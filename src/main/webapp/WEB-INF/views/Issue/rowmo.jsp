<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/includes/include.jsp"%>

<head>

<!--drag- drop  script start--> 
  <script src="http://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="http://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>		
	<script
		src="http://cdn.datatables.net/rowreorder/1.2.0/js/dataTables.rowReorder.min.js"></script>
   <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/rowreorder/1.2.0/css/rowReorder.dataTables.min.css"/>
<!--   -->

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables_themeroller.css">
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/jquery.dataTables.min.js"></script>
<!--  <link rel="stylesheet" href="style.css" />
    <script src="script.js"></script> -->
<style>
table.dataTable tbody tr.selected {
	background-color: #b0bed9;
}

table.dataTable.display tbody tr.odd.selected>.sorting_1, table.dataTable.order-column.stripe tbody tr.odd.selected>.sorting_1
	{
	background-color: #a6b3cd;
}

table.dataTable.display tbody tr:hover.selected>.sorting_1, table.dataTable.display tbody tr.odd:hover.selected>.sorting_1,
	table.dataTable.display tbody tr.even:hover.selected>.sorting_1, table.dataTable.order-column.hover tbody tr:hover.selected>.sorting_1,
	table.dataTable.order-column.hover tbody tr.odd:hover.selected>.sorting_1,
	table.dataTable.order-column.hover tbody tr.even:hover.selected>.sorting_1
	{
	background-color: #a1aec7;
}
</style>
<style>
table {
	counter-reset: tableCount;
}

.sorting_1:before {
	content: counter(tableCount);
	counter-increment: tableCount;
}
</style>
<script>
	// Code goes here
	$(document).ready(function() {
		var stockTable = $('#table1').dataTable({
			"aoColumnDefs": [
				 { "sClass": "sorting_1" }
				 ]
		
		}); // first table 

		var catalogTable = $('#table2').dataTable({
			  rowReorder: {
			      dataSrc: 'order',
			      selector: 'tr'
			    },
			"aoColumnDefs": [
				 { "sClass": "sorting_1" },
			   //   { "sClass": "sorting_1", "aTargets": [ 0 ] },
			      { "sClass": "textEdit", "aTargets": [ 4 ] },
			      { "sClass": "textEdit", "aTargets": [ 5 ] }
			    ]
		
		}); // Second table 
	
		stockTable.on('click', 'tbody tr', function() {
			$(this).toggleClass('selected');
		});
		catalogTable.on('click', 'tbody tr', function() {
			$(this).toggleClass('selected');
		});

		catalogTable
        .on( 'postCreate postRemove', function () {
            // After create or edit, a number of other rows might have been effected -
            // so we need to reload the table, keeping the paging in the current position
            table.ajax.reload( null, false );
        } )
        .on( 'initCreate', function () {
            // Enable order for create
            editor.field( 'readingOrder' ).enable();
        } )
        .on( 'initEdit', function () {
            // Disable for edit (re-ordering is performed by click and drag)
            editor.field( 'readingOrder' ).disable();
        } );
		$('#LeftMove').on('click', function() {
			moveRows(catalogTable, stockTable);
		});

		$('#RightMove').on('click', function() {
			moveRows(stockTable, catalogTable);
		});

		 $('#add-service-button').click(function () { 		
					
			 var rowNode =  $('#table2').dataTable().fnAddData([" ", $("#issueId").val(), $("#issueTitle").val(),$("#pageNo").val(), '0', '0','0','0', "<a class='del-service' href='#' title='Click to remove this entry'>Remove</a>", "<input type='file' name='files' id='files' multiple  required>","<i class='fa fa-arrow-up up'aria-hidden='true'></i> <i class='fa fa-arrow-down down' aria-hidden='true'></i>" ] );
		});
		 
	});

	function moveRows(fromTable, toTable) {
	//	debugger;	
		var $row = fromTable.find(".selected");
	//	var $roww = toTable.find(".selected");
		$.each($row, function(k, v) {
			if (this !== null) {
				addRow = fromTable.fnGetData(this);
				toTable.fnAddData(addRow);
				fromTable.fnDeleteRow(this);
			//	 $row.addClass('counterCell')
			}
		});
	}
