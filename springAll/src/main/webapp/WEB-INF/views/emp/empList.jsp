<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script>
$(function(){
	$(".empId").on("click", function(){
		var empid = $(this).html();
		var url = "getEmp/"+ empid;
		//$("#getEmpDiv").load(url)
		/*$.getJSON("getEmpAjax",{employeeId:empid}, function(result){
			$(".row").find(".col").eq(0).html(result.employeeId);
			$(".row").find(".col").eq(1).html(result.firstName);
			$(".row").find(".col").eq(2).html(result.email);
			$(".row").find(".col").eq(2).html(result.hireDate);
		});*/
		$.ajax({
			url : "getEmpAjax", 
			data : {employeeId:empid},
			method : 'get',
			dataType: 'json'
		}).done(function(result){
			$(".row").find(".col").eq(0).html(result.employeeId);
            $(".row").find(".col").eq(1).html(result.firstName);
            $(".row").find(".col").eq(2).html(result.email);
            $(".row").find(".col").eq(2).html(result.hireDate);
            console.log(result);
		})
		  .fail(function(){})
		  .always(function(){});
	});
});

</script>
<h3>사원목록</h3>
<div id="getEmpDiv">
    <div class="row">
        <div class="col">${emp.employeeId}</div>
        <div class="col">${emp.firstName} ${emp.lastName}</div>
        <div class="col">${emp.email}</div>
        <div class="col">${emp.hireDate}</div>
    </div>
</div>
<c:forEach items="${empList}" var="emp">
    <c:if test="${not empty emp.profile}">
        <img src="download?name=${emp.profile}" style="width:80px" onerror="this.src='resources/Penguins.jpg'">       
    </c:if>
    <c:if test="${not empty emp.profile}">
        <img src="resources/Penguins.jpg" style="width:80px" >       
    </c:if>           
        <a href="#" class="empId">${emp.employeeId}</a>
         ${emp.firstName}  ${emp.lastName} <br>
</c:forEach>