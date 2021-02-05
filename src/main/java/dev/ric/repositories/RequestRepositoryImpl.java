package dev.ric.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ric.models.Request;
import dev.ric.utils.JDBCConnection;

public class RequestRepositoryImpl {
	public static Connection conn = JDBCConnection.getConnection();

	public List<Request> getRequestsByEmp(int id) {
		List<Request> requests = new ArrayList<Request>();

		try {
			String sql = "SELECT * FROM request_form WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Request a = new Request();
				a.setId(rs.getInt("request_id"));
				a.setEmpId(rs.getInt("emp_id"));
				a.setFullName(rs.getString("fullname"));
				a.setDate(rs.getString("event_date"));
				a.setTime(rs.getString("event_time"));
				a.setLocation(rs.getString("event_location"));
				a.setDescription(rs.getString("event_desc"));
				a.setCost(rs.getInt("event_cost"));
				a.setEventId(rs.getInt("event_id"));
				a.setGrade(rs.getInt("grade_id"));
				a.setJustification(rs.getString("justification"));
				requests.add(a);
			}

			return requests;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Request getRequestById(int id) {
		try {
			String sql = "SELECT * FROM request_form WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Request a = new Request();
				a.setId(rs.getInt("request_id"));
				a.setEmpId(rs.getInt("emp_id"));
				a.setFullName(rs.getString("fullname"));
				a.setDate(rs.getString("event_date"));
				a.setTime(rs.getString("event_time"));
				a.setLocation(rs.getString("event_location"));
				a.setDescription(rs.getString("event_desc"));
				a.setCost(rs.getInt("event_cost"));
				a.setEventId(rs.getInt("event_id"));
				a.setGrade(rs.getInt("grade_id"));
				a.setJustification(rs.getString("justification"));

				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Request> getRequestByGrade() {
		List<Request> requests = new ArrayList<Request>();

		try {
			String sql = "SELECT * FROM request_form WHERE grade_id = 9";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Request a = new Request();
				a.setId(rs.getInt("request_id"));
				a.setEmpId(rs.getInt("emp_id"));
				a.setFullName(rs.getString("fullname"));
				a.setDate(rs.getString("event_date"));
				a.setTime(rs.getString("event_time"));
				a.setLocation(rs.getString("event_location"));
				a.setDescription(rs.getString("event_desc"));
				a.setCost(rs.getInt("event_cost"));
				a.setEventId(rs.getInt("event_id"));
				a.setGrade(rs.getInt("grade_id"));
				a.setJustification(rs.getString("justification"));
				requests.add(a);
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Request> getAllRequests() {
		List<Request> requests = new ArrayList<Request>();

		try {
			String sql = "SELECT * FROM request_form";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Request a = new Request();
				a.setId(rs.getInt("request_id"));
				a.setEmpId(rs.getInt("emp_id"));
				a.setFullName(rs.getString("fullname"));
				a.setDate(rs.getString("event_date"));
				a.setTime(rs.getString("event_time"));
				a.setLocation(rs.getString("event_location"));
				a.setDescription(rs.getString("event_desc"));
				a.setCost(rs.getInt("event_cost"));
				a.setEventId(rs.getInt("event_id"));
				a.setGrade(rs.getInt("grade_id"));
				a.setJustification(rs.getString("justification"));
				requests.add(a);
			}

			return requests;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean addRequest(Request a) {
		try {
			// Java is unaware of our sequences, so
			// its better or easier if we just use our procedure
			// that abstracted our sequence

			String sql = "CALL add_req(?,?,?,?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql); // THIS IS USED TO CALL PROCEDURES
			cs.setString(1, Integer.toString(a.getEmpId()));
			cs.setString(2, a.getFullName());
			cs.setString(3, a.getDate());
			cs.setString(4, a.getTime());
			cs.setString(5, a.getLocation());
			cs.setString(6, a.getDescription());
			cs.setString(7, Double.toString(a.getCost()));
			cs.setString(8, Integer.toString(a.getEventId()));
			cs.setString(9, a.getJustification());

			cs.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateRequest(Request change) {
		
		try {
			String sql = "UPDATE REQUEST_FORM SET EMP_ID = ?, EVENT_DATE = ?, EVENT_TIME = ?, EVENT_LOCATION = ?, EVENT_DESC = ?, EVENT_COST = ?, EVENT_ID = ?, GRADE_ID = ?, JUSTIFICATION = ? WHERE REQUEST_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(change.getEmpId()));
			ps.setString(2, change.getDate());
			ps.setString(3, change.getTime());
			ps.setString(4, change.getLocation());
			ps.setString(5, change.getDescription());
			ps.setString(6, Double.toString(change.getCost()));
			ps.setString(7, Integer.toString(change.getEventId()));
			ps.setString(8, Integer.toString(change.getGrade()));
			ps.setString(9, change.getJustification());
			ps.setString(10, Integer.toString(change.getId()));
			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
