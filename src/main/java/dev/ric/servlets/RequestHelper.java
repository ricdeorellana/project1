package dev.ric.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ric.controllers.EmployeeController;
import dev.ric.controllers.LoginController;
import dev.ric.controllers.RequestFormController;

public class RequestHelper {
	/**
	 * This method will give work to other methods on the controller layer of my
	 * application to process the requests.
	 * 
	 * @param request  the HTTP request
	 * @param response the HTTP response
	 * @throws IOException
	 * @throws ServletException
	 */
	public static void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
		System.out.println(uri);

		switch (uri) {
		
		case "/Project1/supervisor.do":{
			EmployeeController.getEmpByEmail(request, response);
		}
		case "/Project1/addEmployee.do": {
			EmployeeController.addEmployee(request, response);
			break;
		}
		
		case "/Project1/login.do": {
			LoginController.login(request, response);
			break;
		}
		case "/Project1/logout.do":{
			LoginController.logout(request, response);
			break;
		}
		
		case "/Project1/loggedIn.do": {
			LoginController.loggedIn(request, response);
			break;
		}
		
		case "/Project1/addRequest.do": {
			RequestFormController.addRequest(request, response);
			break;
		}
		case "/Project1/allRequest.do": {
			RequestFormController.getAllRequests(request, response);
			break;
		}
		
		case "/Project1/getRequests.do":{
			RequestFormController.getEmpRequests(request, response);
			break;
		}
		
		case "/Project1/getSuperRequests.do":{
			RequestFormController.getSuperRequests(request, response);
			break;
		}
		case "/Project1/getDeptRequests.do":{
			RequestFormController.getDeptRequests(request, response);
			break;
		}
		case "/Project1/getBencoRequests.do":{
			RequestFormController.getBencoRequests(request, response);
			break;
		}
		case "/Project1/getRequest.do": {
			RequestFormController.getRequest(request, response);
			break;
		}
		case"/Project1/request.do": {
			RequestFormController.request(request, response);
			break;
		}
		
		case"/Project1/updateRequest.do":{
			RequestFormController.updateRequest(request, response);
			break;
		}
		
		case"/Project1/allEmployees.do":{
			EmployeeController.getAllEmployees(request, response);
			break;
		}
		case "/Project1/updateEmp.do":{
			EmployeeController.updateEmployee(request, response);
			break;
		}
		
		
		
		
		default: {
			response.sendError(418, "You are not going anywhere child!");
			break;
		}
		}
	}
}
