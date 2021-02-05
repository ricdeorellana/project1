package dev.ric.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ric.models.Grade;
import dev.ric.utils.JDBCConnection;

public class GradeRepositoryImpl {
	public static Connection conn = JDBCConnection.getConnection();

	public Grade getGrade(int id) {
		try {
			String sql = "SELECT * FROM grades WHERE grade_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Grade a = new Grade();
				a.setId(rs.getInt("GRADE_ID"));
				a.setType(rs.getString("GRADE_TYPE"));
				a.setValue(rs.getInt("GRADE_VALUE"));
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Grade> getAllGrades() {
		
		List<Grade> grades = new ArrayList<Grade>();
		try {
			String sql = "SELECT * FROM grades";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Grade a = new Grade();
				a.setId(rs.getInt("GRADE_ID"));
				a.setType(rs.getString("GRADE_TYPE"));
				a.setValue(rs.getInt("GRADE_VALUE"));
				grades.add(a);
			}

			return grades;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
