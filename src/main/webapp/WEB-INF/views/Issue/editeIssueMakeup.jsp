 <%@ include file="/WEB-INF/includes/include.jsp"%> 
<style>
table {
	counter-reset: tableCount;
}

.counterCell:before {
	content: counter(tableCount);
	counter-increment: tableCount;
}
.shorting-icon {
	position: absolute;
	right: 10px;
	cursor: pointer;oderingPage
}
</style>
<style>
/* Center the loader */
#loader {
  position: absolute;
  left: 50%;
  top: 50%;
  z-index: 1;
  width: 150px;
  height: 150px;
  margin: -75px 0 0 -75px;
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 1s linear infinite;
  animation: spin 2s linear infinite;
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

/* Add animation to "page content" */
.animate-bottom {
  position: relative;
  -webkit-animation-name: animatebottom;
  -webkit-animation-duration: 1s;
  animation-name: animatebottom;
  animation-duration: 1s
}

@-webkit-keyframes animatebottom {
  from { bottom:-100px; opacity:0 } 
  to { bottom:0px; opacity:1 }
}

@keyframes animatebottom { 
  from{ bottom:-100px; opacity:0 } 
  to{ bottom:0; opacity:1 }
}
</style>
 
 <head>


    
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
   
    
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
 
   <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
 
  
</head> 
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pure/1.0.1/pure-min.css"> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script> 
<!-- <script src="mindmup-editabletable.js"></script> -->
<link href="resources/css/my_style.css" rel="stylesheet">

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- <script src="resources/static/js/SimpleTableCellEditor.es6.min.js"></script> -->


<div class="wrapper" >
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid" id="mainhide">
				<!--main_tittle-->
				<c:if test="${not empty message}"> 
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>  ${message}</strong>
					</div>
				</c:if>

				<c:if test="${issueData ne null}">
					<div class=" alert-info">
						<div class="row">
							<div class="col-sm-6 col-md-6">
								<div class="form-group col">
									<label class="art-left"><spring:message code="book.journal" /> Name </label><input
										type="hidden" value="${journal.journalId}" id="jrId">
									<span class="form-control bg-light title-right title-right">${journal.journalName}</span>
								</div>
							</div>
							<div class="col-sm-6 col-md-6">
								<div class="form-group col">
									<label class="art-left">Workflow Name </label><input
										type="hidden" value="${workflow.id}" id="wrkfId"> <span
										class="form-control bg-light title-right">${workflow.name}</span>
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-sm-4 col-md-4">
								<div class="form-group col">
									<label class="art-left"><spring:message code="issue.book" /> Title</label><input
										type="hidden" value="${issueData.issue_id}" id="isuId">
									<span class="form-control bg-light title-right">${issueData.issue_title}</span>
								</div>
							</div>
							<div class="col-sm-4 col-md-4">
								<div class="form-group col">
									<label class="art-left">Volume Number </label> <span
										class="form-control bg-light title-right">${issueData.last_volume_number}</span>
								</div>
							</div>
							<div class="col-sm-4 col-md-4">
								<div class="form-group col">
									<label class="art-left">Volume Year</label><span
										class="form-control bg-light title-right">${issueData.volume_year}</span>
								</div>
							</div>

						</div>
					</div>
					<!-- <div class=""> -->
						<div class="">
						<!-- 	<div class="task-panel"> --><div class="task-height">
								<div class=" ">
									<div class="task-font"><spring:message code="chapters.articles" /> Available for <spring:message code="issue.book" /></div>

									<div class="task-height editableform-loading" >
										<!-- <table
											class="table table-striped table-bordered m-0 articleTable "
											id="example"> -->
											  <table id="example" class="tablegrid display nowrap tables_ui  " cellspacing="0" width="100%">
											<thead class="table-head">
												<tr>
													<th>S.no</th>
													<th><spring:message code="chapters.articles" /> Id</th>
													<!-- <th>Article id</th> -->
													<th><spring:message code="chapter.article" /> title</th>
													<th>Pages</th>
													<th>Color Image</th>
													<th>BW Image</th>
													<th>tbc</th>
													<th>tbc</th>
													<th><spring:message code="chapters.articles" /> DOI</th>
													<th>Article status</th>

												</tr>
											</thead>

											<!-- <tbody
												class="tasklist vertical connected-sortable droppable-area1 ui-sortable"> -->
												<tbody class="  t_sortable ">
												<c:forEach var="temp" items="${ArticleDetail}"
													varStatus="counter">
													<tr class="">
														<td class="counterCell "><a href="#" class="up">Up</a> <a
												href="#" class="down">Down</a></td>
														<%-- <td>${temp.article_id}</td> --%>
														<td >${temp.aid}</td>
														<td>${temp.article_title}</td>
														<td>${temp.article_pages}</td>
														<td class=textEdit>3</td>
														<td class=textEdit>3</td>
														<td class='numericEdit to'>0</td>
														<td class='numericEdit from' >0</td>
														<td >${temp.article_doi}</td>
														<td>${temp.taskName}</td>
													</tr>
												</c:forEach>

											</tbody>
										</table>

									</div>
								</div>
							</div>
						</div>
						
