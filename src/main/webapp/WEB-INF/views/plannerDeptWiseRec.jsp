
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
							<span class="mr-2">View Planner  Record(Role Assignment Wise) </span> <span id="Date"></span>
						</div>
					</div>
				</div>
				<!--main_tittle_End-->

				<div class="row ">
					<div class="col-md-12 ">
						<div class="content_box">
							<div class="box-body">

									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label for="ExpertiseLevel">Select Role Assignment </label>
												<form:select path="deptDetails" id="roleID" name="roleID"
													class="form-control">
													<form:option value="Please Select" labelValue="" />
													<form:options items="${roleDetails}" itemValue="roleID"
														itemLabel="roleName" />
												</form:select>
											</div>
										</div>
										<div class="col-md-4">
											 <a class="btn btn-danger mt-4" href="#"  onclick="showresultdata()">Search</a>
										</div>
										
					
									</div>

									
                                 <input type="hidden" name="roleID" id=roleID>  
								
								 
							</div>
							
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</div>
 
<script type="text/javascript">
function showresultdata(){
 //   alert(".........");
    if(validate()){
	var roleId = document.getElementById("roleID").value;
//	alert(roleId);
	document.getElementById("mang").action="${context}/viewplannerSuplierWise";
	document.getElementById("mang").method="POST";
    document.getElementById("mang").submit();
    }
}

function validate(){
	
	var roleId=document.getElementById("roleID").value;

	if(roleId=='Please Select'){
		alert("Please select a Role Assignment");
		return false;
	}
	
	return true;
    }
</script>
</form>
