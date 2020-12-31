// document ready function ends here
jQuery.extend(jQuery.fn.dataTableExt.oSort, {
	"num-html-pre" : function(a) {
		var x = String(a).replace(/(?!^-)[^0-9.]/g, "");
		return parseFloat(x);
	},

	"num-html-asc" : function(a, b) {
		return ((a < b) ? -1 : ((a > b) ? 1 : 0));
	},

	"num-html-desc" : function(a, b) {
		return ((a < b) ? 1 : ((a > b) ? -1 : 0));
	}
});
//natural sorting 

jQuery.fn.dataTableExt.oSort['natural-asc'] = function(a, b) {
	return naturalSort(a, b);
};

jQuery.fn.dataTableExt.oSort['natural-desc'] = function(a, b) {
	return naturalSort(a, b) * -1;
};

// Natural sort function
function naturalSort(a, b) {
	var re = /(^-?[0-9]+(\.?[0-9]*)[df]?e?[0-9]?$|^0x[0-9a-f]+$|[0-9]+)/gi, sre = /(^[ ]*|[ ]*$)/g, dre = /(^([\w ]+,?[\w ]+)?[\w ]+,?[\w ]+\d+:\d+(:\d+)?[\w ]?|^\d{1,4}[\/\-]\d{1,4}[\/\-]\d{1,4}|^\w+, \w+ \d+, \d{4})/, hre = /^0x[0-9a-f]+$/i, ore = /^0/, i = function(
			s) {
		return naturalSort.insensitive && ('' + s).toLowerCase() || '' + s
	},
	// convert all to strings strip whitespace
	x = i(a).replace(sre, '') || '', y = i(b).replace(sre, '') || '',
	// chunk/tokenize
	xN = x.replace(re, '\0$1\0').replace(/\0$/, '').replace(/^\0/, '').split(
			'\0'), yN = y.replace(re, '\0$1\0').replace(/\0$/, '').replace(
			/^\0/, '').split('\0'),
	// numeric, hex or date detection
	xD = parseInt(x.match(hre))
			|| (xN.length != 1 && x.match(dre) && Date.parse(x)), yD = parseInt(y
			.match(hre))
			|| xD && y.match(dre) && Date.parse(y) || null, oFxNcL, oFyNcL;
	// first try and sort Hex codes or Dates
	if (yD)
		if (xD < yD)
			return -1;
		else if (xD > yD)
			return 1;
	// natural sorting through split numeric strings and default strings
	for (var cLoc = 0, numS = Math.max(xN.length, yN.length); cLoc < numS; cLoc++) {
		// find floats not starting with '0', string or 0 if not defined (Clint Priest)
		oFxNcL = !(xN[cLoc] || '').match(ore) && parseFloat(xN[cLoc])
				|| xN[cLoc] || 0;
		oFyNcL = !(yN[cLoc] || '').match(ore) && parseFloat(yN[cLoc])
				|| yN[cLoc] || 0;
		// handle numeric vs string comparison - number < string - (Kyle Adams)
		if (isNaN(oFxNcL) !== isNaN(oFyNcL)) {
			return (isNaN(oFxNcL)) ? 1 : -1;
		}
		// rely on string comparison if different types - i.e. '02' < 2 != '02' < '2'
		else if (typeof oFxNcL !== typeof oFyNcL) {
			oFxNcL += '';
			oFyNcL += '';
		}
		if (oFxNcL < oFyNcL)
			return -1;
		if (oFxNcL > oFyNcL)
			return 1;
	}
	return 0;
}

