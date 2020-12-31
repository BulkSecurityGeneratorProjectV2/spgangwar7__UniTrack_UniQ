// Create the chart
Highcharts.chart('containerpie', {
    chart: {
        type: 'pie'
    },
    title: {
        text: 'Supplier Pending targets(Today)'
    },
    subtitle: {
        text: 'Click the slices to view pending chapter count for each supplier'
    },
    plotOptions: {
        series: {
            dataLabels: {
                enabled: true,
                format: '{point.name}: {point.y:.1f}%'
            }
        }
    },

    tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
    },

    series: [
        {
            name: "supplier",
            colorByPoint: true,
            data: [
                {
                    name: "Supplier A",
                    y: 62.74,
                    drilldown: "TypeSetting"
                },
                {
                    name: "Supplier B",
                    y: 10.57,
                    drilldown: "Copy Editing"
                },
                {
                    name: "Supplier C",
                    y: 7.23,
                    drilldown: "Final QC"
                },
                {
                    name: "Supplier D",
                    y: 5.58,
                    drilldown: "Master Editing"
                },
                {
                    name: "Supplier E",
                    y: 4.02,
                    drilldown: "Graphics"
                },
                {
                    name: "Supplier F",
                    y: 1.92,
                    drilldown: "Pagination"
                },
                {
                    name: "Supplier XYZ",
                    y: 7.62,
                    drilldown: null
                }
            ]
        }
    ],
    credits:{
    	 enabled:false,
    	},
    drilldown: {
        series: [
            {
                name: "TypeSetting",
                id: "TypeSetting",
                data: [
                    [
                        "Journal A",
                        0.1
                    ],
                    [
                        "Journal b",
                        1.3
                    ],
                    [
                        "Journal c",
                        53.02
                    ],
                    [
                        "Journal D",
                        1.4
                    ],
                    [
                        "Journal E",
                        0.88
                    ],
                    [
                        "Journal f",
                        0.56
                    ]
                  
                ]
            },
            {
                name: "Copy Editing",
                id: "Copy Editing",
                data: [
                	 [
                         "Journal A",
                         0.1
                     ],
                     [
                         "Journal b",
                         1.3
                     ],
                     [
                         "Journal c",
                         5.02
                     ],
                     [
                         "Journal D",
                         1.4
                     ],
                     [
                         "Journal E",
                         0.88
                     ],
                     [
                         "Journal f",
                         1.56
                     ]
                ]
            },
            {
                name: "Final QC",
                id: "Final QC",
                data: [
                	 [
                         "Journal A",
                         0.1
                     ],
                     [
                         "Journal b",
                         1.3
                     ],
                     [
                         "Journal c",
                         3.02
                     ],
                     [
                         "Journal D",
                         1.4
                     ],
                     [
                         "Journal E",
                         0.88
                     ],
                     [
                         "Journal f",
                         0.56
                     ]
                ]
            },
            {
                name: "Master Editing",
                id: "Master Editing",
                data: [
                	 [
                         "Journal A",
                         0.1
                     ],
                     [
                         "Journal b",
                         1.3
                     ],
                     [
                         "Journal c",
                         2.02
                     ],
                     [
                         "Journal D",
                         1.4
                     ],
                     [
                         "Journal E",
                         0.88
                     ],
                     [
                         "Journal f",
                         0.56
                     ]
                ]
            },
            {
                name: "Graphics",
                id: "Graphics",
                data: [
                	 [
                         "Journal A",
                         0.1
                     ],
                     [
                         "Journal b",
                         1.3
                     ],
                     [
                         "Journal c",
                         1.02
                     ],
                     [
                         "Journal D",
                         1.4
                     ],
                     [
                         "Journal E",
                         0.88
                     ],
                     [
                         "Journal f",
                         0.56
                     ]
                ]
            },
            {
                name: "Pagination",
                id: "Pagination",
                data: [
                    [
                        "Journal abc",
                        0.96
                    ],
                    [
                        "Journal xy",
                        0.82
                    ],
                    [
                        "Journal Z",
                        0.14
                    ]
                ]
            }
        ]
    }
});