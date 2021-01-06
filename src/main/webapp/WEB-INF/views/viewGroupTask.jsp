
<%@ include file="/WEB-INF/includes/include.jsp"%>

<style type="text/css">
.rating-header {
	margin-top: -10px;
	margin-bottom: 10px;
}
</style>
<script src="https://cdn.ckeditor.com/4.13.1/standard-all/ckeditor.js"></script>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Task Detail</span> <span id="Date"></span>
						</div>
					</div>
				</div>
				<!--main_tittle_End-->

				<div class="row ">
					<div class="col-md-12 alert">
						<div class="content_box ">
							<div class="box-body">
								<form id="groupTask" name="groupTask">
									<div class="box-body alert-info">
										<input type="hidden" id="fileurl" name="fileURL"> <input type="hidden" name="article_task_id"
											id="article_task_id" value="${article_task_id}"> <input
											type="hidden" name="article_name" id="article_name"
											value="${article_name}"> <input type="hidden"
											name="article_id" id="article_id" value="${article_id}">
										<input type="hidden" name="flag" id="flag" value="${flag}">
										<input type="hidden" name="workFlowId" id="workFlowId"
											value="${workFlowId}">

										<div class="row">

											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left"><spring:message code="chapter.article" />
														Title :</label> <input type="text"
														class="form-control title-right2" readonly
														id="article_title" placeholder="" autocomplete="off"
														value="${taskManagementVo.article_title}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left"><spring:message code="manuscript.manuscript" />
														ID :</label> <input type="text" class="form-control  title-right2"
														id="journalId" placeholder="" autocomplete="off"
														value="${articleDetail.aid}" readonly>

												</div>
											</div>


											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left"><spring:message code="book.journal" /> Name
														:</label> <input type="text" class="form-control title-right2"
														id="journalId" placeholder="" autocomplete="off"
														value="${journal.journalName}" readonly>

												</div>
											</div>

											<%-- <div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Journal Volume :</label> <input
														type="text" class="form-control title-right2" id="journalId"
														placeholder="" autocomplete="off"
														value="${articleDetail.journal_volume_number}" readonly>

												</div>
											</div> --%>
											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left"><spring:message code="chapter.article" /> DOI
														:</label> <input type="text" class="form-control title-right2"
														id="" placeholder="" autocomplete="off"
														value="${articleDetail.article_doi}" readonly>

												</div>
											</div>
											<%-- 	<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Journal issue :</label> <input
														type="text" class="form-control title-right2" id="journalId"
														placeholder="" autocomplete="off"
														value="${articleDetail.journal_issue_number}" readonly>

												</div>
											</div> --%>

											<div class="col-md-6">
												<div class="form-group">
													<!-- <label for="currency">Stage</label> <input type="text"
													class="form-control" readonly id="task_status"
													placeholder="" autocomplete="off"
													> -->
													<label for="currency" class="art-left">Task Name :</label>
													<input type="text" class="form-control title-right2"
														readonly id="task_status" placeholder=""
														autocomplete="off" value="${taskManagementVo.taskName}">
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<!-- <label for="currency">Stage</label> <input type="text"
													class="form-control" readonly id="task_status"
													placeholder="" autocomplete="off"
													> -->
													<label for="currency" class="art-left">Task Stage :</label>
													<input type="text" class="form-control title-right2"
														readonly id="task_status" placeholder=""
														autocomplete="off" value="${taskManagementVo.task_status}">
												</div>
											</div>


											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Schedule
														Start :</label> <input type="text"
														class="form-control title-right2" readonly
														id="sch_start_time" placeholder="" autocomplete="off"
														value="<fmt:formatDate pattern = "dd-MM-yyyy" value = "${taskManagementVo.sch_start_time}" />">
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Schedule End
														:</label> <input type="text" class="form-control title-right2"
														readonly id="sch_end_time" placeholder=""
														autocomplete="off"
														value="<fmt:formatDate pattern = "dd-MM-yyyy" value = "${taskManagementVo.sch_end_time}" />">
												</div>
											</div>
											<c:if test="${taskscheduler.comments ne null}">
												<div class="col-md-6">
													<div class="form-group">
														<label for="currency" class="art-left">Author
															Decision:</label> <input type="text"
															class="form-control title-right2" readonly placeholder=""
															autocomplete="off" value="${taskscheduler.comments}" />
													</div>
												</div>
											</c:if>
											<%-- 				<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Assign Reason</label> <input
														type="text" class="form-control title-right2" id="journalId"
														placeholder="" autocomplete="off"
														value="${taskManagementVo.assign_reason}" readonly>

												</div>
											</div> --%>

											<%-- <div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Remark :</label> <input type="text"
														class="form-control title-right2" id="journalId" placeholder=""
														autocomplete="off" value="${taskManagementVo.comments}"
														readonly>

												</div>
											</div> --%>
											<%-- 											<c:if test="${sequence ne 0}"> --%>
											<div class="col-md-6">
												<div class="form-group">
													<label for="currency" class="art-left">Type Of
														Article :</label> <input type="text"
														class="form-control title-right2" id="journalId"
														placeholder="" autocomplete="off"
														value="${articleDetail.article_type_cd}" readonly>
												</div>
											</div>
											<!-- <div class="col-md-6">
												<div class="form-group">
													<label class="art-left test-lft">Author Details :</label>
													<button type="button"
														class="btn btn-outline-success date-boxbtn "
														style="padding: 3px 20px; margin-left: 31px;"
														data-toggle="modal" data-target="#authorDetailsList">
														<i class=""></i>Author Details
													</button>
												</div>
											</div> -->
											<div class="col-md-6">
												<div class="form-group">
													<label class="art-left test-lft">Comments :</label>
													<button type="button"
														class="btn btn-outline-success date-boxbtn "
														style="padding: 3px 20px; margin-left: 48px;"
														data-toggle="modal" data-target="#tasksArticleList">
														<i class=""></i>View Comments
													</button>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="art-left test-lft">File Details :</label>
													<button type="button"
														class="btn btn-outline-success date-boxbtn "
														style="padding: 3px 20px; margin-left: 50px;"
														data-toggle="modal" data-target="#FileDetailsList">
														<i class=""></i>File Details
													</button>
												</div>
											</div>
										</div>

									</div>

									<div class=" mt-3">
										<c:if test="${flagDash eq null}">
											<a class="btn btn-outline-danger" href="#"
												onclick="GroupTaskList()"><i class="fa fa-close"></i>
												Cancel</a>
										</c:if>
										<c:if test="${flagDash eq '1'}">
											<a class="btn btn-outline-danger" href="${context}/dashboard">
												<i class="fa fa-close"></i> Cancel
											</a>
										</c:if>
										<c:if test="${flagDash eq '2'}">
											<a class="btn btn-outline-danger" href="${context}/dashboard">
												<i class="fa fa-close"></i> Cancel
											</a>
										</c:if>

										<!-- <a class="btn btn-outline-danger" href="#"
											onclick="GroupTaskList()"><i class="fa fa-close"></i>
											Cancel</a> -->
										&nbsp; <a class="btn btn-outline-dark" href="#"
											onclick="PauseTask(${article_task_id})"><i
											class="fa fa-pause"></i> Pause</a> &nbsp;
										<%-- <c:if test="${roleId eq 2}">  for folder file 
											<a class="btn btn-outline-info" href="#" onclick="allfile()"><i
												class="fa fa-download"></i> Download</a> &nbsp;
											</c:if>
										<c:if test="${roleId ne 2}"> --%>
											<a class="btn btn-outline-info" href="#"
												onclick="Downloadfiles()"><i class="fa fa-download"></i>
												Download</a> &nbsp;
										<%-- 	</c:if> --%>
										<c:if test="${skip eq 'YES'}">
											<button type="button" class="btn btn-outline-primary"
												data-toggle="modal" data-target="#skipTasks">
												<i class="fa fa-arrow-right"></i> Skip
											</button>
										</c:if>

										<%-- 										<c:if test="${workFlowId eq 3717}">  --%>
										<c:choose>

											<c:when test="${approval eq 'YES'}">
												<button type="button" class="btn btn-outline-success"
													data-toggle="modal" data-target="#addapproval">
													<i class="fa fa-check"> </i> Approve
												</button>
											</c:when>
										</c:choose>

										<%-- 	<c:if test="${roleId eq 3712}">
											<button type="button" class="btn btn-outline-success"
												data-toggle="modal" data-target="#sendToAuthorProof">
												<i class="fa fa-check"></i> Author proofs
											</button>

										</c:if> --%>
										<%-- <c:if test="${roleId eq '4'}">
													<button type="button" class="btn btn-outline-success" onClick="window.open('${xmlFile}');">
														<i class="fa fa-check" ></i> View Article
													</button>
												</c:if>
												<c:if test="${roleId ne '4'}"> --%>
										<c:choose>

											<c:when test="${approval ne 'YES'}">
												<button type="button" class="btn btn-outline-success"
													data-toggle="modal" data-target="#addtask">
													<i class="fa fa-check"></i> Complete Action
												</button>
											</c:when>
										</c:choose>
										<%-- </c:if> --%>

										<c:choose>
											<c:when test="${assignBack eq 'YES'}">
												<button type="button" class="btn btn-outline-primary"
													data-toggle="modal" data-target="#assignback">
													<i class="fa fa-arrow-left"></i> Assign back
												</button>
											</c:when>



											<%-- <c:otherwise>
												<button type="button" class="btn btn-outline-primary"
													data-toggle="modal" data-target="#assignback">
													<i class="fa fa-arrow-left"></i> Assign Back 
												</button>
											</c:otherwise> --%>
										</c:choose>


										<!-- <a href="#" data-toggle="modal" data-target="#viewGroupTask"
											class="btn btn-outline-success"> <i class="fa fa-check"></i>
											Run
											</a> &nbsp; -->
										<%-- <c:if test="${errorprocess ne 'NOERROR'}">
										<a href="#" class="btn  btn-outline-danger"
											data-toggle="modal" data-target="#errorModal"> <i
											class="fa  fa-warning"></i>View Error
										</a> &nbsp;
										</c:if> --%>
										<%-- <a class="btn btn-outline-primary ml-2" href="#" onclick="assignBack(${article_id})"><i class="fa fa-arrow-left"></i>Assign Back</a> --%>

										<%-- 										</c:if>  --%>

										<%-- <c:if test="${workFlowId eq 4059}">
											<c:if test="${runValue eq 0 }">
												 <button type="button" class="btn btn-outline-success"
													onclick="createRunFunctionality(${taskId},1);" id="run_task">
													<i class="fa fa-check"></i> Run
												</button> &nbsp; 

													<a href="#" data-toggle="modal" data-target="#viewGroupTask"
													class="btn btn-outline-success"
													onclick="createRunFunctionality(${taskId},${runValue});">
													<i class="fa fa-check"></i> Run
												</a> &nbsp;
												<!-- Button trigger modal -->



											</c:if>
										</c:if> 
									<%-- 	<c:if test="${workFlowId eq 371745}">
											<c:if test="${runValue eq 0 }">
												<button type="button" class="btn btn-outline-success"
													onclick="createRunFunctionalitywindows(${taskId},1);"
													id="run_task">
													<i class="fa fa-check"></i> Run
												</button> &nbsp;
												<!--  <a  href="#" data-toggle="modal" data-target="#viewGroupTask" class="btn btn-outline-success"	>
													<i class="fa fa-check"></i> Run
												</a> &nbsp;  -->
											</c:if>
										</c:if> --%>

										<!-- Modal -->
										<div class="modal fade" id="viewGroupTask" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel">
											<div class="modal-dialog modal-xl" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h4 class="modal-title" id="myModalLabel">Content
															Processing Under Progress</h4>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>

													</div>
													<div class="modal-dialog modal-xl">
														<div class="row" style="padding-left: 15px">
															<div class="col-12">
																<!-- <div id="div10" style="font-size: 11px;margin-bottom: 15px">*XML
																	creation under progress for your Content. Please wait
																	for all steps to complete</div> -->
																<!-- Default unchecked -->
																<div class="row">
																	<div class="col-md-2">
																		<div id="div1" class="content-Block">
																			<div style="margin-bottom: 15px">
																				<img src="resources/images/Uni_tag.png"
																					class="img-res">
																			</div>
																			<div style="margin-bottom: 15px">
																				<i class="fa fa-square" style="color: gray;"
																					id="div12"></i><i class="fa fa-check-square"
																					style="color: green; display: none;" id="div11"></i>&nbsp;&nbsp;&nbsp;Content
																				Collation
																			</div>
																			<div style="margin-bottom: 15px">
																				<div id="div2" class="content-Block">
																					<i class="fa fa-square" style="color: gray;"
																						id="div22"></i><i class="fa fa-check-square"
																						style="color: green; display: none;" id="div21"></i>&nbsp;&nbsp;&nbsp;Content
																					Structuring
																				</div>
																			</div>

																			<div style="margin-bottom: 15px" id="div76">
																				<div id="div2" class="content-Block">
																					<i class="fa fa-clock-o " style="color: gray;"
																						id="div22"></i>&nbsp;&nbsp;&nbsp;0.22 Second
																				</div>
																			</div>
																		</div>
																	</div>


																	<div class="col-md-2">
																		<div id="div3" class="content-Block">
																			<div style="margin-bottom: 15px">
																				<img src="resources/images/Uni_edit.png"
																					class="img-res">
																			</div>
																			<div style="margin-bottom: 15px">
																				<i class="fa fa-square" style="color: gray;"
																					id="div32"></i><i class="fa fa-check-square"
																					style="color: green; display: none;" id="div31"></i>&nbsp;&nbsp;&nbsp;Smart
																				Content Editing
																			</div>
																			<div style="margin-bottom: 15px"></div>
																			<div style="margin-bottom: 15px" id="div77">
																				<i class="fa fa-clock-o" style="color: gray;"
																					id="div32"></i><i class="fa fa-check-square"
																					style="color: green; display: none;" id="div31"></i>&nbsp;&nbsp;&nbsp;0.32
																				Second
																			</div>
																		</div>
																	</div>
																	<div class="col-md-2">
																		<div id="div4" class="content-Block">
																			<div style="margin-bottom: 15px">

																				<img src="resources/images/Uni-_art.png"
																					class="img-res">
																			</div>
																			<div style="margin-bottom: 15px">
																				<i class="fa fa-square" style="color: gray;"
																					id="div42"></i><i class="fa fa-check-square"
																					style="color: green; display: none;" id="div41"></i>&nbsp;&nbsp;&nbsp;Image
																				Processing
																			</div>
																			<div style="margin-bottom: 15px">
																				<!-- <br><br> -->
																			</div>
																			<div style="margin-bottom: 15px" id="div78">
																				<i class="fa fa-clock-o" style="color: gray;"
																					id="div42"></i><i class="fa fa-clock-o"
																					style="color: green; display: none;" id="div41"></i>&nbsp;&nbsp;&nbsp;0.45
																				Second
																			</div>
																		</div>
																	</div>
																	<div class="col-md-3">
																		<div id="div5" class="content-Block">
																			<div style="margin-bottom: 15px">
																				<img src="resources/images/Uni_page.png"
																					class="img-res">
																			</div>
																			<div style="margin-bottom: 15px">
																				<i class="fa fa-square" style="color: gray;"
																					id="div52"></i><i class="fa fa-check-square"
																					style="color: green; display: none;" id="div51"></i>&nbsp;&nbsp;Creating
																				Pagination & Generating XML File
																			</div>
																			<div style="margin-bottom: 15px">
																				<!-- <br><br> -->
																			</div>
																			<div style="margin-bottom: 15px" id="div79">
																				<i class="fa fa-clock-o" style="color: gray;"
																					id="div52"></i><i class="fa fa-clock-o"
																					style="color: green; display: none;" id="div51"></i>&nbsp;&nbsp;1
																				Min. 4 Second
																			</div>
																		</div>
																	</div>
																	<div class="col-md-3">
																		<div id="div6" class="content-Block">
																			<div style="margin-bottom: 15px">
																				<img src="resources/images/Uni_proof.png"
																					class="img-res">
																			</div>
																			<div style="margin-bottom: 15px">
																				<i class="fa fa-square" style="color: gray;"
																					id="div62"></i><i class="fa fa-check-square"
																					style="color: green; display: none;" id="div61"></i>&nbsp;&nbsp;&nbsp;Converting
																				XML to XHTML
																			</div>
																			<div style="margin-bottom: 15px"></div>
																			<div style="margin-bottom: 15px" id="div80">
																				<i class="fa fa-clock-o " style="color: gray;"
																					id="div62"></i><i class="fa fa-clock-o"
																					style="color: green; display: none;" id="div61"></i>&nbsp;&nbsp;&nbsp;1
																				Min. 12 Second
																			</div>
																		</div>
																	</div>
																</div>
																<div class="bar">
																	<div class="in"></div>
																</div>
															</div>
														</div>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">Close</button>
														<button type="button" class="btn btn-primary" id="div71"
															style="display: none;" target='_blank'
															onClick="window.open('https://172.16.1.77:3041/?userId=3&article=3&doi=10.1055/s-0039-1692643');">View
															Content</button>
														<!-- <button type="button" class="btn btn-primary" id="div71"
															style="display: none;" target='_blank'
															onClick="window.open('https://127.0.0.1:3041/?userId=3&article=3&doi=10.1055/s-0039-1692643');">View
															Content</button>
															 -->

													</div>
												</div>
											</div>
										</div>
										<c:if test="${runValue eq 1 }">

											<!-- <span id="task_btn"> <a
											class="btn btn-outline-primary" href="#" onclick=""><i
												class="fa fa-check"></i> Re-Run</a>&nbsp; <a
											class="btn btn-outline-primary ml-2" href="#" onclick=""
											data-toggle="modal" data-target="#assignback"><i
												class="fa fa-arrow-left"></i> Assign-Back</a>&nbsp; <a
											class="btn btn-outline-success" href="#" onclick=""><i
												class="fa fa-check"></i> Approve</a>&nbsp; -->

											<!-- </span> -->
											<span id="task_btn">
												<button type="button" class="btn btn-outline-primary"
													onclick="createRERunFunctionality();">
													<i class="fa fa-check"></i>Re-Run
												</button> &nbsp;

												<button type="button" class="btn btn-outline-dark"
													data-toggle="modal" data-target="#assignback">
													<i class="fa fa-arrow-left"></i> Assign-Back
												</button> &nbsp;

												<button type="button" class="btn btn-outline-success"
													data-toggle="modal" data-target="#addtask">
													<i class="fa fa-check"></i> Approve
												</button> &nbsp;
											</span>
										</c:if>
									</div>

								</form>

								<div id="pageLoder" class="loading-box" style="display: none;">
									<img class="loader-logo" src="resources/images/loader.png">
									<div class="loader"></div>
								</div>
								<!-- error model -->

								<c:if test="${errorprocess ne 'NOERROR'}">

									<div class="modal fade" id="errorModal" role="dialog">
										<div class="modal-dialog">

											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title">View Error</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>

												</div>
												<div class="modal-body">

													<div class="row">
														<div class="col-md-12">
															<div class="content_box">
																<div class="box-body">
																	<table class="table table-striped table-bordered m-0"
																		id="deptTable">
																		<thead class="table-head">
																			<tr>
																				<th>S.No.</th>
																				<th>Error Name</th>
																				<th>Task Name</th>
																				<th>Error Code</th>
																				<th>Error Time</th>

																			</tr>
																		</thead>
																		<tbody>
																			<c:forEach var="temp" items="${errorprocess}"
																				varStatus="counter">

																				<tr>
																					<td align="center">${counter.count}</td>
																					<td align="center">${temp.errorName}</td>
																					<td align="center">${temp.task.taskName}</td>
																					<td>${temp.errorCode}</td>
																					<td><fmt:formatDate
																							pattern="yyyy-MM-dd hh:mm:s  aa"
																							value="${temp.errorTime}" /></td>
																			</c:forEach>
																		</tbody>
																	</table>
																</div>
															</div>
														</div>
													</div>





												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</div>



											</div>

										</div>
									</div>
								</c:if>

							</div>
						</div>
						<div class="modal fade" id=tasksArticleList role="dialog">
							<div class="modal-dialog">
								<div class="modal-content">
									<!-- 	<div class="modal-header"> -->
									<div class="modal-header">
										<h5 class="modal-title">All Comments</h5>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="content_box">
										<div class="box-body">
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
													<c:forEach var="temp" items="${commentsList}"
														varStatus="counter">
														<tr>
															<td align="center">${counter.count}</td>
															<td>${temp.task.taskName}</td>
															<td>${temp.role.roleName}</td>
															<td>${temp.comment}</td>
															<td>${temp.userName}</td>
															<td><fmt:formatDate value="${temp.commentDate}"
																	pattern="yyyy-MM-dd hh:mm a" /></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
									<!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script>
	function GroupTaskList() {
		if (document.getElementById("flag").value == 1){

			document.getElementById("groupTask").action = "mytask";
			document.getElementById("groupTask").method = "POST";
			document.getElementById("groupTask").submit();

		}
		else if(document.getElementById("flag").value == 2){
			document.getElementById("groupTask").action = "dashboard"; // for produnction edtior
			document.getElementById("groupTask").method = "GET";
			document.getElementById("groupTask").submit();
		}else{
			
			document.getElementById("groupTask").action = "mytask";
//			document.getElementById("groupTask").action = "cregrouptask"; // grouptask
			document.getElementById("groupTask").method = "POST";
			document.getElementById("groupTask").submit();
		}
	}

	function PauseTask(val) {
		document.getElementById("article_task_id").value = val;
		document.getElementById("groupTask").action = "pausetask";
		document.getElementById("groupTask").method = "POST";
		document.getElementById("groupTask").submit();
	}

	function Downloadfiles(){
		document.getElementById("groupTask").action="download-Completedtask-file";
	    document.getElementById("groupTask").method="POST";
		document.getElementById("groupTask").submit();
	}
	
	function allfile() {
		document.getElementById("groupTask").action = "file";
		document.getElementById("groupTask").method = "POST";
		document.getElementById("groupTask").submit();
	}


