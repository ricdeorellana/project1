package dev.ric.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ric.models.Event;
import dev.ric.utils.JDBCConnection;

public class EventRepositoryImpl implements EventRepository{
	public static Connection conn = JDBCConnection.getConnection();
	
	@Override
	public Event getEvent(int id) {
		try {
			String sql = "SELECT * FROM events WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Event a = new Event();
				a.setId(rs.getInt("EVENT_ID"));
				a.setType(rs.getString("EVENT_TYPE"));

				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> events = new ArrayList<Event>();
		try {
			String sql = "SELECT * FROM events";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Event a = new Event();
				a.setId(rs.getInt("EVENT_ID"));
				a.setType(rs.getString("EVENT_TYPE"));
				events.add(a);
			}

			return events;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
