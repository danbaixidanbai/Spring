package com.spring;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ClassPathXmlApplicationContext
{
	//读取配置文件信息到集合，
	Map<String, Object> map = new HashMap<String, Object>();
	//声明SAXBuilder对象，解析Spring配置文件的
	SAXBuilder sb = new SAXBuilder();
	public ClassPathXmlApplicationContext(String path){
		
		try
		{
			//通过SAXBuilder对象的build方法，将读取到的配置文件解析为Document
			Document doc = sb.build(this.getClass().getClassLoader().getSystemResourceAsStream(path));
			//获取到根节点
			Element root = doc.getRootElement();
			//获取子节点
			List<Element> list = root.getChildren();
			for(Element e:list){
				//获取bean节点中的id 类的名称
				String id = e.getAttributeValue("id");
				//获取bean节点中的className属性值，  类的全路径
				String className = e.getAttributeValue("className");
				//通过反射全路径，生成实例化
				Object obj = Class.forName(className).newInstance();
				map.put(id, obj);
				//循环bean节点下的子节点
				for(Element el:(List<Element>)e.getChildren()){
					//获取到porperty中的name属性值ֵ
					String name = el.getAttributeValue("name");
					//获取到beanId值ֵ
					String bean= el.getAttributeValue("beanId"); 
					String methodName = "set"+name.substring(0, 1).toUpperCase()+name.substring(1);
					Object o  = map.get(bean);
					//通过反射拿到具体的方法
					Method method = obj.getClass().getMethod(methodName, o.getClass().getInterfaces()[0]);
					System.out.println("参数类型===="+o.getClass().getInterfaces()[0]);
					//obj调用该方法，向方法中传入实参
					method.invoke(obj, o);
				}
			}
		} catch (JDOMException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public Object getBean(String name){
		return map.get(name);
	}
}