<!-- Image loader -->
<div id='loader' style='display: none;'>

</div>
<
			



									<div class="task-height">
<button id="RightMove" >right &raquo;</button>
<button id="LeftMove" >&laquo; left</button>
										<span class="task-font float-left"><spring:message code="chapters.articles" /> Available In <spring:message code="issue.book" /> </span>&nbsp;&nbsp;
										<select id="issueId" placeholder="Enter Title Here">
										<!-- <option value="CoverPage">Cover Page</option> -->
											<option value="IssueCover"><spring:message code="issue.book" /> Cover</option>
											<option value="PrintCover">Print Cover</option>
											<option value="Frontmatter">Frontmatter</option>
											<option value="Backmatter">Backmatter</option>
											<option value="IssueLayout"><spring:message code="issue.book" /> Layout</option>
											<option value="IssueText"><spring:message code="issue.book" /> Text</option>
											<option value="PrintText">Print Text</option>
											<option value="Printlayout">Print layout</option>
											<option value="Advertisement">Advertisement Page</option>
											<option value="AdditionalFile">Additional File</option>
											<option value="Add Extra Page In Issue">Add Extra Page In Issue</option></select>
										<!-- <input type="text" id="issueId"
											placeholder="Enter issueId here..." /> -->
										  <input type="text" id="issueTitle" placeholder="Enter Title Here" /> 
										<!-- <select id="issueTitle" placeholder="Enter issueTitel here..."><option
												value="CoverPage">Cover Page</option>
											<option value="Advertisement">Advertisement Page</option></select>  -->
											<input type="text" id="pageNo" maxlength = 6
											placeholder="Enter Page Number Here" />
										<!-- 	<button type="button" class="btn btn-info float-right"
											data-toggle="modal" data-target="#addIssueData">
											<i class="fa fa-plus font-icon "></i> &nbsp;Add File/Pages
											Issue addrow() 
										</button> -->
										<button type="button" id="oderingPage"
											class="btn btn-outline-danger btn-sm  float-right ml-2 oderingPage">
											<i class="fa font-icon "></i> &nbsp;Update Page Range
										</button>
											<button type="button"  onclick="downloadExcel()" class="btn btn-dark btn-sm float-right ml-2"  >
													<i class="fa  font-icon "></i> &nbsp;Download Excel
												</button> 
										<button type="submit" id="add-service-button" class="btn btn-outline-danger btn-sm  float-right" >
													<i class="fa fa-plus font-icon "></i> &nbsp;Add Pages
												</button>
									<!-- 	<small  class="btn  float-right" ><input type="checkbox" class="form-check-input"
											id="advancedToggle" checked> <label class="form-check-label"
											for="advancedToggle">Click to edit</label></small> -->
										<form method="POST" enctype="multipart/form-data" id="fileupl">
											<!-- <table id="example2"
												class="table table-striped table-bordered m-0 "> -->
												  <table id="example2" class="tablegrid display nowrap " cellspacing="0" width="100%">
												<thead class="table-head">
													<tr>
														<th>S.no</th>
														<th><spring:message code="chapter.article" /> Id</th> 
														<!-- <th>Article id</th> -->
														<th><spring:message code="chapter.article" /> title</th>
														<th>Pages</th>
														<th>Color Image</th>
														<th>BW Image</th>
														<th>From</th>
														<th>To</th>
														<th><spring:message code="chapter.article" /> DOI</th>
														<th><spring:message code="chapter.article" /> status</th>
													</tr>
												</thead>
											
												
													<!-- <tbody
													class="tasklist vertical connected-sortable droppable-area2 ui-sortable"> -->
													<tbody id="dragIt" class=" t_sortable ">
													<c:forEach var="temp" items="${issueSeq}"
													varStatus="counter">
										<tr class="">
											<td class="counterCell ">
											<i class="fa fa-arrow-up up" aria-hidden="true"></i>
											<i class="fa fa-arrow-down down" aria-hidden="true"></i>
											</td>
											<td>${temp.coverArticleId}</td>
											<td>${temp.articletitle}</td>
											<td>${temp.pages}</td>

											<td class=textEdit>3</td>
											<td class=textEdit>3</td>
											<td class='numericEdit to'>${temp.page_from}</td>
											<td class='numericEdit from'>${temp.to_page}</td>
											<c:if test="${temp.articleDoi ne 'Remove'}">
												<td>${temp.articleDoi}</td>
											</c:if>
											<c:if test="${temp.articleDoi eq 'Remove'}">
												<td><a class='del-service' href='#'
													title='Click to remove this entry'>Remove</a></td>
											</c:if>
											<td>${temp.issueFile.fileName}</td>
											<%-- 	<td>${temp.filePath}</td> <input type="hidden" id="fileURL" name="fileURL">
														<button type='button' class=" btn-danger"
																onclick="DownloadFile('C:\\unitouch\\azmj\\33689\\Origin\\AZMJ_39_19_qrc.png')"
																value='Download'>Download</button>--%>
										</tr>
									</c:forEach>
												</tbody>
												
											</table>
										</form>

							<!-- 		</div>

								</div>

							</div> -->

							<div class=" pull-right ">
								<button type="button" class="btn btn-danger oderingPage"
									onclick="saveIssueMakeup()">Save & Next</button>
								<%-- <a type="button" class="btn btn-outline-danger"
												href="${context}/getIssueData">Draft & Exit</a> --%>

								<a type="button" class="btn btn-outline-danger"
									href="${context}/getIssueList">Cancel</a>

							</div>
						</div>


					

				</c:if>



			</div>

		</div>
	</div>
