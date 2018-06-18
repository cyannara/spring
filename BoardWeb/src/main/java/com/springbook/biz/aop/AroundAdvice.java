package com.springbook.biz.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE] around 로직 수행전");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		//서비스 메서드 호출
		Object returnnObj = pjp.proceed();
		
		stopWatch.stop();
		
		
		System.out.println("[AFTER] around 로직 수행후" + 
		                    stopWatch.getTotalTimeMillis());
		return returnnObj;
	}
}