// 	$(function() {
// 		$('#task_btn').hide();
// 	});


	function createRERunFunctionality()
	{

		$('#pageLoder').show();
		setTimeout(function(){hideLoader('Task Executed');}, 5000);
	}

	
	
	function createRunFunctionality(taskID,runId){
	var aId = document.getElementById("article_id").value
	var jId = document.getElementById("journalId").value  
	var wId = document.getElementById("workFlowId").value  
	
		
		
		var mappingJSON = {};
		mappingJSON["task_id"] = taskID;
		mappingJSON["runId"] = runId;
		mappingJSON["workflow_id"] = wId;

		mappingJSON["article_id"] = aId;
		var mappingInfo = JSON.stringify(mappingJSON);
		$.ajax({
			url : '/saveTaskRunId',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				if(/successfully/ig.test(result.responseText)){
					$(location).attr('href',"getDepartmentHead");
					
					createRERunFunctionality();
		    	}else {
		    		
		    	}
			},
			error : function(e) {
				console.log(e.message);
			}
		});
	}

	function createRunFunctionalitywindows(taskID,runId){
		var aId = document.getElementById("article_id").value
		var jId = document.getElementById("journalId").value  
		var wId = document.getElementById("workFlowId").value  
		
			//alert(aId +"  "+jId+" "+wId);
			//alert(taskID+"dfg"+runId);
			$('#pageLoder').show();
			    		setTimeout(function(){hideLoader('Task Executed');}, 18000);
			
			//var deprtId = document.getElementById("deptID").value;
		//	var userId = document.getElementById("userDepartment").value;
			
			var mappingJSON = {};
			mappingJSON["task_id"] = taskID;
			mappingJSON["runId"] = runId;
			mappingJSON["workflow_id"] = wId;

			mappingJSON["article_id"] = aId;
			var mappingInfo = JSON.stringify(mappingJSON);
			$.ajax({
				url : '/saveTaskRunIdwindow',
				type : "POST",
				data : mappingInfo,
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				cache : false,
				success : function(result) {
					if(/successfully/ig.test(result.responseText)){
						$(location).attr('href',"getDepartmentHead");
						
						createRERunFunctionality();
			    	}else {
			    		$('#pageLoder').show();
			    		setTimeout(function(){hideLoader('Task Executed');}, 10000);
			    		//alert(result.responseText);
			    	}
				},
				error : function(e) {
					console.log(e.message);
				}
			});
		}

	$(".progress-bar-fill").css({"width":"100%","transition":"5s"});

	