</div>

 <div>
	<form method="POST" id="coverFile">
		<div id="issueTable">

			<!-- <table class="table  table-bordered" id="showData">
				<thead class="table-head">
					<tr>

						<th>Article Id</th>
						<th>workflow</th>
						<th>Article Title</th>
						<th>Page</th>
						<th>Journal</th>
						<th>Sequence Number</th>
						<th>Article DOI</th>
					</tr>
				</thead>

				<tbody id=appData></tbody>
			</table> -->
		</div>
	</form>
</div> 

<script>
$(window).on("load", function () {
	$("#showData").hide();
});
	/* function getissueData() {
		debugger;
		var journalId = document.getElementById("journalId").value

		var mappingJSON = {};
		mappingJSON["journalId"] = journalId;

		var mappingInfo = JSON.stringify(mappingJSON);
		$.ajax({
			url : '${context}/issueMakeuplist',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {

				$('#issueName').empty();
				var issueDetailList = result.payload;
				issueDetailList.forEach(function(x, index) {

					var str = '<option value="'+x.issue_id+'">' + x.issue_title	+ '</option>';
					$('#issueName').append(str);

				});

			},
			error : function(e) {
				console.log(e.message);
			}
		});
	} */
	//  Save IssueList

	/* function validate() {
		var custName = document.getElementById("Issue_Makeup").value;
		if (custName == '') {
			alert("Workflow name is mandatory and It must be an unique value.");
			return false;
		}

		return true;
	} */

	function saveIssueMakeup() {
		if (confirm("Are you sure you want to save this issue ?")) {
		debugger;
		var taskpre = document.getElementById("service-table");
		//Store HTML Table Values into Multidimensional Javascript Array Object
		var TableData = new Array();
		var values = {};
		var wrkId = document.getElementById("wrkfId").value;
		var jrId = document.getElementById("jrId").value;
		var isuId = document.getElementById("isuId").value;
		//var form = $('#attachmentCover')[0].value;
		 var form = $('#fileupl')[0]; 
		 var data = new FormData(form);
//		 alert(data);
// 		var data = new FormData();    
// 		jQuery.each(jQuery('#group')[0].files, function(i, file) {
// 		    data.append('files-'+i, file);
// 		});
	   // var data = new FormData(form);
				
		//var d=document.getElementById("service-table").childNodes[3].children[1].children[0].childNodes[0].value
		$('#service-table tr ').each(function(row, tr) {
			debugger;
			TableData[row] = {
				"artID" : $(tr).find('input:eq(0)').text(),
				"artID" : $(tr).find('input:eq(0)').text(),
				"articleId" : $(tr).find('td:eq(1)').text(),
				"articletitle" : $(tr).find('td:eq(2)').text(),
				"pages" : $(tr).find('td:eq(3)').text(),
				"pageFrom" : $(tr).find('td:eq(6)').text(),
				"pageTo" : $(tr).find('td:eq(7)').text(), 
				"articleDOI" : $(tr).find('td:eq(8)').text(),
				"atStatusCoverid" : $(tr).find('td:eq(9)').text(),
 			//	"attachmentCover" :data,
				"jId" : jrId,
				"workflowid" : wrkId,
				"issueId" : isuId
			
				
			}//tableData[row]
		});
	
		TableData.shift(); // first row will be empty - so remove
		debugger;
		//alert(data);
		var Data;
		Data = JSON.stringify(TableData);
// 		var formData = new FormData();
// 		formData.append('file', data);
// 		formData.append('datafile', TableData);
// 		alert(Data);
		//alert(wrkId + " :: " + jrId);
		/*  */
		   event.preventDefault();

        // Get form
//  	   var form = $('#coverFile')[0];

//  	     var data1 = new FormData(form);
//          data1.append("CustomField", "This is some extra data, testing");
//          data1.append("wrkId",wrkId);
 	//	alert(data);
 		data.append('filedata', Data);
 		data.append('jrID', jrId);
 		data.append('issueID', isuId);
		// disabled the submit button
       // $("#add-service-button").prop("disabled", true);
		/*  */
		debugger;
		$.ajax({
			url : '${context}/editeCreateIsserSeq',
			/* type : "POST",
			data : Data,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false, */
		    type: 'POST',
            data: data,
            async: false,
            cache: false,
            contentType: false,
            enctype: 'multipart/form-data',
            processData: false,
            beforeSend: function(){
                // Show image container
                $("#loader").show();
               },
			success : function(result) {
			//	$('#hideDiv').hide();
			//	$('#mainhide').hide();
				 $("#loader").hide();
				alert("Issue updated  successfully");
				if(result){
					document.getElementById("coverFile").action = "getIssueList";
					document.getElementById("coverFile").method = "GET";
					document.getElementById("coverFile").submit();
				}else
				{ location.href = "http://unitouch.digiscapetech.com/getIssueList"}
// 				$("#showData").show();
// 				//$('#issueName').empty();
// 				var issueSeqList = result.payload;
// 				//alert(issueSeqList);
// 				//$("#showData").DataTable();
// 				//alert(issueSeqList+" ::::::");
// 				issueSeqList.forEach(function(x, index) {
// 					//'<option value="'+x.issue_id+'">' + x.issue_title	+ '</option>'
// 					var str = '<tr><td>' + x.coverArticleId + '</td>' + '<td>'
// 							+ x.workflows.name + '</td>' + '<td>'
// 							+ x.articletitle + '</td>' + '<td>' + x.pages
// 							+ '</td>' + '<td>' + x.journals.journalName
// 							+ '</td>' + '<td>' + x.sequenceNo + '</td>'
// 							+ '<td>' + x.articleDoi + '</td>' + '</tr>';
// 						alert(str);
// 					$('#appData').append(str);

// 				});

			},
			error : function(e) {
				 $("#loader").hide();
				 alert("Opps Something went wrong , Please refresh the page");
				console.log(e.message);
			}
		});

	}
		}

	function validate() {
		var journalId=document.getElementById("journalId").value;
		var issueid = document.getElementById("issueName").value;

		if(journalId=='Please Select'){
			alert("Journal cannot be blank.");
			return false;
		}
		
		if (issueid == '') {
			alert("Please create new issue than select a issue");
			return false;
		}
		else if((issueid == 'Please select journal first')){
			alert("Choice Issue name cannot be blank.");
			return false;
		}
		
		return true;
	}
	

	// Date Format year
	$(function() {
		  $('#volume_year').datepicker({
		    changeYear: true,
		    showButtonPanel: true,
		    dateFormat: 'yy',
		    onClose: function(dateText, inst) {
		      var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
		      $(this).datepicker('setDate', new Date(year, 1));
		    }
		  });

		  $("#volume_year").focus(function() {
		    $(".ui-datepicker-month").hide();
		    $(".ui-datepicker-calendar").hide();
		  });

		});
	
	function searchdata() {
		if (validate()) {
			document.getElementById("group").action = "getIssueData";
			document.getElementById("group").method = "POST";
			document.getElementById("group").submit();
		}
	}
	function addIssueMakeup() {
		document.getElementById("group").action = "addIssueMakeup";
		document.getElementById("group").method = "POST";
		document.getElementById("group").submit();
	}
	function articalDetails(val) {
		document.getElementById("article_id").value = val;
		document.getElementById("group").action = "startGroupTask";
		document.getElementById("group").method = "POST";
		document.getElementById("group").submit();
	}
