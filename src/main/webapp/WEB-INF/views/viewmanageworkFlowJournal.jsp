
<%@ include file="/WEB-INF/includes/include.jsp"%>
<style>
/* Center the loader */
#loader {
	position: absolute;
	left: 50%;
	top: 50%;
	z-index: 1;
	width: 150px;
	height: 150px;
	margin: -75px 0 0 -75px;
	border: 16px solid #f3f3f3;
	border-radius: 50%;
	border-top: 16px solid #3498db;
	width: 120px;
	height: 120px;
	-webkit-animation: spin 1s linear infinite;
	animation: spin 2s linear infinite;
}

@
-webkit-keyframes spin { 0% {
	-webkit-transform: rotate(0deg);
}

100%
{
-webkit-transform
:
 
rotate
(360deg);
 
}
}
@
keyframes spin { 0% {
	transform: rotate(0deg);
}

100%
{
transform
:
 
rotate
(360deg);
 
}
}

/* Add animation to "page content" */
.animate-bottom {
	position: relative;
	-webkit-animation-name: animatebottom;
	-webkit-animation-duration: 1s;
	animation-name: animatebottom;
	animation-duration: 1s
}

@
-webkit-keyframes animatebottom {from { bottom:-100px;
	opacity: 0
}

to {
	bottom: 0px;
	opacity: 1
}

}
@
keyframes animatebottom {from { bottom:-100px;
	opacity: 0
}

to {
	bottom: 0;
	opacity: 1
}
}
</style>
<form name="Workflow" id="Workflow">
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<c:if test="${not empty message}">
								<div class="alert alert-${css} alert-dismissible" role="alert">
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<strong> ${message}</strong>
								</div>
							</c:if>
							<div class="main_tittle d-flex align-items-center">
							<div class="col-md-8"><label for="currency"><spring:message code="book.journal" /> Name : ${journalName}</label></div>
								<div class="col-md-4">
									<label for="currency">Workflow Name : ${workflowNmae}</label>
									 <input
										type="hidden" id="jId" name="jId" value="${journalId}">
									<input type="hidden" id="listString" name="listString">
									<input type="hidden" id="wfId" name="wfId" value="${wfId}">

								</div>
								
							</div>
						</div>
					</div>
					<div class=" col-sm-12 col-xs-12 no-lr-pad">

						<div class="content_box">
							<div class="box-header">
								<span class="font-head">Task Configuration</span>
							</div>
							<div class="box-body">
								<!--tab 1 start-->
								<div>
									<!--tab content start-->
									<div class="section" data-section="b">

										<div class="tab-pad p-0">

											<div class="">
												<div class="px-3 py-0">
													<div class="row">
														<div class="col-sm-3">
															<div class="task-font2">Available Tasks</div>
														</div>

														<div class="col-sm-3">
															<div class="task-font2">Role</div>
														</div>

														<div class="col-sm-3">

															<div class="task-font2">User List</div>
														</div>
														<div class="col-sm-3">

															<div class="task-font2">File</div>
														</div>
													</div>
												</div>
												<div class="task-height border p-3 bg-white">
													<div class="row">

														<div class="col-sm-3">
															<div class="border-2 tab-pad col-sm-12">
																<ol
																	class="tasklist vertical connected-sortable  ui-sortable">
																	<c:forEach var="temp" items="${manageJournalWorkflows}"
																		varStatus="counter">
																		<li class="draggable-item ui-sortable-handle"><a
																			href="#">${temp.task.taskName}</a></li>
																	</c:forEach>
																</ol>
															</div>
														</div>

														<div class="col-sm-3">
															<div class="border-2 tab-pad col-sm-12">
																<ol
																	class="tasklist vertical connected-sortable  ui-sortable">
																<%-- 	<c:forEach var="temp" items="${workflowTaskSeqlist}"
																		varStatus="counter"> --%>
																		<c:forEach var="temp" items="${manageJournalWorkflows}"
																		varStatus="counter">
																		<input type="hidden" id="roleId" name="roleId">
																		<li class="draggable-item ui-sortable-handle"><a
																			href="#">${temp.role.roleName}</a></li>
																	</c:forEach>
																</ol>
															</div>
														</div>
<!-- Image loader -->
						<div id='loader' style='display: none;'></div>
						<!-- Image loader  	data-toggle="modal" data-target="#chnageUser" -->
														<div class="col-sm-3">
															<div class="border-2 tab-pad col-sm-12">
																<ol
																	class="tasklist vertical connected-sortable  ui-sortable">
																	<c:forEach var="temp" items="${manageJournalWorkflows}"
																		varStatus="counter">
																		<li class="draggable-item ui-sortable-handle"
																			style="background: #f3e4b5; color: #363636; /* padding: 15.5px 0px; */ min-height: 42px;"><a
																		
																			onclick="getUserList(${temp.role_id},${temp.id},${temp.task_id})"
																			href="#">${temp.users.firstName}&nbsp;${temp.users.lastName}</a>
																		</li>
																	</c:forEach>
																</ol>
															</div>
														</div>
														<div class="col-sm-3">
															<div class="border-2 tab-pad col-sm-12">
																<ol
																	class="tasklist vertical connected-sortable  ui-sortable">
																	<c:forEach var="temp" items="${manageJournalWorkflows}"
																		varStatus="counter">
																		<li class="draggable-item ui-sortable-handle"
																			style="min-height: 42px;"><a href="#"
																			data-placement="top" title="Ftp Input" class="py-0">${temp.fileFtpInput}</a>
																			<a href="#" data-placement="top" title="Ftp Output"
																			class="py-0">${temp.fileFtpOutput}</a></li>
																	</c:forEach>
																</ol>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<!--tab content End-->

									</div>
									<div class="clearfix"></div>
								</div>
							</div>

							<!--Material Tabs End-->
							<div class="box-footer text-right">
								<span class="">
									<button type="submit" class="btn btn-outline-danger"
										onclick="WorkflowList()">Cancel</button>
								</span>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</form>
	<div class="modal fade" id="chnageUser" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="${context}/updateJournalWorkflow"  method="post">
					<div class="modal-body">
						<div class="modal-header">
							<label for="currency"><h5>Change User</h5></label>

							<button type="button" class="close" data-dismiss="modal">&times;</button>

						</div>

						<div id="userList"></div><br>
						<input type="submit" value="Submit"
							class="btn flat-btn btn-primary btn-sm float-right" /><br>

					</div>
				</form>

			</div>
		</div>
	</div>
<div class="pull-right martop15">
	<div class="clearfix"></div>
</div>

<!--Container-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function WorkflowList(){
		document.getElementById("Workflow").action="journalList";
	    document.getElementById("Workflow").method="GET";
		document.getElementById("Workflow").submit();
	}
	

	function getUserList(roleID,mjwkid,taskId){
//	alert(roleID+" - "+mjwkid);
		var mappingJSON = {};
		mappingJSON["roleId"] = roleID;
		mappingJSON["mjwId"] = mjwkid;
		mappingJSON["taskId"] = taskId;
		
		var mappingInfo = JSON.stringify(mappingJSON);
		$.ajax({
			url : '${context}/userlistbyrole',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			 beforeSend: function(){
	                // Show image container
	                $("#loader").show();
	               },
			success : function(result) {
				//		alert(result.responseText);
					var str='';	
				 $('#userList').html(result.responseText);
				 $("#loader").hide();
				 $("#chnageUser").modal('show');
			}
		
		});	
	}
	
</script>
<script src="taskCreation_files/jquery-ui.min.js"></script>

</body>
</html>

