<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Hello, world!</title>
  </head>
  <body>
<h1>Hello, world!</h1>
<h3>자바스크립트로 제어</h3>
<button type="button" class="btn btn-primary" id="btnAjax">ajax</button>
<button type="button" class="btn btn-primary" id="btn1">dialog</button>
<button type="button" class="btn btn-primary" id="btn2">첫번째달</button>
<button type="button" class="btn btn-primary" id="btn3">두번째모달(가운데)</button>
<hr>
<h3>자바스크립트 없이 data속성으로 제어</h3>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#dialigTest">
  dialog
</button>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  첫번째달
</button>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
  두번째모달(가운데)
</button>


<div class="modal" tabindex="-1" role="dialog" id="dialigTest">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
          <button type="button" class="btn btn-primary" id="btn4">서브모달</button>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>



<!-- Modal   role="dialog"  aria-hidden="true" aria-labelledby="exampleModalLabel" -->
<div class="modal" id="exampleModal" tabindex="-1" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">첫번째</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <input>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal role="dialog"-->
<div class="modal" id="exampleModalCenter" tabindex="-1"  aria-labelledby="exampleModalCenterTitle" aria-hidden="true" >
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">두번째</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...<br><br><br><br><br><br><br><br><br><br>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="ajaxModal">
  <div class="modal-dialog">
    <div class="modal-content">
        <!-- remote ajax call이 되는영역 -->
    </div>
  </div>
</div>
<button type="button" id="manual-ajax">검색</button><br>



    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
    <link rel="stylesheet" href="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.css">    
    <script src="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.js"></script>
	<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
    <script>

    
	$("#btnAjax").on("click", function(){
			 $('#ajaxModal .modal-content').load("toastui.jsp", function(){
				 $('#ajaxModal').modal(
						 {  keyboard: false,backdrop : 'static'});
				  
				 //grid.refreshLayout();
				 //console.log(grid.getData(1));
			 });
/* 			
			$("#ajaxModal").empty();
			$("#modal").modal();
			//modal.load("tuigrid2.jsp", function(){	});
			$("#modal").load("toastui.jsp", function(){	}); */
		})
		
		$('#modal').on('hidden.bs.modal', function (e) {
			$("#modalDiv").empty();
		})
    
    	$("#btn1").on("click", function(){
    		console.log("aa")
    		$('#dialigTest').modal({
    			  show : true,
    			  keyboard: false,
    			  backdrop : 'static',
    			  focus : true
    		});
    	})
    	$("#btn2").on("click", function(){
    		$('#exampleModal').modal('show');
    		console.log("show event1111 - before");
    		
    	})
    	$("#btn3").on("click", function(){
    		$('#exampleModalCenter').modal();
    		console.log("show event2222 - before");
    	})
    	$("#btn4").on("click", function(){
    		$('#exampleModalCenter').modal();
    	})    	
    	$('#exampleModal').on('shown.bs.modal', function (e) {
		  console.log("show event1111");
		})

    </script>
    
  </body>
</html>