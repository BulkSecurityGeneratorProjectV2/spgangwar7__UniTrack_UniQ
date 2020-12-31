<%@ include file="/WEB-INF/includes/include.jsp"%>
<body>
	<style>
</style>
	<script src="https://cdn.ckeditor.com/4.13.1/standard-all/ckeditor.js"></script>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100 justify-content-center">
			
				<form:form method="POST" action="${context}/updateEmailDetails"
					modelAttribute="emailTemp"> 
					<c:if test="${not empty message}">
						<div class="alert alert-${css} alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<strong> ${message}</strong>
						</div>
					</c:if>
					<div class="container-fluid ">
						<!--main_tittle-->
						<div class="row">
							<div class="col-md-12">
								<div class="main_tittle d-flex align-items-center">
									<label for="fname">
									<span class="mr-2"> Manage Email Templates</span></label> <span id="Date">Mon
										, 26 Aug 2019</span>
									<%-- <span ><a href="${context}/getEmailsDetails" class="btn btn-sm btn-outline-danger"><i class="fa fa-arrow-left"></i>Back To User</a></span> --%>
								</div>
							</div>
						</div>
						<!--main_tittle_End-->
						
						<div class="content_box">
							<div class="box-body">
										
								      <input type="hidden" name="tempId" id="id" value="${emailList.id}">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label for="exampleInputEmail1">Template Name</label> <input
													name="templateName" class="form-control"
													id="exampleInputEmail1" aria-describedby="emailHelp" value="${emailList.emailTempName}"
													 required>
												</div>
										
												<div class="form-group">
												<label for="exampleInputEmail1">Placeholder</label>
												<select class="form-control" id="placeHolderList">
												<c:forEach var="placeHolderList" items="${placeHolder}"	varStatus="counter">
												<option class="placeHolderClass">${placeHolderList.placeHoldername}</option>
												</c:forEach>
												</select>
												 <!-- <input
													name="toSubject" class="form-control" id="exampleInputEmail1"
													aria-describedby="emailHelp" placeholder="Select Place Holder"
													required> -->
												</div>
											
												<div class="form-group">
												<label for="exampleInputEmail1">Subject</label> <input
													name="toSubject" class="form-control" id="toSubject" value="${emailList.toSubject}"
													aria-describedby="emailHelp" placeholder="Enter Subject"
													required>
													</div>
											
												<div class="form-group">
												<label for="exampleInputEmail1" >Email Body</label>
			
												<textarea class="form-control" id="editor1" name="editorData"
													required>
														${emailList.editorData}
														</textarea>
			
												</div>
										    </div>
										  
								 <div class="col-md-4">

									<div class="form-group">
												<label for="exampleInputEmail1">Finish Subject</label> <input
													name="finishSubject" class="form-control" id="finishSubject" value="${emailList.finishSubject}"
													aria-describedby="emailHelp" placeholder="Enter Subject"
													required>
													</div>
											
												<div class="form-group">
												<label for="exampleInputEmail1" >Finish Email Body</label>
			
												<textarea class="form-control" id="finishBody" name="finishBody"
													required>
														${emailList.finishBody}
														</textarea>
												</div>
								</div>
										    
							     <div class="col-md-4">

									<div class="form-group">
												<label for="exampleInputEmail1">Reply Subject</label> <input
													name="replySubject" class="form-control" id="replySubject" value="${emailList.replySubject}"
													aria-describedby="emailHelp" placeholder="Enter Subject"
													required>
													</div>
											
												<div class="form-group">
												<label for="exampleInputEmail1" >Reply Email Body</label>
			
												<textarea class="form-control" id="replyBody" name="replyBody"
													required>
														${emailList.replyBody}
														</textarea>
												</div>
								   </div>		
											
										</div>
							</div>
							
							<div class="box-footer">
							    <a class="btn btn-outline-danger" href="${context}/getEmailsDetails"><i class="fa fa-close"></i> Cancel</a> &nbsp;
							    <%-- <a class="btn btn-danger" href="#" onclick="updateEmailDetails(${emailList.id})"><i class="fa fa-save"></i> Save</a> --%>
								<button type="submit" class=" btn btn-danger">Submit</button>
							</div>
							
						</div>
						
					</div>

		   </form:form>

				<!--   <textarea cols="80" id="editor1" name="editor1" rows="10" data-sample-short>&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href=&quot;https://ckeditor.com/&quot;&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;</textarea> -->
				<script>
					CKEDITOR
							.replace(
									'editorData',
									{
										// Define the toolbar groups as it is a more accessible solution.
										toolbarGroups : [ {
											"name" : "basicstyles",
											"groups" : [ "basicstyles" ]
										}, {
											"name" : "links",
											"groups" : [ "links" ]
										}, {
											"name" : "paragraph",
											"groups" : [ "list", "blocks" ]
										}, {
											"name" : "document",
											"groups" : [ "mode" ]
										}, {
											"name" : "insert",
											"groups" : [ "insert" ]
										}, {
											"name" : "styles",
											"groups" : [ "styles" ]
										}, {
											"name" : "about",
											"groups" : [ "about" ]
										} ],
										// Remove the redundant buttons from toolbar groups defined above.
										removeButtons : 'Underline,Strike,Subscript,Superscript,Anchor,Styles,Specialchar'
									});

					CKEDITOR
					.replace(
							'finishBody',
							{
								// Define the toolbar groups as it is a more accessible solution.
								toolbarGroups : [ {
									"name" : "basicstyles",
									"groups" : [ "basicstyles" ]
								}, {
									"name" : "links",
									"groups" : [ "links" ]
								}, {
									"name" : "paragraph",
									"groups" : [ "list", "blocks" ]
								}, {
									"name" : "document",
									"groups" : [ "mode" ]
								}, {
									"name" : "insert",
									"groups" : [ "insert" ]
								}, {
									"name" : "styles",
									"groups" : [ "styles" ]
								}, {
									"name" : "about",
									"groups" : [ "about" ]
								} ],
								height: "340px",
								
								// Remove the redundant buttons from toolbar groups defined above.
								removeButtons : 'Underline,Strike,Subscript,Superscript,Anchor,Styles,Specialchar'
							});

					CKEDITOR
					.replace(
							'replyBody',
							{
								// Define the toolbar groups as it is a more accessible solution.
								toolbarGroups : [ {
									"name" : "basicstyles",
									"groups" : [ "basicstyles" ]
								}, {
									"name" : "links",
									"groups" : [ "links" ]
								}, {
									"name" : "paragraph",
									"groups" : [ "list", "blocks" ]
								}, {
									"name" : "document",
									"groups" : [ "mode" ]
								}, {
									"name" : "insert",
									"groups" : [ "insert" ]
								}, {
									"name" : "styles",
									"groups" : [ "styles" ]
								}, {
									"name" : "about",
									"groups" : [ "about" ]
								} ],
								height: "340px",
								// Remove the redundant buttons from toolbar groups defined above.
								removeButtons : 'Underline,Strike,Subscript,Superscript,Anchor,Styles,Specialchar'
							});
					
					$( ".placeHolderClass" ).click(function() {
						var selectValue=  $("#placeHolderList").val();
					
						 $('#toSubject').val($('#toSubject').val() + selectValue);
						    myValue = selectValue.trim();
						    CKEDITOR.instances['editor1'].insertText(myValue);

						 $('#finishSubject').val($('#finishSubject').val() + selectValue);
						    myValue = selectValue.trim();
						    CKEDITOR.instances['finishBody'].insertText(myValue);

						 $('#replySubject').val($('#replySubject').val() + selectValue);
						    myValue = selectValue.trim();
						    CKEDITOR.instances['replyBody'].insertText(myValue);
					
// 						  var value=CKEDITOR.instances['editor1'].getData();
// 						  alert(value);
// 						 var totalData= CKEDITOR.instances['editor1'].setData(value+""+selectValue);
						});
				</script>
			</div>
		</div>
	</div>



</body>
<Script>
function updateEmailDetails(id) {
	if (validateEmail()) {
		if (confirm("Are you sure you want to update this email ?")) {
			document.getElementById("id").value = id;
			document.getElementById("emails").action = "updateEmailDetails";
			document.getElementById("emails").method = "POST";
			document.getElementById("emails").submit();
		}
	}
}


function validateEmail(){
	
	var emailName=document.getElementById("exampleInputEmail1").value;
	var toSubject=document.getElementById("toSubject").value;
	
		if (emailName == '') {
			alert("Template name cannot be blank.");
			return false;
		}
		
		if (toSubject == '') {
			alert("Subject cannot be blank.");
			return false;
		}
		return true;
	}

</Script>