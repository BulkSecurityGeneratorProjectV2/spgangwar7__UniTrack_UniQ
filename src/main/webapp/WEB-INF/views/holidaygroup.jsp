
<%@ include file="/WEB-INF/includes/include.jsp" %>
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Holiday Group Details</span> <span id="Date">Mon
									, 26 Aug 2019</span><span class="ml-auto"><a
									href="${context}/createHoliDayGrp" class="btn btn-sm btn-outline-danger"><i class="fa fa-plus"></i> Add New</a></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->

					<form name="holidayGroup" id="holidayGroup">
						<input type="hidden" name="holidayGrpId" id="holidayGrpId">
						<div class="row">
							<div class="col-md-12">
								<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="holidayGroupTable">
											<thead class="table-head">
												<tr>
												<th>Action</th>
													<th>Holiday Group Name</th>
													
													
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${holidayGroup}" varStatus="counter">
													<tr>
														<td>
														<a href="#" onclick="editHoliDayGroup(${temp.holidayGrpId});" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit Info"><i class="fa fa-edit edit-icon"></i></a>  
 														<a href="#" onclick="deleteHoliDayGroup(${temp.holidayGrpId});" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete Info"><i class="fa fa fa-trash delete-icon"></i></a>  
														</td> 
														<td>${temp.holidayGrpName}</td>
														</tr>
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