// 	function createRunFunctionality(taskID){
// 		alert(taskID);
// 		$('#pageLoder').show();
// 		setTimeout(function(){hideLoader('Task Executed');}, 5000);
// 	}

	function hideLoader(actions){
		if (confirm(actions+" Successfully.")) {
			$('#pageLoder').hide();
			$('#run_task').hide();
			$('#task_btn').show();
		}
	}

	function createApproveFunctionality(){
		$('#pageLoder').show();
		setTimeout(function(){hideLoader('Approved');}, 5000);
	}
	
	</script>
<script>
$(document).ready(function(){
	
    $("#div11").delay(10000).fadeIn(1000);
    $("#div21").delay(15000).fadeIn(1000);
    $("#div31").delay(30000).fadeIn(1000);
    $("#div41").delay(45000).fadeIn(1000);
    $("#div51").delay(62000).fadeIn(1000);
    $("#div61").delay(72000).fadeIn(1000);
    $("#div71").delay(72000).fadeIn(1000);
   
    $("#div12").delay(9900).fadeOut(1000);
    $("#div22").delay(14000).fadeOut(1000);
    $("#div32").delay(29000).fadeOut(1000);
    $("#div42").delay(44000).fadeOut(1000);
    $("#div52").delay(61000).fadeOut(1000);
    $("#div62").delay(71000).fadeOut(1000);
    
    $("#div76").hide().delay(15000).fadeIn();
    $("#div77").hide().delay(30000).fadeIn();
    $("#div78").hide().delay(45000).fadeIn();
    $("#div79").hide().delay(62000).fadeIn();
    $("#div80").hide().delay(72000).fadeIn();
   // $("#div76").delay(5000).fadeIn(500);
    

});




