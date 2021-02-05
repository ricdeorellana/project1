package dev.ric.services;

import java.util.ArrayList;
import java.util.List;

import dev.ric.models.Employee;
import dev.ric.models.Request;
import dev.ric.repositories.EmployeeRepository;
import dev.ric.repositories.EmployeeRepositoryImpl;
import dev.ric.repositories.RequestRepositoryImpl;

public class RequestServicesImpl {
	public static RequestRepositoryImpl rerep = new RequestRepositoryImpl();
	public static EmployeeRepository erep = new EmployeeRepositoryImpl();

	public List<Request> getEmpRequests(int id) {
		return rerep.getRequestsByEmp(id);
	}

	public Request getRequest(int id) {
		return rerep.getRequestById(id);
	}

	public List<Request> getAllRequests() {
		return rerep.getAllRequests();
	}

	public boolean addRequest(Request a) {
		Employee b = erep.getEmployee(a.getEmpId());
		switch (a.getEventId()) {
		case 1:
			a.setCost(a.getCost() * .80);
			break;
		case 2:
			a.setCost(a.getCost() * .60);
			break;
		case 3:
			a.setCost(a.getCost() * .75);

			break;
		case 4:
			a.setCost(a.getCost() * 1);

			break;
		case 5:
			a.setCost(a.getCost() * .90);

			break;
		case 6:
			a.setCost(a.getCost() * .30);

			break;
		}

		if (b.getFunds() >= a.getCost()) {

			double finBal = b.getFunds() - a.getCost();
			b.setFunds(finBal);
			erep.updateEmployee(b);
		}
		return rerep.addRequest(a);
	}

	public boolean updateRequest(Request change) {

		return rerep.updateRequest(change);
	}

//The following method will return a list of requests for supervisor
	public List<Request> getRequestsForSuper(int id) {
		List<Employee> employees = erep.getEmployeesBySuper(id);
		List<Integer> empIds = new ArrayList<Integer>();

		int a = employees.size();
		// Goes through list of employees and gets Ids
		System.out.println("List of Employees: " + employees);
		for (int b = 0; b < a; b++) {
			empIds.add(employees.get(b).getId());
		}
		List<List<Request>> requests = new ArrayList<List<Request>>();

		// Adds to list requests searched by empIds
		for (int c = 0; c < empIds.size(); c++) {

			requests.add(rerep.getRequestsByEmp(empIds.get(c)));

		}

		System.out.println("List of Employees Requests: " + requests);
		List<Request> finRequests = new ArrayList<Request>();
		// Turn List of List into list
//		List<List<String>> list;
		for (List<Request> l : requests) {
			for (Request s : l) {
				if (s.getGrade() == 7) {
					finRequests.add(s);
				}
			}
		}

		System.out.println(finRequests);

		return finRequests;
	}

	// The following method will return a list of requests for supervisor
	public List<Request> getRequestsForDept(int id) {
		List<Employee> employees = erep.getEmployeesByDept(id);
		List<Integer> empIds = new ArrayList<Integer>();

		int a = employees.size();
		// Goes through list of employees and gets Ids
		System.out.println("List of Employees: " + employees);
		for (int b = 0; b < a; b++) {
			// This checks whether emp dept is same as dept head
			if (employees.get(b).getDepartmentId() == id) {
				empIds.add(employees.get(b).getId());
			}
		}
		List<List<Request>> requests = new ArrayList<List<Request>>();

		// Adds to list requests searched by empIds
		for (int c = 0; c < empIds.size(); c++) {

			requests.add(rerep.getRequestsByEmp(empIds.get(c)));

		}

		System.out.println("List of Dept Employees Requests: " + requests);
		List<Request> finRequests = new ArrayList<Request>();
		// Turn List of List into list
//			List<List<String>> list;
		for (List<Request> l : requests) {
			for (Request s : l) {
				// This checks whether emp has been approved by super
				if (s.getGrade() == 8) {
					finRequests.add(s);
				}
			}
		}

		System.out.println(finRequests);

		return finRequests;
	}

	public List<Request> getRequestsForBenco() {

		return rerep.getRequestByGrade();
	}

}