</script>

<script>
	function allnumeric(inputtxt) {
		

		var numbers = /^[0-9]+$/;
		if (inputtxt.match(numbers)) {
			document.getElementById("issueId").style.borderColor = "white";
			document.getElementById("pageNo").style.borderColor = "white";
			document.getElementById("issueTitle").style.borderColor = "white";
			
			return true;
		} else {
			//document.getElementById("pageNo").value
			document.getElementById("pageNo").style.borderColor = "red";
			//  $("#errormsg").append("<small style='color:red;'>Please Enter a Number<small>");
			//alert('Please input numeric characters only');
			return false;
		}
	}

	$(function() {
		debugger;
		$("#showData").hide();
	/* 	function numberRows($t) {
			var c = 0;
			$t.find("tr").each(function(ind, el) {
				
				$(el).find("td:eq(0)").html(++c + ".");
			});
		} */
		//.html("<input type='text'/>")

	/* 	$("#add-service-button")
				.click(
						function(e) {
							e.preventDefault();
							var issueid = document.getElementById("issueId").value
							var issueTitle = document
									.getElementById("issueTitle").value
							var pageno = document.getElementById("pageNo").value
							
							
							if (issueid == "") {
								document.getElementById("issueId").style.borderColor = "red";
								//$("#errormsg").append("Please Enter Issue Id  ");
								
							} else if (issueTitle == "") {	
								document.getElementById("issueTitle").style.borderColor = "red";
								alert("Please enter title");
							//	$("#errormsg").append("Please Enter Issue Title ");
								
							}

						/* 	else if (pageno == "") {
						//		document.getElementById("pageNo").style.borderColor = "red";
						//		alert("Please enter page number.");
							//	  $("#errormsg").append("<small style='color:red;'>Please Enter a Number<small>");
								

						//	} 

							else if (true) {
								//allnumeric(pageno)
								
								var $row = $("<tr>");
								$row.append($("<td class='counterCell'>"));
// 								$row.append($("<td>"));
								$row
										.append($("<td>").html(
												$("#issueId").val()));
								$row.append($("<td>").html(
										$("#issueTitle").val()));
								$row.append($("<td class=textEdit>").html($("#pageNo").val()));
								$row.append($("<td class=textEdit>").html($("#pageNo").val()));
								$row.append($("<td class=numericEdit>").html($("#pageNo").val()));
								$row.append($("<td class='numericEdit to'>").html(0));
								$row.append($("<td class='numericEdit from'>").html(0));
								$row
										.append($("<td>")
												.html(
														"<a class='del-service' href='#' title='Click to remove this entry'>Remove</a>"));
								//$row.append($("<td>").html($("#attachmentCover").val()));
								$row.append($("<td>").html("<input type='file' name='files' id='files' multiple  required>")); 
								
								$row.appendTo($("#example2"));
							//  numberRows($("#service-table")); 
							
							//	$('#addIssueData').click();
							}

							else {
								//debugger;

								//alert("Please Enter a valid Number "); 		
							}

						}); */
/* 		$("#form-entry form").submit(function(e) {
			e.preventDefault();
			$("#add-service-button").trigger("click");
		//	alert("from call");
		}); */
		$("#example2")
				.on(
						"click",
						".del-service",
						function(e) {
							e.preventDefault();
							var $row = $(this).parent().parent();
							var retResult = confirm("Are you sure you wish to remove this entry?");
							if (retResult) {
								$row.remove();
							//	$row.fnDeleteRow(6);
								/*  numberRows($("#service-table")); */
							}
						});
	});