</script>
<script src="/resources/js/bootbox.min.js" type="text/javascript"></script>
<script>
jQuery(document).ready(function($){
	
	$(".btnrating").on('click',(function(e) {
	var previous_value = $("#selected_rating").val();
	
	var selected_value = $(this).attr("data-attr");
//	var selected_value =document.getElementById("selected_value").value;
	$("#ratingStar").val(selected_value);
	$("#selected_rating").val(selected_value);
	
	$(".selected-rating").empty();
	$(".selected-rating").html(selected_value);
	
	for (i = 1; i <= selected_value; ++i) {
	$("#rating-star-"+i).toggleClass('btn-warning');
	$("#rating-star-"+i).toggleClass('btn-default');
	}
	
	for (ix = 1; ix <= previous_value; ++ix) {
	$("#rating-star-"+ix).toggleClass('btn-warning');
	$("#rating-star-"+ix).toggleClass('btn-default');
	}
	
	}));
});
</script>
<div class="modal fade" id="addtask" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><h4>Upload File</h4></label>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<form action="${context}/completeTask" method="post" name="form"
				enctype="multipart/form-data">
				<div class="modal-body">
					<div class="form-group">
						<c:if test="${roleid eq 3712}">
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
						</c:if>
					</div>
					<input type="file" class="form-control" id="attachment"
						autocomplete="off" required name="attachment"
						<%-- accept=".${fileType}" --%> placeholder=""> <input
						type="hidden" name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> <span
						class="text-red mandatoryMsg"> <sup class="text-red">&lowast;</sup> You can upload ${fileType}
						file only</span>
					<c:if test="${taskId eq 105923}">
						<lable>Enter Page Number</lable>&nbsp;<sup class="text-red">&lowast;</sup>
						<input class="form-control" type="text" name=page_number
							id="pageNumber" value="" required
							oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
							maxlength="3" onkeypress="return isNumberKey(event)">
					</c:if>
					<lable>Number of Questions</lable>&nbsp;<sup class="text-red">&lowast;</sup>
						<input class="form-control" type="text" name="que_in_file"
							id="queInFile" value="" required
							oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
							maxlength="5" onkeypress="return isNumberKey(event)">
					<label><h5>Comments</h5></label>&nbsp;&nbsp; <br>
					<textarea rows="2" cols="80" maxlength="200" id="assign_reason"
						name="assign_reason"></textarea>
					<div id="textarea_feedback" style="color: red"></div>
					<div class="modal-body">
						<input type="submit" class="btn btn-primary btn-sm float-right "
							value="Submit Task" onClick="return validate()" />
					</div>
					<div id="message">
						<h1>${message}</h1>
					</div>
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
			
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<form action="${context}/assignBack" method="post" name="assignBackFrom"
				enctype="multipart/form-data">
				<div class="modal-body">
					<label for="currency"><b>Assign To</b><sup class="text-red">&lowast;</sup></label>
					<form:select path="TaskList" id="id" name="id" class="form-control"
						required="required">
						<form:option value="Please select a task" labelValue="" />
						<form:options items="${TaskList}" itemValue="id"
							itemLabel="taskName" />
					</form:select>

					<label><b>Comments</b></label> <br>
					<textarea rows="3" cols="80" maxlength="200" name="assign_reason"
						id="assign_reason1"></textarea>
					<div id="textarea_feedback1" style="color: red"></div>

					<input type="file" class="" id="notmandatry" name="backFile"><br> <input type="hidden" name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> <input
						type="submit" class="btn btn-primary btn-sm float-right"
						value="Assign Back" onClick="return validateBack()" /><br>

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

			<form action="${context}/skipTasks" method="post">
				<div class="modal-body">
					<div class="form-group">
						<c:if test="${roleid eq 3712}">
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
						</select></c:if>
					</div>
					<label for="currency"><b>Assign To</b> <sup
						class="text-red">&lowast;</sup></label>
					<form:select path="TaskList" id="id1" name="id"
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
					<input type="hidden" name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> <input
						type="submit" class="btn btn-primary btn-sm float-right"
						value="Skip Task" onClick="return assignBackValidate()" /><br>

				</div>
			</form>
		</div>
	</div>
