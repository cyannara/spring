<%@page import="com.springbook.biz.user.UserService"%>
<%@page import="com.springbook.biz.user.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%  //insertUser_proc.jsp 
	UserVO vo = new UserVO();
	vo.setId(request.getParameter("id"));
	vo.setPassword(request.getParameter("password"));
	vo.setName(request.getParameter("name"));
	vo.setRole(request.getParameter("role"));	
	UserDAO dao = new UserDAO();
	dao.insertUser(vo); 
	response.sendRedirect("getUserList.jsp");
%>
