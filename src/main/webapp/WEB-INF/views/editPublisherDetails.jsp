 <%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Edit Publisher</span> <span id="Date"></span>
							</div>
						</div>
					</div>
					<!--main_tittle_End-->



					<div class="row ">
						<div class="col-md-12 ">
							<div class="content_box">
									<div class="box-body">


								<form id="publishers" name="publishers">
								<input type="hidden" name="publisher_id" id="publisher_id" value="${pubList.publisher_id}">
									<div class="row">
										<div class="col-md-5">
											<div class="form-group">
												<label for="currency">Publisher Name</label> 
												<input	type="text" class="form-control" name="publisherName"
													id="publisherName" placeholder="" autocomplete="off" value="${pubList.publisherName}">
											</div>
										</div>

										<%-- <div class="col-md-6">
											<div class="form-group">
												<label for="currency">City Name</label> <input
													type="text" class="form-control"
													name="cityName" id="cityName"
													placeholder="" autocomplete="off" value="${pubList.cityName}">
											</div>
										</div> --%>

										<div class="col-md-5">
											<div class="form-group">
												<label for="ExpertiseLevel">Country </label>
												<form:select path="countryList" id="countryID"
													name="countryID" class="form-control">
													<form:option value="Please Select" labelValue="" />
													<form:options items="${countryList}" itemValue="countryID"
														itemLabel="countryName" />
												</form:select>
											</div>
										</div>
										<div class="col-md-2">
											<div class=" mt-3">
												<a class="btn btn-outline-danger" href="${context}/publisherDetails"><i class="fa fa-close"></i> Cancel</a> &nbsp;
												<a class="btn btn-danger" href="#" onclick="updatePublisherDetails(${pubList.publisher_id})"><i class="fa fa-save"></i> Save</a>
											</div>
										</div>
									</div>
									
									

								</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
