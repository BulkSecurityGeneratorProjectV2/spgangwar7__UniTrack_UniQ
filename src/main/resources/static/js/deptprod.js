Highcharts.chart('container', {
    chart: {
        type: 'spline'
    },

    accessibility: {
        description: 'Supplier wise production tracking for last 6 months'
    },

    legend: {
        symbolWidth: 40
    },

    title: {
        text: 'Supplier wise production tracking for last 6 months'
    },

   

    yAxis: {
        title: {
            text: 'Percentage usage'
        }
    },

    xAxis: {
        title: {
            text: 'Time'
        },
        accessibility: {
            description: 'Time from January March 2019 to August 2019'
        },
        categories: ['March 2019', 'April 2019', 'May 2019', 'June 2019', 'July 2019','August 2019']
    },

    tooltip: {
        split: true
    },

    plotOptions: {
        series: {
            point: {
                events: {
                    click: function () {
                        window.location.href = this.series.options.website;
                    }
                }
            },
            cursor: 'pointer'
        }
    },

    series: [
        {
            name: 'Copy Editing',
            data: [74, 69.6, 63.7, 63.9,81.9, 43.7],
            
        }, {
            name: 'Type-setting',
            data: [80, 74.8, 43.0, 51.2,65.4, 41.4],
            dashStyle: 'Dot'
        }, {
            name: 'Master Editing',
            data: [60, 82.2, 65.7, 76.8, 83.4,30.9],
            dashStyle: 'ShortDot',
            color: Highcharts.getOptions().colors[7]
        }, {
            name: 'Graphics',
            data: [93, 79.0, 80.7, 73.9,67.8, 29.6],
            dashStyle: 'Dash',
            color: Highcharts.getOptions().colors[0]
        }, {
            name: '3B2',
            data: [60, 66.1, 66.8, 75.3,69.7, 27.5],
            dashStyle: 'ShortDashDot',
            color: Highcharts.getOptions().colors[8]
        }, {
            name: 'Pagination',
            data: [70, 76.2, 72.1, 76.2, 75.5,66.9],
            website: 'https://www.satogo.com',
            dashStyle: 'ShortDash',
            color: Highcharts.getOptions().colors[1]
        }, {
            name: 'Final QC',
            data: [90, 90, 92.8, 94.8,90.6, 82.8],
            dashStyle: 'DotDash',
            color: Highcharts.getOptions().colors[4]
        }
    ],

    responsive: {
        rules: [{
            condition: {
                maxWidth: 500
            },
            chartOptions: {
                legend: {
                    itemWidth: 150
                }
            }
        }]
    }
});
