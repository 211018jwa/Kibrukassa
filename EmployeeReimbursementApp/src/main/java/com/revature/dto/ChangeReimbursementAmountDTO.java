package com.revature.dto;

import java.util.Objects;

public class ChangeReimbursementAmountDTO {
	private int amount;
	private String status;

	public ChangeReimbursementAmountDTO() {
		super();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ChangeReimbursementAmountDTO(int amount, String status) {
		super();
		this.amount = amount;
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChangeReimbursementAmountDTO other = (ChangeReimbursementAmountDTO) obj;
		return amount == other.amount && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "ChangeReimbursementAmountDTO [amount=" + amount + ", status=" + status + "]";
	}

}