// document ready function ends here
//function  start 
$(document).ready(
		function() {
			/* article list datatable START */
			var myTable = $('.articleTable').DataTable({

				columnDefs : [ {
					targets : [ 1 ],
					visible : false,
					searchable : false
				} ],
				/*dom : 'Blfrtip',*/
				dom : 'Pfrtip',
				buttons : [ 'selectAll', 'selectNone' ],
				language : {
					buttons : {
						selectAll : "Select all items",
						selectNone : "Select none"
					}
				}
			});

			var form_data = myTable.rows().data();

			$.each(form_data, function(key, value) {
				// alert( key + ": " + value );
			});
			/* article list datatable  END */

			/* Date picker dashboard START */
			$('#LastUpdated-datepicker').datepicker({
				uiLibrary : 'bootstrap4',
				iconsLibrary : 'fontawesome'
			});
			/* Date picker dashboard END */

			// Date JS starts here
			var monthNames = [ "Jan", "Feb", "Mar", "Apr", "May", "June",
					"July", "Aug", "Sept", "Oct", "Nov", "Dec" ];
			var dayNames = [ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" ]

			var newDate = new Date();
			newDate.setDate(newDate.getDate());
			$('#Date').html(
					dayNames[newDate.getDay()] + " , " + newDate.getDate()
							+ ' ' + monthNames[newDate.getMonth()] + ' '
							+ newDate.getFullYear());
			// DateJS End here

			/* user list datatable  START */
			$('#userTable').DataTable({
			/* "bLengthChange": false*/
			});
			/* user list datatable  END */

			/* department datatable  START */
			$('#deptTable').DataTable({
			/* "bLengthChange": false*/
			});
			/* department datatable  END */

			/* role datatable  START */
			$('#roleTable').DataTable({
			/* "bLengthChange": false*/
			});
			/* role datatable  END */
			$('#myTable').DataTable({
			/* "bLengthChange": false*/
			});
			/* Publisher datatable  START */
			$('#pubTable').DataTable({
			/* "bLengthChange": false*/
			});
			/* Publisher datatable  END */

			/* Holiday Group datatable  START */
			$('#holidayGroupTable').DataTable({
			/* "bLengthChange": false*/
			});
			/* Holiday Group datatable  END */

			/* Holiday datatable  START */
			$('#holidayTable').DataTable({
			/* "bLengthChange": false*/
			});
			/* Holiday datatable  END */

			/* Holiday datatable  START */
			$('#dataTable').DataTable({
			/* "bLengthChange": false*/
			});
			/* Holiday datatable  END */
			$('#emailTable').DataTable({
			/* "bLengthChange": false*/
			});

		});// document ready function ends here

// tooltip
$(function() {
	$('[data-toggle="tooltip"]').tooltip()
})

// sidebar
$(document).ready(function() {
	$('#sidebarCollapse').on('click', function() {
		$('#sidebar').toggleClass('active');

		if (!$("#sidebar").hasClass("active")) {
			$("#content").addClass("slideRight");
			$(".footer").addClass("slideRight");
		} else {
			$("#content").removeClass("slideRight");
			$(".footer").removeClass("slideRight");
		}
	});

	var divHeight = $('#sidebar').height() - 70;

	$('ul.components').css('max-height', divHeight + 'px');
});

$('.components').slimscroll({
	height : 'auto',
	color : "#fff",
	railVisible : true,
	alwaysVisible : false
});

// collapse icon
$(document).ready(
		function() {
			$('.collapse').on(
					'shown.bs.collapse',
					function() {
						$(this).parent().find(".fa-angle-down").removeClass(
								"fa-angle-down").addClass("fa-angle-up");
					}).on(
					'hidden.bs.collapse',
					function() {
						$(this).parent().find(".fa-angle-up").removeClass(
								"fa-angle-up").addClass("fa-angle-down");
					});
		});

/*article list page action START*/

function createArticle() {
	document.getElementById("article").action = "createArticle";
	document.getElementById("article").method = "POST";
	document.getElementById("article").submit();
}

function createJournal() {
	document.getElementById("journal").action = "journal";
	document.getElementById("journal").method = "GET";
	document.getElementById("journal").submit();
}

function updateArticle(val) {
	document.getElementById("article_id").value = val;
	document.getElementById("article").action = "view-articleDetail";
	document.getElementById("article").method = "POST";
	document.getElementById("article").submit();
}

function deleteArticle(val) {
	if (confirm('Are you sure you want to delete this Article ?')) {
		document.getElementById("article_id").value = val;
		document.getElementById("article").action = "delete-articleDetail";
		document.getElementById("article").method = "POST";
		document.getElementById("article").submit();
	} else {
		// Do nothing!
	}
}
/*article list page action END */

/*article Create page action START*/
function ArticleList() {
	document.getElementById("article").action = "articleDetail";
	document.getElementById("article").method = "GET";
	document.getElementById("article").submit();
}

/*article Create page action END*/

/*article Edit page action START*/
function saveEditArticle() {
	document.getElementById("article").action = "updateArticleDetail";
	document.getElementById("article").method = "POST";
	document.getElementById("article").submit();
}

function isNumber(evt) {
	evt = (evt) ? evt : window.event;
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		return false;
	}
	return true;
}

