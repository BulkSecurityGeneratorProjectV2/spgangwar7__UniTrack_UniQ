
<%@ include file="/WEB-INF/includes/include.jsp" %>
<form name="mang" id="mang">

    
 

<div class="wrapper">
	<div class="main_part_outer" id="content" style="
    padding-top: 8px;">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<script src="https://code.highcharts.com/highcharts.js"></script>
				<script src="https://code.highcharts.com/modules/data.js"></script>
				<script src="https://code.highcharts.com/modules/drilldown.js"></script>
				<script src="https://code.highcharts.com/modules/exporting.js"></script>
				<script src="https://code.highcharts.com/modules/export-data.js"></script>
             
                <div class="row">
     
       <!-- ./col -->
       
    </div>
               

				<div class="row">
					<div class="col-md-12">
					<div class="content_box">
					<div class="box-body">
						<div id="container" style="width:100%; margin: 0 auto"></div>
					</div>
					</div>
				</div>
				</div>

				
				<div class="row">


					<div class="col-md-6">
						<div class="content_box">
							<div class="box-body">


								<div id="containerpie" style="min-width: 310px; max-width: 600px; height: 400px; margin: 0 auto"></div>


							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="content_box">
							<div class="box-body">


								<div id="containerbar" style="min-width: 300px; height: 400px; margin: 0 auto"></div>


							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
</div>
</div></div></div>
</form>
<div class="row">
<div class="col-md-12">
<div class="content_box">
 <div class="box-body">
   <div id="contauth" style="min-width: 500px; height: 400px; margin: 0 auto"></div>
	</div>
	</div>
</div>
</div>
<script>

//Create the chart


var cb = ${deliveryDetailsGraph};

Highcharts.chart('container', {

    chart: {
        type: 'column'
    },
    title: {
        text: 'Delivery status with due date'
    },
    subtitle: {
        text: 'Click the columns to view Book Details.'
    },
    xAxis: {
        type: 'category'
    },
    yAxis: {
        title: {
            text: 'Total Chapter Pending'
        }

    },
    legend: {
        enabled: false
    },
    plotOptions: {
        series: {
            borderWidth: 0,
            dataLabels: {
                enabled: true,
               
            }
        }
    },
    credits:{
   	 enabled:false,
   	},

    series: [
        {
            name: "chapter Deliveries(chapter Count)",
            colorByPoint: true,
            data: [
                {
                    name: "Today",
                    y: cb,
                    drilldown: "Today"
                }
                
            ]
        }
    ],
    drilldown: {
        series: [
            {
                name: "Today",
                id: "Today",
                data: [<c:forEach items="${deliveryDetailsJournal}" var="entry">
                    [
                        "${entry.journalName}",
                        ${entry.count}
                         


                    
                      
                    ], </c:forEach>
                ]
            }
          
        ]
    }
});

</script>
<script>

var hour = ${hourRecord};
switch (hour) {
case 13:
    hour = "1 PM";
    break;
case 14:
    hour = "2 PM";
    break;
   case 15:
    hour = "3 PM";
    break;
    case 16:
    hour = "4 PM";
    break;
    case 17:
    hour = "5 PM";
    break;
    case 18:
    hour = "6 PM";
    break;
    case 19:
        hour = "7 PM";
        break;
    case 20:
        hour = "8 PM";
        break;
    case 21:
        hour = "9 PM";
        break;
    case 22:
        hour = "10 PM";
        break;
    case 23:
        hour = "11 PM";
        break;
    case 00:
        hour = "12 PM";
        break;
    case 01:
        hour = "1 AM";
        break;
    case 02:
        hour = "2 AM";
        break;
    case 03:
        hour = "3 AM";
        break;
    case 04:
        hour = "4 AM";
        break;
    case 05:
        hour = "5 AM";
        break;
    case 06:
        hour = "6 AM";
        break;
    case 07:
        hour = "7 AM";
        break;
    case 08:
        hour = "8 AM";
        break;
    case 09:
        hour = "9 AM";
        break;
    case 10:
        hour = "10 AM";
        break;
    case 11:
        hour = "11 AM";
        break;
   
        
  
}

var count=${articleCount};
Highcharts.chart('containerbar', {
	
    chart: {
        type: 'column'
    },
    title: {
        text: 'Hour wise chapter delivered last 24HRs'
    },
    subtitle: {
        text: 'Production tracking for client Demo publication'
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
            text: 'Population (millions)'
        }
    },
    legend: {
        enabled: false
    },
    tooltip: {
        pointFormat: 'chapter delivered(Count): <b>{point.y} </b>'
    },
    credits:{
    	 enabled:false,
    	},
    series: [{
        name: 'Population',
        data: [
            [hour, count]
        ],
        dataLabels: {
            enabled: true,
            rotation: -90,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y}', // one decimal
            y: 10, // 10 pixels down from the top
            style: {
                fontSize: '10px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    }]
});


</script>

<script>
//var record = ${supplierPendingTargetsVo};

Highcharts.chart('containerpie', {
    chart: {
        type: 'pie'
    },
    title: {
        text: 'supplier Pending targets(Today)'
    },
    subtitle: {
        text: 'Click the slices to view pending chapter count for each supplier'
    },
    plotOptions: {
        series: {
            dataLabels: {
                enabled: true,
                format: '{point.name}: {point.y:f}'
            }
        }
    },

    tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> of total<br/>'
    },

    series: [
        {
            name: "supplier",
            colorByPoint: true,
            data: [<c:forEach items="${supplierPendingTargetsVo}" var="entry">
                {

                 
                    name: "${entry.journalName}",
                    y: ${entry.count},
                    drilldown: "${entry.journalName}"
                },
                </c:forEach>
               
            ]
        }
    ],
    credits:{
    	 enabled:false,
    	},
    drilldown: {
        series: [
            {<c:forEach items="${supplierPendingTargetsVo}" var="entry">
                name: "${entry.journalName}",
                id: "${entry.journalName}",
                </c:forEach>
                data: [
                    [
                        "Book A",
                        0.1,
                        "Book B",
                        0.1
                    ]
                   
                  
                ]
            }
          
        ]
    }
});

</script>

<script type="text/javascript">
function showproject(){
		document.getElementById("mang").action="/viewdashboard";
		document.getElementById("mang").method="POST";
		document.getElementById("mang").submit();
	}


// function getDptName(){

// 	var deprtId = document.getElementById("deptID").value;
// 	var selectBox = document.getElementById(deptID);
// 	 var selectedValue = selectBox.options[selectBox.selectedIndex].value;
// alert(deprtId  +"sgdf :"+ selectedValue);
// 	var mappingJSON = {};
// 	mappingJSON["deptID"] = deprtId;
// 	var mappingInfo = JSON.stringify(mappingJSON);
// 	$.ajax({
// 		url : '/getDptName',
// 		type : "POST",
// 		data : mappingInfo,
// 		contentType : "application/json; charset=utf-8",
// 		dataType : "json",
// 		cache : false,
// 		success : function(result) {
// 			alert(result);
// 		},
// 		error : function(e) {
// 			console.log(e.message);
// 		}
// 	});
// }
</script>



<script>
Highcharts.chart('contauth', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Stats For Author Proof'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} '
            }
        }
    },
    series: [{
        name: 'Brands',
        colorByPoint: true,
        data: [{
            name: 'article delivered',
            y: 51.41,
            sliced: true,
            selected: true
        }, {
            name: 'Article In Progress',
            y: 11.84
        }, {
            name: 'Article Not Opened',
            y: 5.61
        }]
    }]
});

</script>
    
<!--Main_part_end-->

