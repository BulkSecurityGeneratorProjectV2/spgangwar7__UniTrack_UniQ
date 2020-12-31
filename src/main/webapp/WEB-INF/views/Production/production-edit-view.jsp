<%@page
	import="java.util.Date,java.util.Calendar,java.text.SimpleDateFormat"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.util.List,java.io.*,java.util.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="images/favicon.ico">
<link href="<%=request.getContextPath()%>/css/datatables.min.css"
	rel="stylesheet">
<title>DigiScape</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<!-- font-awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<!--Bootstrap 4 DatePicker-->
<link href="css/gijgo.css" rel="stylesheet">
<!--Bootstrap 4 DatePicker-->

<!-- Custom styles for this template -->
<link href="css/side_menu.css" rel="stylesheet">
<link href="css/my_style.css" rel="stylesheet">

<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|Poppins:300,400,500,600,700"
	rel="stylesheet">
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
</head>

<body>
	<form name="production" id="production">
		<input type="hidden" value="${LoginId}" name="LoginId" id="LoginId" />
		<input type="hidden" name="flag" id="flag" value="${flag}">
		<!--  header-->
		<div id="header">
			<nav class="navbar navbar-expand-md navbar-light bg-white fixed-top">
				<div class="container-fluid">
					<a class="navbar-brand" href="#"><img src="images/logo.png"
						class="img-fluid" alt=""></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarsExampleDefault"
						aria-controls="navbarsExampleDefault" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarsExampleDefault">
						<ul class="navbar-nav ml-auto">

						</ul>
						  <li class="nav-item"> <a class="nav-link" href="#" onclick="ProductionDashboard()">SQA AM Dashboard</a> </li>
						</ul>
					</div>
					<ul class="d-flex on_mobile">
						<li class="dropdown user-box"><a class="dropdown-toggle"
							href="#" id="dropdown01" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"> <img
								src="images/user2-160x160.jpg" class="user-image rounded-circle"
								alt="User Image"> <span> ${name}</span>
						</a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="dropdown01">
								<ul class="my_dropdown">
									<!-- The user image in the menu -->
									<li class="user-header"><img
										src="images/user2-160x160.jpg" class="rounded-circle"
										alt="User Image">

										<p>${name}</p></li>
									<!-- Menu Body -->
									<li class="user-body">
										<div class="row">
											<div class="col-12 text-center">
												<!--  <a href="change_password.html">Change Password</a> -->
											</div>
										</div> <!-- /.row -->
									</li>
									<!-- Menu Footer-->
									<li class="user-footer clearfix">
										<div class="pull-left clearfix">
											<!-- <a href="profile-page.html" class="remove_btn btn">Profile</a> -->
										</div>
										<div class="pull-right clearfix">
											<a href="${context}/login" class="remove_btn btn">Sign out</a>
										</div>
									</li>
								</ul>

							</div></li>
					</ul>
				</div>
			</nav>
		</div>
		<!--  header-->

		<!-- Sidebar Holder -->
		<%--   <jsp:include page="sidebar.jsp"/> --%>
		<!-- Sidebar Holder -->

		<!--Main_part-->
		<div class="main_part_outer">
			<div class="container-fluid">
				<div class="row ">
					<div class="col-md-12 h-100">
						<div class="main_tittle">Details</div>
						<div class="bg-white h-100 main_box">
							<form class="w-100">

								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label for="Stage">Project Name <sup class="text-red">&lowast;</sup></label>
<%-- 											<form:select path="tdSupportProjectList" name="project_id" --%>
<%-- 												id="project_id" onchange="getteamName()" --%>
<%-- 												class="form-control"> --%>
<%-- 												<form:option value="2">${projectName}</form:option> --%>
<%-- 												<form:options items="${tdSupportProjectList}" --%>
<%-- 													itemValue="projectid" itemLabel="project_name" /> --%>
<%-- 											</form:select> --%>
											<select class="form-control" name="project_name" id="project_name" required>
                   <option value="${ProjectSupportTicket.project_name}">${ProjectSupportTicket.project_name}</option>
                    <option value="Upstream Feed back">Upstream Feed back</option>
                    <option value="Internal Resupply">Internal Resupply</option>
                    <option value="External Resupply">External Resupply</option>
                    <option value="Escalations">Escalations</option>
                     <option value="Customer service">Customer service</option>
                  </select> 
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="CompanyAddress">Ticket Type<sup class="text-red">&lowast;</sup></label> <select
												class="form-control" name="ticket_type_cd"
												id="ticket_type_cd">
												<option value="${ProjectSupportTicket.ticket_type_cd}">${ProjectSupportTicket.ticket_type_cd}</option>
												<option value="Change Request">Change Request</option>
												<option value="Bug">Bug</option>
												<option value="Enhancement">Enhancement</option>
												<option value="Production Support">Production
													Support</option>

											</select>
										</div>
									</div>

									<div class="col-md-4">
										<div class="form-group">
										<label for="CompanyAddress">Application Name<sup class="text-red">&lowast;</sup></label>
