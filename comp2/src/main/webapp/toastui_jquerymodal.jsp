<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="toastgridModal"> 
<button type="button" href="ajax.html" id="manual-ajax">검색</button><br>
<button id="btnSearch">조회</button>
<button id="btnSave">저장</button>
<div id="grid"></div>
<script>


$('#manual-ajax').on("click",matModal );

	function chooseComp(p){
		alert("===="+p.html());
	}

	
  var gridData;
/*    $.ajax({
	  async : false,
	  url : "ajax/EgovCcmCmmnCodeAll2",
	  success : function(result){
		  gridData = result.data.contents;
	  }
  });  */
  
  var dataSource = {
		  api: {
		    readData: { url: 'ajax/EgovCcmCmmnCodeAll2', method: 'GET' },
			updateData: { url: 'ajax/updateCode', method: 'PUT',
			      headers: { 'x-custom-header': 'custom-header' },
			      // 아래에 설정된 serializer 옵션이 공통 serializer 옵션보다 우선순위를 가진다.
			      serializer(params) {
			    	  alert('aaa');i
			        return Qs.stringify(params);
			      }  }, 
		  },  
		  
		  contentType : "application/json"
		};
  
 
  var option = {
		    el: document.getElementById('grid'),
		    data: dataSource,
		   //data : gridData,
		   // rowHeight : 20,
		   // minRowHeight : 20,
		    scrollX: false,
		    scrollY: true,
		    columns: [
		      {
		        header: 'codeId',
		        name: 'codeId',
		        editor: 'text'
		      },
		      {
		        header: 'codeIdNm',
		        name: 'codeIdNm',
		        editor: 'text'
		      },
		      {
		          header: 'check',
		          name: 'check',
		        //  editor: MyCheckboxRenderer
		       },
		      {
		        header: 'clCodeNm',
		        name: 'clCodeNm',
		        //editor: 'text'
		        hidden : true
		      },
		      {
		    	  header: 'codeDate',
		          name: 'codeDate',
		          editor: 'datePicker'
		    /* 	  editor: {
		    	      type: 'datePicker',
		    	      options: {
		    	        format: 'yyyy-MM-dd'
		    	      }
		    	    } */
		      }
		    ]
		  }
  var grid = new tui.Grid(option);

  tui.Grid.applyTheme('striped', { row: { hover: { background: '#00eeff',  } } })
  
  
  grid.on("click", function(ev){
	  console.log(ev);
	   /*  $.ajax({
		    // url: "main/getByteImage2.do?fileName=02.PNG",
		     url : "/main/down.do?fileName=02.PNG",		 
		     type: "GET",
		     dataType: "json",
		     success: function(base64string){
		    	 $("#myimage").attr("src", "data:image/jpg;base64," + base64string);
		     }
		});	*/	  
	  	//$("#myimage").attr("src", "main/down.do?fileName=02.PNG");
  });
	
  
  $("#btnSave").bind("click", function(){
	  //grid.request('updateData')
	 // console.log(grid.getModifiedRows({}));
  });
  
  $("#btnSearch").bind("click", function(){
	 // grid.readData();
	  grid.refreshLayout();
  });
  
/*   grid.on('beforeRequest', function(ev) {
	  // 요청을 보내기 전
	}).on('response', function(ev) {
	  // 성공/실패와 관계 없이 응답을 받았을 경우
		grid.refreshLayout();
	}).on('successResponse', function(ev) {
	  // 결과가 true인 경우
		grid.refreshLayout();
	}).on('failResponse', function(ev) {
	  // 결과가 false인 경우
	}).on('errorResponse', function(ev) {
	  // 오류가 발생한 경우
	}); */

</script>
<img id="myimage"/>
<button type="button" onclick="location.href='main/down.do?fileName=02.PNG'">파일다운</button>

</div>