</script>
</head>

<body>
	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid" id="mainhide">
					<!--main_tittle-->
					<c:if test="${not empty message}">
						<div class="alert alert-${css} alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<strong> ${message}</strong>
						</div>
					</c:if>
					<div class=" alert-info">
						<div class="row">
							<div class="col-sm-6 col-md-6">
								<div class="form-group col">
									<label class="art-left">Journal Name </label><input
										type="hidden" value="${journal.journalId}" id="jrId">
									<span class="form-control bg-light title-right title-right">${journal.journalName}</span>
								</div>
							</div>
							<div class="col-sm-6 col-md-6">
								<div class="form-group col">
									<label class="art-left">Workflow Name </label><input
										type="hidden" value="${workflow.id}" id="wrkfId"> <span
										class="form-control bg-light title-right">${workflow.name}</span>
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-sm-4 col-md-4">
								<div class="form-group col">
									<label class="art-left">Issue Title</label><input type="hidden"
										value="${issueData.issue_id}" id="isuId"> <span
										class="form-control bg-light title-right">${issueData.issue_title}</span>
								</div>
							</div>
							<div class="col-sm-4 col-md-4">
								<div class="form-group col">
									<label class="art-left">Volume Number </label> <span
										class="form-control bg-light title-right">${issueData.last_volume_number}</span>
								</div>
							</div>
							<div class="col-sm-4 col-md-4">
								<div class="form-group col">
									<label class="art-left">Volume Year</label><span
										class="form-control bg-light title-right">${issueData.volume_year}</span>
								</div>
							</div>

						</div>
					</div>

					<table class="dataTable table" id="table1">
						<thead>
							<tr>
								<th>S.no</th>
								
								<th>Aid</th>
								<!-- <th>Article id</th> -->
								<th>Article title</th>
								<th>Pages</th>
								<th>Color Image</th>
								<th>BW Image</th>
								<th>tbc</th>
								<th>tbc</th>
								<th>Article DOI</th>
								<th>Article status</th>
							<th>Up || Down</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="temp" items="${ArticleDetail}"
								varStatus="counter">
								<tr class="">
									<td class=""></td>
								
									<%-- <td>${temp.article_id}</td> --%>
									<td>${temp.aid}</td>
									<td>${temp.article_title}</td>
									<td>${temp.article_pages}</td>
									<td class=textEdit>3</td>
									<td class=textEdit>3</td>
									<td class='numericEdit to'>0</td>
									<td class='numericEdit from'>0</td>
									<td>${temp.article_doi}</td>
									<td>${temp.taskName}</td>
									<td class=" "><i class="fa fa-arrow-up up"
										aria-hidden="true"></i> <i class="fa fa-arrow-down down"
										aria-hidden="true"></i> <input name="select_all" value="1" type="checkbox"></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>


					<div class="row m-4">
						<section>
							<div class=" editableform-loading">
								
								<span class="task-font float-left">Articles Available In
									Issue </span>&nbsp;&nbsp; <select id="issueId"
									placeholder="Enter Title Here">
									<!-- <option value="CoverPage">Cover Page</option> -->
									<option value="IssueCover">Issue Cover</option>
									<option value="PrintCover">Print Cover</option>
									<option value="Frontmatter">Frontmatter</option>
									<option value="Backmatter">Backmatter</option>
									<option value="IssueLayout">Issue Layout</option>
									<option value="IssueText">Issue Text</option>
									<option value="PrintText">Print Text</option>
									<option value="Printlayout">Print layout</option>
									<option value="Advertisement">Advertisement Page</option>
									<option value="AdditionalFile">Additional File</option>
									<option value="Add Extra Page In Issue">Add Extra Page
										In Issue</option>
								</select>
								<!-- <input type="text" id="issueId"
											placeholder="Enter issueId here..." /> -->
								<input type="text" id="issueTitle"
									placeholder="Enter Title Here" />
								<input type="text" id="pageNo" maxlength=6
									placeholder="Enter Page Number Here" />
							
								<button type="button" id="oderingPage"
									class="btn btn-outline-danger btn-sm  float-right ml-2 oderingPage" >
									<i class="fa font-icon "></i> &nbsp;Update Page Range
								</button>
								<button type="button" onclick="downloadExcel()"
									class="btn btn-dark btn-sm float-right ml-2">
									<i class="fa  font-icon "></i> &nbsp;Download Excel
								</button>
								<button type="submit" id="add-service-button"
									class="btn btn-outline-danger btn-sm  float-right">
									<i class="fa fa-plus font-icon "></i> &nbsp;Add Pages
								</button>
								<button id="RightMove"class="btn btn-dark btn-sm oderingPage float-right" >
									Down <i class="fa fa-arrow-down " aria-hidden="true"></i>
								</button>
								<button id="LeftMove" class="btn btn-dark btn-sm oderingPage float-right" >
									 UP <i class="fa fa-arrow-up " aria-hidden="true"></i>
								</button>
							</div>

						</section>
					</div>

					<table class="dataTable table m-4" id="table2">
						<thead class="table-head">
							<tr>
								<th>S.no</th>
								<th>Aid</th>
								<!-- <th>Article id</th> -->
								<th>Article title</th>
								<th>Pages</th>
								<th>Color Image</th>
								<th>BW Image</th>
								<th>From</th>
								<th>To</th>
								<th>Article DOI</th>
								<th>Article status</th>
								<th>Up || Down</th>
							</tr>
						</thead>


						<!-- <tbody
													class="tasklist vertical connected-sortable droppable-area2 ui-sortable"> -->
						<tbody>
							<c:forEach var="temp" items="${issueSeq}" varStatus="counter">
								<tr class="">
									
									<td class=""></td>
									<td>${temp.coverArticleId}</td>
									<td>${temp.articletitle}</td>
									<td>${temp.pages}</td>

									<td class=textEdit>3</td>
									<td class=textEdit>3</td>
									<td class='numericEdit to'>${temp.page_from}</td>
									<td class='numericEdit from'>${temp.to_page}</td>
									<c:if test="${temp.articleDoi ne 'Remove'}">
										<td>${temp.articleDoi}</td>
									</c:if>
									<c:if test="${temp.articleDoi eq 'Remove'}">
										<td><a class='del-service' href='#'
											title='Click to remove this entry'>Remove</a></td>
									</c:if>
									<td>${temp.issueFile.fileName}</td>
							<td class=" "><i class="fa fa-arrow-up up"
										aria-hidden="true"></i> <i class="fa fa-arrow-down down"
										aria-hidden="true"></i> <input name="select_all" value="1" type="checkbox"></td>
								</tr>
							</c:forEach>
						</tbody>

					</table>

				</div>
			</div>
		</div>
	</div>
