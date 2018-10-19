package com.revature.service;

import java.util.HashMap;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.beans.User;



public class AccountManager 
{
	private static HashMap<Integer, User> activeAccounts = new HashMap<>();	
	private static HashMap<User, Integer> activeAccountsRev = new HashMap<>();
	
	private static int getAvailableToken(User ua)
	{
		Integer i = activeAccountsRev.get(ua);
		if(i != null)
			return i;
		
		// Go through the list of possible positive integers for a space
		// Starting at 1 since 0 is used by accounts as no logged on
		for(int c = 1; c < Integer.MAX_VALUE; c++)
		{
			if(!activeAccounts.containsKey(c))
			{
				// Found a space, use it
				activeAccounts.put(c, ua);
				activeAccountsRev.put(ua,c);
				return c;
			}
		}
		
		// No space available, report the User Level value for not logged on
		return -1;
	}
	
	
	private static User logOn(String un, String pw)
	{
		UserDao ud = new UserDaoImpl();
		return null;
	}

}
