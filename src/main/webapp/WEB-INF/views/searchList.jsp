<%@ include file="/WEB-INF/includes/include.jsp"%>
<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<form name="group" id="group">
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Search</span> <span id="Date"></span><span
									class="ml-auto">
							</div>
						</div>
					</div>


					<div class="row">
						<div class="col-md-12">
							<div class="content_box">
								<div class="box-body alert-warning">
									<!--main_tittle_End-->
									<div id='Show-wf' class="mb-2">
										<div class="row">
											<div class="col">
												<div class="">
													<label><spring:message code="manuscript.manuscript" /> ID</label> <input type="text" id="aid"
														class="form-control" placeholder="<spring:message code="manuscript.manuscript" /> ID" name=aid
														value="${aid}">
												</div>

												<div class="">
													<label></label> <input type="hidden"
														id="article_doi" class="form-control"
														placeholder="<spring:message code="chapter.article" /> DOI" name="article_doi"
														value="${article_doi}">
												</div>

												<div class="">
													<!-- <label>Publisher Name</label>  -->
													<input type="hidden" id="publishers" class="form-control"
														placeholder="publisher Name" name="publisherName"
														value="${publisherName}">
												</div>
											</div>
											<div class="col">
												<div class="">
													<label><spring:message code="chapter.article" /> Title</label> <input type="text"
														id="article_title" class="form-control"
														placeholder="<spring:message code="chapter.article" /> Title" name="article_title"
														value="${article_title}">
												</div>

												<div class="">
													<label></label> <input type="hidden"
														id="article_type_cd" class="form-control"
														placeholder="<spring:message code="chapter.article" /> Type" name="article_type_cd"
														value="${article_type_cd}">
												</div>

											</div>

											<div class="col">
												<input type="hidden"
														id="authorEmail" class="form-control"
														placeholder="Author Email" name="authorEmail"
														value="${authorEmail}">
												
												<div class="">
													<label><spring:message code="book.journal" /> Abbr</label> <input type="text"
														id="journalAbbr" class="form-control"
														placeholder="<spring:message code="book.journal" /> Abbr" name=journalAbbr
														value="${journalAbbr}">
												</div>
											</div>
											<div class="col">

												 <input type="hidden"
														id="lname" class="form-control"
														placeholder="Author last name" name="lname"
														value="${lname}">
												<div class="">
													<label><spring:message code="chapter.article" />
														Status</label> <input type="text" id="articleStatus"
														class="form-control"
														placeholder="<spring:message code="chapter.article" /> Status"
														name="articleStatus" value="${articleStatus}">
												</div>


											</div>

											<div class="col">
												<div class="">
													
												</div>
												<div class="">
													<label class="d-block">&nbsp;</label>
													<button onclick="searchdata()" class="btn btn-danger mb-2">
														<i class="fa fa-search"></i> Search
													</button>
													<button onclick="resetdata()" class="btn btn-primary mb-2">
														<i class="fa fa-repeat"></i> Reset
													</button>
												</div>
											</div>

										</div>
									</div>

								</div>

							</div>

							<div class="row">
								<div class="col-md-12">
									<c:if test="${not empty message}">
										<div class="alert alert-${css} alert-dismissible" role="alert">
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<strong> ${message}</strong>
										</div>
									</c:if>
									<c:if test="${fn:length(ArticleDetail) > 0}">
										<div class="content_box">
											<div class="box-body">
												<table
													class="table table-striped table-bordered m-0 filter9">
													<!-- 	id="deptTable"> -->
													<thead class="table-head">
														<tr>
															<th>S.No.</th>
															<th><spring:message code="book.journal" /> Name</th>
															<!-- 													<th>Publisher Name</th> -->
															
															<th><spring:message code="chapter.article" /> Title</th>
															<th><spring:message code="chapter.article" /> DOI</th>

															<th><spring:message code="issue.book" /> Title</th>
															<th><spring:message code="chapter.article" /> Type</th>
															<th><spring:message code="chapter.article" /> Status</th>
															<th>Task Name</th>
															<th>Action</th>

														</tr>
													</thead>
													<tbody>
														<c:forEach var="temp" items="${ArticleDetail}"
															varStatus="counter">

															<tr>
																<td align="center">${counter.count}</td>
																<td align="center">${temp.journalName}</td>
																<%-- 														<td>${temp.publisherName}</td> --%>
																
																	<td align="center">${temp.article_title}</td>
																	<td>${temp.article_doi}</td>
																<td>${temp.issueTitle}</td>
																<td>${temp.article_type_cd}</td>
																<td>${temp.task_status}</td>
																<td>${temp.taskName}</td>
																<td align="center"><input type="hidden"
																	name="article_id" id="article_id"
																	value="${temp.article_id}"> <a href="#"
																	class="btn btn-outline-success btn-sm"
																	onclick="articalDetails(${temp.article_id})">
																		Details </a></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</c:if>
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
	function searchdata() {
		document.getElementById("group").action = "searchArticleData";
		document.getElementById("group").method = "POST";
		document.getElementById("group").submit();
	}
	function resetdata() {
		document.getElementById("group").action = "srchart";
		document.getElementById("group").method = "POST";
		document.getElementById("group").submit();
	}
	function articalDetails(val) {
		document.getElementById("article_id").value =val;
		document.getElementById("group").action = "startGroupTask";
		document.getElementById("group").method = "POST";
		document.getElementById("group").submit();
	}
	

	</script>