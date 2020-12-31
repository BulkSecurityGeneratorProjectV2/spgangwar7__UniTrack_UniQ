 <%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
					<!--main_tittle-->
					<div class="row">
						<div class="col-md-6">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Create Publisher</span> <span id="Date"></span>
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
								<form id="publishers" name="publishers">
									<div class="box-body">

									<div class="row">

										<div class="col-md-3">
											<div class="form-group">
												<label for="currency">Publisher Name <sup
													class="text-red">&lowast;</sup></label> <input type="text"
													class="form-control" name="publisherName" required
													id="publisherName" placeholder="" autocomplete="off">
											</div>
										</div>

										<div class="col-md-3">
											<div class="form-group">
												<label for="Countrylist">Country <sup
													class="text-red">&lowast;</sup></label>
												
												<form:select path="countryList"  id="countryID" name="countryID"  onchange="getState()" class="form-control">
												  <form:option value = "Please Select" labelValue = ""/>
												  <form:options items = "${countryList}" itemValue="countryID" itemLabel="countryName" />
												 </form:select> 
											</div>
										</div>
										
										
										
										
										<div class="col-md-3">
											<div class="form-group">
						                  <label for="Statelist">State</label>
						                    <select class="form-control" name="state" id="state" onchange="getCity()" >
						                 <option value="">Select country first</option>
						                      </select> 
						                 </div>
										</div>
										<div class="col-md-3">

											<div class="form-group">
												<label for="cityList">City</label> <select
												class="form-control" name="city" id="city">
													<option value="">Select State first</option>
												</select>
											</div>
										</div>
									</div>



									

								
								</div>
								<div class="box-footer text-right">
									<div>
										<a class="btn btn-outline-danger" href="${context}/publisherDetails"><i class="fa fa-close"></i> Cancel</a> &nbsp;
										<a class="btn btn-danger" href="#" onclick="saveNewPublisher()"><i class="fa fa-save"></i> Save</a>
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
	
<script type="text/javascript">
function getState(){
	var countryId=document.getElementById("countryID").value;
	
	
    $.ajax({
		type : 'GET',
		url : '<%=request.getContextPath()%>/state-List-' + countryId,
				
		success : function(data) {
			var stateList = data.payload;
			$('#state').empty();
			//debugger;
			stateList.forEach(function(x, index){
				// alert(x.stateName); 
				
				var str = '<option value="'+x.id+'">'+x.statename+'</option>';
				$('#state').append(str);
				
			});
			
		},
	
		error : function() {
			alert("error while getting state list.");
		}
	});

}


function getCity(){
	var state=document.getElementById("state").value;
	
	
    $.ajax({
		type : 'GET',
		url : '<%=request.getContextPath()%>/city-List-' + state,
				
		success : function(data) {
			var stateList = data.payload;
			$('#city').empty();
			stateList.forEach(function(x, index){
				var str = '<option value="'+x.id+'">'+x.cityname+'</option>';
				$('#city').append(str);
				
			});
			
		},
	
		error : function() {
			alert("error while getting state list.");
		}
	});

}

	
</script>	
	
<script>
	function validate(){
	
	var publisherName=document.getElementById("publisherName").value;
	//var cityName=document.getElementById("cityName").value;
	var countryID=document.getElementById("countryID").value;
	$("#publisherName").css("color", "black");
	
	if(publisherName==''){
		alert("Publisher Name cannot be blank.");
		return false;
	}
	if (!/^[a-zA-Z ]*$/g.test(publisherName)) {
		alert("Enter valid name");
		$("#publisherName").css("color", "red");
		return false;
	}
// 	if(cityName==''){
//  		alert("City Name cannot be blank.");
//  		return false;
//  	}

	if(countryID=='Please Select'){
 		alert("Country cannot be blank.");
 		return false;
 	}
	
	return true;
}
</script>	