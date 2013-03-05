package com.ncsu.db.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ncsu.db.sql.DBQueries;
import com.ncsu.db.utils.DBConnection;

public class UsersManager {
	
	public int checkUserLogin(String id, String password) {
		
		int userType = -1;
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement userInfo;
		try {
			userInfo = conn.prepareStatement(DBQueries.fetchUserInfo);
			userInfo.setString(1, id);
			ResultSet rs = userInfo.executeQuery();
			
			if(rs.next()) {
				String db_pwd = rs.getString("password");
				if(password.equals(db_pwd)) {
					userType = Integer.parseInt(rs.getString("type"));
				} else {
					System.out.println("Username password does not match.");
				}
			} else {
				System.out.println("The user with user id=" + id + " does not exist.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userType;
	}
	
	public void addUser(String username, String password, String type) {
		
		//check if the type is correct
		
		//add the user information in the table
		
	}
}
