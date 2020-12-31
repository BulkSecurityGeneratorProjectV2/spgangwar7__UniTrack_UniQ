<%@page import="java.util.Date,java.util.Calendar,java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="images/favicon.ico">
<link href="<%=request.getContextPath()%>/css/datatables.min.css" rel="stylesheet">
<title>Production Ticket Details</title>

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
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|Poppins:300,400,500,600,700" rel="stylesheet">
<script type="text/javascript" src="https://www.google.com/jsapi"></script>

</head>

<body>
<form name="production" id="production">
<input type="hidden" value="${LoginId}" name="LoginId" id="LoginId"/>
  <input type="hidden"  value="${projectId}" name="projectId" id="projectId"/>
  
<!--  header-->
<div id="header">
  <nav class="navbar navbar-expand-md navbar-light bg-white fixed-top">
    <div class="container-fluid"> <a class="navbar-brand" href="#"><img src="images/logo.png" class="img-fluid" alt=""></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav ml-auto">
        
          
          <li class="nav-item"> <a class="nav-link" href="#" onclick="ProductionDashboard()">SQA AM Dashboard</a> </li>
        </ul>
      </div>
      <ul class="d-flex on_mobile">
        <li class="dropdown user-box">
            <a class="dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            	<img src="images/user2-160x160.jpg" class="user-image rounded-circle" alt="User Image">
                <span> ${name}</span>
            </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown01">          
          	<ul class="my_dropdown">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="images/user2-160x160.jpg" class="rounded-circle" alt="User Image">

                <p>
                 ${name}
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <div class="row">
                  <div class="col-12 text-center">
                   <!--  <a href="change_password.html">Change Password</a> -->
                  </div>
                </div>
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer clearfix">
                <div class="pull-left clearfix">
                  <!-- <a href="profile-page.html" class="remove_btn btn">Profile</a> -->
                </div>
                <div class="pull-right clearfix">
                  <a href="/unitouch/logout" class="remove_btn btn">Sign out</a>
                </div>
              </li>
            </ul>
          
          </div>
        </li>
      </ul>
    </div>
  </nav>
</div>



<!--  header--> 

<%--  <jsp:include page="sidebar.jsp"/> --%>

<input type="hidden" name="LoginId" value="${LoginId}">

<!--Main_part-->
<div class="main_part_outer" >
  <div class="container-fluid">
    <div class="row ">
      <div class="col-md-12 h-100">
       <div class="main_tittle">UF Technical Point List</div>
        <div class="bg-white h-100 main_box">
        <font color="Blue">${Message}</font>
     
     
     
     <div class="dropdown float-right">
               <a href="#" class="add_btn float-right ml-2 mt-1"  onclick="completedList(${LoginId})">Completed List</a>
                    <a href="#" class="add_btn float-right ml-2 mt-1"  onclick="createProduction(${LoginId})">Raise New Ticket</a>
                    </div>
     
               
                <!--box-header-end--> 
                <!--box-body-->
                </br>
                </br>
                </br>
                
				<div class="box-body p-0">
                <div style="overflow:auto;">
                  <table class="table table-striped m-0" style="min-width:1250px;" id="managerDashboardTable">
                    <thead class="table-head">
                      <tr>
                       <th width="50">S.No</th>
                       <th width="50">Action</th>
                       <th width="150">Project Name</th>
                       <th width="130">Assign To </th>
                        <th width="100">Ticket Type</th>
                        <th width="150">Application Name</th>
                        <th width="150">TX/PA No.</th>
                        <th width="100">Priority</th>
                        <th width="150">Ticket Status </th>
                        <th width="170">Client Name</th>
                      </tr>
                    </thead>
                    <tbody id="check_value">
                     <c:forEach var="temp" items="${ProjectSupportTicketList}" varStatus="counter">
                     
                      <tr>
                      <td>${counter.count}</td>
                      <td> 
                      <input type="hidden" name="flag" id="flag" value="${flag}">
                            <input type="hidden" name="support_ticket_id" id="support_ticket_id" value="${temp.support_ticket_id}">
                          <a href="#" onclick="editViewProduction(${temp.support_ticket_id})" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit Info"><i class="fa fa-edit edit-icon"></i></a>
 							<a href="#" onclick="sendtoApproval(${temp.support_ticket_id})" data-toggle="tooltip" data-placement="top" title="" data-original-title="Convert to Client"><i class="fa fa-mail-forward convert-icon"></i></a>
                       
                        <td>${temp.project_name}</td>
                        <td>${temp.assigned_to_sqaTeam}</td>
                        <td>${temp.ticket_type_cd}</td>
                         <td>${temp.application_name}</td>
                         <td>${temp.tx_pa_no}</td>
                        <td>${temp.prioitty}</td>
                        <td>${temp.ticket_status_cd}</td>
                        <td>${temp.client_name}</td>

                      </tr>
                      </c:forEach>
                    
                    </tbody>
                    </table>  
                 </div>
          </div>
</div>
              
             </div>
  
  </div>

</div>

  
  <div class="footer">
  	<div class="container-fluid">
  		Copyright © 2019 DigiScape. All rights reserved.
    </div>
  </div>
  
</div>
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js" ></script>

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js" ></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.flash.min.js" ></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js" ></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js" ></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js" ></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.html5.min.js" ></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.print.min.js" ></script>
<script>
$( document ).ready(function() {
	 var t = $('#managerDashboardTable').DataTable( {
		 	"dom": 'Bfrtip',
	        "columnDefs": [ {
	            "searchable": false,
	            "orderable": false,
	            "targets": 0
	        } ],
	        buttons: [
	            'copy', 'csv', 'excel', 'print'
	        ]
	    } );
	 
	    t.on( 'order.dt search.dt', function () {
	        t.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
	            cell.innerHTML = i+1;
	        } );
	    } ).draw();
});
</script>
<!--Bootstrap 4 DatePicker--> 

 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
<script>
	$('#A-S-datepicker').datepicker({

		uiLibrary: 'bootstrap4',
		iconsLibrary: 'fontawesome',
		format: 'yyyy-mm-dd'
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
	
	
	function createProduction(val){
		document.getElementById("LoginId").value=val
		document.getElementById("production").action="<%=request.getContextPath()%>/create-Production";
	    document.getElementById("production").method="POST";
		document.getElementById("production").submit();
	}
	function ProductionDashboard(){
		document.getElementById("production").action="production-Dashboard";
	    document.getElementById("production").method="POST";
		document.getElementById("production").submit();
	}
	function completedList(){
		document.getElementById("production").action="UAT-completed-List";
	    document.getElementById("production").method="POST";
		document.getElementById("production").submit();
	}
	
	function editViewProduction(val){
	    document.getElementById("support_ticket_id").value=val
		document.getElementById("production").action="<%=request.getContextPath()%>/editViewProduction";
	    document.getElementById("production").method="POST";
		document.getElementById("production").submit();
	}

	function sendtoApproval(val){

		if (confirm('Are you sure you send it for Approval?')) {
			  document.getElementById("support_ticket_id").value=val
				document.getElementById("production").action="<%=request.getContextPath()%>/sendtoApproval";
			    document.getElementById("production").method="POST";
				document.getElementById("production").submit();
		} else {
		    // Do nothing!
		}	
	}

</script> 

<!--common-js-->
<script src="js/common.js"></script>
</form>
</body>
</html>
