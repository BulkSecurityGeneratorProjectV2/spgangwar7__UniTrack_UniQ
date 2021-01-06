
<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-6">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Create <spring:message code="exam.exam" /></span>
							<span id="Date"></span>
						</div>
					</div>
					<div class="col-md-6">
						<label class="mandatoryMsg">All <sup class="text-red">(&lowast;)</sup>
							marked fields are mandatory
						</label>
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


				<div class="row ">
					<div class="col-md-12 ">
						<div class="content_box  ">
							<form action="${context}/saveExam" method="post" id="ExamDetails"
								name="ExamDetails" enctype="multipart/form-data">
								<div class="box-body">
									<div class="row divtoappend">

										<div class="col-md-4">
											<div class="form-group">
												<label for="currency"><spring:message
														code="exam.exam" /> Title <sup class="text-red">&lowast;</sup></label>
												<input type="text" class="form-control" name="examName"
													id="examName" placeholder="" autocomplete="off"
													maxlength="1000" required>
											</div>
										</div>

										<div class="col-md-4">
											<div class="form-group">
												<label for="currency"><spring:message
														code="exam.exam" /> Description<sup class="text-red">&lowast;</sup></label>
												<input type="text" class="form-control" name="examDescription"
													id="examDescription" placeholder="" autocomplete="off"
													maxlength="1000" required>
											</div>
										</div>
									</div>

								</div>
								<div class="box-footer text-right">
									<a class="btn btn-outline-danger" href="/journalList">Cancel</a>
									&nbsp;
									<!--  <a
										class="btn btn-danger" href="#" onclick="saveArticle()">Save</a> -->
									&nbsp; <input type="submit" value="Save"
										class="btn btn-danger " />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
