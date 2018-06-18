<%@page import="com.springbook.biz.user.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  //login_proc.jsp

	String id= request.getParameter("id");
	String password= request.getParameter("password");
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO dao = new UserDAO();
	UserVO result = dao.getUser(vo);
	if(result == null) {
		//일치하는 ID가 없는 경우
		out.print("<script>alert('id error'); history.go(-1); </script>");
	} else if( password.equals(result.getPassword()) ) {
		//패스워드 일치하는 경우
		//세션처리
		session.setAttribute("id", id);
		response.sendRedirect("getUser.jsp?id="+id);
	} else {
		//패스워드가 틀린 경우
		out.print("<script>alert('pw error'); history.go(-1); </script>");
	}
%>
