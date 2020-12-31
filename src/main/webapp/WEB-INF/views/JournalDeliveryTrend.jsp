
<%@ include file="/WEB-INF/includes/include.jsp" %>
<form name="mang" id="mang">
<div class="main_part_outer" id="content">
	<div class="d-flex flex-column w-100 h-100">
  	<div class="container-fluid">
    <!--main_tittle-->
    <div class="row">
       <div class="col-md-9">
           <div class="main_tittle">Journals Delivery Trend <span id="Date">Wednesday , 21 November 2018</span></div>
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
								<div id="JournalDeliveryTrend" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
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
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
    <script type="text/javascript">
    Highcharts.chart('JournalDeliveryTrend', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'A&A Journal - Delivery Trend - WK39'
        },
       
        xAxis: {
            categories: [
                'Proof in preparation',
                'Proof being corrected',
                'Intermediate proof in preparation',
                'Intermediate proof being corrected',
                'Dataset'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'No. of Articles'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: 'Processed on-time',
            data: [11, 4, 11, 16, 18]

        }, {
            name: 'Processed late',
            data: [0,0,0,0,1]

        }]
    });
    </script>