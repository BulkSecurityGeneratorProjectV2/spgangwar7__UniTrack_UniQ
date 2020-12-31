<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Manage Group In-charge</span> <span id="Date">Mon
									, 26 Aug 2019</span><span class="ml-auto"><a
									href="${context}/createDeptHead" class="btn btn-sm btn-outline-danger"><i class="fa fa-plus"></i> Add New</a></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->

				<form id="deartmentHead" name="deartmentHead">
				<input type="hidden" name="deptID" id="deptHeadID">
					<div class="row">
						<div class="col-md-12">

							<div class="content_box">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0"
										id="dataTable">
										<thead class="table-head">
											<tr>
												<th>Action</th>
												<th>Group</th>
												 <th>Head of Group</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach items="${usrHeadGrpList}" var="temp">
												<tr>
													<td>
													<a href="#" onclick="editHeadDeptUser(${temp.deptID});"
														data-toggle="tooltip" data-placement="top" title=""
														data-original-title="Edit Info"><i
															class="fa fa-edit edit-icon"></i></a>
												  	<a href="#" onclick="deleteHeadDeptUser(${temp.deptHeadID});"
														data-toggle="tooltip" data-placement="top" title=""
														data-original-title="Delete Info"><i
															class="fa fa fa-trash delete-icon"></i></a></td>
													 <td>${temp.department.groupName}</td> 
													<td>${temp.user.firstName}&nbsp;${temp.user.lastName}</td>
												</tr>
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

