
<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Edit User</span> <span id="Date"></span>
						</div>
					</div>
				</div>

				<!--main_tittle_End-->



				<div class="row ">
					<div class="col-md-12 ">
						<div class="content_box">
							<form id="users" name="users">
								<div class="box-body pb-0">
									<input type="hidden" name="userID" id="userID"
										value="${userDetails.userID}"> <input type="hidden"
										name="password" id="password" value="${userDetails.password}">
									<div class="">

										<div class="row">

											<div class="col-md-4">
												<div class="form-group mb-2">
													<label for="currency">First Name</label> <input type="text"
														maxlength=15 class="form-control" name="firstName" id="firstName"
														placeholder="" autocomplete="off"
														value="${userDetails.firstName}">
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group mb-2">
													<label for="currency">Last Name</label> <input type="text"
														maxlength=15 class="form-control" name="lastName" id="lastName"
														placeholder="" autocomplete="off"
														value="${userDetails.lastName}">
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group mb-2">
													<label for="currency">User Email</label> <input type="text" maxlength=40
														class="form-control" name="username" id="username"
														placeholder="" autocomplete="off"
														value="${userDetails.username}">
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group mb-2">
													<label for="ExpertiseLevel">Status </label> <select
														id="active" name="active" class="form-control">
														<c:choose>
															<c:when test="${userDetails.active == 'Y'}">
																<option value="Y">Active</option>
																<option value="N">InActive</option>
															</c:when>
															<c:otherwise>
																<option value="N">InActive</option>
																<option value="Y">Active</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group mb-2">
													<label for="ExpertiseLevel">Role <sup
														class="text-red">&lowast;</sup></label>

													<form:select path="roleList" id="roleID" name="roleID"
														class="form-control">
														<option value="${roleN.roleID}">${roleN.roleName}</option>
														<%-- 	<form:option value="Please Select" labelValue="" /> --%>
														<form:options items="${roleList}" itemValue="roleID"
															itemLabel="roleName" />
													</form:select>
												</div>
											</div>
										<%-- 	<div class="col-md-9">
												<div class="form-group mb-3">
													<label for="ExpertiseLevel">Department </label>
													<div class="bg-white border pl-2 pr-2 pt-2"
														style="min-height: 34px;">
														<div id="deptlist"></div>
														<c:forEach items="${userDetails.group1}" var="userDetails">
															<label id="rmvlb" class="rmdpt"> <input type="checkbox"
																id="role" name="depID" checked="true"
																value="${userDetails.deptID}">${userDetails.groupName}</label>
														</c:forEach>
													</div>
												</div>
											</div>
 --%>


										</div>
									</div>

								</div>

								<div class="box-footer text-right">
									<a class="btn btn-outline-danger" href="${context}/userDetails"><i
										class="fa fa-close"></i> Cancel</a> &nbsp; <a
										class="btn btn-danger" href="#"
										onclick="updateUserDetails(${userDetails.userID})"><i
										class="fa fa-save"></i> Save</a>
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
   $('#firstName').on('input', function() {
	    var cursor_pos = $(this).getCursorPosition()
	    if(!(/^[a-zA-Z]*$/.test($(this).val())) ) {
	        $(this).val($(this).attr('data-value'))
	        $(this).setCursorPosition(cursor_pos - 1)
	        return
	    }
	    $(this).attr('data-value', $(this).val())
	})
	
	$('#lastName').on('input', function() {
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
<script>
function validateEditeUser() {

	var firstName = document.getElementById("firstName").value;
	var lastName = document.getElementById("lastName").value;
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
//	var deptID = document.getElementById("roleID").value;
	var active = document.getElementById("active").value;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
//	var check= $('input[name="depID"]:checked').val();
	
	if (firstName == '') {
		alert("First Name cannot be blank.");
		return false;
	}
	if (!/^[a-zA-Z ]*$/g.test(firstName)) {
		alert("Invalid characters");
		$("#firstName").css("color", "red");
		return false;
	}
	if (lastName == '') {
		alert("Last Name cannot be blank.");
		return false;
	}
	if (!/^[a-zA-Z ]*$/g.test(lastName)) {
		alert("Invalid characters");
		$("#lastName").css("color", "red");
		return false;
	}

	if (username == '') {
		alert("Email cannot be blank.");
		return false;
	}
	
	if (!username.match(mailformat)) {
	 		alert("Enter valid email format");

	 		return false;
		}
	if (password == '') {
		alert("Password cannot be blank.");
		return false;
	}
	
	
	if (active == 'Select Status') {
		alert("Status cannot be blank.");
		return false;
		}

// 	if (deptID == 'Please Select') {
// 			alert("Role cannot be blank.");
// 			return false;
// 	}
// 	if (check ==null) {
// 		alert("Pleace select a department ");
// 		return false;
// }

	return true;
	
}

function updateUserDetails(userID) {
	if (validateEditeUser()) {
		if(confirm("Are you sure you want to update this user ?")){
	document.getElementById("userID").value = userID;
	//document.getElementById("password").value = password;
	document.getElementById("users").action = "updateUserDetails";
	document.getElementById("users").method = "POST";
	document.getElementById("users").submit();
	}
		}
	}


// //$( document ).ready(function() {
//  $('#roleID').on('change', function(e) {
// 	//e.preventDefault();
// 	 $( ".rmdpt" ).remove();
// 	//var selectBox = document.getElementById("deptID");
// 	//var selectedValue = selectBox.options[selectBox.selectedIndex].value;
// 	var selectBox = $("#roleID").val(); //new methord for jquery value 		

// 	var roleID = this.value;
// 	var mappingJSON = {};
// 	mappingJSON["roleID"] = roleID;
// 	var mappingInfo = JSON.stringify(mappingJSON);
// 	$.ajax({
// 		url : '${context}/departmentlistbyrole',
// 		type : "POST",
// 		data : mappingInfo,
// 		contentType : "application/json; charset=utf-8",
// 		dataType : "json",
// 		cache : false,
// 		success : function(result) {
// 			$('#deptlist').html(result.responseText);
// 		},
// 		error : function(e) {
// 			console.log(e.message);
// 		}
// 	});
// });

</script>