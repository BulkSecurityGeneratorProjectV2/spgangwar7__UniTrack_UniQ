<%@ include file="/WEB-INF/includes/include.jsp"%>

<script src="https://code.highcharts.com/gantt/highcharts-gantt.js"></script>
<script
	src="https://code.highcharts.com/gantt/modules/draggable-points.js"></script>
<form name="srchart2" id="srchart2">
	<form name="srchart" id="srchart" action='searchArticleData'
		method='post'>

		<div class="wrapper">
			<div class="main_part_outer" id="content">
				<div class="d-flex flex-column w-100 h-200">
					<div class="container-fluid">
						<!--main_tittle-->
						<c:if test="${not empty message}">
							<div id="message" class="alert alert-${css} alert-dismissible"
								role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong> ${message}</strong>
							</div>
						</c:if>
						<div class="row">
							<div class="col-md-12">
								<div class="main_tittle d-flex align-items-center">

									<span class="mr-2"><spring:message code="issue.book" /> Details</span> <span class="ml-auto"><a
										href="${context}/dashboard"
										class="btn btn-sm btn-outline-danger">Back to Dashboard</a></span>
									<%-- 	</c:if> --%>
									<input type="hidden" class="form-control" id="article_title"
										name="article_title" value="${article_title}"> <input
										type="hidden" class="form-control" id="article_doi"
										name="article_doi" value="${article_doi}"> <input
										type="hidden" class="form-control" id="article_type_cd"
										name="article_type_cd" value="${article_type_cd}"> <input
										type="hidden" class="form-control" id="publisherName"
										name="publisherName" value="${publisherName}">
								</div>
							</div>
						</div>





						<div class="content_box">
							<div class="box-body">
								<div class="row">
									<div class="col-sm-6 col-md-6">
										<div class="form-group">
											<label class="art-left">Journal Name: </label> <span
												class="form-control bg-lighttitle-right title-right">${journalName}</span>
										</div>
									</div>
									<div class="col-sm-6 col-md-6">
										<div class="form-group">
											<label class="art-left">Workflow Name: </label> <span
												class="form-control bg-light title-right">${workflowName}</span>
										</div>
									</div>



								</div>
								<div class="row">
									<div class="col-sm-6 col-md-6">
										<div class="form-group">
											<label class="art-left"><spring:message code="issue.book" /> Title: </label> <input
												type="text" id="issue_title"
												class="form-control bg-light title-right"
												placeholder="Issue Title" value="${IssueTitle}"
												data-placement="top" title="Issue Title" maxlength="50">

										</div>
									</div>

									<div class="col-sm-6 col-md-6">
										<div class="form-group">
											<label class="art-left">Volume Year: </label> <input
												type="text" id="volume_year"
												class="form-control bg-light title-right"
												placeholder="volume Year" value="${volumeYear}"
												data-placement="top" title="Volume Year" maxlength="50">
										</div>
									</div>


								</div>
								<div class="row">
									<div class="col-sm-6 col-md-6">
										<div class="form-group">
											<label class="art-left">Volume Per Year: </label> <input
												type="text" id="numberVolumePerYear"
												class="form-control bg-light title-right"
												placeholder="Number Volume PerYear"
												value="${numberVolumePerYear}" data-placement="top"
												title="Number VolumePerYear" maxlength="50">
										</div>
									</div>
									<div class="col-sm-6 col-md-6">
										<div class="form-group">
											<label class="art-left test-lft">Comments : </label> <span><button
													type="button" class="btn btn-outline-success date-boxbtn "
													style="padding: 3px 20px; margin-left: 45px;"
													data-toggle="modal" data-target="#commentList">
													<i class=""></i>View Comments
												</button> </span>
										</div>
									</div>


								</div>
								<div class="row">

									<div class="col-sm-6 col-md-6">
										<div class="form-group">
											<label class="art-left test-lft">Accepted Date: </label> <span
												class="form-control bg-light title-right date-box">${article_ingested}</span>
										</div>





									</div>


									<div class="col-12  text-right">
										<div class="form-group clearfix">
											<button type="button"
												onclick="updateIssueDetails(${article_id});"
												class="btn btn-sm btn-outline-danger" data-toggle="modal">
												<i class=""></i>Update <spring:message code="issue.book" />
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>


						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2 left-mrgn">File Inventory Details:</span>
						</div>

						<div class="row">

							<div class="col-md-12">
								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0 "
											id="fileTable">
											<thead class="table-head">
												<tr>
													<th>S.No.</th>
													<th>File Name</th>

													<th>File Version</th>
													<th>File Size</th>
													<th>Task Name</th>
													<th>User Name</th>
													<th>File download</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${fileVersions}"
													varStatus="counter">

													<tr>
														<td align="center">${counter.count}</td>
														<td>${temp.fileName}</td>

														<td>${temp.fileVersion}</td>
														<td>${temp.size}</td>
														<td>${temp.taskDetails.taskName}</td>
														<td>${temp.userDetails.firstName}
															&nbsp;${temp.userDetails.lastName}</td>
														<td><input type="hidden" id="fileURL" name="fileURL">
															<button type='button' class="btn btn-danger btn-sm"
																onclick="downloadIssueFile('${temp.filePath}');"
																value='Download'>Download</button></td>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<!-- <div class="main_tittle d-flex align-items-center">
							<span class="mr-2 left-mrgn">Issue Creation Schedule
								Details:</span>
						</div> -->
						<div class="row">
							<div class="col-md-12">
								<div class="main_tittle d-flex align-items-center">
									<span class="mr-2"><spring:message code="issue.book" /> Creation Schedule Details:</span> <span
										class="ml-auto">
										<button type="button" class=" btn btn-primary btn-sm"
											data-toggle="modal" onclick="issueProxyAction(${article_id})"
											data-target="#completeProxy">
											<i class="fa fa-check"></i>Proxy Action
										</button>
										<button type="button"
											class="btn text-white btn-primary btn-sm  "
											data-toggle="modal" onclick="setArticleTask(${article_id})"
											data-target="#assignback">
											<i class="fa fa-arrow-left"></i> Assign back
										</button>
										<button type='button'
											class="btn text-white btn-primary btn-sm  "
											data-toggle="modal" data-target="#skipTasks"
											onclick="setArticleTask(${article_id})" value='Skip'>
											Skip <i class="fa fa-arrow-right"></i>
										</button>
									</span>
								</div>
							</div>
						</div>
						<div class="row">

							<div class="col-md-12">
								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="articleTable">
											<thead class="table-head">
												<tr>
													<th>S.No.</th>
													<th>Task Name</th>
													<th>Schedule Start Time</th>
													<th>Schedule End Time</th>
													<th>Start Date Time</th>
													<th>Completed Date Time</th>
													<th>difference in Days</th>
													<th>Assigned User Name</th>
													<th>Completed Action</th>
													<!-- <th>Responsible Vendor/Group</th> -->

												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${ArticleDetail}"
													varStatus="counter">

													<tr>
														<td align="center">${counter.count}</td>
														<td>${temp.taskName}</td>
														<td><fmt:formatDate value="${temp.sch_start_time}"
																pattern="yyyy-MM-dd hh:mm a" /></td>
														<td><fmt:formatDate value="${temp.sch_end_time}"
																pattern="yyyy-MM-dd hh:mm a" /></td>
														<td><fmt:formatDate value="${temp.start_date_time}"
																pattern="yyyy-MM-dd hh:mm a" /></td>
														<td><fmt:formatDate
																value="${temp.completed_date_time}"
																pattern="yyyy-MM-dd hh:mm a" /></td>
														<td align="center">${temp.diffdate}</td>
														<td>${temp.firstName}${temp.lastName}</td>
														<c:if
															test="${temp.task_status ne 'In Progress' and temp.task_status ne 'InPool'}">
															<td>${temp.task_status}</td>
														</c:if>

														<c:if
															test="${temp.task_status eq 'In Progress' or temp.task_status eq 'InPool'}">
															<td>${temp.task_status}
																<button type="button" class=" btn-primary"
																	data-toggle="modal"
																	onclick="issueProxyAction(${temp.article_task_id});"
																	data-target="#completeProxy">
																	<i class="fa fa-check"></i>Proxy Action
																</button>
															</td>
														</c:if>
														<%-- <td>${temp.deptName}</td> --%>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

						<div class="alert" id="container"></div>
					</div>
				</div>
			</div>
		</div>

	</form>
