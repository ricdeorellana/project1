package dev.ric.models;

public class Employee {
private int id;
private String fName;
private String lName;
private String email;
private String password;
private int supervisorId;
private int departmentId;
private double funds;
private int role;

public Employee() {
	super();
}



public Employee(String fName, String lName, String email, String password) {
	super();
	this.fName = fName;
	this.lName = lName;
	this.email = email;
	this.password = password;
}




public Employee(int id, String fName, String lName, String email, String password, int role) {
	super();
	this.id = id;
	this.fName = fName;
	this.lName = lName;
	this.email = email;
	this.password = password;
	this.role = role;
}



public Employee(int id, String fName, String lName, String email, String password, int supervisorId, int departmentId,
		int funds, int role) {
	super();
	this.id = id;
	this.fName = fName;
	this.lName = lName;
	this.email = email;
	this.password = password;
	this.supervisorId = supervisorId;
	this.departmentId = departmentId;
	this.funds = funds;
	this.role = role;
}







public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getSupervisorId() {
	return supervisorId;
}
public void setSupervisorId(int supervisorId) {
	this.supervisorId = supervisorId;
}
public int getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(int departmentId) {
	this.departmentId = departmentId;
}
public double getFunds() {
	return funds;
}
public void setFunds(double funds) {
	this.funds = funds;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}



@Override
public String toString() {
	return "Employees [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", password="
			+ password + ", supervisorId=" + supervisorId + ", departmentId=" + departmentId + ", funds=" + funds
			+ ", role=" + role + "]";
}



}
