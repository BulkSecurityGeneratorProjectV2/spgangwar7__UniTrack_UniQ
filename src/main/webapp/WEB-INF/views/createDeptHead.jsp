
<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Create Group Head</span> <span id="Date"></span>
						</div>
					</div>
				</div>
				<!--main_tittle_End-->

				<div class="row ">
					<div class="col-md-12 ">
						<div class="content_box">
						<form id="users" name="users">
							<div class="box-body">								
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="ExpertiseLevel">Group <sup
													class="text-red">&lowast;</sup></label>
												<form:select path="deptDetails" id="deptID" name="deptID"
													class="form-control">
													<option value="Please Select" />Please Select</otion>
													<form:options items="${deptDetails}" itemValue="deptID"
														itemLabel="groupName" />
												</form:select>
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group" id="userlist"></div>
										</div>
										

									</div>

								
							</div>
							
							<div class="box-footer">
									<a class="btn btn-outline-danger" href="${context}/getDepartmentHead"><!-- <i
											class="fa fa-close"></i> --> Cancel</a> &nbsp; <a
											class="btn btn-danger" href="#" onclick="saveNewDeptHead()"><!-- <i
											class="fa fa-save"></i> --> Save</a>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$('#deptID').on('change', function(e) {
		e.preventDefault();
		//var selectBox = document.getElementById("deptID");
		//var selectedValue = selectBox.options[selectBox.selectedIndex].value;
		var selectBox = $("#deptID").val(); //new methord for jquery value 		
		var deptId = this.value;
		var mappingJSON = {};
		mappingJSON["deptID"] = deptId;
		var mappingInfo = JSON.stringify(mappingJSON);
		$.ajax({
			url : '${context}/getuserListByDptID',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				$('#userlist').html(result.responseText);
			},
			error : function(e) {
				console.log(e.message);
			}
		});
	});

	function validateGroupUser() {
		debugger;
		var deprtId = document.getElementById("deptID").value;
		if (deprtId == 'Please Select') {
			alert("Select Group First ");
			return false;
		}
		if (document.getElementById("userDepartment").value == 'Select User ...') {
			alert("Select User  ");
			return false;
		}
		return true;
	}

	function saveNewDeptHead() {
		if (validateGroupUser()) {
			debugger;
			var deprtId = document.getElementById("deptID").value;
			var userId = document.getElementById("userDepartment").value;
			var mappingJSON = {};
			mappingJSON["deptID"] = deprtId;
			mappingJSON["userId"] = userId;
			var mappingInfo = JSON.stringify(mappingJSON);
			$.ajax({
				url : '${context}/saveDepartmentHead',
				type : "POST",
				data : mappingInfo,
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				cache : false,
				success : function(result) {
					if (/successfully/ig.test(result.responseText)) {
						$(location).attr('href', "getDepartmentHead");
					} else {
						alert(result.responseText);
					}
				},
				error : function(e) {
					console.log(e.message);
				}
			});
		}
	}
</script>