</form>
<div class="modal fade" id=commentList role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- 	<div class="modal-header"> -->
			<div class="modal-header">
				<h5 class="modal-title">All Comments</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-header">
				<div class="content_box">
					<div class="box-body">
						<table class="table table-striped table-bordered m-0"
							id="articleCommentTable">
							<thead class="table-head">
								<tr>
									<th>S.No.</th>
									<th>Task Name</th>
									<th>Role Name</th>
									<th>Comment</th>
									<th>User Name</th>
									<th>Comments Date</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="temp" items="${commentsList}"
									varStatus="counter">
									<tr>
										<td align="center">${counter.count}</td>
										<td>${temp.task.taskName}</td>
										<td>${temp.role.roleName}</td>
										<td>${temp.issueComments}</td>
										<td>${temp.userName}</td>
										<td><fmt:formatDate value="${temp.commentDate}"
												pattern="yyyy-MM-dd hh:mm a" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
			</div>

		</div>
	</div>
</div>


<div class="modal fade" id="skipTasks" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><b>Skip Tasks</b></label>
				<!-- 				<span class=""> Assign Back</span> -->
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<form action="${context}/skipIssueTasksFrom" method="post">
				<div class="modal-body">

					<label for="currency"><b>Assign To</b> <sup
						class="text-red">&lowast;</sup></label>
					<form:select path="nextTasks" id="id1" name="id"
						class="form-control" required="required">
						<form:option value="Please select a task" labelValue="" />
						<form:options items="${nextTasks}" itemValue="id"
							itemLabel="taskName" />
					</form:select>
					<div>
						<label><b>Comments</b></label> <br>
						<textarea rows="2" cols="80" maxlength="200" name="assign_reason"
							id="assign_reason2">  
                   </textarea>
						<div id="textarea_feedback2" style="color: red"></div>
					</div>
					<input type="hidden" name="articletaskid" id="articletaskid"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> <input
						type="submit" value="Skip Task"
						class="btn btn-primary btn-sm float-right"
						onClick="return assignBackValidate()" /><br>

				</div>
			</form>
		</div>
	</div>
