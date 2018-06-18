<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@page import="com.springbook.biz.user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html><html><head><title>getUserList.jsp</title></head>
<body>

<h3>model2: 회원목록 조회</h3>
<c:forEach items="${list}" var="user">
	<div style="border:1px solid blue;">
	id  : ${user.id} <br>
	pw  : ${user.password} <br>
	name: ${user.name}  <br>
	role: ${user.role} <br>
	</div>
</c:forEach>
</body>
</html>