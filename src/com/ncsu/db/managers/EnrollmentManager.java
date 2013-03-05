package com.ncsu.db.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ncsu.db.beans.CourseBean;
import com.ncsu.db.sql.DBQueries;
import com.ncsu.db.utils.DBConnection;

public class EnrollmentManager {
	
	public ArrayList<CourseBean> getCourses(String studentID) {
		
		ArrayList<CourseBean> courses = new ArrayList<CourseBean>();
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement coursesByStudent;
		
		try {
			coursesByStudent = conn.prepareStatement(DBQueries.fetchCoursesByStudent);
			coursesByStudent.setString(1, studentID);
			ResultSet rs = coursesByStudent.executeQuery();
			
			while(rs.next()) {
				String courseToken = rs.getString("token");
				String courseName = rs.getString("name");
				
				CourseBean c = new CourseBean();
				c.setName(courseName);
				c.setToken(courseToken);
				courses.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	public void addCourseForStudent(String courseToken, String studentId) {
		
		//TODO - check that the course start and end date allow the course to be enrolled
		
		//add the course, student pair in enrollment table
		Connection conn = DBConnection.getConnection();
		PreparedStatement insertEnrollment;
		
		try {
			insertEnrollment = conn.prepareStatement(DBQueries.insertEnrollment);
			insertEnrollment.setString(1, courseToken);
			insertEnrollment.setString(2, studentId);
			
			insertEnrollment.executeQuery();			
		} catch (SQLException e) {
			System.out.println("Error inserting enrollment information. Please check the course ID token");
		}
	}
}