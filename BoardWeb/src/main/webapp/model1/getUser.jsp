
<%@page import="com.springbook.biz.user.UserVO"%>
<%@page import="com.springbook.biz.user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>getUser.jsp</title></head>
<body>
<%
//단건조회
String id=request.getParameter("id");
UserDAO dao = new UserDAO();
UserVO vo = new UserVO();
vo.setId(id);
UserVO user = dao.getUser(vo);
%>
<h3>회원정보 조회</h3>
id: <%=user.getId() %> <br>
pw: <%=user.getPassword() %> <br>
name: <%=user.getName() %> <br>
role: <%=user.getRole() %> <br>
</body>
</html>