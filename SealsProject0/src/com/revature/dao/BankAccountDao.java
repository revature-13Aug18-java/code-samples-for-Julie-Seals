package com.revature.dao;

import com.revature.model.BankAccount;

public interface BankAccountDao {
	
	public int createBankAccount(BankAccount account);
	public int updateAccount(BankAccount account);
	public double getBalance(String id);
	

}
