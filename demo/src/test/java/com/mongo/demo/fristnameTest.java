
package com.mongo.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import java.util.List;
import com.mongo.demo.model.EmployeeModel;
import com.mongo.demo.repository.EmployeeRepository;

@SpringBootTest

class fristnameTest {
	@Autowired
	private EmployeeRepository emprepo;
	
	
	@Test
	void findByFirstname() {
		List<EmployeeModel> actualresult= emprepo.findByFirstname("Punit");
		assertThat(actualresult.size(),not(0));
		
	}
	
	@Test
	void findByFirstnameandsalary() {
		List<EmployeeModel> actualresult= emprepo.findByFirstnameAndSalary("Punit",500);
		assertThat(actualresult.size(),not(0));
		
	}
}
