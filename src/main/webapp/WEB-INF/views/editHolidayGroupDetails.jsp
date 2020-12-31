 <%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Edit Holiday Group</span> <span id="Date"></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->



					<div class="row ">
						<div class="col-md-12 ">
							<div class="content_box">
									<div class="box-body">


								<form id="holidayGroup" name="holidayGroup">
								<input type="hidden" name="holidayGrpId" id="holidayGrpId" value="${holidayGropDetails.holidayGrpId}">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Holiday Group  Name</label> <input
													type="text" class="form-control" name="holidayGrpName"
													id="holidayGrpId" placeholder="" autocomplete="off" value="${holidayGropDetails.holidayGrpName}">
											</div>
										</div>
										
<!-- 										<div class="col-md-6"> -->
<!-- 											<div class="form-group"> -->
<!-- 												<label for="ExpertiseLevel">Role</label> -->
<%-- 												<form:select path="roleList" id="roleID" --%>
<%-- 													name="roleID" class="form-control"> --%>
<%-- 													<form:option value="Please select a role..." labelValue="" /> --%>
<%-- 													<form:options items="${roleList}" itemValue="roleID" --%>
<%-- 														itemLabel="roleName" /> --%>
<%-- 												</form:select> --%>
<!-- 											</div> -->
<!-- 										</div> -->
										
									</div>

									<div class=" mt-3">
										<a class="btn btn-outline-danger" href="${context}/holidayGroup"><i class="fa fa-close"></i> Cancel</a> &nbsp;
										<a class="btn btn-danger" href="#" onclick="updateHoliDayGroup(${holidayGropDetails.holidayGrpId})"><i class="fa fa-save"></i> Save</a>
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
