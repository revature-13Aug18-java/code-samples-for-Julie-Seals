package com.revature.model;

public class BankAccount {
	
	private String userId;
	private double balance;
	
	public BankAccount() {
		super();
	}

	public BankAccount(String userId, double balance) {
		super();
		this.userId = userId;
		this.balance = balance;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId)) {	
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [userId=" + userId + ", balance=" + balance + "]";
	}

}