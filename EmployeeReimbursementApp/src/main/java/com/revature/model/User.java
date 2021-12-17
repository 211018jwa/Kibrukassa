package com.revature.model;

import java.util.Objects;

public class User {

	private int user_id;
	private String user_password;
	private String user_first_name;
	private String user_last_name;
	private String user_email;
	private String user_role;
	
	public User() {
	}

	public User(int user_id, String user_password, String user_first_name, String user_last_name, String user_email,
			String user_role) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.user_role = user_role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user_email, user_first_name, user_id, user_last_name, user_password, user_role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(user_email, other.user_email) && Objects.equals(user_first_name, other.user_first_name)
				&& user_id == other.user_id && Objects.equals(user_last_name, other.user_last_name)
				&& Objects.equals(user_password, other.user_password) && Objects.equals(user_role, other.user_role);
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_password=" + user_password + ", user_first_name=" + user_first_name
				+ ", user_last_name=" + user_last_name + ", user_email=" + user_email + ", user_role=" + user_role
				+ "]";
	}
}