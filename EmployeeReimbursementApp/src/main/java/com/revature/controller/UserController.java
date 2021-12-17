package com.revature.controller;

import com.revature.model.User;
import com.revature.service.AuthorizationService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserController implements Controller {

	private AuthorizationService authorizationService;
	
	public UserController() {
		this.authorizationService = new AuthorizationService();
	}
	
	// This will be a "protected" endpoint that can only be accessed when you are logged in as either employee or finance manager
		private Handler getUserById = (ctx) -> {
		User user = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authorizationService.authorizeEmployeeAndFinanceManager(user); 
		// Any other logic goes below
		String id = ctx.pathParam("user_id");
		
				
	};
	
	// This will be a protected endpoint that can only be accessed when you are logged in as an finance manager
	private Handler updateReimbursements = (ctx) -> {
		User user = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authorizationService.authorizeFinanceManager(user); 
				
		
	};

	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/users/{user_id}", getUserById);
		app.patch("/users/{id}?action=approve",updateReimbursements);
	}
	
}