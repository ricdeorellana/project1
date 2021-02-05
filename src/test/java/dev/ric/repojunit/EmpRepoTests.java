package dev.ric.repojunit;



import org.junit.Test;

import dev.ric.models.Employee;
import dev.ric.repositories.EmployeeRepository;
import dev.ric.repositories.EmployeeRepositoryImpl;

public class EmpRepoTests {
	private static EmployeeRepository emp = new EmployeeRepositoryImpl();

	@Test
	public void test() {
		Employee a = emp.getEmployee(3);
		System.out.println(a);
	}
	
	@Test
	public void updateTest() {
		Employee a = emp.getEmployee(51);
		a.setFunds(1000);
		emp.updateEmployee(a);
		
	}

}
