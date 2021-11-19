package com.revature.dto;

import java.util.Objects;

public class AddOrUpdateAccountDTO {
	
	private int clientId;
	private int account_no;
	private String account_type;
	private double available_balance;
	
	public AddOrUpdateAccountDTO() {
		super();
	}

	public AddOrUpdateAccountDTO(int account_no, String account_type, double amount) {
		super();
//		this.clientId = clientId;
		this.account_no = account_no;
		this.account_type = account_type;
		this.available_balance = available_balance;
	}
		
	public AddOrUpdateAccountDTO(int clientId, int account_No, String account_Type, double available_balance ) {
		super();
		this.clientId = clientId;
		this.account_no = account_no;
		this.account_type = account_Type;
		this.available_balance = available_balance;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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

	public double getAvailable_balance() {
		return available_balance;
	}

	public void setAvailable_balance(double available_balance) {
		this.available_balance = available_balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(account_no, account_type, available_balance, clientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddOrUpdateAccountDTO other = (AddOrUpdateAccountDTO) obj;
		return account_no == other.account_no && Objects.equals(account_type, other.account_type)
				&& Double.doubleToLongBits(available_balance) == Double.doubleToLongBits(other.available_balance)
				&& clientId == other.clientId;
	}

	@Override
	public String toString() {
		return "AddOrUpdateAccountDTO [clientId=" + clientId + ", account_no=" + account_no + ", account_type="
				+ account_type + ", available_balance=" + available_balance + "]";
	}
}