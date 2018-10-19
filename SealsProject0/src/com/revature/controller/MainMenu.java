package com.revature.controller;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class MainMenu extends UserInput {
	
	public MainMenu() {
		super();
		
	}
	
	UserInput input = new UserInput();
	
	private static Logger log = Logger.getRootLogger();
	
	@SuppressWarnings("resource")
	public void mainMenu() {	
		int choice;
		Scanner choiceIn = new Scanner(System.in);
		
		log.info("Welcome");
		log.info("1: Create account");
		log.info("2: Log in to existing account");
		log.info("3: Exit");
		log.info("Please choose one of the menu options.");
		
		do {
			choice = choiceIn.nextInt();
						
			switch(choice) {
			
			case 1: 
				createAccount();
				log.info("Now press 2 to log in");
				break;
			
			case 2: 
				input.logIn();
				break;
			case 3:
				log.info("Have a nice day");
				break;
					
			default: 
				log.info("You must enter a choice from the menu");
			}
			
		} while(choice != 3);
		
		
	}

}
