
<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="main_part_outer" id="content">

	<div class="d-flex flex-column w-100 h-100">
		<div class="container-fluid">
			<!--main_tittle-->

			<div class="row">
				<div class="col-md-6">
					<div class="main_tittle">
						Production Dashboard <span id="Date">Wednesday , 21
							November 2018</span>
					</div>
				</div>
				<%-- 	<div class="col-md-6 text-right">
					<!-- 	<label class=" btn btn-dark btn-sm">
					 Switch Journal<i class="fa fa-arrow-circle-right"></i></label> -->
					<select class="slctbtn " id="multiTaskjournal"
						onchange="changejournal()">
						<option>Select Journal</option>
						<c:forEach var="journalList" items="${journalList}">
							<option value='${journalList.journalId}'>${journalList.journalName}
							</option>
						</c:forEach>
					</select>
				</div> --%>
			</div>

			<div class="row">

				<div class="col mb-4">
					<div
						class="small-box bg-dark-green-gradient d-flex align-items-center h-100 text-white">
						<h3>
							My <spring:message code="chapters.articles" /> &nbsp;:&nbsp; ${taskScheduler.size()} <span
								class="d-block text-capitalize text-small mt-3"> <a
								style="color: white;" href="#"
								onclick="showAndHide('articleList')"> More info <i
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

				<div class="col mb-4">
					<div
						class="small-box bg-blue-gradient d-flex align-items-center h-100 text-white">
						<h3>
							My <spring:message code="issue.book" /> &nbsp;:&nbsp; ${issueScheduler.size()} <span
								class="d-block text-capitalize text-small mt-3"> <a
								style="color: white;" href="#"
								onclick="showAndHide('issueList')"> More info <i
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


				<%-- <div class="col mb-4">
					<div class="small-box bg-blue-gradient d-flex align-items-center h-100 text-white">
						 <h3>Task Available on Pool : ${taskManagementVoc.size()}
				            <span class="d-block text-capitalize text-small mt-3">
				            	<a href="#" class="text-white" onclick="showAndHide('inprocess')">More info <i class="fa fa-long-arrow-right"></i></a>
				            </span>
				          </h3>
				          <div class="icon ml-auto">
			            	<svg xmlns="https://www.w3.org/2000/svg" xmlns:xlink="https://www.w3.org/1999/xlink" class="main-icon" version="1.1" x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve" class="main-icon"><g><path d="M18.416,62.788c1.746,0,3.143-1.411,3.143-3.149c0-0.246-0.071-0.459-0.13-0.692L79.435,7.721l1.44,1.466   l1.629-6.504l-6.516,1.585l1.744,1.76L20.019,56.992c-0.492-0.291-0.996-0.491-1.601-0.491c-1.731,0-3.143,1.413-3.143,3.138   C15.273,61.377,16.684,62.788,18.416,62.788z M18.416,58.882c0.418,0,0.751,0.346,0.751,0.757c0,0.425-0.333,0.749-0.751,0.749   c-0.406,0-0.753-0.324-0.753-0.749C17.665,59.228,18.01,58.882,18.416,58.882z"/><path d="M95.485,94.777h-2.267h-8.638V20.936c0-2.871-2.32-5.207-5.192-5.207c-2.855,0-5.178,2.336-5.178,5.207   v73.838h-4.537V32.893c0-2.857-2.321-5.178-5.208-5.178c-2.854,0-5.179,2.321-5.179,5.178v61.884h-4.555V47.27   c0-2.868-2.307-5.199-5.178-5.199c-2.856,0-5.189,2.331-5.189,5.199v47.507h-4.544V59.271c0-2.88-2.32-5.187-5.192-5.187   c-2.871,0-5.176,2.307-5.176,5.187v35.507h-4.557V73.619c0-2.865-2.305-5.183-5.192-5.183c-2.854,0-5.174,2.317-5.174,5.183v21.158   H6.77H4.513c-0.674,0-1.195,0.541-1.195,1.21c0,0.649,0.521,1.18,1.195,1.18h2.252h86.457h2.264c0.665,0,1.197-0.53,1.197-1.18   C96.683,95.318,96.15,94.777,95.485,94.777z M76.606,20.936c0-1.55,1.255-2.8,2.782-2.8c1.544,0,2.803,1.25,2.803,2.8v73.805   h-5.585V20.936z M61.683,32.893c0-1.529,1.255-2.779,2.783-2.779c1.545,0,2.802,1.25,2.802,2.779v61.848h-5.585V32.893   L61.683,32.893z M46.768,47.27c0-1.55,1.242-2.8,2.785-2.8c1.544,0,2.797,1.25,2.797,2.8v47.471h-5.58V47.27H46.768z    M31.859,59.271c0-1.537,1.239-2.804,2.768-2.804c1.544,0,2.8,1.267,2.8,2.804v35.471h-5.565V59.271H31.859z M16.917,73.619   c0-1.529,1.254-2.799,2.782-2.799c1.547,0,2.801,1.27,2.801,2.799v21.122h-5.581V73.619H16.917z"/></g></svg>
			            </div>
						
					</div>

				</div> --%>


				<div class="col mb-4">
					<div
						class="small-box bg-orange-gradient d-flex align-items-center h-100 text-white">
						<h3>
							Overdue tasks : ${taskSchedulerDue.size()} <span
								class="d-block text-capitalize text-small mt-3"> <a
								style="color: white;" href="#" onclick="showAndHide('overdue')">
									More info <i class="fa fa-long-arrow-right"></i>
							</a></span>
						</h3>
						<div class="icon ml-auto">
							<svg xmlns="http://www.w3.org/2000/svg" id="Layer_2_copy_2"
								data-name="Layer 2 copy 2" viewBox="0 0 64 64" class="main-icon"
								width="100%" height="100%">
								<path
									d="M45.267,39.462,33,31.458V12a1,1,0,0,0-2,0V32.542l13.173,8.6a1,1,0,1,0,1.094-1.676Z" />
								<path
									d="M32,0A32,32,0,1,0,64,32,32,32,0,0,0,32,0ZM53.893,52.479l-1.9-1.9A1,1,0,0,0,50.583,52l1.9,1.9A29.881,29.881,0,0,1,33,61.975V59a1,1,0,0,0-2,0v2.975a29.881,29.881,0,0,1-19.479-8.081l1.9-1.9A1,1,0,0,0,12,50.583l-1.9,1.9A29.881,29.881,0,0,1,2.025,33H5a1,1,0,0,0,0-2H2.025a29.881,29.881,0,0,1,8.081-19.479l1.9,1.9A1,1,0,0,0,13.417,12l-1.9-1.9A29.881,29.881,0,0,1,31,2.025V5a1,1,0,0,0,2,0V2.025a29.881,29.881,0,0,1,19.479,8.081l-1.9,1.9A1,1,0,1,0,52,13.417l1.9-1.9A29.881,29.881,0,0,1,61.975,31H59a1,1,0,0,0,0,2h2.975A29.881,29.881,0,0,1,53.893,52.479Z" /></svg>
						</div>
					</div>

				</div>
			</div>

			<%-- <div class="row" id="inprocess">
				<div class="col-md-12">
					<div class="main_tittle d-flex align-items-center"></div>
					<div class="content_box">
						<div class="box-body bg-white p-0">
							<table class="table table-striped table-bordered m-0">
								<tr>
									<th class="rotate">Task Name</th>
									<c:forEach var="dpttask" items="${departmentsTask}"
										varStatus="counter" begin="0" end="8" step="1">
										<td><b>${dpttask.taskName}</b></td>
									</c:forEach>
								</tr>
								<tr>
									<th class="rotate">Journal Name</th>
									<c:forEach var="dpttask" items="${departmentsTask}"
										varStatus="counter" begin="0" end="8" step="1">
										<td>${dpttask.journalName}</td>
									</c:forEach>
								</tr>
								<tr>
									<th class="rotate">Task Status</th>
									<c:forEach var="dpttask" items="${departmentsTask}"
										varStatus="counter" begin="0" end="8" step="1">
										<td>${dpttask.task_status}</td>
									</c:forEach>
								</tr>
								<tr>
									<th class="rotate">Task Count</th>
									<c:forEach var="dpttask" items="${departmentsTask}"
										varStatus="counter" begin="0" end="8" step="1">
										<td>${dpttask.count}</td>
									</c:forEach>
								</tr>

							</table>
						</div>
					</div>
				</div>
			</div> --%>

			<!-- <div class="box-body">
				<div class="row">
					<div class="col-md-12">
						<div>
							<table class="table table-striped table-bordered m-0" id="inpro">
								<tr id="taskname">
									<th class="rotate">Task Name</th>
									<td id="taskname"></td>
								</tr>
								<tr id="jrname">
									<th class="rotate">Journal Name</th>
									<td id="jrname"></td>
								</tr>
								<tr id="taskStatus">
									<th class="rotate">Task Status</th>
									<td id="taskStatus"></td>
								</tr>
								<tr id="statuscount">
									<th class="rotate">Task Count</th>
									<td id="statuscount"></td>
								</tr>

							</table>


						</div>
					</div>
				</div>
			</div> -->
			<form name="groupTask" id="groupTask">
				<input type="hidden" name="flag" id="flag" value=2> <input
					type="hidden" name="flag" id="flagDash" value=2> <input
					type="hidden" name="article_id" id="article_id"> <input
					type="hidden" name="article_task_id" id="article_task_id">
				<div class="row" id="new_project">
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">My <spring:message code="chapters.articles" /></span>
						</div>
						<div class="content_box">
							<div class="box-body">
								<table class="table table-striped table-bordered m-0 filter10"
									id="">
									<thead class="table-head">
										<tr>
											<th width="2%">S.No.</th>
											<!-- <th width="2%"><input type="checkbox" id="checkAll"></th> -->

											<th width="15%"><spring:message code="book.journal" /> Abbreviation Name</th>
											<th width="25%">Title</th>
											<th width="8%"><spring:message code="chapters.articles" /> ID</th>

											<th width="10%">Task Name</th>
											<th width="10%">Stage</th>
											<th width="10%">Schedule Start Date</th>
											<th width="10%">Schedule End Date</th>
											<!-- <th>Actual Start Date</th> -->
											<th width="10%">Action</th>
											<th width="10%">History</th>
										</tr>
									</thead>
									<tbody id=appData>
										<c:forEach var="temp" items="${taskScheduler}"
											varStatus="counter">

											<tr class=appData>
												<td align="center">${counter.count}</td>
												<%-- <td align="left"><input type="checkbox"
														class="checkItem" id="${temp.article_task_id}"
														value=" ${temp.article_task_id}"></td> --%>
												<td align="center">${temp.journalAbbrName}</td>
												<td>${temp.article_title}</td>
												<td>${temp.aid}</td>
												<td>${temp.taskName}</td>
												<td>${temp.task_status}</td>
												<td align="center"><fmt:formatDate pattern="dd-MM-yyyy"
														value="${temp.sch_start_time}" /></td>
												<td align="center"><fmt:formatDate pattern="dd-MM-yyyy"
														value="${temp.sch_end_time}" /></td>
												<td align="center"><a href="#"
													class="btn btn-outline-success btn-sm"
													onclick="StartMYTask(${temp.article_task_id},${temp.article_id})">
														Start</a></td>
												<td><a href="#" class="btn btn-outline-success btn-sm"
													onclick="articalDetails('${temp.article_id}')"> History
												</a></td>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

			</form>

			<%--  <form name="groupTask" id="groupTask">
					<input type="hidden" name="flag" id="flag" value="${flag}">
					<div class="row" id="new_project">
						<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
													<span class="mr-2">Articles Task</span>
						</div>
							<div class="content_box box-shadow">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0"
										id="mytaskTable">
										<thead class="table-head">
											<tr>
												<th>S.No.</th>
												<th>Article ID</th>
												<th>Journal Abbreviation Name</th>
												<th>Article Title</th>
												<th>Task Name</th>
												<th>Stage</th>
												<th>Schedule Start Date</th>
												<th>Schedule End Date</th>
												<!--
																									<th>Actual Start Date</th> -->
												<th>Priority</th>
												<th>Action</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach var="temp" items="${taskScheduler}"
												varStatus="counter">
												<c:if test="${temp.priority eq 'High Priority'}">
												<tr class="bg-danger">
												</c:if>
												<c:if test="${temp.priority eq 'Medium Priority'}">
												<tr class="">
												</c:if>
												<c:if test="${temp.priority eq 'Low Priority'}">
												<tr class="bg-warning">
												</c:if>
													<td align="center">${counter.count}</td>
													<td align="center">${temp.aid}</td>
													<td align="center">${temp.journalAbbrName}</td>
													<td>${temp.article_title}</td>
													<td>${temp.taskName}</td>
													<td>${temp.task_status}</td>
													<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.sch_start_time}" /></td>
													<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.sch_end_time}" /></td>
																											<td><fmt:formatDate pattern="dd-MM-yyyy" value="${temp.start_date_time}" /></td>
													
													<td>${temp.priority}</td>
													<td align="center"><input type="hidden"
														name="article_id_${temp.article_task_id}" id="article_id"
														value="${temp.article_id}"> <input type="hidden"
														name="article_task_id" id="article_task_id"
														value="${temp.article_task_id}"> 														<input type="hidden" name="journalId" id="journalId" value="${temp.journalId}">
														<a href="#" class="btn btn-success btn-sm"
														onclick="StartMYTask(${temp.article_task_id})"> Start
													</a> <!-- <a href="/unitouchLogo" class="btn btn-outline-success btn-sm" > Start </a> -->
													</td>
													
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

				</form> --%>
			<form name="groupTask1" id="groupTask1">
				<div class="row" id="issue_project">
					<div class="col-md-12">
						<c:if test="${issueScheduler.size() ge 1}">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">My Issues</span>
							</div>
							<div class="content_box box-shadow">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0 filter8"
										id="">
										<!-- deptTable  -->
										<thead class="table-head">
											<tr>
												<th>S.No.</th>
												<!-- <th>Article ID</th> -->
												<th><spring:message code="book.journal" /> Abbreviation</th>
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
											<c:forEach var="temp" items="${issueScheduler}"
												varStatus="counter">

												<tr>
													<td align="center">${counter.count}</td>
													<%-- 	<td align="center">${temp.aid}</td> --%>
													<td align="center">${temp.journalAbbrName}</td>
													<td>${temp.issue_title}</td>
													<td>${temp.taskName}</td>
													<td>${temp.taskStatus}</td>
													<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.schStartTime}" /></td>
													<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.taskEstTimeFrom}" /></td>
													<%-- 														<td><fmt:formatDate pattern="dd-MM-yyyy" value="${temp.start_date_time}" /></td> --%>
													<td align="center"><input type="hidden"
														name="article_id_${temp.issueTaskId}" id="article_id"
														value="${temp.issue_id}"> <input type="hidden"
														name="article_task_id" id="article_task_id_issue"
														value="${temp.issueTaskId}"> <%-- 														<input type="hidden" name="journalId" id="journalId" value="${temp.journalId}"> --%>
														<a href="#" class="btn btn-outline-success btn-sm"
														onclick="StartMYTask1(${temp.issueTaskId})"> Start </a> <!-- <a href="/unitouchLogo" class="btn btn-outline-success btn-sm" > Start </a> -->
													</td>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</form>

			<form name="articleOverdue" id="articleOverdue">

				<div class="row" id="overdue_project">
					<div class="col-md-12">
						<c:if test="${taskSchedulerDue.size() ge 1}">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Overdue Tasks</span>
							</div>
							<div class="content_box box-shadow">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0 filter9"
										id="overDueArticle">
										<thead class="table-head">
											<tr>
												<th>S.No.</th>
												<th><spring:message code="book.journal" /> Abbreviation Name</th>
												<th>Title</th>
												<th><spring:message code="chapter.article" /> ID</th>

												<th>Task Name</th>
												<th>Stage</th>
												<th>Schedule Start Date</th>
												<th>Schedule End Date</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="temp" items="${taskSchedulerDue}"
												varStatus="counter">

												<tr>
													<td align="center">${counter.count}</td>
													<td align="center">${temp.articleDetail.journals.journalAbbrName}</td>
													<td>${temp.articleDetail.article_title}</td>
													<td align="center">${temp.articleDetail.aid}</td>


													<td>${temp.task.taskName}</td>
													<td>${temp.task_status}</td>
													<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.sch_start_time}" /></td>
													<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.sch_end_time}" /></td>
													<%-- 														<td><fmt:formatDate pattern="dd-MM-yyyy" value="${temp.start_date_time}" /></td> --%>
													<td align="center"><input type="hidden"
														name="flagDash" id="flagDash"> <input
														type="hidden" name="article_id" id="article_id_overdue"
														value="${temp.article_id}"> <input type="hidden"
														name="article_task_id" id="article_task_id_overdue"
														value="${temp.article_task_id}"> <a href="#"
														class="btn btn-outline-success btn-sm"
														onclick="StartMYTaskto(${temp.article_task_id},${temp.article_id})">
															Start </a></td>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</form>

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

