<style type="text/css">

@import 'https://code.highcharts.com/css/highcharts.css';

#container {
	height: 400px;
	max-width: 800px;
	min-width: 320px;
	margin: 0 auto;
}
.highcharts-pie-series .highcharts-point {
	stroke: #EDE;
	stroke-width: 2px;
}
.highcharts-pie-series .highcharts-data-label-connector {
	stroke: silver;
	stroke-dasharray: 2, 2;
	stroke-width: 2px;
}

</style>
<%@ include file="/WEB-INF/includes/include.jsp" %>
<form name="mang" id="mang">
<div class="main_part_outer" id="content">
	<div class="d-flex flex-column w-100 h-100">
  	<div class="container-fluid">
    <!--main_tittle-->
    <div class="row">
       <div class="col-md-9">
           <div class="main_tittle">Planner Dashboard <span id="Date">Wednesday , 21 November 2018</span></div>
        <%--    <c:if test="${deptID eq null}">
           <h6></h6>
           </c:if>
             <c:if test="${deptID ne null}">
             <h6>Stat's for ${deptID}</h6>
             </c:if> --%>
        </div>
     <!--main_tittle_End-->
     
     <!--/*4 boxes*/-->
    
 

<div class="wrapper">
	<div class="main_part_outer" id="content" style="
    padding-top: 8px;">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<script src="https://code.highcharts.com/highcharts.js"></script>
				<script src="https://code.highcharts.com/modules/data.js"></script>
				<script src="https://code.highcharts.com/modules/drilldown.js"></script>
				<script src="https://code.highcharts.com/modules/exporting.js"></script>
				<script src="https://code.highcharts.com/modules/export-data.js"></script>
             <div class="border position-relative bg-white pt-3 pl-3 pr-3 mb-4 pb-0">
	<h5 class="boxHeading bg-blue">Articles</h5>
                <div class="row">
      <div class="col mb-3"> 
        <!-- small box -->
        <div class="small-box text-red d-flex align-items-center h-100 box-shadow" >
          	<h3> Total Article On Supplier  &nbsp;&nbsp;:&nbsp; ${totalarticleOnDept.size()}
            <span class="d-block text-capitalize text-small"><a href="#"  onclick="showAndHide('articalList')">More info <i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
              <div class="icon ml-auto">
              	<svg xmlns="https://www.w3.org/2000/svg" data-name="Layer 1" viewBox="0 0 100 100" x="0px" y="0px" class="main-icon">
					<g data-name="Group">
						<path data-name="Compound Path" d="M50,9.9A40.1,40.1,0,1,0,90.1,50,40.2,40.2,0,0,0,50,9.9ZM22.4,23.8l4.9,4.9,1.4-1.4-4.9-4.9A38,38,0,0,1,49,11.9v6.9h2V11.9A38,38,0,0,1,76.2,22.4l-4.9,4.9,1.4,1.4,4.9-4.9A38,38,0,0,1,88.1,49H81.2v2h6.9a37.9,37.9,0,0,1-2.6,13H58.8A8.8,8.8,0,0,0,51,55.3V36.7H49V55.3A8.8,8.8,0,0,0,41.2,64H14.6a37.9,37.9,0,0,1-2.6-13h6.9V49H11.9A38,38,0,0,1,22.4,23.8ZM50,57.2A6.8,6.8,0,1,1,43.2,64,6.8,6.8,0,0,1,50,57.2Zm0,30.9A38.2,38.2,0,0,1,15.4,66H41.5a8.7,8.7,0,0,0,17,0H84.6A38.2,38.2,0,0,1,50,88.1Z"/>
					</g>
                    </svg>
              </div>
          </div>
      </div>
       <!-- ./col -->
      
      <div class="col mb-3"> 
        <!-- small box -->
        <div class="small-box text-blue d-flex align-items-center h-100 box-shadow" >
        	<h3> Today's Pending Article On Supplier &nbsp;:&nbsp; ${totalarticleOnDeptToday.size()}
            <span class="d-block text-capitalize text-small"><a href="#" onclick="showAndHide('inprocess')">More info <i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
            <div class="icon ml-auto">
            	<svg xmlns="https://www.w3.org/2000/svg" xmlns:xlink="https://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve" class="main-icon"><g><path fill="#ff0000" d="M18.416,62.788c1.746,0,3.143-1.411,3.143-3.149c0-0.246-0.071-0.459-0.13-0.692L79.435,7.721l1.44,1.466   l1.629-6.504l-6.516,1.585l1.744,1.76L20.019,56.992c-0.492-0.291-0.996-0.491-1.601-0.491c-1.731,0-3.143,1.413-3.143,3.138   C15.273,61.377,16.684,62.788,18.416,62.788z M18.416,58.882c0.418,0,0.751,0.346,0.751,0.757c0,0.425-0.333,0.749-0.751,0.749   c-0.406,0-0.753-0.324-0.753-0.749C17.665,59.228,18.01,58.882,18.416,58.882z"/><path fill="#1b8ce2" d="M95.485,94.777h-2.267h-8.638V20.936c0-2.871-2.32-5.207-5.192-5.207c-2.855,0-5.178,2.336-5.178,5.207   v73.838h-4.537V32.893c0-2.857-2.321-5.178-5.208-5.178c-2.854,0-5.179,2.321-5.179,5.178v61.884h-4.555V47.27   c0-2.868-2.307-5.199-5.178-5.199c-2.856,0-5.189,2.331-5.189,5.199v47.507h-4.544V59.271c0-2.88-2.32-5.187-5.192-5.187   c-2.871,0-5.176,2.307-5.176,5.187v35.507h-4.557V73.619c0-2.865-2.305-5.183-5.192-5.183c-2.854,0-5.174,2.317-5.174,5.183v21.158   H6.77H4.513c-0.674,0-1.195,0.541-1.195,1.21c0,0.649,0.521,1.18,1.195,1.18h2.252h86.457h2.264c0.665,0,1.197-0.53,1.197-1.18   C96.683,95.318,96.15,94.777,95.485,94.777z M76.606,20.936c0-1.55,1.255-2.8,2.782-2.8c1.544,0,2.803,1.25,2.803,2.8v73.805   h-5.585V20.936z M61.683,32.893c0-1.529,1.255-2.779,2.783-2.779c1.545,0,2.802,1.25,2.802,2.779v61.848h-5.585V32.893   L61.683,32.893z M46.768,47.27c0-1.55,1.242-2.8,2.785-2.8c1.544,0,2.797,1.25,2.797,2.8v47.471h-5.58V47.27H46.768z    M31.859,59.271c0-1.537,1.239-2.804,2.768-2.804c1.544,0,2.8,1.267,2.8,2.804v35.471h-5.565V59.271H31.859z M16.917,73.619   c0-1.529,1.254-2.799,2.782-2.799c1.547,0,2.801,1.27,2.801,2.799v21.122h-5.581V73.619H16.917z"/></g></svg>
            </div>
        </div>
      </div>
    
      <div class="col mb-3"> 
        <!-- small box -->
        <div class="small-box text-blue d-flex align-items-center h-100 box-shadow" >
        	<h3>Total Article On Supplier (Virtual) &nbsp;:&nbsp; ${totalarticleOnDeptVirtual.size()}
            <span class="d-block text-capitalize text-small"><a href="#" onclick="showAndHide('overdue')">More info <i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
            <div class="icon ml-auto">
            <img src="/resources/images/icon/Overdue-icon.png"  class="img-fluid">
