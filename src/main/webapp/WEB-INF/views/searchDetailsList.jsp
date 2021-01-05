\<%@ include file="/WEB-INF/includes/include.jsp"%>

<script src="https://code.highcharts.com/gantt/highcharts-gantt.js"></script>
<script
	src="https://code.highcharts.com/gantt/modules/draggable-points.js"></script>
<form name="srchart2" id="srchart2">
	<form name="srchart" id="srchart" action='searchArticleData'
		method='post'>

		<div class="wrapper">
			<div class="main_part_outer" id="content">
				<div class="d-flex flex-column w-100 h-200">
					<div class="container-fluid">
						<!--main_tittle-->
						<c:if test="${not empty message}">
							<div id="message" class="alert alert-${css} alert-dismissible"
								role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong> ${message}</strong>
							</div>
						</c:if>
						<div class="row">

							<div class="col-md-12">
								<div class="main_tittle d-flex align-items-center">
									<c:if test="${flag eq null}">
										<span class="mr-2"><spring:message code="chapter.article" /> Details:</span>
										<span class="ml-auto"><button onclick="searchdata()"
												class="btn btn-sm btn-outline-danger">Back to
												Search</button></span>
									</c:if>
									<c:if test="${flag eq '1'}">
										<span class="mr-2"><spring:message code="chapter.article" /> Details:</span>
										<span class="ml-auto"><a href="${context}/dashboard"
											class="btn btn-sm btn-outline-danger">Back to Dashboard</a></span>
									</c:if>
									<input type="hidden" class="form-control" id="article_title"
										name="article_title" value="${article_title}"> <input
										type="hidden" class="form-control" id="article_doi"
										name="article_doi" value="${article_doi}"> <input
										type="hidden" class="form-control" id="article_type_cd"
										name="article_type_cd" value="${article_type_cd}"> <input
										type="hidden" class="form-control" id="publisherName"
										name="publisherName" value="${publisherName}">
								</div>
							</div>
						</div>





						<div class="content_box">
							<div class="box-body ">

								<div class="row">
									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left"><spring:message code="book.journal" /> Name: </label> <span
												class="form-control bg-lighttitle-right title-right">${journalName}</span>
										</div>
									</div>
									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left">Workflow Name: </label> <span
												class="form-control bg-light title-right">${workflowName}</span>
										</div>
									</div>



								</div>
								<div class="row">
									<%-- <div class="form-group">
									<label class="art-left">Journal Name: </label> <span
										class="form-control bg-lighttitle-right title-right">${journalName}</span>
								</div> --%>
									<%-- <div class="form-group">
									<label class="art-left">Journal EISSN: </label> <span
										class="form-control bg-light title-right ">${Journalissn}</span>
								</div> --%>
									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left"><spring:message code="chapter.article" /> Title: </label> <span
												class="form-control bg-light title-right">${ArticleTitle}</span>
										</div>
									</div>

									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left"><spring:message code="chapter.article" /> ID: </label> <span
												class="form-control bg-light title-right">${aid}</span>
										</div>
									</div>


								</div>
								<div class="row">

									<%-- <div class="form-group">
									<label class="art-left">Article ID: </label> <span
										class="form-control bg-light title-right">${aid}</span>
								</div> --%>
									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left"><spring:message code="chapter.article" /> DOI: </label> <span
												class="form-control bg-light title-right">${article_doi}</span>
										</div>
									</div>
									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left"><spring:message code="chapter.article" /> Keywords: </label> <span
												class="form-control bg-light title-right">${article_keywords}</span>
										</div>
									</div>
									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left">Review Date: </label> <span
												class="form-control bg-light title-right">${reviewDate}</span>
										</div>
									</div>
									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left">Submission Date: </label> <span
												class="form-control bg-light title-right">${submissionDate}</span>
										</div>
									</div>	</div>
								
							
								<div class="row">
									<%-- <div class="col-sm-6 col-md-6">
								<div class="form-group">
									<label class="art-left">Article Keywords: </label> <span
										class="form-control bg-light title-right">${article_keywords}</span>
								</div>
								</div> --%>
									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left">Productions: </label> <span
												class="form-control bg-light title-right">${commentorproductions}</span>
										</div>
									</div><!--  date-box  -->
									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left test-lft">Accepted Date: </label> <span
												class="form-control bg-light title-right">${article_ingested}</span>
										</div>
									</div>
									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left test-lft">Type Of Article: </label> <span
												class="form-control bg-light title-right ">${article_type}</span>
										</div>
									</div>

									<!-- <div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left test-lft">Author Details :</label> <span><button
													type="button" class="btn btn-outline-success date-boxbtn "
													style="padding: 3px 20px; margin-left: 31px;"
													data-toggle="modal" data-target="#authorDetailsList">
													<i class=""></i>Author Details
												</button> </span>
										</div>
									</div>

									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left test-lft">Comments : </label> <span><button
													type="button" class="btn btn-outline-danger date-boxbtn "
													style="padding: 3px 20px; margin-left: 45px;"
													data-toggle="modal" data-target="#commentList">
													<i class=""></i>View Comments
												</button> </span>
										</div>
										
									</div> -->
								
									
									<div class="col-sm-2 col-md-2">
											<label class="art-left test-lft">Pages : </label>
											<div class=" title-right"> 
										<input type="text" id="pagenumber" class="form-control float-left w-75"
												placeholder="pages" value="${article_pages}"  data-placement="top" title="Page Number Info"
												oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
												maxlength="7" onkeypress="return isNumberKey(event)"> 
										 </div>
										</div>
										<div class="col-sm-2 col-md-2">
											<label class="art-left test-lft">Color Count : </label>
											<div class=" title-right"> 
										<input type="text" id="coloimg" class="form-control w-75"
												placeholder="colorcount" value="${colorCount}"  data-placement="top" title="color Count Info"
												oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
												maxlength="7" onkeypress="return isNumberKey(event)">
										 </div>
										</div>
									<div class="col-sm-2 col-md-2">
											<label class="art-left test-lft">Word Count : </label>
											<div class=" title-right"> 
										<input type="text" id="wordcount" class="form-control"
												placeholder="wordcount" value="${wordCount}"  data-placement="top" title="word Count Info"
												oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
												maxlength="7" onkeypress="return isNumberKey(event)">
										 </div>
										</div>
									<!-- <div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left test-lft">File Attachment : </label> <span> </span> -->
											<!--  <span><button type="button"
													class="btn bg-info text-white"
													style="padding: 3px 20px; margin-left: 28px;"
													data-toggle="modal" data-target="#extraFileList">
													<i class=""></i>View Additional File
												</button></span> -->

										<!-- </div>
									</div> -->


									<div class="col-sm-6 col-md-6">
										<div class="form-group clearfix">
											<label class="art-left test-lft">Note: </label><span
												class="title-right d-flex"> <input type="text"
												placeholder="note" id="articleNote"
												class="form-control " value="${articleNote}" data-placement="top" title="${articleNote}">

												
												</span>
										</div>
									</div>
									 
									
									<!-- <div class="col-sm-2 col-md-2">
										<div class="form-group clearfix">
											<button type="button" class="btn btn-outline-success"
												data-toggle="modal" data-target="#extraFileList">
												<i class=""></i>View File
											</button>
										</div>
									</div> -->
								</div>
								<div class="row">
									
									<div class="col-8 text-left">
									<button
													type="button" class="btn btn-sm btn-outline-success "
													
													data-toggle="modal" data-target="#extraFileAttachmets">
													<i class=""></i>Add Additional File
												</button>
											<!-- 	<button
													type="button" class="btn  btn-sm btn-outline-success mx-2"
													
													data-toggle="modal" data-target="#authorDetailsList">
													<i class=""></i>Author Details
												</button> -->
												<button
													type="button" class="btn btn-sm btn-outline-success"
													
													data-toggle="modal" data-target="#commentList">
													<i class=""></i>View Comments
												</button>
									</div>
									<div class="col-4  text-right">
										<div class="form-group clearfix">
											<button type="button" onclick="updateNote('${aid}');"
												class="btn btn-sm btn-outline-danger" data-toggle="modal">
												<i class=""></i>Update
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>


						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2 left-mrgn">File Submission Details:</span>
						</div>

						<div class="row">
							<div class="col-md-12">
								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="fileTable">
											<thead class="table-head">
												<tr>
													<th>S.No.</th>
													<th>File Name</th>

													<th>File Version</th>
												<!-- 	<th>File Size</th> -->
													<th>Task Name</th>
													<th>User Name</th>
													<th>File Download</th>
													<th>File Replace</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${fileVersions}"
													varStatus="counter">

													<tr>
														<td align="center">${counter.count}</td>
														<td>${temp.fileName}</td>

														<td>${temp.fileVersion}</td>
													<%-- 	<td>${temp.size}</td> --%>
														<td>${temp.taskDetails.taskName}</td>
														<td>${temp.userDetails.firstName}
															&nbsp;${temp.userDetails.lastName}</td>
														<td class="text-center"><input type="hidden"
															id="fileURL" name="fileURL">
															<button type='button' class="btn btn-danger btn-sm"
																onclick="DownloadFile('${temp.filePath}')"
																value='Download'>Download</button></td>
														<td class="text-center">

															<button type='button'
																class="btn text-white bg-info btn-sm"
																data-toggle="modal" data-target="#fileReplace"
																onclick="fileRepalce(${temp.id})" value='Replace'>Replace</button>
														</td>
														<!--  -->
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-md-12">
								<div class="main_tittle d-flex align-items-center">
									<span class="">Additional File Details:</span>
								</div>
								<div class="content_box">
									<div class="box-body">

										<div class="border">
											<table class="table table-striped table-bordered m-0"
												id="fileAdditional">
												<thead class="table-head">
													<tr>
														<th>S.No.</th>
														<th>File Name</th>
														<!-- <th>User Name</th> -->
														<th>Upload At</th>
														<th>Download File</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="temp" items="${fileAttachments}"
														varStatus="counter">
														<tr>
															<td align="center">${counter.count}</td>
															<td>${temp.fileName}</td>
															<%-- <td>${temp.user.firstName}</td> --%>
															<td><fmt:formatDate value="${temp.created_at}"
																	pattern="yyyy-MM-dd hh:mm a" /></td>
															<td class="text-center">
																<button type='button' class="btn btn-danger btn-sm"
																	onclick="DownloadFile('${temp.filePath}')"
																	value='Download'>Download</button>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>


									</div>
								</div>
							</div>

						</div>






						<div class="row">
							<div class="col-md-12">
								<div class="main_tittle d-flex align-items-center">
									<span class="mr-2"><spring:message code="chapter.article" /> Creation Schedule Details:</span> <span
										class="ml-auto">
										<button type="button" class=" btn btn-primary btn-sm"
											data-toggle="modal" onclick="proxyAction(${article_id})"
											data-target="#completeProxy">
											<i class="fa fa-check"></i>Proxy Action
										</button>
										<button type="button"
											class="btn text-white btn-primary btn-sm  "
											data-toggle="modal" onclick="setArticleTask(${article_id})"
											data-target="#assignback">
											<i class="fa fa-arrow-left"></i> Assign back
										</button>
										<button type='button'
											class="btn text-white btn-primary btn-sm  "
											data-toggle="modal" data-target="#skipTasks"
											onclick="setArticleTask(${article_id})" value='Skip'>
											Skip <i class="fa fa-arrow-right"></i>
										</button>
									</span>
								</div>
							</div>
						</div>
						<div class="row">

							<div class="col-md-12">
								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="articleTable">
											<thead class="table-head">
												<tr>
													<th>S.No.</th>
													<th>Task Name</th>
													<th>Scheduled Start Time</th>
													<th>Scheduled End Time</th>
													<th>Start Date Time</th>
													<th>Completed Date Time</th>
													<th>difference in Days</th>
													<th>Assigned User Name</th>
													<th>Completed Action</th>


												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${ArticleDetail}"
													varStatus="counter">

													<tr>
														<td align="center">${counter.count}</td>
														<td>${temp.taskName}</td>
														<td><fmt:formatDate value="${temp.sch_start_time}"
																pattern="dd-MM-yyyy hh:mm a" /></td>
														<td><fmt:formatDate value="${temp.sch_end_time}"
																pattern="dd-MM-yyyy hh:mm a" /></td>
														<td><fmt:formatDate value="${temp.start_date_time}"
																pattern="dd-MM-yyyy hh:mm a" /></td>
														<td><fmt:formatDate
																value="${temp.completed_date_time}"
																pattern="dd-MM-yyyy hh:mm a" /></td>
														<td align="center">${temp.diffdate}</td>
														<td>${temp.firstName}&nbsp;${temp.lastName}</td>
														<%-- <c:if
															test="${temp.task_status ne 'In Progress' and temp.task_status ne 'InPool'}"> --%>
														<c:if test="${temp.task_status ne 'Skiped'}">
															<td>${temp.task_status}</td>
														</c:if>
														<c:if test="${temp.task_status eq 'Skiped'}">
															<td>Skipped</td>
														</c:if>
														<%-- </c:if> --%>

														<%-- <c:if
															test="${temp.task_status eq 'In Progress' or temp.task_status eq 'InPool'}">
															<td>${temp.task_status}
																<button type="button" class=" btn-primary"
																	data-toggle="modal"
																	onclick="proxyAction(${temp.article_task_id})"
																	data-target="#completeProxy">
																	<i class="fa fa-check"></i>Proxy Action
																</button>  --%>
														<%-- <button type="button" class="btn-primary"
																	onclick="setArticleTask(${temp.article_task_id})"
																	data-toggle="modal" data-target="#skipTasks">
																	<i class="fa fa-arrow-right"></i> Skip
																</button>
															</td>
														</c:if> --%>

													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

						<div class="alert" id="container"></div>
					</div>
				</div>
			</div>
		</div>

	</form>