<!-- 											 <input -->
<!-- 												type="text" class="form-control" name="application_name" -->
<!-- 												id="application_name" placeholder="" -->
<%-- 												value="${ProjectSupportTicket.application_name}">  --%>
										<select class="form-control" name="application_name" id="application_name" required>
							                   <option value="${ProjectSupportTicket.application_name}">${ProjectSupportTicket.application_name}</option>
							                    <option value="TD XPS">TD XPS</option>
							                    <option value="FMS">FMS</option>
							                    <option value="UniTouch">UniTouch</option>
							                    <option value="Hybrid">Hybrid</option>
							                  </select> 
												<input type="hidden" name="support_ticket_id" value="${ProjectSupportTicket.support_ticket_id}">
										</div>
									</div>

								</div>


								<div class="row"></div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label for="CompanyAddress">Priority<sup class="text-red">&lowast;</sup></label> <select
												class="form-control" name="prioitty" id="prioitty" required>
												<option value="${ProjectSupportTicket.prioitty}">${ProjectSupportTicket.prioitty}</option>
												<option value="Urgent">Urgent</option>
												<option value="Production Urgent">Production Urgent</option>
												<option value="Medium">Medium</option>
												<option value="High">High</option>
												<option value="Low">Low</option>
											</select>
										</div>
									</div>

									<div class="col-md-4">
										<div class="form-group">
											<label for="CompanyAddress">Ticket Status<sup class="text-red">&lowast;</sup></label> <select
												class="form-control" name="ticket_status_cd"
												id="ticket_status_cd" required>
												<option value="${ProjectSupportTicket.ticket_status_cd}">${ProjectSupportTicket.ticket_status_cd}</option>
												<option value="Created">Created</option>
												<option value="Assigned">Assigned</option>
												<option value="In progress">In progress</option>
												<option value="On Hold">On Hold</option>
												<option value="Cancelled">Cancelled</option>
												<option value="Completed">Completed</option>
												<option value="Waiting for details">Waiting for
													details</option>
											</select>
										</div>
									</div>

									<div class="col-md-4">
										<div class="form-group">
											<label for="Stage">Client Name <sup class="text-red">&lowast;</sup></label>
											<form:select path="customerlist" name="client_name"
												id="client_name" class="form-control">
												<form:option value="${ProjectSupportTicket.client_name}"
													labelValue="" />
												<form:options items="${customerlist}"
													itemValue="customerName" itemLabel="customerName" />
											</form:select>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label for="CompanyAddress">Journal ID/Chapter ID/Unique ID<sup class="text-red">&lowast;</sup></label> <input
												type="text" class="form-control" name="journal_id"
												id="journal_id" placeholder="" value="${ProjectSupportTicket.journal_id}">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="CompanyAddress">AID<sup class="text-red">&lowast;</sup></label> <input type="text"
												class="form-control" name="aid" id="aid" placeholder="" value="${ProjectSupportTicket.aid}">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="CompanyAddress">Incident date</label> <input
												type="text" class="form-control" name="incident_date"
												id="incident_date" placeholder="" value="<fmt:formatDate pattern = "dd-MM-yyyy" value = "${ProjectSupportTicket.incident_date}" /> ">
										</div>
									</div>
