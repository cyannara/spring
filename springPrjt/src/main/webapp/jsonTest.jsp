<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><title>webapp/jsonTest.jsp</title>
<script>
	obj = {id:"chichi", name:"홍길동"}
	str = JSON.stringify(obj);  //object -> string
	document.write(str);
	document.write("<hr>");
	document.write(typeof str);
	document.write("<hr>");
	document.write(typeof obj);
	
	result = JSON.parse(str);   // string -> object 
	document.write("<hr>"+result.name);
</script>
</head>
<body>

</body>
</html>