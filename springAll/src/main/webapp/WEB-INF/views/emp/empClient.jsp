<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>

<script>
	$(function() {
		//목록
		$('#table_id').DataTable(
			{ajax:  { url : 'ajaxEmpList', dataSrc: '' } ,
			 columns: [
			        { data: "employeeId" },
			        { data: "firstName" },
			        { data: "lastName" }
			    ]});
	});
</script>
<div class="row">
	<div class="col">
		<div>목록</div>
		<div id="empList">
			<table id="table_id" class="display">
				<thead>
					<tr>
                        <th>employeeId</th>
						<th>firstName</th>
						<th>LastName</th>
					</tr>
				</thead>
			
			</table>
		</div>
	</div>
	<div class="col">
		<form>
			<div>
				<button class="btn btn-success">등록</button>
				<button class="btn btn-success">수정</button>
			</div>

			<input type="text" name="firstName"> <br> <input
				type="text" name="lastName">
		</form>
	</div>
</div>
