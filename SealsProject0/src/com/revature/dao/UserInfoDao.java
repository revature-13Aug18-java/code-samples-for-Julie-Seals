package com.revature.dao;

import java.util.List;

import com.revature.model.UserInfo;

public interface UserInfoDao {
	
	public int createUserAccount(UserInfo user);
	public List<UserInfo> getUsers();
	public int updateAccount(UserInfo user);
	public boolean isMatchUsername(String input);
	public boolean isMatchPassword(String inputPassword, String inputUser);
}

