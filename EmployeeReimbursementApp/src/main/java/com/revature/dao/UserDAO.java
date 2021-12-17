package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;
import com.revature.util.JDBCUtility;

public class UserDAO {

	public User getUserByEmailAndPassword(String user_email, String user_password) throws SQLException {
		try (Connection con = JDBCUtility.getConnection()) {
			String sql = "SELECT * FROM project1.users WHERE user_email = ? AND user_password = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			pstmt.setString(2, user_password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("user_id");
				String password = rs.getString("user_password");
				String firstName = rs.getString("user_first_name");
				String lastName = rs.getString("user_last_name");
				String email = rs.getString("user_email");
				String userRole = rs.getString("user_role");
				
				return new User(id, password, firstName, lastName, user_email, userRole);
			} else {
				return null;
			}
		}
	}
	
}