$(init);

function init() {
	$(".droppable-area1, .droppable-area2").sortable({
		connectWith : ".connected-sortable",
		stack : '.connected-sortable ul'
	}).disableSelection();
}

///*user list page action START*/
//function validate(){
//	
//	var username=document.getElementById("username").value;
//	var firstName=document.getElementById("firstName").value;
// 	var lastName=document.getElementById("lastName").value;
// 	var deptID=document.getElementById("deptID").value;
//	
//	if(username==''){
//		alert("User Name   cannot be blank.");
//		return false;
//	}
//	/*if(WebUrl==''){
//		alert("WebUrl Name cannot be blank.");
//		return false;
//	}
//	else{
//		var pattern =new RegExp('(www\.)[a-zA-Z0-9\.\-]+\\.[a-zA-Z]{2,5}');
//		 
//		if (!pattern.test(WebUrl)) { 
//		    alert("Web Url must be start with world wide web. eg. \" www.test.com\"");
//		    return false;
//		}
//	}*/
// 	if(firstName==''){
//		alert("first Name cannot be blank.");
//		return false;
//	}
//	if(lastName==''){
//		alert("Last Name cannot be blank.");
//		return false;
//	}
// 	if(deptID=='Please Select'){
// 		alert("Dept Name cannot be blank.");
// 		return false;
// 	}
//
//	return true;
//}

function updateUser(userID) {
	document.getElementById("userID").value = userID;
	document.getElementById("users").action = "editUser";
	document.getElementById("users").method = "POST";
	document.getElementById("users").submit();
}

function deleteUser(userID) {
	if (confirm("Are you sure you want to delete this user ?")) {
		document.getElementById("userID").value = userID;
		document.getElementById("users").action = "deleteUser";
		document.getElementById("users").method = "POST";
		document.getElementById("users").submit();
	}
}

/*User list page action END*/
//function validate(){
//	
////	var holidayGrpId=document.getElementById("holidayGrpId").value;
//	var roleID=document.getElementById("roleID").value;
// 	var groupName=document.getElementById("groupName").value;
// 	var status=document.getElementById("status").value;
//	
// 	
// 	if(groupName==''){
//		alert("Group Name cannot be blank.");
//		return false;
//	}
// 	if(roleID=='Please select a role...'){
// 		alert("holiday  cannot be blank.");
// 		return false;
// 	}
// 	if(status=='Selct one...'){
// 		alert("holiday  cannot be blank.");
// 		return false;
// 	}
//// 	if(holidayGrpId=='Please select a group...'){
//// 		alert("holiday  cannot be blank.");
//// 		return false;
//// 	}
//	
//
//	return true;
//}
function validateRole() {

	var status = document.getElementById("status").value;
	var roleName = document.getElementById("roleName").value;
	var che = $('input[name="function"]:checked').val();
	$("#roleName").css("color", "black");
	if (roleName == '') {
		alert("Role Name cannot be blank.");
		return false;
	}
	if (!/^[a-zA-Z ]*$/g.test(roleName)) {
		alert("Invalid characters");
		$("#roleName").css("color", "red");
		return false;
	}
	if (status == 'Select Status') {
		alert("Status cannot be blank.");
		return false;
	}
	if (che == null) {
		alert("Select at least one menu function")
		return false;
	}
	return true;
}
function validateGroup() {

	var status = document.getElementById("status").value;
	var groupName = document.getElementById("groupName").value;

	$("#groupName").css("color", "black");
	if (groupName == '') {
		alert("Group name cannot be blank.");
		return false;
	}
	if (!/^[a-zA-Z ]*$/g.test(groupName)) {
		alert("Invalid characters");
		$("#groupName").css("color", "red");
		return false;
	}
	if (status == 'Select Status') {
		alert("Status cannot be blank.");
		return false;
	}

	return true;
}

function deleteDept(deptID) {
	if (confirm("Are you sure you want to delete this department ?")) {
		document.getElementById("deptID").value = deptID;
		document.getElementById("dept").action = "deleteDept";
		document.getElementById("dept").method = "POST";
		document.getElementById("dept").submit();
	}
}