<!-- 									<div class="col-md-3"> -->
<!-- 										<div class="form-group"> -->
<!-- 											<label for="CompanyAddress">Workflow (FMS/TDXPS)</label> <input -->
<!-- 												type="text" class="form-control" name="workflow_fms_tdxps" -->
<%-- 												id="workflow_fms_tdxps" placeholder=""  value="${ProjectSupportTicket.workflow_fms_tdxps}"> --%>
<!-- 										</div> -->
<!-- 									</div> -->
								</div>
								
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<label for="CompanyAddress">TX/PA No.<sup class="text-red">&lowast;</sup></label> <input
												type="text" class="form-control" name="tx_pa_no"
												id="tx_pa_no" value="${ProjectSupportTicket.tx_pa_no}" placeholder="">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="CompanyAddress">Location<sup class="text-red">&lowast;</sup></label> <input
												type="text" class="form-control" name="location"
												id="location" value="${ProjectSupportTicket.location}" placeholder="">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="CompanyAddress">Site<sup class="text-red">&lowast;</sup></label> 
												 <select class="form-control" name="site" id="site" >
						                <option value="${ProjectSupportTicket.site}">${ProjectSupportTicket.site}</option>
						                <option value="English">English</option>
						                   <option value="French">French</option>
						                   <option value="German" >German</option>
						                    <option value="Spanish">Spanish</option>
						                    
						                  </select> 
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="CompanyAddress">Report Date<sup class="text-red">&lowast;</sup></label> <input
												type="text" class="form-control" name="report_date" autocomplete="none" onchange="newReponse()" placeholder=""
												id="report_date" value="<fmt:formatDate pattern = "dd-MM-yyyy" value = "${ProjectSupportTicket.report_date}" /> ">
										</div>
									</div>
								</div>
								
								
								<div class="row">
             <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Reponse Date<sup class="text-red">&lowast;</sup></label>
                  <input type="text" class="form-control" name="reponse_date" id="reponse_date" autocomplete="none" placeholder=""  value="<fmt:formatDate pattern = "dd-MM-yyyy" value = "${ProjectSupportTicket.reponse_date}" /> ">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Reported Week<sup class="text-red">&lowast;</sup></label>
                  <input type="text" class="form-control" name="reported_week" id="reported_week" placeholder="" value="${ProjectSupportTicket.reported_week}">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Reported Month<sup class="text-red">&lowast;</sup></label>