</div>



<div class="modal fade" id=sendToAuthorProof role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<label for="currency"><b>Compose A Mail to Author</b></label>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>


			<form action="${context}/sendCostMsg" method="post">
				<div class="modal-body">
					<label for="currency"><b>Assign To : </b></label>
					<c:forEach var="authorDetail" items="${authorDetails}"
						varStatus="counter">
						<br>
						<a>${authorDetail.title}</a>
						<a> ${authorDetail.fName}</a>
						<a> ${authorDetail.lName}</a>
						<br>
					</c:forEach>



					<label for="exampleInputEmail1"><b>Email Body</b></label>

					<textarea class="form-control" id="editor1" name="editorData"
						required>
							</textarea>


					<input type="hidden" name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						name="article_id" id="article_id" value="${article_id}"> <input
						type="submit" class="btn btn-primary btn-sm float-right" /><br>

				</div>
			</form>
		</div>
	</div>
</div>

<div class="modal fade" id=authorDetailsList role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- <div class="modal-header"> -->
			<div class="modal-header">
				<h5 class="modal-title">Author Details</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="content_box">
				<div class="box-body">
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
									<td>${temp.title}&nbsp;${temp.fName}&nbsp; ${temp.mName}
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
			<!-- 	<button type="button" class="close" data-dismiss="modal">&times;</button> -->
		</div>

	</div>