</div>


<div class="modal fade" id="assignback" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><b>Assign Back</b></label>
				<!-- 				<span class=""> Assign Back</span> -->
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<form action="${context}/issueAssignBackFrom" method="post"
				name="form" enctype="multipart/form-data">
				<div class="modal-body">
					<label for="currency"><b>Assign To</b><sup class="text-red">&lowast;</sup></label>
					<form:select path="TaskList" id="id" name="id" class="form-control"
						required="required">
						<form:option value="Please select a task" labelValue="" />
						<form:options items="${TaskList}" itemValue="id"
							itemLabel="taskName" />
					</form:select>

					<input type="hidden" name="article_id" id="article_id"
						value="${article_id}"> <label><b>Comments</b></label> <br>
					<textarea rows="3" cols="80" maxlength="200" name="assign_reason"
						id="assign_reason1"></textarea>
					<div id="textarea_feedback1" style="color: red"></div>
					<input type="file" class="" id="notmandatry" name="backFile"
						accept="application/${fileType}" placeholder=""><br>

					<%--  <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> --%>
					<input type="submit" class="btn btn-primary btn-sm float-right"
						value="Assign Back" onClick="return validateBack()" /><br>

				</div>
			</form>
		</div>
	</div>
</div>



<div class="modal fade" id="completeProxy" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><h4>Upload File</h4></label>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>


			<form id="myForm" action="${context}/completeIssueProxyTask"
				method="post" enctype="multipart/form-data">
				<div class="modal-body">
					<input type="file" class="form-control" id="files"
						name="attachmentList" multiple required><br />

					<div id="selectedFiles"></div>
					<input type="hidden" name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}">

					<div class="modal-body">
						<input type="submit" class="btn btn-primary btn-sm float-right "
							value="Submit" />
					</div>
				</div>
			</form>

			<script>
	              var selDiv = "";
		
	                document.addEventListener("DOMContentLoaded", init, false);
	
	                function init() {
		                  document.querySelector('#files').addEventListener('change', handleFileSelect, false);
		                  selDiv = document.querySelector("#selectedFiles");
	                 } 
		
	               function handleFileSelect(e) {
		                if(!e.target.files) return;
		
		                  selDiv.innerHTML = "";
		
		                  var files = e.target.files;
		                  for(var i=0; i<files.length; i++) {
			                    var f = files[i];
			                    selDiv.innerHTML += f.name + "<br/>";

		                  }
		
	                }
	          </script>


		</div>
	</div>
</div>

