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

<title>DigiTrack :: Login</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<!-- font-awesome -->
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<!--slick-slider-->
<link href="resources/css/slick.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="resources/css/login.css" rel="stylesheet">
<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900|Roboto:100,300,400,500,700"
	rel="stylesheet">
</head>

<body>

	<div class="login_outer">
		<div class="login_container">
			<div class="LeftSide_login">

				<form class="form-login" method="POST" id="formid">
					<div class="login_logo text-center d-block w-100">
						<!-- <img src="images/login_logo.png" alt="" > -->
						<!-- <img src="resources/images/digitrack.png"
							style="max-width: 230px; margin-bottom: 20px;" alt=""> -->
						<a
							class="logo" href="${context}/dashboard"><img
							src="resources/images/unitrack-logo.png" class="img-fluid"></a>
					</div>
					<!-- <div class="project_name mb-3">
                    	Submissions &amp;
                        <h3>P<span>ee</span>R Review</h3>
                        <p>Please login to your account</p>
                    </div> -->
					<!--Alert Box-->
					<div class="alert alert-danger alert-dismissible d-none">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">×</button>
						<i class="icon fa fa-ban"></i> <strong>Alert!</strong><br>
						Mail could not be sent to <strong>email id</strong> as the above
						email id is/are not available.
					</div>
					<!--Alert Box-->

					<!--User ID / Email ID-->


					<!--User ID / Email ID-->
					<div class="w-100">
						<c:if
							test="${not empty sessionScope.SPRING_SECURITY_LAST_EXCEPTION}">
							<div class="error">
								Your login attempt was not successful, try again.<br /> Reason:
								${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
							</div>
						</c:if>
						<div class="input-group mb-12">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa fa-user-o"></i></span>
							</div>
							 <input type="email" id="inputEmail" name="username" class="form-control" placeholder="User ID / Email ID" required>
							 
						</div>
						<div class="input-group mb-3 " style="margin-top: 24px;">
							<div class="input-group-prepend">
								<span class="input-group-text"><i
									class="fa fa-unlock-alt"></i></span>
							</div>
							 <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
						</div>
					</div>

					<div class="checkbox mb-4 w-100">
						<div class="custom-control custom-checkbox float-left">
							<input type="checkbox" class="custom-control-input" id="remember-me">
								<label class="custom-control-label"
								for="remember-me">Remember me</label>
						</div>
						<a class="pull-right" href="#" data-toggle="modal" data-target="#addtask"> Forgot Password?</a>
					</div>

					<div class="mb-3 d-block w-100">
						<div class="mb-3 d-block w-100">
							<button class="submit_btn" type="submit" onclick="submit()">Sign In</button>
							<span class="main_class">
								 
							</span>
						</div>
					</div>




					<div class="footer text-center">
						Copyright &copy; 2020 <a href="#">DigiScape</a> | All Rights
						Reserved.
					</div>
				</form>
			</div>

			<div class="login_bg7 ">

				<div class="login-slider-wrap flex-column d-flex h-100 mt-0 w-100">
					<div class="help_info w-100 d-block">
						<script type="text/javascript">
						var today = new Date();
						var dd = String(today.getDate()).padStart(2, '0');
						var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
						var yyyy = today.getFullYear();

						today = dd + '/' + mm + '/' + yyyy;
						document.write(today);

						</script> 
						<!-- <a href="#" class="white-border-btn ml-2">Help</a> -->
					</div>
					<div style="margin-top: 17%;">
						<ul class="slogin-slider-item">
							<li style="list-style: none;">
								<h2>
									UniTrack Intelligent Publishing Platform <br>
								</h2> <!-- <p class="mt-5">Customisable Solution specific to Publishers needs</p> -->
							</li>

						</ul>
					</div>
					<div
						class="footLogo text-white mt-auto text-right pr-3 py-2 bg-white border-top shadow-sm">
						<img src="resources/images/footerLogo.png" alt="">
					</div>
				</div>
			</div>


		</div>
	</div>
	<!-- Modal popup for create new task -->
<div class="modal fade" id="addtask" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Forgot Password</h5>
				 
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

<%-- 	<form:form method="POST" action="/forgotPassword" --%>
<%-- 			modelAttribute="Users" style="padding-top: 80px;"> --%>
			<form action="/forgotPassword" method="post" id=forgot>
				<div class="modal-body">
					 <div class="form-group">
					    <label for="username">Enter Email Id</label>
					    <input type="text" class="form-control" id="username"
						name="username" required placeholder="User ID / Email ID">
					  </div>
					  <button type="submit" class="btn btn-danger" onclick="forgotPassword()">Submit</button>
				</div>
			</form>


		</div>
	</div>
</div>
<!------End  popup for create new task------->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!--<script src="js/jquery-3.3.1.slim.min.js"></script>-->
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
		    	 $('#formid').submit();  
		    }
		  });

		});
	
    function submit() {
        $('#formid').submit();  
    }
    
	function forgotPassword() {

		document.getElementById("forgot").action = "forgotPassword";
		document.getElementById("forgot").method = "POST";
		document.getElementById("forgot").submit();
	}
    </script>
    

</body>
</html>