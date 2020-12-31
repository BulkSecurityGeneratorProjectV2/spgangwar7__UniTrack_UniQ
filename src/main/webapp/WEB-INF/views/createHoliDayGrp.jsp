 <%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Create Holiday Group</span> <span id="Date"></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->


					<div class="row ">
						<div class="col-md-12 ">
							<div class="content_box">
									<div class="box-body">


								<form id="holidayGrp" name="holiDayGrp">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Enter Holi Day Group Name</label> <input
													type="text" class="form-control" name="holidayGrpName" required
													id="holidayGrpName" placeholder="" autocomplete="off">
											</div>
										</div>
										
									<%-- 	<div class="col-md-6">
											<div class="form-group">
												<label for="ExpertiseLevel">Role</label>
												<form:select path="roleList" id="roleID"
													name="roleID" class="form-control">
													<form:option value="Please select a role..." labelValue="" />
													<form:options items="${roleList}" itemValue="roleID"
														itemLabel="roleName" />
												</form:select>
											</div>
										</div> --%>
										
									</div>

									<div class=" mt-3">
										<a class="btn btn-outline-danger" href="${context}/holidayGroup"><i class="fa fa-close"></i> Cancel</a> &nbsp;
										<a class="btn btn-danger" href="#" onclick="saveHoliDayGrp()"><i class="fa fa-save"></i> Save</a>
									</div>

								</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</html>

<script>
function validate(){
	
	var holidayGrpName=document.getElementById("holidayGrpName").value;
	
	if(holidayGrpName==''){
 		alert("Enter Group Name First!!");
 		return false;
 	}
	
	return true;
}
</script>