<script>


 $( ".oderingPage" ).click(function() {
// function updatePage(){
 //$('table').on("cell:onEditExit", function (event) {
		var TableData = new Array();
		var lastnumber = '${issSeqLast.to_page}'
		//alert(lastnumber);
			var subTotal = 1;
			var subTotal2=0;
			if(lastnumber!=""){
				subTotal2=parseInt(lastnumber);
				}
	/* 	var subTotal = 1;
		var subTotal2=0; */
		var $data =	$('#table2 tr ').each(function(row, tr) {
			TableData[row] = {
				"articleId" : $(tr).find('td:eq(1)').text(),
				"pages" : $(tr).find('td:eq(3)').text(),
				"from" : $(tr).find('td:eq(6)').text(),
				
				"to" : $(tr).find('td:eq(7)').text(),
			}//tableData[row]
			var to = $(tr).find('td:eq(6)').text();
			var from = $(tr).find('td:eq(7)').text();
			var remove = $(tr).find('td:eq(8)').text();
			var page =$(tr).find('td:eq(3)').text();
			if(remove!="Remove"){
			if (to!="") {
				//debugger;
			 subTotal2=parseInt(page)+parseInt(subTotal)-1;
			
			$(tr).find('td:eq(6)').empty();
			$(tr).find('td:eq(6)').append(""+subTotal+"");
			$(tr).find('td:eq(7)').empty();
			$(tr).find('td:eq(7)').append("" + subTotal2 + "");
			}
			subTotal=subTotal2+1;	
			//alert(subTotal);
			}});
		TableData.shift(); 
	 	var Data = JSON.stringify(TableData);
 //      		alert(Data); 

 //    console.log('onEditExited event');
 });