<%--                   <input type="text" class="form-control" name="reported_month" id="reported_month" autocomplete="none" placeholder="" value="<fmt:formatDate pattern = "dd-MM-yyyy" value = "${ProjectSupportTicket.reported_month}" /> "> --%>
               <select class="form-control" name="reported_month" id="reported_month" >
                <option value="${ProjectSupportTicket.reported_month}">${ProjectSupportTicket.reported_month}</option>
                <option value="April">April</option>
                   <option value="May">May</option>
                   <option value="June" >June</option>
                    <option value="July">July</option>
                    <option value="August">August</option>
                    <option value="September">September</option>
                   <option value="October">October</option>
                   <option value="November">November</option>
                   <option value="December">December</option>
                    <option value="January" >January</option>
                    <option value="February">February</option>
                    <option value="March">March</option>
                    
                  </select> 
               
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Incident  Week</label>
                  <input type="text" class="form-control" name="incident_week" id="incident_week" autocomplete="none" placeholder="" value="${ProjectSupportTicket.incident_week}">
                </div>
              </div>
                </div>
                
                      <div class="row">
             
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Primary Responsible Department<sup class="text-red">&lowast;</sup></label>
                  <input type="text" class="form-control" name="primary_resp_department" id="primary_resp_department" placeholder="" value="${ProjectSupportTicket.primary_resp_department}">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Technical/User</label>
                  <input type="text" class="form-control" name="technical_user" id="technical_user" placeholder="" value="${ProjectSupportTicket.technical_user}">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Concerned 1</label>
                  <input type="text" class="form-control" name="concerned_1" id="concerned_1" placeholder="" value="${ProjectSupportTicket.concerned_1}">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Concerned 2</label>
                  <input type="text" class="form-control" name="concerned_2" id="concerned_2" placeholder="" value="${ProjectSupportTicket.concerned_2}">
                </div>
              </div>
                </div>
                
                <div class="row">
             
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >DOJ-1</label>
                 <input type="text" class="form-control" name="doj_1" id="doj_1" autocomplete="none" placeholder="" value="<fmt:formatDate pattern = "dd-MM-yyyy" value = "${ProjectSupportTicket.doj_1}" /> ">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >DOJ-2</label>
                <input type="text" class="form-control" name="doj_2" id="doj_2" autocomplete="none" placeholder="" value="<fmt:formatDate pattern = "dd-MM-yyyy" value = "${ProjectSupportTicket.doj_2}" /> ">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Technical Implementation</label>
                  <input type="text" class="form-control" name="technical_implementation" id="technical_implementation" autocomplete="none" placeholder="" value="${ProjectSupportTicket.technical_implementation}">
                </div>
              </div>
             
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Error Source</label>
                  <input type="text" class="form-control" name="error_source" id="error_source" placeholder="" value="${ProjectSupportTicket.error_source}">
                </div>
              </div>
                </div>
                
                <div class="row">
                 
              <div class="col-md-6">
                <div class="form-group">
                  <label for="CompanyAddress" >Internal Error Category</label>
                  <input type="text" class="form-control" name="internal_error_category" id="internal_error_category" placeholder="" value="${ProjectSupportTicket.internal_error_category}">
                </div>
              </div>
               <div class="col-md-6">
                <div class="form-group">
                  <label for="CompanyAddress" >Internal Learning</label>
                  <input type="text" class="form-control" name="internal_learning" id="internal_learning" autocomplete="none" placeholder="" value="${ProjectSupportTicket.internal_learning}">
                </div>
              </div>
                </div>
                
								
								
								
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="CompanyAddress">Error Description/Enhancement<sup class="text-red">&lowast;</sup> </label>
											<textarea class="form-control" id="ticket_desc"
												name="ticket_desc" placeholder="" required="required"
												rows="4">${ProjectSupportTicket.ticket_desc}</textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<label for="CompanyAddress">Error Code/Enhancement<sup class="text-red">&lowast;</sup> </label> <input
												type="text" class="form-control" name="error_code"
												id="error_code" placeholder="" value="${ProjectSupportTicket.error_code}">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="CompanyAddress">Error Type/Enhancement <sup class="text-red">&lowast;</sup></label> <input
												type="text" class="form-control" name="error_type"
												id="error_type" placeholder="" value="${ProjectSupportTicket.error_type}">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="CompanyAddress">Stage<sup class="text-red">&lowast;</sup></label> <input type="text"
												class="form-control" name="stage" id="stage" placeholder="" value="${ProjectSupportTicket.stage}">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="CompanyAddress">Repetitive Feedback<sup class="text-red">&lowast;</sup></label> <select
												class="form-control" name="repetitive_feedback"
												id="repetitive_feedback" required>
												<option value="${ProjectSupportTicket.repetitive_feedback}">${ProjectSupportTicket.repetitive_feedback}</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="CompanyAddress">Description of the root
												cause<sup class="text-red">&lowast;</sup></label>
											<textarea class="form-control"
												id="description_of_the_root_cause"
												name="description_of_the_root_cause" placeholder="" readonly
												required="required" rows="4">${ProjectSupportTicket.description_of_the_root_cause}</textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="CompanyAddress">Corrective action<sup class="text-red">&lowast;</sup></label> <input
												type="text" class="form-control" name="corrective_action" readonly
												id="corrective_action" placeholder="" value="${ProjectSupportTicket.corrective_action}">
										</div>
									</div>
									  <div class="col-md-2">
			                <div class="form-group">
			                  <label for="CompanyAddress" >Revised RCA</label></div></div>
			                   <div class="col-md-2">
			                <div class="form-group">

							 
								  <input type="radio" name="revised_RCA" value="Yes" ${ProjectSupportTicket.revised_RCA == 'Yes' ? 'checked' : ''}>Yes
								 </div></div>
								 <div class="col-md-2">
			                <div class="form-group">
								<input type="radio" name="revised_RCA" value="No" ${ProjectSupportTicket.revised_RCA == 'No' ? 'checked' : ''}>No
								
			                </div>
			              </div>
								</div>
								
								<div class="row">
										<div class="col-md-12">
										 <div class="form-group">
											<label for="CompanyAddress">Revised RCA Description</label> 
											<textarea class="form-control"
												id="revised_RCA_description" readonly
												name="revised_RCA_description" placeholder="" 
												required="required" rows="4">${ProjectSupportTicket.revised_RCA_description}</textarea>
										</div>
										</div></div>
             
								
								
								<div class="row">
								<div class="col-md-12">
										<div class="form-group">
											<label for="CompanyAddress">Preventive measures</label> 
											
											<textarea class="form-control"
												id="preventive_measures"
												name="preventive_measures" placeholder="" 
												required="required" readonly rows="4">${ProjectSupportTicket.preventive_measures}</textarea>
											
	
										</div>
									</div>
								</div>

								 <div class="row">
                 <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >CAPA Applicability</label>
                  <input type="text" class="form-control" name="capa_applicability" id="capa_applicability" readonly placeholder="">
                </div>
                </div>
             <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Technical Target Date</label>
                  <input type="text" class="form-control" name="technical_target_date" id="technical_target_date" readonly placeholder="">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Actual Technical Closing Date</label>
                  <input type="text" class="form-control" name="actual_technical_closing_date" id="actual_technical_closing_date" readonly placeholder="">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >UAT Status</label>
                  <input type="text" class="form-control" name="uat_status" id="uat_status" readonly placeholder="">
                </div>
              </div>
                </div>
                <div class="row">
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >UAT Done Date</label>
                  <input type="text" class="form-control" name="uat_done_date" id="uat_done_date" readonly  placeholder="">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Technical CAPA Implementor (Developer)</label>
                  <input type="text" class="form-control" name="technical_capa_implementor" id="technical_capa_implementor" readonly placeholder="">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >CAPA Implementation Date</label>
                  <input type="text" class="form-control" name="capa_implementation_date" id="capa_implementation_date" readonly placeholder="">
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="CompanyAddress" >Impacted Application</label>
                  <input type="text" class="form-control" name="impacted_application" id="impacted_application"  readonly placeholder="">
                </div>
              </div>
                </div>
            
            <div class="row">
              <div class="col-md-12">
                <div class="form-group">
                  <label for="CompanyAddress" >Remarks</label>
                  <textarea class="form-control" id="remarks" name="remarks" placeholder="" required="required"  readonly rows="4"></textarea>
                </div>
              </div>
              </div>
              
              <div class="row">
              <div class="col-md-4">
										<div class="form-group">
											<label for="CompanyAddress">Workflow<sup class="text-red">&lowast;</sup></label> 
												 <select class="form-control" name="workflow" id="workflow" >
						                <option value="${ProjectSupportTicket.workflow}">${ProjectSupportTicket.workflow}</option>
						                <option value="Conventional">Conventional</option>
						                   <option value="Lemans">Lemans</option>
						                   <option value="Lemans-CPC" >Lemans-CPC</option>
						                    
						                  </select> 
										</div>
									</div>
              
              <div class="col-md-4">
                <div class="form-group">
                  <label for="CompanyAddress" >Assigned To</label>
				 <form:select path="teamUsers" name="assigned_to_sqaTeam"
												id="assigned_to_sqaTeam" class="form-control">
												<form:option value="${ProjectSupportTicket.assigned_to_sqaTeam}"
													labelValue="" />
												<form:options items="${teamUsers}"
													itemValue="team_member_name" itemLabel="team_member_name" />
											</form:select>
                  
                </div>
              </div>
              </div>


								<div class="btn_box">
								    <a class="btn btn-dark btn-right" href="#" onclick="ProductionDashboard()"  style="float: right !important;">Cancel</a>
									<a class="btn btn-primary btn-right" href="#" onclick="saveProduction()"  style="float: right !important;margin-right: 5px;">Save</a>
								</div>
						
								
							</form>

						</div>


					</div>
				</div>
			</div>
		</div>

		<%-- <jsp:include page="footer.jsp" /> --%>
