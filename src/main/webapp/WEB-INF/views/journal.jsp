
<%@ include file="/WEB-INF/includes/include.jsp"%>
<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">

			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-6">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Create <spring:message code="book.journal" /></span> <span id="Date">Mon
								, 26 Aug 2019</span>
						</div>
					</div>
					<div class="col-md-6">
						<label class="mandatoryMsg">All <sup class="text-red">(&lowast;)</sup>
							marked fields are mandatory
						</label>
					</div>
				</div>
				<!--main_tittle_End-->

				<!-- <div class="row">
					<div class="col-md-6"></div>
					<div class="col-md-6">
						<label class="mandatoryMsg" style="padding-top: 101px;">All <sup
							class="text-red">(&lowast;)</sup> marked fields are mandatory
						</label>
					</div>
				</div> -->



				<div class="accordion my_accordion" id="accordionExample">
					<form:form method="POST" action="${context}/createjournal"
						modelAttribute="journal">

						<div class="content_box">
							<div class="box-body">
								<div class="">
									<div class="row mrgBottom">
										<!-- <div class="col-md-6"> -->

										<div class="form-group col-md-4">
											<label><spring:message code="book.journal" /> Acronym <sup class="text-red">&lowast;</sup>
											</label> <input type="text" required id="journalAcronym"
												name="journalAcronym" class="form-control title-right3"
												maxlength="10" placeholder="Journal Acronym">
										</div>
										<!-- <div class="form-group col-md-4">
											<label>Journal Acronym <sup class="text-red">&lowast;</sup> </label> <input type="text" required
												name="journalAcronym" class="form-control title-right3"
												placeholder="Journal Acronym">
										</div> -->

										<div class="form-group col-md-4">
											<!-- <label> Partner name: </label> <input type="text" required
												name="partnername" class="form-control"
												placeholder="Partner name"> -->

											<label> Partner name <sup class="text-red">&lowast;</sup>
											</label> <select path="publisherList" id="publisher_id"
												name="publisher_id" class="form-control title-right3">
												<c:forEach items="${publisherList}" var="temp">
													<option value="${temp.publisher_id}">${temp.publisherName}</option>
												</c:forEach>
											</select>
											<%-- <label > Partner name: </label>
															<form:select path="journallist"  id="publisher_id" name="publisher_id"  class="form-control">
							 								 <form:options items = "${publisherList}" itemValue="publisher_id" itemLabel="publisherName" />
															</form:select> --%>

										</div>

										<div class="form-group col-md-4">
											<label><spring:message code="book.journal" /> Title <sup class="text-red">&lowast;</sup>
											</label> <input type="text" required name="journalTitle"
												class="form-control title-right3"
												placeholder="Journal Title">
										</div>
										<div class="form-group col-md-4">
											<label>From Email
											</label> <input type="text" maxlength=70 
												onchange="validate()" id="fromEmail" name="fromEmail"
												class="form-control title-right3" placeholder="Email">
										</div>
									<!-- 	<div class="form-group col-md-4">
											<label>From Password <sup class="text-red">&lowast;</sup>
											</label> <input type="password" maxlength=30 required
												id="fromPassword" name="fromPassword"
												class="form-control title-right3" placeholder="Password">
										</div>  -->
										<div class="form-group col-md-4">
											<label> Partner Contact <sup class="text-red">&lowast;</sup>
											</label>
											<textarea name="partnerContact" id="partnerContact"
												placeholder="Partner Contact"
												class="form-control title-right3" rows="2" cols="40"
												required></textarea>
											<!-- <input type="text" required
												name="partnerContact" class="form-control title-right3"
												placeholder="Partner Contact"> -->
										</div>

										<div class="form-group col-md-4">
											<label> Short Title <sup class="text-red">&lowast;</sup>
											</label> <input type="text" required maxlength=10 name="shortTitle"
												id="shortTitle" class="form-control title-right3"
												placeholder="Short Title">
										</div>

										<div class="form-group col-md-4">
											<label> INGESTION Method <sup class="text-red">&lowast;</sup></label>
											<!-- 									<input type="text" required -->
											<!-- 									name="INGESTIONMethod" class="form-control" -->
											<!-- 									placeholder="Ingestion Method"> -->

											<select class="form-control title-right3"
												name="INGESTIONMethod">
												<option>Automated</option>
												<option>Push</option>
												<option>Pull</option>
											</select>
										</div>

										<div class="form-group col-md-4">
											<label> OA Status <sup class="text-red">&lowast;</sup>
											</label>
											<!-- <input type="text" name="oAStatus" required
												class="form-control" placeholder="OA Status"> -->
											<select class="form-control title-right3" name="oAStatus">
												<option>Full</option>
												<option>None</option>
												<option>hybrid</option>
											</select>
										</div>

										<div class="form-group col-md-4">
											<label> House Style <sup class="text-red">&lowast;</sup>
											</label>
											<!-- <input type="text" required
												name="houseStyle" class="form-control"
												placeholder="House Style"> -->
											<select class="form-control title-right3" name="houseStyle">
												<option>NA</option>
												<option>LWW House Style</option>
											</select>
										</div>

										<!-- <div class="form-group col-md-4">
											<label> Online ISSN <sup class="text-red">&lowast;</sup></label> <input type="text" required onchange="onlineIssn1()"
												name="onlineIssn" id="onlineIssn" class="form-control title-right3"
												placeholder="Online ISSN eg-: 0208-6336">
										</div> -->
										<div class="form-group col-md-4">
											<label> Online ISSN <sup class="text-red">&lowast;</sup></label>
											<input type="text" required onchange="onlineIssn1()"
												name="onlineIssn" id="onlineIssn"
												class="form-control title-right3"
												placeholder="Online ISSN eg-: XXXX-XXXX" maxlength="9"
												onkeypress="return this.value.length < 9;"
												oninput="if(this.value.length>=10) { this.value = this.value.slice(0,9); }">
										</div>


										<div class="form-group col-md-4">
											<label> Page Layout <sup class="text-red">&lowast;</sup>
											</label>
											<!-- <input type="text" required
												name="pageLayout" class="form-control"
												placeholder="Page Layout"> -->
											<select class="form-control title-right3" name="pageLayout">
												<option>Single</option>
												<option>Double</option>

											</select>
										</div>
				
										<div class="form-group col-md-4">
											<label> Print ISSN <sup class="text-red">&lowast;</sup></label>
											<input type="text" name="printIssn" id="printIssn" required
												onchange="printIssn1()" class="form-control title-right3"
												placeholder="Print ISSN eg-:XXXX-XXXX" maxlength="9"
												onkeypress="return this.value.length < 9;"
												oninput="if(this.value.length>=10) { this.value = this.value.slice(0,9); }">
										</div>
										<div class="form-group col-md-4">
											<label>Publication Type <sup class="text-red">&lowast;</sup>
											</label>
											<!-- <input type="text" required
												name="publicationType" class="form-control"
												placeholder="Publication Type"> -->
											<select class="form-control title-right3"
												name="publicationType">
												<option>Yearly</option>
												<option>Semiannual</option>
												<option>Triannual</option>
												<option>Quarterly</option>
												<option>Bimonthly</option>
												<option>Monthly</option>
											</select>
										</div>

										<div class="form-group col-md-4">
											<label> ISSN to use for DOI <sup class="text-red">&lowast;</sup>
											</label>
											<!-- <input type="text" required
												name="issnDoi" class="form-control"
												placeholder="ISSN to Use for DOI"> -->
											<select class="form-control title-right3" name="issnDoi">
												<option>Yes</option>
												<option>No</option>

											</select>

										</div>

							<!-- 			<div class="form-group col-md-4">
											<label>Sequential Numbering<sup class="text-red">&lowast;</sup></label>
											<input type="text" required
												name="sequentialIssue" class="form-control"	placeholder="Sequential issue numbering?">

											<select class="form-control title-right3"
												name="sequentialIssue">
												<option>Yes</option>
												<option>No</option>

											</select>
										</div> -->
								<!-- 		<div class="form-group col-md-4">
											<label> Journal Comments <sup class="text-red">&lowast;</sup>
											</label> <input type="text" required maxlength="50"
												name="journalComments" class="form-control title-right3"
												placeholder="Journal Comments">
										</div> -->
										<div class="form-group col-md-4">
											<label> DOI Prefix <sup class="text-red">&lowast;</sup></label>
											<input type="text" required maxlength=40 name="doiPrefix"
												id="doiPrefix" class="form-control title-right3"
												placeholder="DOI Prefix">
										</div>

