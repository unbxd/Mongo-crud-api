package com.mongo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.demo.model.EmployeeModel;
import com.mongo.demo.repository.employeeTemplaterepo;

@Service
public class employeeTemplateservices {
	@Autowired
	employeeTemplaterepo employeeRepository;
	
	public List<EmployeeModel> getbysalary(float salary) {
		// TODO Auto-generated method stub
		return employeeRepository.findbySalary(salary);
	}


}
