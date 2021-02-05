package dev.ric.repositories;

import java.util.List;

import dev.ric.models.Department;

public interface DepartmentRepository {
public Department getDepartment(int id);
public boolean addDepartment(Department a);
public List<Department> getAllDepartments();
}
