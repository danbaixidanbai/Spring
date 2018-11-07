package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.Cal;

public class Main {
	public static void main(String[] args) {
		 @SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("application.xml");
		 Cal cal=(Cal) ac.getBean("cal");
		 System.out.println(cal.getClass());
		 int result=cal.add(1, 2);
		 System.out.println(result);
		 
		 result=cal.div(1000, 10);
		 System.out.println(result);
	}
}