<script>
$(document).ready(function(){
    $('#inpro').hide();
});
</script>
<script type="text/javascript">
function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [day, month, year].join('-');
}
/* 
function changejournal(){ 
	// $('#inpro').empty();
	var journalId= $('#multiTaskjournal').find('option:selected').val();
	 	var mappingJSON = {};
		mappingJSON["journal_id"] = journalId;
	//	mappingJSON["workflow_id"] = wkid;
		var mappingInfo = JSON.stringify(mappingJSON); 
 		
		 $.ajax({
			url : '${context}/getjournalsTask',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				var articlePoolList = result.payload;
				var mytask = result.payloadNext;
				$('#inprocess').hide();
				 $('#inpro').show();
				 $('.remove').hide();
				 articlePoolList.forEach(function(x, index) {
					var taskname = 	'<td class=remove><b>'+ x.taskName+'</b></td>';
					var jrname=	'<td class=remove>'+ x.journalName+'</td>';
					var taskStatus=	'<td class=remove>'+ x.task_status+'</td>';
					var statuscount='<td class=remove>'+ x.count+'</td>';	
					$('#taskname').append(taskname);
					$('#jrname').append(jrname);
					$('#taskStatus').append(taskStatus);
					$('#statuscount').append(statuscount);
				}); 
				 
					var mytask = result.payloadNext;
					var count=1;
					$('.appData').empty();
					mytask.forEach(function(x, index) {
						var str = '<tr class=appData>'+
						'<td>'+ (count++)+'</td>'+
						/* '<td align="left"><input type="checkbox" class="checkItem" id='+x.article_task_id+'	value='+x.article_task_id+'+></td>'+ */
