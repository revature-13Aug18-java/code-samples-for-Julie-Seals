package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Login;
import com.revature.beans.NewAccount;
import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController 
{
	@Autowired
	UserService userServe;
	
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	@RequestMapping(value="/Dashboard", method=RequestMethod.POST)
	@ResponseBody
	public User requestUser(@RequestParam("id") int id, @RequestParam("token") int token)
	{
		UserDao ud = new UserDaoImpl();
		return ud.getUserById(id);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public User loginUser(@RequestBody Login log)
	{
		String userStr = log.getUsername();
		String passStr = log.getPassword();
		
		System.out.println("Username: " + userStr);
		System.out.println("password: " + passStr);
		
		
//		return userServe.login(userStr, passStr);
		
		UserDao ud = new UserDaoImpl();
		
		User use = ud.getUserByUsername(userStr);
		if(use == null)
			return null;
		
		if(use.getPwd().equals(passStr))
			return use;
		
		
		return null;
	}
	
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	@ResponseBody
	public User createUser(@RequestBody NewAccount na)
	{
		String userStr = na.getUsername();
		String passStr = na.getPassword();
		String nameStr = na.getDisplayName();
		
		
		
		if( userStr != null && passStr != null && nameStr != null)
		{
			User use = new User(nameStr, userStr,passStr,0,0);
			
			return userServe.addUser(use);
		}
		return null;
	}
	
	@RequestMapping(value="/checkUsername", method=RequestMethod.POST)
	@ResponseBody
	public Boolean checkUsername(@RequestBody String userStr)
	{
		return userServe.findUserByUsername(userStr) != null;
	}
	
	
}
