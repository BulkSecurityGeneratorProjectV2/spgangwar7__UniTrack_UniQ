<%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Journal Details</span> <span id="Date">Mon
									, 26 Aug 2019</span><span class="ml-auto"><a
									href="javascript:;" class="btn btn-sm btn-outline-danger"
									onclick="createJournal()"><i class="fa fa-plus"></i> Add New</a></span>
									<span class="pull-right">
<!--                     <button type="button" class="btn btn-sm btn-outline-danger" data-toggle="modal" data-target="#mailSetup"><i class="fa fa-envelope "></i> &nbsp;Email</button> -->
                    </span>
							</div>
						</div>	
					</div>
					<!--main_tittle_End-->

					<form name="article" id="journal">
						<input type="hidden" name="journalId" id="journalId">

						<div class="row">
							<div class="col-md-12">



								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="articleTable">
											<thead class="table-head">
												<tr>
												<th>Manage Workflow</th>
													<th>Journal Acronym</th>
													<th>Journal Title</th>
													<th>Online ISSN</th>
													<th>Copyright statement</th>
													<th>Sequential Issue Numbering</th>
												
													<th>Created By</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${journallist}"
													varStatus="counter">
													<tr>
														<td>  <input type="hidden" name="jId" id="jId">
													   <c:if test="${temp.articleWorkflowId eq 0}">
								       				    <a href="#" onclick="editworkFlowTask(${temp.journalId})"  data-placement="top"  title="Edit Info">
														<i class="fa fa-edit edit-icon"></i></a></c:if> </td>
														<td>${temp.journalAcronym}</td>
														<td>${temp.journalName}</td>
														<td>${temp.journalIssn}</td>
														<td>${temp.copyrightStmt}</td>
														<td>${temp.lastIssueNbr}</td>
														<%-- <td>${temp.createdBy}</td> --%>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
	
	<!--  Pop up Email   Email Setup  start -->

<div class="modal fade" id="mailSetup" role="dialog">
  <div class="modal-dialog modal-lg"> 
    
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="border:none;">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <div class=""> 
        
        <!--Material Tabs Start-->
        
        <div class="">
          <div class="col-md-12"> 
            <!-- Nav tabs -->
            <div class="">
              <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#e" aria-controls="home" role="tab" data-toggle="tab">Restart Workflow</a></li>
              </ul>
              
              <!-- Tab panes -->
              <div class="tab-content"> 
                
                <!--  tab  start -->
                <div role="tabpanel" class="tab-pane active" id="e">
                  <div class="form-group">
                    <label for="email">To</label>
                    <input type="email" class="form-control" id="EmailId"  name="EmailId">
                  </div>
                  <div class="form-group">
                    <label for="email">Subject</label>
                    <input type="email" class="form-control" id="emailSubject" Value="" name="emailSubject">
                  </div>
                  <div class="col-sm-12 no-lr-pad">
                  <textarea name="editor1" id="editor1" rows="10" cols="80"></textarea>
                  </div>
                  
                  
                  <div class="clearfix"></div>
                  
                  <div class="modal-footer footer-popup  mt-20"> <span> 
       
        <button type="button" class="btn-sm btn-danger" data-dismiss="modal"  onclick="createNewTask()">Save</button>
        <button type="button" class="btn-sm btn-outline-danger" data-dismiss="modal"  onclick="createNewTask()">Cancel</button>
        </span> </div>
                </div>
                
                <!--  tab  End --> 
                
              </div>
              
              
            </div>
          </div>
        </div>
        
        <!--Material Tabs End--> 
        
      </div>
      <div class="clearfix"></div>
      
    </div>
  </div>
</div>

<!------ Pop up Email   Email Setup End------->

<script src="https://cdn.ckeditor.com/4.6.2/basic/ckeditor.js"></script> 
<script>
CKEDITOR.editorConfig = function (config) {
 config.language = 'es';
 config.uiColor = '#F7B42C';
 config.height = 300;
 config.toolbarCanCollapse = true;
};
CKEDITOR.replace('editor1');

function editworkFlowTask(val){
	document.getElementById("jId").value=val;
	document.getElementById("journal").action="manageworkFlowJournal";
    document.getElementById("journal").method="POST";
	document.getElementById("journal").submit();
}
</script>
 
 