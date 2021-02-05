package dev.ric.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ric.models.Department;
import dev.ric.utils.JDBCConnection;

public class DepartmentRepositoryImpl implements DepartmentRepository {

	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public Department getDepartment(int id) {
		try {
			String sql = "SELECT * FROM departments WHERE department_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Department a = new Department();
				a.setId(rs.getInt("DEPARTMENT_ID"));
				a.setName(rs.getString("DEPARTMENT_NAME"));

				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addDepartment(Department a) {
		try {
			// Java is unaware of our sequences, so
			// its better or easier if we just use our procedure
			// that abstracted our sequence

			String sql = "CALL add_dep(?)";
			CallableStatement cs = conn.prepareCall(sql); // THIS IS USED TO CALL PROCEDURES
			cs.setString(1, a.getName());

			cs.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<Department>();

		try {
			String sql = "SELECT * FROM departments";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Department a = new Department();
				a.setId(rs.getInt("DEPARTMENT_ID"));
				a.setName(rs.getString("DEPARTMENT_NAME"));
				departments.add(a);
			}

			return departments;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
