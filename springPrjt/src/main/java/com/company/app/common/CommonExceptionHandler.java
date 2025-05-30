package com.company.app.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice("com.yedam.web.board.view")
public class CommonExceptionHandler {
	
	@ExceptionHandler(Exception.class) 
	public ModelAndView handleException(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", e);
		mv.setViewName("popup/common/error");
		return mv;
	}	
}