</form>
<div class="modal fade" id=commentList role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">All Comments</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<div class="border">
					<table class="table table-striped table-bordered m-0"
						id="articleCommentTable">
						<thead class="table-head">
							<tr>
								<th>S.No.</th>
								<th>Task Name</th>
								<th>Role Name</th>
								<th>Comment</th>
								<th>User Name</th>
								<th>Comments Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="temp" items="${commentsList}" varStatus="counter">
								<tr>
									<td align="center">${counter.count}</td>
									<td>${temp.task.taskName}</td>
									<td>${temp.role.roleName}</td>
									<td>${temp.comment}</td>
									<td>${temp.userName}</td>
									<td><fmt:formatDate value="${temp.commentDate}"
											pattern="dd-MM-yyyy hh:mm a" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>



		</div>
	</div>
</div>

<div class="modal fade" id=authorDetailsList role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Author Details</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<div class="border">
					<table class="table table-striped table-bordered m-0"
						id="articleCommentTable">
						<thead class="table-head">
							<tr>
								<th>S.No.</th>
								<th>Author Name</th>
								<th>Email</th>
								<th>Author Order</th>
								<th>Corresponding Author</th>
								<th>ORCID</th>
								<th>Copyright</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="temp" items="${authorDetails}"
								varStatus="counter">
								<tr>
									<td align="center">${counter.count}</td>
									<td>${temp.title}&nbsp;${temp.fName}&nbsp;${temp.mName}
										&nbsp; ${temp.lName}</td>
									<td>${temp.eMail}</td>
									<td>${temp.author_order}</td>
									<td>${temp.is_corresponding}</td>
									<td>${temp.orcid}</td>
									<td>${temp.copyright}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>



		</div>
	</div>