function editDeptDetails(deptID) {
	document.getElementById("deptID").value = deptID;
	document.getElementById("dept").action = "editDeptDetails";
	document.getElementById("dept").method = "POST";
	document.getElementById("dept").submit();
}

function updateEditDeptDetails(deptID) {
	if (validateGroup()) {
		if (confirm("Are you sure you want to update this Role Assignment ?")) {
			document.getElementById("deptID").value = deptID;
			document.getElementById("dept").action = "updateEditDeptDetails";
			document.getElementById("dept").method = "POST";
			document.getElementById("dept").submit();
		}
	}
}
function deleteRole(roleID) {
	if (confirm("Are you sure you want to delete this role ?")) {
		document.getElementById("roleID").value = roleID;
		document.getElementById("roles").action = "deleteRole";
		document.getElementById("roles").method = "POST";
		document.getElementById("roles").submit();
	}
}

function editRoleDetails(roleID) {
	document.getElementById("roleID").value = roleID;
	document.getElementById("roles").action = "editRoleDetails";
	document.getElementById("roles").method = "POST";
	document.getElementById("roles").submit();
}

function updateRoleDetails(roleID) {
	if (validateRole()) {
		if (confirm("Are you sure you want to update this role ?")) {
			document.getElementById("roleID").value = roleID;
			var x = document.getElementById("myColor").value;
			document.getElementById("myColor").value = x;
			document.getElementById("roles").action = "updateRoleDetails";
			document.getElementById("roles").method = "POST";
			document.getElementById("roles").submit();

		}
	}
}

function saveNewPublisher() {
	if (validate()) {
		document.getElementById("publishers").action = "saveNewPublisher";
		document.getElementById("publishers").method = "POST";
		document.getElementById("publishers").submit();
	}
}

function editPubDetails(pubID) {
	document.getElementById("publisher_id").value = pubID;
	document.getElementById("publishers").action = "editPublisherDetails";
	document.getElementById("publishers").method = "POST";
	document.getElementById("publishers").submit();
}

function updatePublisherDetails(pubID) {
	document.getElementById("publisher_id").value = pubID;
	document.getElementById("publishers").action = "updatePublisherDetails";
	document.getElementById("publishers").method = "POST";
	document.getElementById("publishers").submit();
}

function deletePubDetails(pubID) {
	if (confirm("Are you sure you want to delete this Publisher ?")) {
		document.getElementById("publisher_id").value = pubID;
		document.getElementById("publishers").action = "deletePublisher";
		document.getElementById("publishers").method = "POST";
		document.getElementById("publishers").submit();
	}
}

function deleteHoliDayGroup(holidayGrpId) {
	if (confirm("Are you sure you want to delete this department ?")) {
		document.getElementById("holidayGrpId").value = holidayGrpId;
		document.getElementById("holidayGroup").action = "deleteHolidayGroup";
		document.getElementById("holidayGroup").method = "POST";
		document.getElementById("holidayGroup").submit();
	}
}

function editHoliDayGroup(holidayGrpId) {
	document.getElementById("holidayGrpId").value = holidayGrpId;
	document.getElementById("holidayGroup").action = "editHolidayGroup";
	document.getElementById("holidayGroup").method = "POST";
	document.getElementById("holidayGroup").submit();
}

function updateHoliDayGroup(holidayGrpId) {
	document.getElementById("holidayGrpId").value = holidayGrpId;
	document.getElementById("holidayGroup").action = "updateHoliDayGroup";
	document.getElementById("holidayGroup").method = "POST";
	document.getElementById("holidayGroup").submit();
}

function saveHoliDayGrp() {
	if (validate()) {
		document.getElementById("holidayGrp").action = "updateHoliDayGroup";
		document.getElementById("holidayGrp").method = "POST";
		document.getElementById("holidayGrp").submit();
	}
}

function saveNewHoliday() {
	if (validate()) {
		document.getElementById("holidays").action = "saveNewHoliday";
		document.getElementById("holidays").method = "POST";
		document.getElementById("holidays").submit();
	}
}

function deleteHolidayDetails(holidayCalID) {
	if (confirm("Are you sure you want to delete this holiday ?")) {
		document.getElementById("hcId").value = holidayCalID;
		document.getElementById("holidays").action = "deleteHoliday";
		document.getElementById("holidays").method = "POST";
		document.getElementById("holidays").submit();
	}
}