<%@ include file="/WEB-INF/includes/footer.jsp" %>
		</div>
		<!--Main_part_end-->

		<!--History_Modle-->
		<div class="modal fade bd-example-modal-lg" id="ActionModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Action Description History</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
       <div class="row">
            <div class="col-md-12">
             
                <ul class="timeline">
                <c:forEach var="temp" items="${ProjectSupportTicketList}" varStatus="counter">
                    <li>
                        <span class="dateSpan"><fmt:formatDate pattern="dd-MM-yyyy" value="${temp.created_on}" /></span>
                        <p class="m-0">${temp.action_desc}</p>
                    </li>
                    </c:forEach>
                </ul>
                
            </div>
        </div>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>



<div class="modal fade bd-example-modal-lg" id="ResolutionModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Resolution Description History</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
       <div class="row">
            <div class="col-md-12">
             
                <ul class="timeline">
                <c:forEach var="temp" items="${ProjectSupportTicketList}" varStatus="counter">
                    <li>
                        <span class="dateSpan"><fmt:formatDate pattern="dd-MM-yyyy" value="${temp.created_on}" /></span>
                        <p class="m-0">${temp.resolution_desc}</p>
                    </li>
                    </c:forEach>
                </ul>
                
            </div>
        </div>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
		<!--History_Modle-->
		<!--Main_part_end-->

		<!-- /.container -->

		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<!--<script src="js/jquery-3.3.1.slim.min.js"></script>-->
		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/popper.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<!--Bootstrap 4 DatePicker-->
		<script src="js/date-picker/gijgo.js"></script>
		<script src="<%=request.getContextPath()%>/js/datatables.min.js"></script>

		<!--Bootstrap 4 DatePicker-->
		<script>

