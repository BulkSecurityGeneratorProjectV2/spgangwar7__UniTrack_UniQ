 <%@ include file="/WEB-INF/includes/include.jsp" %>
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Overdue <spring:message code="chapter.article" /> In My Task</span> <span id="Date">Mon
									, 26 Aug 2019</span><!-- <span class="ml-auto"><a
									href="javascript:;" class="btn btn-sm btn-outline-danger"
									onclick="createArticle()"><i class="fa fa-plus"></i> Add New</a></span> -->
							</div>
						</div>
					</div>
					<!--main_tittle_End-->

					<form name="articleOverdue" id="articleOverdue">
						<!-- <input type="hidden" name="article_id" id="article_id"> -->

						<div class="row">
							<div class="col-md-12">



								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="overDueArticle">
											<thead class="table-head">
												<tr>
											<th>S.No.</th>
											<th><spring:message code="chapter.article" /> ID</th>
											<th><spring:message code="book.journal" /> Abbreviation Name</th>
											<th>Title</th>
											<th>Task Name</th>
											<th>Stage</th>
											<th>Schedule Start Date</th>
											<th>Schedule End Date</th>
											<th>Action</th>
										</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${taskScheduler}"
											varStatus="counter">

											<tr>
												<td align="center">${counter.count}</td>
												<td align="center">${temp.articleDetail.aid}</td>
												<td align="center">${temp.articleDetail.journals.journalAbbrName}</td>
												<td>${temp.articleDetail.article_title}</td>
												<td>${temp.task.taskName}</td>
												<td>${temp.task_status}</td>
												<td><fmt:formatDate pattern="dd-MM-yyyy"
														value="${temp.sch_start_time}" /></td>
												<td><fmt:formatDate pattern="dd-MM-yyyy"
														value="${temp.sch_end_time}" /></td>
												<%-- 														<td><fmt:formatDate pattern="dd-MM-yyyy" value="${temp.start_date_time}" /></td> --%>
												<td align="center"><input type="hidden" name="flagDash"
													id="flagDash"> <input type="hidden"
													name="article_id" id="article_id"
													value="${temp.article_id}"> <input type="hidden"
													name="article_task_id" id="article_task_id"
													value="${temp.article_task_id}"> <a href="#"
													class="btn btn-outline-success btn-sm"
													onclick="StartMYTask(${temp.article_task_id},${temp.article_id})"> Start </a>
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
 <script>
 $(document).ready(function() {
	    $('#overDueArticle').DataTable();
	} );
 function StartMYTask(val,artilceID) {
		document.getElementById("article_task_id").value = val;
		document.getElementById("article_id").value = artilceID;
		document.getElementById("articleOverdue").action = "view-groupTask";
		document.getElementById("articleOverdue").method = "POST";
		document.getElementById("articleOverdue").submit();
	}
 </script>