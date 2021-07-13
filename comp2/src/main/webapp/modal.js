/**
 * 
 */
function productModal(){
	    function addUser() { alert("aaaa")}

	    $("#toastgridModal").remove();

    	$.get("toastui_jquerymodal.jsp", function(data){
    		$(document.body).append(data);
    		$( "#toastgridModal" ).dialog({
        		   // autoOpen: false,
        		    height: 400,
        		    width: 350,
        		    modal: true,
        		    buttons: {
        		      "Create an account": addUser,
        		      Cancel: function() {
        		        dialog.dialog( "close" );
        		      }
        		    },
        		    close: function() {
        		      allFields.removeClass( "ui-state-error" );
        		    }
            }); 
    		
    	})
}

function matModal(){
	    
	    $("#matModal").remove();

    	$.get("tuigrid2.jsp", function(data){
    		$(document.body).append(data);
    		$( "#matModal" ).dialog({
        		    height: 400,
        		    width: 350,
        		    modal: true        		
            }); 
    		
    	})
}