package com.test;

import org.junit.Test;

import com.bean.User;
import com.service.UserService;
import com.spring.ClassPathXmlApplicationContext;

public class Demo
{
	@Test
	public void show(){
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("beans.xml");
		UserService us = (UserService) cpx.getBean("userService");
		User user = new User(1,"admin","123456");
		user = us.login(user);
		System.out.println("登陆成功！新的用户名为："+user.getUserName());
	}
}
