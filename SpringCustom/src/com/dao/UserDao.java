package com.dao;

import com.bean.User;

public interface UserDao
{
	public User login(User user);
	
	public boolean register(User user);
}