<!--             	<svg xmlns="https://www.w3.org/2000/svg" xmlns:xlink="https://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve" class="main-icon"><g><path fill="#ff0000" d="M18.416,62.788c1.746,0,3.143-1.411,3.143-3.149c0-0.246-0.071-0.459-0.13-0.692L79.435,7.721l1.44,1.466   l1.629-6.504l-6.516,1.585l1.744,1.76L20.019,56.992c-0.492-0.291-0.996-0.491-1.601-0.491c-1.731,0-3.143,1.413-3.143,3.138   C15.273,61.377,16.684,62.788,18.416,62.788z M18.416,58.882c0.418,0,0.751,0.346,0.751,0.757c0,0.425-0.333,0.749-0.751,0.749   c-0.406,0-0.753-0.324-0.753-0.749C17.665,59.228,18.01,58.882,18.416,58.882z"/><path fill="#1b8ce2" d="M95.485,94.777h-2.267h-8.638V20.936c0-2.871-2.32-5.207-5.192-5.207c-2.855,0-5.178,2.336-5.178,5.207   v73.838h-4.537V32.893c0-2.857-2.321-5.178-5.208-5.178c-2.854,0-5.179,2.321-5.179,5.178v61.884h-4.555V47.27   c0-2.868-2.307-5.199-5.178-5.199c-2.856,0-5.189,2.331-5.189,5.199v47.507h-4.544V59.271c0-2.88-2.32-5.187-5.192-5.187   c-2.871,0-5.176,2.307-5.176,5.187v35.507h-4.557V73.619c0-2.865-2.305-5.183-5.192-5.183c-2.854,0-5.174,2.317-5.174,5.183v21.158   H6.77H4.513c-0.674,0-1.195,0.541-1.195,1.21c0,0.649,0.521,1.18,1.195,1.18h2.252h86.457h2.264c0.665,0,1.197-0.53,1.197-1.18   C96.683,95.318,96.15,94.777,95.485,94.777z M76.606,20.936c0-1.55,1.255-2.8,2.782-2.8c1.544,0,2.803,1.25,2.803,2.8v73.805   h-5.585V20.936z M61.683,32.893c0-1.529,1.255-2.779,2.783-2.779c1.545,0,2.802,1.25,2.802,2.779v61.848h-5.585V32.893   L61.683,32.893z M46.768,47.27c0-1.55,1.242-2.8,2.785-2.8c1.544,0,2.797,1.25,2.797,2.8v47.471h-5.58V47.27H46.768z    M31.859,59.271c0-1.537,1.239-2.804,2.768-2.804c1.544,0,2.8,1.267,2.8,2.804v35.471h-5.565V59.271H31.859z M16.917,73.619   c0-1.529,1.254-2.799,2.782-2.799c1.547,0,2.801,1.27,2.801,2.799v21.122h-5.581V73.619H16.917z"/></g></svg> -->
            </div>
        </div>
      </div>
      
      <div class="col mb-3"> 
        <!-- small box -->
        <div class="small-box text-dark-green d-flex align-items-center h-100 box-shadow" >
          	<h3>Today's Pending Article On Supplier (Virtual)  &nbsp;:&nbsp; ${totalarticleOnDeptTodayVirtual.size()}
            <span class="d-block text-capitalize text-small"><a href="#" onclick="showAndHide('complete')">More info <i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
          
            <div class="icon ml-auto">
            
            	<svg class="main-icon" xmlns:dc="https://purl.org/dc/elements/1.1/" xmlns:cc="https://creativecommons.org/ns#" xmlns:rdf="https://www.w3.org/1999/02/22-rdf-syntax-ns#" xmlns:svg="https://www.w3.org/2000/svg" xmlns="https://www.w3.org/2000/svg" xmlns:sodipodi="https://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd" xmlns:inkscape="https://www.inkscape.org/namespaces/inkscape" version="1.1" x="0px" y="0px" viewBox="0 0 32 30" style="enable-background:new 0 0 32 32;" xml:space="preserve"><path style="" d="M 6 2 C 3.8 2 2 3.8 2 6 C 2 8.2 3.8 10 6 10 C 8.2 10 10 8.2 10 6 C 10 3.8 8.2 2 6 2 z M 6 3 C 7.7 3 9 4.3 9 6 C 9 7.7 7.7 9 6 9 C 4.3 9 3 7.7 3 6 C 3 4.3 4.3 3 6 3 z M 12.5 3 C 12.2 3 12 3.2 12 3.5 L 12 8.5 C 12 8.8 12.2 9 12.5 9 L 17.5 9 C 17.8 9 18 8.8 18 8.5 L 18 5.2011719 L 19.300781 3.9003906 C 19.500781 3.7003906 19.500781 3.3992188 19.300781 3.1992188 C 19.100781 2.9992188 18.799609 2.9992187 18.599609 3.1992188 L 18 3.7988281 L 18 3.5 C 18 3.2 17.8 3 17.5 3 L 12.5 3 z M 13 4 L 17 4 L 17 4.8007812 L 15.400391 6.4003906 L 14.300781 5.3007812 C 14.100781 5.1007812 13.799609 5.1007812 13.599609 5.3007812 C 13.399609 5.5007812 13.399609 5.8 13.599609 6 L 15 7.4003906 C 15.1 7.5003906 15.300391 7.5 15.400391 7.5 C 15.600391 7.5 15.700781 7.4003906 15.800781 7.4003906 L 17 6.2011719 L 17 8 L 13 8 L 13 4 z M 20.5 4 C 20.2 4 20 4.2 20 4.5 C 20 4.8 20.2 5 20.5 5 L 29.5 5 C 29.8 5 30 4.8 30 4.5 C 30 4.2 29.8 4 29.5 4 L 20.5 4 z M 4.8007812 4.5 A 0.5 0.5 0 0 0 4.3007812 5 A 0.5 0.5 0 0 0 4.8007812 5.5 A 0.5 0.5 0 0 0 5.3007812 5 A 0.5 0.5 0 0 0 4.8007812 4.5 z M 7.3007812 4.5 A 0.5 0.5 0 0 0 6.8007812 5 A 0.5 0.5 0 0 0 7.3007812 5.5 A 0.5 0.5 0 0 0 7.8007812 5 A 0.5 0.5 0 0 0 7.3007812 4.5 z M 20.5 6 C 20.2 6 20 6.2 20 6.5 C 20 6.8 20.2 7 20.5 7 L 26.5 7 C 26.8 7 27 6.8 27 6.5 C 27 6.2 26.8 6 26.5 6 L 20.5 6 z M 4.9492188 6.5507812 C 4.8242188 6.5507812 4.6996094 6.5992188 4.5996094 6.6992188 C 4.3996094 6.8992187 4.3996094 7.2003906 4.5996094 7.4003906 C 4.9996094 7.8003906 5.5 8 6 8 C 6.5 8 7.0003906 7.8003906 7.4003906 7.4003906 C 7.6003906 7.2003906 7.6003906 6.8992188 7.4003906 6.6992188 C 7.2003906 6.4992187 6.8992188 6.4992187 6.6992188 6.6992188 C 6.2992187 7.0992187 5.7007813 7.0992188 5.3007812 6.6992188 C 5.2007813 6.5992188 5.0742188 6.5507812 4.9492188 6.5507812 z M 6 12 C 3.8 12 2 13.8 2 16 C 2 18.2 3.8 20 6 20 C 8.2 20 10 18.2 10 16 C 10 13.8 8.2 12 6 12 z M 6 13 C 7.7 13 9 14.3 9 16 C 9 17.7 7.7 19 6 19 C 4.3 19 3 17.7 3 16 C 3 14.3 4.3 13 6 13 z M 12.5 13 C 12.2 13 12 13.2 12 13.5 L 12 18.5 C 12 18.8 12.2 19 12.5 19 L 17.5 19 C 17.8 19 18 18.8 18 18.5 L 18 13.5 C 18 13.2 17.8 13 17.5 13 L 12.5 13 z M 13 14 L 17 14 L 17 18 L 13 18 L 13 14 z M 20.5 14 C 20.2 14 20 14.2 20 14.5 C 20 14.8 20.2 15 20.5 15 L 29.5 15 C 29.8 15 30 14.8 30 14.5 C 30 14.2 29.8 14 29.5 14 L 20.5 14 z M 4.8007812 14.5 A 0.5 0.5 0 0 0 4.3007812 15 A 0.5 0.5 0 0 0 4.8007812 15.5 A 0.5 0.5 0 0 0 5.3007812 15 A 0.5 0.5 0 0 0 4.8007812 14.5 z M 7.3007812 14.5 A 0.5 0.5 0 0 0 6.8007812 15 A 0.5 0.5 0 0 0 7.3007812 15.5 A 0.5 0.5 0 0 0 7.8007812 15 A 0.5 0.5 0 0 0 7.3007812 14.5 z M 20.5 16 C 20.2 16 20 16.2 20 16.5 C 20 16.8 20.2 17 20.5 17 L 26.5 17 C 26.8 17 27 16.8 27 16.5 C 27 16.2 26.8 16 26.5 16 L 20.5 16 z M 4.9003906 16.5 C 4.6003906 16.5 4.4003906 16.7 4.4003906 17 C 4.4003906 17.3 4.6003906 17.5 4.9003906 17.5 L 7.0996094 17.5 C 7.2996094 17.5 7.5 17.3 7.5 17 C 7.5 16.7 7.3 16.5 7 16.5 L 4.9003906 16.5 z M 6 22 C 3.8 22 2 23.8 2 26 C 2 28.2 3.8 30 6 30 C 8.2 30 10 28.2 10 26 C 10 23.8 8.2 22 6 22 z M 6 23 C 7.7 23 9 24.3 9 26 C 9 27.7 7.7 29 6 29 C 4.3 29 3 27.7 3 26 C 3 24.3 4.3 23 6 23 z M 12.5 23 C 12.2 23 12 23.2 12 23.5 L 12 28.5 C 12 28.8 12.2 29 12.5 29 L 17.5 29 C 17.8 29 18 28.8 18 28.5 L 18 23.5 C 18 23.2 17.8 23 17.5 23 L 12.5 23 z M 13 24 L 17 24 L 17 28 L 13 28 L 13 24 z M 20.5 24 C 20.2 24 20 24.2 20 24.5 C 20 24.8 20.2 25 20.5 25 L 29.5 25 C 29.8 25 30 24.8 30 24.5 C 30 24.2 29.8 24 29.5 24 L 20.5 24 z M 4.8007812 24.5 A 0.5 0.5 0 0 0 4.3007812 25 A 0.5 0.5 0 0 0 4.8007812 25.5 A 0.5 0.5 0 0 0 5.3007812 25 A 0.5 0.5 0 0 0 4.8007812 24.5 z M 7.3007812 24.5 A 0.5 0.5 0 0 0 6.8007812 25 A 0.5 0.5 0 0 0 7.3007812 25.5 A 0.5 0.5 0 0 0 7.8007812 25 A 0.5 0.5 0 0 0 7.3007812 24.5 z M 20.5 26 C 20.2 26 20 26.2 20 26.5 C 20 26.8 20.2 27 20.5 27 L 26.5 27 C 26.8 27 27 26.8 27 26.5 C 27 26.2 26.8 26 26.5 26 L 20.5 26 z M 6 26.675781 C 5.475 26.675781 4.9496094 26.849219 4.5996094 27.199219 C 4.3996094 27.399219 4.3996094 27.700391 4.5996094 27.900391 C 4.7996094 28.100391 5.1007812 28.100391 5.3007812 27.900391 C 5.7007813 27.500391 6.2992187 27.500391 6.6992188 27.900391 C 6.7992187 28.000391 6.9996094 28 7.0996094 28 C 7.1996094 28 7.3003906 28.000391 7.4003906 27.900391 C 7.6003906 27.700391 7.6003906 27.399219 7.4003906 27.199219 C 7.0503906 26.849219 6.525 26.675781 6 26.675781 z " fill="#0f7e7d" stroke="none"/></svg>
            </div>
										
									</div>
      </div>
       <!-- ./col -->
       
    </div>
    </div>
    
                    <div class="row" id="new_project">
	                <div class="col-md-12">
	                <c:if test="${articleDetaillist.size() ge 1}">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">Article Details</span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="articleTable">
											<thead class="table-head">
												<tr>
													<th>Article Title</th>
													<th>Journal Name</th>
													<th>Publisher Name</th>
													<th>Articles DOI</th>
													<th>Articles ID</th>
													<th>Articles Type CD</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${articleDetaillist}"
													varStatus="counter">
													<tr>
														<td>${temp.article_title}</td>
														<td>${temp.journals.journalName}</td>
														<td>${temp.publisher.publisherName}</td>
														<td>${temp.article_doi}</td>
														<td>${temp.aid}</td>
														<td>${temp.article_type_cd}</td>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</c:if>
							</div>
						</div>
						 <div class="row" id="inprocess_project">
	                <div class="col-md-12">
	                <c:if test="${articleInProgressDetail.size() ge 1}">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">InProgress Article</span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="inprocess">
											<thead class="table-head">
												<tr>
													<th>Articles Title</th>
													<th>Journal Name</th>
													<th>Publisher Name</th>
													<th>Articles DOI</th>
													<th>Articles ID</th>
													<th>Articles Type CD</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${articleInProgressDetail}"
													varStatus="counter">
													<tr>
														<td>${temp.article_title}</td>
														<td>${temp.journalName}</td>
														<td>${temp.publisherName}</td>
														<td>${temp.article_doi}</td>
														<td>${temp.aid}</td>
														<td>${temp.article_type_cd}</td>
														</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</c:if>
							</div>
						</div>
						 <div class="row" id="overdue_project">
	                <div class="col-md-12">
	                <c:if test="${articleOverDueDetail.size() ge 1}">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">Overdue Article</span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="overdue">
											<thead class="table-head">
												<tr>
													<th>Articles Title</th>
													<th>Journal Name</th>
													<th>Publisher Name</th>
													<th>Articles DOI</th>
													<th>Articles ID</th>
													<th>Articles Type CD</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${articleOverDueDetail}"
													varStatus="counter">
													<tr>
														<td>${temp.article_title}</td>
														<td>${temp.journalName}</td>
														<td>${temp.publisherName}</td>
														<td>${temp.article_doi}</td>
														<td>${temp.aid}</td>
														<td>${temp.article_type_cd}</td>
														</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</c:if>
							</div>
						</div>
						
						<div class="row" id="complete_project">
	                <div class="col-md-12">
	                <c:if test="${articlecompleteDetail.size() ge 1}">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">Completed Articles</span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0"
											id="completeArticle">
											<thead class="table-head">
												<tr>
													<th>Articles Title</th>
													<th>Journal Name</th>
													<th>Publisher Name</th>
													<th>Articles DOI</th>
													<th>Articles ID</th>
													<th>Articles Type CD</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${articlecompleteDetail}"
													varStatus="counter">
													<tr>
														<td>${temp.article_title}</td>
														<td>${temp.journalName}</td>
														<td>${temp.publisherName}</td>
														<td>${temp.article_doi}</td>
														<td>${temp.aid}</td>
														<td>${temp.article_type_cd}</td>
														</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</c:if>
							</div>
						</div>
		

    <!--main_tittle-->
