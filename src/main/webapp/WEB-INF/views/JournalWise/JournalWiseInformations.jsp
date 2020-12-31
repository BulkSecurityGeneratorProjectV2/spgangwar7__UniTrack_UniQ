<%@ include file="/WEB-INF/includes/include.jsp"%>
<style>
@-webkit-keyframes animatebottom {
  from { bottom:-100px; opacity:0 } 
  to { bottom:0px; opacity:1 }
}

@keyframes animatebottom { 
  from{ bottom:-100px; opacity:0 } 
  to{ bottom:0; opacity:1 }
}
</style>
<body>
	<div class="main_part_outer" id="content" >

		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<section class="" >
					<form id="jAbbr">
						<div class="container">
							<div class="row">
								<div class="col-sm-12">
									<h4 class="text-center">Select Journals</h4>

									<div class="srch-boxx">
										<input
											class="form-control"
											placeholder="Search Journals Here" type="search"
											id="searchText">&nbsp; &nbsp;
									</div>
								</div>
							</div>
								<div class="row overflow-auto">
									<div class="col-sm-12 ">
										<div class=" clearfix">
											<ul class="clearfix list-group">
												<c:forEach var="journalList" items="${journalList}"
													varStatus="counter">
													<%-- <input type="button" onclick='showArticle("${journalList.journalAbbrName}")'> --%>
													<li 
														class=" list-group-item text-center p-3 mb-2 bg-primary text-white rounded-left rounded-right"><a class="text-white"
														href="${context}/journal-${journalList.journalAbbrName}">${journalList.journalName}</a></li>
													
												</c:forEach>

											</ul>
										</div>
									</div>
								</div>
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>

	<!-- <script> 
	$('#searchText').onKeyPress(function() {
	    var searchString = $(this).val();
	    $("ul li").each(function(index, value) {
	        
	        currentName = $(value).text()
	        if( currentName.toUpperCase().indexOf(searchString.toUpperCase()) > -1) {
	           $(value).show();
	        } else {
	            $(value).hide();
	        }
	        
	    });
	    
	});
</script>
 -->
	<script>
		function showArticle(jabbr) {
			//	alert("fun call");
			document.getElementById("jAbbr").action = jabbr;
			document.getElementById("jAbbr").method = "POST";
			document.getElementById("jAbbr").submit();
		}
	</script>

</body>