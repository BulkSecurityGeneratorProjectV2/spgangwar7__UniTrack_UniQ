
<%@ include file="/WEB-INF/includes/include.jsp" %>
<!--Main_part-->
<div class="main_part_outer" id="content">






	<div class="d-flex flex-column w-100 h-100">
  	<div class="container-fluid">
    <!--main_tittle-->
    <div class="row">
       <div class="col-md-12">
           <div class="main_tittle">Graphics  Dashboard <span id="Date">Wednesday , 21 November 2018</span></div>
        </div>
     </div>
     <!--main_tittle_End-->
     
     <!--/*4 boxes*/-->
    
    <div class="row">
    
    <div class="col mb-4"> 
         <div class="h-100 boxContainer bg-green  border px-3 pt-4 pb-3">
			<div class="mainBox d-flex">
				<div class="boxContent">
					<h5 style="color: white;">Article Process</h5>
					<p class="numberBox">3</p>
				</div>
				<div class="boxLogo ml-auto">
					<img src="https://digitrack.digiscapetech.com/images/icon/inprogress_tasks_icon.png" class="img-fluid">
				</div>
			</div>
			<div class="boxFooter w-100">
				<a href="#" onclick="showAndHide('articalList')" class="d-flex text-white moreinfoBlock">More info <i class="fa fa-angle-right ml-auto"></i></a>
				
			</div>
		 </div>
        
      </div>
       <!-- ./col -->
      
     <div class="col mb-4"> 
         <div class="h-100 boxContainer bg-blue  border px-3 pt-4 pb-3">
			<div class="mainBox d-flex">
				<div class="boxContent">
					<h5 style="color: white;">In Queue</h5>
					<p class="numberBox">3</p>
				</div>
				<div class="boxLogo ml-auto"><img src="https://digitrack.digiscapetech.com/images/icon/total_tasks_icon.png" class="img-fluid"></div>
			</div>
			<div class="boxFooter w-100">
				<a href="#" onclick="showAndHide('inprocess')" class="d-flex text-white moreinfoBlock">More info <i class="fa fa-angle-right ml-auto"></i></a>
			</div>
		 </div>
        
      </div>
       <!-- ./col -->
       
      <div class="col mb-4"> 
         <div class="h-100 boxContainer bg-red border px-3 pt-4 pb-3">
			<div class="mainBox d-flex">
				<div class="boxContent">
					<h5 style="color: white;">Failed</h5>
					<p class="numberBox">3</p>
				</div>
				<div class="boxLogo ml-auto"><img src="resources/images/failed_tasks_icon.png" class="img-fluid"></div>
			</div>
			<div class="boxFooter w-100">
				<a href="#" onclick="showAndHide('overdue')" class="d-flex text-white moreinfoBlock">More info <i class="fa fa-angle-right ml-auto"></i></a>
			</div>
		 </div>
        
      </div>
    <!--   <div class="col mb-4"> 
         <div class="h-100 boxContainer bg-dark-green border px-3 pt-4 pb-3">
			<div class="mainBox d-flex">
				<div class="boxContent">
					<h5>Vector</h5>
					<p class="numberBox">3</p>
				</div>
				<div class="boxLogo ml-auto"><img src="resources/images/vector_image_icon.png" class="img-fluid"></div>
			</div>
			<div class="boxFooter w-100">
				<a href="#" class="d-flex text-white moreinfoBlock">More info <i class="fa fa-angle-right ml-auto"></i></a>
			</div>
		 </div>
        
      </div>
	  <div class="col mb-4"> 
         <div class="h-100 boxContainer bg-orange border px-3 pt-4 pb-3">
			<div class="mainBox d-flex">
				<div class="boxContent">
					<h5>Raster</h5>
					<p class="numberBox">3</p>
				</div>
				<div class="boxLogo ml-auto"><img src="resources/images/raster_images_icon.png" class="img-fluid"></div>
			</div>
			<div class="boxFooter w-100">
				<a href="#" class="d-flex text-white moreinfoBlock">More info <i class="fa fa-angle-right ml-auto"></i></a>
			</div>
		 </div>
        
      </div> -->
      
      
    
    </div>
    
    
    
    <div class="row" id="new_project">
	                <div class="col-md-12">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">Article Details</span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="articleTable">
											<thead class="table-head">
												<tr>
													<th>Article Title</th>
													<th>Journal Name</th>
													<th>Publisher Name</th>
													<th>Article DOI</th>
													<th>Article ID</th>
													<th>Article Type CD</th>
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						 <div class="row" id="inprocess_project">
	                <div class="col-md-12">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">InProgress Article</span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="inprocess">
											<thead class="table-head">
												<tr>
													<th>Article Title</th>
													<th>Journal Name</th>
													<th>Publisher Name</th>
													<th>Article DOI</th>
													<th>Article ID</th>
													<th>Article Type CD</th>
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						 <div class="row" id="overdue_project">
	                <div class="col-md-12">
	                
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">Overdue Article</span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="overdue">
											<thead class="table-head">
												<tr>
													<th>Article Title</th>
													<th>Journal Name</th>
													<th>Publisher Name</th>
													<th>Article DOI</th>
													<th>Article ID</th>
													<th>Article Type CD</th>
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
								</div>
								
							</div>
						</div>
				
     <div class="box-body">
     <div class="row">
     <div class="col-md-12">
           <div id="container"></div>
       </div>
       </div>
       </div>
    
      </div>
      </div>
      </div>
      
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<script type="text/javascript">

