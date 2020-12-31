 <%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2"><spring:message code="chapter.article" /> Files</span> <span id="Date"></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->



					<div class="row ">
						<div class="col-md-12 ">
							<div class="content_box">
									<div class="box-body">


								<form id="article" name="article" enctype="multipart/form-data">
									<div class="row">

										<div class="col-md-8">
											<div class="form-group">
												<label for="currency"><spring:message code="chapter.article" /> Name : ${article_name}</label> 
												<input type="hidden" name="article_task_id"
											id="article_task_id" value="${article_task_id}"> <input
											type="hidden" name="article_id" id="article_id" value="${article_id}">
												
												<c:forEach var="temp" items="${testP}" varStatus="counter">
													<ul>
														<i class="fa fa-folder-open-o edit-icon"></i>&nbsp;<strong>${temp.key}</strong>
													</ul>

													<c:forEach items="${temp.value}" var="item"  begin="0" end="0">
														<li><input type="hidden" name="fileURL" id="fileURL">
														<a id='test' href="#" onclick="pathVal('${path}','${temp.key}','${item}')">${temp.value}</a></li>
														
													</c:forEach>
													
													
												</c:forEach>
												
												
											</div>
											
											
											</div>	
											
											<%-- <div class="col-sm-4">
														<div class="border-2 tab-pad col-sm-12">
															<ol
																class="tasklist vertical connected-sortable  ui-sortable">
																<c:forEach var="temp" items="${testP}"
																	varStatus="counter">
																	 <ul> <strong>${temp.key}</strong></ul>
																	<c:forEach items="${temp.value}" var="item" >
																      
																       <li><strong>${item}</strong></li>
																    </c:forEach>
																</c:forEach>
															</ol>
														</div>
													</div>	 --%>									
									</div>

									
									
									
									
									
 
 
									<div class=" mt-3">
										<a class="btn btn-outline-danger" href="#" onclick="IssueList()"><i class="fa fa-close"></i> Back To Veiw</a> &nbsp;
									</div>


								</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script>


function IssueList() {
	
			document.getElementById("article").action = "view-groupTask";
			document.getElementById("article").method = "POST";
			document.getElementById("article").submit();
		
	}
	
	function pathVal(p,l,m) {
		var url=p+'/'+l+'/'+m;
		console.log(url);
 		document.getElementById('fileURL').value = url;
 		document.getElementById("article").action = "dwonload_file";
		document.getElementById("article").method = "GET";
		document.getElementById("article").submit();
}
	

</script>