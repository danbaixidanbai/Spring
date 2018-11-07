package com.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CalAspect {
	
	/*//�ڷ���ִ��֮ǰ�Ĵ���
	@Before("execution(public int com.dao.Cal.*(..) )")
	public void beforeMethod(JoinPoint jp){
		String methodname=jp.getSignature().getName();
		Object[] args=jp.getArgs();
		System.out.println("the method:"+methodname+" begins whith"+Arrays.asList(args));
	}
	//�ڷ���ִ��֮��Ĵ��룬���۸÷����Ƿ�����쳣
	@After("execution(public int com.dao.Cal.*(..) )")
	public void afterMethod(JoinPoint jp){
		String methodname=jp.getSignature().getName();
		System.out.println("the method:"+methodname+" end");
	}
	//�ڷ�������ִ�н���ִ�еĴ��룬���Է��ʵ�Ŀ�귽���ķ���ֵ
	@AfterReturning(value="execution(public int com.dao.Cal.*(..) )",returning="result")
	public void afterReturnMethod(JoinPoint jp,Object result){
		String methodname=jp.getSignature().getName();
		System.out.println("the method:"+methodname+" end with "+result);
	}
	//��Ŀ�귽�����쳣ʱ��ִ�еĴ��룬���Է��ʵ��쳣�����ҿ���ָ�������ض��쳣ʱ��ִ��֪ͨ����
	@AfterThrowing(value="execution(public int com.dao.Cal.*(..) )",throwing="e")
	public void afterThrowing(JoinPoint jp,Exception e){
		String methodname=jp.getSignature().getName();
		System.out.println("the method:"+methodname+" occour with "+e);
	}*/
	
	//����֪ͨ��ҪЯ��ProceedingJoinPoint���͵Ĳ���
	//����֪ͨ���ƶ�̬�����ȫ���̣�ProceedingJoinPoint���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��
	//�һ���֪ͨ�����з���ֵ���ұ���ΪĿ�귽���ķ���ֵ
	@Around("execution(public int com.dao.Cal.*(..) )")
	public Object AroundMethod(ProceedingJoinPoint pjp){
		Object result=null;
		String methodname=pjp.getSignature().getName();
		Object[] args=pjp.getArgs();
		try {
			//ǰ��֪ͨ
			System.out.println("the method:"+methodname+" begin with"+Arrays.asList(args));
			result=pjp.proceed();//ִ��Ŀ�귽��
			//����֪ͨ
			System.out.println("the method:"+methodname+" end with:"+result);
		} catch (Throwable e) {
			//�쳣֪ͨ
			System.out.println("the method:"+methodname+" occurs with:"+e);
			throw new RuntimeException(e);
		}
			//����֪ͨ
		System.out.println("the method:"+methodname+" end....");
		return result;
	}
}
