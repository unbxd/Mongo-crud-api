package com.mongo.demo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mongo.demo.model.EmployeeModel;
import com.mongo.demo.repository.employeeTemplaterepo;
import com.mongo.demo.services.EmployeeServices;
@SpringBootTest
public class salarytest {
	@Autowired
	private employeeTemplaterepo emp;
	@Test
	void findbySalary() {
		List<EmployeeModel> actualresult= emp.findbySalary(576);
		assertThat(actualresult.size(),not(0));
		
	}
	@Autowired
	private EmployeeServices empserv;
	@Test
	void testpagination() {
		List<EmployeeModel> actualresult= empserv.getAllWithPagination(1,8);
		assertThat(actualresult.size(),not(0));
		
	}
	@Test
	void testgetall() {
		List<EmployeeModel> actualresult= empserv.getdAll();
		assertThat(actualresult.size(),not(0));
		
	}
}
