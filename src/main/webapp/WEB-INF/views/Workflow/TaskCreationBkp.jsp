<%@ include file="/WEB-INF/includes/include.jsp"%>
<style>
.hide {
	display: none;
}
</style>
<form name="Workflow" id="Workflow">
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Configure Workflow</span>  
							</div>
						</div>
					<div class="col-md-6">
						<label class="mandatoryMsg">All <sup class="text-red">(&lowast;)</sup> marked fields are mandatory</label> 
						</div>
					 
					<div class=" col-sm-12  ">
					<div class="content_box">
							<div class="box-body">
						<!-- Tabs Start-->
						<input class="form-control" type="hidden" name="listString"
							id="listString">
						<%-- 					<input class="form-control" type="hidden" name="WorkflowName" id="WorkflowNameId" value="${workflowName}"> --%>
						<div class="tabContainer">
							<div class="tabs">
								<ul>
									<li class="active"><strong>Task
												Creation</strong></li>
									<li>Define Rules</li>
									<li>Preview</li>

								</ul>
							</div>
						</div>


						<div class=" mt-20">
							<div class="white-bg">

								<!--tab 1 start-->
								<div class=" mt10">

									<!--tab content radio button start-->
									<%-- 								<c:if test="${workflowName eq null}"> --%>
									 

										<div class="tab-pad border-1">

											<div id='Show-wf'>
												<div class="form-group row">
											    <label for="staticEmail" class="col-sm-1 col-form-label">Create New <sup class="text-red">&lowast;</sup></label>
											    <div class="col-sm-4">
											      <c:if test="${workflowName eq null}">
											      <input type="text" id="WorkflowNameId" class="form-control" placeholder="Workflow name" autocomplete=flase name="name" value="${workflowName}">
                                                  </c:if>
                                                  <c:if test="${workflowName ne null}">
											      <input type="text" id="WorkflowNameId" class="form-control" placeholder="Workflow name"  name="name" value="${workflowName}" >
                                                  </c:if>
											      
											    </div>
											     <label for="staticEmail" class="col-sm-2 col-form-label" style="font-size:13px;">Workflow Type <sup class="text-red">&lowast;</sup></label>
											     
											     <div class="col-sm-2">
											    <select id="workflowType" name="workflowType" class="form-control">
												<option>Select Status</option>
												<option value="Article">Article</option>
<!-- 												<option value="Chapter">Chapter</option> -->
												<option value="Issue">Issue</option>
												</select>
											     <span id=wtermsg></span> 
											    </div>
											    
											  </div>
											</div>

										</div>

							
								 
									<div class="row mt-3">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<p class="">
															<c:if test="${workflowName eq null}">

															</c:if>
															<c:if test="${workflowName ne null}">
																<span>Workflow Name: </span>
																<span class="font-bold">${workflowName}</span>
																<span class="font-bold">${workflowNameMess}</span>
															</c:if>

															<%--  <span>Workflow Name: </span> <span class="font-bold">${workflowName}</span><span class="font-bold">${workflowNameMess}</span>  --%>
															<input class="form-control" type="hidden"
																name="workflowid" id="workflowid" value="${workflowid}"> <span class="text-right pull-right "> 
																<span class="font-bold"></span>
																<button type="button"
																	class="btn btn-outline-danger btn-sm"
																	data-toggle="modal" data-target="#addtask">
																	<i class="fa fa-tasks font-icon "></i>
																	&nbsp;&nbsp;Create a new task
																</button>
															</span>


														</p>


										</div>


										<div class="clearfix"></div>
										<div class="col-sm-12">
											<div class="task-panel">
												<div class="col-sm-6 ">
													<div class="task-font">Available Tasks</div>

													<div class="task-height">

														<ol
															class="tasklist vertical connected-sortable droppable-area1 ui-sortable">
															<c:forEach var="temp" items="${taskDetails}"
																varStatus="counter">
																<li class="draggable-item ui-sortable-handle back-bgs" ><a
																	href="#">${temp.taskName}<span class="hide">${temp.id}</span></a></li>
															</c:forEach>

														</ol>

													</div>
												</div>
												<div class="col-sm-6">
													<div class="task-font">Preview<sup class="text-red">&lowast;</sup><small id="preErr"></small></div>
													<div class="task-height">
														<ol
															class="tasklist vertical connected-sortable droppable-area2 ui-sortable"
															id="task_preview">
															<c:forEach var="temp" items="${workflowTaskSeqlist}"
																varStatus="counter">
																<li class="draggable-item ui-sortable-handle">
																<a href="#">${temp.task.taskName}<span class="hide">${temp.task.id}</span></a></li>
															</c:forEach>
														</ol>
													</div>
												</div>
											</div>
											<div class=" pull-right ">
												<button type="button" class="btn btn-danger"
													onclick="savecreateTask()">Save & Next</button>
												<button type="button" class="btn btn-outline-danger"
													onclick="WorkflowDraftAndExit()">Draft & Exit</button>
												
												<button type="button" class="btn btn-outline-danger"
													onclick="WorkflowList()">Cancel</button>
												<!-- <input type="submit" value="Click me" /> -->
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
				</div>
			</div>
		</div>

		<!--Material Tabs End-->

	</div><!-- end of wrapper -->

	<select name="workflowTaskName" id="workFlowTaskNameId"
		style='display: none' multiple="multiple">
	</select>

	<!-- <div class="pull-right martop15">
		<div class="clearfix"></div>
	</div> -->
	<!------------add user modal end------------->


	<!--Container-->


</form>

