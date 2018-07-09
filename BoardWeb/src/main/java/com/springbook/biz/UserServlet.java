package com.springbook.biz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.user.UserDAO;
import com.springbook.biz.user.UserVO;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//doGet, doPost, service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답결과 인코딩
		response.setContentType("text/html; charset=UTF-8");
		//요청 파라미터 인코딩
		request.setCharacterEncoding("utf-8");
		
		//요청  URI 확인
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("요청 URI===="+path);
		
		//파라미터 받아서 VO에 저장
		UserVO vo = new UserVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setRole(request.getParameter("role"));	
		
		UserDAO dao = new UserDAO();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//URI에 따라서 처리
		if(path.equals("/login.do")) {
			UserVO result = dao.getUser(vo);
			if(result == null) {
				//일치하는 ID가 없는 경우
				out.print("<script>alert('id error');"
						//+ " history.go(-1); "						
						+ "location.href='    ';"
						+ "</script>");
			} else if( vo.getPassword().equals(result.getPassword()) ) {
				//패스워드 일치하는 경우
				//세션처리
				session.setAttribute("id", vo.getId());
				response.sendRedirect("getUser.do?id="+vo.getId());
			} else {
				//패스워드가 틀린 경우
				out.print("<script>alert('pw error'); history.go(-1); </script>");
			}
		}
		else if(path.equals("/insertUser.do")) {
			dao.insertUser(vo);
			response.sendRedirect("getUserList.do");
		}
		else if(path.equals("/getUser.do")) {
			request.setAttribute("user", dao.getUser(vo));
			request.getRequestDispatcher("getUser.jsp")
				.forward(request, response);
		}
		else if(path.equals("/updateUserForm.do")) {  //수정폼
			request.setAttribute("user", dao.getUser(vo));
			request.getRequestDispatcher("updateUser.jsp")
				.forward(request, response);
		}
		else if(path.equals("/updateUser.do")) {  //수정처리
			request.setAttribute("user", dao.getUser(vo));
			request.getRequestDispatcher("updateUser.jsp")
				.forward(request, response);
		}
		else if(path.equals("/getUserList.do")) {
			request.setAttribute("list", dao.getUserList());
			request.getRequestDispatcher("getUserList.jsp")
				.forward(request, response);
		} else {
		
		}	
	}
}
