
<%@ include file="/WEB-INF/includes/include.jsp" %>
<!--Main_part-->
<div class="main_part_outer" id="content">






	<div class="d-flex flex-column w-100 h-100">
  	<div class="container-fluid">
    <!--main_tittle-->
    <div class="row">
       <div class="col-md-12">
           <div class="main_tittle">${name} Dashboard <span id="Date">Wednesday , 21 November 2018</span></div>
        </div>
     </div>
     <!--main_tittle_End-->
     
     <!--/*4 boxes*/-->
    
    <div class="row">
      <div class="col mb-4"> 
        <!-- small box -->
        <div class="small-box text-red d-flex align-items-center h-100 box-shadow" style="cursor: pointer;">
          	<h3> My Task
            <span class="d-block text-capitalize text-small"><h3>${taskManagementVoc.size()}</h3><a href="/mytask"> <i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
              <div class="icon ml-auto">
              	<svg xmlns="https://www.w3.org/2000/svg" data-name="Layer 1" viewBox="0 0 100 100" x="0px" y="0px" class="main-icon">
					<g data-name="Group">
						<path data-name="Compound Path" d="M50,9.9A40.1,40.1,0,1,0,90.1,50,40.2,40.2,0,0,0,50,9.9ZM22.4,23.8l4.9,4.9,1.4-1.4-4.9-4.9A38,38,0,0,1,49,11.9v6.9h2V11.9A38,38,0,0,1,76.2,22.4l-4.9,4.9,1.4,1.4,4.9-4.9A38,38,0,0,1,88.1,49H81.2v2h6.9a37.9,37.9,0,0,1-2.6,13H58.8A8.8,8.8,0,0,0,51,55.3V36.7H49V55.3A8.8,8.8,0,0,0,41.2,64H14.6a37.9,37.9,0,0,1-2.6-13h6.9V49H11.9A38,38,0,0,1,22.4,23.8ZM50,57.2A6.8,6.8,0,1,1,43.2,64,6.8,6.8,0,0,1,50,57.2Zm0,30.9A38.2,38.2,0,0,1,15.4,66H41.5a8.7,8.7,0,0,0,17,0H84.6A38.2,38.2,0,0,1,50,88.1Z"/>
					</g>
                    </svg>
              </div>
          </div>
      </div>
       <!-- ./col -->
      
      <div class="col mb-4"> 
        <!-- small box -->
        <div class="small-box text-blue d-flex align-items-center h-100 box-shadow" style="cursor: pointer;">
        	<h3>Department Task 
            <span class="d-block text-capitalize text-small"><h3>${taskManagementVo.size()}</h3><a href="/grouptask"><i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
            <div class="icon ml-auto">
            	<svg xmlns="https://www.w3.org/2000/svg" xmlns:xlink="https://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve" class="main-icon"><g><path fill="#ff0000" d="M18.416,62.788c1.746,0,3.143-1.411,3.143-3.149c0-0.246-0.071-0.459-0.13-0.692L79.435,7.721l1.44,1.466   l1.629-6.504l-6.516,1.585l1.744,1.76L20.019,56.992c-0.492-0.291-0.996-0.491-1.601-0.491c-1.731,0-3.143,1.413-3.143,3.138   C15.273,61.377,16.684,62.788,18.416,62.788z M18.416,58.882c0.418,0,0.751,0.346,0.751,0.757c0,0.425-0.333,0.749-0.751,0.749   c-0.406,0-0.753-0.324-0.753-0.749C17.665,59.228,18.01,58.882,18.416,58.882z"/><path fill="#1b8ce2" d="M95.485,94.777h-2.267h-8.638V20.936c0-2.871-2.32-5.207-5.192-5.207c-2.855,0-5.178,2.336-5.178,5.207   v73.838h-4.537V32.893c0-2.857-2.321-5.178-5.208-5.178c-2.854,0-5.179,2.321-5.179,5.178v61.884h-4.555V47.27   c0-2.868-2.307-5.199-5.178-5.199c-2.856,0-5.189,2.331-5.189,5.199v47.507h-4.544V59.271c0-2.88-2.32-5.187-5.192-5.187   c-2.871,0-5.176,2.307-5.176,5.187v35.507h-4.557V73.619c0-2.865-2.305-5.183-5.192-5.183c-2.854,0-5.174,2.317-5.174,5.183v21.158   H6.77H4.513c-0.674,0-1.195,0.541-1.195,1.21c0,0.649,0.521,1.18,1.195,1.18h2.252h86.457h2.264c0.665,0,1.197-0.53,1.197-1.18   C96.683,95.318,96.15,94.777,95.485,94.777z M76.606,20.936c0-1.55,1.255-2.8,2.782-2.8c1.544,0,2.803,1.25,2.803,2.8v73.805   h-5.585V20.936z M61.683,32.893c0-1.529,1.255-2.779,2.783-2.779c1.545,0,2.802,1.25,2.802,2.779v61.848h-5.585V32.893   L61.683,32.893z M46.768,47.27c0-1.55,1.242-2.8,2.785-2.8c1.544,0,2.797,1.25,2.797,2.8v47.471h-5.58V47.27H46.768z    M31.859,59.271c0-1.537,1.239-2.804,2.768-2.804c1.544,0,2.8,1.267,2.8,2.804v35.471h-5.565V59.271H31.859z M16.917,73.619   c0-1.529,1.254-2.799,2.782-2.799c1.547,0,2.801,1.27,2.801,2.799v21.122h-5.581V73.619H16.917z"/></g></svg>
            </div>
        </div>
      </div>
       <!-- ./col -->
       
      <div class="col mb-4"> 
        <!-- small box -->
        <div class="small-box text-orange d-flex align-items-center h-100 box-shadow" style="cursor: pointer;">
            <h3>Overdue task
            <span class="d-block text-capitalize text-small"><h3>${taskScheduler.size()}</h3> <a href="/overDuetaskList"><i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
            <div class="icon ml-auto">
            	<svg xmlns="https://www.w3.org/2000/svg" xmlns:xlink="https://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve" class="main-icon"><g>
					<path fill="#000000" d="M59.445,53.682L83.99,29.138c-0.426-0.688-0.871-1.362-1.336-2.022L57.506,52.264L59.445,53.682z"/>
					<path fill="#000000" d="M55.287,50.645l25.722-25.724c-0.5-0.617-1.022-1.212-1.558-1.798L53.35,49.227L55.287,50.645z"/>
					<path fill="#000000" d="M71.656,16.52l-20.26,20.26v3.36l22.244-22.245C72.994,17.417,72.332,16.959,71.656,16.52z"/>
					<path fill="#000000" d="M67.037,13.944l-15.641,15.64v3.359l17.867-17.864C68.535,14.677,67.791,14.302,67.037,13.944z"/>
					<path fill="#000000" d="M61.866,11.921l-10.47,10.468v3.356l12.963-12.963C63.542,12.466,62.708,12.184,61.866,11.921z"/>
					<path fill="#000000" d="M56.016,10.575l-4.619,4.618v3.356l7.447-7.448C57.913,10.89,56.968,10.719,56.016,10.575z"/>
					<path fill="#000000" d="M75.788,19.585L51.396,43.978v3.36l26.154-26.155C76.979,20.635,76.393,20.099,75.788,19.585z"/>
					<path fill="#000000" d="M51.396,10.144v1.209l1.155-1.156C52.168,10.173,51.782,10.157,51.396,10.144z"/>
					<path fill="#000000" d="M63.605,56.723l22.869-22.868c-0.342-0.769-0.703-1.526-1.092-2.268L61.666,55.305L63.605,56.723z"/>
					<path fill="#000000" d="M71.932,62.803l17.664-17.664c-0.119-0.979-0.267-1.948-0.455-2.903L69.99,61.385L71.932,62.803z"/>
					<path fill="#000000" d="M67.77,59.762l20.619-20.617c-0.242-0.862-0.508-1.715-0.808-2.552L65.829,58.346L67.77,59.762z"/>
					<path fill="#000000" d="M80.253,68.884l8.187-8.187c0.393-1.404,0.709-2.84,0.944-4.303l-11.069,11.07L80.253,68.884z"/>
					<path fill="#000000" d="M89.871,48.708L74.15,64.427l1.94,1.417l13.751-13.75c0.035-0.693,0.061-1.39,0.061-2.093   C89.902,49.567,89.884,49.138,89.871,48.708z"/>
					<path fill="#000000" d="M83.666,71.378c0.936-1.466,1.777-2.996,2.518-4.583l-3.711,3.711L83.666,71.378z"/>
					<path fill="#fd570a" d="M48.439,49.5V10.027c-21.31,0.792-38.405,18.365-38.405,39.866c0,22.003,17.899,39.902,39.903,39.902   c13.006,0,24.583-6.26,31.872-15.926c0,0,0-0.001,0.002-0.001L48.46,49.5H48.439z"/></g></svg>
            </div>
         </div>
      </div>
      
     
       
    </div>
    
    
    
    <div class="row">
							<div class="col-md-12">
									<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0" id="deptTable">
											<thead class="table-head">
												<tr>
													<th>S.No.</th>
													
													<th>Article ID</th>
													<th>Journal Abbreviation Name</th>
													<th>Title</th>
													<th>Task Name</th>
													<th>Stage</th>
													<th>Schedule Start Date</th>
													<th>Schedule End Date</th>
