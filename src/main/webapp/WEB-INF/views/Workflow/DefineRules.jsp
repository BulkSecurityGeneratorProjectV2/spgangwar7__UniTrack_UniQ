
<%@ include file="/WEB-INF/includes/include.jsp"%>

<style>
.border-2 .form-control {
	width: 50% !important;
	float: right;
	margin-bottom: 10px;
}
</style>
<form name="Workflow" id="Workflow">
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
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
						<div class="col-md-6">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Configure Workflow</span>
							</div>
						</div>
						<div class="col-md-6">
							<label class="mandatoryMsg">All <sup class="text-red">(&lowast;)</sup>
								marked fields are mandatory
							</label>
						</div>

					</div>

					<div class=" col-sm-12 no-lr-pad">
						<!-- Tabs Start-->
						<div class="content_box">
							<div class="box-body">
								<div class="tabContainer">
									<div class="tabs">
										<ul>
											<li><a href="#" onclick="TaskCration">Task Creation</a></li>
											<li class="active"><a href="#"><strong>Define
														Rules</strong></a></li>
											<li><a href="#">Preview</a></li>

										</ul>
									</div>

								</div>
								<div class=" mt-20">
									<div class="bg-white border">

										<!--tab 1 start-->
										<div class=" mt10">

											<!--tab content  start-->
											<div class="section mt10" data-section="b">






												<!--tab2 content button End-->

												<div class="tab-pad no-lr-pad">
													<div class="bg-light p-3 border">
														<div class=row>
															<div class="col-xs-4 col-sm-4 col-lg-4">
																<span class="font-head">Task Configuration</span>
															</div>

															<div class="col-xs-4 col-sm-4 col-lg-4">
																<%-- <span class="font-head">Current Task Name : <mark
																	style="color: white; background-color: green;">${taskRealName}</mark>
															</span> --%>
																<!-- Ravi changed this  -->
																<span class="font-head">Current Task Name : <c:if
																		test="${taskRealName ne null}">
																		<mark style="color: white; background-color: green;">${taskRealName}</mark>
																	</c:if> <%--  <c:if test="${FistTaskName ne ''}">
															 <mark style="color: white; background-color: green;">
															 <input type="hidden" value="${FistTaskName}">
																	${FistTaskName}</mark>
															 </c:if> --%>
																</span>
															</div>
															<div class="col-xs-4 col-sm-4 col-lg-4">
																<span class="font-head">Workflow Name : <mark
																		style="color: white; background-color: green;">
																		${workflowName}</mark>
																</span>
															</div>



															<%-- <c:if test="${roleName eq null}">
														<div class="col-xs-3 col-sm-3 col-lg-3">
															<span class="font-head">Function Name : <mark
																	style="color: white; background-color: green">
																	${workflowTaskSeq.role.roleName}</mark>
															</span>
														</div>
														</c:if> --%>

															<%-- <c:if test="${roleName ne null}">
															<div class="col-xs-3 col-sm-3 col-lg-3">
																<span class="font-head">Function Name : <mark
																		style="color: white; background-color: green;">
																		${roleName.roleName}</mark>
																</span>
															</div>
														</c:if> --%>

														</div>
													</div>
													<div class="mt-20 ">
														<div class="row">
															<div class="col-sm-4">
																<div class="task-font2">Available Tasks</div>
																<div class="">
																	<div class="task-height">

																		<ol
																			class="tasklist vertical   ui-sortable">
																			<c:forEach var="temp" items="${workflowTaskSeqlist}"
																				varStatus="counter">
																				<input type="hidden" id="taskid" name="taskid"
																					value="${temp.taskId}">

																				<c:if test="${taskName eq 1}">
																					<c:choose>
																						<c:when
																							test="${temp.taskName eq taskRealName}">
																							<li class="draggable-item ui-sortable-handle bg-success "><a
																								href="#"
																								onclick="TaskConfiguration(${temp.taskId})">${temp.taskName}</a>
																							</li>
																						</c:when>
																						<c:otherwise>
																							<li class="draggable-item ui-sortable-handle "><a
																								href="#"
																								onclick="TaskConfiguration(${temp.taskId})">${temp.taskName}</a>
																							</li>
																						</c:otherwise>
																					</c:choose>

																				</c:if>
																				<c:if test="${taskName eq 2}">


																					<c:choose>
																						<c:when
																							test="${temp.task.taskName eq taskRealName}">

																							<li
																								class="draggable-item ui-sortable-handle bg-success"><a
																								href="#"
																								onclick="TaskConfiguration(${temp.taskId})">${temp.task.taskName}</a>
																							</li>
																						</c:when>
																						<c:otherwise>
																							<li class="draggable-item ui-sortable-handle"><a
																								href="#"
																								onclick="TaskConfiguration(${temp.taskId})">${temp.task.taskName}</a>
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
																<div class="task-font2">Privileges</div>
																<div class="border tab-pad col-sm-12 ">
																	<div>
																		<div class="row">
																			<%-- <div class="col-sm-6">
																				<div class="form-group">
																					<label for="tat">Turn Around Time (In
																						Hours)<sup class="text-red">&lowast;</sup></label> <input type="text" maxlength="3"  placeHolder="Max length is 3" class="form-control"
																						id="tat" onkeyup="myFunction()" name="tat"
																						value="${workflowTaskSeq.tat}" placeholder="">
																					<input type="hidden" class="form-control" id="id"
																						name="id" value="${workflowTaskSeq.id}"> <input
																						type="hidden" class="form-control"
																						id="workflowName" name="workflowName"
																						value="${workflowName}"> <input
																						type="hidden" class="form-control" id="workflowid"
																						name="workflowid" value="${workflowid}">
																				</div>
																			</div> --%>
																			<div class="col-sm-6">
																				<div class="form-group">
																					<label for="tat">Turn Around Time (In
																						Day)<sup class="text-red">&lowast;</sup>
																					</label> <input type="text" maxlength="3"
																						placeHolder="Max length is 3" class="form-control"
																						id="tat" onkeyup="myFunction()" name="tat"
																						value="${workflowTaskSeq.tat}"> <input
																						type="hidden" class="form-control" id="id"
																						name="id" value="${workflowTaskSeq.id}"> <input
																						type="hidden" class="form-control"
																						id="workflowName" name="workflowName"
																						value="${workflowName}"> <input
																						type="hidden" class="form-control" id="workflowid"
																						name="workflowid" value="${workflowid}">
																				</div>
																			</div>
																			<div class="col-sm-6">
																				<div class="form-group">
																					<label for="tat">Role Function <sup
																						class="text-red">&lowast;</sup> <%--  <c:if test="${roleName ne null}">
																					  <mark style="color: white;">${roleName}</mark>
																					 </c:if>  --%>
																					</label>

																					<form:select path="rolelist" id="RoleId"
																						name="RoleId" class="form-control" placeholder="">
																						<c:if
																							test="${workflowTaskSeq.role.roleName eq ''}">
																							<form:option value="${workflowTaskSeq.role.roleID}"
																								labelValue="${workflowTaskSeq.role.roleName}" />
																						</c:if>
																						<c:if test="${roleName eq null}">
																							<option value="${workflowTaskSeq.role.roleID}">
																								${workflowTaskSeq.role.roleName}</option>
																						</c:if>
																						<c:if test="${roleName ne null}">
																							<option value="${workflowTaskSeq.role.roleID}">
																								${roleName.roleName}</option>
																						</c:if>
																						<%-- <option value="${workflowTaskSeq.role.roleID}">
																							---------------------------------------------</option> --%>
																						<form:options items="${rolelist}"
																							itemValue="roleID" itemLabel="roleName" />
																					</form:select>

																					<%-- 
																					<form:select path="rolelist" id="RoleId"
																						name="RoleId" class="form-control" placeholder="">
																						 <form:options items="${rolelist}  itemValue="roleID"  itemLabel="roleName"/> 
																					 	 <form:options items="${rolelist}"
																							itemValue="roleID" itemLabel="roleName" />  
																					</form:select>

 --%>
																				</div>
																			</div>
																			<div class="col-sm-6">
																				<div class="form-group">
																					<!-- <label for="tat">Input Folder:</label> --> <input
																						type="hidden" class="form-control" id="tat" name=""
																						value="" placeholder=""> <input
																						type="hidden" class="form-control" id="id"
																						name="id" value="${workflowTaskSeq.id}"> <input
																						type="hidden" class="form-control"
																						id="workflowName" name="workflowName"
																						value="${workflowName}"> <input
																						type="hidden" class="form-control" id="workflowid"
																						name="workflowid" value="${workflowid}">
																				</div>
																			</div>
																			<div class="col-sm-6">
																				<div class="form-group">
																					<!-- <label for="tat">Output Folder:</label> --> <input
																						type="hidden" class="form-control" id="rr" name=""
																						value="">
																				</div>
																			</div>
																			<div class="col-sm-6">
																				<div class="form-group">
																					<label for="tat">File Type:</label> <select
																						id="fileType" name="fileType" class="form-control">

																						<option value="all"
																							${workflowTaskSeq.fileType == 'null' ? "selected" : ""}>ALL</option>
																						<option value="pdf"
																							${workflowTaskSeq.fileType == 'pdf' ? "selected" : ""}>PDF</option>
																						<option value="docx"
																							${workflowTaskSeq.fileType == 'docx' ? "selected" : ""}>Word
																							File</option>
																						<option value="xml"
																							${workflowTaskSeq.fileType == 'xml' ? "selected" : ""}>XML</option>
																						<option value="zip"
																							${workflowTaskSeq.fileType == 'zip' ? "selected" : ""}>ZIP</option>
																						<option value="docx or pdf"
																							${workflowTaskSeq.fileType == 'docx,.pdf' ? "selected" : ""}>Word
																							File And PDF</option>

																					</select>
																				</div>
																			</div>

																			<%-- <div class="col-sm-4">
                              <div class="form-group">
                                <label for="tat">Task:</label>
                                <form:select path="taskDetails"  id="role" name="role"  class="form-control">
				                 <form:option value = "" labelValue = ""/>
				                  <form:options items = "${taskDetails}" itemValue="id" itemLabel="taskName" />
				                  </form:select>  
                              </div>
                            </div> --%>
																			<div class="col-sm-3">
																				<div class="form-group">
																					<input type="hidden" id="taskname" name="taskname">
																					<div>
																						<label for="email">Email <sup
																							class="text-red">&lowast;</sup></label>
																					</div>
																					<label class="radio-inline  mr-3"> <input
																						checked id="yes" type="radio" name="emailFlag"
																						value="YES"
																						${workflowTaskSeq.emailFlag == 'YES' ? 'checked' : ''}>
																						YES
																					</label> <label class="radio-inline"> <input
																						id="no" type="radio" name="emailFlag" value="NO"
																						${workflowTaskSeq.emailFlag == 'NO' ? 'checked' : ''}>
																						NO
																					</label>


																				</div>
																			</div>

																			<div class="col-sm-3">
																				<div class="form-group">
																					<div>
																						<label for="readOnly">File Access <sup
																							class="text-red">&lowast;</sup></label>
																					</div>
																					<label class="radio-inline  mr-3"> <input
																						checked type="radio" name="readOnly" value="YES"
																						${workflowTaskSeq.readOnly == 'YES' ? 'checked' : ''}>
																						Read-Only
																					</label> <label class="radio-inline"> <input
																						type="radio" name="readOnly" value="NO"
																						${workflowTaskSeq.readOnly == 'NO' ? 'checked' : ''}>
																						Read/Write
																					</label>
																				</div>
																			</div>
																			<div class="col-sm-3">
																				<div class="form-group">
																					<div>
																						<label for="assign_back">Assign Back<%--  ${workflowTaskSeq.assign_back} --%> <sup
																							class="text-red">&lowast;</sup></label>
																					</div>
																					<label class="radio-inline  mr-3"> <input
																						type="radio" name="assign_back" value="YES"
																						${workflowTaskSeq.assign_back == 'YES' ? 'checked' : ''}>
																						YES
																					</label> <label class="radio-inline"> <input
																						checked type="radio" name="assign_back" value="NO"
																						${workflowTaskSeq.assign_back == 'NO' ? 'checked' : ''}>
																						NO
																					</label>
																				</div>
																			</div>
																			<div class="col-sm-3">
																				<div class="form-group">
																					<div>
																						<label for="approval">Approval <sup
																							class="text-red">&lowast;</sup></label>
																					</div>
																					<label class="radio-inline  mr-3"> <input
																						checked type="radio" name="approval" value="YES"
																						${workflowTaskSeq.approval == 'YES' ? 'checked' : ''}>
																						YES
																					</label> <label class="radio-inline"> <input
																						type="radio" name="approval" value="NO"
																						${workflowTaskSeq.approval == 'NO' ? 'checked' : ''}>
																						NO
																					</label>
																				</div>
																			</div>
																			<div class="col-sm-3">
																				<div class="form-group">
																					<div>
																						<label for="email">Skip <sup
																							class="text-red">&lowast;</sup></label>
																					</div>
																					<label class="radio-inline  mr-3"> <input
																						checked type="radio" name="skip" value="YES"
																						${workflowTaskSeq.skip == 'YES' ? 'checked' : ''}>
																						YES
																					</label> <label class="radio-inline"> <input
																						type="radio" name="skip" value="NO"
																						${workflowTaskSeq.skip == 'NO' ? 'checked' : ''}>
																						NO
																					</label>
																				</div>
																			</div>
																			<div class="col-sm-3">
																				<div class="form-group">
																					<div>
																						<label for="email">Email Temp <sup
																							class="text-red">&lowast;</sup></label>
																					</div>
																					<select class="form-control" name="emailId">
																						<c:forEach var="emailTemp" items="${emailTemp}"
																							varStatus="counter">
																							<c:if
																								test="${emailTemp.id eq workflowTaskSeq.emailId}">
																								<option value="${emailTemp.id}" selected>
																									${emailTemp.emailTempName}</option>
																							</c:if>
																							<option value="${emailTemp.id}">
																								${emailTemp.emailTempName}</option>
																						</c:forEach>
																					</select>
																				</div>
																			</div>
																			<c:if test="${workflowType eq 'Issue'}">
																			<div class="col-sm-3">
																				<div class="form-group">
																					<div>
																						<label for="email">Edit Issue <sup
																							class="text-red">&lowast;</sup></label>
																					</div>
																					<label class="radio-inline  mr-3"> <input
																						checked type="radio" name="editeIssueJournal"
																						value="YES"
																						${workflowTaskSeq.editeIssueJournal == 'YES' ? 'checked' : ''}>
																						YES
																					</label> <label class="radio-inline"> <input
																						type="radio" name="editeIssueJournal" value="NO"
																						${workflowTaskSeq.editeIssueJournal == 'NO' ? 'checked' : ''}>
																						NO
																					</label>
																				</div>
																			</div></c:if>
																			<div class="mt-10">&nbsp;</div>

																			<div
																				class="col-sm-12 mt-20 text-right border-top pt-3">
																				<span><button type="button"
																						class="btn btn-danger"
																						onclick="saveTAT('${taskRealName}')">Save</button></span>


																			</div>
																		</div>
																	</div>
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

								</div>
							</div>

							<div class="box-footer">
								<div class="row">
									<div class=" col-sm-12  text-right">
										<button type="submit" class="btn btn-dark"
											onclick="WorkflowList()">Cancel</button>
										<button type="submit" class="btn btn-danger"
											onclick="WorkflowPreview()">Save &amp; Next</button>
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
</form>

