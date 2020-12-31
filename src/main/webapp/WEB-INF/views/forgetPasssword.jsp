<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">

<link href="${context}/resources/css/bootstrap.css" rel="stylesheet">

<link href="${context}/resources/css/font-awesome.min.css"
	rel="stylesheet">

<link href="${context}/resources/css/slick.css" rel="stylesheet">

<link href="${context}/resources/css/forgot.css" rel="stylesheet">

<link
	href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900|Roboto:100,300,400,500,700"
	rel="stylesheet">
<script>
	function showPassword() {
		var x = document.getElementById("repassword");
		var y = document.getElementById("password");
		if (x.type === "password" && y.type == "password") {
			x.type = "text";
			y.type = "text";
		} else {
			x.type = "password";
			y.type = "password";
		}
	}


/* 
	function validate() {
		$("#pasId").empty();
		$("#repasId").empty();
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
			//alert(password + "  " + repassword);
		if (password == '') {
			$("#pasId").append("Please enter the password").css("color", "red");
			//alert("Please Enter the password");
			return false;
		}
		if (repassword == '') {
			$("#pasId").append("Please enter Re-enter password").css("color",
					"red");
			//alert("Please Enter the RePassword");
			return false;
		}
		if (!(password == repassword)) {
			$("#pasId").append("Please enter the same password in both password fields").css("color",
			"red");
			return false;
		}
		return true;
	} */
	function validate() {
		$("#pasId").empty();
		$("#repasId").empty();
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
			//alert(password + "  " + repassword);
		if (password == '') {
			$("#pasId").append("Please Enter New Password").css("color", "red");
			//alert("Please Enter the password");
			return false;
		}
		if (repassword == '') {
			$("#repasId").append("Please Re-Enter New Password").css("color",
					"red");
			//alert("Please Enter the RePassword");
			return false;
		}
		if (!(password == repassword)) {
			$("#pasId").append("Please enter the same password in both Password fields").css("color",
			"red");
			return false;
		}
		return true;
	}
	function passwordValidate() {
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
		if (validate()) {
			document.getElementById("forgot").action = "validate";
			document.getElementById("forgot").method = "POST";
			document.getElementById("forgot").submit();
		}
	}
</script>


</head>
<body>
	<form id="forgot" name="forgot">

		<input type="hidden" value='${token}' name=token>
		<div class="main-bg clearfix">
			<div class="container">
				<div class="row bg-grey">
					<div class="col-sm-6">
						<div class="imgss">
							<img src="resources/images/img-frm.jpg" class="img-responsive">
						</div>
					</div>
					<div class="clear"></div>

					<div class="col-sm-6">

						<div class="frm-box">
							<div class="one">
								<h3>Forgot Your Password!!!</h3>

								<div class="form-group">
									<small id="pasId"></small> <input id="password" type="password"
										id="password" class=" form-control new "
										placeholder="Enter New password" name="password" required>
								</div>
								<div class="form-group">
									<small id="repasId"></small> <input id="repassword" class="form-control new" type="password"
										placeholder="Re-Enter New password" name="repassword" required>
								</div>
								<input type="checkbox" onclick="showPassword()"> 
								<span class=" text-s">Show Password</span>
								<button type="button" class="bnts-snd" onClick="passwordValidate()">Submit</button>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</form>
</body>

</html>