</script>
<script>
        $(document).ready(function () {

            var logAllEvents = true;


            //Basic editor with no navigation
       /*      var simpleEditor = new SimpleTableCellEditor("service-table", {navigation:false});
            simpleEditor.SetEditableClass("editMe");

            $('#service-table').on("cell:edited", function (event) {
                console.log(`'${event.oldValue}' changed to '${event.newValue}'`);
            }); */


            //Advanced editor
            var advancedEditor = new SimpleTableCellEditor("example2");
            advancedEditor.SetEditableClass("numericEdit", { validation: $.isNumeric });
            advancedEditor.SetEditableClass("textEdit");
            $("#advancedToggle").on('click', function(e){
                advancedEditor.Toggle($(e.currentTarget).is(':checked'));
            })

            if (logAllEvents) {
                $('table').on("cell:onEditExit", function (event) {
        			var TableData = new Array();
        			
        			var lastnumber = '${issSeqLast.to_page}'
            			var subTotal = 1;
        				var subTotal2=0;
        				if(lastnumber!=""){
        					subTotal2=parseInt(lastnumber);
        					}
        		
        			var $data =	$('#example2 tr ').each(function(row, tr) {
            			TableData[row] = {
            				//"artID" : $(tr).find('input:eq(0)').text(),
            				"articleId" : $(tr).find('td:eq(1)').text(),
            				//"articletitle" : $(tr).find('td:eq(2)').text(),
            				"pages" : $(tr).find('td:eq(3)').text(),
            				"from" : $(tr).find('td:eq(6)').text(),
            				"to" : $(tr).find('td:eq(7)').text(),
            			//	"articleDOI" : $(tr).find('td:eq(8)').text(),
            				//"atStatusCoverid" : $(tr).find('td:eq(9)').text(),
            			}//tableData[row]
            			var to = $(tr).find('td:eq(6)').text();
        				var from = $(tr).find('td:eq(7)').text();
        				var remove = $(tr).find('td:eq(8)').text();
        				var page =$(tr).find('td:eq(3)').text();
        				if(remove!="Remove"){
            			if (to!="") {
            				debugger;
        			//	alert("to :"+to);
        			//	alert("from :"+from);
        			//	alert("page :"+page);
        				
        				 subTotal2=parseInt(page)+parseInt(subTotal)-1;
        			//	alert(subTotal2);		
        				
        				$(tr).find('td:eq(6)').empty();
        				$(tr).find('td:eq(6)').append(""+subTotal+"");
        				$(tr).find('td:eq(7)').empty();
            			$(tr).find('td:eq(7)').append("" + subTotal2 + "");
        				}
            			subTotal=subTotal2+1;	
            		}});
            		TableData.shift(); 
	        	 	var Data = JSON.stringify(TableData);
                      		//alert(Data); 

                    console.log('onEditExited event');
                });
            }



        });
    </script>
