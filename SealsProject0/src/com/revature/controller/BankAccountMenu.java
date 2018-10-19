package com.revature.controller;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.model.BankAccount;

public class BankAccountMenu extends UserInput {
	
	private static Logger log = Logger.getRootLogger();
	
	double mostRecent;
	double balance;
	
	public BankAccountMenu() {
		super();
	}

	public BankAccountMenu(double mostRecent, double balance) {
		super();
		this.mostRecent = mostRecent;
		this.balance = balance;
	}

	void deposit (double depositAmount) {
		
		if(depositAmount != 0) {
			balance += depositAmount;
			mostRecent = depositAmount;
		}
	}
	
	void withdraw (double withdrawAmount) {
		
		if(withdrawAmount != 0) {
			balance -= withdrawAmount;
			mostRecent = -withdrawAmount;
		}
	}	
	
	void accountMenu(String userName) {
		BankAccountDaoImpl bad = new BankAccountDaoImpl();
		balance = bad.getBalance(userName);
		char choice;
		Scanner choiceIn = new Scanner(System.in);
		double depositAmount = 0;
		double withdrawAmount = 0;
		
		log.info("Welcome");
		log.info("\n");
		log.info("A: View balance"); 
		log.info("B: Deposit"); 
		log.info("C: Withdraw");
		log.info("D: Exit");
				
		do {
			
			log.info("Please input an option from the menu");
			choice = Character.toUpperCase(choiceIn.next().charAt(0));
						
			switch(choice) {
			
			case 'A': 
				log.info("Balance: " + balance);
				break;
			
			case 'B': 
				
				log.info("Deposit amount: ");
				while(!(choiceIn.hasNextDouble())) {		
					log.info("You must enter a number. Try again.");
					choiceIn.next();
				}
				depositAmount = choiceIn.nextDouble();
				log.info(depositAmount);
				
				if(depositAmount > 0) {
					deposit(depositAmount);
				} else {
					log.info("You attempted to deposit a negative amount.");
				}
				
				break;
			
			case 'C':
				log.info("Withdrawal amount: ");
				while(!(choiceIn.hasNextDouble())) {		
					log.info("You must enter a number. Try again.");
					choiceIn.next();
				}
				
				withdrawAmount = choiceIn.nextDouble();
				if(withdrawAmount < 0) {
					log.info("You attempted to withdraw a negative amount.");
				} else if (withdrawAmount > balance) {
					log.info("You attempted to withdraw more than you have.");
				} else {
				withdraw(withdrawAmount);
				}
				break;
				
			case 'D': 
				log.info("Thank you for using our services!");
				break;
			
			default: 
				log.info("You must enter a choice from the menu");
			}
			
		} while(choice != 'D');
		
		BankAccount account = new BankAccount();
		account.setUserId(userName);
		account.setBalance(balance);
		bad.updateAccount(account);

	}
	
}



