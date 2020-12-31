
<%@ include file="/WEB-INF/includes/include.jsp"%>
<style>
.brdNone {
	border: none !important;
}

.headngWorkflw {
	display: block;
	background: #1eacab;
	color: #fff;
	padding: 10px;
}
</style>
<form name="Workflow" id="Workflow">
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<div class="main_tittle d-flex align-items-center">
						<input type="hidden" name="type" value="${type}">
						<span class="mr-2">Manage ${type} Workflow</span> <span id="Date">Mon
								, 26 Aug 2019</span>
								<span class="ml-auto"><label for="currency"><spring:message code="book.journal" /> Name : ${journalName}</label></span><span class="ml-auto">
								<button type="submit" class="btn btn-outline-danger fa fa-arrow-left"
									onclick="WorkflowList()">Back To <spring:message code="book.journal" /></button>
							</span>
						<%-- 	<span class="ml-auto"><label for="currency">Journal Name : ${journalName}</label></span><span class="ml-auto"><a href="${context}/journalList"
								class="btn btn-sm btn-outline-danger">	<i
								onclick="WorkflowList()" class="fa fa-arrow-left"></i> Back To Journal</a></span> <span class="pull-right">
							</span> --%>
						
					<%-- 
						<span class="mr-2">Manage ${type} Workflow</span>
						<input type="hidden" name="type" value="${type}">
						<a type="button" class="btn btn-outline-danger"
									onclick="WorkflowList()">Cancel</a> --%>
					</div>
					<div class="content_box">

						<div class="box-body">
							<div class="">
								<!--tab 1 start-->
								<div class="">
									<div class="bg-white p-3 border mb-3">
									<!--tab content  start-->
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label for="currency">Choose ${type} Workflow</label><br>
												<form:select path="workflowslist" id="id" name="id"
													class="form-control">
													<form:option value="Please Select" labelValue="" />
													<form:options items="${workflowslist}" itemValue="id"
														itemLabel="name" />
												</form:select>
												<input type="hidden" id="jId" name="jId"
													value="${journalId}"> <input type="hidden"
													id="listString" name="listString"> <input
													type="hidden" id="wfId" name="wfId" value="${wfId}">
												<input type="hidden" id="issueworkflow" name="issueworkflow"
													value="${issueworkflow}">

											</div>
										</div>
										<div class="col-md-4">
											<button type="submit" class="btn btn-danger mt-4"
											onclick="savemanageworkFlowJournal()">Search</button>
										</div>
									</div>
									</div>


									<div class="section mt10" data-section="b" id="taskconfig">

										<div class="content_box mb-0" style="box-shadow:none;">
											<div class="box-header">
												<span class="font-head">Task Configuration</span>
											</div>
											<div class="box-body bg-white">
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
	
															<div class="task-font2"> File FTP Location</div>
														</div>
													</div>
												</div>

												<div class="task-height border-0 px-3 bg-white">
												<div class="row ">

													<div class="col-sm-3">
														<div class="border-2 tab-pad bg-white">
															<ol
																class="tasklist vertical connected-sortable  ui-sortable">
																<c:forEach var="temp" items="${workflowTaskSeqlist}"
																	varStatus="counter">

																	<li class="draggable-item ui-sortable-handle pdd-set2"><a
																		href="#" onclick="TaskConfiguration(${temp.taskId})">${temp.task.taskName}
																			<%-- --- ${temp.role.roleName} --%></a></li>
																</c:forEach>
															</ol>
														</div>
													</div>

													<!-- 
 
 							group data 
                       -->

													<div class="col-sm-3">
														<div class="border-2 tab-pad bg-white">
															<ol class="tasklist vertical connected-sortable  ui-sortable ">
																<c:forEach var="temp" items="${workflowTaskSeqlist}"
																	varStatus="counter">
																	<input type="hidden" id="roleId" name="roleId">
																	<li class="draggable-item ui-sortable-handle pdd-set2"><a
																		href="#" onclick="getDepartmantList(${temp.role.roleID})">${temp.role.roleName}</a>
																	</li>
																</c:forEach>
															</ol>
														</div>
													</div>

													<div class="col-sm-3">

														<div class="border-2 tab-pad bg-white">
															<div class="form-group" id="departId">
																<ol
																	class="tasklist vertical connected-sortable  ui-sortable">
																	<c:forEach items="${department}" var="entry">
																		<li><select id="deptID" name="test[]"
																			class="form-control brdNone tasklist vertical "
																			style="background: #f2f2f2; color: #000; height:40px;">
																				<c:forEach items="${entry.value}" var="temp">
																					<option
																						value="_${temp.roleid}_${temp.userid}_${temp.taskID}">${temp.fastName} ${temp.lastName}</option>
																				</c:forEach>
																		</select></li>
																	</c:forEach>
																</ol>
															</div>

														</div>
													</div>
														<div class="col-sm-3">
														<div class="border-2 tab-pad bg-white">
															<ol
																class=" tasklist vertical connected-sortable  ui-sortable">
																<c:forEach var="temp" items="${workflowTaskSeqlist}"
																	varStatus="counter">

																	<li class="draggable-item ui-sortable-handle pdd-set2">
																	 	<div class="d-block"><input class="fileftpinput" data-placement="top"  title="Ftp Input" type=text name=fileftpInput  value="NA" style="padding: 0; margin: 0; font-size: 11px;"  required>Input File</div>
																		<div class="d-block"><input class="fileftpinput" data-placement="top"  title="Ftp Output" type=text name=fileftpOutput value="NA" style="padding: 0; margin: 0; font-size: 11px;" required>Output File</div>
																	
																	 <!--	<a>combin edting</a>
																	  	<input class="form-control" data-placement="top"  title="Ftp Output" type=text name=fileftpOutput value="NA" required>
																	 -->
																	</li>
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
							<div class="clearfix"></div>

							<!--Material Tabs End-->
							
						</div><c:if test="${workflowTaskSeqlist ne null}">
						<div class="box-footer text-right">
							
								<button type="submit" class="btn btn-outline-danger"
									onclick="WorkflowList()">Cancel</button>
								<button type="submit" class="btn btn-danger"
									onclick="savedepartment()">Save &amp; Next</button>

							<!--  <a class="flat-btn pull-right" href="/results/jsp/options/workflows/createWorkflowNext.jsp">  Next</a> -->

						</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>

