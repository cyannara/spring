<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', '부서');
        data.addColumn('number', '사원수');
        
        var chartdata = [];
        $.ajax({
        	url : "_____________",
        	async : false,   //동기식
        	success : function(result){
        		for(i=0; i<result.length; i++ ) {
        			chartdata.push( [ result[i].name,  parseInt(result[i].cnt) ]  );
        		}
        	}
        });         
        data.addRows(chartdata);

        // Set chart options
        var options = {'title':'부서별 인원수',
                       'width':800,
                       'height':300,
                       is3D: true,
                       vAxis: { format:'0,000',  gridlines: { count: 10 }  }, 
                       colors: ['#e0440e', 'yellow', '#ec8f6e', '#f3b49f', '#f6c7b6']
                      };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
        
        google.visualization.events.addListener(chart, 'select', selectHandler);

        function selectHandler(e) {
          var row = chart.getSelection()[0]["row"]
          var column = chart.getSelection()[0]["column"]
          console.log(chart.getSelection());
          
        }
      }
    </script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
  </body>
</html>
