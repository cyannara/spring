<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
</head>
<body>
<form:form command="userVO" action="insertUser" method="post">
	id:<form:input path="id"/><br>
	password:<form:input path="password"/><br>
	name:<form:input path="name"/><br>
	role:<form:select path="role">
		<form:option value="">선택</form:option>
		<form:options items="${roleOptions}"/>
	</form:select><br>
	<button>등록</button>
</form:form>
</body>
</html>