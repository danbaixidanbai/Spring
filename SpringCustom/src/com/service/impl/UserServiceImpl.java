package com.service.impl;

import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;

public class UserServiceImpl implements UserService
{
	private UserDao userDao;
	
	public UserDao getUserDao()
	{
		return userDao;
	}
	//set����ע��
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	@Override
	public User login(User user)
	{
		return userDao.login(user);
	}

	@Override
	public boolean register(User user)
	{
		return userDao.register(user);
	}

}