</script>

<script>
        $(document).ready(function () {
            var logAllEvents = true;

            var advancedEditor = new SimpleTableCellEditor("table2");
            advancedEditor.SetEditableClass("numericEdit", { validation: $.isNumeric });
            advancedEditor.SetEditableClass("textEdit");
            $("#advancedToggle").on('click', function(e){
                advancedEditor.Toggle($(e.currentTarget).is(':checked'));
            })

            if (logAllEvents) {
                $('table').on("cell:onEditExit", function (event) {
        			var TableData = new Array();
        			
        			var lastnumber = '${issSeqLast.to_page}'
            			var subTotal = 1;
        				var subTotal2=0;
        				if(lastnumber!=""){
        					subTotal2=parseInt(lastnumber);
        					}
        		
        			var $data =	$('#table2 tr ').each(function(row, tr) {
            			TableData[row] = {
            				//"artID" : $(tr).find('input:eq(0)').text(),
            				"articleId" : $(tr).find('td:eq(1)').text(),
            				//"articletitle" : $(tr).find('td:eq(2)').text(),
            				"pages" : $(tr).find('td:eq(3)').text(),
            				"from" : $(tr).find('td:eq(6)').text(),
            				"to" : $(tr).find('td:eq(7)').text(),
            			//	"articleDOI" : $(tr).find('td:eq(8)').text(),
            				//"atStatusCoverid" : $(tr).find('td:eq(9)').text(),
            			}//tableData[row]
            			var to = $(tr).find('td:eq(6)').text();
        				var from = $(tr).find('td:eq(7)').text();
        				var remove = $(tr).find('td:eq(8)').text();
        				var page =$(tr).find('td:eq(3)').text();
        				if(remove!="Remove"){
            			if (to!="") {
            				//debugger;
        			//	alert("to :"+to);
        			//	alert("from :"+from);
        			//	alert("page :"+page);
        				
        				 subTotal2=parseInt(page)+parseInt(subTotal)-1;
        			//	alert(subTotal2);		
        				
        				$(tr).find('td:eq(6)').empty();
        				$(tr).find('td:eq(6)').append(""+subTotal+"");
        				$(tr).find('td:eq(7)').empty();
            			$(tr).find('td:eq(7)').append("" + subTotal2 + "");
        				}
            			subTotal=subTotal2+1;	
            		}});
            		TableData.shift(); 
	        	 	var Data = JSON.stringify(TableData);
                      		//alert(Data); 

                    console.log('onEditExited event');
                });
            }



        });
        
        $(document).ready(function(){
            $(".up,.down,.top,.bottom").click(function(){
                var row = $(this).parents("tr:first");
               
                if ($(this).is(".up")) {
                    row.insertBefore(row.prev());
                } else if ($(this).is(".down")) {
                    row.insertAfter(row.next());
                } else if ($(this).is(".top")) {
                    row.insertBefore($("table tr:first"));
                }else {
                    row.insertAfter($("table tr:last"));
                }
            });
        });
    </script>
    
    
</body>

</html>
