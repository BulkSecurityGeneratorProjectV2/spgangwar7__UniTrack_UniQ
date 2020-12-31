
<%@ include file="/WEB-INF/includes/include.jsp"%>
<form name="mang" id="mang">
<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">View Planner By user</span> <span id="Date"></span>
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
												<label for="ExpertiseLevel">Select Role Name </label>
												<form:select path="roleDetails" id="roleID" name="roleID"
													class="form-control">
													<form:option value="Please Select" labelValue="" />
													<form:options items="${roleDetails}" itemValue="roleID"
														itemLabel="roleName" />
												</form:select>
											</div>
										</div>
										
										<div class="col-md-6">
											<div class="form-group"  id="userlist"></div>
										</div>

									</div>

									
                                 
								<input type="hidden" name="userid" id=userid >  
							</div>
							<div class="box-footer">
									 <a class="btn btn-danger text-white" href="#"  onclick="showresult()">Search</a>
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
function validate(){
	
	var roleID=document.getElementById("roleID").value;

	if(roleID=='Please Select'){
		alert("Please select a Role Name");
		return false;
	}

	if(document.getElementById("userrole").value == 'Select User ...'){
		alert("Please select an user");
		return false;
	}
	
	return true;
    }
    
function showresult(){
if(validate()){
	var roleId = document.getElementById("roleID").value;
	//alert(roleId);
	var userId = document.getElementById("userrole").value;
	//alert(userId);
	document.getElementById("userid").value = userId;

	
	document.getElementById("mang").action="${context}/viewplannerSuplierUserWise";
	document.getElementById("mang").method="POST";
    document.getElementById("mang").submit();
}
}
</script>
 
<script type="text/javascript">

	$('#roleID').on('change', function(e) {
		e.preventDefault();
		//var selectBox = document.getElementById("deptID");
		//var selectedValue = selectBox.options[selectBox.selectedIndex].value;
		var selectBox =$("#roleID").val();  //new methord for jquery value 		
		var roleId = this.value;
		//alert(roleId);
		var mappingJSON = {};
		mappingJSON["roleId"] = roleId;
		var mappingInfo = JSON.stringify(mappingJSON);
		$.ajax({
			url : '${context}/getuserListByroleID',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				//alert(result);
				$('#userlist').html(result.responseText);
			},
			error : function(e) {
				console.log(e.message);
			}
		});
	});

</script>
</form>