</div>

<div class="modal fade" id=FileDetailsList role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- <div class="modal-header"> -->
			<div class="modal-header">
				<h5 class="modal-title">File Details</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
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
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="temp" items="${fileVersions}" varStatus="counter">

								<tr>
									<td align="center">${counter.count}</td>
									<td>${temp.fileName}</td>

									<td>${temp.fileVersion}</td>
								<%-- 	<td>${temp.size}</td> --%>
									<td>${temp.taskDetails.taskName}</td>
									<td>${temp.userDetails.firstName}
										&nbsp;${temp.userDetails.lastName}</td>
									<td class="text-center">
										<button type='button' class="btn btn-danger btn-sm"
											onclick="DownloadFile('${temp.filePath}')" value='Download'>Download</button></td>
								
									<!--  -->
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 	<button type="button" class="close" data-dismiss="modal">&times;</button> -->
		</div>

	</div>
</div>


<div class="modal fade" id="addapproval" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="${context}/approveTask" enctype="multipart/form-data"
				method="post">
				<div class="modal-body">

					<div class="modal-header">
						<label for="currency"><h5>Approve Task</h5></label>

						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
				
					<c:if test="${roleid eq 3712}">
					<label>Priority</label> <select id="priority" name="priority"
						class="form-control">
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
					</c:if>
					 <label><b>Comments</b></label> <br>
					<textarea rows="8" cols="80" maxlength="200" name="comments"
						id="comments"></textarea>
					<div class=""></div>
					<div id="textarea_feedback3" style="color: red"></div>

					<input type="hidden" name="article_task_id" id="article_task_id"
						value="${article_task_id}"> <input type="hidden"
						id="ratingStar" name="ratingStar" value=0> <input
						type="hidden" name="article_id" id="article_id"
						value="${article_id}"><br>
					<input type="file" class="" id="attachment" name="attachment"
						accept="application/${fileType}" placeholder=""><br>
					<input type="submit" value="Submit Task"
						class="btn flat-btn btn-primary btn-sm float-right" /><br>

				</div>
			</form>

		</div>
	</div>
