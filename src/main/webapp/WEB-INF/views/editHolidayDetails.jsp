
<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Edit Holiday Details</span> <span id="Date"></span>
						</div>
					</div>
				</div>
				<!--main_tittle_End-->



				<div class="row ">
					<div class="col-md-12 ">
						<div class="content_box">
							<div class="box-body">


								<form name="holidays" id="holidays">
									<input type="hidden" name="hcId" id="hcId"
										value="${holidayList.hcId}">
									<div class="row">

										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Holiday Name</label> <input
													type="text" class="form-control" name="holidayName"
													id="holidayName" placeholder="" autocomplete="off"
													value="${holidayList.holidayName}">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label for="ExpertiseLevel">Holiday Group </label>
												<form:select path="holidayGroup" id="hgId" name="hgId"
													class="form-control">
													<form:option value="Please Select A Group..." labelValue="" />
													<form:options items="${holidayGroup}"
														itemValue="holidayGrpId" itemLabel="holidayGrpName" />
												</form:select>
											</div>
										</div>

									</div>

									<div class="row">

										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Holiday Start Date</label> <input
													class="form-control" name="holidayStartDate"
													id="holidayStartDate" placeholder="" autocomplete="off"
													value="${startDate}">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Holiday End Date</label> <input
													class="form-control" name="holidayEndDate"
													id="holidayEndDate" placeholder="" autocomplete="off"
													value="${endDate}">
											</div>
										</div>

									</div>

									<div class=" mt-3">
										<a class="btn btn-outline-danger" href="/holidayDetails"><i
											class="fa fa-close"></i> Cancel</a> &nbsp; <a
											class="btn btn-danger" href="#"
											onclick="updateHoliDayDetails(${holidayList.hcId})"><i
											class="fa fa-save"></i> Save</a>
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


<script>

/* Date picker holiday Start Date */
$('#holidayStartDate').datepicker({
	minDate: new Date(),
	uiLibrary: 'bootstrap4',
	iconsLibrary: 'fontawesome',
	format: 'dd-mm-yyyy'
});
/* Date picker holiday Start Date */

/* Date picker holiday End Date */
$('#holidayEndDate').datepicker({
	minDate: new Date(),
	uiLibrary: 'bootstrap4',
	iconsLibrary: 'fontawesome',
	format: 'dd-mm-yyyy'
});
/* Date picker holiday End Date */

</script>