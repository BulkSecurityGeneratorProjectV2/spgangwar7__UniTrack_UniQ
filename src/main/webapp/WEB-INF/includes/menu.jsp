<div class="top-panel box-shadow">
	<!-- Static navbar -->

	<nav class="navbar navbar-expand-md p-0 d-flex">
		<!--menu_icon-->
		<button type="button" id="sidebarCollapse" class="sidebar-toggle">
			<i class="fa fa-bars"></i>
		</button>
		<!--menu_icon-->
		<c:set var="context" value="${pageContext.request.contextPath}" />
		<div class="navbar-header bg-blue text-center">
			<a class="logo" href="${context}/dashboard"><img
				src="resources/images/wolters-kluwer-login-logo-white.png" class="img-fluid"></a>
		</div>
		<!-- <span class="version">UniTouch 2.0</span> -->

		<!-- /.sb-search-->
		<div class="sb-search ml-auto">
			<!-- 			<a href="#search_modal" data-toggle="modal" data-backdrop="static"> -->
			<!-- 				<span class="sb-icon-search"><img -->
			<!-- 					src="resources/images/search_icon.png"> </span> -->
			<!-- 			</a> -->
		</div>
		<!-- /.sb-search-->

		<div class="user-wrap">
			<div class="dropdown my-dropdown pull-right w-100 ">
				<button class="user dropdown-toggle w-100" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
					<img src="resources/images/mail_user.jpg" class="img-responsive">
					<div class="user_name">
						Welcome
						<p>${name}</p>
					</div>
					<span class="caret"></span>
				</button>

				<ul class="dropdown-menu dropdown-menu-right"
					aria-labelledby="dropdownMenuButton">
					 <li><a href="#" data-toggle="modal" data-target="#updateprofile">Update
							Profile</a></li>
					<li><a href="#" data-toggle="modal" data-target="#changepass">Change
							Password</a></li>
					<li><a href="${context}/logout">Logout</a></li>
				</ul>
			</div>
			<!-- /.Dropdown -->
		</div>
	</nav>
</div>
<!--header ends here-->

<!--wrapper-->

<!-- Sidebar  -->
<nav id="sidebar" class="active">
	<div class="side_menu_header">Main Links</div>
	<ul class="list-unstyled components" id="sideMenu">
		<c:set var="count" value="" scope="page" />
		<c:forEach var="temp" items="${menu}" varStatus="counter">
			<c:if test="${temp.menuName != count}">
				<c:set var="count" value="${temp.menuName}" scope="page" />

				<li><a href=#${temp.uri} data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle"> <i
						class="fa  fa-arrow-circle-right"></i>${temp.menuName} <span
						class="fa pull-right fa-angle-down"></span>
				</a>
					<ul class="collapse list-unstyled" id=${temp.uri
						}
						data-parent="#sideMenu">
						<c:forEach var="tempsub" items="${menu}" varStatus="counter">
							<c:if test="${tempsub.menuName == count}">

								<li><a href=${tempsub.uri}>${tempsub.functionName}</a></li>
							</c:if>
						</c:forEach>


					</ul></li>
			</c:if>

		</c:forEach>

	</ul>

</nav>

<!-- Modal popup for create new task -->
<div class="modal fade" id="changepass" role="dialog">
	<div class="modal-dialog">
<small><b>${message}</b></small>
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Change Password</h5>

				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<%-- 	<form:form method="POST" action="/forgotPassword" --%>
			<%-- 			modelAttribute="Users" style="padding-top: 80px;"> --%>
			<form id=reset>
				<div class="modal-body">
					<div class="form-group">
						<label for="username">Current Password</label> <input
							type="password" class="form-control" id="oldpassword"
							name="password" required placeholder="Current password"> <label
							for="password">New Password</label> <input type="password"
							class="form-control" id="newpassword" name="newpassword" required
							placeholder="New password"> <label for="rePassword">Re-Enter New
							Password</label> <input type="password" class="form-control"
							id="confpassword" name="rePassword" required
							placeholder="Re-Enter New Password">
					</div>
					<button type="button" class="btn btn-danger"
						onClick="forgotPassword()">Submit</button>

				</div>
			</form>


		</div>
	</div>
