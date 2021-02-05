package dev.ric.services;

import java.util.List;

import dev.ric.models.Employee;
import dev.ric.repositories.EmployeeRepository;
import dev.ric.repositories.EmployeeRepositoryImpl;

public class EmployeeServicesImpl implements EmployeeServices {
	EmployeeRepository erep = new EmployeeRepositoryImpl();
	@Override
	public Employee getEmployee(int id) {
		return erep.getEmployee(id);
		
	}

	@Override
	public boolean addEmployee(Employee a) {
		return erep.addEmployee(a);
	}

	@Override
	public boolean updateEmployee(Employee change) {
		return erep.updateEmployee(change);
	}

	@Override
	public boolean deleteEmployee(int id) {
		return erep.deleteEmployee(id);
	}

	public List<Employee> getAllEmployees(){
		return erep.getAllEmployees();
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		return erep.getEmployeeByEmail(email);
	};
}
