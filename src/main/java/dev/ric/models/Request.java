package dev.ric.models;

public class Request {
	private int id;
	private int empId;
	private String fullName;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private String date;
	private String time;
	private String location;
	private String description;
	private double cost;
	private int eventId;
	private int grade;
	private String justification;

	public Request() {
		super();
	}

	public Request(int id, int empId, String date, String time, String location, String description, int cost,
			int eventId, String justification) {
		super();
		this.id = id;
		this.empId = empId;
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.eventId = eventId;
		this.justification = justification;
	}

	public Request(int id, int empId, String date, String time, String location, String description, int cost,
			int eventId, int grade, String justification) {
		super();
		this.id = id;
		this.empId = empId;
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.eventId = eventId;
		this.grade = grade;
		this.justification = justification;
	}

	public Request(int id, int empId, int cost) {
		super();
		this.id = id;
		this.empId = empId;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", empId=" + empId + ", fullName=" + fullName + ", date=" + date + ", time=" + time
				+ ", location=" + location + ", description=" + description + ", cost=" + cost + ", eventId=" + eventId
				+ ", grade=" + grade + ", justification=" + justification + "]";
	}

}
