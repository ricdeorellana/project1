package dev.ric.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dev.ric.models.Employee;
import dev.ric.services.EmployeeServices;
import dev.ric.services.EmployeeServicesImpl;

public class LoginController {
	public static EmployeeServices as = new EmployeeServicesImpl();
	public static Gson gson = new Gson();

	public static HttpSession sess;

	public static void login(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		try {
			// Setting login to Employee Object
			String c = null;
			Employee a = gson.fromJson(request.getReader(), Employee.class);

			if (as.getEmployeeByEmail(a.getEmail()) != null) {
				Employee b = as.getEmployeeByEmail(a.getEmail());
				// This logins
				if (a.getPassword().equals(b.getPassword())) {
					System.out.println("Success");
					sess = request.getSession();

					sess.setAttribute("User", b);

					response.getWriter().append(gson.toJson(sess.getAttribute("User")));
				} else {
					
					System.out.println("Password Fail");
					response.getWriter().append(c);
				}
			}

			else {
				System.out.println("Invalid Email");
				response.getWriter().append(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void logout(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		sess.invalidate();
		
		response.getWriter().append(gson.toJson(sess));
		
	}

	public static void loggedIn(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		System.out.println("Reached LoggedIn");
		response.getWriter().append(gson.toJson(sess.getAttribute("User")));
	}
	
	public static void updateSess() {
	Employee a = (Employee) sess.getAttribute("User");	
	Employee b = as.getEmployee(a.getId());
	sess.setAttribute("User", b);
	}

}
