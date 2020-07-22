<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h1>사원등록</h1>
<form action="insertEmp" method="post" encType="multipart/form-data">
	firstName<input name="firstName"> <br>
	lastName<input name="lastName"><br> 
	email <input name="email"> <br>
	jobid<input name="jobId"><br> 
	hireDate<input name="hireDate"><br>
	이미지<input type="file" name="uploadFile"/><br>
	<button>등록</button>
</form>
