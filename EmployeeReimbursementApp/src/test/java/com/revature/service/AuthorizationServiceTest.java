package com.revature.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.UnauthorizedException;
import com.revature.model.User;
public class AuthorizationServiceTest {

	private AuthorizationService authService;
	@BeforeEach
	public void setup() {
		this.authService= new AuthorizationService ();
		
	}
	@Test
	public void authorizeEmployeeAndFinanceManager_NegativeTest_userIsEmployeeButRequiresFinanceManagerPermissions()throws UnauthorizedException {
		User user = new User(1,"helen","Ali","helen@gmail.com","Pass123","employee");
		Assertions.assertThrows(UnauthorizedException.class, ()-> {
			this.authService.authorizeFinanceManager(user);
		});
	}
		
		@Test
		public void authorizeEmployeeAndFinanceManager_PositiveTest_userIsEmployeeButRequiresFinanceManagerPermissions()throws UnauthorizedException {
			User user = new User(1,"Mo","Sala","sala@gmail.com","Pass111","employee");
			Assertions.assertThrows(UnauthorizedException.class, ()-> {
				this.authService.authorizeFinanceManager(user);
			});
		}
		
			@Test
			public void authorizeEmployeeAndFinanceManager_PositiveTest_userIsEmployeeButRequiresAFinanceManagerPermissions()throws UnauthorizedException {
				User user = new User(1,"Jhon","Dustin","jhone@gmail.com","Password123","employee");
				Assertions.assertThrows(UnauthorizedException.class, ()-> {
					this.authService.authorizeFinanceManager(user);
				});
		}
		
		@Test
		public void authorizeFinanceManager_NegativeTest_userIsNull () {
			Assertions.assertThrows(UnauthorizedException.class, ()-> {
				this.authService.authorizeFinanceManager(null);
			});
			
		}
			@Test
			public void authorizeFinanceManager_NegativeTest_userIsNotNull () throws UnauthorizedException {
				User user = new User(1,"helen","Ali","helen@gmail.com","Pass123","Finance Manager");
				this.authService.authorizeFinanceManager(user);
			}
		
		
		@Test
		public void authorizeFinanceManager_PositiveTest_userIsAFinanceManager () throws UnauthorizedException {
			User user = new User(1,"helen","Ali","helen@gmail.com","Pass123","Finance Manager");
			this.authService.authorizeFinanceManager(user);
		
		}
		
		@Test
		public void authorizeFinanceManager_PositiveTest_userIsNotFinanceManager () throws UnauthorizedException {
			User user = new User(1,"Mo","Sala","sala@gmail.com","Pass111","employee");
			this.authService.authorizeEmployeeAndFinanceManager(user);
		
		}
		
		@Test
		public void authorizeFinanceManager_PositiveTest_userIsNotAFinanceManager () throws UnauthorizedException {
			User user = new User(1,"john","Dustin","jhon@gmail.com","Password123","employee");
			this.authService.authorizeEmployeeAndFinanceManager(user);
		
	}
		@Test
		public void authorizeEmployeeAndFinanceManager_NegativeTestuserIsNotFinanceManagerOrEmployee ()  {
			User user = new User(1,"helen","Ali","helen@gmail.com","Pass123","Tester");
			Assertions.assertThrows(UnauthorizedException.class, ()-> {
				this.authService.authorizeFinanceManager(user);
			});
		}
		
		@Test
		public void authorizeEmployeeAndFinanceManager_NegativeTestuserIsNotAFinanceManagerOrAEmployee ()  {
			User user = new User(1,"helen","Ali","helen@gmail.com","Pass123","Qc");
			Assertions.assertThrows(UnauthorizedException.class, ()-> {
				this.authService.authorizeFinanceManager(user);
			});
		}
		
		@Test
		public void authorizeFinanceManagerAndEmployee_NegativeTest_userIsNull () {
			Assertions.assertThrows(UnauthorizedException.class, ()-> {
				this.authService.authorizeFinanceManager(null);
			});
}
		
		@Test
		public void authorizeFinanceManagerAndEmployee_PositiveTest_userIsEmployee () throws UnauthorizedException {
			User user = new User(1,"john","Dustin","jhon@gmail.com","Password123","employee");
			this.authService.authorizeEmployeeAndFinanceManager(user);
			
		}
		
		@Test
		public void authorizeFinanceManagerAndEmployee_PositiveTest_userIsAnEmployee () throws UnauthorizedException {
			User user = new User(1,"Mo","Sala","sala@gmail.com","Pass111","employee");
			this.authService.authorizeEmployeeAndFinanceManager(user);
						
		}
		
		@Test
		public void authorizeFinanceManagerAndEmployee_PositiveTest_userIsFinanceManager () throws UnauthorizedException {
			User user = new User(1,"helen","ali","helen@gmail.com","Pass123","Finance Manager");
			this.authService.authorizeEmployeeAndFinanceManager(user);
						
		}
		
		
}
		
	