<script>
$(document).ready(function() {
    $('#fileTable').DataTable();
} );
function issueProxyAction(val) {
	//alert(val);
	document.getElementById("article_task_id").value =val;
}
	
	function searchdata() {
		document.getElementById("srchart2").action = "searchArticleData";
		document.getElementById("srchart2").method = "POST";
		document.getElementById("srchart2").submit();
	}
	function articalDetails(val) {
		document.getElementById("article_id").value =val;
		document.getElementById("srchart").action = "StartGroupTask";
		document.getElementById("srchart").method = "POST";
		document.getElementById("srchart").submit();
	}
	
	function downloadIssueFile(val) {
		debugger;
	//	alert(val);
		document.getElementById("fileURL").value =val;
		document.getElementById("srchart2").action = "dwonload_file";
		document.getElementById("srchart2").method = "GET";
		document.getElementById("srchart2").submit();
	}
// 	function DownloadFile(path) {
// 	    alert(path);
// 		document.getElementById("fileURL").value =path;
// 		var mappingJSON = {};
// 		mappingJSON["roleID"] = path;
// 		var mappingInfo = JSON.stringify(mappingJSON);
// 		$.ajax({
// 			url : '/dwonload_file',
// 			type : "POST",
// 			data : mappingInfo,
// 			contentType : "application/json; charset=utf-8",
// 			dataType : "json",
// 			cache : false,
// 			success : function(result) {
// 				alert(result.responseText)				
				
// 			}
		
// 		});	
	
        
        
// 	}
	</script>


<script>
 			Highcharts.ganttChart('container', {
 				chart: {
 					style: {"color": "#003C71", "fontSize": "12px"}
 			    },
 			   credits: {
 				    enabled: false
 				},
 			   
 			    title: {
 			        text: 'Gantt Chart'
 			    },

 			    xAxis: {
 			        tickPixelInterval: 70
 			    },

 			    yAxis: {
 			        type: 'category',
 			        grid: {
 			            enabled: true,
 			            borderColor: 'rgba(0,0,0,0.3)',
 			            borderWidth: 1,
 			            columns: [{
 			                title: {
 			                    text: 'Task Name'
 			                },
 			                labels: {
 			                    format: '{point.name}'
 			                }
 			            }, {
 			                title: {
 			                    text: 'Username'
 			                   	
 			                },  
 			               
 			                labels: {
 			                    format: '{point.assignee}',
 			                 
 			                }
 			            }, {
 			                title: {
 			                    text: 'Est. days'
 			                },
 			                labels: {
 			                    formatter: function () {
 			                        var point = this.point,
 			                            days = (1000 * 60 * 60 * 24),
 			                            number = (point.x2 - point.x) / days;
 			                        return Math.round(number * 100) / 100;
 			                    }
 			                }
 			            }, {
 			                labels: {
 			                    format: '{point.start:%e. %b}'
 			                },
 			                title: {
 			                    text: 'Start date'
 			                }
 			            }, {
 			                title: {
 			                    text: 'End date'
 			                },
 			                offset: 30,
 			                labels: {
 			                    format: '{point.end:%e. %b}'
 			                }
 			            }]
 			        }
 			    },

 			   <c:set var="count" value="0" scope="page" />
 			   series: [{
 			        name: 'Project 1',
 			        data: [<c:forEach items="${ArticleDetail}" var="entry">{
			             start: ${entry.sch_start_time.getTime()},
			             end: ${entry.sch_end_time.getTime()},
			             name: '${entry.taskName}',
			             assignee: '${entry.firstName} ${entry.lastName}',
			             y: ${count}
		               
		            	
 			        },
 			       <c:set var="count" value="${count + 1}" scope="page"/>
 			        </c:forEach>]
 			    }],

 			    exporting: {
 			        sourceWidth: 1000
 			    }
 			});

 			
			</script>
<script>
function updateIssueDetails(issue_id) {
	  var volume_year=   $("#volume_year").val();
	  var issue_title=  $("#issue_title").val();	
	  var numberVolumePerYear=  $("#numberVolumePerYear").val();	
		var mappingJSON = {};
		mappingJSON["volume_year"] = volume_year;
		mappingJSON["issue_title"] = issue_title;
		mappingJSON["number_of_volume_per_year"] = numberVolumePerYear;
		mappingJSON["issue_id"] = issue_id;
		var mappingInfo = JSON.stringify(mappingJSON);
	//	alert(mappingInfo);
		$.ajax({
			url : '${context}/updateIssueDetails',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				alert("Updated successfully")				
				
			}
		
		});	
	}
	</script>
