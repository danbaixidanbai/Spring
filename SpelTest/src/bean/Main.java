package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Person per=(Person) ac.getBean("person");
		System.out.println(per);
		Adress ad=(Adress) ac.getBean("address");
		System.out.println(ad.getCity()+ad.getStreet());
		Car car=(Car) ac.getBean("car");
		System.out.println(car);
	}
}