</div>

<%-- 
<div class="modal fade" id=extraFileList role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">File Details</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<div class="border">
					<table class="table table-striped table-bordered m-0"
						id="articleCommentTable">
						<thead class="table-head">
							<tr>
								<th>S.No.</th>
								<th>File Name</th>
								<!-- <th>User Name</th> -->
								<th>Upload At</th>
								<th>Download File</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="temp" items="${fileAttachments}"
								varStatus="counter">
								<tr>
									<td align="center">${counter.count}</td>
									<td>${temp.fileName}</td>
									<td>${temp.user.firstName}</td>
									<td><fmt:formatDate value="${temp.created_at}"
											pattern="yyyy-MM-dd hh:mm a" /></td>
									<td class="text-center">
										<button type='button' class="btn btn-danger btn-sm"
											onclick="DownloadFile('${temp.filePath}')" value='Download'>Download</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>



		</div>
	</div>
</div>
 --%>


<div class="modal fade" id="fileReplace" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><b>File Replace</b></label>
				<!-- 				<span class=""> Assign Back</span> -->
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<form action="${context}/fileReplace" enctype="multipart/form-data"
				method="post">
				<div class="modal-body">

					<input type="hidden" id="fileReplace" name="fileReplace"> <input
						type="hidden" id="fileId" name="fileId"> <label
						for="currency"><b>File Replace</b><sup class="text-red">&lowast;</sup></label>
					<input type="file" class="form-control" id="files"
						name="attachmentLis" required><br /> <input type="submit"
						class="btn btn-primary btn-sm float-right" value="Upload File" /><br>

				</div>
			</form>
		</div>
	</div>
