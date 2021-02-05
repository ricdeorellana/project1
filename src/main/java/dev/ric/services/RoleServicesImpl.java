package dev.ric.services;

import java.util.List;

import dev.ric.models.Role;
import dev.ric.repositories.RoleRepositoryImpl;

public class RoleServicesImpl {
public static RoleRepositoryImpl rrep = new RoleRepositoryImpl();

public Role getRole(int id) {
	return rrep.getRole(id);
}

public List<Role> getAllRoles(){
	return rrep.getAllRoles();
}
}
