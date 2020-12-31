 <%@ include file="/WEB-INF/includes/include.jsp" %>
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Task Details</span> <span id="Date">Mon
									, 26 Aug 2019</span><span class="ml-auto"><a
									href="javascript:;" class="btn btn-sm btn-outline-danger"
									onclick="createArticle()"><i class="fa fa-plus"></i> Add New</a></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->

					<form name="article" id="article">
						<input type="hidden" name="article_id" id="article_id">

						<div class="row">
							<div class="col-md-12">



								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="articleTable">
											<thead class="table-head">
												<tr>
													<th>S.no</th>
													<th>Task Name</th>
													<th>Created By</th>
													<th>Created Date</th>
													
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${taskDetails}"
													varStatus="counter">
													<tr>
													
														<td>${counter.count}</td>
														<td>${temp.taskName}</td>
														<td>${temp.createdBy}</td>
														<td>
														<fmt:formatDate
																value="${temp.createdAt}"
																pattern="yyyy-MM-dd hh:mm a" />
														</td>
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
 