</div>

<div class="modal fade" id="run_task_dialog" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header"></div>

		</div>
	</div>
</div>
<script>
					CKEDITOR
							.replace(
									'editorData',
									{
										// Define the toolbar groups as it is a more accessible solution.
										toolbarGroups : [ {
											"name" : "basicstyles",
											"groups" : [ "basicstyles" ]
										},  {
											"name" : "paragraph",
											"groups" : [ "list", "blocks" ]
										}, {
											"name" : "document",
											"groups" : [ "mode" ]
										}, {
											"name" : "insert",
											"groups" : [ "insert" ]
										}],
										// Remove the redundant buttons from toolbar groups defined above.
										removeButtons : 'Underline,Strike,Subscript,Superscript,Anchor,Styles,Specialchar'
									});
				</script>
<script type="text/javascript">

function validate(){
	  var file= form.attachment.value;
	 var filety= '${fileType}';
	 var filetype =  /(.*?)\.(${fileType})$/;
	 var filetypedoc =  /(.*?)\.(${fileType}|doc)$/;
	 var filetypepdfdoc =  /(.*?)\.(pdf|doc|docx)$/;
	 debugger;
	 
	 if(filety=='' || filety=='null' || filety=='all'){
		  return true;
	  }
	 if(filety=='docx'){
	  if(file.match(filetypedoc)){
		//  alert('You can upload ${fileType} or doc files only.');
		 return true;;
	 }
	  }
	 if(filety=='docx or pdf'){
		  if(file.match(filetypepdfdoc)){
			//  alert('You can upload ${fileType} or doc files only.');
			 return true;;
		 }
		  }
	  if(!file.match(filetype))
	       {
	    	   alert('You can upload ${fileType} files only.');
	    	   return false;
	       }
	  
	  var pageNumber=document.getElementById("pageNumber").value;
		if(pageNumber ==''){
			alert("Page number cannot be blank.");
			return false;
		}
		
		  var queInFile=document.getElementById("queInFile").value;
			if(queInFile ==''){
				alert("Que Number cannot be blank.");
				return false;
			}
		
	   	return true;
	   	return true;
	 }
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

