package com.revature.model;

import java.util.Objects;

public class Client {
	
	private String First_Name;
	private String Last_Name;
	private String Address;
	private String Phone_Number;
	
	public Client() {
		super();
	}
	
	public Client(String First_Name, String Last_Name, String Address, String Phone_Number) {
		super();
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
		this.Address = Address;
		this.Phone_Number = Phone_Number;
}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, First_Name, Last_Name, Phone_Number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(Address, other.Address) && Objects.equals(First_Name, other.First_Name)
				&& Objects.equals(Last_Name, other.Last_Name) && Objects.equals(Phone_Number, other.Phone_Number);
	}

	@Override
	public String toString() {
		return "Client [First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Address=" + Address
				+ ", Phone_Number=" + Phone_Number + "]";
	}
}