//Create the chart
Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Last 30days Productivity'
    },
    subtitle: {
        text: 'Source: UniTouch Production tracking system'
    },
    xAxis: {
        type: 'category'
    },
    yAxis: {
        title: {
            text: 'Article Processed (Article Count)'
        }

    },
    legend: {
        enabled: false
    },
    plotOptions: {
        series: {
            borderWidth: 3,
            dataLabels: {
                enabled: true,
                format: '{point.y:.1f}'
            }
        }
    },

    tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: 'Number of article processed: <b>{point.y}</b><br/>'
    },

    series: [
        {
            name: "Article Processed",
            colorByPoint: true,
            data: [
                {
                    name: "9/09/2019",
                    y: 12,
                    drilldown: "9/09/2019"
                },
                {
                    name: "7/09/2019",
                    y: 11,
                    drilldown: "7/09/2019"
                },
                {
                    name: "6/09/2019",
                    y: 12,
                    drilldown: "6/09/2019"
                },
                {
                    name: "5/09/2019",
                    y: 7,
                    drilldown: "5/09/2019"
                },
                {
                    name: "4/09/2019",
                    y: 9,
                    drilldown: "4/09/2019"
                },
                {
                    name: "3/09/2019",
                    y: 5,
                    drilldown: "3/09/2019"
                },
                {
                    name: "2/09/2019",
                    y: 11,
                    drilldown: "2/09/2019"
                },
                {
                    name: "31/08/2019",
                    y: 9,
                    drilldown: "31/08/2019"
                },
                {
                    name: "30/08/2019",
                    y: 11,
                    drilldown: "30/08/2019"
                },
                {
                    name: "28/08/2019",
                    y: 8,
                    drilldown: "29/08/2019"
                },
                {
                    name: "27/08/2019",
                    y: 9,
                    drilldown: "27/08/2019"
                },
               
                
                {
                    name: "27/08/2019",
                    y: 9,
                    drilldown: "27/08/2019"
                },
                {
                    name: "26/08/2019",
                    y: 6,
                    drilldown: "26/08/2019"
                },
               
                {
                    name: "24/08/2019",
                    y: 9,
                    drilldown: "24/08/2019"
                },
                {
                    name: "23/08/2019",
                    y: 6,
                    drilldown: "23/08/2019"
                },
                {
                    name: "22/08/2019",
                    y: 12,
                    drilldown: "22/08/2019"
                },
                {
                    name: "21/08/2019",
                    y: 7,
                    drilldown: "21/08/2019"
                },
                {
                    name: "20/08/2019",
                    y: 9,
                    drilldown: "20/08/2019"
                },
                {
                    name: "19/08/2019",
                    y: 10,
                    drilldown: "19/08/2019"
                },
                
                {
                    name: "17/08/2019",
                    y: 9,
                    drilldown: "17/08/2019"
                },
                {
                    name: "16/08/2019",
                    y: 6,
                    drilldown: "16/08/2019"
                },
                {
                    name: "15/08/2019",
                    y: 8,
                    drilldown: "15/08/2019"
                },
                {
                    name: "14/08/2019",
                    y: 11,
                    drilldown: "14/08/2019"
                },
                {
                    name: "13/08/2019",
                    y: 9,
                    drilldown: "13/08/2019"
                },
                {
                    name: "12/08/2019",
                    y: 7,
                    drilldown: "12/08/2019"
                },
                
                {
                    name: "10/08/2019",
                    y: 10,
                    drilldown: "10/08/2019"
                },
                
                
            ]
        }
    ],
    drilldown: {
        series: [
            {
                name: "Article Processed",
                id: "Chrome",
                data: [
                    [
                        "v65.0",
                        0.1
                    ],
                    [
                        "v64.0",
                        1.3
                    ],
                    [
                        "v63.0",
                        53.02
                    ],
                    [
                        "v62.0",
                        1.4
                    ],
                    [
                        "v61.0",
                        0.88
                    ],
                    [
                        "v60.0",
                        0.56
                    ],
                    [
                        "v59.0",
                        0.45
                    ],
                    [
                        "v58.0",
                        0.49
                    ],
                    [
                        "v57.0",
                        0.32
                    ],
                    [
                        "v56.0",
                        0.29
                    ],
                    [
                        "v55.0",
                        0.79
                    ],
                    [
                        "v54.0",
                        0.18
                    ],
                    [
                        "v51.0",
                        0.13
                    ],
                    [
                        "v49.0",
                        2.16
                    ],
                    [
                        "v48.0",
                        0.13
                    ],
                    [
                        "v47.0",
                        0.11
                    ],
                    [
                        "v43.0",
                        0.17
                    ],
                    [
                        "v29.0",
                        0.26
                    ]
                ]
            },
            {
                name: "Firefox",
                id: "Firefox",
                data: [
                    [
                        "v58.0",
                        1.02
                    ],
                    [
                        "v57.0",
                        7.36
                    ],
                    [
                        "v56.0",
                        0.35
                    ],
                    [
                        "v55.0",
                        0.11
                    ],
                    [
                        "v54.0",
                        0.1
                    ],
                    [
                        "v52.0",
                        0.95
                    ],
                    [
                        "v51.0",
                        0.15
                    ],
                    [
                        "v50.0",
                        0.1
                    ],
                    [
                        "v48.0",
                        0.31
                    ],
                    [
                        "v47.0",
                        0.12
                    ]
                ]
            },
            {
                name: "Internet Explorer",
                id: "Internet Explorer",
                data: [
                    [
                        "v11.0",
                        6.2
                    ],
                    [
                        "v10.0",
                        0.29
                    ],
                    [
                        "v9.0",
                        0.27
                    ],
                    [
                        "v8.0",
                        0.47
                    ]
                ]
            },
            {
                name: "Safari",
                id: "Safari",
                data: [
                    [
                        "v11.0",
                        3.39
                    ],
                    [
                        "v10.1",
                        0.96
                    ],
                    [
                        "v10.0",
                        0.36
                    ],
                    [
                        "v9.1",
                        0.54
                    ],
                    [
                        "v9.0",
                        0.13
                    ],
                    [
                        "v5.1",
                        0.2
                    ]
                ]
            },
            {
                name: "Edge",
                id: "Edge",
                data: [
                    [
                        "v16",
                        2.6
                    ],
                    [
                        "v15",
                        0.92
                    ],
                    [
                        "v14",
                        0.4
                    ],
                    [
                        "v13",
                        0.1
                    ]
                ]
            },
            {
                name: "Opera",
                id: "Opera",
                data: [
                    [
                        "v50.0",
                        0.96
                    ],
                    [
                        "v49.0",
                        0.82
                    ],
                    [
                        "v12.1",
                        0.14
                    ]
                ]
            }
        ]
    }
});


</script>


<script>

function showAndHide(val){
	//alert(val)
	if(val=='inprocess'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "block";
		document.getElementById("overdue_project").style.display = "none";
		
	}
	else if(val=='overdue'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "block";
	}
	
	else if(val=='articalList'){
		document.getElementById("new_project").style.display = "block";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
	}
	
	else if(val==''){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
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
} );
    
</script>