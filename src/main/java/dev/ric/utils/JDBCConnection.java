package dev.ric.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConnection {
	

	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		try {
			if(conn == null) {
				//make a new connection
				
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				
				Properties props = new Properties();
				FileInputStream input = new FileInputStream(JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile());
				
				props.load(input);
				
				String url = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
				
				//Establish our connection
				conn = DriverManager.getConnection(url, username, password);
				return conn;
			}
			else {
				//return the connection that already exists
				return conn;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * This is for testing purposes, not needed to use JDBC
	 */
	
	public static void main(String[] args) {
		Connection conn1 = getConnection();
		
		System.out.println(conn1);
	}
}