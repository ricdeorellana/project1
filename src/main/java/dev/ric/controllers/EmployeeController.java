package dev.ric.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dev.ric.models.Employee;
import dev.ric.services.EmployeeServices;
import dev.ric.services.EmployeeServicesImpl;

public class EmployeeController {
	/*
	 * Read any necessary information from the request Call the appropriate services
	 * Prepare our data to be added to the response Add said data into the response
	 * body
	 * 
	 * 
	 * Processing request Generating response
	 */

	public static EmployeeServices as = new EmployeeServicesImpl();

	public static Gson gson = new Gson();

	public static void getEmployee(HttpServletRequest request, HttpServletResponse response)
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

		Employee a = as.getEmployee(id);
		response.getWriter().append((a != null) ? gson.toJson(a) : gson.toJson("{}"));
	}

	public static void getAllEmployees(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		List<Employee> employees = as.getAllEmployees();
		System.out.println("Retrieving All Employees");
		response.getWriter().append(gson.toJson(employees));

	}

	public static void addEmployee(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		/*
		 * This time we are going to need to make a POST Request POST requests are for
		 * creating (adding) data to your Database
		 * 
		 * What's going to change is that you don't pass around data you plan to add via
		 * parameters.
		 * 
		 * Instead, any non-GET Request has access to a Request Body.
		 */

		// GSON will convert a JSON passed into the Request Body
		// into an Object for your choosing.

		Employee a = gson.fromJson(request.getReader(), Employee.class);

		// Call the appropriate service
		as.addEmployee(a);

		// Most common practice is to send back the added object
		// Just in case the Client wants to use it again

		response.getWriter().append(gson.toJson(a));

	}

	public static void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		Employee a = gson.fromJson(request.getReader(), Employee.class);

		as.deleteEmployee(a.getId());

		response.getWriter().append('k');
	}

	public static void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		Employee a = gson.fromJson(request.getReader(), Employee.class);

		as.updateEmployee(a);
		System.out.println("Updating Employee Super");
		response.getWriter().append('k');
	}

	public static void getEmpByEmail(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		try {
			// Setting login to Employee Object
			Employee a = gson.fromJson(request.getReader(), Employee.class);

			if (as.getEmployeeByEmail(a.getEmail()) != null) {
				Employee b = as.getEmployeeByEmail(a.getEmail());
				response.getWriter().append(gson.toJson(b));
			} else {
				System.out.println("Wrong Supervisor Email");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
