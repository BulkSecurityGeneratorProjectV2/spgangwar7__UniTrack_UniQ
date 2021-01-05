
<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-6">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Create <spring:message code="chapter.article" /></span> <span id="Date"></span>
						</div>
					</div>
					<div class="col-md-6">
						<label class="mandatoryMsg">All <sup class="text-red">(&lowast;)</sup>
							marked fields are mandatory
						</label>
					</div>
				</div>
				<!--main_tittle_End-->
				<c:if test="${not empty message}">
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong> ${message}</strong>
					</div>
				</c:if>


				<div class="row ">
					<div class="col-md-12 ">
						<div class="content_box  ">
							<form action = "${context}/SaveArticle"  method="post" id="article" name="article" enctype="multipart/form-data">
								<div class="box-body">
									<div class="row divtoappend">

										<div class="col-md-4">
											<div class="form-group">
												<label for="currency"><spring:message code="chapter.article" /> Title <sup
													class="text-red">&lowast;</sup></label> <input type="text"
													class="form-control" name="article_title"
													id="article_title" placeholder="" autocomplete="off" maxlength="1000"
													required>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label for="currency"><spring:message code="chapter.article" /> ID <sup
													class="text-red">&lowast;</sup></label> <input type="text"
													class="form-control" name="aid" id="aid" placeholder="" maxlength="30"
													autocomplete="off" required>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label for="ExpertiseLevel"><spring:message code="book.journal" /> Name <sup
													class="text-red">&lowast;</sup></label>


												<form:select path="journallist" id="journalId"
													autocomplete="off" required="required" onchange="getjournaAbb1(this)" name="journalId"
													class="form-control">
													<form:option value="" placeholder="Please Select" labelValue="" />
													<form:options items="${journallist}" itemValue="journalId"
														itemLabel="journalName" />
												</form:select>
											</div>
										</div>

										<%-- 	<div class="col-md-4">
											<div class="form-group">
												<label for="currency">Publisher Name <sup class="text-red">&lowast;</sup></label> 
													<form:select path="publisherList" id="publisher_id"
													name="publisher_id" class="form-control">
													<form:option value="Please Select" labelValue="" />
													<form:options items="${publisherList}" itemValue="publisher_id"
														itemLabel="publisherName" />
												</form:select>
											</div>
										</div>
 --%>
<!-- 										<div class="col-md-4"> -->
<!-- 											<div class="form-group"> -->
<%-- 												<label for="currency"><spring:message code="book.journal" /> Issue Number <sup --%>
<!-- 													class="text-red">&lowast;</sup></label> <input type="text" -->
<!-- 													class="form-control" name="journal_issue_number" -->
<!-- 													id="journal_issue_number" -->
<%-- 													onkeypress="return this.value.length < 3;" --%>
<!-- 													oninput="if(this.value.length>=10) { this.value = this.value.slice(0,3); }" -->
<!-- 													placeholder="Max length is 3" autocomplete="off" required -->
<!-- 													onpaste="return false;"> -->
<!-- 											</div> -->
<!-- 										</div> -->


									<!-- 	<div class="col-md-4"> -->
											<!-- <div class="form-group">
												<label for="currency">Journal Volume Number <sup class="text-red">&lowast;</sup></label> <input
													type="text" class="form-control" 
													name="journal_volume_number" id="journal_volume_number"
													placeholder="" autocomplete="off" required>
											</div> -->
<!-- 											<div class="form-group"> -->
<%-- 												<label for="currency"><spring:message code="book.journal" /> Volume Number <sup --%>
<!-- 													class="text-red">&lowast;</sup></label> <input type="text" -->
<!-- 													class="form-control" name="journal_volume_number" -->
<!-- 													id="journal_volume_number" -->
<%-- 													onkeypress="return this.value.length < 2;" --%>
<!-- 													oninput="if(this.value.length>=10) { this.value = this.value.slice(0,2); }" -->
<!-- 													placeholder="Max length is 2" autocomplete="off" required -->
<!-- 													onpaste="return false;"> -->
<!-- 											</div> -->
									<!-- 	</div> -->
<!-- 										<div class="col-md-4"> -->
<!-- 											<div class="form-group"> -->
<%-- 												<label for="currency"><spring:message code="chapter.article" /> DOI <sup --%>
<!-- 													class="text-red">&lowast;</sup></label> <input type="text" -->
<!-- 													class="form-control" name="article_doi" -->
<%-- 													value="${doiPrefix}" id="article_doi" placeholder="" --%>
<!-- 													autocomplete="off " required > -->
<!-- 											</div> -->
<!-- 										</div> -->

