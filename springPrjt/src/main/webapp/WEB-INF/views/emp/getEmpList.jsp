<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html><head><title>emp/getEmpList.jsp</title></head>
<body>
<c:forEach items="${empList}" var="emp">
	${emp.employeeId}   ${emp.firstName}  
	${emp.lastName} ${emp.salary} <br>
</c:forEach>
</body>
</html>