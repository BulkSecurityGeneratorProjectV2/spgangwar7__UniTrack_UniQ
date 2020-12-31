
<%@ include file="/WEB-INF/includes/include.jsp"%>

<style type="text/css">
.rating-header {
	margin-top: -10px;
	margin-bottom: 10px;
}
</style>
<script src="https://cdn.ckeditor.com/4.13.1/standard-all/ckeditor.js"></script>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Issue Task Detail</span> <span id="Date"></span>
						</div>
					</div>
				</div>
				<!--main_tittle_End-->

				<div class="row ">
					<div class="col-md-12 alert">
						<div class="content_box ">
							<div class="box-body">
								<form id="groupTask" name="groupTask">
									<div class="box-body alert-info">
<input type="hidden" id="fileURL" name="fileURL">
<input type="hidden" name=issue_id id="issue_id">
										<input type="hidden" name="article_task_id"
											id="article_task_id" value="${issueTaskId}"> <input
											type="hidden" name="article_name" id="article_name"
											value="${article_name}"> <input type="hidden"
											name="article_id" id="article_id" value="${issue_id}">
											<input type="hidden"
											name="issueId" id="issueId" value="${issue_id}">
										<input type="hidden" name="flag" id="flag" value="${flag}">
										<input type="hidden" name="workFlowId" id="workFlowId"
											value="${workFlowId}">
											
										<div class="row">

											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Issue Title</label> <input
														type="text" class="form-control title-right2" readonly
														id="article_title" placeholder="" autocomplete="off"
														value="${taskManagementVo.issue_title}">
												</div>
											</div>
											<%-- <div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Issue Id</label> <input
														type="text" class="form-control  title-right2" id="journalId"
														placeholder="" autocomplete="off"
														value="${articleDetail.issue_id}" readonly>

												</div>
											</div> --%>

										
											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Journal Name</label> <input
														type="text" class="form-control title-right2" id="journalId"
														placeholder="" autocomplete="off"
														value="${journal.journalName}" readonly>

												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Issue Volume</label> <input
														type="text" class="form-control title-right2" id="journalId"
														placeholder="" autocomplete="off"
														value="${articleDetail.last_volume_number}" readonly>

												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Issue Number</label> <input
														type="text" class="form-control title-right2" id="journalId"
														placeholder="" autocomplete="off"
														value="${articleDetail.last_issue_number}" readonly>

												</div>
											</div>
										
											<div class="col-md-6">
												<div class="form-group">
													<!-- <label for="currency">Stage</label> <input type="text"
													class="form-control" readonly id="task_status"
													placeholder="" autocomplete="off"
													> -->
													<label for="currency" class="art-left">Task Name</label> <input type="text"
														class="form-control title-right2" readonly id="task_status"
														placeholder="" autocomplete="off"
														value="${taskManagementVo.taskName}">
												</div>
											</div>
											
											<div class="col-md-6">
												<div class="form-group">
													<!-- <label for="currency">Stage</label> <input type="text"
													class="form-control" readonly id="task_status"
													placeholder="" autocomplete="off"
													> -->
													<label for="currency" class="art-left">Task Stage</label> <input type="text"
														class="form-control title-right2" readonly id="task_status"
														placeholder="" autocomplete="off"
														value="${taskManagementVo.taskStatus}">
												</div>
											</div>


											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Schedule Start </label> <input
														type="text" class="form-control title-right2" readonly
														id="sch_start_time" placeholder="" autocomplete="off"
														value="<fmt:formatDate pattern = "dd-MM-yyyy" value = "${taskManagementVo.schStartTime}" />">
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Schedule End </label> <input
														type="text" class="form-control title-right2" readonly
														id="sch_end_time" placeholder="" autocomplete="off"
														value="<fmt:formatDate pattern = "dd-MM-yyyy" value = "${taskManagementVo.taskEstTimeFrom}" />">
												</div>
											</div>

										
										<%-- 	<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Assign Reason</label> <input
														type="text" class="form-control title-right2" id="journalId"
														placeholder="" autocomplete="off"
														value="${taskManagementVo.assignReason}" readonly>

												</div>
											</div>
											
											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Remark</label> <input type="text"
														class="form-control title-right2" id="journalId" placeholder=""
														autocomplete="off" value="${taskManagementVo.comments}"
														readonly>

												</div>
											</div> --%>
											
											<div class="col-md-6">
												<div class="form-group">
													<label class="art-left test-lft">Comments  </label> <span><button
															type="button" class="btn btn-outline-success date-boxbtn "
															data-toggle="modal" data-target="#tasksArticleList">
															<i class=""></i>View Comment
														</button> </span>
												</div>
											</div>
										</div>
										
									</div>
									
									<div class=" mt-3">
										<c:if test="${flagDash eq null}">
											<a class="btn btn-outline-danger" href="#"
												onclick="GroupTaskList()"><i class="fa fa-close"></i>
												Cancel</a>
										</c:if>
										<c:if test="${flagDash eq '1'}">
											<a class="btn btn-outline-danger" href="${context}/dashboard">
												<i class="fa fa-close"></i> Cancel
											</a>
										</c:if>
										<c:if test="${flagDash eq '2'}">
											<a class="btn btn-outline-danger" href="${context}/dashboard">
												<i class="fa fa-close"></i> Cancel
											</a>
										</c:if>

										<!-- <a class="btn btn-outline-danger" href="#"
											onclick="GroupTaskList()"><i class="fa fa-close"></i>
											Cancel</a> -->
										<%-- &nbsp; <a class="btn btn-outline-dark" href="#"
											onclick="PauseTask(${article_task_id})"><i
											class="fa fa-pause"></i> Pause</a> &nbsp; --%>
									<%-- 	<c:if test="${roleId eq 2}">
											<a class="btn btn-outline-info" href="#" onclick="allfile()"><i
												class="fa fa-download"></i> Download</a> &nbsp;
											</c:if>
										<c:if test="${roleId ne 2}">
											<a class="btn btn-outline-info" href="#"
												onclick="Downloadfiles()"><i class="fa fa-download"></i>
												Download</a> &nbsp;
											</c:if> --%>
										<c:if test="${skip eq 'YES'}">
											<button type="button" class="btn btn-outline-primary"
												data-toggle="modal" data-target="#skipTasks">
												<i class="fa fa-arrow-right"></i> Skip
											</button>
										</c:if>

									
										<c:choose>

											<c:when test="${approval eq 'YES'}">
												<button type="button" class="btn btn-outline-success"
													data-toggle="modal" data-target="#addapproval">
													<i class="fa fa-check"> </i> Approve
												</button>
											</c:when>
										</c:choose>
										<c:choose>

											<c:when test="${approval ne 'YES'}">
												<button type="button" class="btn btn-outline-success"
													data-toggle="modal" data-target="#addtask">
													<i class="fa fa-check"></i> Complete Action
												</button>
											</c:when>
										</c:choose>
										

										<c:choose>
											<c:when test="${assignBack eq 'YES'}">
												<button type="button" class="btn btn-outline-primary"
													data-toggle="modal" data-target="#assignback">
													<i class="fa fa-arrow-left"></i>Assign Back
												</button>
											</c:when>



											<%-- <c:otherwise>
												<button type="button" class="btn btn-outline-primary"
													data-toggle="modal" data-target="#assignback">
													<i class="fa fa-arrow-left"></i> Assign Back 
												</button>
											</c:otherwise> --%>
										</c:choose>


							

										<!-- Modal -->
										 <c:choose>
											 <c:when test="${journalIssueEdite eq 'YES'}">
												<button type="button" class="btn btn-outline-success"
													onclick="editeIssueMakeUpLIst(${articleDetail.issue_id});">
													<i class="fa fa-check"></i> Edit Issue
												</button>
											</c:when>
										</c:choose>
										<button type="button"
											class="btn btn-outline-success"
											data-toggle="modal" data-target="#fileInventory" data-placement="top" title="View Files">
											<i class=""></i>File Inventory
										</button>&nbsp;
										<button type="button" class="btn btn-outline-success"
											onclick="downloadExcel(${articleDetail.issue_id})"
											data-placement="top" title="Download  Excel">
											<i class="fa fa-file-excel-o" aria-hidden="true"
												style="font-size: 24px; color: red"></i>
										</button>
										<c:if test="${runValue eq 1 }">

										

											<!-- </span> -->
											<span id="task_btn">
												<button type="button" class="btn btn-outline-primary"
													onclick="createRERunFunctionality();">
													<i class="fa fa-check"></i>Re-Run
												</button> &nbsp;

												<button type="button" class="btn btn-outline-dark"
													data-toggle="modal" data-target="#assignback">
													<i class="fa fa-arrow-left"></i> Assign-Back
												</button> &nbsp;

												<button type="button" class="btn btn-outline-success"
													data-toggle="modal" data-target="#addtask">
													<i class="fa fa-check"></i> Approve
												</button> &nbsp;
											</span>
										</c:if>
									</div>

								</form>

								<div id="pageLoder" class="loading-box" style="display: none;">
									<img class="loader-logo" src="resources/images/loader.png">
									<div class="loader"></div>
								</div>
								<!-- error model -->

								

							</div>
						</div>
							<div class="modal fade" id=tasksArticleList role="dialog">
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
																						<td><fmt:formatDate value="${temp.commentDate}" pattern="yyyy-MM-dd hh:mm a" /></td>
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
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	function GroupTaskList() {
		if (document.getElementById("flag").value == 1){

			document.getElementById("groupTask").action = "issueMyTask";
			document.getElementById("groupTask").method = "POST";
			document.getElementById("groupTask").submit();

		}
		else if(document.getElementById("flag").value == 2){
			document.getElementById("groupTask").action = "dashboard"; // for produnction edtior
			document.getElementById("groupTask").method = "GET";
			document.getElementById("groupTask").submit();
		}else{
			document.getElementById("groupTask").action = "issuegrouptask"; // grouptask
			document.getElementById("groupTask").method = "POST";
			document.getElementById("groupTask").submit();
		}
	}

	function PauseTask(val) {
		document.getElementById("article_task_id").value = val;
		document.getElementById("groupTask").action = "pausetask";
		document.getElementById("groupTask").method = "POST";
		document.getElementById("groupTask").submit();
	}

	function Downloadfiles(){
		document.getElementById("groupTask").action="download-Completedtask-file";
	    document.getElementById("groupTask").method="POST";
		document.getElementById("groupTask").submit();
	}
	
	function allfile() {
		document.getElementById("groupTask").action = "file";
		document.getElementById("groupTask").method = "POST";
		document.getElementById("groupTask").submit();
	}


