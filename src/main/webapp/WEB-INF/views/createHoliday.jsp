
<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-6">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Create New Holiday</span> <span id="Date"></span>
						</div>
					</div>
					<div class="col-md-6">
						<label class="mandatoryMsg">All <sup class="text-red">(&lowast;)</sup> marked fields are mandatory</label> 
						</div>
				</div>
				<!--main_tittle_End-->


				<div class="row ">
					<div class="col-md-12 ">
						<div class="content_box">
							<div class="box-body">
								<form id="holidays" name="holidays">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Holiday Name <sup class="text-red">&lowast;</sup></label> <input
													type="text" class="form-control" name="holidayName" required
													id="holidayName" placeholder="" autocomplete="off">
											</div>
										</div>
										
										<div class="col-md-6">
											<div class="form-group" id="holidayGroup">
												<label for="ExpertiseLevel">Holiday Group <sup class="text-red">&lowast;</sup></label>
												<form:select path="holidayGroup" id="hgId"
													name="hgId" class="form-control">
													<form:option value="Please Select" labelValue="" />
													<form:options items="${holidayGroup}" itemValue="holidayGrpId"
														itemLabel="holidayGrpName" />
												</form:select>
											</div>
										</div>


									</div>

									<div class="row">

										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Holiday Start Date <sup class="text-red">&lowast;</sup></label> <input
													class="form-control" name="holidayStartDate" required
													id="holidayStartDate" placeholder="" autocomplete="off">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="currency">Holiday End Date <sup class="text-red">&lowast;</sup></label> <input
													class="form-control" name="holidayEndDate" required
													id="holidayEndDate" placeholder="" autocomplete="off">
											</div>
										</div>
									</div>

									<div class=" mt-3">
										<a class="btn btn-outline-danger" href="/holidayDetails"><i
											class="fa fa-close"></i> Cancel</a> &nbsp; <a
											class="btn btn-danger" href="#" onclick="saveNewHoliday()"><i
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


function validate(){
	
	var holidayName=document.getElementById("holidayName").value;
	var hgId=document.getElementById("hgId").value;
	var holidayStartDate=document.getElementById("holidayStartDate").value;
	var holidayEndDate=document.getElementById("holidayEndDate").value;
	
	if(holidayName==''){
		alert("Holiday Name cannot be blank.");
		return false;
	}	
	if(hgId=='Please Select'){
 		alert("Holiday Group cannot be blank.");
 		return false;
 	}
	if(holidayStartDate==''){
		alert("Holiday Start Date cannot be blank.");
		return false;
	}	
	if(holidayEndDate==''){
 		alert("Holiday End Date cannot be blank.");
 		return false;
 	}
	
	return true;
}

</script>