</div>
<div class="modal fade" id="skipTasks" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><b>Skip Tasks</b></label>
				<!-- 				<span class=""> Assign Back</span> -->
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<form action="${context}/skipTasksFrom" method="post">
				<div class="modal-body">
					<div class="form-group">
						<label for="tat">Priority</label> <select id="priority"
							name="priority" class="form-control">
							<!--  <option>Please select a priority</option> -->
							<option value="High Priority"
								${articleDetail.priority == 'High Priority' ? "selected" : ""}>High
								Priority</option>
							<option value="Medium Priority"
								${articleDetail.priority == 'Medium Priority' ? "selected" : ""}>Medium
								Priority</option>
							<option value="Low Priority"
								${articleDetail.priority == 'Low Priority' ? "selected" : ""}>Low
								Priority</option>
						</select>
					</div>
					<label for="currency"><b>Assign To</b> <sup
						class="text-red">&lowast;</sup></label>
					<form:select path="nextTasks" id="id1" name="id"
						class="form-control" required="required">
						<form:option value="Please select a task" labelValue="" />
						<form:options items="${nextTasks}" itemValue="id"
							itemLabel="taskName" />
					</form:select>
					<div>
						<label><b>Comments</b></label> <br>
						<textarea rows="2" cols="80" maxlength="200" name="assign_reason"
							id="assign_reason2">  
                   </textarea>
						<div id="textarea_feedback2" style="color: red"></div>
					</div>
					<input type="hidden" name="articletaskid" id="articletaskid"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> <input
						type="submit" value="Skip Task"
						class="btn btn-primary btn-sm float-right"
						onClick="return assignBackValidate()" /><br>

				</div>
			</form>
		</div>
	</div>