// 	$(function() {
// 		$('#task_btn').hide();
// 	});


	function createRERunFunctionality()
	{

		$('#pageLoder').show();
		setTimeout(function(){hideLoader('Task Executed');}, 5000);
	}

	
	
	function createRunFunctionality(taskID,runId){
	var aId = document.getElementById("article_id").value
	var jId = document.getElementById("journalId").value  
	var wId = document.getElementById("workFlowId").value  
	
		
		
		var mappingJSON = {};
		mappingJSON["task_id"] = taskID;
		mappingJSON["runId"] = runId;
		mappingJSON["workflow_id"] = wId;

		mappingJSON["article_id"] = aId;
		var mappingInfo = JSON.stringify(mappingJSON);
		$.ajax({
			url : '/saveTaskRunId',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				if(/successfully/ig.test(result.responseText)){
					$(location).attr('href',"getDepartmentHead");
					
					createRERunFunctionality();
		    	}else {
		    		
		    	}
			},
			error : function(e) {
				console.log(e.message);
			}
		});
	}

	function createRunFunctionalitywindows(taskID,runId){
		var aId = document.getElementById("article_id").value
		var jId = document.getElementById("journalId").value  
		var wId = document.getElementById("workFlowId").value  
		
			//alert(aId +"  "+jId+" "+wId);
			//alert(taskID+"dfg"+runId);
			$('#pageLoder').show();
			    		setTimeout(function(){hideLoader('Task Executed');}, 18000);
			
			//var deprtId = document.getElementById("deptID").value;
		//	var userId = document.getElementById("userDepartment").value;
			
			var mappingJSON = {};
			mappingJSON["task_id"] = taskID;
			mappingJSON["runId"] = runId;
			mappingJSON["workflow_id"] = wId;

			mappingJSON["article_id"] = aId;
			var mappingInfo = JSON.stringify(mappingJSON);
			$.ajax({
				url : '/saveTaskRunIdwindow',
				type : "POST",
				data : mappingInfo,
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				cache : false,
				success : function(result) {
					if(/successfully/ig.test(result.responseText)){
						$(location).attr('href',"getDepartmentHead");
						
						createRERunFunctionality();
			    	}else {
			    		$('#pageLoder').show();
			    		setTimeout(function(){hideLoader('Task Executed');}, 10000);
			    		//alert(result.responseText);
			    	}
				},
				error : function(e) {
					console.log(e.message);
				}
			});
		}

	$(".progress-bar-fill").css({"width":"100%","transition":"5s"});

	