<script>
$('#last_volume_number').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[0-9]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
})

 $('#last_issue_number').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[0-9]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
})

 $('#number_of_volume_per_year').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[0-9]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
})

 $('#number_of_issue_per_year').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[0-9]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
})

 $('#datepicker').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[0-9]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
})

$('#issueTitle').on('input', function() {
   var cursor_pos = $(this).getCursorPosition()
   if(!(/^[a-zA-Z0-9 _]*$/.test($(this).val())) ) {
    $(this).val($(this).attr('data-value'))
    $(this).setCursorPosition(cursor_pos - 1)
    return
  }
  $(this).attr('data-value', $(this).val())
})

/* $('#pageNo').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[0-9]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
}) */
$.fn.getCursorPosition = function() {
    if(this.length == 0) return -1
    return $(this).getSelectionStart()
}
$.fn.setCursorPosition = function(position) {
    if(this.lengh == 0) return this
    return $(this).setSelection(position, position)
}
$.fn.getSelectionStart = function(){
  if(this.lengh == 0) return -1
  input = this[0]
  var pos = input.value.length
  if (input.createTextRange) {
    var r = document.selection.createRange().duplicate()
    r.moveEnd('character', input.value.length)
    if (r.text == '') 
    pos = input.value.length
    pos = input.value.lastIndexOf(r.text)
  } else if(typeof(input.selectionStart)!="undefined")
  pos = input.selectionStart
  return pos
}
$.fn.setSelection = function(selectionStart, selectionEnd) {
  if(this.lengh == 0) return this
  input = this[0]
  if(input.createTextRange) {
    var range = input.createTextRange()
    range.collapse(true)
    range.moveEnd('character', selectionEnd)
    range.moveStart('character', selectionStart)
    range.select()
  }
  else if (input.setSelectionRange) {
    input.focus()
    input.setSelectionRange(selectionStart, selectionEnd)
  }
  return this
}  
</script>
<script>
function DownloadFile(val) {
	//alert(val);
	document.getElementById("fileURL").value =val;
	document.getElementById("fileupl").action = "dwonload_file";
	document.getElementById("fileupl").method = "GET";
	document.getElementById("fileupl").submit();
}
function downloadExcel() {
	debugger;
   // alert("Cryeae");
	
	document.getElementById("fileupl").action = "createExcel";
	document.getElementById("fileupl").method = "POST";
	document.getElementById("fileupl").submit();	
}

</script>


<script>


