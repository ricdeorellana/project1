package dev.ric.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ric.models.Employee;
import dev.ric.utils.JDBCConnection;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public Employee getEmployee(int id) {
		try {
			String sql = "SELECT * FROM employees WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee a = new Employee();
				a.setId(rs.getInt("ID"));
				a.setfName(rs.getString("F_NAME"));
				a.setlName(rs.getString("L_NAME"));
				a.setEmail(rs.getString("EMAIL"));
				a.setPassword(rs.getString("PASSWORD"));
				a.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				a.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				a.setFunds(rs.getInt("FUNDS"));
				a.setRole(rs.getInt("EMP_ROLE"));

				return a;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addEmployee(Employee a) {
		try {
			// Java is unaware of our sequences, so
			// its better or easier if we just use our procedure
			// that abstracted our sequence

			String sql = "CALL add_emp(?,?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql); // THIS IS USED TO CALL PROCEDURES
			cs.setString(1, a.getfName());
			cs.setString(2, a.getlName());
			cs.setString(3, a.getEmail());
			cs.setString(4, a.getPassword());
			cs.setString(5, Integer.toString(a.getSupervisorId()));
			cs.setString(6, Integer.toString(a.getDepartmentId()));
			cs.setString(7, Integer.toString(a.getRole()));

			cs.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		try {
			String sql = "SELECT * FROM employees";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee a = new Employee();
				a.setId(rs.getInt("ID"));
				a.setfName(rs.getString("F_NAME"));
				a.setlName(rs.getString("L_NAME"));
				a.setEmail(rs.getString("EMAIL"));
				a.setPassword(rs.getString("PASSWORD"));
				a.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				a.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				a.setFunds(rs.getInt("FUNDS"));
				a.setRole(rs.getInt("EMP_ROLE"));
				employees.add(a);
			}

			return employees;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateEmployee(Employee change) {
		try {
			String sql = "UPDATE employees SET f_name = ?, l_name = ?, email = ?, password = ?, supervisor_id = ?, department_id = ?, funds = ? WHERE ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, change.getfName());
			ps.setString(2, change.getlName());
			ps.setString(3, change.getEmail());
			ps.setString(4, change.getPassword());
			ps.setString(5, Integer.toString(change.getSupervisorId()));
			ps.setString(6, Integer.toString(change.getDepartmentId()));
			ps.setString(7, Double.toString(change.getFunds()));
			System.out.println("New Funds: " + change.getFunds());
			ps.setString(8, Integer.toString(change.getId()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		try {
			String sql = "DELETE employees WHERE ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ps.executeQuery();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		try {
			String sql = "SELECT * FROM employees WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee a = new Employee();
				a.setId(rs.getInt("ID"));
				a.setfName(rs.getString("F_NAME"));
				a.setlName(rs.getString("L_NAME"));
				a.setEmail(rs.getString("EMAIL"));
				a.setPassword(rs.getString("PASSWORD"));
				a.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				a.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				a.setFunds(rs.getInt("FUNDS"));
				a.setRole(rs.getInt("EMP_ROLE"));

				return a;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getEmployeesBySuper(int id) {
		List<Employee> employees = new ArrayList<Employee>();

		try {
			String sql = "SELECT * FROM employees WHERE supervisor_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee a = new Employee();
				a.setId(rs.getInt("ID"));
				a.setfName(rs.getString("F_NAME"));
				a.setlName(rs.getString("L_NAME"));
				a.setEmail(rs.getString("EMAIL"));
				a.setPassword(rs.getString("PASSWORD"));
				a.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				a.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				a.setFunds(rs.getInt("FUNDS"));
				a.setRole(rs.getInt("EMP_ROLE"));
				employees.add(a);
			}

			return employees;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> getEmployeesByDept(int id) {
		List<Employee> employees = new ArrayList<Employee>();

		try {
			String sql = "SELECT * FROM employees WHERE department_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee a = new Employee();
				a.setId(rs.getInt("ID"));
				a.setfName(rs.getString("F_NAME"));
				a.setlName(rs.getString("L_NAME"));
				a.setEmail(rs.getString("EMAIL"));
				a.setPassword(rs.getString("PASSWORD"));
				a.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				a.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				a.setFunds(rs.getInt("FUNDS"));
				a.setRole(rs.getInt("EMP_ROLE"));
				employees.add(a);
			}

			return employees;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
