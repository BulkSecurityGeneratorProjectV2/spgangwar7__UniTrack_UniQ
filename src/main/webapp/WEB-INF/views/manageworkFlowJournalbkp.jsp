
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
					<span class="mr-2">Manage WorkFlow</span>
					
					</div>
					<div class=" col-sm-12 col-xs-12 no-lr-pad">

						<div class="mt-7">
							<div class="white-bg mb-2">

								<!--tab 1 start-->
								<div class=" mt10">

									<!--tab content  start-->
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label for="currency">Choose Workflow</label><br>
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
										<button type="submit" class="btn btn-danger mt-4"
											onclick="savemanageworkFlowJournal()">Save</button>
									</div>


									<div class="section mt10" data-section="b" id="taskconfig">

										<div
											class="tab-pad border-1 form-bg  mt-10 col-sm-12 no-lr-pad">
											<div class="headngWorkflw">
												<span class="font-head">Task Configuration</span>
											</div>
											<div class="mt-20 ">

												<div class="row">

													<div class="col-sm-3">
														<div class="task-font2">Available Tasks</div>
													</div>

													<div class="col-sm-3">
														<div class="task-font2">Role</div>
													</div>

													<div class="col-sm-3">

														<div class="task-font2">Choose supplier</div>
													</div>
													
													<div class="col-sm-3">

														<div class="task-font2"> File FTP location</div>
													</div>
												</div>


												<div class="row task-height">

													<div class="col-sm-3">
														<div class="border-2 tab-pad col-sm-12">
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
														<div class="border-2 tab-pad col-sm-12">
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

														<div class="border-2 tab-pad col-sm-12">
															<div class="form-group" id="departId">
																<ol
																	class="tasklist vertical connected-sortable  ui-sortable">
																	<c:forEach items="${department}" var="entry">
																		<li><select id="deptID" name="test[]"
																			class="form-control brdNone tasklist vertical "
																			style="background: #f2f2f2; color: #000; height:52px;">
																				<c:forEach items="${entry.value}" var="temp">
																					<option
																						value="_${temp.roleid}_${temp.deptID}_${temp.taskID}">${temp.name}</option>
																				</c:forEach>
																		</select></li>
																	</c:forEach>
																</ol>
															</div>

														</div>
													</div>
														<div class="col-sm-3">
														<div class="border-2 tab-pad col-sm-12">
															<ol
																class=" vertical connected-sortable ">
																<c:forEach var="temp" items="${workflowTaskSeqlist}"
																	varStatus="counter">

																	<li class=" ">
																	<input class="fileftpinput" data-placement="top"  title="Ftp Input" type=text name=fileftpInput  value="NA" required>Input File
																	<input class="fileftpinput" data-placement="top"  title="Ftp Output" type=text name=fileftpOutput value="NA" required>Output File
																	</li>
																</c:forEach>
															</ol>
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
							<div class=" col-sm-12  no-lr-pad mb-20">
								<span class="pull-left"> </span> <span class="pull-right">
									<button type="submit" class="btn btn-outline-danger mb-3"
										onclick="WorkflowList()">Cancel</button>
									<button type="submit" class="btn btn-danger mb-3"
										onclick="savedepartment()">Save &amp; Next</button>

								</span>
								<!--  <a class="flat-btn pull-right" href="/results/jsp/options/workflows/createWorkflowNext.jsp">  Next</a> -->

							</div>
						</div>
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
	
	
	
</script>


<script>
/* $("#no").click(function(){
	
	  $("#showHideFrom").hide();
	});

	$("#yes").click(function(){
		getEmailTemplate();
	  $("#showHideFrom").show();
	  
	}); 
	 */
	
	/* function getEmailTemplate(){
		$.ajax({
			url : '/getEmailTemplate',
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
	 */
	
	/* function getTemplate(){
		var tempID = document.getElementById("emailTempId").value;
		var mappingJSON = {};
		mappingJSON["tempId"] = tempID;
		var mappingInfo = JSON.stringify(mappingJSON);
		$.ajax({
			url : '/getEmailTemplateById',
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
	 */
	

</script>



<!--drag- drop  script start-->

<!------------add user modal end------------->

<!--  Pop up Email Modal_Task Notification  start -->





<!------ Pop up Email Modal_Task Notification  End------->



<!--  Pop up Email   Email Setup  start -->



<!------ Pop up Email   Email Setup End------->


<script src="taskCreation_files/jquery-ui.min.js"></script>

<!--Ck Editor start-->
<script src="https://cdn.ckeditor.com/4.6.2/basic/ckeditor.js"></script>



</form>
</body>
</html>

