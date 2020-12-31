
<%@ include file="/WEB-INF/includes/include.jsp"%>
<form id="users" name="users">

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-6">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Create User</span> <span id="Date"></span>
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
								<div class="box-body">
									<div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label class="new-lbl" for="currency">First Name <sup
														class="text-red">&lowast;</sup></label> <input type="text"
														maxlength=25 class="form-control" name="firstName"
														required id="firstName" placeholder="" autocomplete="off">
												</div>
											</div>
											<div class="col-md-4">

												<div class="form-group">
													<label class="new-lbl" for="currency">Last Name <sup
														class="text-red">&lowast;</sup></label> <input type="text"
														maxlength=25 class="form-control" required name="lastName"
														id="lastName" placeholder="" autocomplete="off">
												</div>
											</div>

											<div class="col-md-4">

												<div class="form-group">
													<label class="new-lbl" for="currency">User Email <sup
														class="text-red">&lowast;</sup></label> <input type="email"
														maxlength=50 class="form-control" name="username"
														id="usernameid" placeholder="" autocomplete="off">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label class="new-lbl" for="currency">Password <sup
														class="text-red">&lowast;</sup></label> <input type="password"
														class="form-control" name="password" id="password"
														required placeholder="" autocomplete="off">
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group">
													<label class="new-lbl" for="ExpertiseLevel">Status
														<sup class="text-red">&lowast;</sup>
													</label> <select id="active" name="active" class="form-control">
														<option value="Select Status">Select Status</option>
														<option value="Y">Active</option>
														<option value="N">InActive</option>
													</select>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label class="new-lbl" for="ExpertiseLevel">Role <sup
														class="text-red">&lowast;</sup></label>
													<form:select path="roleList" id="roleID" name="roleID"
														class="form-control">
														<form:option value="Please Select" labelValue="" />
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
											href="${context}/userDetails">Cancel</a> &nbsp; <a
											class="btn btn-danger" href="#" onclick="saveUser()">Save</a>
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
<script>
   $('#firstName').on('input', function() {
	    var cursor_pos = $(this).getCursorPosition()
	    if(!(/^[a-zA-Z ]*$/.test($(this).val())) ) {
	        $(this).val($(this).attr('data-value'))
	        $(this).setCursorPosition(cursor_pos - 1)
	        return
	    }
	    $(this).attr('data-value', $(this).val())
	});
	
	$('#lastName').on('input', function() {
	    var cursor_pos = $(this).getCursorPosition()
	    if(!(/^[a-zA-Z]*$/.test($(this).val())) ) {
	        $(this).val($(this).attr('data-value'))
	        $(this).setCursorPosition(cursor_pos - 1)
	        return
	    }
	    $(this).attr('data-value', $(this).val())
	});

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

		function validate() {

			var firstName = document.getElementById("firstName").value;
			var lastName = document.getElementById("lastName").value;
			var username = document.getElementById("usernameid").value;
			var password = document.getElementById("password").value;
			var deptID = document.getElementById("roleID").value;
			var active = document.getElementById("active").value;
			var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	//		var check= $('input[name="depID"]:checked').val();
			
			if (firstName == '') {
				alert("First name cannot be blank.");
				return false;
			}
			if (!/^[a-zA-Z ]*$/g.test(firstName)) {
				alert("Invalid characters");
				$("#firstName").css("color", "red");
				return false;
			}
			if (lastName == '') {
				alert("Last name cannot be blank.");
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

			if (deptID == 'Please Select') {
					alert("Role cannot be blank.");
					return false;
			}
// 			if (check ==null) {
// 				alert("Pleace select a department ");
// 				return false;
// 		}
		
			return true;
			
		}
		function saveUser() {
			if (validate()) {
				document.getElementById("users").action = "saveUsers";
				document.getElementById("users").method = "POST";
				document.getElementById("users").submit();
			}
		}
		
	/* 	
		$('#roleID').on('change', function(e) {
			e.preventDefault();
			//var selectBox = document.getElementById("deptID");
			//var selectedValue = selectBox.options[selectBox.selectedIndex].value;
			var selectBox = $("#roleID").val(); //new methord for jquery value 		
			var roleID = this.value;
			var mappingJSON = {};
			mappingJSON["roleID"] = roleID;
			var mappingInfo = JSON.stringify(mappingJSON);
			$.ajax({
				url : '${context}/departmentlistbyrole',
				type : "POST",
				data : mappingInfo,
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				cache : false,
				success : function(result) {
					$('#deptlist').html(result.responseText);
				},
				error : function(e) {
					console.log(e.message);
				}
			});
		});
		 */
		
	</script>