// 	function createRunFunctionality(taskID){
// 		alert(taskID);
// 		$('#pageLoder').show();
// 		setTimeout(function(){hideLoader('Task Executed');}, 5000);
// 	}

	function hideLoader(actions){
		if (confirm(actions+" Successfully.")) {
			$('#pageLoder').hide();
			$('#run_task').hide();
			$('#task_btn').show();
		}
	}

	function createApproveFunctionality(){
		$('#pageLoder').show();
		setTimeout(function(){hideLoader('Approved');}, 5000);
	}
	
	</script>
<script>
$(document).ready(function(){
	
    $("#div11").delay(10000).fadeIn(1000);
    $("#div21").delay(15000).fadeIn(1000);
    $("#div31").delay(30000).fadeIn(1000);
    $("#div41").delay(45000).fadeIn(1000);
    $("#div51").delay(62000).fadeIn(1000);
    $("#div61").delay(72000).fadeIn(1000);
    $("#div71").delay(72000).fadeIn(1000);
   
    $("#div12").delay(9900).fadeOut(1000);
    $("#div22").delay(14000).fadeOut(1000);
    $("#div32").delay(29000).fadeOut(1000);
    $("#div42").delay(44000).fadeOut(1000);
    $("#div52").delay(61000).fadeOut(1000);
    $("#div62").delay(71000).fadeOut(1000);
    
    $("#div76").hide().delay(15000).fadeIn();
    $("#div77").hide().delay(30000).fadeIn();
    $("#div78").hide().delay(45000).fadeIn();
    $("#div79").hide().delay(62000).fadeIn();
    $("#div80").hide().delay(72000).fadeIn();
   // $("#div76").delay(5000).fadeIn(500);
    

});




