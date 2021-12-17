package com.revature.service;

import java.sql.SQLException;
import javax.security.auth.login.FailedLoginException;
import com.revature.dao.UserDAO;
import com.revature.model.User;

public class UserService {
	
	private UserDAO userDao;
	
	public UserService() {
		this.userDao = new UserDAO();
	}

	public User getUserByEmailAndPassword(String email, String password) throws SQLException, FailedLoginException {
		
		User user = this.userDao.getUserByEmailAndPassword(email, password);
		
		if (user == null) {
			throw new FailedLoginException("Incorrect email and/or password");
		}
		
		return user;
	}
	
}