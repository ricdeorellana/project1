package dev.ric.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ric.models.Role;
import dev.ric.utils.JDBCConnection;


public class RoleRepositoryImpl {

	public static Connection conn = JDBCConnection.getConnection();

	public Role getRole(int id) {

		try {
			String sql = "SELECT * FROM emp_roles WHERE role_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Role a = new Role();
				a.setId(rs.getInt("ROLE_ID"));
				a.setName(rs.getString("ROLE_NAME"));

				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Role> getAllRoles() {
		List<Role> roles = new ArrayList<Role>();
		try {
			String sql = "SELECT * FROM emp_roles";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Role a = new Role();
				a.setId(rs.getInt("ROLE_ID"));
				a.setName(rs.getString("ROLE_NAME"));
				roles.add(a);
			}

			return roles;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
