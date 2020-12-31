<%@ include file="/WEB-INF/includes/include.jsp" %>
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<form name="article_id" id="article_id" >
				 <div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Supplier Load Details</span> <span id="Date"></span><span class="ml-auto">
							</div>
						</div>
					</div>
						<%--
					<!--main_tittle_End-->
                                        <div id='Show-wf'>
												<div class="row mt-3">
												<div class="col-sm-2">
														<div class="form-group">
															<input type="text" id="publishers"
																class="form-control" placeholder="publisher Name"
																name="publisherName" value="${publisherName}">
														</div>
													</div>
													<div class="col-sm-2">
														<div class="form-group">
															<input type="text" id="article_title"
																class="form-control" placeholder="Article Name"
																name="article_title" value="${article_title}">
														</div>
													</div>
													
													<div class="col-sm-2">
														<div class="form-group">
															<input type="text" id="article_doi"
																class="form-control" placeholder="Article Doi"
																name="article_doi" value="${article_doi}">
														</div>
													</div>
													<div class="col-sm-2">
														<div class="form-group">
															<input type="text" id="article_type_cd"
																class="form-control" placeholder="Article Type"
																name="article_type_cd" value="${article_type_cd}">
														</div>
													</div>
													
													<div class="col-sm-1">
														<button onclick="searchdata()" class="btn btn-danger mb-2 ml-4" >Search</button>
													</div>
													<div class="col-sm-2">
														<button onclick="resetdata()" class="btn btn-primary mb-2 mr-5" ><i class="fa fa-repeat"></i> Reset</button>
													</div>
												</div>
											</div> --%>
					
						<div class="row">
							<div class="col-md-12">
								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="articleTable">
											<thead class="table-head">
												<tr>
													
													<!-- <th>Journal Name</th>
													<th>Publisher Name</th> -->
													<th>Article Title</th>
													<th>Article DOI</th>
													<th>Article Type</th>
													<th>Action</th>
													
												</tr>
											</thead>
										       
        									 	<tbody> 
											
												<%-- <c:forEach var="cemp" items="${articleDetail}"
													varStatus="counter"> --%>
											<%-- <tr> 
														
														<td><input type="hidden" name="article_title">${articleDetail.article_title}</td>
														<td><input type="hidden" name="article_doi">${articleDetail.article_doi}</td>
													    <td><input type="hidden" name="article_type_cd">${articleDetail.article_type_cd}</td>
													    <td><a href="#" class="btn btn-outline-success btn-sm" onclick="articalDetails(${articleDetail.article_id})"> Details </a></td>
											
												</c:forEach>
											
											
											 --%>
											
												 <c:forEach var="temp" items="${ArticleDetailsList}" varStatus="counter"> 
													
													<tr>
													
														<td align="center">${temp.article_title}</td>
														<td>${temp.article_doi}</td>
														<td>${temp.article_type_cd}</td>
													    <td align="center">
													    <input type="hidden" name="journal_name" id="journal_name" value="${temp.journal_name}">
													    <input type="hidden" name="article_title" id="article_title" value="${temp.article_title}">
													    <input type="hidden" name="article_doi" id="article_doi" value="${temp.article_doi}">
													    <input type="hidden" name="article_type_cd" id="article_type_cd" value="${temp.article_type_cd}">
													    <input type="hidden" name="publisherName" id="publisherName" value="${temp.publ_name}">
														<input type="hidden" name="article_id" id="article_id" value="${temp.article_id}">
														<a href="#" class="btn btn-outline-success btn-sm" onclick="articalDetails(${temp.article_id})"> Details </a></td>
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
		document.getElementById("article_id").action = "startGroupTask";
		document.getElementById("article_id").method = "POST";
		document.getElementById("article_id").submit();
	}
	</script>