</div>


<div class="modal fade" id="assignback" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><b>Assign Back</b></label>
				<!-- 				<span class=""> Assign Back</span> -->
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<form action="${context}/assignBackFrom" method="post"  name="form"
				enctype="multipart/form-data">
				<div class="modal-body">
					<label for="currency"><b>Assign To</b><sup class="text-red">&lowast;</sup></label>
					<form:select path="TaskList" id="id" name="id" class="form-control"
						required="required">
						<form:option value="Please select a task" labelValue="" />
						<form:options items="${TaskList}" itemValue="id"
							itemLabel="taskName" />
					</form:select>
				
					<input type="hidden" name="article_id" id="article_id"
						value="${article_id}"> <label><b>Comments</b></label> <br>
					<textarea rows="3" cols="80" maxlength="200" name="assign_reason"
						id="assign_reason1"></textarea>
					<div id="textarea_feedback1" style="color: red"></div>
	<input type="file" class="" id="notmandatry" name="backFile"
						accept="application/${fileType}" placeholder=""><br>

					<%--  <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> --%>
					<input type="submit" class="btn btn-primary btn-sm float-right"
						value="Assign Back" onClick="return validateBack()" /><br>

				</div>
			</form>
		</div>
	</div>
</div>

<div class="modal fade" id="completeProxy" role="dialog">
	<div class="modal-dialog modal-lg">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><h4>Upload File</h4></label>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>


			<form id="myForm" action="${context}/completeProxyTask" method="post"
				enctype="multipart/form-data">
				<div class="modal-body">
					<input type="file" class="form-control" id="files"
						name="attachmentList" multiple required><br />

					<div id="selectedFiles"></div>
					<input type="hidden" name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}">


				</div>
				<div class="modal-footer text-right">
					<input type="submit" class="btn btn-primary btn-sm" value="Submit" />
				</div>
			</form>

			<script>
	              var selDiv = "";
		
	                document.addEventListener("DOMContentLoaded", init, false);
	
	                function init() {
		                  document.querySelector('#files').addEventListener('change', handleFileSelect, false);
		                  selDiv = document.querySelector("#selectedFiles");
	                 } 
		
	               function handleFileSelect(e) {
		                if(!e.target.files) return;
		
		                  selDiv.innerHTML = "";
		
		                  var files = e.target.files;
		                  for(var i=0; i<files.length; i++) {
			                    var f = files[i];
			                    selDiv.innerHTML += f.name + "<br/>";

		                  }
		
	                }
	          </script>


		</div>
	</div>
