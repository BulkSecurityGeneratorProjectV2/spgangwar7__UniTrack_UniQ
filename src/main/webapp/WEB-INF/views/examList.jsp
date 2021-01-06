<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2"><spring:message code="exam.exam" />
								Details</span> <span id="Date">Mon , 26 Aug 2019</span><span
								class="ml-auto"><a href="/createExam"
								class="btn btn-sm btn-outline-danger"><i class="fa fa-plus"></i>
									Add New <spring:message code="exam.exam" /></a></span> <span
								class="pull-right"> </span>
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
						<strong> ${message}</strong>
					</div>
				</c:if>
				<form name="exam" id="exam">
					<div class="row">
						<div class="col-md-12">
							<div class="content_box">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0 filter8"
										id="articleList">
										<thead class="table-head">
											<tr>
												<th>S.No</th>
												<th data-orderable="false"><spring:message
														code="exam.exam" /> Name</th>
												<th><spring:message code="exam.exam" /> Title</th>


											</tr>
										</thead>
										<tbody>
											<c:forEach var="temp" items="${examList}" varStatus="counter">
												<tr>
													<td>${counter.count}</td>
													<td>${temp.examName}</td>
													<td>${temp.examDescription}</td>
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