/*						'<td>'+ x.aid+'</td>'+
						'<td>'+ x.journalAbbrName+'</td>'+
						'<td>'+ x.article_title+'</td>'+
						'<td>'+ x.taskName+'</td>'+
						'<td>'+ x.task_status+'</td>'+ 
						'<td style="text-align: center;">'+ formatDate(x.sch_start_time)+'</td>'+
						'<td style="text-align: center;">'+ formatDate(x.sch_end_time)+'</td>'+
// 						'<td>'+x.sch_start_time+'</td>'+
// 						'<td>'+ x.sch_end_time+'</td>'+
						'<td >'+
						'<input type="hidden" name="article_id" id="article_id" value='+x.article_id+'>' + 
						'<input type="hidden" name="article_task_id" id="article_task_id" value='+x.article_task_id+'>' +
						'<a href="#" class="btn btn-outline-success btn-sm" onclick="StartMYTask('+x.article_task_id+','+x.article_id+')">Start</a></td>'+
						'<td style="text-align: center;">'+
						'<input type="hidden" name="article_id" id="article_id" value='+x.article_id+'>' + 
						'<input type="hidden" name="article_task_id" id="article_task_id" value='+x.article_task_id+'>' +
						'<a href="#" class="btn btn-outline-success btn-sm" onclick="articalDetails('+x.article_id+')">History</a></td>'+
						'</tr>';	
		
						$('#appData').append(str);
							//alert(str);
						$('#myTable').DataTable();
					});
			},
			error : function(e) {
				console.log(e.message);
			}
		}); 

	} */
  
  
