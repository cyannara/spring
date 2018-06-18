package com.springbook.biz.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(returning="returnObj", 
			        pointcut="LogAdvice.allpointcut()")
	public void afterLog(JoinPoint jp, Object returnObj) {
		//메서드명
		String method = jp.getSignature().getName();
		String returnStr =  returnObj != null ? returnObj.toString() : "";
		System.out.println("[사후처리] " + method + " return : " + returnStr);
	}
}
