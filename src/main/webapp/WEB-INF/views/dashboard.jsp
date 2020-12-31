<%@ include file="/WEB-INF/includes/include.jsp"%>
<!--Main_part-->
<form name="mang" id="mang">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-12">
						<div class="main_tittle">
							Dashboard <span id="Date"></span>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col mb-4">
						<!-- small box -->
						<div
							class="small-box bg-dark-green-gradient d-flex align-items-center h-100 text-white">
							<h3 style="color: white;">
								My Task : ${taskScheduler.size()} <span
									class="d-block text-capitalize text-small mt-3"><a
									style="color: white;" href="${context}/mytask"> More info <i
										class="fa fa-long-arrow-right"></i>
								</a></span>
							</h3>
							<div class="icon ml-auto">
								<svg xmlns="https://www.w3.org/2000/svg" data-name="Layer 1"
									viewBox="0 0 100 100" x="0px" y="0px" class="main-icon">
					<g data-name="Group">
						<path data-name="Compound Path"
										d="M50,9.9A40.1,40.1,0,1,0,90.1,50,40.2,40.2,0,0,0,50,9.9ZM22.4,23.8l4.9,4.9,1.4-1.4-4.9-4.9A38,38,0,0,1,49,11.9v6.9h2V11.9A38,38,0,0,1,76.2,22.4l-4.9,4.9,1.4,1.4,4.9-4.9A38,38,0,0,1,88.1,49H81.2v2h6.9a37.9,37.9,0,0,1-2.6,13H58.8A8.8,8.8,0,0,0,51,55.3V36.7H49V55.3A8.8,8.8,0,0,0,41.2,64H14.6a37.9,37.9,0,0,1-2.6-13h6.9V49H11.9A38,38,0,0,1,22.4,23.8ZM50,57.2A6.8,6.8,0,1,1,43.2,64,6.8,6.8,0,0,1,50,57.2Zm0,30.9A38.2,38.2,0,0,1,15.4,66H41.5a8.7,8.7,0,0,0,17,0H84.6A38.2,38.2,0,0,1,50,88.1Z" />
					</g>
                    </svg>
							</div>
						</div>
					</div>
					<%-- <c:if test="${issueScheduler.size()!=0}"> --%>
					<div class="col mb-4">
						<!-- small box -->
						<div
							class="small-box bg-blue-gradient d-flex align-items-center h-100 text-white">
							<h3 style="color: white;">
								Issue Task : ${issueScheduler.size()} <span
									class="d-block text-capitalize text-small  mt-3"> <a
									style="color: white;" href="${context}/issueMyTask">More
										info <i class="fa fa-long-arrow-right"></i>
								</a></span>
							</h3>
							<div class="icon ml-auto">
								<svg xmlns="https://www.w3.org/2000/svg"
									xmlns:xlink="https://www.w3.org/1999/xlink" version="1.1"
									x="0px" y="0px" viewBox="0 0 100 100"
									enable-background="new 0 0 100 100" xml:space="preserve"
									class="main-icon">
									<g>
									<path
										d="M18.416,62.788c1.746,0,3.143-1.411,3.143-3.149c0-0.246-0.071-0.459-0.13-0.692L79.435,7.721l1.44,1.466   l1.629-6.504l-6.516,1.585l1.744,1.76L20.019,56.992c-0.492-0.291-0.996-0.491-1.601-0.491c-1.731,0-3.143,1.413-3.143,3.138   C15.273,61.377,16.684,62.788,18.416,62.788z M18.416,58.882c0.418,0,0.751,0.346,0.751,0.757c0,0.425-0.333,0.749-0.751,0.749   c-0.406,0-0.753-0.324-0.753-0.749C17.665,59.228,18.01,58.882,18.416,58.882z" />
									<path
										d="M95.485,94.777h-2.267h-8.638V20.936c0-2.871-2.32-5.207-5.192-5.207c-2.855,0-5.178,2.336-5.178,5.207   v73.838h-4.537V32.893c0-2.857-2.321-5.178-5.208-5.178c-2.854,0-5.179,2.321-5.179,5.178v61.884h-4.555V47.27   c0-2.868-2.307-5.199-5.178-5.199c-2.856,0-5.189,2.331-5.189,5.199v47.507h-4.544V59.271c0-2.88-2.32-5.187-5.192-5.187   c-2.871,0-5.176,2.307-5.176,5.187v35.507h-4.557V73.619c0-2.865-2.305-5.183-5.192-5.183c-2.854,0-5.174,2.317-5.174,5.183v21.158   H6.77H4.513c-0.674,0-1.195,0.541-1.195,1.21c0,0.649,0.521,1.18,1.195,1.18h2.252h86.457h2.264c0.665,0,1.197-0.53,1.197-1.18   C96.683,95.318,96.15,94.777,95.485,94.777z M76.606,20.936c0-1.55,1.255-2.8,2.782-2.8c1.544,0,2.803,1.25,2.803,2.8v73.805   h-5.585V20.936z M61.683,32.893c0-1.529,1.255-2.779,2.783-2.779c1.545,0,2.802,1.25,2.802,2.779v61.848h-5.585V32.893   L61.683,32.893z M46.768,47.27c0-1.55,1.242-2.8,2.785-2.8c1.544,0,2.797,1.25,2.797,2.8v47.471h-5.58V47.27H46.768z    M31.859,59.271c0-1.537,1.239-2.804,2.768-2.804c1.544,0,2.8,1.267,2.8,2.804v35.471h-5.565V59.271H31.859z M16.917,73.619   c0-1.529,1.254-2.799,2.782-2.799c1.547,0,2.801,1.27,2.801,2.799v21.122h-5.581V73.619H16.917z" /></g></svg>
							</div>
						</div>
					</div>

					<%-- 		</c:if> --%>

					<!-- ./col -->

					<div class="col mb-4">
						<!-- small box -->
						<div
							class="small-box bg-orange-gradient d-flex align-items-center h-100 text-white"
							style="cursor: pointer;">
							<h3 style="color: white;">
								Overdue task : ${taskSchedulerDue.size()} <span
									class="d-block text-capitalize text-small mt-3"> <a
									style="color: white;" href="${context}/overDuetaskList">
										More info <i class="fa fa-long-arrow-right"></i>
								</a></span>
							</h3>
							<div class="icon ml-auto">
								<svg xmlns="http://www.w3.org/2000/svg" id="Layer_2_copy_2"
									data-name="Layer 2 copy 2" viewBox="0 0 64 64"
									class="main-icon" width="100%" height="100%">
									<path
										d="M45.267,39.462,33,31.458V12a1,1,0,0,0-2,0V32.542l13.173,8.6a1,1,0,1,0,1.094-1.676Z" />
									<path
										d="M32,0A32,32,0,1,0,64,32,32,32,0,0,0,32,0ZM53.893,52.479l-1.9-1.9A1,1,0,0,0,50.583,52l1.9,1.9A29.881,29.881,0,0,1,33,61.975V59a1,1,0,0,0-2,0v2.975a29.881,29.881,0,0,1-19.479-8.081l1.9-1.9A1,1,0,0,0,12,50.583l-1.9,1.9A29.881,29.881,0,0,1,2.025,33H5a1,1,0,0,0,0-2H2.025a29.881,29.881,0,0,1,8.081-19.479l1.9,1.9A1,1,0,0,0,13.417,12l-1.9-1.9A29.881,29.881,0,0,1,31,2.025V5a1,1,0,0,0,2,0V2.025a29.881,29.881,0,0,1,19.479,8.081l-1.9,1.9A1,1,0,1,0,52,13.417l1.9-1.9A29.881,29.881,0,0,1,61.975,31H59a1,1,0,0,0,0,2h2.975A29.881,29.881,0,0,1,53.893,52.479Z" /></svg>
							</div>
						</div>
					</div>



				</div>
				<!--/*4 boxes end*/-->

				<div class="row">
					<div class="col-md-12">
						<div class="content_box">
							<div class="box-header with-border">
								<div class="box-title">My Task</div>
							</div>
							<div class="box-body">
								<table class="table table-striped table-bordered m-0 filter9">
									<!-- id="deptTable"> -->
									<thead class="table-head">
										<tr>
											<th>S.No.</th>
											<th><spring:message code="book.journal" /> Abbr.</th>
											<th><spring:message code="chapter.article" /> Title</th>
											<th><spring:message code="chapter.article" /> ID</th>
											<th>Task Name</th>
											<th>Stage</th>
											<th>Schedule Start Date</th>
											<th>Schedule End Date</th>
											<!-- 													<th>Actual Start Date</th> -->
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="temp" items="${taskScheduler}"
											varStatus="counter">

											<tr>
												<td align="center">${counter.count}</td>

												<td align="center">${temp.journalAbbrName}</td>
												<td>${temp.article_title}</td>
												<td align="center">${temp.aid}</td>
												<td>${temp.taskName}</td>
												<td>${temp.task_status}</td>
												<td><fmt:formatDate pattern="dd-MM-yyyy"
														value="${temp.sch_start_time}" /></td>
												<td><fmt:formatDate pattern="dd-MM-yyyy"
														value="${temp.sch_end_time}" /></td>
												<%-- 														<td><fmt:formatDate pattern="dd-MM-yyyy" value="${temp.start_date_time}" /></td> --%>
												<td align="center"><input type="hidden" name="flagDash"
													id="flagDash"> <input type="hidden"
													name="article_id_${temp.article_task_id}" id="article_id"
													value="${temp.article_id}"> <input type="hidden"
													name="article_task_id" id="article_task_id"
													value="${temp.article_task_id}"> <a href="#"
													class="btn btn-outline-success btn-sm"
													onclick="startMYTask(${temp.article_task_id})"> Start </a>
												</td>
										</c:forEach>
									</tbody>
								</table>

							</div>
						</div>
					</div>
				</div>
				<!--/*content_box*/-->
				<div class="row">
					<div class="col-12 col-md-12 col-lg-12">
						<!--content_box-->
						<div class="content_box">


							<!--box-body-->
							<div class="box-body bg-white">
								<div id="container"></div>
							</div>



						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</form>
<!--Main_part_end-->

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<script type="text/javascript">

function startMYTask(val){
	document.getElementById("flagDash").value = 1;
	document.getElementById("article_task_id").value = val;
	document.getElementById("mang").action="${context}/view-groupTask";
	document.getElementById("mang").method="POST";
	document.getElementById("mang").submit();
}


Highcharts.chart('container', {
    chart: {
        type: 'column'
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
            text: '<spring:message code="chapter.article" /> Delivered(No. Of articles)'
        }, 
        min: 0,
      
    },
    legend: {
        enabled: false
    },
    tooltip: {
        pointFormat: '<spring:message code="chapters.articles" /> Delivered on : <b>{point.y} Articles</b>'
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
