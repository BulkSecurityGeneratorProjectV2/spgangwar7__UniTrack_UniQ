<%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
				<form name="mang" id="mang">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2"><spring:message code="chapter.article" /> Load</span> <span id="Date">Mon
									, 26 Aug 2019</span>
									<span class="ml-auto">
											        
				<%--   <form:select cssClass="custom-select" path="deptDetails" name="deptID" id="inputGroupSelect02" action="/dashboard">
        
					   
					    <c:if test="${deptID eq null}">
					      <option value="">${DeptNameBy}</option>
					    </c:if>
					     <c:if test="${deptID ne null}">
					     <option value="">${DeptNameBy}</option>
					    </c:if>
					   
					    <c:forEach items="${deptDetails}" var="s">
					        
					            	 <option value="${s.deptID}">${s.groupName}</option>
					           
					    </c:forEach>
					
				
				
					</form:select>
									 --%>
									</span>
								<!-- 	<span class="pull-right">
                               
			    <a class="input-group-text" href="javascript:;"  onclick="showproject();">View</a>
			 
                    </span> -->
							</div>
						</div>	
					</div>


				<div class="row">
					<div class="col-md-12">
						<div class="content_box">
							<div class="box-body bg-white">
							<div class="row">
								<div class="col-md-12">
									<div id="container"></div>
								</div>
								<!-- <div class="col-md-6">
									<div id="containersec"></div>
								</div> -->
								</div>
							</div>
						</div>
					</div>
				</div>



            </form>
			</div>
			
			
			</div>
		</div>
	</div>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script>

 //var record = ${avilabelLode};
/*var avil =${totalLode}; */
Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Day Wise Load (Actual)'
    },
   
    

    xAxis: {
        categories: [
        	<c:forEach items="${deptDetails}" var="entry">
            [  '${entry.roleName}' ],
           </c:forEach>
        ],
        crosshair: true
    },



    
    yAxis: {
        min: 0,
        title: {
            text: 'Available Load Actual'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.f}</b></td></tr>',
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
        name: 'Capacity',
        
        data: [<c:forEach items="${totelLoad}" var="entry">${entry.totalLoadCount},</c:forEach>],
       

    },

    {
        name: 'Load',
        data: [ <c:forEach items="${avilabelLoad}" var="entry">${entry.totalLoadCount},</c:forEach>]

    }, 

    ]
});
</script>






<script>
 //var record = ${avilabelLode};
 /*var avil =${totalLode}; */
Highcharts.chart('containersec', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Monthly Total Load'
    },
   
    xAxis: {


    	categories: [
        	<c:forEach items="${totelLoad}" var="entry">
            [  '${entry.dname}' ],
           </c:forEach>
        ],
        crosshair: true
    },
        
    yAxis: {
        min: 0,
        title: {
            text: 'Total Load'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.f}</b></td></tr>',
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
        name: 'Article',
        data:[ <c:forEach items="${totelLoad}" var="entry">${entry.totalLoadCount},</c:forEach> ],
       

    },]
});
</script>


<script type="text/javascript">
function showproject(){
		document.getElementById("mang").action="/viewLoadRecordDepartmrntWise";
		document.getElementById("mang").method="POST";
		document.getElementById("mang").submit();
	}

</script>
  
 