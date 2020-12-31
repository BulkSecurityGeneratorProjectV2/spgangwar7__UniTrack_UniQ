<%@ include file="/WEB-INF/includes/include.jsp"%>

<style>
#container {
	height: 400px;
}

.highcharts-figure, .highcharts-data-table table {
	min-width: 310px;
	max-width: 800px;
	margin: 1em auto;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #EBEBEB;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}

.highcharts-data-table caption {
	padding: 1em 0;
	font-size: 1.2em;
	color: #555;
}

.highcharts-data-table th {
	font-weight: 600;
	padding: 0.5em;
}

.highcharts-data-table td, .highcharts-data-table th,
	.highcharts-data-table caption {
	padding: 0.5em;
}

.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even)
	{
	background: #f8f8f8;
}

.highcharts-data-table tr:hover {
	background: #f1f7ff;
}
</style>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<form name="mang" id="mang">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<button type="button" onclick="downloadExcel()"
				class="btn btn-dark btn-sm float-right ml-2">Download WIP
				Report</button>
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-9">
						<div class="main_tittle">
							<spring:message code="chapter.article" /> & <spring:message code="issue.book" /> <span id="Date">Wednesday , 21 November
								2018</span>
						</div>

					</div>


					<div class="wrapper">
						<div class="main_part_outer" id="content"
							style="padding-top: 8px;">
							<div class="d-flex flex-column w-100 h-100">
								<div class="container-fluid">
									<div class="row">
										<section class=col-md-4>
											<section>
												<label>Total Pages In <spring:message code="chapter.article" />:</label> ${totalPage}
											</section>
											<div id="container"></div>
										</section>
										<div class=" col-md-8 box-body bg-white">
											<div id="container1"></div>
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
</form>

<script>Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    credits: {
        enabled: false
    },
    title: {
        text: 'Articles  & Issues'
    },
    subtitle: {
        text: ''
    },
    xAxis: {
        type: 'category',
        labels: {
            rotation: -45,
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Articles  & Issues '
        }
    },
    legend: {
        enabled: false
    },
    tooltip: {
       
    },
    series: [{
        name: 'Total Numbers',
        data: [
            ['Total Article', ${totalArticle}],
          /*   ['Total Page', ${totalPage}], */
            ['Total Issue', ${totalIssue}]
          
        ],
        dataLabels: {
            enabled: true,
            rotation: -5,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y}', // one decimal
            y: 10, // 10 pixels down from the top
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    }]
});
</script>


<script type="text/javascript">
Highcharts.chart('container1', {
    chart: {
        type: 'column'
    },
    credits: {
        enabled: false
      },
    title: {
        text: 'User Productivity'
    },
    subtitle: {
        text: 'UniTouch Production Tracking system'
    },
    xAxis: {
        type: 'category',
        labels: {
            rotation: -45,
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    },
    yAxis: {
    tickInterval: 1,
        title: {
            text: 'Articles Delivered(No. Of articles)'
        }, 
        min: 0,
      
    },
    legend: {
        enabled: false
    },
    tooltip: {
        pointFormat: 'Articles Delivered on : <b>{point.y} Articles</b>'
    },
    series: [{
        name: 'Articles',
        data: [  
          
        	<c:forEach items="${productivityTask}" var="map">
          
              [' ${map.date}' ,  ${map.count}],
              
       		 </c:forEach> 
           
        ],
        dataLabels: {
            enabled: true,
            rotation: -5,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y}', // one decimal
            y: 10, // 10 pixels down from the top
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    }]
});
</script>

<script>

    
function downloadExcel() {
	debugger;
 //   alert("Cryeae");
	
	document.getElementById("mang").action = "WipUserWise";
	document.getElementById("mang").method = "GET";
	document.getElementById("mang").submit();	
}
</script>