<!-- 										<div class="col-md-3"> -->
<!-- 											<div class="form-group"> -->
<%-- 												<label for="currency"><spring:message code="chapter.article" /> Type <sup --%>
<!-- 													class="text-red">&lowast;</sup></label> <input type="text" -->
<!-- 													class="form-control" name="article_type_cd" maxlength="50" -->
<!-- 													id="article_type" placeholder="" autocomplete="off" -->
<!-- 													required> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 										<div class="col-md-3"> -->
<!-- 											<div class="form-group"> -->
<%-- 												<label for="currency"><spring:message code="chapter.article" /> keywords <sup --%>
<!-- 													class="text-red">&lowast;</sup></label> <input type="text" -->
<!-- 													class="form-control" name="keywords" maxlength="200" id="" -->
<!-- 													placeholder="" autocomplete="off" required> -->
<!-- 											</div> -->
<!-- 										</div> -->
										
										
										<div class="col-md-4">
											<div class="form-group">
												<label for="currency">Upload File <sup
													class="text-red">&lowast;</sup></label> <input type="file"
													class="form-control" style="padding: 3px;"
													name="attachment" id="filepath" placeholder=""
													autocomplete="off" required>
											</div>
										</div>

										<div class="col-md-4">
											<div class="form-group">
												<label for="currency">Noms <sup
													class="text-red">&lowast;</sup></label> <input type="text"
													class="form-control" style="padding: 3px;"
													name="subjectnoms" id="subjectnoms" placeholder="noms"
													autocomplete="off" required>
											</div>
										</div>


										<!-- 										<div class="col-md-3 numberofauthor"> -->
<!-- 											<div class="form-group"> -->
<!-- 												<label for="currency">Number of Authors <sup -->
<!-- 													class="text-red">&lowast;</sup></label> <input  placeholder="Enter the  value eg. 1-9" -->
<!-- 													class='input form-control' type="text" maxlength='1' id="noAuthor" required /> -->
<!-- 											</div> -->
<!-- 										</div> -->
									</div>

								</div>
								<div class="box-footer text-right">
									<a class="btn btn-outline-danger" href="#"
										onclick="ArticleList()">Cancel</a> &nbsp;<!--  <a
										class="btn btn-danger" href="#" onclick="saveArticle()">Save</a> -->
										&nbsp; <input type="submit" value="Save" class="btn btn-danger " />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- <script>

function getAbb(current_select){
	var aid = document.getElementById("aid").value
	//alert(aid);
    var journalId =  current_select.value;
    //alert( journalId );

    var mappingJSON = {};
	mappingJSON["journalId"] = journalId;
	var mappingInfo = JSON.stringify(mappingJSON);
    $.ajax({
		url : '${context}/getuserListByjournalID',
        type : "POST",
		data : mappingInfo,
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		cache : false,
		success : function(result) {
			//alert (result.payload);
			var journal = result.payload +aid;
			
		    $('#article_doi').val(journal);
		},
		error : function(e) {
			console.log(e.message);
		}
	});
}


</script> -->
<script>

function getjournaAbb1(current_select){
	var aid = document.getElementById("aid").value
	//alert(aid);
    var journalId =  current_select.value;
    //alert( journalId );

    var mappingJSON = {};
	mappingJSON["journalId"] = journalId;
	var mappingInfo = JSON.stringify(mappingJSON);
    $.ajax({
		url : '${context}/getuserListByjournalID',
        type : "POST",
		data : mappingInfo,
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		cache : false,
		success : function(result) {
			var articleID=result.payloadNext;
			if(articleID!=null){
				//$("#aid").prop('disabled', true);
				var journal = result.payload;
				 $('#aid').val(articleID);
			    $('#article_doi').val(journal);
			}else{
				//$("#aid").prop('disabled', false);
				 $('#aid').val(aid);
					var journal = result.payload +aid;
				    $('#article_doi').val(journal);
			}
		
		},
		error : function(e) {
			console.log(e.message);
		}
	});
}

/* function getjournaAbb(doiprix,jAbbr){
	debugger;

	var input_text = $('#aid').val();
	 
	var doiId = doiprix+"/"+jAbbr+"."+input_text;

	$("#journalId").click(function(event) { 
        $('#article_doi').attr('value', doiId);
       
    }); 
} */

