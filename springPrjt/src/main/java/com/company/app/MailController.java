package com.company.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.common.MailService;
import com.company.app.common.MailVO;

@Controller
public class MailController {

	@RequestMapping("mailSend")
	public String mailSend(MailVO vo
			        , HttpServletResponse response,HttpServletRequest request) throws IOException {
		//String a = request.getAttribute("");
				
		vo.setFrom("");
		vo.setTo("");
		vo.setUsername("");
		vo.setPassword("");
		vo.setSubject("");
		vo.setText("");
		MailService.send(vo);
		PrintWriter out = response.getWriter();
		out.print("<script>alert('send success');</script>");
		return null;		
	}
}
