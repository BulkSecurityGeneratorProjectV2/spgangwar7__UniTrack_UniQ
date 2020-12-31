<%@ include file="/WEB-INF/includes/include.jsp" %>
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Group Load</span> <span id="Date">Mon
									, 26 Aug 2019</span><span class="ml-auto"><a
									href="${context}/createDept" class="btn btn-sm btn-outline-danger"><i class="fa fa-plus"></i> Add New</a></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->

					<form name="article_id" id="article_id">
						<input type="hidden" name="article_id" id="article_id">
						<div class="row">
							<div class="col-md-12">
								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0" id="deptTable">
											<thead class="table-head">
												<tr>
												<!-- 	<th>Action</th> -->
												 	<th>Group Name</th>
													<th>Total Assigned Article</th>
													<th>Ontime</th>
													<th>Overdue</th>
													<th>View</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${deptDetails}" varStatus="counter">
													<tr>
													 
													<td>${temp.suplliername}
													</td>
													<td>${temp.count}</td>
													<td>${starttimecount}</td>
													<td>${overdue}</td>
													
													<%-- 	<td>
														<a href="#" onclick="editDeptDetails(${temp.deptID});" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit Info"><i class="fa fa-edit edit-icon"></i></a>
														<a href="#" onclick="deleteDept(${temp.deptID});" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete Info"><i class="fa fa fa-trash delete-icon"></i></a>
														</td> --%>
													<%-- 	<td>${temp.}</td>
														<td>${temp.role.roleName}</td>
														<td>
														<c:choose>
															<c:when test="${temp.status eq 'Y'}">
																Active
															</c:when>
															<c:otherwise>
																InActive
															</c:otherwise>
														</c:choose>
														</td> --%>
												
														<td><input type="hidden" name="articleId" id="article_id" value="${temp.article_id}" >
														<a href="#" onclick="viewartDetail(${temp.article_id});" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit Info">View Details</a>
													    </td>
														
														
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</form>
					<script type="text/javascript">
					function viewartDetail(article_id){
						
							document.getElementById("article_id").value = article_id;
							document.getElementById("article_id").action="viewartDetails";
						    document.getElementById("article_id").method="POST";
							document.getElementById("article_id").submit();
						                         }
					</script>
				</div>
			</div>
		</div>
	</div>