</script>
<script>
function validate(){
	
	var articletitle=document.getElementById("article_title").value;
	var aid=document.getElementById("aid").value;
	var journalId=document.getElementById("journalId").value;
// 	var publisherid=document.getElementById("publisher_id").value;
 	var journalIssueNumber=document.getElementById("journal_issue_number").value;
	var journalVolumeNumber=document.getElementById("journal_volume_number").value;
	var articleDoi=document.getElementById("article_doi").value;
	var article_type_cd=document.getElementById("article_type").value;
	var filepath=document.getElementById("filepath").value;
//	var noAuthor=document.getElementById("noAuthor").value;
	
	if(articletitle==''){
		alert("Subject Title cannot be blank.");
		return false;
	}
	if(aid==''){
		alert("Subject ID cannot be blank.");
		return false;
	}
	if(journalId=='Please Select'){
		alert("Exam Name cannot be blank.");
		return false;
	}
 /* 	if(publisherid=='Please Select'){
 		alert("Publisher Name cannot be blank.");
 		return false;
 	} */

 	if(journalIssueNumber==''){
 		alert("Exam Issue Number cannot be blank.");
 		return false;
 	}
	if(journalVolumeNumber==''){
		alert("Exam Volume Number cannot be blank.");
		return false;
	}
	if(articleDoi==''){
 		alert("Subject DOI cannot be blank.");
 		return false;
 	}
	
	if(article_type_cd==''){
 		alert("Subject Type cannot be blank.");
 		return false;
 	}
	if(filepath==''){
		alert("File Upload cannot be blank.");
		return false;
	}
	/* if(noAuthor==''){
		alert("Number of Authors cannot be blank.");
		return false;
	} */
	return true;
}
/* function saveArticle() {
 /* if(validate()&&GetFileSize()){  */
		//document.getElementById("article").action = "SaveArticle";
		//document.getElementById("article").method = "POST";
		//document.getElementById("article").submit();
	/* } 
	
} */
</script>
<script>
    function GetFileSize() {
        var fi = document.getElementById('filepath'); // GET THE FILE INPUT.
        debugger;
        // VALIDATE OR CHECK IF ANY FILE IS SELECTED.
        if (fi.files.length > 0) {
            // RUN A LOOP TO CHECK EACH SELECTED FILE.
              var fsize = Math.round(fi.files.item(0).size/1024/1024);
            if(fsize>100){
            	alert("File size should smaller then 100Mb");
            	return false;
            }
            else{
            	return true;
            }
         
        }
    }
</script>
<script>