<!-- Modal popup for create new task -->
<div class="modal fade" id="addtask" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Create a new task</h5>
				 
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>


			<form  id=creatask>
				<div class="modal-body">
					<div class="form-group">
						<label for="taskName">Task Name <sup class="text-red">&lowast;</sup></label>
						<input type="text" class="form-control" id="taskName"
							name="taskName" required="required" placeholder="Enter Task Name">
					</div>
					<input class="form-control" type="hidden" name="workflowName"
						id="workflowName" value="${workflowName}">
					<button type="button" onclick="createNewTask()"class="btn btn-danger modalBtn">Submit</button>
				</div>
			</form>


		</div>
	</div>
</div>
<!------End  popup for create new task------->



<script type="text/javascript">
// $("#WorkflowNameId").keypress(function(){
// 	  $("span").text(i += 1);
// 	});

function createNewTask() {
	var worname= $("#WorkflowNameId").val(); 
	var taskName= $("#taskName").val(); 
	//alert(taskName);
	if (!/^[a-zA-Z ]*$/g.test(taskName)) {
		alert("Task name only be character");
		return false;}
	if(taskName==''){
		alert("Task name cannot be blank ");
		return false;
	}
	
	else{
	//alert(""+taskName);
	document.getElementById("workflowName").value=worname;
	document.getElementById("creatask").action = "createNewTask";
	document.getElementById("creatask").method = "POST";
	document.getElementById("creatask").submit();
	}
}
	function validate() {
		$("#wtermsg").empty();
		$("#preErr").empty();
		var custName = document.getElementById("WorkflowNameId").value;
		var workflowType = document.getElementById("workflowType").value;
		var task_preview = document.getElementById("task_preview").children;;
		//alert(task_preview.length);
		
		if (custName == '') {
			alert("Workflow name cannot be blank and it must be an unique value.");
			return false;
		}
		if (!/^[a-zA-Z ]*$/g.test(custName)) {
			alert("Invalid characters");
			$("#custName").css("color", "red");
			return false;
		}
		if(workflowType == 'Select Status'){
			//$("#wtermsg").empty();
			//$("#wtermsg").append("Workflow type cannot be Empty").css("color", "red");
			alert("Workflow type cannot be empty");
			return false;
		}
		
		if(task_preview.length<=4){
		//	$("#preErr").empty();
			$("#preErr").append("Please drag and drop at least 5 task").css("color", "red");
			return false;
		}
		return true;
	}
	function WorkflowDraftAndExit() {
		if (validate()) {
			var taskpre = document.getElementById("task_preview").children;
			var datArary = [];
			var i;
			for (i = 0; i < taskpre.length; i++) {

				var previewList = taskpre[i].getElementsByTagName('span')[0].innerText;
				console.log(previewList);
				datArary.push(previewList);
			}
			document.getElementById("listString").value = datArary;
			var worname= $("#WorkflowNameId").val(); 
			document.getElementById("workflowName").value=worname;
			document.getElementById("Workflow").action = "workflowDraftAndExit";
			document.getElementById("Workflow").method = "POST";
			document.getElementById("Workflow").submit();
			alert("Workflow Added Draft Successfully. Please Update it latter");
		}
	}

	function savecreateTask() {
		if (validate()) { 
			var worname= $("#WorkflowNameId").val(); 
			document.getElementById("workflowName").value=worname;
			var taskpre = document.getElementById("task_preview").children;
			var datArary = [];
			var i;
			for (i = 0; i < taskpre.length; i++) {
				var previewList = taskpre[i].getElementsByTagName('span')[0].innerText;
				console.log(previewList);
				datArary.push(previewList);
			}

			document.getElementById("listString").value = datArary;
			document.getElementById("Workflow").action = "createworkflow";
			document.getElementById("Workflow").method = "POST";
			document.getElementById("Workflow").submit();
		 //  alert("Workflow Added Successfully");
		}

	}
	function getTaskList() {
		var workflowSelectedTaskName = document
				.getElementById("workFlowTaskNameId");
		var ol = document.getElementById("previewId");
		var list = ol.getElementsByTagName("li");
		for (var i = 0; i <= list.length; ++i) {
			var el = document.createElement("option");
			var opt = list[i].innerHTML;
			el.textContent = opt;
			el.value = opt;
			el.selected = true;
			workflowSelectedTaskName.appendChild(el);

		}
	}
	function validateWorkflowName() {
		var workflowSelectedTaskName = document
				.getElementById("workFlowTaskNameId");

	}

	function createWorkflow1() {
		document.getElementById("Workflow").action = "createworkflow";
		document.getElementById("Workflow").method = "POST";
		document.getElementById("Workflow").submit();
	}
	function newTask() {
		document.getElementById("Workflow").action = "createNewTask";
		document.getElementById("Workflow").method = "POST";
		document.getElementById("Workflow").submit();
	}
	function TaskCreation() {
		document.getElementById("Workflow").action = "TaskCreation";
		document.getElementById("Workflow").method = "POST";
		document.getElementById("Workflow").submit();
	}
	function DefinrRule() {
		document.getElementById("Workflow").action = "DefinrRule";
		document.getElementById("Workflow").method = "POST";
		document.getElementById("Workflow").submit();
	}
	function WorkflowList() {
		document.getElementById("Workflow").action = "WorkflowList";
		document.getElementById("Workflow").method = "POST";
		document.getElementById("Workflow").submit();
	}
</script>
<script>
$('#taskName').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[a-zA-Z]*$/.test($(this).val())) ) {
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
