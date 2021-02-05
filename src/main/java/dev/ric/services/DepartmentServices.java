package dev.ric.services;

import java.util.List;

import dev.ric.models.Department;

public interface DepartmentServices {
	public Department getDepartment(int id);
	public boolean addDepartment(Department a);
	public List<Department> getAllDepartments();
}
