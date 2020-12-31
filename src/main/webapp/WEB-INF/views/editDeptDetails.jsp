 <%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Edit Role Assignment</span> <span id="Date"></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->



					<div class="row ">
						<div class="col-md-12 ">
							<div class="content_box">
									<form id="dept" name="dept">
									<div class="box-body">

																
								<input type="hidden" name="deptID" id="deptID" value="${deptDetails.deptID}">
									
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label for="currency">Role Assignment Name</label>
												 <input
													maxlength=40 type="text" class="form-control" name="groupName"
													id="groupName" placeholder="" autocomplete="off" value="${deptDetails.groupName}">
											</div>
										</div>										
													
										<div class="col-md-4">
											<div class="form-group">	
											<label for="ExpertiseLevel">Status </label>											
												<select id="status" name="status" class="form-control">
												<c:choose>
													<c:when test="${deptDetails.status eq 'Y'} ">
														<option value="Y">Active</option>
														<option value="N">InActive</option>
													</c:when>
													<c:otherwise>
														<option value="Y">Active</option>
														<option value="N">InActive</option>
														
													</c:otherwise>
												</c:choose>
												</select>
											</div>
										</div>
										
										<div class="col-md-4">
											<div class="form-group">
												<label for="ExpertiseLevel">Role</label>												
												<form:select path="roleList" id="roleID"
													name="roleID" class="form-control">
													<option value="${deptDetails.role.roleID}">${deptDetails.role.roleName}</option>
													<form:options items="${roleList}" itemValue="roleID"
														itemLabel="roleName" />
												</form:select>
											</div>
										</div>							
									
									</div>
									
								</div>
									
									<div class="box-footer">
										<div class="text-right">
											<a class="btn btn-outline-danger" href="${context}/deptDetails"><i class="fa fa-close"></i> Cancel</a> &nbsp;
											<a class="btn btn-danger" href="#" onclick="updateEditDeptDetails(${deptDetails.deptID})"><i class="fa fa-save"></i> Save</a>
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
	