<!-- 										<div class="form-group col-md-4">
											<label> CODEN <sup class="text-red">&lowast;</sup>
											</label> <input type="text" name="coden" id="coden" required
												maxlength="50" class="form-control title-right3"
												placeholder="CODEN">
										</div>
 -->
<!-- 										<div class="form-group col-md-4">
											<label> DOI Creation Rule <sup class="text-red">&lowast;</sup></label>
											<input type="text" required name="creationRule"
												class="form-control title-right3"
												placeholder="DOI Creation Rule">
										</div>
 -->
										<!-- </div> -->

										<!-- <div class="col-md-6"> -->

										<!-- 							<div class="form-group col-md-4"> -->
										<!-- 								<label>Article Id Created By Application*: </label> <input -->
										<!-- 									type="text" name="articleID" class="form-control" -->
										<!-- 									placeholder="Article Id Created By Application"> -->
										<!-- 							</div> -->



									</div>


								</div>
							</div>

							<div class="box-footer text-right">
								<a class="btn btn-primary" href="${context}/journalList"
									style="text-transform: capitalize;">Cancel</a>
								<button type="submit" class="btn btn-danger ">Submit</button>
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<script>

function onlineIssn1(){
	var onlineIssn=document.getElementById("onlineIssn").value;
	var pattern =new RegExp('[0-9 A-Z a-z]{4}\-[0-9 A-Z a-z]{4}');
	if (!pattern.test(onlineIssn)) { 
		alert("Online ISSN pattern is not matched. eg-: XXXX-XXXX");
		document.getElementById('onlineIssn').value = "";
		return false;
	}
	return true;
}
function printIssn1(){
var printIssn=document.getElementById("printIssn").value;
var pattern =new RegExp('[0-9 A-Z a-z]{4}\-[0-9 A-Z a-z]{4}');
if (!pattern.test(printIssn)) { 
	alert("Print ISSN pattern is not matched. eg-: XXXX-XXXX");
	document.getElementById('printIssn').value = "";
	return false;
}
return true;
} 
// function onlineIssn1(){
// 		var onlineIssn=document.getElementById("onlineIssn").value;
// 		var pattern =new RegExp('[0-9]{4}\-[0-9]{4}');
// 		if (!pattern.test(onlineIssn)) { 
// 			alert("Online ISSN pattern is not matched. eg-: 0208-6336");
// 			document.getElementById('onlineIssn').value = "";
// 			return false;
// 		}
// 		return true;
// 	}
// function printIssn1(){
// 	var printIssn=document.getElementById("printIssn").value;
// 	var pattern =new RegExp('[0-9]{4}\-[0-9]{4}');
// 	if (!pattern.test(printIssn)) { 
// 		alert("Print ISSN pattern is not matched. eg-: 0208-6336");
// 		document.getElementById('printIssn').value = "";
// 		return false;
// 	}
// 	return true;
// }