$( document ).ready(function() {
	  $('#Billabletable').DataTable();
});

	$('#report_date').datepicker({
		uiLibrary: 'bootstrap4',
		iconsLibrary: 'fontawesome',
			format: 'dd-mm-yyyy'
	});
	
	$('#incident_date').datepicker({
		uiLibrary: 'bootstrap4',
		iconsLibrary: 'fontawesome',
			format: 'dd-mm-yyyy'
	});
	$('#technical_target_date').datepicker({
		uiLibrary: 'bootstrap4',
		iconsLibrary: 'fontawesome',
		format: 'dd-mm-yyyy'
	});
	$('#actual_technical_closing_date').datepicker({
		uiLibrary: 'bootstrap4',
		iconsLibrary: 'fontawesome',
		format: 'dd-mm-yyyy'
	});
	$('#uat_done_date').datepicker({
		uiLibrary: 'bootstrap4',
		iconsLibrary: 'fontawesome',
		format: 'dd-mm-yyyy'
	});
	$('#capa_implementation_date').datepicker({
		uiLibrary: 'bootstrap4',
		iconsLibrary: 'fontawesome',
		format: 'dd-mm-yyyy'
	});
	$('#reponse_date').datepicker({
		uiLibrary: 'bootstrap4',
		iconsLibrary: 'fontawesome',
		format: 'dd-mm-yyyy'
	});
	
	$('#doj_1').datepicker({
		uiLibrary: 'bootstrap4',
		iconsLibrary: 'fontawesome',
		format: 'dd-mm-yyyy'
	});
	$('#doj_2').datepicker({
		uiLibrary: 'bootstrap4',
		iconsLibrary: 'fontawesome',
		format: 'dd-mm-yyyy'
	});
