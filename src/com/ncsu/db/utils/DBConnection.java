package com.ncsu.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String jdbcURL = "jdbc:oracle:thin:@ora.csc.ncsu.edu:1523:orcl";
	private static final String username = "arvaidya";
	private static final String password = "001087821";

	private static Connection conn;

	private DBConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbcURL, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		if(conn == null) {
			new DBConnection();
		}		
		return conn;
	}
}