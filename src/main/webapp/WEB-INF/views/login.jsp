<!doctype html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="resources/images/favicon.ico">

<title>UNI Touch :: Login</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<!-- font-awesome -->
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<!--slick-slider-->
<link href="resources/css/slick.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="resources/css/latest-login.css" rel="stylesheet">
<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900|Roboto:100,300,400,500,700"
	rel="stylesheet">
</head>

<script>
</script>

<body>
		<div class="login_outer">
	    	<!--login_header-->
	    	<div class="navbar-header login_header bg-blue text-center">
			<span class="logo" ><img
				src="resources/images/wolters-kluwer-login-logo-white.png" class="img-fluid"></span>
		</div>
	    	<!-- <div class="login_header d-flex p-2 align-items-center">
	        	<span class="logo pl-3"><img src="resources/images/wolters-kluwer-login-logo-white.png" class="img-fluid" ></span>wolters-kluwer-logo.png  
	            <span class="ml-auto arrow_box bg-white p-2 rounded-right"><img src="resources/images/medknowLo.png" class="img-fluid"></span>
	        </div> -->
	        <!--login_header_end-->
	        <!--login_body-->
	        <div class="login_body">
	        	<form class="form-login" method="POST" id="formid">
	        			<h2 class="w-100 mb-2">Journal Management</h2>
	                    <p>Please login to your account</p>
	                    
	                     <!--Alert Box-->
                    		<c:if test="${not empty message}">
								<div class="alert alert-${css} alert-dismissible"
									role="alert">
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<strong> ${message}</strong>
								</div>
							</c:if>
							<c:if
								test="${not empty sessionScope.SPRING_SECURITY_LAST_EXCEPTION}">
								<div class="error text-danger" style="margin-bottom:10px; display: inline-block;">
									Your login attempt was not successful, try again.<br />
								
									${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
								</div>
							</c:if>
						<!--Alert Box-->
<%-- 							<span class="text-danger" style="margin-bottom:10px; display: inline-block;">${errorMessge}</span> --%>

								

								

								
	                    
	                    <!--User ID / Email ID-->	                    
	                    <div class="input-group mb-3">
	                        <div class="input-group-prepend">
	                          <span class="input-group-text"><i class="fa fa-pencil"></i></span>
	                        </div>
	                        <input type="email" id="inputEmail" name="username" class="form-control" placeholder="User ID / Email ID" required>
	                        <span class="error-star">*</span>
	                      </div>
	                    <!--User ID / Email ID-->
	                    
	                    <!--Password-->
	                    <div class="input-group mb-3">
	                        <div class="input-group-prepend">
	                          <span class="input-group-text"><i class="fa fa-unlock-alt"></i></span>
	                        </div>
	                       <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
	                       <span class="error-star">*</span>
	                      </div>
	                    <!--Password-->
	                    
	                    <div class="checkbox mb-4 w-100">
	                    <div class="custom-control custom-checkbox d-inline">
	                      <input type="checkbox" class="custom-control-input" id="remember-me">
	                      <label class="custom-control-label" for="remember-me">Remember me</label>
	                    </div>
	                   
	                    <a class="pull-right" href="#" data-toggle="modal" data-target="#addtask"> Forgot Password?</a>
	                    </div>
	                    
	                    <div class="d-block"><a href="#" class="submit_btn" onclick="submit()">Login</a></div>
	                  
	                </form>
	        </div>
	        <!--login_body_end-->
	        <!--login_footer-->
	        <div class="login_footer">
	        	<div class="text-center mb-1">©Copyright 2020 Unitouch | All Rights Reserved.</div>
	        	<div class="text-center">
	        		<a href="https://www.wolterskluwer.com" target='_blank'>www.wolterskluwer.com</a>  <span>|</span> 
	        		<a href="http://www.medknow.com" target='_blank'>www.medknow.com</a>  
	        		
	        	</div>
	        	
				<div class="container-fluid" style=" margin-top: 10px;">
					<div class="row">
						<div class="col-md-4">
							Need Help?
							<!-- <span class="ml-3 font-weight-medium"><img src="resources/images/icon/phone.png"> +91-120-4511500 </span> -->
							<a class="ml-3 font-weight-medium text-left"><img
								src="resources/images/icon/mail.png">
								info@digiscapetech.com </a>
						</div>
						<div class="col-md-4 text-center">
							 <a href="http://unitouch.digiscapetech.com/login"><img style="height: 50px; padding-left: 38px; "
								src="resources/images/uni-proff-logo.png"></a>
						</div>
						<div class="col-md-4 text-right">
							Powered by: <a href="https://www.digiscapetech.com/" target='_blank'><img
								src="resources/images/footer-digi-logo.png"></a>
						</div>
					</div>
					</div>
	        </div>
	        <!--login_footer_end-->
	    </div>

	<script src="resources/js/jquery-3.4.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>


	<script>

	$(function() {

		  $('#inputPassword').keypress(function(e) {
		    var key = e.which;
		    if (key == 13) // the enter key code
		    {
		    	if(valida()){
		    	document.getElementById("formid").action = "login";
				document.getElementById("formid").method = "POST";
				document.getElementById("formid").submit();
		    	// $('#formid').submit();  
		    	}
		    }
		  });

		});

		function valida() {
			var username = document.getElementById("inputEmail").value;
			var password = document.getElementById("inputPassword").value;
			var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			if (username == '') {
				alert("Email cannot be blank.");
				return false;
			}
			if (!username.match(mailformat)) {
				alert("Enter valid email Format");

				return false;
			}
			if (password == '') {
				alert("Password cannot be blank.");
				return false;
			}
			return true;
		}

		function submit() {

			if (valida()) {
				document.getElementById("formid").action = "login";
				document.getElementById("formid").method = "POST";
				document.getElementById("formid").submit();
				//$('#formid').submit();
			}
		}

		function validEmail(){
			$("#efId").empty();
			var username = document.getElementById("username").value;
			var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			if (username=='') {
				$("#efId").append("Please enter email id").css("color", "red");
				return false;
			}
			if (!username.match(mailformat)) {
				$("#efId").append("Please enter the valid email format").css("color", "red");
				return false;
			}
			return true;
		}
		function forgotPassword() {
		if(validEmail()){
			document.getElementById("forgot").action = "forgotPassword";
			document.getElementById("forgot").method = "POST";
			document.getElementById("forgot").submit();
		}
		}
	</script>

	<!-- Modal popup -->
	<div class="modal fade" id="addtask" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Forgot Password</h5>

					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<%-- 	<form:form method="POST" action="/forgotPassword" --%>
				<%-- 			modelAttribute="Users" style="padding-top: 80px;"> --%>
				<form  id=forgot>
					<div class="modal-body">
						<div class="form-group">
							<label for="username">Enter Email Id &nbsp;<sup style="color:red;">&lowast;</sup></label><br> <small id="efId"></small><input type="text"
								class="form-control" id="username" name="username" required
								placeholder="User ID / Email ID">
						</div>
						<button type="button" class="submit_btn"
							onclick="forgotPassword()">Submit</button>
					</div>
				</form>


			</div>
		</div>
	</div>
	<!------End  popup for ------->

</body>

</html>
