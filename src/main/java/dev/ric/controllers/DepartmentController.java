package dev.ric.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dev.ric.models.Department;
import dev.ric.services.DepartmentServices;
import dev.ric.services.DepartmentServicesImpl;

public class DepartmentController {

	public static DepartmentServices ds = new DepartmentServicesImpl();

	public static Gson gson = new Gson();

	public static void getDepartment(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		String param = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(param);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrect");
			return;
		}

		Department a = ds.getDepartment(id);
		response.getWriter().append((a != null) ? gson.toJson(a) : gson.toJson("{}"));
	};

	public static void addDepartment(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		
		Department department = gson.fromJson(request.getReader(), Department.class);
		
	
		
		ds.addDepartment(department);

		response.getWriter().append(gson.toJson(department));
	};

	public static void getAllDepartments(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
	List<Department> departments = ds.getAllDepartments();
		
		response.getWriter().append(gson.toJson(departments));
	};

}
