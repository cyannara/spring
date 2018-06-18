<%@page import="com.springbook.biz.user.UserVO"%>
<%@page import="com.springbook.biz.user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>getUser.jsp</title></head>
<body>
<h3>model2: 회원정보 조회</h3>
id  : ${user.id} <br>
pw  : ${user.password} <br>
name: ${user.name} <br>
role: ${user.role} <br>
</body>
</html>