package com.revature.controller;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.revature.dao.UserInfoDaoImpl;
import com.revature.model.UserInfo;

public class UserInput extends UserInfoDaoImpl {
	
	public UserInput() {
		super();
	}
	
	private static Logger log = Logger.getRootLogger();

	Scanner sc = new Scanner(System.in);
		
	UserInfo user = new UserInfo();
	
	public void createAccount () {
		
		String createUserName;
		String createPassword;
		String fname;
		String lname;

		log.info("Follow prompts to create online account.");
		log.info("Enter email address or username: ");
		createUserName = sc.nextLine();
		user.setUsername(createUserName);
		log.info("Enter password: ");
		createPassword = sc.nextLine();
		user.setPassword(createPassword);
		log.info("Enter first name: ");
		fname = sc.nextLine();
		user.setFname(fname);
		log.info("Enter last name: ");
		lname = sc.nextLine();
		user.setLname(lname);

		createUserAccount(user);		
	}
	
	public void logIn() {			
		log.info("Please enter your username: ");
		String userName = sc.nextLine();
			while(!isMatchUsername(userName)) {
			log.info("Try again: ");
			userName = sc.nextLine();
		} 
				
		log.info("Enter password:");
		String password = sc.nextLine();
		while(!isMatchPassword(password, userName)) {
			log.info("Try again: ");
			password = sc.nextLine();
		} 
		
		BankAccountMenu bank = new BankAccountMenu();
		bank.accountMenu(userName);
		
		
		
	}

}
