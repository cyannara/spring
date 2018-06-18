package com.springbook.biz.aop;

import org.aspectj.lang.annotation.After;

public class AfterAdvice {
	
	@After("LogAdvice.allpointcut()")
	public void finallyLog() {
		System.out.println("[사후처리] 비즈니스 로직 수행 후 무조건 동작");
	}
}