</script>
		<!-- custom scrollbar plugin -->

		<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
		<script type="text/javascript">
	$(document).ready(function () {
		$("#sidebar").mCustomScrollbar({
			theme: "dark"
		});

		$('#sidebarCollapse').on('click', function () {
			$('#sidebar, #content').toggleClass('active');
			$('.collapse.in').toggleClass('in');
			$('a[aria-expanded=true]').attr('aria-expanded', 'true');
		});
	});
	
	$(document).ready(function () {
			

			$('#sidebarCollapse').html(function () {
				$(this).toggleClass('fa fa-angle-left');
			});
			
			$('#sidebarCollapse').click(function () {
					$(this).toggleClass('fa fa-angle-right');
				});
				
				
			$('#sidebarCollapse').click(function () {
				$(this).toggleClass('fa fa-angle-left');
			});
	});

	 function validate(){
			
			var project_name=document.getElementById("project_name").value;
			var ticket_type_cd=document.getElementById("ticket_type_cd").value;
			var application_name=document.getElementById("application_name").value;
			var prioitty=document.getElementById("prioitty").value;
			var ticket_status_cd=document.getElementById("ticket_status_cd").value;
			var client_name=document.getElementById("client_name").value;
			var journal_id=document.getElementById("journal_id").value;
			var aid=document.getElementById("aid").value;
			var tx_pa_no=document.getElementById("tx_pa_no").value;
			var location=document.getElementById("location").value;
			var site=document.getElementById("site").value;
			var report_date=document.getElementById("report_date").value;
			var reponse_date=document.getElementById("reponse_date").value;
			var reported_week=document.getElementById("reported_week").value;
			var reported_month=document.getElementById("reported_month").value;
			var primary_resp_department=document.getElementById("primary_resp_department").value;
			var ticket_desc=document.getElementById("ticket_desc").value;
			var error_code=document.getElementById("error_code").value;
			var error_type=document.getElementById("error_type").value;
			var stage=document.getElementById("stage").value;
			var repetitive_feedback=document.getElementById("repetitive_feedback").value;
		//	var remarks=document.getElementById("remarks").value;
			

			if(project_name==''){
				alert("Project Name cannot be blank.");
				return false;
			}
			if(ticket_type_cd==''){
				alert("Ticket Type cannot be blank.");
				return false;
			}
			if(application_name=='Please Select'){
				alert("Application Name cannot be blank.");
				return false;
			}
			if(prioitty==''){
				alert("Priority Date cannot be blank.");
				return false;
			}

			if(ticket_status_cd=='Please Select'){
				alert("Ticket Status cannot be blank.");
				return false;
			}
			if(client_name==''){
				alert("Client Name cannot be blank.");
				return false;
			}
			
			if(journal_id==''){
				alert("Journal ID/Chapter ID/Unique ID cannot be blank.");
				return false;
			}
			if(aid==''){
				alert("AID cannot be blank.");
				return false;
			}

			if(tx_pa_no==''){
				alert("TX/PA No. cannot be blank.");
				return false;
			}
			if(location==''){
				alert("Location cannot be blank.");
				return false;
			}
			if(site==''){
				alert("Site cannot be blank.");
				return false;
			}
			if(report_date==''){
				alert("Report Date cannot be blank.");
				return false;
			}
			if(reported_week==''){
				alert("Reported Week cannot be blank.");
				return false;
			}
			if(reported_month==''){
				alert("Reported Month cannot be blank.");
				return false;
			}

			 if(primary_resp_department==''){
				alert("Primary Responsible Department cannot be blank.");
				return false;
			} 
			
				if(ticket_desc==''){
					alert("Error Description/Enhancement cannot be blank.");
					return false;
				}
				if(error_code==''){
					alert("Error Code/Enhancement cannot be blank.");
					return false;
				}
				if(error_type==''){
					alert("Error Type/Enhancement cannot be blank.");
					return false;
				}
				if(stage==''){
					alert("Stage cannot be blank.");
					return false;
				}
				if(repetitive_feedback==''){
					alert("Repetitive Feedback cannot be blank.");
					return false;
				}
				
				
				
			return true;
		}

// 	function saveProduction(){
// 		if(validate()){
// 		//document.getElementById("support_ticket_id").value=proId
// 			document.getElementById("production").action="updateTicketProduction";
// 		    document.getElementById("production").method="POST";
// 			document.getElementById("production").submit();
// 		}
// 	}


// 	function ProductionDashboard(){
// 		document.getElementById("production").action="production-Dashboard";
// 	    document.getElementById("production").method="POST";
// 		document.getElementById("production").submit();
// 	}


	function saveProduction() {
		if(validate()){
				if (document.getElementById("flag").value == 1){
		
					document.getElementById("production").action = "updateTicketProduction";
					document.getElementById("production").method = "POST";
					document.getElementById("production").submit();
		
				}else{
					document.getElementById("production").action = "updateForwadedTicket";
					document.getElementById("production").method = "POST";
					document.getElementById("production").submit();
				}
		}
	}


	function ProductionDashboard() {
		
				if (document.getElementById("flag").value == 1){
		
					document.getElementById("production").action = "production-Dashboard";
					document.getElementById("production").method = "POST";
					document.getElementById("production").submit();
		
				}else{
					document.getElementById("production").action = "sqaManager_dashboard";
					document.getElementById("production").method = "POST";
					document.getElementById("production").submit();
				}
	
	}

	
</script>
		<script type="text/javascript"
			src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
    google.charts.load("current", {packages:["timeline"]});
    google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var container = document.getElementById('timeline');
        var chart = new google.visualization.Timeline(container);
        var dataTable = new google.visualization.DataTable();
        var options = {
      	      timeline: { colorByRowLabel: true },
      	      backgroundColor: '#ffd'
      	    };

        dataTable.addColumn({ type: 'string', id: 'Milestone' });
        dataTable.addColumn({ type: 'date', id: 'Start' });
        dataTable.addColumn({ type: 'date', id: 'End' });
        dataTable.addRows([
        	  <c:forEach items="${salesLeadMilestoneList}" var="entry">
		        ['${entry.moduleName}', new Date(${entry.startyear},${entry.startmonth},${entry.startdate}) , new Date(${entry.endyear},${entry.endmonth},${entry.enddate})],
		    </c:forEach>
         ]);
       
        chart.draw(dataTable);
      }
    </script>
		<!--common-js-->
		<script src="js/common.js"></script>
		<script type="text/javascript">