</div>


<div class="modal fade" id="extraFileAttachmets" role="dialog">
	<div class="modal-dialog modal-lg">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><h4>Upload Additional Files</h4></label>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>


			<form id="myForm" action="${context}/fileAttachments" method="post"
				enctype="multipart/form-data">
				<div class="modal-body">
					<input type="file" class="form-control" id="fileAttachments"
						name="fileAttachments" multiple required><br />

					<div id="attachmentFiles"></div>
					<input type="hidden" name=aid id="aid" value="${article_id}">


				</div>
				<div class="modal-footer text-right">
					<input type="submit" class="btn btn-primary btn-sm" value="Submit" />
				</div>
			</form>

			<script>
	              var selDiv = "";
		
	                document.addEventListener("DOMContentLoaded", init, false);
	
	                function init() {
		                  document.querySelector('#fileAttachments').addEventListener('change', handleFileSelect, false);
		                  selDiv = document.querySelector("#attachmentFiles");
	                 } 
		
	               function handleFileSelect(e) {
		                if(!e.target.files) return;
		
		                  selDiv.innerHTML = "";
		
		                  var files = e.target.files;
		                  for(var i=0; i<files.length; i++) {
			                    var f = files[i];
			                    selDiv.innerHTML += f.name + "<br/>";

		                  }
		
	                }
	          </script>


		</div>
	</div>
</div>
<script>

$('input#coloimg').keyup(function(e){ 
    if(this.value.substring(0,1) == "0")
    {
       this.value = this.value.replace(/^0+/g, '');             
    }         
});

	function isNumberKey(evt){
	    var charCode = (evt.which) ? evt.which : evt.keyCode
	    if (charCode > 31 && (charCode < 48 || charCode > 57))
	        return false;
	    return true;
	} 
	$('input#wordcount').keyup(function(e){ 
	    if(this.value.substring(0,1) == "0")
	    {
	       this.value = this.value.replace(/^0+/g, '');             
	    }         
	});

		function isNumberKey(evt){
		    var charCode = (evt.which) ? evt.which : evt.keyCode
		    if (charCode > 31 && (charCode < 48 || charCode > 57))
		        return false;
		    return true;
		} 
</script>
<script>
$(document).ready(function() {
    $('#fileTable').DataTable();
} );
$(document).ready(function() {
    $('#fileAdditional').DataTable();
} );
	function proxyAction(val) {
		document.getElementById("article_task_id").value =val;
	}
	
	function searchdata() {
		document.getElementById("srchart2").action = "searchArticleData";
		document.getElementById("srchart2").method = "POST";
		document.getElementById("srchart2").submit();
	}
	function articalDetails(val) {
		document.getElementById("article_id").value =val;
		document.getElementById("srchart").action = "StartGroupTask";
		document.getElementById("srchart").method = "POST";
		document.getElementById("srchart").submit();
	}
	
	function DownloadFile(val) {
		//alert(val);
		debugger;
		document.getElementById("fileURL").value =val;
		document.getElementById("srchart2").action = "dwonload_file";
		document.getElementById("srchart2").method = "GET";
		document.getElementById("srchart2").submit();
	}
	
	function setArticleTask(val){
	//	alert(val);
		document.getElementById("articletaskid").value =val;
		
	}
	
	
	function assignBackValidate() {
		var id=document.getElementById("id1").value;

		if(id =='Please select a task'){
			alert("Assign To cannot be blank.");
			return false;
		}
		return true;
	}
	function fileRepalce(fileId) {
	//	alert(val);
	//	alert(fileId);
	//	document.getElementById("fileReplace").value =val;
		document.getElementById("fileId").value =fileId;
	}

	function updateNote(aid) {
	  var articleNote=   $("#articleNote").val();
	  var coloimg=  $("#coloimg").val();
	  var wordcount=  $("#wordcount").val();
	  var pagenumber=  $("#pagenumber").val();
		 
		var mappingJSON = {};
		mappingJSON["article_comment"] = articleNote;
		mappingJSON["wordCount"] = wordcount;
		mappingJSON["article_pages"] = pagenumber;
		mappingJSON["colorImgCount"] = coloimg;
		mappingJSON["aid"] = aid;
		var mappingInfo = JSON.stringify(mappingJSON);
	//	alert(mappingInfo);
		$.ajax({
			url : '${context}/updateNode',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				alert("Updated successfully")				
				
			}
		
		});	
	
	}
	</script>


