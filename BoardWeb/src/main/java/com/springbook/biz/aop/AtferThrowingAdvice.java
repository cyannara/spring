package com.springbook.biz.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AtferThrowingAdvice {
	
	@AfterThrowing(throwing="exceptObj", pointcut="LogAdvice.allpointcut()")
	public void exceptionLog(JoinPoint jp, Exception exceptObj ) {
		String method = jp.getSignature().getName();
		String exceptStr = exceptObj != null ? exceptObj.getMessage() : "";
		System.out.println("[사후처리] " + method +
				           " exception: " + exceptStr);
	}
}
