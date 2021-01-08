<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-12">
					<c:if test="${not empty message}"> 
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>  ${message}</strong>
					</div>
				</c:if>
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Manage <spring:message
									code="book.journal" /></span> <span id="Date">Mon , 26 Aug
								2019</span><span class="ml-auto"><a href="javascript:;"
								class="btn btn-sm btn-outline-danger" onclick="createJournal()"><i
									class="fa fa-plus"></i> Add New Subject</a> <a href="/createExam"
								class="btn btn-sm btn-outline-danger"><i class="fa fa-plus"></i>
									Add New Exam</a>
									<a href="getExamList"
								class="btn btn-sm btn-outline-danger">
									Exam List</a>
									</span> <span class="pull-right"> </span>
						</div>
					</div>
				</div>
				<!--main_tittle_End-->

				<form name="article" id="journal">
					<input type="hidden" name="journalId" id="journalId">

					<div class="row">
						<div class="col-md-12">


							<input type="hidden" name="workflowid" id="workflowid">
							<div class="content_box">
							<input type="hidden" name="jId"
														id="jId">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0"
										id="journalTable" style="max-width: 100%">
										<thead class="table-head">
											<tr>
												<th>Manage <spring:message code="chapter.article" /> Workflow</th>
												<%-- <th>Manage <spring:message code="issue.book" /> Workflow</th> --%>
												<th>Email Temp</th>
												<!-- <th>Email Issue Temp</th> -->
												<th><spring:message code="book.journal" /> Acronym</th>
												<th><spring:message code="book.journal" /> Title</th>
												<th><spring:message code="exam.exam" /> Exam</th>
												<!-- <th>Online ISSN</th>
												<th>Print ISSN</th>
												<th>DOI</th>
												<th>Open Access Status</th> -->
												<th>Status</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="temp" items="${journallist}"
												varStatus="counter">
												<tr>
													<td align="center"> <c:if
															test="${temp.articleWorkflowId eq 0}">
															<a href="#" onclick="editworkFlowTask(${temp.journalId})"
																data-placement="top" title="Add Workflow"> <i
																class="fa fa-edit edit-icon"></i></a>
														</c:if> <c:if test="${temp.articleWorkflowId ne 0}">
															<a href="#" onclick="viewworkFlowTask(${temp.journalId})"
																data-placement="top" title="View Workflow Info"> <i
																class="fa fa-eye edit-icon"></i></a>
														</c:if></td>
													<%-- <td align="center"><input type="hidden" name="jId"
														id="jId"> <c:if
															test="${temp.issueWorkflowId eq 0}">
															<a href="#"
																onclick="editIssueworkFlowTask(${temp.journalId})"
																data-placement="top" title="Add Issue Workflow"> <i
																class="fa fa-edit edit-icon"></i></a>
														</c:if> <c:if test="${temp.issueWorkflowId ne 0}">
															<a href="#"
																onclick="viewIssueworkFlowTask(${temp.journalId})"
																data-placement="top" title="View Issue Workflow Info">
																<i class="fa fa-eye edit-icon"></i>
															</a>
														</c:if></td> --%>

													<td align="center"><c:if
															test="${(temp.articleWorkflowId ne 0)}">
															<a href="#" onclick="editMail(${temp.articleWorkflowId},${temp.journalId})"
																data-placement="top" title="Add Article Email"> <i
																class="fa fa-edit edit-icon"></i></a>
														</c:if> 
<%-- 														<c:if --%>
<%-- 															test="${(temp.articleWorkflowId eq 0) and (temp.issueWorkflowId eq 0)}"> --%>
<%-- 															<a href="#" onclick="editMail(${temp.articleWorkflowId},${temp.journalId})" --%>
<!-- 																data-placement="top" title="View Email Info"> <i -->
<!-- 																class="fa fa-eye edit-icon"></i></a> -->
<%-- 														</c:if> --%>
														</td>
														<%-- <td align="center"><c:if
															test="${(temp.issueWorkflowId ne 0)}">
															<a href="#" onclick="editIssueMail(${temp.issueWorkflowId},${temp.journalId})"
																data-placement="top" title="Add Issue Email"> <i
																class="fa fa-edit edit-icon"></i></a>
														</c:if> 
														</td> --%>
														

													<td>${temp.journalAcronym}</td>
													<td>${temp.journalName}</td>
													<td>${temp.examDetails.examDescription}</td>
													<%-- <td>${temp.onlineIssn}</td>
													<td>${temp.printIssn}</td>
													<td>${temp.doiPrefix}</td>
													<td>${temp.openAccessStatus}</td> --%>
													<td class="greenActive">${temp.status}</td>
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

$(document).ready( function () {
    $('#journalTable').DataTable();
} );

function editworkFlowTask(val){
	document.getElementById("jId").value=val;
	document.getElementById("journal").action="manageworkFlowJournal";
    document.getElementById("journal").method="POST";
	document.getElementById("journal").submit();
}
function editIssueworkFlowTask(val){
	document.getElementById("jId").value=val;
	document.getElementById("journal").action="manageIssueworkFlowJournal";
    document.getElementById("journal").method="POST";
	document.getElementById("journal").submit();
}

function viewworkFlowTask(val){
	document.getElementById("jId").value=val;
	document.getElementById("journal").action="viewmanageworkFlowJournal";
    document.getElementById("journal").method="POST";
	document.getElementById("journal").submit();
}
function viewIssueworkFlowTask(val){
	document.getElementById("jId").value=val;
	document.getElementById("journal").action="viewmanageIssueworkFlowJournal";
    document.getElementById("journal").method="POST";
	document.getElementById("journal").submit();
}

function editMail(val,jrID){
	document.getElementById("workflowid").value=val;
	document.getElementById("jId").value=jrID;
//	alert(val+"::"+jrID);
	document.getElementById("journal").action="emailJournalMail";
    document.getElementById("journal").method="POST";
	document.getElementById("journal").submit();
}
function editIssueMail(val,jrID){
	document.getElementById("workflowid").value=val;
	document.getElementById("jId").value=jrID;
//	alert(val+"::"+jrID);
	document.getElementById("journal").action="emailJournalIssueMail";
    document.getElementById("journal").method="POST";
	document.getElementById("journal").submit();
}
</script>

