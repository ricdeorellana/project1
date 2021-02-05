package dev.ric.services;

import java.util.List;

import dev.ric.models.Employee;

public interface EmployeeServices {
public Employee getEmployee(int id);
public boolean addEmployee(Employee a);
public List<Employee> getAllEmployees();
public boolean updateEmployee(Employee change);
public boolean deleteEmployee(int id);
public Employee getEmployeeByEmail(String email);


}