function getteamName(){
	var projectId=document.getElementById("project_id").value;
	
	
    $.ajax({
		type : 'GET',
		url : '<%=request.getContextPath()%>/Project-team-List-' + projectId,
				
		success : function(data) {
			var teamlist = data.payload;
			$('#assigned_to_user').empty();
			teamlist.forEach(function(x, index){
				
				var str = '<option value="'+x.teamMemberName+'">'+x.teamMemberName+'</option>';
				$('#assigned_to_user').append(str);
				
			});
			
		},
	
		error : function() {
			alert("error while getting user list.");
		}
	});

}

function newReponse(){

	var reportdate=document.getElementById('report_date').value;
	var from = reportdate.split("-")
	var newdate = new Date(from[2], from[1] - 1, from[0])
	var day = newdate.getDay()
	
	if(day==3||day==4||day==5||day==6||day==7){
		newdate.setDate(newdate.getDate() + 4);
		}else{
			
			newdate.setDate(newdate.getDate() + 2);
			}

    var dd = newdate.getDate();
    var mm = newdate.getMonth() + 1;
    var y = newdate.getFullYear();

    var holiday = ["26-1-2019","4-3-2019","21-3-2019","17-4-2019","5-6-2019","15-8-2019","2-10-2019", "8-10-2019","26-10-2019","21-11-2019","25-12-2019"];

   //var startDate = new Date();
    var endDate = new Date(newdate.setDate(newdate.getDate() + 1));
    for (i = 0; i < holiday.length; i++) {
        var dd = endDate.getDate();
        var mm = endDate.getMonth() + 1; 
        var y = endDate.getFullYear();
        
        if ((dd + '-' + mm + '-' + y) === (holiday[i])) {
        	
            endDate = new Date(endDate.setDate(endDate.getDate() + 1));
           // var FormattedDate = endDate.getDate()+"-"+(endDate.getMonth() + 1) +"-"+endDate.getFullYear();
        }
    }

    
    var FormattedDate = endDate.getDate()+"-"+(endDate.getMonth() + 1) +"-"+endDate.getFullYear();
   // var someFormattedDate = dd + '-' + mm + '-' + y;
    $("#reponse_date").val(FormattedDate);
     $("#reported_week").val(newdate.getWeek());

     var month = new Array();
     month[0] = "January";
     month[1] = "February";
     month[2] = "March";
     month[3] = "April";
     month[4] = "May";
     month[5] = "June";
     month[6] = "July";
     month[7] = "August";
     month[8] = "September";
     month[9] = "October";
     month[10] = "November";
     month[11] = "December";


     var n = month[newdate.getMonth()];

     

     
     $("#reported_month").val(n);
	
	
	
}
 Date.prototype.getWeek = function (dowOffset) {

	dowOffset = typeof(dowOffset) == 'int' ? dowOffset : 0; //default dowOffset to zero
	var newYear = new Date(this.getFullYear(),0,1);
	var day = newYear.getDay() - dowOffset; //the day of week the year begins on
	day = (day >= 0 ? day : day + 7);
	var daynum = Math.floor((this.getTime() - newYear.getTime() - 
		       (this.getTimezoneOffset()-newYear.getTimezoneOffset())*60000)/86400000) + 1;
		  var weeknum;
		       //if the year starts before the middle of a week
		     if(day < 4) {
		           weeknum = Math.floor((daynum+day-1)/7) + 1;
		           if(weeknum > 52) {
		               nYear = new Date(this.getFullYear() + 1,0,1);
		               nday = nYear.getDay() - dowOffset;
		               nday = nday >= 0 ? nday : nday + 7;
		               /*if the next year starts before the middle of
		                 the week, it is week #1 of that year*/
		               weeknum = nday < 4 ? 1 : 53;
		           }
		       }
		       else {
		           weeknum = Math.floor((daynum+day-1)/7);
		       }
		       return weeknum;
		   };




</script>
<script>
$(':radio:not(:checked)').attr('disabled', true);
</script>
	</form>
</body>
</html>

