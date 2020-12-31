
<%@ include file="/WEB-INF/includes/include.jsp"%>

<form:form name="assignEmail" id="assignEmail" method="POST">
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<div class=" col-sm-12 no-lr-pad">
						<!-- Tabs Start-->
						<c:if test="${not empty message}">
							<div class="alert alert-${css} alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong> ${message}</strong>
							</div>
						</c:if>
						<div class="content_box">
							<div class="box-body">
								<div class="tabContainer">
									<div class="tabs">
										<ul>
											<li class="active"><a href="#"><strong>Email
														configuration </strong></a></li>
										</ul>
									</div>
								</div>
								<div class=" mt-20">
									<div class="white-bg">
										<div class=" mt10">
											<div class="section mt10" data-section="b">
												<div
													class="tab-pad border-1 form-bg  mt-10 col-sm-12 no-lr-pad">
													<div class=row>
														<div class="col-xs-4 col-sm-4 col-lg-4">
															<span class="font-head">Email Configuration</span>
														</div>

														<div class="col-xs-4 col-sm-4 col-lg-4">
															<span class="font-head">Current Task Name : <mark
																	style="color: white; background-color: green;">${taskRealName}</mark>
															</span>
														</div>
														<input type="hidden" class="form-control" id="jId"
															name="jId" value="${jrid}"> <input type="hidden"
															class="form-control" id="workflowid" name="workflowid"
															value="${workflowid}">
														<div class="col-xs-4 col-sm-4 col-lg-4">
															<span class="font-head">Workflow Name : <mark
																	style="color: white; background-color: green;">
																	${workflowName}</mark>
															</span>
														</div>
													</div>
													<div class="mt-20 ">
														<div class="row">
															<div class="col-sm-4">
																<div class="task-font2">Available Tasks</div>
																<div class="border-2 tab-pad col-sm-12">
																	<div class="task-height">
																		<input type="hidden" id="taskid" name="taskid"
																			value="${taskid}">
																		<ol class="tasklist vertical   ui-sortable">
																			<c:forEach var="temp"
																				items="${manageJournalWorkflows}"
																				varStatus="counter">
																				<c:if test="${taskName eq 1}">
																					<li class="draggable-item ui-sortable-handle "><a
																						href="#"
																						onclick="emailConfiguration(${temp.task_id})">${taskName}</a>
																					</li>
																				</c:if>
																				<c:if test="${taskName eq 2}">
																					<c:choose>
																						<c:when test="${temp.task_id eq taskid}">

																							<li
																								class="draggable-item ui-sortable-handle bg-success"><a
																								href="#"
																								onclick="emailConfiguration(${temp.task_id})">${temp.task.taskName}</a>
																							</li>
																						</c:when>
																						<c:otherwise>

																							<li class="draggable-item ui-sortable-handle "><a
																								href="#"
																								onclick="emailConfiguration(${temp.task_id})">${temp.task.taskName}</a>
																							</li>

																						</c:otherwise>
																					</c:choose>

																				</c:if>
																			</c:forEach>
																		</ol>

																	</div>
																</div>
															</div>
															<div class="col-sm-8">
																<div class="task-font2">Email</div>
																<div class="border-2 tab-pad col-sm-12 ">
																	<div class="row">

																		<div class="col-md-4">
																			<input type="search" class=" "
																				placeholder="Search Role" id="myInput"
																				onkeyup="filterFunction()">
																		</div>
																		<div class="col-md-8 form-group">
																			<label for="ExpertiseLevel">Select Role Name
																				(Cc) </label> <select id="roleID">
																				<option>Select Role</option>
																				<c:forEach var="temp" items="${roleDetails}"
																					varStatus="counter">
																					<option value="${temp.roleID}">${temp.roleName}</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>

																	<div>
																		<div>
																			<div>
																				<div class="form-group">
																					<input type="hidden" id="taskname" name="taskname">
																				</div>

																			</div>

																			<div id="showHideFrom">


																				<input class="" type="hidden" name="ejwId"
																					value="${emailJournalTask.ejwId}"> <input
																					class="" type="hidden" id="roleid" name="roleId">
																				<div>
																					<div class="row">

																						<div class="col-md-3">
																							<div class="">
																								<label for="currency" class="">User Name
																									(To) </label>
																								<div class="form-group">
																									<input type="hidden" name="to" id="to"
																										value="${userList.userID}"> <input
																										type="text" class="form-control "
																										placeholder="" autocomplete="off"
																										value="${userList.firstName} ${userList.lastName}"
																										readonly>

																								</div>
																							</div>
																						</div>
																						<div class="col-md-3">
																							<div class="">
																								<input type="hidden" name="nextTaskid" id="nextTaskid"
																									value="${nextTaskId}">

																								<c:if test="${nextUserList eq 'NA'}">

																																
																								<label for="currency" class="">Next User Name(Finish)</label>
																									<div class="form-group"><input type="text" class="form-control "
																									placeholder="" autocomplete="off" value="NOT AVAILABLE" readonly>
																									</div>
																								</c:if>
																								<c:if test="${nextUserList ne 'NA'}">
																									<label for="currency" class="">Next
																										User Name(Finish)</label>
																									<div class="form-group">
																										<input type="hidden" name="nextUserid" id="nextUserid"
																											value="${nextUserList.userID}"> <input
																											type="text" class="form-control "
																											placeholder="" autocomplete="off"
																											value="${nextUserList.firstName} ${nextUserList.lastName}"
																											readonly>

																									</div>
																								</c:if>
																							</div>
																						</div>


																						<div class="col-md-3">
																							<div class="">
																							<input type="hidden" name="preTaskid" id="preTaskid"
																									value="${preTaskId}">
																								<c:if test="${preTaskDetails eq 'NA'}">
																									<label for="currency" class="">Reply
																										User Name </label>
																									<div class="form-group">
																										<input type="text" class="form-control "
																											placeholder="" autocomplete="off"
																											value="NOT AVAILABLE" readonly>
																									</div>
																								</c:if>
																								<c:if test="${preTaskDetails ne 'NA'}">
																									<label for="currency" class="">Reply
																										User Name</label>
																									<div class="form-group">
																										<input type="hidden" name="preUserid" id="preUserid"
																											value="${preTaskDetails.userID}"> <input
																											type="text" class="form-control "
																											placeholder="" autocomplete="off"
																											value="${preTaskDetails.firstName} ${preTaskDetails.lastName}"
																											readonly>
																									</div>
																								</c:if>
																							</div>
																						</div>

																						<input type="hidden" name="cc" id=userID>
																						<div class="col-md-3">
																							<div class="" id="userlist"></div>

																						</div>
																					</div>

																				</div>

																				<input type="hidden" id="emailid" name="emailid">
																				<div class="form-group " id="tempid"></div>


																				<div class="form-group " id="viewtemplate">
																					<div id="template">${template}</div>
																				</div>



																			</div>


																			<div class="col-sm-12 mt-20 text-right">

																				<span><button type="button"
																						class="btn btn-danger"
																						onclick="saveTATforEmail('${taskRealName}')">Save</button></span>


																			</div>
																		</div>
																	</div>
																	<%-- </c:if>
																		<c:if test="${taskList.emailFlag == 'no'}">
																		</c:if> --%>
																</div>

															</div>
														</div>
													</div>
												</div>

												<!--tab content End-->

											</div>

										</div>
									</div>


									<!--Material Tabs End-->
									<div class="row">
										<div class=" col-sm-12  text-right mt-3">
											<a type="submit" class="btn btn-outline-danger mb-3"
												href="${context}/journalList">Cancel</a> <a type="submit"
												class="btn btn-danger mb-3" href="${context}/journalList">Save
												&amp; Next</a>
											<!--  <a class="flat-btn pull-right" href="/results/jsp/options/workflows/createWorkflowNext.jsp">  Next</a> -->
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
</form:form>