</form>

<div class="pull-right martop15">
	<div class="clearfix"></div>
</div>

<!--Container-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

// $(document).ready(function(){
	 
//     $("#taskconfig").hide();
	  
// });

function validate(){
		
		var WorkFlow=document.getElementById("id").value;
		debugger
		if(WorkFlow=='Please Select'){
			alert("WorkFlow name cannot be blank.");
			return false;
		}
		
		
		return true;
	}
	
	function savemanageworkFlowJournal(){
// 		if(validate()){
		debugger
	var WorkFlow=document.getElementById("id").value;
		if(WorkFlow=='Please Select'){
			alert("WorkFlow name cannot be blank.");
			document.getElementById("Workflow").action="manageworkFlowJournal";
		    document.getElementById("Workflow").method="POST";
			document.getElementById("Workflow").submit();
		}else{
			document.getElementById("Workflow").action="savemanageworkFlowJournal";
		    document.getElementById("Workflow").method="POST";
			document.getElementById("Workflow").submit();
		}
		
	}
	function WorkflowList(){
		document.getElementById("Workflow").action="journalList";
	    document.getElementById("Workflow").method="GET";
		document.getElementById("Workflow").submit();
	}

	function TaskCreation(){
		document.getElementById("Workflow").action="TaskCreation";
	    document.getElementById("Workflow").method="POST";
		document.getElementById("Workflow").submit();
	}
	
	
	
	function savedepartment(){
		var datArary = [];
		var i;
		$("#Workflow").submit(function(e){
			e.preventDefault();
			 var x = $(this).serializeArray();
		
			 $.each(x, function(i, field){
				 debugger;
				 datArary.push(field.name + ":" + field.value + " ");
				 
				  });
			 document.getElementById("listString").value = datArary;
			// alert(datArary);
				document.getElementById("Workflow").action="savedepartment";
			    document.getElementById("Workflow").method="POST";
				document.getElementById("Workflow").submit(); 
		});
	}
	
	function selectworkflow(val){
		document.getElementById("workflowid").value=val;
		document.getElementById("Workflow").action="manageworkFlowTask";
	    document.getElementById("Workflow").method="POST";
		document.getElementById("Workflow").submit();
	}
	function saveTAT(){
		document.getElementById("Workflow").action="SaveTaskConfig";
	    document.getElementById("Workflow").method="POST";
		document.getElementById("Workflow").submit();
	}


	
	

/* 	
	
	function getDepartmantList(roleID){
		document.getElementById("roleId").value=roleID;
	//	alert(roleID);
		var roleID = roleID;
		//var userId = document.getElementById("userDepartment").value;

		var mappingJSON = {};
		mappingJSON["roleID"] = roleID;
		//mappingJSON["userId"] = userId;
		var mappingInfo = JSON.stringify(mappingJSON);
		$.ajax({
			url : '/getDepartmentListByRoleID',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				alert(result.responseText)				
				 $('#department').html(result.responseText);
			}
		
		});	
			}
	
	
 */	

</script>






<script src="taskCreation_files/jquery-ui.min.js"></script>



</form>
</body>
</html>

