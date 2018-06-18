<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><title>userInsert.jsp</title>
</head>
<body>
<h3>회원수정</h3>
<form action="updateUser.do">
	id:<input type="text" name="id" value="${user.id}"/>
	password:<input type="text" name="password" />
	name:<input type="text" name="name" />
	role:<input type="text" name="role" />
	<input type="submit" value="로그인" />	
</form>
</body>
</html>