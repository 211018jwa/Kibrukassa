package com.revature.service;

import com.revature.exception.UnauthorizedException;
import com.revature.model.User;

public class AuthorizationService {
	
	/**********
	 * The purpose of this class is to check whether the user have the permission
	 * to access a particular data or not.
	 * @author rjm20
	 *
	 */
	public void authorizeRegularAndManager(User user) throws UnauthorizedException {
		
		if (user == null || !(user.getUserRole().equals("employee") || user.getUserRole().equals("manager"))) {
			throw new UnauthorizedException("You have to be employee or a manager");
		}			
	}
	
	public void authorizeManager(User user) throws UnauthorizedException {
		if(user == null || !user.getUserRole().equals("manager")) {
			throw new UnauthorizedException("You must be a manager to access this resource");
		}
	}
	
	public void authorizeAssociate(User user) throws UnauthorizedException {
		if(user == null || user.getUserRole().equals("manager")) {
			throw new UnauthorizedException("You must be logged in and have a role of associate for this resource");
		}
	}

}