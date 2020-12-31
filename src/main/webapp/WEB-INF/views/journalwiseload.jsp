
<%@ include file="/WEB-INF/includes/include.jsp" %>
<form name="mang" id="mang">

    
 

<div class="wrapper">
	<div class="main_part_outer" id="content" style="
    padding-top: 58px;">
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
               

<div class="row mrgTop">
<div class="col-md-12">
<div class="content_box">
 <div class="box-body">
 <div class="row ">
    
    </div>
   <div id="container" style="min-width: 500px; height: 400px; margin: 0 auto"></div>
   </div>
	</div>
	
	
</div>
</div>
</div>
</div>
</div>
</div>
<script>
Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Journal Wise Load - Intermediate proof'
    },
    xAxis: {
        categories: [
            'Journal 1',
            'Journal 2',
            'Journal 3',
            'Journal 4',
            'Journal 5',
            'Journal 6',
            'Journal 7',
            'Journal 8',
            'Journal 9',
            'Journal 10',
            'Journal 11',
            'Journal 12'
          
        ],
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: 'No. of Articles'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: [{
        name: 'Load',
        data: [3, 2, 3, 2, 1, 2, 2, 1, 8, 0,0, 2]

    }, {
        name: 'Overdue',
        data: [0, 0, 2, 1, 1, 0, 1, 0, 0, 1, 1, 3]

    },  {
        name: 'Query',
        data: [2, 0, 1, 0, 0, 1, 2, 2, 1, 2, 1, 0]

    }]
});

</script>
</form>