<script>
	
	function saveTATforEmail(taskName){
		if(assignEmailvalidate()){
// 		var roleID=document.getElementById("roleID").value;
// 		var userId = document.getElementById("userrole").value;
// 		document.getElementById("userID").value = userId;
		document.getElementById("taskname").value=taskName;
		var taskid= document.getElementById("taskid").value;
		var emailID=document.getElementById("emailTempId").value;
		document.getElementById("emailid").value=emailID;
		document.getElementById("assignEmail").action="saveAssignEmail";
	    document.getElementById("assignEmail").method="POST";
		document.getElementById("assignEmail").submit();
	}
}
	function emailConfiguration(val){
		//alert("taskid :" );
		document.getElementById("taskid").value=val;
	//	alert("taskid :" +val)
		document.getElementById("assignEmail").action="emailJournalMail";
	    document.getElementById("assignEmail").method="POST";
		document.getElementById("assignEmail").submit();
	}

</script>

<script>
$("#no").click(function(){
	
	  $("#showHideFrom").hide();
	});

	$("#yes").click(function(){
		window.onload
	  $("#showHideFrom").show();
	  
	}); 
	
	
	window.onload = function getEmailTemplate(){
		$.ajax({
			url : '${context}/getEmailTemplate',
			type : "GET",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				
				$('#tempid').html(result.responseText);
				
			},
			error : function(e) {
				console.log(e.message);
			}
		});
	}
	
	function getTemplate(){
		var tempID = document.getElementById("emailTempId").value;
		var mappingJSON = {};
		mappingJSON["tempId"] = tempID;
		var mappingInfo = JSON.stringify(mappingJSON);
		$.ajax({
			url : '${context}/getEmailTemplateById',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				//alert(result.responseText);
				$('#template').html(result.responseText);
			},
			error : function(e) {
				console.log(e.message);
			}
		});
		
		
	}
	
	

</script>
<script>
function filterFunction() {
	  var input, filter, a, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  div = document.getElementById("showHideFrom");
	  a = div.getElementsByTagName("option");
	  for (i = 0; i < a.length; i++) {
	    txtValue = a[i].textContent || a[i].innerText;
	    if (txtValue.toUpperCase().indexOf(filter) > -1) {
	      a[i].style.display = "";
	    } else {
	      a[i].style.display = "none";
	    }
	  }
	}
</script>
<script>
function assignEmailvalidate() {
	var emid = document.getElementById("emailTempId").value;
	debugger;
	if(emid=="Select Email Template"){
		alert("Please select email template");
		return false;
	}  
	var userId = document.getElementById("userrole");
	    if(userId){
	       // var myEleValue= userId.value;
	       var usd = document.getElementById("userrole").value;
	       if(usd=="Select User ..."){
	    	  return true;
	       }
	       else{
	        document.getElementById("userID").value = usd;
	        return true;
	        }
	    }

	return true;
	}
</script>

<script type="text/javascript">

	$('#roleID').on('change', function(e) {
		e.preventDefault();
		//var selectBox = document.getElementById("deptID");
		//var selectedValue = selectBox.options[selectBox.selectedIndex].value;
		var selectBox =$("#roleID").val();  //new methord for jquery value 		
		var roleId = this.value;
		//alert(roleId);
		var mappingJSON = {};
		mappingJSON["roleId"] = roleId;
		var mappingInfo = JSON.stringify(mappingJSON);
		$.ajax({
			url : '${context}/getuserListByroleID',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				//alert(result);
				$('#userlist').html(result.responseText);
			},
			error : function(e) {
				console.log(e.message);
			}
		});
	});

</script>

