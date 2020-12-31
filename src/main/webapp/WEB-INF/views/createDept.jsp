
<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-6">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Create Role Assignment</span> <span id="Date"></span>
						</div>
					</div>
					<div class="col-md-6">
						<label class="mandatoryMsg">All <sup class="text-red">(&lowast;)</sup>
							marked fields are mandatory
						</label>
					</div>
				</div>
				<!--main_tittle_End-->


				<div class="row ">
					<div class="col-md-12 ">
						<div class="content_box">
						<form id="dept" name="dept">
							<div class="box-body">
									<div class="">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label class="new-lbl" for="currency">Role Assignment Name <sup class="text-red">&lowast;</sup></label>
													<input type="text" class="form-control" name="groupName" maxlength=40
														required id="groupName" placeholder="" autocomplete="off">
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group">
													<label class="new-lbl" for="ExpertiseLevel">Status <sup
													class="text-red">&lowast;</sup></label>

													<select id="status" name="status" class="form-control">
														<option value="Select Status">Select Status</option>
														<option value="Y">Active</option>
														<option value="N">InActive</option>
													</select>
												</div>
											</div>
											
											<div class="col-md-4">
												<div class="form-group">
												    <label class="new-lbl for="ExpertiseLevel">Choose Role for Role Assignment <sup class="text-red">&lowast;</sup>
												</label>
													<form:select path="roleList" id="roleID" name="roleID"
														class="form-control">
														<form:option value="Please select a role..." labelValue="" />
														<form:options items="${roleList}" itemValue="roleID"
															itemLabel="roleName" />
													</form:select>
												</div>
											</div>

											

										</div>

									</div>

								
							</div>
							
							<div class="box-footer text-right">
								<div class="">
									<a class="btn btn-outline-danger"
										href="${context}/deptDetails"><i class="fa fa-close"></i>
										Cancel</a> &nbsp;
									<!-- 	<input type="button" onclick="saveDepartment()" value="Save">  -->
									<a class="btn btn-danger"
										onclick="saveDepartment()"><i class="fa fa-save"></i>
										Save</a>
								</div>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
$('#groupName').on('input', function() {
var cursor_pos = $(this).getCursorPosition()
if(!(/^[a-zA-Z ]*$/.test($(this).val())) ) {
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
	function validate(){
	
	var groupName=document.getElementById("groupName").value;
	var status=document.getElementById("status").value;
	var roleID=document.getElementById("roleID").value;
	//var holidayGrpId=document.getElementById("holidayGrpId").value;
	
	$("#groupName").css("color", "black");
	if(groupName==''){
		alert("Role Assignment name cannot be blank.");
		return false;
	}
	
	if (!/^[a-zA-Z ]*$/g.test(groupName)) {
		alert("Invalid characters");
		$("#groupName").css("color", "red");
		return false;
	}
	
	if(status=='Select Status'){
 		alert("Status cannot be blank.");
 		return false;
 	} 
	
	if(roleID=='Please select a role...'){
 		alert("Role cannot be blank.");
 		return false;
 	}
	
// 	if(holidayGrpId=='Please select a group...'){
// 		alert("Holiday cannot be blank.");
// 		return false;
// 	}	

	
	return true;
}

	function saveDepartment() {
		
		 if(validate()){ 
			 if(confirm("Are you sure you want to create this Role Assignment ?")){
		document.getElementById("dept").action = "saveDept";
		document.getElementById("dept").method = "POST";
		document.getElementById("dept").submit();
		/* alert("Group Created Successfully") */
		 }
		}	
	}
		
	</script>