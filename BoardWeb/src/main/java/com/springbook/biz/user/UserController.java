package com.springbook.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired UserService userService;
	
	//로그인폼으로
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "/user/login";
	}
	
	//로그인 처리
	@RequestMapping("/login")
	public String login() {
		return "/getBoardList";
	}
	
	
}