<!-- <div class="pull-right martop15">
	  <div class="clearfix"></div>
	</div> -->

<!--Container-->

<script>
	
	function TaskCreation(){
		document.getElementById("Workflow").action="TaskCreation";
	    document.getElementById("Workflow").method="POST";
		document.getElementById("Workflow").submit();
	}
	function WorkflowPreview(){
		document.getElementById("Workflow").action="WorkflowPreview";
	    document.getElementById("Workflow").method="POST";
		document.getElementById("Workflow").submit();
	}
	function DefinrRule(){
		document.getElementById("Workflow").action="DefinrRule";
	    document.getElementById("Workflow").method="POST";
		document.getElementById("Workflow").submit();
	}
	function validate() {
		var tat = document.getElementById("tat").value;
		var RoleId = document.getElementById("RoleId").value;
		var fileType = document.getElementById("fileType").value;
		//alert(RoleId);
		if (tat == '') {
			alert("Turn around time cannot be blank.");
			return false;
		}
		if (!/^[0-9 ]*$/g.test(tat)) {
			alert("Turn around time only be number.");
			return false;
		}
		if (RoleId == '') {
			alert("Role function cannot be blank.");
			return false;
		}
		if (fileType == 'Select Status') {
			alert("File type cannot be blank.");
			return false;
		}

		return true;
	}
	
	function saveTAT(val){
		if (validate()) {
		document.getElementById("taskname").value=val;
		document.getElementById("Workflow").action="SaveTaskConfig";
	    document.getElementById("Workflow").method="POST";
		document.getElementById("Workflow").submit();
	}
	}
	
	function TaskConfiguration(val){
		document.getElementById("taskid").value=val;

		document.getElementById("Workflow").action="editTaskConfiguration";
	    document.getElementById("Workflow").method="POST";
		document.getElementById("Workflow").submit();
	}
	function WorkflowList(){
		document.getElementById("Workflow").action="workflowList";
	    document.getElementById("Workflow").method="GET";
		document.getElementById("Workflow").submit();
	}
