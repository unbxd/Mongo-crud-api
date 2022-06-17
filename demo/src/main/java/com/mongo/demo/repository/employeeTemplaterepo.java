package com.mongo.demo.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.mongo.demo.model.EmployeeModel;

@Repository
public class employeeTemplaterepo {
	@Autowired
	MongoTemplate MongoTemplate;
	public List<EmployeeModel> findbySalary(float salary) {
		Query query= new Query(Criteria.where("salary").gte(salary));
		//query.fields().include("salary");
		
		return MongoTemplate.find(query, EmployeeModel.class);
	}

}
