package dev.ric.repositories;

import java.util.List;

import dev.ric.models.Employee;

public interface EmployeeRepository {
		
		public Employee getEmployeeByEmail(String email);
		public Employee getEmployee(int id);
		public boolean addEmployee(Employee a);
		public List<Employee> getAllEmployees();
		public boolean updateEmployee(Employee change);
		public boolean deleteEmployee(int id);
		public List<Employee> getEmployeesBySuper(int id);
		public List<Employee> getEmployeesByDept(int id);
	
}