function editHolidayDetails(holidayCalID) {
	document.getElementById("hcId").value = holidayCalID;
	document.getElementById("holidays").action = "editHolidayDetails";
	document.getElementById("holidays").method = "POST";
	document.getElementById("holidays").submit();
}

function updateHoliDayDetails(holidayCalID) {
	document.getElementById("hcId").value = holidayCalID;
	document.getElementById("holidays").action = "updateHolidayDetails";
	document.getElementById("holidays").method = "POST";
	document.getElementById("holidays").submit();
}

function editHeadDeptUser(deptID) {
	document.getElementById("deptHeadID").value = deptID;
	document.getElementById("deartmentHead").action = "editDepartmentHead";
	document.getElementById("deartmentHead").method = "POST";
	document.getElementById("deartmentHead").submit();
}

function updateDeptHeadDetails(deptID) {
	document.getElementById("deptID").value = deptID;
	document.getElementById("deartmentHead").action = "updateDepartmentHead";
	document.getElementById("deartmentHead").method = "POST";
	document.getElementById("deartmentHead").submit();

}

function deleteHeadDeptUser(deptID) {
	if (confirm("Are you sure you want to delete this department head ?")) {
		document.getElementById("deptHeadID").value = deptID;
		document.getElementById("deartmentHead").action = "deleteDepartmentHead";
		document.getElementById("deartmentHead").method = "POST";
		document.getElementById("deartmentHead").submit();
	}
}

function createBook() {
	document.getElementById("book").action = "books";
	document.getElementById("book").method = "GET";
	document.getElementById("book").submit();
}
function deleteEmail(id) {
	if (confirm("Are you sure you want to delete this email ?")) {
		document.getElementById("id").value = id;
		document.getElementById("emails").action = "deleteEmail";
		document.getElementById("emails").method = "POST";
		document.getElementById("emails").submit();
	}
}

function editEmailTemplate(id) {
	document.getElementById("id").value = id;
	document.getElementById("emails").action = "editEmailTemplate";
	document.getElementById("emails").method = "POST";
	document.getElementById("emails").submit();
}


$(document).ready(function() {
    $('.filter10').DataTable( {
        initComplete: function () {
            this.api().columns(1).every( function () {
                var column = this;
                var select = $('<select class="custom-select tbl-select"><option value="">Journal Abbreviation Name</option></select>')
                    .appendTo( $(column.header()).empty() )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
 
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
 
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );
            } );
        },
        "aoColumns": [null, null,null,{ "sType": "natural" }, null,null, null,null , null,null]
    } );
} );

$(document).ready(function() {
    $('.filter8').DataTable( {
        initComplete: function () {
            this.api().columns(1).every( function () {
                var column = this;
                var select = $('<select class="custom-select tbl-select"><option value="">Journal Abbreviation Name</option></select>')
                    .appendTo( $(column.header()).empty() )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
 
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
 
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );
            } );
        },
        "aoColumns": [null, null,{ "sType": "natural" },null, null,null, null,null ]
    } );
} );

$(document).ready(function() {
    $('.filter7').DataTable( {
        initComplete: function () {
            this.api().columns(3).every( function () {
                var column = this;
                var select = $('<select class="custom-select tbl-select"><option value="">Journal Name</option></select>')
                    .appendTo( $(column.header()).empty() )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
 
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
 
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );
            } );
        },
      /*  "aoColumns": [null, null,{ "sType": "natural" },null, null,null, null,null,null ]*/
        "aoColumns": [null, { "sType": "natural" },{ "sType": "natural" }, { "sType": "natural" },{ "sType": "natural" }, null , null]
    } );
} );

$(document).ready(function() {
    $('.filter9').DataTable( {
        initComplete: function () {
            this.api().columns(1).every( function () {
                var column = this;
                var select = $('<select class="custom-select tbl-select"><option value="">Journal Name</option></select>')
                    .appendTo( $(column.header()).empty() )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
 
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
 
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );
            } );
        },
      /*  "aoColumns": [null, null,{ "sType": "natural" },null, null,null, null,null,null ]*/
        "aoColumns": [null, null,null,{ "sType": "natural" }, { "sType": "natural" },null, null,null , null]
    } );
} );