</script>
<script>
$('input#tat').keyup(function(e){ 
    if(this.value.substring(0,1) == "0")
    {
       this.value = this.value.replace(/^0+/g, '');             
    }         
});

$('#tat').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[(0-9)]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
    })

	$.fn.getCursorPosition = function() {
	    if(this.length == 0) return -1
	    return $(this).getSelectionStart()
	}
	$.fn.setCursorPosition = function(position) {
	    if(this.lengh == 0) return this
	    return $(this).setSelection(position, position)
	}
	$.fn.getSelectionStart = function(){
	  if(this.lengh == 0) return -1
	  input = this[0]
	  var pos = input.value.length
	  if (input.createTextRange) {
	    var r = document.selection.createRange().duplicate()
	    r.moveEnd('character', input.value.length)
	    if (r.text == '') 
	    pos = input.value.length
	    pos = input.value.lastIndexOf(r.text)
	  } else if(typeof(input.selectionStart)!="undefined")
	  pos = input.selectionStart
	  return pos
	}
	$.fn.setSelection = function(selectionStart, selectionEnd) {
	  if(this.lengh == 0) return this
	  input = this[0]
	  if(input.createTextRange) {
	    var range = input.createTextRange()
	    range.collapse(true)
	    range.moveEnd('character', selectionEnd)
	    range.moveStart('character', selectionStart)
	    range.select()
	  }
	  else if (input.setSelectionRange) {
	    input.focus()
	    input.setSelectionRange(selectionStart, selectionEnd)
	  }
	  return this
	} 
</script>
<script>
setTimeout(function() {
	    $('#message').fadeOut('fast');
	}, 2000);
</script>
</body>
</html>

