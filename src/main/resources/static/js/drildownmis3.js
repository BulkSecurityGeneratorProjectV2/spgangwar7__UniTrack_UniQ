Highcharts.chart('containerbar', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Hour wise Article delivered last 24HRs'
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
        pointFormat: 'Article delivered(Count): <b>{point.y} </b>'
    },
    credits:{
    	 enabled:false,
    	},
    series: [{
        name: 'Population',
        data: [
            ['8 AM', 24],
            ['9 AM', 20],
            ['10 AM', 14],
            ['11 AM', 18],
            ['12 AM', 13],
            ['1 PM', 12],
            ['2 PM', 22],
            ['3 PM', 15],
            ['4 PM', 02],
            ['5 PM', 17],
            ['6 PM', 15],
            ['7 PM', 13],
            ['8 PM', 12],
            ['9 PM', 19],
            ['10 PM', 12],
            ['11 PM', 22],
            ['12 PM', 15],
            ['1 AM', 18],
            ['2 AM', 10],
            ['3 AM', 11],
            ['4 AM', 10],
            ['5 AM', 13],
            ['6 AM', 12],
            ['7 AM', 11]
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