</script>
<script src="/resources/js/bootbox.min.js" type="text/javascript"></script>
<script>
jQuery(document).ready(function($){
	
	$(".btnrating").on('click',(function(e) {
	var previous_value = $("#selected_rating").val();
	
	var selected_value = $(this).attr("data-attr");
//	var selected_value =document.getElementById("selected_value").value;
	$("#ratingStar").val(selected_value);
	$("#selected_rating").val(selected_value);
	
	$(".selected-rating").empty();
	$(".selected-rating").html(selected_value);
	
	for (i = 1; i <= selected_value; ++i) {
	$("#rating-star-"+i).toggleClass('btn-warning');
	$("#rating-star-"+i).toggleClass('btn-default');
	}
	
	for (ix = 1; ix <= previous_value; ++ix) {
	$("#rating-star-"+ix).toggleClass('btn-warning');
	$("#rating-star-"+ix).toggleClass('btn-default');
	}
	
	}));
});
</script>
<div class="modal fade" id="addtask" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><h4>Upload File</h4></label>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>


			<form action="${context}/issueCompleteTask" method="post"
				enctype="multipart/form-data">
				<div class="modal-body">
					<input type="file" class="form-control" id="attachment"
						name="attachment" accept="application/${fileType}" placeholder="">
					<input type="hidden" name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> <span
						class="text-red mandatoryMsg">* You can upload ${fileType}
						file only</span><label><h5>Comments</h5></label>&nbsp;&nbsp; <br>
					<textarea rows="2" cols="80" maxlength="100" id="assign_reason"
						name="assign_reason"></textarea>
						<div id="textarea_feedback" style="color: red"></div>
					<div class="modal-body">
						<input type="submit" class="btn btn-primary btn-sm float-right "
							value="Submit" onClick="return uploadvalidate()"/>
					</div>
				</div>
			</form>


		</div>
	</div>
