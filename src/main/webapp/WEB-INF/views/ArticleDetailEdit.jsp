 <%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Edit Article</span> <span id="Date"></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->

					<div class="row ">
						<div class="col-md-12 ">
							<div class="content_box">
									<div class="box-body">


								<form id="article" name="article">
								<input type="hidden" name="article_id" id="article_id" value="${article_id}">
									<div class="row">

										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Article Title</label> <input
													type="text" class="form-control" name="article_title"
													id="article_title" placeholder="" autocomplete="off" value="${ArticleDetail.article_title}">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="ExpertiseLevel">Journal ID </label>
												<form:select path="journallist"  id="journalId" name="journalId"  class="form-control">
				 								 <form:options items = "${journallist}" itemValue="journalId" itemLabel="journalName" />
												</form:select>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Publisher ID</label> 
												<form:select path="publisherList"  id="publisher_id" name="publisher_id"  class="form-control">
				 								 <form:options items = "${publisherList}" itemValue="publisher_id" itemLabel="publisherName" />
												</form:select>
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Journal Issue Number</label> <input
													type="text" class="form-control"
													name="journal_issue_number" id="journal_issue_number"
													placeholder="" autocomplete="off" value="${ArticleDetail.journal_issue_number}">
											</div>
										</div>

									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Journal Volume Number</label> <input
													type="text" class="form-control"
													name="journal_volume_number" id="journal_volume_number"
													placeholder="" autocomplete="off" value="${ArticleDetail.journal_volume_number}">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Article DOI</label> <input
													type="text" class="form-control" name="article_doi"
													id="article_doi" placeholder="" autocomplete="off" value="${ArticleDetail.article_doi}">
											</div>
										</div>

									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Article ID</label> <input type="text"
													class="form-control" name="aid" id="aid" placeholder=""
													autocomplete="off" value="${ArticleDetail.aid}">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Article Type CD</label> <input
													type="text" class="form-control" name="article_type_cd"
													id="article_type_cd" placeholder="" autocomplete="off" value="${ArticleDetail.article_type_cd}">
											</div>
										</div>
									</div>

									<div class=" mt-3">
										<a class="btn btn-outline-danger" href="#" onclick="ArticleList()"><i class="fa fa-close"></i> Cancel</a> &nbsp;
										<a class="btn btn-danger" href="#" onclick="saveEditArticle()"><i class="fa fa-save"></i> Save</a>
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