$( ".oderingPage" ).click(function() {

 //$('table').on("cell:onEditExit", function (event) {
		var TableData = new Array();
		var lastnumber = '${issSeqLast.to_page}'
			var subTotal = 1;
			var subTotal2=0;
			if(lastnumber!=""){
				subTotal2=parseInt(lastnumber);
				}
	/* 	var subTotal = 1;
		var subTotal2=0; */
		var $data =	$('#example2 tr ').each(function(row, tr) {
			TableData[row] = {
				"articleId" : $(tr).find('td:eq(1)').text(),
				"pages" : $(tr).find('td:eq(3)').text(),
				"from" : $(tr).find('td:eq(6)').text(),
				
				"to" : $(tr).find('td:eq(7)').text(),
			}//tableData[row]
			var to = $(tr).find('td:eq(6)').text();
			var from = $(tr).find('td:eq(7)').text();
			var remove = $(tr).find('td:eq(8)').text();
			var page =$(tr).find('td:eq(3)').text();
			if(remove!="Remove"){
			if (to!="") {
				debugger;
			 subTotal2=parseInt(page)+parseInt(subTotal)-1;
			
			$(tr).find('td:eq(6)').empty();
			$(tr).find('td:eq(6)').append(""+subTotal+"");
			$(tr).find('td:eq(7)').empty();
			$(tr).find('td:eq(7)').append("" + subTotal2 + "");
			}
			subTotal=subTotal2+1;	
			}});
		TableData.shift(); 
	 	var Data = JSON.stringify(TableData);
 //      		alert(Data); 

 //    console.log('onEditExited event');
 });

</script>

<script>
var editor;
var table2;
$(document).ready( function () {

/* 	  editor = new $.fn.dataTable.Editor( {
	     //   ajax:  '../php/sequence.php',
	        table: '#example',
	        fields: [ {
	                label: 'Order:',
	                name: 'readingOrder',
	                fieldInfo: 'This field can only be edited via click and drag row reordering.'
	            }, {
	                label: 'Aid:',
	                name:  'Aid'
	            }, {
	                label: 'Article title:',
	                name:  'Article title'
	            }, {
	                label: 'Pages :',
	                name:  'Pages'
	            }, {
	                label: 'BW Image:',
	                name:  'BW Image'
	            }, {
	                label: 'From:',
	                name:  'From'
	            }, {
	                label: 'To :',
	                name:  'To'
	            }, {
	                label: 'Article DOI:',
	                name:  'doi'
	            }, {
	                label: 'Article status :',
	                name:  'Status'
	            }
	        ]
	    } ); */
	  
	var table = $('#example').DataTable({
   // data: data,
    columnDefs: [
      {
    	   targets: [0, 1,2,3,4] ,
        createdCell: function (td, cellData, rowData, row, col) {
          $(td).addClass('draggable_tr');
        }
      }
    ], 
    sPaginationType: 'full_numbers',
    bFilter: false,
    rowReorder: {
        dataSrc: 'sequence',
        editor:  editor
    },
    autoheight:true, 
    select:true,
    multiselect:true,
    drag:true,
    
    drawCallback: function () {
      $("#example tr .draggable_tr").draggable({
      helper: function(){
        var selected = $('tr.selectedRow');
        if (selected.length === 0) {
          selected = $(this).closest('tr').addClass('selectedRow');
        }
        var container = $('<div/>').attr('id', 'draggingContainer');
        container.append(selected.clone().removeClass("selectedRow"));
        return container;
        }
      });
    }
  });
	     
  $('#example tbody').on( 'click', 'tr', function () {
      $(this).toggleClass('selected');
  } );

//   $('#button').click( function () {
//       alert( table.rows('.selected').data().length +' row(s) selected' );
//   } );
  
  
   table2 = $('#example2').DataTable({
   // data: data2,
    columnDefs: [
      {
      
        orderable: false,
        targets: [ 0,1,2,3,4] ,
        
     
        createdCell: function (td, cellData, rowData, row, col) {
          $(td).addClass('draggable_tr');
        }
      }
    ],
    sPaginationType: 'full_numbers',
    bFilter: false,
    createdRow: function(row, data, dataIndex){
        $(row).attr('id', 'row-' + dataIndex);
     } ,
    rowReorder: {
    	 selector: 'tr',
         dataSrc: 'r'
    },
    autoheight:true, 
    select:true,
    multiselect:true,
    drag:true,
    drawCallback: function () {
      $("#example2 tr .draggable_tr").draggable({
      helper: function(){
        var selected = $('tr.selectedRow');
        if (selected.length === 0) {
          selected = $(this).closest('tr').addClass('selectedRow');
        }
        var container = $('<div/>').attr('id', 'draggingContainer');
        container.append(selected.clone().removeClass("selectedRow"));
        return container;
        }
      });
    } 
   
  });
   table.on('click', 'tbody tr' ,function() {
		 $(this).toggleClass('selected');
  });
   table2.on('click', 'tbody tr' ,function() {
		 $(this).toggleClass('selected');
  });
	
	$('#LeftMove').on('click',function () {
		debugger;
		moveRows(table, table2);
		
	});
	
	$('#RightMove').on('click',function () {
		debugger;
		moveRows(table2, table);
	});
	  
	function moveRows(fromTable, toTable){
		var $row= fromTable.find(".selected");
		$.each($row, function(k, v){
			if(this !== null){
				addRow = fromTable.fnGetData(this);
				toTable.fnAddData(addRow);
				fromTable.fnDeleteRow(this);
			}
		});
	}
	
//  table2.fnDeleteRow(index);
$('#add-service-button').click(function () { 
var rowNode = table2
  .row.add( [" <a href='#' class='up'>Up</a> <a href='#' class='down'>Down</a>", $("#issueId").val(), $("#issueTitle").val(),$("#pageNo").val(), 32, '0','0','0', "<a class='del-service' href='#' title='Click to remove this entry'>Remove</a>", '' ] )
  .draw()
  .node();
$( rowNode ).find('td').eq(0).addClass('counterCell ');
$( rowNode ).find('td').eq(4).addClass('textEdit');
$( rowNode ).find('td').eq(5).addClass('textEdit');
  });


$("#example, #example2").droppable({
    drop: function (event, ui) {
    	debugger;
      var dropTable = $(this).DataTable();
      dropTable.row.add(ui.helper.children()).draw(false);

      var draggingTable = $('.selectedRow').closest('table').DataTable();
      draggingTable.row($('.selectedRow')).remove().draw(false);
    } 
});


// $(document).on("click", ".tablegrid tr", function () {
//   console.log('toggle class')
//     $(this).toggleClass("selectedRow");
// });

} );