</div>
<div class="modal fade" id="fileInventory" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><b>File Inventory Details</b></label>
				<!-- 				<span class=""> Assign Back</span> -->
				<button type="button" class="close" data-dismiss="modal">&times;</button>
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
										<!-- <th>File Size</th> -->
										<th>Task Name</th>
										<th>Create At</th>
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
											<%-- <td>${temp.size}</td> --%>
											<td>${temp.taskDetails.taskName}</td>
											<td><fmt:formatDate value="${temp.createdAt}" pattern="yyyy-MM-dd hh:mm a" /></td>
											<td>
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


			<form action="${context}/issueAssignBack" method="post" name="form"
				enctype="multipart/form-data">
				<div class="modal-body">
					<label for="currency"><b>Assign To</b><sup class="text-red">&lowast;</label>
					<form:select path="TaskList" id="id" name="id" class="form-control"
						required="required">
						<form:option value="Please select a task" labelValue="" />
						<form:options items="${TaskList}" itemValue="id"
							itemLabel="taskName" />
					</form:select>
					<div>
						<label><b>Comments</b></label> <br>
						<textarea rows="2" cols="80" maxlength="200" name="assign_reason" id="assign_reason1"></textarea>
                     <div id="textarea_feedback1" style="color: red"></div>
					</div>
			<input type="file" class="" id="notmandatry" name="backFile"
						accept="application/${fileType}" placeholder=""><br>
					<input type="hidden" name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> <input
						type="submit" class="btn btn-primary btn-sm float-right" value="Submit Task" onClick="return validateAssignBack()"/><br>

				</div>
			</form>
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


			<form action="${context}/skipIssueTasks" method="post">
				<div class="modal-body">
					<label for="currency"><b>Assign To</b><sup class="text-red">&lowast;</label>
					<form:select path="nextTasks" id="id1" name="id"
						class="form-control" required="required">
						<form:option value="Please select a task" labelValue="" />
						<form:options items="${nextTasks}" itemValue="id"
							itemLabel="taskName" />
						<%-- <form:option value="Please select a task" labelValue="" />
						<form:options items="${nextTasks}" itemValue="id"
							itemLabel="taskName" /> --%>
					</form:select>
					<div>
						<label><b>Comments</b></label> <br>
						<textarea rows="2" cols="80" maxlength="200" name="assign_reason" id="assign_reason2">
                      
                   </textarea>
                   <div id="textarea_feedback2" style="color: red"></div>
					</div>

					<input type="hidden" name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> <input
						type="submit" class="btn btn-primary btn-sm float-right" value="Skip Task" onClick="return validateBack()" /><br>

				</div>
			</form>
		</div>
	</div>
</div>


<%-- 
<div class="modal fade" id=sendToAuthorProof role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><b>Compose A Mail to Author</b></label>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>


			<form action="${context}/sendCostMsg" method="post">
				<div class="modal-body">
					<label for="currency"><b>Assign To : </b></label>
					<c:forEach var="authorDetail" items="${authorDetails}"
						varStatus="counter">
						<br>
						<a>${authorDetail.title}</a>
						<a> ${authorDetail.fName}</a>
						<a> ${authorDetail.lName}</a>
						<br>
					</c:forEach>



					<label for="exampleInputEmail1"><b>Email Body</b></label>

					<textarea class="form-control" id="editor1" name="editorData"
						required>
							</textarea>


					<input type="hidden" name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> <input
						type="submit" class="btn btn-primary btn-sm float-right" /><br>

				</div>
			</form>
		</div>
	</div>
</div> --%>




<div class="modal fade" id="addapproval" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- <h2 class="bold rating-header" style="text-align: center;">
				<br> Comments
			</h2> -->
			<form action="${context}/issueApproveTask" 	enctype="multipart/form-data" method="post">
			
			  <div class="modal-body">
					<div class="modal-header">
						<label for="currency"><b>Approve Task</b></label>
				   
				      <button type="button" class="close" data-dismiss="modal">&times;</button>
			        </div>
			        
					<label><b>Comments</b></label> <br>
					<textarea rows="2" cols="80" maxlength="200" name="comments"
						id="comments"></textarea>
				    <div id="textarea_feedback3" style="color: red">&nbsp;&nbsp;</div>

                    <input type="hidden"
						name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						id="ratingStar" name="ratingStar" value=0> <input
						type="hidden" name="article_id" id="article_id"
						value="${article_id}">
						<input type="file" class="" id="attachment"
						name="attachment" accept="application/${fileType}" placeholder=""><br>
						 <input type="submit" value="Submit Task"
						class="btn flat-btn btn-primary btn-sm float-right" /><br>

				</div>
				<%-- <div class="modal-body">
				
				<input type="text" class="form-control" id="comments"
						name="comments" placeholder=""> <input type="hidden"
						name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						id="ratingStar" name="ratingStar" value=0> <input
						type="hidden" name="article_id" id="article_id"
						value="${article_id}"><input type="file" class="" id="attachment"
						name="attachment" accept="application/${fileType}" placeholder="">
						 <input type="submit" value="Submit Task"
						class="btn btn-primary btn-sm float-right" />
				</div> --%>
			</form>

		</div>
	</div>
