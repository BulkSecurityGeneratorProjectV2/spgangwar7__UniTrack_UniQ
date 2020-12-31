

<%@ include file="/WEB-INF/includes/footer.jsp"%>



<head>


<!--Bootstrap-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 
<!--Google font-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900|Roboto:100,300,400,500,700" rel="stylesheet"> 
<style>
html,body{height:100%;}
	body{sbackground:#B90000;}
	
	
.myButton {
	box-shadow: 3px 4px 0px 0px #8a2a21;
	background:linear-gradient(to bottom, #c62d1f 5%, #f24437 100%);
	background-color:#c62d1f;
	border-radius:18px;
	border:1px solid #d02718;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:17px;
	padding:7px 25px;
	text-decoration:none;
	text-shadow:0px 1px 0px #810e05;
	position:relative;top:0;
	transition:0.5s all;
}
.myButton:hover {
	background:linear-gradient(to bottom, #f24437 5%, #c62d1f 100%);
	background-color:#f24437;
	color:#fff;
	top:-3px;
	text-decoration:none;
}
.myButton:active {
	position:relative;
	top:1px;
}
</style>
</head>
<%-- 	<input type="hidden" name="article_task_id" id="article_task_id" value="${article_task_id}">  --%>
<body class="d-flex flex-column">
	<form id="groupTask" name="groupTask">
<div class="h-100 text-center d-flex w-100">
	<div class="align-self-center w-100"><img src="resources/images/uni-logo.png"  class="border p-1 shadow rounded">
		<h5 class="mt-5" style="line-height:36px;color:#333;">Intelligent Publishing Platform <br>powered by Artificial Intelligence & Machine Language</h5>
		<a href="#" class="myButton mt-4"  id="article_task_id" onclick="StartMYTask(${article_task_id})">Click Here</a>
		
	</div>
</div>
<div class="bg-white mt-auto p-3">
<div class="d-flex align-items-center">
	<div>
		
	</div>
	<div class="ml-auto">
		<img src="resources/images/digi-logo.png">
	</div>
</div>
</div>


<script type="text/javascript">
function StartMYTask(val) {
	//alert(val);
	document.getElementById("article_task_id").value = val;
	document.getElementById("groupTask").action = "view-groupTask";
	document.getElementById("groupTask").method = "POST";
	document.getElementById("groupTask").submit();
}
</script>
</form>
</body>