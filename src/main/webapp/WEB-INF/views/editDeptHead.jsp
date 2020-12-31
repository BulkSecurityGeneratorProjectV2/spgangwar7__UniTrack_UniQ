
<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Edit Group Head</span> <span id="Date"></span>
						</div>
					</div>
				</div>
				<!--main_tittle_End-->



				<div class="row ">
					<div class="col-md-12 ">
						<div class="content_box">

								<form id="deartmentHead" name="deartmentHead">
							<div class="box-body bg-white">
									<input type="hidden" name="deptID" id="deptID" value="${deptID}">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Group Name</label> <input type="text"
													class="form-control" name="" id="deptID"
													placeholder="deptID" autocomplete="off"
													value="${deptName}" disabled="true">
											</div>
										</div>
										
										<div class="col-md-6">
											<div class="form-group">
												<label for="ExpertiseLevel">User Name </label>
												<form:select path="usrHeadGrpList" id="id"
													name="userId" class="form-control">
													<form:option value="Please Select" labelValue="" />
													<form:options items="${usrHeadGrpList}" itemValue="id"
														itemLabel="userFname" />
												</form:select>
											</div>
										</div>

									</div>

								
							</div>
							<div class="box-footer text-right">
								<a class="btn btn-outline-danger" href="${context}/getDepartmentHead"><!-- <i
													class="fa fa-close"></i> --> Cancel</a> &nbsp; <a
													class="btn btn-danger" href="#"
													onclick="updateDeptHeadDetails(${deptID})"><!-- <i
													class="fa fa-save"></i>  -->Save</a>
							</div>
							</form>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
