<%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Role Assignment Details</span> <span id="Date">Mon
									, 26 Aug 2019</span><span class="ml-auto">
									<span ><a href="${context}/userDetails" class="btn btn-sm btn-outline-danger"><i class="fa fa-arrow-left"></i> Back To User</a></span>
									&nbsp;&nbsp;<a href="${context}/createDept" class="btn btn-sm btn-outline-danger"><i class="fa fa-plus"></i> Add New Role Assignment</a></span>
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
					<form name="dept" id="dept">
						<input type="hidden" name="deptID" id="deptID">
						<div class="row">
							<div class="col-md-12">
								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0" id="deptTable">
											<thead class="table-head">
												<tr>
													<th>Action</th>
												 	<th>Role Assignment Name</th>
													<th>Role Name</th>
													<th>Status</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${deptDetails}" varStatus="counter">
													<tr>
														<td>
														<a href="#" onclick="editDeptDetails(${temp.deptID});" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit Info"><i class="fa fa-edit edit-icon"></i></a>
														<a href="#" onclick="deleteDept(${temp.deptID});" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete Info"><i class="fa fa fa-trash delete-icon"></i></a>
														 <%-- <a href="${context}/getDepartmentHead"  data-toggle="tooltip" title="" data-original-title="Create Head "><i class="fa fa-user user-icon"></i></a>  --%>
														
														</td>
														<td>${temp.groupName}</td>
														<td>${temp.role.roleName}</td>
														<c:choose>
															<c:when test="${temp.status eq 'Y'}">
																<td class="greenActive">Active</td>
															</c:when>
															<c:otherwise>
															<td class="redInactive text-center">Inactive</td>
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
