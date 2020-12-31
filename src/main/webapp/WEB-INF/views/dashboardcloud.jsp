<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>


<!--Google font-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900|Roboto:100,300,400,500,700" rel="stylesheet"> 

<!-- <script type="text/javascript">
     google.charts.load('current', {'packages':['line']});
     google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	  var data = new google.visualization.DataTable();
          data.addColumn('number', 'Day');
          data.addColumn('number', '');
          
          <c:forEach var="item" items="${chartList}" varStatus="counter">
          data.addRows([
              [${counter.count},  ${item.number}]
          ]);
          </c:forEach>

          var options = {
            chart: {
              title: 'Weekly Report',
              subtitle: 'Number of Articles processed'
            },
            width: 550,
            height: 500
          };

          var chart = new google.charts.Line(document.getElementById('linechart_material'));

          chart.draw(data, google.charts.Line.convertOptions(options));
      }

      function drawChartAjax(chartList, id) {
    	  var data = new google.visualization.DataTable();
          data.addColumn('number', 'Day');
          data.addColumn('number', ''); 
          
          $.each(chartList, function(index, value){
        	  data.addRows([
                  [index,  value.number]
              ]); 

          });
          
          if(id == 1) {
        	
        	  var options = {
        	            chart: {
        	              title: 'Yearly Report',
        	              subtitle: 'Number of Articles processed'
        	            },
        	            width: 550,
        	            height: 500
        	          };
          }

          else if (id == 2) {
        	  
        	  var options = {
        	            chart: {
        	              title: 'Monthly Report',
        	              subtitle: 'Number of Articles processed'
        	            },
        	            width: 550,
        	            height: 500
        	          };
          }

          else if (id == 3) {
        	  var options = {
        	            chart: {
        	              title: 'Weekly Report',
        	              subtitle: 'Number of Articles processed'
        	            },
        	            width: 550,
        	            height: 500
        	          };
          }
               
          var chart = new google.charts.Line(document.getElementById('linechart_material'));

          chart.draw(data, google.charts.Line.convertOptions(options));
      }
    </script> -->
    
      <script type="text/javascript" src="/resources/static/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['line']});
      google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

      var data = new google.visualization.DataTable();
      data.addColumn('number', 'Day');
      data.addColumn('number', 'Guardians of the Galaxy');
      data.addColumn('number', 'The Avengers');
      data.addColumn('number', 'Transformers: Age of Extinction');

      data.addRows([
        [1,  37.8, 80.8, 41.8],
        [2,  30.9, 69.5, 32.4],
        [3,  25.4,   57, 25.7],
        [4,  11.7, 18.8, 10.5],
        [5,  11.9, 17.6, 10.4],
        [6,   8.8, 13.6,  7.7],
        [7,   7.6, 12.3,  9.6],
        [8,  12.3, 29.2, 10.6],
        [9,  16.9, 42.9, 14.8],
        [10, 12.8, 30.9, 11.6],
        [11,  5.3,  7.9,  4.7],
        [12,  6.6,  8.4,  5.2],
        [13,  4.8,  6.3,  3.6],
        [14,  4.2,  6.2,  3.4]
      ]);

      var options = {
        chart: {
//           title: 'Box Office Earnings in First Two Weeks of Opening',
//           subtitle: 'in millions of dollars (USD)'
        	 
        },
        //width: 900,
         height: 400,
         
        axes: {
          x: {
            0: {side: 'top'}
          }
        }
      };

      var chart = new google.charts.Line(document.getElementById('chartGraph'));

      chart.draw(data, google.charts.Line.convertOptions(options));
    }
  </script>
</head>
<%@ include file="/WEB-INF/includes/include.jsp" %>
<body>


