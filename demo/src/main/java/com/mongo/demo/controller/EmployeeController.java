package com.mongo.demo.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mongo.demo.model.EmployeeModel;
import com.mongo.demo.services.EmployeeServices;
import com.mongo.demo.services.employeeTemplateservices;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeServices employeeservices;
	@Autowired
	employeeTemplateservices employeeservice;
	//inserting records into db
	@PostMapping("/getdetails")
	public EmployeeModel save(@RequestBody EmployeeModel emp) {
		
		//validate request 
		if (emp.getFirstname() ==null || emp.getAddresses() ==null || emp.getLastname() ==null|| emp.getSalary()==0) 
		{
			System.out.println("paramrequest is missing");
			throw new badrequest("bad request");
			
		}
		try {
			//return saved data
			return employeeservices.save(emp);
		}
		catch(Exception e)
		{
			
			logger.info("internal server error in getdetails====== "+ e);
			throw new intrnalservererror("internal server error");
		}
		
	}
	//getting all records 
	@GetMapping("/showsdetails")
	public List<EmployeeModel> getAll() {
		
		//return all the records 
		List<EmployeeModel> data = employeeservices.getdAll();
		//checking size of matched records
		if (data.size()==0) {
			logger.info("datat not available");
			throw new userNotFound("datat not available");
		}
		else
			
			return data;
			
			}
	//getting matches records of firstname
	@GetMapping("/getbyname")
	public List<EmployeeModel> getbyname(@RequestBody EmployeeModel emp) {
		//checking request
		if(null==emp.getFirstname())
			throw new badrequest("bad request");
		
		List<EmployeeModel> data = employeeservices.getbyname(emp.getFirstname());
		
		System.out.println(data);
		//checking size of matched records
		if (data.size()==0) {
			logger.info("name  not foud");
			throw new userNotFound("data not found");
			
			}		
		else
			
			return data;
		}
	// getting records according to page 
	@GetMapping("/allWithPagination")
	public List<EmployeeModel> getAllWithPagination(@RequestParam int pageNo,
			@RequestParam int pageSize) {
		System.out.println(pageNo);
		
		//get data, according to page nummber and limit
		List<EmployeeModel> data = employeeservices.getAllWithPagination(pageNo, pageSize);
		//checking size of matches records
		if (data.size()==0) {
			logger.info("data of pages  not foud");
			throw new userNotFound("data not available");
			
			}		
		else
			
			return data;
		
	}
	//sorting records
	@GetMapping("/allWithSorting")
	public List<EmployeeModel> allWithSorting() {
		
		List<EmployeeModel> data = employeeservices.allWithSorting();
			
		if (data.size()==0) {
			logger.info("data of sorting  not foud");
			throw new userNotFound("data not available");
			
			}		
		else
			
			return data;
	}
	//getting matches records of firstNname and salary
	@GetMapping("/employeeByNameAndsalary")
	public List<EmployeeModel> employeeByfirstNameAndsalary(@RequestBody EmployeeModel emp) {
		
		if (emp.getFirstname() ==null || emp.getSalary()==0) {
			System.out.println("paramrequest is missing");
			throw new badrequest("bad request");
		}
			
		List<EmployeeModel> data = employeeservices.employeeByfirstNameAndsalary(emp.getFirstname(),emp.getSalary());
		if (data.size()==0) {
			logger.info("name or salary not foud");
			throw new userNotFound("name or salary not matched");
			
			}		
		else
			
			return data;
	}
	//getting matches records wehere salary is greater than given request
	@GetMapping("/salary")
	public List<EmployeeModel> getbysalary(@RequestBody EmployeeModel emp) {
		
		float requestParam = emp.getSalary();
		
		
		System.out.println(requestParam);
		//validating request
		if (0== requestParam) {
			
			throw new badrequest("bad request");
			
		}
		
		List<EmployeeModel> data = employeeservice.getbysalary(emp.getSalary());
		if (data.size()==0) {
			logger.info("salary not foud");
			throw new userNotFound("data not found");
			
			}		
		else
			
			return data;
	}
	//update matches records
	@PutMapping("/update")
	public EmployeeModel updateStudent(@RequestBody EmployeeModel emp) {
		
			System.out.println(emp.getFirstname());
			//validating request
			if (emp.getFirstname() ==null) 
			{
				System.out.println("paramrequest is missing");
				throw new badrequest("bad request");
				
			}
		try
		{
		//get updated records
		return employeeservices.updateEmployee(emp);
		}
		catch(Exception e)
		{
			logger.info("internal server error====== "+ e);
			throw new intrnalservererror("internal server error");
			
			
		}
	}
	//delete matches records
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		try {
		//delete matches id
		return employeeservices.deleteEmployee(id);
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("internal server error====== "+ e);
			throw new intrnalservererror("internal server error");
		}
	}
	 
}
