<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<!-- <div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Article Details</span> <span id="Date">Mon
								, 26 Aug 2019</span> <span class="pull-right">  <button type="button" class="btn btn-sm btn-outline-danger" data-toggle="modal" data-target="#mailSetup"><i class="fa fa-envelope "></i> &nbsp;Email</button>
							</span>
						</div>
					</div> -->
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Article Details</span> <span id="Date">Mon
								, 26 Aug 2019</span><span class="ml-auto"><a href="javascript:;"
								class="btn btn-sm btn-outline-danger" onclick="createUserArticle()"><i
									class="fa fa-plus"></i> Add New Article</a></span> <span
								class="pull-right"> <!--  <button type="button" class="btn btn-sm btn-outline-danger" data-toggle="modal" data-target="#mailSetup"><i class="fa fa-envelope "></i> &nbsp;Email</button> -->
							</span>
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
				<form name="article" id="articleList">
					<input type="hidden" name="article_id" id="article_id"> <input type="hidden" name="flag" id="flag">
					<div class="row">
						<div class="col-md-12">



							<div class="content_box">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0"
										id="roleTable">
										<thead class="table-head">
											<tr>
												<th>S.No</th>
												<th>Article Title</th>
												<th>Journal Name</th>
												<!-- 													<th>Publisher Name</th> -->
										<!-- 		<th>Journal Issue Number</th> -->
												<th>Article DOI</th>
												<th>Article ID</th>
												<th>Article Type</th>
												<th>Status</th>
												<th>Action</th>
												<th>Withdraw</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="temp" items="${journalWisearticle}"
												varStatus="counter">
												<tr>
													<td>${counter.count}</td>
													<td>${temp.article_title}</td>
													<td>${temp.journalName}</td>
													<%-- 														<td>${temp.publisher.publisherName}</td> --%>
												<%-- 	<td>${temp.journal_issue_number}</td> --%>
													<td>${temp.article_doi}</td>
													<td>${temp.aid}</td>
													<td>${temp.article_type_cd}</td>
													<td>${temp.taskName}</td>
													<td align="center"><a href="#"
														class="btn btn-outline-success btn-sm"
														onclick="articalDetails(${temp.article_id})"> History
													</a></td>
													<td><a href="#" class="btn btn-outline-success btn-sm"
														onclick="withdrawArtical('${temp.article_id}')"> <i
															class=" btn fa fa-paper-plane"></i></a></td>
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

<script type="text/javascript">
		function articalDetails(val) {
		document.getElementById("article_id").value =val;
		document.getElementById("flag").value = 1;
		document.getElementById("articleList").action = "startGroupTask";
		document.getElementById("articleList").method = "POST";
		document.getElementById("articleList").submit();
	}
		
		function withdrawArtical(articleId){
			if (confirm('Are you sure you want to withdraw this article ?')) {
			document.getElementById("article_id").value =articleId;
			document.getElementById("flag").value = 1;
			document.getElementById("articleList").action="${context}/articalWithdraw";
			document.getElementById("articleList").method="POST";
			document.getElementById("articleList").submit();
		}
}
		

		function createUserArticle() {
			document.getElementById("articleList").action = "createArticle";
			document.getElementById("articleList").method = "POST";
			document.getElementById("articleList").submit();
		}
		</script>
