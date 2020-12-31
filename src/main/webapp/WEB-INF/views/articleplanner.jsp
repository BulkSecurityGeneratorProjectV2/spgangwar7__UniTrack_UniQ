<%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2"><spring:message code="chapter.article" /> Planner</span> <span id="Date">Mon
									, 26 Aug 2019</span><span class="ml-auto"><a
									href="javascript:;" class="btn btn-sm btn-outline-danger"
									onclick="createArticle()"><i class="fa fa-plus"></i> Add New</a></span>
									<span class="pull-right">
                   <!--  <button type="button" class="btn btn-sm btn-outline-danger" data-toggle="modal" data-target="#mailSetup"><i class="fa fa-envelope "></i> &nbsp;Email</button> -->
                    </span>
							</div>
						</div>	
					</div>
					<!--main_tittle_End-->

					<form name="article" id="article">
						<input type="hidden" name="article_id" id="article_id">

						<div class="row">
							<div class="col-md-12">



								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="articleTable">
											<thead class="table-head">
												<tr>
				                                    <th>S.No</th>
													<th>Publisher Name</th>
													
													<th>Supplier name</th>
													
													<th>Stage</th>
													
													<th>Segment</th>
													
												    <th><spring:message code="chapter.article" /> Title</th>
												    
												     <th>Status</th>
													
													<th>Schedule Start Time</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${articleplanner}"
													varStatus="counter">
													<tr>
													    <td>${counter.count}</td>
														<td>${temp.publ_name}</td>
														<td>${temp.dname}</td>
														<td>${temp.wname}</td>
														<td>${temp.journal_name}</td>
														<td>${temp.article_title}</td>	
														<td>${temp.task_status}</td>
													    <td>${temp.sch_start_time}</td>
													
														
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
</script>
  
 