function StartMYTask(val,aid) {
//	alert("fun call");
	document.getElementById("article_task_id").value = val;
	document.getElementById("article_id").value = aid;
	document.getElementById("groupTask").action = "view-groupTask";
	document.getElementById("groupTask").method = "POST";
	document.getElementById("groupTask").submit();
}
function articalDetails(articleId){

	document.getElementById("article_id").value =articleId;
	document.getElementById("flag").value = 1;
	document.getElementById("groupTask").action="${context}/startGroupTask";
	document.getElementById("groupTask").method="POST";
	document.getElementById("groupTask").submit();
}	
</script>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<script type="text/javascript">

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

function showAndHide(val){
	//alert(val)
	if(val=='articleList'){
		document.getElementById("new_project").style.display = "block";
		document.getElementById("issue_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
	}
	
	else if(val=='issueList'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("issue_project").style.display = "block";
		document.getElementById("overdue_project").style.display = "none";
	}
	
	else if(val=='overdue'){
		//alert(val);
		document.getElementById("new_project").style.display = "none";
		document.getElementById("issue_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "block";
	}
	
	else if(val==''){
		document.getElementById("new_project").style.display = "block";
		document.getElementById("issue_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
	}
}

</script>
<script type="text/javascript">

$(document).ready(function() {
	document.getElementById("new_project").style.display = "block";
	document.getElementById("issue_project").style.display = "none";
	document.getElementById("overdue_project").style.display = "none";
} );
    
</script>

<script>
 
	 function StartMYTask1(val) { 
		 document.getElementById("article_task_id_issue").value = val;
	//	document.getElementById("article_task_id").value = val;
		document.getElementById("groupTask1").action = "view-groupTaskIssue";
		document.getElementById("groupTask1").method = "POST";
		document.getElementById("groupTask1").submit();
	}
	 
/* 	 
 	 function multijournal(wkid){ 
	    	var journalId= $('#multijournal').find('option:selected').val();
	    	//alert(wkid);
				var mappingJSON = {};
				mappingJSON["journal_id"] = journalId;
				mappingJSON["workflow_id"] = wkid;
				var mappingInfo = JSON.stringify(mappingJSON);
				$.ajax({
					url : '${context}/getArticleInMytask',
					type : "POST",
					data : mappingInfo,
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					cache : false,
					success : function(result) {
						var articlePoolList = result.payload;
						var count=1;
						$('.appData').hide();
						articlePoolList.forEach(function(x, index) {
							var str = '<tr class=appData>'+
							'<td>'+ (count++)+'</td>'+
							'<td align="left"><input type="checkbox" class="checkItem" id='+x.article_task_id+'	value='+x.article_task_id+'+></td>'+
							'<td>'+ x.aid+'</td>'+
							'<td>'+ x.journalAbbrName+'</td>'+
							'<td>'+ x.article_title+'</td>'+
							'<td>'+ x.taskName+'</td>'+
							'<td>'+ x.task_status+'</td>'+
							'<td>'+x.sch_start_time+'</td>'+
							'<td>'+ x.sch_end_time+'</td>'+
							'<td >'+
							'<input type="hidden" name="article_id" id="article_id" value='+x.article_id+'>' + 
							'<input type="hidden" name="article_task_id" id="article_task_id" value='+x.article_task_id+'>' +
							'<a href="#" class="btn btn-outline-success btn-sm" onclick="StartGroupTask('+x.article_task_id+','+x.article_id+')">Assign Me</a></td>'+
							'</tr>';	
			
							$('#appData').append(str);
								//alert(str);
						});
					},
					error : function(e) {
						console.log(e.message);
					}
				});
		
	    	}  */
	</script>

<script>

</script>
<script>
/*  $(document).ready(function() {
	    $('#overDueArticle').DataTable();
	} ); */
 function StartMYTaskto(val,artilceID) {
		document.getElementById("article_task_id_overdue").value = val;
		document.getElementById("article_id_overdue").value = artilceID;
		document.getElementById("articleOverdue").action = "view-groupTask";
		document.getElementById("articleOverdue").method = "POST";
		document.getElementById("articleOverdue").submit();
	}
 </script>