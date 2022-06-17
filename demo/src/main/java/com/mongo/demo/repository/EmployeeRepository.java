package com.mongo.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.mongo.demo.model.EmployeeModel;
@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeModel, String>{
	List<EmployeeModel> findByFirstname(String name);
	List<EmployeeModel> findByFirstnameAndSalary (String name, float salary);
	List<EmployeeModel> findByFirstnameLike (String name);
	List<EmployeeModel> findByFirstnameStartsWith (String name);
	
	
}