<script> 
$(document).ready(function() {
	var text_max = 200;
	/ $('#textarea_feedback').html(text_max + ' characters remaining'); /

	$('#assign_reason').keyup(function() {
	    var text_length = $('#assign_reason').val().length;
	    var text_remaining = text_max - text_length;

	    $('#textarea_feedback').html(text_remaining + ' characters remaining');
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
$(document).ready(function() {
	var text_max = 200;

	$('#comments').keyup(function() {
	    var text_length = $('#comments').val().length;
	    var text_remaining = text_max - text_length;

	    $('#textarea_feedback3').html(text_remaining + ' characters remaining');
	});

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
function assignBackValidate() {
	var id=document.getElementById("id1").value;

	if(id =='Please select a task'){
		alert("Assign To cannot be blank.");
		return false;
	}
	return true;
}
</script>
<script>

$('input#pageNumber').keyup(function(e){ 
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

<Script>
	 window.onload = function() {
		 const myInput = document.getElementById('pageNumber');
		 myInput.onpaste = function(e) {
		   e.preventDefault();
		 }
		}
	 </Script>

<script>

	$(document).ready(function() {
	    $('#fileTable').DataTable();
	} );
	
	
	function DownloadFile(val) {
	//	alert(val);
		debugger;
		document.getElementById("fileurl").value =val;
		document.getElementById("groupTask").action = "dwonload_file";
		document.getElementById("groupTask").method = "GET";
		document.getElementById("groupTask").submit();
	}
</script>