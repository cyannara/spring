package com.springbook.biz.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect  // advice 클래스와 포인트컷이 결합된 클래스
public class LogAdvice {	
	//포인트컷 지정
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allpointcut() {} 
	
	@Before("allpointcut()")
	public void printLog() {
		System.out.println("[공통로그] 비즈니스 수행 전 동작");
	}
}
