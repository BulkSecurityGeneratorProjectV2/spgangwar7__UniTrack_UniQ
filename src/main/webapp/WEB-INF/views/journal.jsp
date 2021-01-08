
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

				<div class="accordion my_accordion" id="accordionExample">
					<form:form method="POST" action="${context}/createjournal"
						modelAttribute="journal">

						<div class="content_box">
							<div class="box-body">
								<div class="">
									<div class="row mrgBottom">
										<!-- <div class="col-md-6"> -->

										<div class="form-group col-md-4">
											

											<label> Exam name <sup class="text-red">&lowast;</sup>
											</label> <select  onchange="getuniqID()" path="examList" id="examID"
												name="examID" class="form-control title-right3">
												<c:forEach items="${examList}" var="temp">
													<option value="${temp.examID}">${temp.examName}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group col-md-4">
											<label><spring:message code="book.journal" /> Title <sup class="text-red">&lowast;</sup>
											</label> <input type="text"  onkeypress="getuniqID()" required name="journalTitle"
												class="form-control title-right3" id="title"
												placeholder="<spring:message code="book.journal" /> Title">
										</div>
										
										<div class="form-group col-md-4">
											<label><spring:message code="book.journal" /> Acronym <sup class="text-red">&lowast;</sup>
											</label> <input type="text" required id="uniqID"
												name="journalAcronym" class="form-control title-right3"
												maxlength="80"  placeholder="<spring:message code="book.journal"/> Acronym">
										</div>

										

										
										<div class="form-group col-md-4">
											<label>From Email
											</label> <input type="text" maxlength=70 
												onchange="validate()" id="fromEmail" onclick="getuniqID()"  name="fromEmail"
												class="form-control title-right3" placeholder="Email">
										</div>
									
										<div class="form-group col-md-4">
											<label> Partner Contact <sup class="text-red">&lowast;</sup>
											</label>
											<textarea name="partnerContact" id="partnerContact"
												placeholder="Partner Contact"
												class="form-control title-right3" rows="2" cols="40"
												required></textarea>
											
										</div>

										<!-- <div class="form-group col-md-4">
											<label> Short Title <sup class="text-red">&lowast;</sup>
											</label> <input type="text" required maxlength=10 name="shortTitle"
												id="shortTitle" class="form-control title-right3"
												placeholder="Short Title">
										</div> -->

<!-- 										<div class="form-group col-md-4"> -->
<!-- 											<label> INGESTION Method <sup class="text-red">&lowast;</sup></label> -->
<!-- 																				<input type="text" required -->
<!-- 																				name="INGESTIONMethod" class="form-control" -->
<!-- 																				placeholder="Ingestion Method"> -->

<!-- 											<select class="form-control title-right3" -->
<!-- 												name="INGESTIONMethod"> -->
<!-- 												<option>Automated</option> -->
<!-- 												<option>Push</option> -->
<!-- 												<option>Pull</option> -->
<!-- 											</select> -->
<!-- 										</div> -->

<!-- 										<div class="form-group col-md-4"> -->
<!-- 											<label> OA Status <sup class="text-red">&lowast;</sup> -->
<!-- 											</label> -->
<!-- 											<input type="text" name="oAStatus" required
<!-- 												class="form-control" placeholder="OA Status"> -->
<!-- 											<select class="form-control title-right3" name="oAStatus"> -->
<!-- 												<option>Full</option> -->
<!-- 												<option>None</option> -->
<!-- 												<option>hybrid</option> -->
<!-- 											</select> -->
<!-- 										</div> -->

										<!-- <div class="form-group col-md-4">
											<label> House Style <sup class="text-red">&lowast;</sup>
											</label>
											<input type="text" required
												name="houseStyle" class="form-control"
												placeholder="House Style">
											<select class="form-control title-right3" name="houseStyle">
												<option>NA</option>
												<option>LWW House Style</option>
											</select>
										</div> -->

										<!-- <div class="form-group col-md-4">
											<label> Online ISSN <sup class="text-red">&lowast;</sup></label> <input type="text" required onchange="onlineIssn1()"
												name="onlineIssn" id="onlineIssn" class="form-control title-right3"
												placeholder="Online ISSN eg-: 0208-6336">
										</div> -->
								<%-- 		<div class="form-group col-md-4">
											<label> Online ISSN <sup class="text-red">&lowast;</sup></label>
											<input type="text" required onchange="onlineIssn1()"
												name="onlineIssn" id="onlineIssn"
												class="form-control title-right3"
												placeholder="Online ISSN eg-: XXXX-XXXX" maxlength="9"
												onkeypress="return this.value.length < 9;"
												oninput="if(this.value.length>=10) { this.value = this.value.slice(0,9); }">
										</div> --%>

<!-- 
										<div class="form-group col-md-4">
											<label> Page Layout <sup class="text-red">&lowast;</sup>
											</label>
											<input type="text" required
												name="pageLayout" class="form-control"
												placeholder="Page Layout">
											<select class="form-control title-right3" name="pageLayout">
												<option>Single</option>
												<option>Double</option>

											</select>
										</div> -->
				
								<%-- 		<div class="form-group col-md-4">
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
										</div> --%>

									<!-- 	<div class="form-group col-md-4">
											<label> ISSN to use for DOI <sup class="text-red">&lowast;</sup>
											</label>
											<input type="text" required
												name="issnDoi" class="form-control"
												placeholder="ISSN to Use for DOI">
											<select class="form-control title-right3" name="issnDoi">
												<option>Yes</option>
												<option>No</option>

											</select>

										</div> -->

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
									<!-- 	<div class="form-group col-md-4">
											<label> DOI Prefix <sup class="text-red">&lowast;</sup></label>
											<input type="text" required maxlength=40 name="doiPrefix"
												id="doiPrefix" class="form-control title-right3"
												placeholder="DOI Prefix">
										</div> -->
									</div>


								</div>
							</div>

							<div class="box-footer text-right">
								<a class="btn btn-primary" href="${context}/journalList"
									style="text-transform: capitalize;">Cancel</a>
								<button type="submit"  onclick="getuniqID()" class="btn btn-danger ">Submit</button>
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<script>

$('#uniqID').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[a-zA-Z ']*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
});
$('#partnerContact').on('input', function() {
    var cursor_pos = $(this).getCursorPosition()
    if(!(/^[a-zA-Z @ _ 0-9 .]*$/.test($(this).val())) ) {
        $(this).val($(this).attr('data-value'))
        $(this).setCursorPosition(cursor_pos - 1)
        return
    }
    $(this).attr('data-value', $(this).val())
});
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



function getuniqID(){
	debugger;
	var title = document.getElementById("title").value
	 var value = $("#examID option:selected"); 
	//alert(aid);
//	$("#uniqID").prop('disabled', true);
//	 $('#examID').val(examID);
//	 $('#title').val(title);
	 var journal = title +'/'+value.text();
	 $('#uniqID').val(journal);			
	}
</Script>