// $(document).ready(function(){
//     $(".up,.down").click(function(){
//         var row = $(this).parents("tr:first");
//         if ($(this).is(".up")) {
//             row.insertBefore(row.prev());
//         } else {
//             row.insertAfter(row.next());
//         }
//     });
// });

$(document).ready(function(){
    $(".up,.down,.top,.bottom").click(function(){
        var row = $(this).parents("tr:first");
        debugger;
        if ($(this).is(".up")) {
            row.insertBefore(row.prev());
        } else if ($(this).is(".down")) {
            row.insertAfter(row.next());
        } else if ($(this).is(".top")) {
            row.insertBefore($("table tr:first"));
        }else {
            row.insertAfter($("table tr:last"));
        }
    });
});
</script>

<style>
/* Styles go here */

.dataTables_wrapper {
float: left;
width: 40%;
clear: none
}
#table2_wrapper{
	margin-top:50px;
	margin-left:50px;
}
#table1_wrapper{
	
	margin-left:50px;
}
table.dataTable tbody tr.selected {
  background-color: #b0bed9;
}
table.dataTable.display tbody tr.odd.selected > .sorting_1, table.dataTable.order-column.stripe tbody tr.odd.selected > .sorting_1 {
background-color: #a6b3cd;
}
table.dataTable.display tbody tr:hover.selected > .sorting_1, table.dataTable.display tbody tr.odd:hover.selected > .sorting_1, table.dataTable.display tbody tr.even:hover.selected > .sorting_1, table.dataTable.order-column.hover tbody tr:hover.selected > .sorting_1, table.dataTable.order-column.hover tbody tr.odd:hover.selected > .sorting_1, table.dataTable.order-column.hover tbody tr.even:hover.selected > .sorting_1 {
background-color: #a1aec7;
}

</style>
<script>
// Code goes here
//$(document).ready(function() {
//     var stockTable = $('#table1').dataTable({
//         "sPaginationType": "full_numbers",
//         "bFilter": false
//     }); // first table 
    
// 	var catalogTable = $('#table2').dataTable({
//         "sPaginationType": "full_numbers",
//         "bFilter": false
//     }); // Second table 
   
//     stockTable.on('click', 'tbody tr' ,function() {
// 		 $(this).toggleClass('selected');
//     });
// 	catalogTable.on('click', 'tbody tr' ,function() {
// 		 $(this).toggleClass('selected');
//     });
	
// 	$('#LeftMove').on('click',function () {
// 		moveRows(catalogTable, stockTable);
// 	});
	
// 	$('#RightMove').on('click',function () {
// 		moveRows(stockTable, catalogTable);
// 	});
	
// });
	

</script>
