
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
 <div class="row">
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
        text: 'Aritlce Rejections - No. of Rounds (Journal)'
    },
    xAxis: {
        categories: [
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            '10',
            '11'
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
        name: 'Jan 19',
        data: [19, 11, 23, 23, 14, 17, 6, 5, 2, 1, 9, 4]

    }, {
        name: 'Feb 19',
        data: [45, 50, 25, 52, 16, 4, 10, 0, 9, 8, 6, 3]

    }, {
        name: 'Mar 19',
        data: [40, 20, 39, 50, 47, 8, 0, 5, 5, 6, 5, 2]

    }, 
    {
        name: 'Apr 19',
        data: [25, 35, 37, 11, 47, 3, 9, 5, 5, 6, 5, 2]

    },
    {
        name: 'May 19',
        data: [29, 38, 39, 41, 7, 3, 0, 5, 4, 2, 5, 1]

    },
    {
        name: 'June 19',
        data: [30, 33, 43, 42, 17, 4, 0,6, 4, 2, 3, 5]

    },
    {
        name: 'July 19',
        data: [45, 37, 27, 25, 27, 4, 0, 5, 5, 2, 3, 2]

    },
    {
        name: 'Aug 19',
        data: [51, 38, 32, 21, 42, 3, 0, 6, 4, 2, 3, 2]

    },{
        name: 'Sept 19',
        data: [48, 33, 34, 39, 50, 5, 4, 4, 6, 1, 8, 1]

    }]
});
</script>
</form>

