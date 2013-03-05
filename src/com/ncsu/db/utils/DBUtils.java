package com.ncsu.db.utils;

import java.sql.*;

import com.ncsu.db.sql.DBSchema;

public class DBUtils {

	static final String jdbcURL = "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl";

	public static void main(String[] args) {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String user = "arvaidya";	
			String passwd = "001087821";

			Connection conn = null;
			Statement stmt = null;

			try {

				conn = DriverManager.getConnection(jdbcURL, user, passwd);

				stmt = conn.createStatement();
				
				System.out.println(DBSchema.createQuestions);
				
				stmt.executeUpdate(DBSchema.dropAnswers);
				stmt.executeUpdate(DBSchema.dropQuestions);
				stmt.executeUpdate(DBSchema.dropExercises);
				stmt.executeUpdate(DBSchema.dropCourseTA);
				stmt.executeUpdate(DBSchema.dropEnrollments);
				stmt.executeUpdate(DBSchema.dropTopic);
				stmt.executeUpdate(DBSchema.dropCourses);
				stmt.executeUpdate(DBSchema.dropGUsers);

				stmt.executeUpdate(DBSchema.createGUsers);
				stmt.executeUpdate(DBSchema.createCourses);
				stmt.executeUpdate(DBSchema.createTopics);
				stmt.executeUpdate(DBSchema.createEnrollment);
				stmt.executeUpdate(DBSchema.createCourseTA);
				stmt.executeUpdate(DBSchema.createExercises);
				stmt.executeUpdate(DBSchema.createQuestions);
				stmt.executeUpdate(DBSchema.createAnswers);

			} finally {
				close(stmt);
				close(conn);
			}
		} catch(Throwable oops) {
			oops.printStackTrace();
		}
	}

	static void close(Connection conn) {
		if(conn != null) {
			try { conn.close(); } catch(Throwable whatever) {}
		}
	}

	static void close(Statement st) {
		if(st != null) {
			try { st.close(); } catch(Throwable whatever) {}
		}
	}

}