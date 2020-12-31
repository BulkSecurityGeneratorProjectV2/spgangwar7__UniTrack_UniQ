
<%@ include file="/WEB-INF/includes/include.jsp" %>
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Role Details</span><span id="Date">Mon
									, 26 Aug 2019</span><span class="ml-auto">
									<span ><a href="${context}/userDetails" class="btn btn-sm btn-outline-danger"><i class="fa fa-arrow-left"></i> Back To User</a></span>
									&nbsp;&nbsp;<a href="${context}/createNewRole" class="btn btn-sm btn-outline-danger"><i class="fa fa-plus"></i> Add New Role</a></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->
				<c:if test="${not empty message}"> 
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>  ${message}</strong>
					</div>
				</c:if> 
				<form name="roles" id="roles">
						<input type="hidden" name="roleID" id="roleID">
						<div class="row">
							<div class="col-md-12">
								<div class="content_box">
									<div class="box-body">
									
										<table class="table table-striped table-bordered m-0"
											id="roleTable">
											<thead class="table-head">
												<tr>
													<th>Action</th>
													<th>Role Name</th>
													<th>Created By</th>
													<th>Status</th>
													
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${roleList}" varStatus="counter">
													<tr>
														<td>
														<a href="#" onclick="editRoleDetails(${temp.roleID});" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit Info"><i class="fa fa-edit edit-icon"></i></a>
														<%-- <a href="#" onclick="deleteRole(${temp.roleID});" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete Info"><i class="fa fa fa-trash delete-icon"></i></a> --%>
														</td>
														<td>${temp.roleName}</td>
														<td>${temp.createdBy}</td> 
														<c:choose>
															<c:when test="${temp.status eq 'Y'}">
															<td class="greenActive">Active</td>
																<!-- <td><button type="button" class="btn btn-success">Active</button></td> -->
																
															</c:when>
															<c:otherwise>
															<!-- 	<td><button type="button" class="btn btn-danger">Inactive</button></td> -->
															<td class="redInactive">Inactive</td>
															</c:otherwise>
														</c:choose>
														
														
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>