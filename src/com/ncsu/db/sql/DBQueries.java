package com.ncsu.db.sql;

import com.ncsu.db.managers.insert;

public class DBQueries {
	
	public static String fetchUserInfo = "Select password, type from GUsers where ID = ?";
	
	public static String fetchCoursesByStudent = "select C.token, C.name from courses C, Enrollment E where E.studentID = ?";
	
	public static String fetchCourseByToken = "select * from courses where token = ?";
	
	public static String insertEnrollment = "insert into enrollement(courseID, studentID) values(?, ?)";
	
	public static String insertACourse = "insert into courses(token, name, startDate, endDate, profId) values(?, ?, ?, ?, ?, ?)";
	

}
