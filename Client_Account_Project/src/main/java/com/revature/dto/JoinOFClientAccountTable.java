package com.revature.dto;

import java.util.Objects;

public class JoinOFClientAccountTable {
	
	private int Client_id;
	private String First_Name;
	private String Last_Name;
	private String Address;
	private int Account_No;
	private String Account_Type;
	private double available_balance;
	
	public JoinOFClientAccountTable() {
		super();
	}

	public JoinOFClientAccountTable(int Client_id, String First_Name, String Last_Name, String Address, int Account_No,
			String Account_Type, double available_balance) {
		super();
		this.Client_id = Client_id;
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
		this.Address = Address;
		this.Account_No = Account_No;
		this.Account_Type = Account_Type;
		this.available_balance = available_balance;
	}

	public int getClient_id() {
		return Client_id;
	}

	public void setClient_id(int client_id) {
		Client_id = client_id;
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

	public int getAccount_No() {
		return Account_No;
	}

	public void setAccount_No(int account_No) {
		Account_No = account_No;
	}

	public String getAccount_Type() {
		return Account_Type;
	}

	public void setAccount_Type(String account_Type) {
		Account_Type = account_Type;
	}

	public double getAvailable_balance() {
		return available_balance;
	}

	public void setAvailable_balance(double available_balance) {
		this.available_balance = available_balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Account_No, Account_Type, Address, Client_id, First_Name, Last_Name, available_balance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JoinOFClientAccountTable other = (JoinOFClientAccountTable) obj;
		return Account_No == other.Account_No && Objects.equals(Account_Type, other.Account_Type)
				&& Objects.equals(Address, other.Address) && Client_id == other.Client_id
				&& Objects.equals(First_Name, other.First_Name) && Objects.equals(Last_Name, other.Last_Name)
				&& Double.doubleToLongBits(available_balance) == Double.doubleToLongBits(other.available_balance);
	}

	@Override
	public String toString() {
		return "JoinOFClientAccountTable [Client_id=" + Client_id + ", First_Name=" + First_Name + ", Last_Name="
				+ Last_Name + ", Address=" + Address + ", Account_No=" + Account_No + ", Account_Type=" + Account_Type
				+ ", available_balance=" + available_balance + "]";
	}
}