<!--Main_part-->
<div class="main_part_outer" id="content">
  <div class="container-fluid">
    <!--main_tittle-->
    <div class="row">
       <div class="col-md-12">
           <div class="main_tittle">System Performance</div>
        </div>
     </div>
     <!--main_tittle_End-->
     
      <div class="row">
      <div class="col mb-4"> 
        <!-- small box -->
        <div class="small-box text-red d-flex align-items-center h-100 box-shadow" style="cursor: pointer;">
          	<h3>Length of the Queue  
            <span class="d-block text-capitalize text-small">
				queueLenth
			</span>
			<span class="d-block text-capitalize text-small">
				Articles in Queue
			</span>
            </h3>
              <div class="icon ml-auto">
              <img src="/resources/images/icon/Average-Quality-Score-icon.png" class="img-fluid">
              </div>
          </div>
      </div>
       <!-- ./col -->
      
      <div class="col mb-4"> 
        <!-- small box -->
        <div class="small-box text-blue d-flex align-items-center h-100 box-shadow" style="cursor: pointer;">
        	<h3>Avg. Time 
            <span class="d-block text-capitalize text-small">10min/Article</span>
            </h3>
            <div class="icon ml-auto">
            	<img src="/resources/images/icon/Average-TAT-icon.png" class="img-fluid">
            </div>
        </div>
      </div>
    
      
      <div class="col mb-4"> 
        <!-- small box -->
        <div class="small-box text-dark-green d-flex align-items-center h-100 box-shadow" style="cursor: pointer;">
          	<h3>Avg. Split: 10:19:12 am
            <span class="d-block text-capitalize text-small"> 03/Oct/2019</span>
            </h3>
          
            <div class="icon ml-auto">
            	<svg xmlns="https://www.w3.org/2000/svg"   data-name="Layer 1" viewBox="0 0 100 100" x="0px" y="0px" class="main-icon">
					<g data-name="Group">
						<path data-name="Compound Path" fill="#0f7e7d" d="M50,9.9A40.1,40.1,0,1,0,90.1,50,40.2,40.2,0,0,0,50,9.9ZM22.4,23.8l4.9,4.9,1.4-1.4-4.9-4.9A38,38,0,0,1,49,11.9v6.9h2V11.9A38,38,0,0,1,76.2,22.4l-4.9,4.9,1.4,1.4,4.9-4.9A38,38,0,0,1,88.1,49H81.2v2h6.9a37.9,37.9,0,0,1-2.6,13H58.8A8.8,8.8,0,0,0,51,55.3V36.7H49V55.3A8.8,8.8,0,0,0,41.2,64H14.6a37.9,37.9,0,0,1-2.6-13h6.9V49H11.9A38,38,0,0,1,22.4,23.8ZM50,57.2A6.8,6.8,0,1,1,43.2,64,6.8,6.8,0,0,1,50,57.2Zm0,30.9A38.2,38.2,0,0,1,15.4,66H41.5a8.7,8.7,0,0,0,17,0H84.6A38.2,38.2,0,0,1,50,88.1Z"></path>
					</g>
                    </svg>
            </div>
										
									</div>
      </div>
       <!-- ./col -->
       
    </div>
      <!--/*content_box*/-->
     	<div class="row">
     		 
               
             
                  
                   
        	<div class="col-12 col-md-4 col-lg-4">
            	 
                   <!-- ./col -->
                  
                  
                    <!-- small box -->
                    <div class="content_box box-shadow" style="cursor: pointer;">
                    <div class="box-header with-border"> <div class="box-title"> Content Processing Details</div></div>
                    <div class="box-body with-border">
                      <div class="inner">
                         
                        <ul>
                            <li class="w-100 mb-3 "> How Many Credit I have? <span class="badge badge-pill badge-warning">30</span></li>
                            <li class="w-100 mb-3"> How Many Articles I can process? <span class="badge badge-pill badge-warning">25</span></li>
                            <li class="w-100 mb-1"> How Many Days Remaining <span class="badge badge-pill badge-warning">150</span></li>
                        </ul>
                      </div>
                       
                      </div>
                    </div>  
                      <!-- small box -->
                   <div class="content_box box-shadow" style="cursor: pointer;">
                    <div class="box-header with-border"> <div class="box-title"> How many users logged in</div></div>
                    <div class="box-body with-border">
                      <div class="inner">
                
                        <ul>
                            <li class="w-100 mb-3 "> Users <span class="badge badge-pill badge-success">1</span></li>
                            <li class="w-100 mb-3 "> DTDs Live <span class="badge badge-pill badge-success">1</span></li>
                            <li class="w-100 mb-1 "> Imprints <span class="badge badge-pill badge-success">1</span></li>
                        </ul>
                      </div>
                      </div>
                     </div>
                     
                    
                  
                   <!-- ./col -->
                   
               
 </div>
            
            <div class="col-12 col-md-8 col-lg-8">
            	<div class="content_box box-shadow">
                  <!--box-header--> 
                    <div class="box-header with-border">
                    	<div class="row">
                       	  <div class="col-12">
                            	<div class="box-title">Total Articles Processed</div>
                            	<div id="chartGraph"></div>
                               <!--  <select class="form-control float-right" id="chart" onchange="getChart()">
                                    <option value="0">Select Action </option>
                                    <option value="1">Yearly Trend</option>
                                    <option value="2">Monthly Trend</option>
                                    <option value="3" selected="">Weekly Trend</option>
                                </select> -->
                            </div>
                        </div>
                  </div>
                  <!--box-header--> 
                  
                  
                    <!--box-body-->
                    <div class="box-body text-center" >
                    <div class="w-100" id="linechart_material"></div>
                    	<!-- <img src="/resources/img/Article-Processed-graph.png" class="img-fluid"> -->
                    </div>
                    <!--box-body--> 
                    <!--box-footer-->  
                       <!--<div class="box-footer text-right">
                       	<a href="#" class="btn-white-small"><img src="images/icon/send_notification_icon.png"><span> Send Reminder</span></a> 
                        <a href="#" class="btn-white-small"><img src="images/icon/export_sheet_icon.png"><span> Export Tasks List</span></a>
                       </div>-->
                        <!--box-footer--> 
                    </div>
            </div>
        </div>
      <!--/*content_box_end*/-->
     
     
  </div>
  

  
</div>

<script>
	$(function() {
		$('input[name="dates"]').daterangepicker({ startDate: moment(), endDate: moment().add(2, 'day')});
	})
	
	function getChart() {
		var index = $('#chart').val();
		$.ajax({
	          url : "chartdata-" +  index,
	          type: "get",
	          success : function(data) {
	        	  drawChartAjax(data.payload, index);
	          },
              error:function() {
                  
              }
	      });
	}  
</script>

</body>
</html>
