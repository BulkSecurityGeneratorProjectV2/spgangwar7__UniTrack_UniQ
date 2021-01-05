<%@ include file="/WEB-INF/includes/include.jsp"%>


<style>
#container {
	height: 400px;
}

.highcharts-figure, .highcharts-data-table table {
	min-width: 310px;
	max-width: 800px;
	margin: 1em auto;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #EBEBEB;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}

.highcharts-data-table caption {
	padding: 1em 0;
	font-size: 1.2em;
	color: #555;
}

.highcharts-data-table th {
	font-weight: 600;
	padding: 0.5em;
}

.highcharts-data-table td, .highcharts-data-table th,
	.highcharts-data-table caption {
	padding: 0.5em;
}

.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even)
	{
	background: #f8f8f8;
}

.highcharts-data-table tr:hover {
	background: #f1f7ff;
}
</style>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<form name="mang" id="mang">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<button type="button" onclick="downloadExcel()"
				class="btn btn-dark btn-sm float-right ml-2">Download WIP
				Report</button>
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-6">
						<div class="main_tittle">
							Total <spring:message code="chapters.articles" /><span id="Date">Wednesday , 21
								November 2018</span>
						</div>
						<label></label>
						<button type="button" class="btn btn-info btn-sm mt-3"
							onclick="articleRejected()">Download Withdraw <spring:message code="chapters.articles" /></button>
						<button type="button" class="btn btn-info btn-sm mt-3"
							onclick="masterReports()">Master Reports</button>
					</div>
					<div class="col-md-6">
						<div class="box-body">

							<div class="row">
								<div class="col-md-4">
									<label for="ExpertiseLevel">Select Role Name </label>
									<div class="form-group">

										<form:select path="roleDetails" id="roleID" name="roleID"
											class="custom-select">
											<form:option value="Please Select" labelValue="" />
											<form:options items="${roleDetails}" itemValue="roleID"
												itemLabel="roleName" />
										</form:select>
									</div>
								</div>
								<input type="hidden" name="userID" id=userID>
								<div class="col-md-6">
									<div class="" id="userlist"></div>

								</div>
								<div class="">
									<div class="form-group">

										<button type="button" class="btn btn-info text-white"
											style="margin-top: 23px;" onclick="downloadExcelUser()">Download</button>
										<!-- 										<a -->
										<!-- 											class="btn btn-info text-white" href="#" -->
										<!-- 											onclick="downloadExcelUser()">Download</a> -->
									</div>
								</div>
							</div>

						</div>
					</div>

					<div class="wrapper">
						<div class="main_part_outer" id="content"
							style="padding-top: 8px;">
							<div class="d-flex flex-column w-100 h-100">
								<div class="container-fluid">
									<div class="row">
										<section class=col-md-4>
											<section>
												<label>Total Pages In <spring:message code="chapter.article" />:</label> ${totalPage}
												<!-- 	<button type="button" class=" btn-info text-white" style="margin-top: 23px;"
											onclick="articleRejected()">Rejected Article</button> -->
											</section>

											<div id="container"></div>
										</section>
										<div class=" col-md-8 box-body bg-white">

											<div id="container1"></div>
										</div>

									</div>

								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>

<script>Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    credits: {
        enabled: false
    },
    title: {
        text: 'Total Subject'
    },
    subtitle: {
        text: ''
    },
    xAxis: {
        type: 'category',
        labels: {
            rotation: -45,
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: '<spring:message code="chapters.articles" /> '
        }
    },
    legend: {
        enabled: false
    },
    tooltip: {
       
    },
    series: [{
        name: 'Total Numbers',
        data: [
            ['Total <spring:message code="chapters.articles" />', ${totalArticle}],
            ['Rejected <spring:message code="chapters.articles" />', ${statusRejectCount}],
            ['Total Noms', ${totalIssue}]
          
        ],
        dataLabels: {
            enabled: true,
            rotation: -5,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y}', // one decimal
            y: 10, // 10 pixels down from the top
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    }]
});
</script>


<script type="text/javascript">
Highcharts.chart('container1', {
    chart: {
        type: 'column'
    },
    credits: {
        enabled: false
    },
    title: {
        text: 'Uni-Track Productivity'
    },
    subtitle: {
        text: 'Uni-Track system'
    },
    xAxis: {
        type: 'category',
        labels: {
            rotation: -45,
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    },
    yAxis: {
    tickInterval: 1,
        title: {
            text: 'Subject Delivered(No. Of Subject)'
        }, 
        min: 0,
      
    },
    legend: {
        enabled: false
    },
    tooltip: {
        pointFormat: 'Subject Delivered on : <b>{point.y} Subject</b>'
    },
    series: [{
        name: 'Subject',
        data: [  
          
        	<c:forEach items="${productivityTask}" var="map">
          
              [' ${map.date}' ,  ${map.count}],
              
       		 </c:forEach> 
           
        ],
        dataLabels: {
            enabled: true,
            rotation: -5,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y}', // one decimal
            y: 10, // 10 pixels down from the top
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    }]
});
</script>

<script>
function downloadExcel() {
	debugger;
 //   alert("Cryeae");
	
	document.getElementById("mang").action = "WipUserAdmin";
	document.getElementById("mang").method = "GET";
	document.getElementById("mang").submit();	
}
</script>
<script type="text/javascript">

	$('#roleID').on('change', function(e) {
		e.preventDefault();
		//var selectBox = document.getElementById("deptID");
		//var selectedValue = selectBox.options[selectBox.selectedIndex].value;
		var selectBox =$("#roleID").val();  //new methord for jquery value 		
		var roleId = this.value;
		//alert(roleId);
		var mappingJSON = {};
		mappingJSON["roleId"] = roleId;
		var mappingInfo = JSON.stringify(mappingJSON);
		$.ajax({
			url : '${context}/getuserListByroleID',
			type : "POST",
			data : mappingInfo,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			cache : false,
			success : function(result) {
				//alert(result);
				$('#userlist').html(result.responseText);
			},
			error : function(e) {
				console.log(e.message);
			}
		});
	});

</script>

<script>
function validate(){
	
	var roleID=document.getElementById("roleID").value;

	if(roleID=='Please Select'){
		alert("Please select a Role Name");
		return false;
	}

	if(document.getElementById("userrole").value == 'Select User ...'){
		alert("Please select an user");
		return false;
	}
	
	return true;
    }
function downloadExcelUser() {
	debugger;
	if(validate()){
 //   alert("Cryeae");
			var userId = document.getElementById("userrole").value;
	//alert(userId);
	document.getElementById("userID").value = userId;

	document.getElementById("mang").action = "WipUserWise";
	document.getElementById("mang").method = "GET";
	document.getElementById("mang").submit();	
}
	}
	
function articleRejected() {
	debugger;

	document.getElementById("mang").action = "articleRejected";
	document.getElementById("mang").method = "GET";
	document.getElementById("mang").submit();	
	}
	
function masterReports() {
	debugger;

	document.getElementById("mang").action = "masterReports";
	document.getElementById("mang").method = "GET";
	document.getElementById("mang").submit();	
	}
	
</script>