<!-- 													<th>Actual Start Date</th> -->
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${taskScheduler}" varStatus="counter"> 
													
													<tr>
														<td align="center">${counter.count}</td>
														<td align="center">${temp.aid}</td>
														<td align="center">${temp.journalAbbrName}</td>
														<td>${temp.article_title}</td>
														<td>${temp.taskName}</td>
														<td>${temp.task_status}</td>
														<td><fmt:formatDate pattern="dd-MM-yyyy" value="${temp.sch_start_time}" /></td>
														<td><fmt:formatDate pattern="dd-MM-yyyy" value="${temp.sch_end_time}" /></td>
<%-- 														<td><fmt:formatDate pattern="dd-MM-yyyy" value="${temp.start_date_time}" /></td> --%>
														<td align="center">
														<input type="hidden" name="article_id_${temp.article_task_id}" id="article_id" value="${temp.article_id}">
														<input type="hidden" name="article_task_id" id="article_task_id" value="${temp.article_task_id}"> 
<%-- 														<input type="hidden" name="journalId" id="journalId" value="${temp.journalId}"> --%>
													  <a href="#" class="btn btn-outline-success btn-sm" onclick="StartMYTask(${temp.article_task_id})"> Start </a> 
														<!-- <a href="/unitouchLogo" class="btn btn-outline-success btn-sm" > Start </a> -->
														</td>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
     <!--/*4 boxes end*/-->
     
     
     <!--/*content_box*/-->
     	<div class="row">
        	<div class="col-12 col-md-12 col-lg-12">
            	<!--content_box--> 
            	<div class="content_box">
                  <!--box-header--> 
                    <div class="box-header with-border">
                    	<div class="row">
                       	  
                  </div>
                  <!--box-header--> 
                  
                  
                    <!--box-body-->
                    <div class="box-body">
                
                    
              
                                         <div id="container"></div>
                    </div>
                    <!--box-body--> 
                    <!--box-footer-->  
                       <!--<div class="box-footer text-right">
                       	<a href="#" class="btn-white-small"><img src="resources/images/icon/send_notification_icon.png"><span> Send Reminder</span></a> 
                        <a href="#" class="btn-white-small"><img src="resources/images/icon/export_sheet_icon.png"><span> Export Tasks List</span></a>
                       </div>-->
                        <!--box-footer--> 
                    </div>
               <!--content_box--> 
            </div>
            
        
     
     
  </div>
   </div>
  
</div>


<!--Main_part_end-->

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
<!-- <script>
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
            text: 'Article Processed (Article Count)'
        }
    },
    legend: {
        enabled: false
    },
    tooltip: {
        pointFormat: 'Number of article processed: <b>{point.y}</b>'
    },
    series: [{
        name: 'Article Processed',
        data: [
        	  <c:forEach items="${categoryList}" var="entry">
  	         ['${entry.key}',${entry.value}],
  	           </c:forEach> 
        ],
        dataLabels: {
            enabled: true,
            rotation: -90,
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

</script> -->