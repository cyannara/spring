package com.springbook.biz.aop;

import org.aspectj.lang.JoinPoint;

//advice 클래스
public class BeforeAdvice {
	
	
	public void beforeLog(JoinPoint jp) {
		//조인포인트  = 서비스 메서드
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		String args1 = 
				args != null && args.length>0 ? args[0].toString() : "";
		System.out.println("[사전처리] " + method + " 비즈니스 로직 수행전 처리 \n"
				           + "메서드: " + args1 );
	}
}