</div>

<div class="modal fade" id="run_task_dialog" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header"></div>

		</div>
	</div>
</div>
<script>
					CKEDITOR
							.replace(
									'editorData',
									{
										// Define the toolbar groups as it is a more accessible solution.
										toolbarGroups : [ {
											"name" : "basicstyles",
											"groups" : [ "basicstyles" ]
										},  {
											"name" : "paragraph",
											"groups" : [ "list", "blocks" ]
										}, {
											"name" : "document",
											"groups" : [ "mode" ]
										}, {
											"name" : "insert",
											"groups" : [ "insert" ]
										}],
										// Remove the redundant buttons from toolbar groups defined above.
										removeButtons : 'Underline,Strike,Subscript,Superscript,Anchor,Styles,Specialchar'
									});
				</script>
				
<script>
function editeIssueMakeUpLIst(issueID){
	document.getElementById("issueId").value= issueID;
	document.getElementById("groupTask").action="editGetIssueData";
    document.getElementById("groupTask").method="POST";
	document.getElementById("groupTask").submit();
}
</script>

<script> 
$(document).ready(function() {
	var text_max = 200;

	$('#assign_reason').keyup(function() {
	    var text_length = $('#assign_reason').val().length;
	    var text_remaining = text_max - text_length;

	    $('#textarea_feedback').html(text_remaining + ' characters remaining');
	});

	});
</script>
<script>
function downloadIssueFile(val) {
	debugger;
//	alert(val);
	document.getElementById("fileURL").value =val;
	document.getElementById("groupTask").action = "dwonload_file";
	document.getElementById("groupTask").method = "GET";
	document.getElementById("groupTask").submit();
}
</script>
<script>
function validateAssignBack() {
	var id=document.getElementById("id").value;

	if(id =='Please select a task'){
		alert("Assign To cannot be blank.");
		return false;
	}
	return true;
}

function validateBack() {
	var id=document.getElementById("id1").value;

	if(id =='Please select a task'){
		alert("Assign To cannot be blank.");
		return false;
	}
	return true;
}
</script>
<script> 
$(document).ready(function() {
	var text_max = 200

	$('#assign_reason1').keyup(function() {
	    var text_length = $('#assign_reason1').val().length;
	    var text_remaining = text_max - text_length;

	    $('#textarea_feedback1').html(text_remaining + ' characters remaining');
	});

	});
function uploadvalidate() {
	var attachment=document.getElementById("attachment").value;

	if(attachment ==''){
		alert("Please select a file.");
		return false;
	}
	return true;
}
</script>

<script> 
$(document).ready(function() {
	var text_max = 200;

	$('#assign_reason2').keyup(function() {
	    var text_length = $('#assign_reason2').val().length;
	    var text_remaining = text_max - text_length;

	    $('#textarea_feedback2').html(text_remaining + ' characters remaining');
	});

	});
</script>
<script> 
$(document).ready(function() {
	var text_max = 200;

	$('#comments').keyup(function() {
	    var text_length = $('#comments').val().length;
	    var text_remaining = text_max - text_length;

	    $('#textarea_feedback3').html(text_remaining + ' characters remaining');
	});

	});
	
function downloadExcel(issueId) {
	debugger;
  //  alert("File will  download until the  issue will save ");
  		document.getElementById("issue_id").value =issueId;
	document.getElementById("groupTask").action = "issueCreateExcel";
	document.getElementById("groupTask").method = "POST";
	document.getElementById("groupTask").submit();	
}

</script>