<!--     <div class="row">
       <div class="col-md-12">
           <div class="main_tittle">Processing Performance</div>
        </div>
     </div>
     main_tittle_End
     
      <div class="row">
      <div class="col mb-4"> 
        small box
        <div class="small-box text-red d-flex align-items-center h-100 box-shadow">
          	<h3>Length of the Queue  
          	</br>
            <span class="d-block text-capitalize text-midium text-blue">
				3 Articles
			</span>
			</h3>
              <div class="icon ml-auto">
              <img src="/resources/images/icon/Average-Quality-Score-icon.png" class="img-fluid">
              </div>
          </div>
      </div>
       ./col
      
      <div class="col mb-4"> 
        small box
        <div class="small-box text-red d-flex align-items-center h-100 box-shadow" >
        	<h3>Avg. Time 
            <span class="d-block text-capitalize text-midium text-blue"> 2.7 Min. per Articles</span>
            </h3>
            <div class="icon ml-auto">
            	<img src="/resources/images/icon/Average-TAT-icon.png" class="img-fluid">
            </div>
        </div>
      </div>
    
      
      <div class="col mb-4"> 
        small box
        <div class="small-box text-dark-green d-flex align-items-center h-100 box-shadow" >
          	<h3>Articles Processed today
            <span class="d-block text-capitalize text-midium text-blue"> 1</span>
            </h3>
          
            <div class="icon ml-auto">
            	<svg xmlns="https://www.w3.org/2000/svg"   data-name="Layer 1" viewBox="0 0 100 100" x="0px" y="0px" class="main-icon">
					<g data-name="Group">
						<path data-name="Compound Path" fill="#0f7e7d" d="M50,9.9A40.1,40.1,0,1,0,90.1,50,40.2,40.2,0,0,0,50,9.9ZM22.4,23.8l4.9,4.9,1.4-1.4-4.9-4.9A38,38,0,0,1,49,11.9v6.9h2V11.9A38,38,0,0,1,76.2,22.4l-4.9,4.9,1.4,1.4,4.9-4.9A38,38,0,0,1,88.1,49H81.2v2h6.9a37.9,37.9,0,0,1-2.6,13H58.8A8.8,8.8,0,0,0,51,55.3V36.7H49V55.3A8.8,8.8,0,0,0,41.2,64H14.6a37.9,37.9,0,0,1-2.6-13h6.9V49H11.9A38,38,0,0,1,22.4,23.8ZM50,57.2A6.8,6.8,0,1,1,43.2,64,6.8,6.8,0,0,1,50,57.2Zm0,30.9A38.2,38.2,0,0,1,15.4,66H41.5a8.7,8.7,0,0,0,17,0H84.6A38.2,38.2,0,0,1,50,88.1Z"></path>
					</g>
                    </svg>
            </div>
										
									</div>
      </div>
       ./col
       
    </div>
      /*content_box*/
     	<div class="row">
     		 
        	<div class="col-12 col-md-4 col-lg-4">
                   ./col
                    small box
                    <div class="content_box box-shadow">
                    <div class="box-header with-border"> <div class="box-title"> Articles Processing Details</div></div>
                    <div class="box-body with-border">
                      <div class="inner">
                         
                         <table class="table table-bordered">
                         <tr>
	                         <th>Maximum Article process per Day</th>
	                         <th>Articles processed today</th>
	                         <th>Average Article Time to Publish</th>
                         
                         <tr>
                         <td>480</td>
                         <td>325</td>
                         <td>2 days</td>
                         </tr>
                         </table>
                         <ul class="custBlock">
                            <li class="w-100 mb-3 ">Maximum Articles process per Day? <span class="badge badge-pill badge-warning"  >480</span></li>
                            <li class="w-100 mb-3"> How Many Articles can be processed today? <span class="badge badge-pill badge-warning"  >325</span></li>
                            <li class="w-100 mb-1"> Average Articles Time to Publish: <span class="badge badge-pill badge-warning"  >2 days</span></li>
                        </ul> 
                      </div>
                       
                      </div>
                    </div>  
                      small box
                   <div class="content_box box-shadow" style="cursor: pointer;">
                    <div class="box-header with-border"> <div class="box-title"> Platform Stats</div></div>
                    <div class="box-body with-border">
                      <div class="inner">
                
                        <ul class="custBlock">
                            <li class="w-100 mb-3 "> Users <span class="badge badge-pill badge-success" >1</span></li>
                            <li class="w-100 mb-3 "> Journal Setup <span class="badge badge-pill badge-success"  >3</span></li>
                            <li class="w-100 mb-1 "> Workflow Setup <span class="badge badge-pill badge-success" >3</span></li>
                        </ul>
                      </div>
                      </div>
                     </div>
                     
                    
                  
                   ./col
                   
               
 </div>
            
            <div class="col-12 col-md-8 col-lg-8">
            	<div class="content_box box-shadow">
                  box-header 
                    <div class="box-header with-border">
                    	<div class="row">
                       	  <div class="col-12">
                            	<div class="box-title">Total Articles Processed</div>
                            	<div id="chartGraph"></div>
                                <select class="form-control float-right" id="chart" onchange="getChart()">
                                    <option value="0">Select Action </option>
                                    <option value="1">Yearly Trend</option>
                                    <option value="2">Monthly Trend</option>
                                    <option value="3" selected="">Weekly Trend</option>
                                </select>
                            </div>
                        </div>
                  </div>
                  box-header 
                  
                  
                    box-body
                    <div class="box-body text-center" >
                    <div class="w-100" id="linechart_material"></div>
                    	<img src="/resources/img/Article-Processed-graph.png" class="img-fluid">
                    </div>
                    box-body 
                    box-footer  
                       <div class="box-footer text-right">
                       	<a href="#" class="btn-white-small"><img src="images/icon/send_notification_icon.png"><span> Send Reminder</span></a> 
                        <a href="#" class="btn-white-small"><img src="images/icon/export_sheet_icon.png"><span> Export Tasks List</span></a>
                       </div>
                        box-footer 
                    </div>
            </div>
        </div> -->
      <!--/*content_box_end*/-->
    <!--  <div class="row">
					<div class="col-md-12">
					<div class="content_box">
					<div class="box-body">
						<div id="container" style="width:100%; margin: 0 auto"></div>
					</div>
					</div>
				</div>
				</div>

				
				<div class="row">


					<div class="col-md-6">
						<div class="content_box">
							<div class="box-body">
								<div id="containerpie" style="min-width: 310px; max-width: 600px; height: 400px; margin: 0 auto"></div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="content_box">
							<div class="box-body">
								<div id="containerbar" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
							</div>
						</div>
					</div>
				</div> -->
     
  </div>
  

  

				
				
			</div>
		</div>
		</div>
	</div>