<script>
 			Highcharts.ganttChart('container', {
 				chart: {
 					style: {"color": "#003C71", "fontSize": "12px"}
 			    },
 			   credits: {
 				    enabled: false
 				},
 			   
 			    title: {
 			        text: 'Gantt Chart'
 			    },

 			    xAxis: {
 			        tickPixelInterval: 70
 			    },

 			    yAxis: {
 			        type: 'category',
 			        grid: {
 			            enabled: true,
 			            borderColor: 'rgba(0,0,0,0.3)',
 			            borderWidth: 1,
 			            columns: [{
 			                title: {
 			                    text: 'Task Name'
 			                },
 			                labels: {
 			                    format: '{point.name}'
 			                }
 			            }, {
 			                title: {
 			                    text: 'Username'
 			                   	
 			                },  
 			               
 			                labels: {
 			                    format: '{point.assignee}',
 			                 
 			                }
 			            }, {
 			                title: {
 			                    text: 'Est. days'
 			                },
 			                labels: {
 			                    formatter: function () {
 			                        var point = this.point,
 			                            days = (1000 * 60 * 60 * 24),
 			                            number = (point.x2 - point.x) / days;
 			                        return Math.round(number * 100) / 100;
 			                    }
 			                }
 			            }, {
 			                labels: {
 			                    format: '{point.start:%e. %b}'
 			                },
 			                title: {
 			                    text: 'Start date'
 			                }
 			            }, {
 			                title: {
 			                    text: 'End date'
 			                },
 			                offset: 30,
 			                labels: {
 			                    format: '{point.end:%e. %b}'
 			                }
 			            }]
 			        }
 			    },

 			   <c:set var="count" value="0" scope="page" />
 			   series: [{
 			        name: 'Project 1',
 			        data: [<c:forEach items="${ArticleDetail}" var="entry">{
 			        	
 			        //	 start: Date.UTC(2019, 10, 18, 8),
			         //    end: Date.UTC(2019, 10, 25, 16),
			           //  console.log(start.toUTCString());
			             start: ${entry.sch_start_time.getTime()},
			             end: ${entry.sch_end_time.getTime()},
			             name: '${entry.taskName}',
			             assignee: '${entry.firstName} ${entry.lastName}',
			             y: ${count}
		               
		            	
 			        },
 			       <c:set var="count" value="${count + 1}" scope="page"/>
 			        </c:forEach>]
 			    }],

 			    exporting: {
 			        sourceWidth: 1000
 			    }
 			});

 			
			</script>

<script> 
$(document).ready(function() {
	var text_max = 200;

	$('#assign_reason2').keyup(function() {
	    var text_length = $('#assign_reason2').val().length;
	    var text_remaining = text_max - text_length;

	    $('#textarea_feedback2').html(text_remaining + ' characters remaining');
	});

	});
</script>
<script> 
$(document).ready(function() {
	var text_max = 200;

	$('#assign_reason1').keyup(function() {
	    var text_length = $('#assign_reason1').val().length;
	    var text_remaining = text_max - text_length;

	    $('#textarea_feedback1').html(text_remaining + ' characters remaining');
	});

	});
</script>

<script>
function validateBack() {
	var id=document.getElementById("id").value;

	if(id =='Please select a task'){
		alert("Assign To cannot be blank.");
		return false;
	}
	return true;
}
</script>
