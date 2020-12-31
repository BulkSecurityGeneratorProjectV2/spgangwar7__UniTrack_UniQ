
<%@ include file="/WEB-INF/includes/include.jsp" %>
<form name="mang" id="mang">
<div class="main_part_outer" id="content">
	<div class="d-flex flex-column w-100 h-100">
  	<div class="container-fluid">
    <!--main_tittle-->
    <div class="row">
       <div class="col-md-9">
           <div class="main_tittle">Supplier Pending Dashboard <span id="Date">Wednesday , 21 November 2018</span></div>
        <%--    <c:if test="${deptID eq null}">
           <h6></h6>
           </c:if>
             <c:if test="${deptID ne null}">
             <h6>Stat's for ${deptID}</h6>
             </c:if> --%>
        </div>
     <!--main_tittle_End-->
     
     <!--/*4 boxes*/-->
    
 


<div class="wrapper">
	<div class="main_part_outer" id="content" style="
    padding-top: 8px;">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<script src="https://code.highcharts.com/highcharts.js"></script>
				<script src="https://code.highcharts.com/modules/data.js"></script>
				<script src="https://code.highcharts.com/modules/drilldown.js"></script>
				<script src="https://code.highcharts.com/modules/exporting.js"></script>
				<script src="https://code.highcharts.com/modules/export-data.js"></script>
             
               
      <!--/*content_box_end*/-->
     <div class="row">
					<div class="col-md-12">
						<div class="content_box">
							<div class="box-body">
								<div id="containerpie" style="min-width: 310px; max-width: 600px; height: 400px; margin: 0 auto"></div>
							</div>
						</div>
					</div>
				</div>

				
				<!-- <div class="row">


					<div class="col-md-6">
						<div class="content_box">
							<div class="box-body">
								<div id="containerpie" style="min-width: 310px; max-width: 600px; height: 400px; margin: 0 auto"></div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="content_box">
							<div class="box-body">
								<div id="containerbar" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
							</div>
						</div>
					</div>
				</div> -->
     
     
  </div>
  

  

				
				
			</div>
		</div>
		</div>
	</div>
</div>
</div></div>
</form>
<script src="resources/js/drildownmis.js"></script>
<script src="resources/js/drildownmis2.js"></script>
<script src="resources/js/drildownmis3.js"></script>

<script type="text/javascript">
function showproject(){
		document.getElementById("mang").action="/dashboard";
		document.getElementById("mang").method="POST";
		document.getElementById("mang").submit();
	}
	
function showAndHide(val){
	//alert(val)
	if(val=='inprocess'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "block";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
		
	}
	else if(val=='overdue'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "block";
		document.getElementById("complete_project").style.display = "none";
	}
	
	else if(val=='articalList'){
		document.getElementById("new_project").style.display = "block";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
	}
	else if(val=='complete'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "block";
	}
	else if(val==''){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
	}
}


</script>
<script type="text/javascript">

$(document).ready(function() {
    $('#overdue').DataTable();
} );
$(document).ready(function() {
    $('#completeArticle').DataTable();
} );
$(document).ready(function() {
    $('#inprocess').DataTable();
} );
$(document).ready(function() {
	document.getElementById("new_project").style.display = "none";
	document.getElementById("inprocess_project").style.display = "none";
	document.getElementById("overdue_project").style.display = "none";
	document.getElementById("complete_project").style.display = "none";
} );
    
</script>
<!--Main_part_end-->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
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