/* $('input#article_doi').keyup(function(e){ 
    if(this.value.substring(0,1) == "0")
    {
       this.value = this.value.replace(/^0+/g, '');             
    }         
}); 

$('#article_title').on('input', function() {
	   var cursor_pos = $(this).getCursorPosition()
	   if(!(/^[a-zA-Z () ? _ {} -]*$/.test($(this).val())) ) {
	    $(this).val($(this).attr('data-value'))
	    $(this).setCursorPosition(cursor_pos - 1)
	    return
	  }
	  $(this).attr('data-value', $(this).val())
});*/
$('#aid').on('input', function() {
	   var cursor_pos = $(this).getCursorPosition()
	   if(!(/^[a-zA-Z 0-9 _-]*$/.test($(this).val())) ) {
	    $(this).val($(this).attr('data-value'))
	    $(this).setCursorPosition(cursor_pos - 1)
	    return
	  }
	  $(this).attr('data-value', $(this).val())
});
$('#article_type').on('input', function() {
	   var cursor_pos = $(this).getCursorPosition()
	   if(!(/^[a-zA-Z ]*$/.test($(this).val())) ) {
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
	
	$('input#journal_issue_number').keyup(function(e){ 
	    if(this.value.substring(0,1) == "0")
	    {
	       this.value = this.value.replace(/^0+/g, '');             
	    }         
	});

	$('#journal_issue_number').on('input', function() {
		   var cursor_pos = $(this).getCursorPosition()
		   if(!(/^[0-9]*$/.test($(this).val())) ) {
		    $(this).val($(this).attr('data-value'))
		    $(this).setCursorPosition(cursor_pos - 1)
		    return
		  }
		  $(this).attr('data-value', $(this).val())
	})

	$('input#journal_volume_number').keyup(function(e){ 
	    if(this.value.substring(0,1) == "0")
	    {
	       this.value = this.value.replace(/^0+/g, '');             
	    }         
	});
	$('#journal_volume_number').on('input', function() {
		   var cursor_pos = $(this).getCursorPosition()
		   if(!(/^[0-9]*$/.test($(this).val())) ) {
		    $(this).val($(this).attr('data-value'))
		    $(this).setCursorPosition(cursor_pos - 1)
		    return
		  }
		  $(this).attr('data-value', $(this).val())
	})
	
	$('input#noAuthor').keyup(function(e){ 
	    if(this.value.substring(0,1) == "0")
	    {
	       this.value = this.value.replace(/^0+/g, '');             
	    }         
	});
	$('#noAuthor').on('input', function() {
		   var cursor_pos = $(this).getCursorPosition()
		   if(!(/^[0-9]*$/.test($(this).val())) ) {
		    $(this).val($(this).attr('data-value'))
		    $(this).setCursorPosition(cursor_pos - 1)
		    return
		  }
		  $(this).attr('data-value', $(this).val())
	})
</script>


<script>
$(document).ready(function() {
$(".input").keyup(function(e) {
	//alert(e.which);
if ((e.which > 48 && e.which < 58)) {
	doWork();
}else{
return false;
}
});

// function doWork() {
// var number = $('.input').val();
// //$(".input").prop('disabled', true);
// //$(".numberofauthor").remove();
//  $('.rmv').remove();
// if (number) {
// 	for (var i = 0; i < number; i++) {
// 		$('.divtoappend').append("<div class='col-md-2 rmv' ><div class= 'form-group rmv'> <label for= 'currency' > Author Title <sup class= 'text-red'>&lowast;</sup></label> <select class='form-control' name='title' id='title' required > <option>Dr.</option> <option>Mr.</option> <option>Mrs.</option> <option>Ms.</option> <option>Miss.</option> </select></div></div></div></div>"
// 		+"<div class='col-md-2 rmv' ><div class= 'form-group rmv'> <label for= 'currency' >Author First Name <sup class= 'text-red'>&lowast;</sup></label> <input class='form-control' name='fname' id='fName' type= 'text' maxlength='50' autocomplete='off' onKeyUp='chText()' onKeyDown='chText()' required /></div></div>"
// 		+"<div class='col-md-2 rmv' ><div class= 'form-group rmv'> <label for= 'currency' >Author Middle Name <sup class= 'text-red'>&lowast;</sup></label> <input class='form-control' name='mname'' id='mName' value='-' type= 'text' maxlength='50' autocomplete='off' onKeyUp='chText1()' onKeyDown='chText1()' /></div></div>"
// 		+"<div class='col-md-2 rmv' ><div class= 'form-group rmv'> <label for= 'currency' >Author Last Name <sup class= 'text-red'>&lowast;</sup></label> <input class='form-control' name='lname' id='lName' type= 'text' maxlength='50' autocomplete='off' onKeyUp='chText2()' onKeyDown='chText2()' required /></div></div>"
// 		+"<div class='col-md-2 rmv' ><div class= 'form-group rmv'> <label for= 'currency' >Author Email<sup class= 'text-red'>&lowast;</sup></label> <input class='form-control' name='email' id='eMail' type= 'email' maxlength='60' autocomplete='off' onKeyUp='chText3()' onKeyDown='chText3()' required /></div></div>"
// 		+"<div class='col-md-2 rmv' ><div class= 'form-group rmv'> <label for= 'currency' >Is Corresponding<sup class= 'text-red'>&lowast;</sup></label> <select class='form-control' name='is_corresponding' id='is_corresponding' required > <option>Yes</option> <option>No</option> </select></div></div>")
// 		//<span class='?' >Span " + i.toString() + "</span>"
// 		}
//     }
// }
});
</script>
    
<script>

/* $(document).ready(function() {
	$(".input").keyup(function(e) {
		alert(e.which);
	if ((e.which < 48 && e.which > 57)) {
		doWork();
	}else{
	return false;
	}
	}); */
	
		function chText()
		{
		    var str=document.getElementById("fName");
		    var regex=/[^a-z-]/gi;
		    str.value=str.value.replace(regex ,"");
		}

		function chText1()
		{
		    var str=document.getElementById("mName");
		   // var regex=/[^a-z-]/gi;
		    //str.value=str.value.replace(regex ,"");
		}

		function chText2()
		{
		    var str=document.getElementById("lName");
		    var regex=/[^a-z-]/gi;
		    str.value=str.value.replace(regex ,"");
		}

		function chText3()
		{
		    var str=document.getElementById("eMail");
		    var regex=/[^a-z0-9 @ .]/gi;
		    str.value=str.value.replace(regex ,"");
		}
</script>