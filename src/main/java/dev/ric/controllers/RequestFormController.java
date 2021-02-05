package dev.ric.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dev.ric.models.Employee;
import dev.ric.models.Request;
import dev.ric.services.EmployeeServices;
import dev.ric.services.EmployeeServicesImpl;
import dev.ric.services.RequestServicesImpl;

public class RequestFormController {

	public static RequestServicesImpl reser = new RequestServicesImpl();
	public static Gson gson = new Gson();
	public static EmployeeServices eser = new EmployeeServicesImpl();

	public static HttpSession sesh;

	public static void addRequest(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		System.out.println("Turning json to request object");

		Request a = gson.fromJson(request.getReader(), Request.class);

		// Call the appropriate service
		reser.addRequest(a);
		System.out.println("Succesfully added request");

		// Most common practice is to send back the added object
		// Just in case the Client wants to use it again

		response.getWriter().append(gson.toJson(a));
		System.out.println("Updating Session");
		LoginController.updateSess();

	}

	public static void getAllRequests(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		List<Request> l = reser.getAllRequests();
		System.out.println("Sending all requests");
		response.getWriter().append(gson.toJson(l));

	}

	public static void getEmpRequests(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		String parameter = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(parameter);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrect");
			return;
		}

		List<Request> l = reser.getEmpRequests(id);

		System.out.println("Sending all requests");
		response.getWriter().append(gson.toJson(l));

	}

	public static void getRequest(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		String parameter = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(parameter);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrect");
			return;
		}

		Request l = reser.getRequest(id);
		sesh = request.getSession();
		sesh.setAttribute("Request", l);

		System.out.println("Sending single request");
		response.getWriter().append(gson.toJson(sesh.getAttribute("Request")));

	}

	public static void request(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		System.out.println("Reached Request");
		response.getWriter().append(gson.toJson(sesh.getAttribute("Request")));
	}

	public static void getSuperRequests(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		String parameter = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(parameter);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrect");
			return;
		}

		List<Request> l = reser.getRequestsForSuper(id);
		System.out.println("Sending all Super requests: " + l);
		response.getWriter().append(gson.toJson(l));
	}

	public static void getDeptRequests(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		String parameter = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(parameter);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrect");
			return;
		}

		List<Request> l = reser.getRequestsForDept(id);
		System.out.println("Sending all Dept requests: " + l);
		response.getWriter().append(gson.toJson(l));
	}

	public static void getBencoRequests(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		List<Request> l = reser.getRequestsForBenco();
		System.out.println("Sending all Benco requests: " + l);
		response.getWriter().append(gson.toJson(l));
	}

	public static void updateRequest(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		
		Request a = gson.fromJson(request.getReader(), Request.class);
		System.out.println("Updating Request");
		
		if(a.getGrade() == 11 | a.getGrade() ==4 | a.getGrade() == 6) {
			System.out.println("Returning Funds Back");
			double balance = a.getCost();
			Employee b = eser.getEmployee(a.getEmpId());
			b.setFunds(b.getFunds() + balance);
			eser.updateEmployee(b);
		
		}
		reser.updateRequest(a);
		
		response.getWriter().append(gson.toJson(a));
		
	}

}
