<%@page import="com.springbook.biz.user.UserDAO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>getUserList.jsp</title></head>
<body>
<%
//단건조회 
UserDAO dao = new UserDAO();
List<Map<String, Object>> list = dao.getUserList(); 
%>
<h3>회원정보 조회</h3>
<% for(Map user : list) { %>
<div style="border:1px solid blue;">
id: <%=user.get("id") %> <br>
pw: <%=user.get("password") %> <br>
name: <%=user.get("name") %> <br>
role: <%=user.get("role") %> <br>
</div>
<%} %>
</body>
</html>