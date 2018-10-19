package com.revature.main;

import org.apache.log4j.BasicConfigurator;
import com.revature.controller.MainMenu;

public class BankDriver {

	public static void main(String[] args) {
		BasicConfigurator.configure();
				
		MainMenu session = new MainMenu();
		session.mainMenu();		
		
	}
}