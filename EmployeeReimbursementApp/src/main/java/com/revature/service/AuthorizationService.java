package com.revature.service;

import com.revature.exceptions.UnauthorizedException;
import com.revature.model.User;

public class AuthorizationService {

	public void authorizeEmployeeAndFinanceManager(User user) throws UnauthorizedException {
		
		if (user == null || !(user.getUser_role().equals("employee") || user.getUser_role().equals("Finance Manager"))) {
			throw new UnauthorizedException("You must have an employee or Finance Manager role to access this resource");
		}
	}
	
	public void authorizeFinanceManager(User users) throws UnauthorizedException {
		if (users == null || !users.getUser_role().equals("Finance Manager")) {
			throw new UnauthorizedException("You must have an Finance Manager role to access this resource");
		}
	}
	
}