</div>
</div></div>
</form>
            <div class="col-md-12">	
				<div class="row">
			  
				<div class="col-md-6">
				<div id="container"></div>
				</div>
				
				<div class="col-md-6">
				<div id="containerone">
				</div>
				</div>
             </div>
             </div>
<script src="resources/js/drildownmis.js"></script>
<script src="resources/js/drildownmis2.js"></script>
<script src="resources/js/drildownmis3.js"></script>

<script type="text/javascript">
function showproject(){
		document.getElementById("mang").action="/dashboard";
		document.getElementById("mang").method="POST";
		document.getElementById("mang").submit();
	}
	
function showAndHide(val){
	//alert(val)
	if(val=='inprocess'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "block";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
		
	}
	else if(val=='overdue'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "block";
		document.getElementById("complete_project").style.display = "none";
	}
	
	else if(val=='articalList'){
		document.getElementById("new_project").style.display = "block";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
	}
	else if(val=='complete'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "block";
	}
	else if(val==''){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
	}
}


</script>
<script type="text/javascript">

$(document).ready(function() {
    $('#overdue').DataTable();
} );
$(document).ready(function() {
    $('#completeArticle').DataTable();
} );
$(document).ready(function() {
    $('#inprocess').DataTable();
} );
$(document).ready(function() {
	document.getElementById("new_project").style.display = "none";
	document.getElementById("inprocess_project").style.display = "none";
	document.getElementById("overdue_project").style.display = "none";
	document.getElementById("complete_project").style.display = "none";
} );
    
</script>


<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>


 <script type="text/javascript">  
 Highcharts.chart('container', {

	    chart: {
	        styledMode: true
	    },

	    title: {
	        text: 'Total Article On Department /Today'
	    },

	   
	    series: [{
	        type: 'pie',
	        allowPointSelect: true,
	        keys: ['name', 'y', 'selected', 'sliced'],
	        data: [
	            ['Total Article On Department', ${totalarticlDept}, false],
	            ['Total Article On Department Today', ${totalarticleDeptToday}, false]
	            
	        ],
	        showInLegend: true
	    }]
	});
</script>

<script type="text/javascript">  
 Highcharts.chart('containerone', {

	    chart: {
	        styledMode: true
	    },

	    title: {
	        text: 'Day Wise Current Article Load'
	    },

	   
	    series: [{
	        type: 'pie',
	        allowPointSelect: true,
	        keys: ['name', 'y', 'selected', 'sliced'],
	        data: [
	            ['Total Article On Dept Virtual', ${totalarticleDeptVirtual}, false],
	            ['Total Article On Dept Today Virtual', ${totalarticleDeptTodayVirtual}, false]
	            
	        ],
	        showInLegend: true
	    }]
	});
</script>