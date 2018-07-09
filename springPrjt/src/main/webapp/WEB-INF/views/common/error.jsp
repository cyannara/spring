<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html><head><title>기본 에러 화면</title></head>
<body bgcolor="#33ff33" text="red">
<h3>기본에러화면입니다.</h3><br><br><br><br>
<!-- 에러 메시지 -->
message : ${exception.message}
</body>
</html>