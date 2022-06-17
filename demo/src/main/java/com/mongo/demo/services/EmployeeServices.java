package com.mongo.demo.services;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mongo.demo.controller.intrnalservererror;
import com.mongo.demo.model.EmployeeModel;
import com.mongo.demo.repository.EmployeeRepository;

@Service
public class EmployeeServices {
	Logger logger = LoggerFactory.getLogger(EmployeeServices .class);
	@Autowired
	EmployeeRepository employeeRepository;
	
    
		public EmployeeModel save(EmployeeModel emp) {
			emp.setDate(new Date());
			try {
			return employeeRepository.save(emp);
			
		}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.info("internal server error====== "+ e);
				throw new intrnalservererror("internal server error");
			}
	}
	//return all data getting from employee Repository
	public List<EmployeeModel> getdAll() {
		// TODO Auto-generated method stub
		try
		{
			return employeeRepository.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("internal server error====== "+ e);
			throw new intrnalservererror("internal server error");
		}
	}

	public List<EmployeeModel> getbyname(String firstname) {
		// TODO Auto-generated method stub
		try
		{
			return employeeRepository.findByFirstname(firstname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("internal server error====== "+ e);
			throw new intrnalservererror("internal server error");
		}
	}

	
	public List<EmployeeModel> getAllWithPagination (int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		try {
			
		return employeeRepository.findAll(pageable).getContent();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("internal server error====== "+ e);
			throw new intrnalservererror("internal server error");
		}
	}
	
	public List<EmployeeModel> allWithSorting () {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstnamename");
		try
		{
			return employeeRepository.findAll(sort);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("internal server error====== "+ e);
			throw new intrnalservererror("internal server error");
		}
	}

	public EmployeeModel updateEmployee (EmployeeModel emp) {
		try
		{
		return employeeRepository.save(emp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("internal server error====== "+ e);
			throw new intrnalservererror("internal server error");
		}
	}

	public String deleteEmployee(String id) {
		employeeRepository.deleteById(id);
		logger.info("id deleted=====> "+ id);
		try {
		return "Employee has been deleted.";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("internal server error====== "+ e);
			throw new intrnalservererror("internal server error");
		}
	}

	public List<EmployeeModel> employeeByfirstNameAndsalary(String firstname, float salary) {
		// TODO Auto-generated method stub
		try {
		return employeeRepository.findByFirstnameAndSalary (firstname,salary);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("internal server error====== "+ e);
			throw new intrnalservererror("internal server error");
		}
	}

	
	
}
