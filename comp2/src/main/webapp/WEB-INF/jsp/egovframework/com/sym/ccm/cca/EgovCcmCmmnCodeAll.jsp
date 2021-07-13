<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>
<script>
$(function(){
	$(document).ready( function () {
	    $('#codeList').DataTable({
	    	 ajax: {
	    	        url: 'ajax/EgovCcmCmmnCodeAll',
	    	        dataSrc: 'codes'
	    	    },
	    	    columns: [  { data: 'codeId' },
			    	        { data: 'codeIdNm' },
			    	        { data: 'codeIdDc' },
			    	        { data: 'clCodeNm' }]
			    });
	} );
})
</script>
</head>
<body>
<h3>공통코드 리스트</h3>
<table id="codeList">
	<thead>
		<tr><th>코드ID</th><th>코드ID명</th><th>코드ID설명</th><th>분류코드명</th></tr>
	</thead>
	<tbody></tbody>
</table>
</body>
</html>