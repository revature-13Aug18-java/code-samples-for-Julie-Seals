package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;

@Service
public class UserService {

	private UserDao udi = new UserDaoImpl();
	
	public List<User> findAllUsers() {
		return udi.getUserList();
	}

	public User findUserById(int id) {
		return udi.getUserById(id);
	}
	
	public User findUserByUsername(String username) {
		return udi.getUserByUsername(username);
	}

	public User addUser(User newUser) {
		int userId = udi.createUser(newUser);
		return udi.getUserById(userId);
	}
	
	public User updateUser(User user) {
		udi.updateUser(user);
		return user;
	}

	public void deleteUser(User user) {
		udi.deleteUser(user);
	}
	
	public void deleteUserById(int id) {
		udi.deleteUserById(id);
	}

	public User login(String username, String pwd) {
		if(udi.isMatchPassword(username, pwd)) {
			return udi.getUserByUsername(username);
		} else {
			return null;
		}
	}

}