$('#journalAcronym').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[a-zA-Z ']*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
})
$('#partnerContact').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[a-zA-Z @ _ 0-9 .]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
})

$('#shortTitle').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[a-zA-Z ]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
})

// $('#doiPrefix').on('input', function() {
//     var cursor_pos = $(this).getCursorPosition()
//     if(!(/^[0-9 . / ]*$/.test($(this).val())) ) {
//         $(this).val($(this).attr('data-value'))
//         $(this).setCursorPosition(cursor_pos - 1)
//         return
//     }
//     $(this).attr('data-value', $(this).val())
// })

$('#doiPrefix').keypress(function(event) {
    if ((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
        event.preventDefault();
    }
});

$('#coden').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[a-z A-Z 0-9  ]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
})
// $('#fromEmail').on('input', function() {
//     var cursor_pos = $(this).getCursorPosition()
//     if(!(/^[a-zA-Z 0-9 .  @]*$/.test($(this).val())) ) {
//         $(this).val($(this).attr('data-value'))
//         $(this).setCursorPosition(cursor_pos - 1)
//         return
//     }
//     $(this).attr('data-value', $(this).val())
// })
$('#creationRule').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[a-zA-Z 0-9 _ . @ ! -]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
})


$.fn.getCursorPosition = function() {
    if(this.length == 0) return -1
    return $(this).getSelectionStart()
}
$.fn.setCursorPosition = function(position) {
    if(this.lengh == 0) return this
    return $(this).setSelection(position, position)
}
$.fn.getSelectionStart = function(){
  if(this.lengh == 0) return -1
  input = this[0]
  var pos = input.value.length
  if (input.createTextRange) {
    var r = document.selection.createRange().duplicate()
    r.moveEnd('character', input.value.length)
    if (r.text == '') 
    pos = input.value.length
    pos = input.value.lastIndexOf(r.text)
  } else if(typeof(input.selectionStart)!="undefined")
  pos = input.selectionStart
  return pos
}
$.fn.setSelection = function(selectionStart, selectionEnd) {
  if(this.lengh == 0) return this
  input = this[0]
  if(input.createTextRange) {
    var range = input.createTextRange()
    range.collapse(true)
    range.moveEnd('character', selectionEnd)
    range.moveStart('character', selectionStart)
    range.select()
  }
  else if (input.setSelectionRange) {
    input.focus()
    input.setSelectionRange(selectionStart, selectionEnd)
  }
  return this
}  
$('#onlineIssn').on('input', function() {
	 var $this = $(this);
	 var input = $this.val();
	 input = input.replace(/[\()\W\s\._\-]+/g, '');
	 
	 var split = 4;
	 var chunk = [];
	  
	 for (var i = 0, len = input.length; i < len; i += split) {
	     split = ( i >= 4 && i <= 9 ) ? 4 : 4;
	     chunk.push( input.substr( i, split ) );
	 }
	  
	 $this.val(function() {
	     return chunk.join("-");
	 });
});
$('#printIssn').on('input', function() {
	 var $this = $(this);
	 var input = $this.val();
	 input = input.replace(/[\()\W\s\._\-]+/g, '');

	 var split = 4;
	 var chunk = [];
	  
	 for (var i = 0, len = input.length; i < len; i += split) {
	     split = ( i >= 4 && i <= 9 ) ? 4 : 4;
	     chunk.push( input.substr( i, split ) );
	 }
	  
	 $this.val(function() {
	     return chunk.join("-");
	 });
});
/* 
$('#onlineIssn').on('input', function() {
	 var $this = $(this);
	 var input = $this.val();
	 input = input.replace(/[\(a-zA-Z)\W\s\._\-]+/g, '');
	 
	 var split = 4;
	 var chunk = [];
	  
	 for (var i = 0, len = input.length; i < len; i += split) {
	     split = ( i >= 4 && i <= 9 ) ? 4 : 4;
	     chunk.push( input.substr( i, split ) );
	 }
	  
	 $this.val(function() {
	     return chunk.join("-");
	 });
})
 $('#printIssn').on('input', function() {
	 var $this = $(this);
	 var input = $this.val();
	 input = input.replace(/[\(a-zA-Z)\W\s\._\-]+/g, '');

	 var split = 4;
	 var chunk = [];
	  
	 for (var i = 0, len = input.length; i < len; i += split) {
	     split = ( i >= 4 && i <= 9 ) ? 4 : 4;
	     chunk.push( input.substr( i, split ) );
	 }
	  
	 $this.val(function() {
	     return chunk.join("-");
	 });
})

 */
</script>
<Script>

function validate() {
	var email = document.getElementById("fromEmail").value;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	
	if (!email.match(mailformat)) {
	 		alert("Enter valid email format");
	 		document.getElementById('fromEmail').value = "";
    		return false;
		}
    return true;	
}
</Script>

