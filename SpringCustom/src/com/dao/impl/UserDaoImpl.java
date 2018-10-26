package com.dao.impl;

import com.bean.User;
import com.dao.UserDao;

public class UserDaoImpl implements UserDao
{

	@Override
	public User login(User user)
	{
		User use = null;
		if(user.getUserName().equals("admin")&& user.getPassword().equals("123456")){
			use = new User(1001, "userName", "123456");
		}
		return use;
	}

	@Override
	public boolean register(User user)
	{
		if(user!=null){
			return true;
		}
		return false;
	}

}
