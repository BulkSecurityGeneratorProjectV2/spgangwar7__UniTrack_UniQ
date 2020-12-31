<%@ include file="/WEB-INF/includes/include.jsp"%>
<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
		
			<div class="container-fluid">
			<form name="groupTask" id="groupTask">
				<!--main_tittle-->
				<div class="row">
					<div class="col-sm-4 col-md-4">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2"><spring:message code="chapter.article" /> Pool</span> <span id="Date"></span>
						</div>
					</div>
					<div class="col-sm-4 col-md-4 text-center">
							<a class=" btn btn-dark btn-sm text-white" href="${context}/getjournalListForPool"><i class="fa fa-hand-o-up"></i> Switch Journal</a>
					</div>
					<div class="col-sm-4 col-md-4">
						<input type="hidden" name="flag" id="flag" value="${flag}">
						<div align="right">
							<select class="slctbtn col-sm-4" id="multiUser">
								<option value="null">Select User</option>
								<c:forEach var="user" items="${userDepartment}"
									varStatus="counter">
									<option value="${user.id}">${user.name}</option>
								</c:forEach>
							</select> <input type="button" class="asnButton" value="Assign Article"
								onclick="GetSelected()" />
						</div>
					</div>
						
					</div>
				<!--main_tittle_End-->

				
<%-- <select>
										<c:forEach var="journalList" items="${journalList}">
											<option value='${journalList.journalName}'>${journalList.journalName}</option>
										</c:forEach>
									</select> --%>
					<div class="row">
						<div class="col-md-12">
							<div class="content_box">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0"
										id="myTable">
										<thead class="table-head">
											<tr>
												<th width="2%">S.No.</th>
												<th width="2%"><input type="checkbox" id="checkAll"></th>
												<th width="8%">Article ID</th>
												<th width="15%">Journal Abbreviation Name</th>
												<th width="25%">Title</th>
												<th width="10%">Task Name</th>
												<th width="10%">Stage</th>
												<th width="10%">Schedule Start Date</th>
												<th width="10%">Schedule End Date</th>
												<!-- <th>Actual Start Date</th> -->
												<th width="20%">Action</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach var="temp" items="${taskManagementVo}"
												varStatus="counter">

												<tr>
													<td align="center">${counter.count}</td>
													<td align="left"><input type="checkbox"
														class="checkItem" id="${temp.article_task_id}"
														value=" ${temp.article_task_id}"></td>
													<td>${temp.aid}</td>
													<td align="center">${temp.journalAbbrName}</td>
													<td>${temp.article_title}</td>
													<td>${temp.taskName}</td>
													<td>${temp.task_status}</td>
													<td align="center"><fmt:formatDate
															pattern="dd-MM-yyyy" value="${temp.sch_start_time}" /></td>
													<td align="center"><fmt:formatDate
															pattern="dd-MM-yyyy" value="${temp.sch_end_time}" /></td>
													<%--													<td>${temp.start_date_time}</td>
												
														<td><fmt:formatDate pattern="dd-MM-yyyy" value="${temp.sch_end_time}" /></td> --%>
													<td align="center"><input type="hidden"
														name="article_id" id="article_id"
														value="${temp.article_id}"> <input type="hidden"
														name="article_task_id" id="article_task_id"
														value="${temp.article_task_id}"> <%-- 														<input type="hidden" name="journalId" id="journalId" value="${temp.journalId}"> --%>


														<a href="#" class="btn btn-outline-success btn-sm"
														onclick="StartGroupTask(${temp.article_task_id},${temp.article_id})">
															Assign Me</a></td>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

					<input type="hidden" name="userId" id="userId"> <input
						type="hidden" name="selectedArticle" id="selectedArticle">
				</form>

			</div>
		</div>
	</div>
</div>


<script type="text/javascript">

/* $(document).ready( function () {
    $('#myTable').DataTable();
} );

 */
</script>

<script>
	function StartGroupTask(val,aid) {
		
		document.getElementById("article_task_id").value = val;
		document.getElementById("article_id").value = aid
		document.getElementById("groupTask").action = "view-groupTask";
		document.getElementById("groupTask").method = "POST";
		document.getElementById("groupTask").submit();
		
	}
	</script>

<script type="text/javascript">
    function GetSelected() {
       
		 $('#user_combo').find('option:selected').val(); 
		 var userId= $('#multiUser').find('option:selected').val();
		 
        //Create an Array.
        var selectedArticle = new Array();
 
        //Reference the Table.
        var multipleActicleIds = document.getElementById("groupTask");
 
        //Reference all the CheckBoxes in Table.
        var chks = multipleActicleIds.getElementsByTagName("INPUT");
 
        // Loop and push the checked CheckBox value in Array.
        for (var i = 0; i < chks.length; i++) {
            if (chks[i].checked) {
            	selectedArticle.push(chks[i].value);
               
            }
        }
 
        //Display the selected CheckBox values.
        if (selectedArticle =='') {
    		alert("Select article(s) to proceed");
    		return false;
    	}  if (userId =='null') {
    		alert("Please select an user");
    		return false;
    	}else if(selectedArticle !='null' && userId !=''){
    		    document.getElementById("userId").value = userId;
    	        document.getElementById("selectedArticle").value = selectedArticle;
    	        document.getElementById("groupTask").action = "assignTask";
    			document.getElementById("groupTask").method = "POST";
    			document.getElementById("groupTask").submit();	
    	}
       
 
    };
    
    $('#checkAll').click(function () {    
	    $(':checkbox.checkItem').prop('checked', this.checked);    
	 });
    
</script>
