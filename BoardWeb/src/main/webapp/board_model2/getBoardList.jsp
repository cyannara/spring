<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html><head><title>getBoardList.jsp</title>
</head>
<body><h3>모델2: 게시판 목록</h3>
<c:forEach items="${list}" var="board">
	${board.seq} ${board.title}  <br>
</c:forEach>
</body>
</html>