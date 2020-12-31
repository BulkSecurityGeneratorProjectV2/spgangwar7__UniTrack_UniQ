<%@ include file="/WEB-INF/includes/include.jsp" %>

	<div class="wrapper">
		<div class="main_part_outer" id="content">
			<div class="d-flex flex-column w-100 h-100">
				<div class="container-fluid">
				
				<form id="ingestion" name="ingestion" >
					<div class="row">
						<div class="col-md-12">
							<div class="main_tittle d-flex align-items-center">
								<span class="mr-2">Article Ingestion</span> <span class="ml-auto"><a
									href="javascript:;" class="btn btn-sm btn-outline-danger"
									onclick="IngestArticle()">Insert Article</a></span>
							</div>
						</div>
					</div>
					
			<div class="row">
			<div class="col-md-4">
					<div class="content_box">
									<div class="box-body">

							<c:forEach items="${map}" var="entry">
<%--    									 Key = ${entry.key}, value = ${entry.value}<br> --%>
   									  <c:forEach items="${entry.value}" var="temp">
   										<td>${temp}</br>${!loop.last ? ' ' : ''}</td>
   									 </c:forEach>
							</c:forEach>
						</div>
								</div>
								</div>
								<div class="col-md-4">
								<div class="content_box">
									<div class="box-body">

							<c:forEach items="${semierrorlist}" var="entry">
<%--    									 Key = ${entry.key}, value = ${entry.value}<br> --%>
   									 <c:forEach items="${entry.value}" var="temp">
   										<td>${temp}</br>${!loop.last ? ' ' : ''}</td>
   									 </c:forEach>
							</c:forEach>
						</div>
								</div>
								</div>
								<div class="col-md-4">
								<div class="content_box">
									<div class="box-body">

							<c:forEach items="${errorlist}" var="entry">
<%--    									 Key = ${entry.key}, value = ${entry.value}<br> --%>
   									  <c:forEach items="${entry.value}" var="temp" varStatus="loop">
   										<td>${temp}</br>${!loop.last ? ' ' : ''}</td>
   									 </c:forEach>
							</c:forEach>
						</div>
								</div>
								</div>
								
								</div>
			
					
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		 function IngestArticle(){
				document.getElementById("ingestion").action="insert-articles";
			    document.getElementById("ingestion").method="POST";
				document.getElementById("ingestion").submit();
			}
	
	</script>