package com.doodle.core.spring.aspect;

import java.time.LocalTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect 
public class MyAspects {
	@Pointcut("execution(* com.doodle.core.spring.controller.ApiController.*(..))")
	public void allApiControllerMethods() {}
	
	@Pointcut("execution(* com.doodle.core.spring.service.*.*(..))")
	public void allServicesMethods() {}
	
	@Pointcut("execution(* com.doodle.core.spring.dao.*.*(..))")
	public void allDAOMethods() {}
	
	
	@Before("allApiControllerMethods()")
	public void beforeAllApiControllerMethods(JoinPoint jp) {
		System.out.println(LocalTime.now()+" | "+jp.getSignature().getDeclaringTypeName()+" | Method "+ jp.getSignature().getName()+" has started");
	}
	
	@Before("allServicesMethod()")
	public void beforeallServicesMethod(JoinPoint jp) {
		System.out.println(LocalTime.now()+" | "+jp.getSignature().getDeclaringTypeName()+" | Method "+ jp.getSignature().getName()+" has started");
	}
	
	@Before("allDAOMethods()")
	public void beforeAllDAOMethods(JoinPoint jp) {
		System.out.println(LocalTime.now()+" | "+jp.getSignature().getDeclaringTypeName()+" | Method "+ jp.getSignature().getName()+" has started");
	}
}

