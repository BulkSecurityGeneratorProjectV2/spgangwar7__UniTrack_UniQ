
<%@ include file="/WEB-INF/includes/include.jsp" %>
<form name="mang" id="mang">
<div class="main_part_outer" id="content">
	<div class="d-flex flex-column w-100 h-100">
  	<div class="container-fluid">
    <!--main_tittle-->
    <div class="row">
       <div class="col-md-9">
           <div class="main_tittle">E-Proofing Stats Dashboard <span id="Date">Wednesday , 21 November 2018</span></div>
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
   
    
     <div class="row">
<div class="col-md-12">
<div class="content_box">
 <div class="box-body">
   <div id="contauth" style="min-width: 500px; height: 400px; margin: 0 auto"></div>
	</div>
	</div>
</div>
</div>
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



<!--Main_part_end-->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
  
  <script>
Highcharts.chart('contauth', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Stats For E-Proofing for on Delivered Article'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.y}</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.y} '
            }
        }
    },
    series: [{
        name: 'Brands',
        colorByPoint: true,
        data: [{
            name: 'E-Proofing Completed',
            y: 50,
            sliced: true,
            selected: true
        }, {
            name: 'E-Proofing In-Progress',
            y: 35
        }, {
            name: 'E-Proofing Not Started',
            y: 25
        }]
    }]
});

</script>