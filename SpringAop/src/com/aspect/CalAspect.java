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
	
	/*//在方法执行之前的代码
	@Before("execution(public int com.dao.Cal.*(..) )")
	public void beforeMethod(JoinPoint jp){
		String methodname=jp.getSignature().getName();
		Object[] args=jp.getArgs();
		System.out.println("the method:"+methodname+" begins whith"+Arrays.asList(args));
	}
	//在方法执行之后的代码，无论该方法是否出现异常
	@After("execution(public int com.dao.Cal.*(..) )")
	public void afterMethod(JoinPoint jp){
		String methodname=jp.getSignature().getName();
		System.out.println("the method:"+methodname+" end");
	}
	//在方法正常执行结束执行的代码，可以访问到目标方法的返回值
	@AfterReturning(value="execution(public int com.dao.Cal.*(..) )",returning="result")
	public void afterReturnMethod(JoinPoint jp,Object result){
		String methodname=jp.getSignature().getName();
		System.out.println("the method:"+methodname+" end with "+result);
	}
	//在目标方法出异常时会执行的代码，可以访问到异常对象，且可以指定出现特定异常时在执行通知代码
	@AfterThrowing(value="execution(public int com.dao.Cal.*(..) )",throwing="e")
	public void afterThrowing(JoinPoint jp,Exception e){
		String methodname=jp.getSignature().getName();
		System.out.println("the method:"+methodname+" occour with "+e);
	}*/
	
	//环绕通知需要携带ProceedingJoinPoint类型的参数
	//环绕通知类似动态代理的全过程，ProceedingJoinPoint类型的参数可以决定是否执行目标方法
	//且环绕通知必须有返回值，且必须为目标方法的返回值
	@Around("execution(public int com.dao.Cal.*(..) )")
	public Object AroundMethod(ProceedingJoinPoint pjp){
		Object result=null;
		String methodname=pjp.getSignature().getName();
		Object[] args=pjp.getArgs();
		try {
			//前置通知
			System.out.println("the method:"+methodname+" begin with"+Arrays.asList(args));
			result=pjp.proceed();//执行目标方法
			//返回通知
			System.out.println("the method:"+methodname+" end with:"+result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("the method:"+methodname+" occurs with:"+e);
			throw new RuntimeException(e);
		}
			//后置通知
		System.out.println("the method:"+methodname+" end....");
		return result;
	}
}
