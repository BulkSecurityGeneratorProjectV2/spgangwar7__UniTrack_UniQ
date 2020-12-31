<%@ include file="/WEB-INF/includes/include.jsp" %>
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Manage User's Login </span> <span id="Date">Mon
									, 26 Aug 2019</span><span class="ml-auto">
								<span ><a href="${context}/roleDetails" class="btn btn-sm btn-outline-danger"><i class="fa fa-plus"></i> Manage Roles</a></span>
							<%-- 	&nbsp;&nbsp;<span><a href="${context}/deptDetails" class="btn btn-sm btn-outline-danger"><i class="fa fa-plus"></i> Manage Groups</a></span> --%>
						      &nbsp;&nbsp; <a href="${context}/createUser" class="btn btn-sm btn-outline-danger"><i class="fa fa-plus"></i> Add New User</a></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->
				<c:if test="${not empty message}"> 
					<div id="message" class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>  ${message}</strong>
					</div>
				</c:if> 
					<form name="users" id="users">
						<input type="hidden" name="userID" id="userID">
						<div class="row">
							<div class="col-md-12">
								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="userTable">
											<thead class="table-head">
												<tr>
													<th>Action</th>
													<th>User Name</th>
													<th>User Email</th>
													<!-- <th>Group Name</th> -->
												 <th>Role Name</th>
													<th>Status</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${userDetails}" varStatus="counter">
													<tr>
														<td>
														<a href="#" onclick="updateUser(${temp.userID});" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit Info"><i class="fa fa-edit edit-icon"></i></a>
														<%-- <a href="#" onclick="deleteUser(${temp.userID});" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete Info"><i class="fa fa fa-trash delete-icon"></i></a> --%>
														</td>
														<td>${temp.firstName}  ${temp.lastName}</td>
														<td>${temp.username}</td>
 														<%-- <td>   
 														<c:forEach var="group" items="${temp.group1}" varStatus="counter">
 														${group.groupName} |
 														
 														</c:forEach>
 														</td>  --%>
 														 <td>
<%--  														 <c:forEach var="rolelist" items="${temp.group1}" varStatus="counter" begin="0" end="0"> --%>
 													
 														 ${temp.role.roleName}
<%--  														 </c:forEach></td>  --%>
														<c:choose>
															<c:when test="${temp.active eq 'Y'}">
																<td class="greenActive">Active</td>
															</c:when>
															<c:otherwise>
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
<script>
	setTimeout(function() {
 	    $('#message').fadeOut('fast');
 	}, 1000);
</script>