</div>

 <div class="modal fade" id="updateprofile" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Update Profile</h5>

				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<form id="updateUsers" name="updateUsers">
				<div class="modal-body">
					<div class="form-group">
						<label for="currency">First Name</label> 
						<input	type="text" class="form-control" name="updateUserFname"
					     id="updateuserFname" placeholder="" autocomplete="off" value="${userinfo.firstName}" required>
						 
						 <label for="currency">Last Name</label>
							 <input type="text" class="form-control"
							name="updateLastName" id="updateLastName"
							placeholder="" autocomplete="off" value="${userinfo.lastName}"  required>
							
						 <label for="currency">User Email</label> 
							<input
							type="text" class="form-control" name="updateUserEmail" readonly
							id="updateUserEmail" placeholder="" autocomplete="off" value="${userinfo.username}"  required>
					</div>
					<button type="button" class="btn btn-danger"
						onClick="updateUserDetails()">Submit</button>

				</div>
			</form>


		</div>
	</div>
</div>
<script>
	function forgotPassword() {
		
		if (passwordVali()) {
			document.getElementById("reset").action = "reset";
			document.getElementById("reset").method = "POST";
			document.getElementById("reset").submit();

		}
	}
	
	function emptyField(){
		
		var newpassword = document.getElementById("newpassword").value;
		var confpassword = document.getElementById("confpassword").value;
		var n = confpassword.length;
		var oldpassword = document.getElementById("oldpassword").value;

		if (oldpassword == '') {
			alert("Current Password field can not be empty");
			return false;
		}
		if (newpassword == '') {
			alert("New Password field can not be empty");
			return false;
		}
		if (confpassword == '') {
			alert("Re-Enter New Password field can not be empty");
			return false;
		}
		
		return true;
	}
	
	
function passwordVali() {
		
		var newpassword = document.getElementById("newpassword").value;
		var confpassword = document.getElementById("confpassword").value;
		var n = confpassword.length;
		var oldpassword = document.getElementById("oldpassword").value;

		if (oldpassword == '') {
			alert("Current Password field can not be empty");
			return false;
		}
		if (newpassword == '') {
			alert("New Password field can not be empty");
			return false;
		}
		if (confpassword == '') {
			alert("Re-Enter New Password field can not be empty");
			return false;
		}
		if (emptyField()) {
			if (n <= 7) {
				alert("Password must be at least 8 characters");
				return false;
			}else if(newpassword != confpassword){
				alert("Password not match !!");
				document.getElementById("reset").reset();
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
	
// 	function passwordVali() {
		
// 		var newpassword = document.getElementById("newpassword").value;
// 		var confpassword = document.getElementById("confpassword").value;
// 		var n = confpassword.length;
// 		var oldpassword = document.getElementById("oldpassword").value;
// 		if (emptyField() && newpassword == confpassword) {
// 			if (n <= 7) {
// 				alert("Password must be at least 8 characters");
// 				return false;
// 			}
// 			return true;
// 		} else {
// 			return false;
// 		}
// 	}

	function updateUserDetails() {
	 	if(validate()){ 
				document.getElementById("updateUsers").action = "updateUser";
				document.getElementById("updateUsers").method = "POST";
				document.getElementById("updateUsers").submit();

} 
	}
	
	function validate() {

		var FirstName = document.getElementById("updateuserFname").value;
		var LastName = document.getElementById("updateLastName").value;
	
		
		if (FirstName== '') {
			alert("First name cannot be blank.");
			return false;
		}
		if (!/^[a-zA-Z ]*$/g.test(FirstName)) {
			alert("Invalid characters");
			$("#updateuserFname").css("color", "red");
			return false;
		}
		if (LastName == '') {
			alert("Last name cannot be blank.");
			return false;
		}
		if (!/^[a-zA-Z ]*$/g.test(LastName)) {
			alert("Invalid characters");
			$("#updateLastName").css("color", "red");
			return false;
		}

	
		return true;
		
	}	
</script>
<!------End  popup for create new task------->
