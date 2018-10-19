package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDao 
{
	public User getUserByUsername(String username);	
	public User getUserById(int id);
	public List<User> getUserList();
	public int createUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public void deleteUserById(int id);
	boolean isMatchUsername(String username);
	boolean isMatchPassword(String username, String pwd);
}
