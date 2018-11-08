package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.BookShopService;

public class DemoTest {
	
	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	BookShopService bs=(BookShopService) ac.getBean(BookShopService.class);
	
	@Test
	public void show(){
		bs.buys("asd", "10001");
	}
}
