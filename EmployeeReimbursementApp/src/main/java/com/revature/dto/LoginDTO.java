package com.revature.dto;

import java.util.Objects;

public class LoginDTO {

	// Properties
	private String user_email;
	private String user_password;
	public LoginDTO() {
	}
	public LoginDTO(String user_email, String user_password) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user_email, user_password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDTO other = (LoginDTO) obj;
		return Objects.equals(user_email, other.user_email) && Objects.equals(user_password, other.user_password);
	}

	@Override
	public String toString() {
		return "LoginDTO [user_email=" + user_email + ", user_password=" + user_password + "]";
	}
	
}

