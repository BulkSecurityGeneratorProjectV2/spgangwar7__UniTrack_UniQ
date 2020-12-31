//Create the chart
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
             text: 'Total Article Pending'
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

  /*   tooltip: {
         headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
         pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
     },*/

     series: [
         {
             name: "Article Deliveries(chapter Count)",
             colorByPoint: true,
             data: [
                 {
                     name: "Today",
                     y: 27,
                     drilldown: "Today"
                 },
                 {
                     name: "Yesterday",
                     y: 8,
                     drilldown: "Yesterday"
                 },
                 {
                     name: "More than 5 days",
                     y: 7,
                     drilldown: "More than 5 days"
                 },
                 {
                     name: "More than 15 days",
                     y: 5,
                     drilldown: "More than 15 days"
                 }
             ]
         }
     ],
     drilldown: {
         series: [
             {
                 name: "Today",
                 id: "Today",
                 data: [
                     [
                         "Journal A",
                         15
                     ],
                     [
                         "Journal B",
                         10
                     ],
                     [
                         "Journal C",
                         2
                     ]
                 ]
             },
             {
                 data: [
                     [
                         "Journal A",
                         6
                     ],
                     [
                         "Journal B",
                         1
                     ],
                     [
                         "Journal C",
                         1
                     ]
                 ]
             },
             {
                 name: "More than 5 days",
                 id: "More than 5 days",
                 data: [
                     [
                         "Journal A",
                         3
                     ],
                     [
                         "Journal B",
                         2
                     ],
                     [
                         "Journal C",
                         2
                     ]
                 ]
             },
             {
                 name: "More than 15 days",
                 id: "More than 15 days",
                 data: [
                     [
                         "Journal A",
                         1
                     ],
                     [
                         "Journal B",
                         2
                     ],
                     [
                         "Journal C",
                         2
                     ]
                 ]
             }
         ]
     }
 });
 