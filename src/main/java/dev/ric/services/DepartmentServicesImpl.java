package dev.ric.services;

import java.util.List;

import dev.ric.models.Department;
import dev.ric.repositories.DepartmentRepository;
import dev.ric.repositories.DepartmentRepositoryImpl;

public class DepartmentServicesImpl implements DepartmentServices{
	private static DepartmentRepository drep = new DepartmentRepositoryImpl();
	@Override
	public Department getDepartment(int id) {
		return drep.getDepartment(id);
	}

	@Override
	public boolean addDepartment(Department a) {
		return drep.addDepartment(a);
	}

	@Override
	public List<Department> getAllDepartments() {
		return drep.getAllDepartments();
	}

}
