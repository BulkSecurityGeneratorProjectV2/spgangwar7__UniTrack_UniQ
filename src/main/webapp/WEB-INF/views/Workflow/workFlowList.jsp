<%@ include file="/WEB-INF/includes/include.jsp" %>
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Workflow Details</span> <span id="Date"></span> ${workflowNameMess}
								<span class="ml-auto">
								<button type='button' class="btn btn-sm btn-outline-danger" onclick="createNewworkflow()"><i class="fa fa-tasks font-icon "></i> Create New Workflow</button></span>
								&nbsp;<button type="button" class="btn btn-outline-danger btn-sm "
									data-toggle="modal" data-target="#addtask">
									<i class="fa fa-tasks font-icon "></i> &nbsp;&nbsp;Create a new
									task
								</button>
								&nbsp; <a class="btn btn-sm btn-outline-danger" href="getAllTaskList">View Task List</a>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->
					<c:if test="${not empty message}"> 
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>  ${message}</strong>
					</div>
				</c:if> 
                      <form name="Workflow" id="Workflow">
						<div class="row">
							<div class="col-md-12">
											<div class="content_box">
													<div class="box-body">
														<table class="table table-striped table-bordered m-0"
															id="deptTable">
											<thead class="table-head">
												<tr>
                                    <th>Action</th>
                                    <th>Workflow Name</th>
                                    <th>Workflow Type</th>
                                    <th>Created By</th>
                                    <th>created At</th>
                                  </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="temp" items="${workflowslist}">
                                  <tr>
                                 <td class="icon-box">
			                       <input type="hidden" name="workflowid" id="workflowid">
			                          <c:if test="${temp.status eq 'Y'}">  
			                        <a href="#" onclick="editworkFlow(${temp.id})"  data-placement="top"  title="Edit Info"><i class="fa fa-edit edit-icon"></i></a>
			                         <a href="#" onclick="WorkflowPreview(${temp.id})"  data-placement="top"  title="Preview Info"><i class="fa fa-eye edit-icon"></i></a>
			                        </c:if>
			                         <c:if test="${temp.status eq 'N'}">  
			                          <a href="#" onclick="editworkFlowTask(${temp.id})"  data-placement="top"  title="Edit Info"><i class="fa fa-edit edit-icon"></i></a>
			                          </c:if>
			                        </td>
			                        <td><c:out value="${temp.name}"/></td>
			                         <td><c:out value="${temp.workflowType}"/></td>
			                        <td><c:out value="${temp.createdBY}"/></td>
			                        <td align="center"><c:out value="${temp.createdAT}"/></td>
			                      </tr>
                                </c:forEach>
                                 </tbody>
                                </table>
                                
                                <!--pagination-->
                               
                               <!--pagination--> 
                                
          
             </div>
</div>
</div>
  	<div class="modal fade" id="addtask" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Create a new task</h5>

				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>


			<form id=taskList>
				<div class="modal-body">
					<div class="form-group">
						<label for="taskName">Task Name <sup class="text-red">&lowast;</sup></label>
						<input type="text" class="form-control" id="taskName" maxlength=60
							name="taskName" required="required" placeholder="Enter Task Name">
					</div>
					<button type="button" onclick="createNewTask()"
						class="btn btn-danger modalBtn">Submit</button>
				</div>
			</form>


		</div>
	</div>
</div>
</div>

<script> 

function createNewworkflow(){

	document.getElementById("Workflow").action="workflowCreation";
    document.getElementById("Workflow").method="POST";
	document.getElementById("Workflow").submit();
}

function editworkFlow(val){
	document.getElementById("workflowid").value=val;
	document.getElementById("Workflow").action="editworkFlow";
    document.getElementById("Workflow").method="POST";
	document.getElementById("Workflow").submit();
}
function editworkFlowTask(val){
	document.getElementById("workflowid").value=val;
	document.getElementById("Workflow").action="editworkFlowTask";
    document.getElementById("Workflow").method="POST";
	document.getElementById("Workflow").submit();
}
function WorkflowPreview(val){
	document.getElementById("workflowid").value=val;
	document.getElementById("Workflow").action="WorkflowPreview";
    document.getElementById("Workflow").method="POST";
	document.getElementById("Workflow").submit();
}
</script>
<script>

function createNewTask() {
	var worname= $("#WorkflowNameId").val(); 
	var taskName= $("#taskName").val(); 
	//alert(taskName);
	if (!/^[a-z _A-Z ]*$/g.test(taskName)) {
		alert("Task name only be character");
		return false;}
	if(taskName==''){
		alert("Task name cannot be blank ");
		return false;
	}
	
	else{
	//alert(""+taskName);
	document.getElementById("Workflow").action = "createNewTask";
	document.getElementById("Workflow").method = "POST";
	document.getElementById("Workflow").submit();
	}
}

</script>

<script>
$('#taskName').on('input', function() {
	    var cursor_pos = $(this).getCursorPosition()
	    if(!(/^[a-zA-Z _]*$/.test($(this).val())) ) {
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
	</form>
				</div>
			</div>
		</div>
	</div>