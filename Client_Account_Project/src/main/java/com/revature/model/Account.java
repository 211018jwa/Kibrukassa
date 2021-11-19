package com.revature.model;

import java.util.Objects;

public class Account {
	
	private int Client_id;
	private int account_no;
	private String account_type;
	private Double available_balance;
	public Account() {
		super();
	}

	public Account(int Client_Id, int account_no, String account_type, Double available_balance ) {
		super();
		this.account_no = account_no;
		this.account_type = account_type;
		this.available_balance = available_balance ;
		this.Client_id = Client_id;
	}

	public int getClient_id() {
		return Client_id;
	}

	public void setClient_id(int client_id) {
		Client_id = client_id;
	}

	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public Double getAvailable_balance() {
		return available_balance;
	}

	public void setAvailable_balance(Double available_balance) {
		this.available_balance = available_balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Client_id, account_no, account_type, available_balance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Client_id == other.Client_id && account_no == other.account_no
				&& Objects.equals(account_type, other.account_type)
				&& Objects.equals(available_balance, other.available_balance);
	}

	@Override
	public String toString() {
		return "Account [Client_id=" + Client_id + ", account_no=" + account_no + ", account_type=" + account_type
				+ ", available_balance=" + available_balance + "]";
	}
}