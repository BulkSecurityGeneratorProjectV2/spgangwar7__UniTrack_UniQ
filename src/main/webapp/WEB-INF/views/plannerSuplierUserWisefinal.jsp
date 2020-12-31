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
 

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				    <div class="row">
				       <div class="col-md-9">
				           <div class="main_tittle">Planner's Dashboard User Wise<span id="Date">Wednesday , 21 November 2018</span></div>
				        <%--    <c:if test="${deptID eq null}">
				           <h6></h6>
				           </c:if>
				             <c:if test="${deptID ne null}">
				             <h6>Stat's for ${deptID}</h6>
				             </c:if> --%>
				        </div>
				       </div>
				     <!--main_tittle_End-->
			
				<script src="https://code.highcharts.com/highcharts.js"></script>
				<script src="https://code.highcharts.com/modules/data.js"></script>
				<script src="https://code.highcharts.com/modules/drilldown.js"></script>
				<script src="https://code.highcharts.com/modules/exporting.js"></script>
				<script src="https://code.highcharts.com/modules/export-data.js"></script>
             <div class="">
	<!-- <h5 class="boxHeading bg-blue">Articles</h5> -->
                <div class="row">
      <div class="col col-md-4 mb-3"> 
        <!-- small box -->
        <div class="small-box bg-dark-green-gradient d-flex align-items-center h-100 text-white" >
          	<h3> My Task &nbsp;:&nbsp; ${taskManagementVo.size()}
            <span class="d-block text-capitalize text-small"><a href="#" class="text-white"  onclick="showAndHide('articalList')">More info <i class="fa fa-long-arrow-right"></i></a></span>
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
      
      <div class="col col-md-4 mb-3"> 
        <!-- small box -->
        <div class="small-box bg-blue-gradient d-flex align-items-center h-100 text-white" >
        	<h3>Today's Target (Articles) &nbsp;:&nbsp; ${totalarticleavailableToday.size()}
            <span class="d-block text-capitalize text-small"><a href="#" class="text-white" onclick="showAndHide('inprocess')">More info <i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
            <div class="icon ml-auto">
            	<svg xmlns="https://www.w3.org/2000/svg" xmlns:xlink="https://www.w3.org/1999/xlink" class="main-icon" version="1.1" x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve" class="main-icon"><g><path fill="#ff0000" d="M18.416,62.788c1.746,0,3.143-1.411,3.143-3.149c0-0.246-0.071-0.459-0.13-0.692L79.435,7.721l1.44,1.466   l1.629-6.504l-6.516,1.585l1.744,1.76L20.019,56.992c-0.492-0.291-0.996-0.491-1.601-0.491c-1.731,0-3.143,1.413-3.143,3.138   C15.273,61.377,16.684,62.788,18.416,62.788z M18.416,58.882c0.418,0,0.751,0.346,0.751,0.757c0,0.425-0.333,0.749-0.751,0.749   c-0.406,0-0.753-0.324-0.753-0.749C17.665,59.228,18.01,58.882,18.416,58.882z"/><path fill="#1b8ce2" d="M95.485,94.777h-2.267h-8.638V20.936c0-2.871-2.32-5.207-5.192-5.207c-2.855,0-5.178,2.336-5.178,5.207   v73.838h-4.537V32.893c0-2.857-2.321-5.178-5.208-5.178c-2.854,0-5.179,2.321-5.179,5.178v61.884h-4.555V47.27   c0-2.868-2.307-5.199-5.178-5.199c-2.856,0-5.189,2.331-5.189,5.199v47.507h-4.544V59.271c0-2.88-2.32-5.187-5.192-5.187   c-2.871,0-5.176,2.307-5.176,5.187v35.507h-4.557V73.619c0-2.865-2.305-5.183-5.192-5.183c-2.854,0-5.174,2.317-5.174,5.183v21.158   H6.77H4.513c-0.674,0-1.195,0.541-1.195,1.21c0,0.649,0.521,1.18,1.195,1.18h2.252h86.457h2.264c0.665,0,1.197-0.53,1.197-1.18   C96.683,95.318,96.15,94.777,95.485,94.777z M76.606,20.936c0-1.55,1.255-2.8,2.782-2.8c1.544,0,2.803,1.25,2.803,2.8v73.805   h-5.585V20.936z M61.683,32.893c0-1.529,1.255-2.779,2.783-2.779c1.545,0,2.802,1.25,2.802,2.779v61.848h-5.585V32.893   L61.683,32.893z M46.768,47.27c0-1.55,1.242-2.8,2.785-2.8c1.544,0,2.797,1.25,2.797,2.8v47.471h-5.58V47.27H46.768z    M31.859,59.271c0-1.537,1.239-2.804,2.768-2.804c1.544,0,2.8,1.267,2.8,2.804v35.471h-5.565V59.271H31.859z M16.917,73.619   c0-1.529,1.254-2.799,2.782-2.799c1.547,0,2.801,1.27,2.801,2.799v21.122h-5.581V73.619H16.917z"/></g></svg>
            </div>
        </div>
      </div>
      <div class="col col-md-4 mb-3"> 
        <!-- small box -->
        <div class="small-box bg-orange-gradient d-flex align-items-center h-100 text-white" >
        	<h3>Total Overdue Articles &nbsp;:&nbsp; ${totalarticleavailablepastdate.size()}
            <span class="d-block text-capitalize text-small"><a href="#" class="text-white" onclick="showAndHide('complete')">More info <i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
            <div class="icon ml-auto">
            	<svg xmlns="http://www.w3.org/2000/svg" id="Layer_2_copy_2" data-name="Layer 2 copy 2" viewBox="0 0 64 64" class="main-icon" width="100%" height="100%"><path d="M45.267,39.462,33,31.458V12a1,1,0,0,0-2,0V32.542l13.173,8.6a1,1,0,1,0,1.094-1.676Z"/><path d="M32,0A32,32,0,1,0,64,32,32,32,0,0,0,32,0ZM53.893,52.479l-1.9-1.9A1,1,0,0,0,50.583,52l1.9,1.9A29.881,29.881,0,0,1,33,61.975V59a1,1,0,0,0-2,0v2.975a29.881,29.881,0,0,1-19.479-8.081l1.9-1.9A1,1,0,0,0,12,50.583l-1.9,1.9A29.881,29.881,0,0,1,2.025,33H5a1,1,0,0,0,0-2H2.025a29.881,29.881,0,0,1,8.081-19.479l1.9,1.9A1,1,0,0,0,13.417,12l-1.9-1.9A29.881,29.881,0,0,1,31,2.025V5a1,1,0,0,0,2,0V2.025a29.881,29.881,0,0,1,19.479,8.081l-1.9,1.9A1,1,0,1,0,52,13.417l1.9-1.9A29.881,29.881,0,0,1,61.975,31H59a1,1,0,0,0,0,2h2.975A29.881,29.881,0,0,1,53.893,52.479Z"/></svg>
			</div>
        </div>
      </div>
    
      <div class="col col-md-4 mb-3"> 
        <!-- small box -->
        <div class="small-box bg-green-gradient d-flex align-items-center h-100 text-white" >
        	<h3>Overdue Articles &nbsp;:&nbsp; ${totalarticleavailablepast24.size()}
            <span class="d-block text-capitalize text-small"><a href="#" class="text-white" onclick="showAndHide('overdue')">More info <i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
            <div class="icon ml-auto">
            <svg version="1.1" id="Layer_2_copy_2" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
	 y="0px" viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" class="main-icon" width="100%" height="100%" xml:space="preserve">
<g>
	<path d="M186.1,251.3v-12l10.9-9.8c18.7-16.7,27.7-26.3,27.9-36.2c0-6.9-4.1-12.4-13.9-12.4c-7.3,0-13.7,3.7-18.2,6.9l-5.6-14.1
		c6.3-4.8,16.4-8.8,27.7-8.8c19.4,0,29.8,11.3,29.8,26.6c0,14.4-10.2,25.8-22.6,36.8l-7.8,6.5v0.3h32.2v16.4H186.1z"/>
	<path d="M293.7,251.3V231H256v-13l32-51.8h24.5v49.8h10.1V231h-10.1v20.3H293.7z M293.7,216.1v-18.8c0-5.1,0.3-10.3,0.5-15.8h-0.4
		c-2.7,5.5-5.1,10.5-8,15.8l-11.3,18.6l-0.1,0.3H293.7z"/>
</g>
<g>
	<g>
		<path d="M127.2,269v26.6H152V269h15v69.3h-15v-29h-24.8v29h-15V269H127.2z"/>
		<path d="M236.3,302.9c0,22.8-13.2,36.5-32.7,36.5c-19.7,0-31.4-15.5-31.4-35.4c0-20.8,12.9-36.3,32.4-36.3
			C225.1,267.8,236.3,283.7,236.3,302.9z M188.1,303.8c0,13.7,6.1,23.2,16.2,23.2c10.2,0,16-10.1,16-23.5c0-12.5-5.6-23.2-16-23.2
			C194,280.2,188.1,290.3,188.1,303.8z"/>
		<path d="M256.3,269v39.8c0,12,4.5,18.1,12.1,18.1c7.9,0,12.3-5.8,12.3-18.1V269h15v38.9c0,21.4-10.4,31.6-27.8,31.6
			c-16.8,0-26.6-9.8-26.6-31.8V269H256.3z"/>
		<path d="M303.7,269.9c4.8-0.8,12-1.4,20.1-1.4c9.9,0,16.8,1.5,21.6,5.4c4.1,3.3,6.2,8.2,6.2,14.6c0,8.7-6,14.8-11.8,17v0.3
			c4.6,2,7.2,6.5,8.9,12.8c2.1,7.9,4.1,17,5.3,19.6h-15.4c-1-2.1-2.7-7.6-4.5-16.1c-1.9-8.7-4.7-11-11-11.1h-4.5v27.2h-14.9V269.9z
			 M318.7,299.7h5.9c7.5,0,12-3.9,12-10c0-6.3-4.2-9.6-11.1-9.6c-3.7,0-5.7,0.2-6.8,0.5V299.7z"/>
		<path d="M357.9,322.2c4,2.2,10.3,4.3,16.7,4.3c6.9,0,10.6-3,10.6-7.5c0-4.3-3.2-6.8-11.2-9.7c-11.1-4.1-18.4-10.5-18.4-20.6
			c0-11.8,9.6-20.8,25.2-20.8c7.6,0,13.1,1.5,17,3.5l-3.4,12.5c-2.6-1.3-7.4-3.3-13.8-3.3c-6.5,0-9.7,3.2-9.7,6.7
			c0,4.4,3.7,6.4,12.4,9.8c11.8,4.5,17.2,10.9,17.2,20.7c0,11.6-8.5,21.5-26.8,21.5c-7.6,0-15.1-2.2-18.9-4.3L357.9,322.2z"/>
	</g>
</g>
<g transform="translate(0,-288.53332)">
	<path d="M246.4,338.7c-3,0-5.9,0.3-8.9,0.5v28.3h17.7v-28.3C252.3,339,249.4,338.8,246.4,338.7L246.4,338.7z"/>
	<path d="M151.3,362c-5.2,2.7-10.3,5.7-15.3,8.9l14.2,24.7l15.3-8.9L151.3,362z"/>
	<path d="M341.5,362.1l-14.2,24.7l15.4,8.9l14.2-24.6C351.9,367.8,346.8,364.9,341.5,362.1L341.5,362.1z"/>
	<path d="M72.8,434.1c-3.2,5-6.2,10.1-8.9,15.3l24.7,14.3l8.9-15.4L72.8,434.1z"/>
	<path d="M419.9,434.2l-24.5,14.1l8.9,15.4l24.5-14.1C426,444.3,423,439.2,419.9,434.2z"/>
	<path d="M41,535.7c-0.1,3-0.4,5.9-0.4,8.9c0,3,0.3,5.9,0.4,8.8h28.3v-17.7H41z"/>
	<path d="M88.6,625.5l-24.7,14.3c2.7,5.3,5.7,10.4,8.9,15.3l24.7-14.3L88.6,625.5z"/>
	<path d="M150.2,693.5l-14.3,24.7c5,3.2,10.1,6.2,15.3,8.9l14.3-24.8L150.2,693.5z"/>
	<path d="M246.5,305.5C114.5,305.5,7.4,412.7,7.4,544.6s107.1,239.1,239.1,239.1c12,0.2,12-17.9,0-17.7
		c-122.4,0-221.4-99-221.4-221.4s99-221.4,221.4-221.4c109.5,0,200,79.3,217.9,183.6h17.8C464.1,392.9,365.5,305.5,246.5,305.5z"/>
	<path d="M512,524.6L476.6,560l-35.4-35.4H512z"/>
	<path d="M297.5,769.2c-1.3-4.7,1.5-9.6,6.3-10.8c4.7-1.3,9.6,1.5,10.8,6.3c0,0,0,0,0,0c1.3,4.7-1.5,9.6-6.3,10.8
		C303.6,776.8,298.7,774,297.5,769.2L297.5,769.2z"/>
	<path d="M353.9,748.4c-2.4-4.2-1-9.7,3.2-12.1c0,0,0,0,0,0c4.2-2.4,9.6-1,12.1,3.2c2.4,4.2,1,9.7-3.2,12.1c0,0,0,0,0,0
		C361.7,754.1,356.3,752.6,353.9,748.4z"/>
	<path d="M403,713.6c-3.5-3.5-3.5-9.1,0-12.5c3.5-3.5,9.1-3.5,12.5,0c0,0,0,0,0,0c3.5,3.5,3.5,9.1,0,12.5
		C412,717.1,406.4,717.1,403,713.6C403,713.6,403,713.6,403,713.6z"/>
	<path d="M441.4,667.3c-4.2-2.4-5.7-7.9-3.2-12.1c0,0,0,0,0,0c2.4-4.2,7.9-5.7,12.1-3.2c4.2,2.4,5.7,7.9,3.2,12.1c0,0,0,0,0,0
		C451,668.3,445.6,669.8,441.4,667.3z"/>
	<path d="M466.5,612.7c-4.7-1.3-7.5-6.1-6.3-10.8c1.3-4.7,6.1-7.5,10.8-6.3c0,0,0,0,0,0c4.7,1.3,7.5,6.1,6.3,10.8
		C476.1,611.2,471.2,614,466.5,612.7L466.5,612.7z"/>
</g>
</svg>
            </div>
        </div>
      </div>
      
     <%--  <div class="col mb-3"> 
        <!-- small box -->
        <div class="small-box text-dark-green d-flex align-items-center h-100 box-shadow" >
          	<h3>Total Article for Past Two Day &nbsp;:&nbsp; ${totalarticleavailablepast48.size()}
            <span class="d-block text-capitalize text-small"><a href="#" onclick="showAndHide('complete')">More info <i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
          
            <div class="icon ml-auto">
            
            	<svg class="main-icon" xmlns:dc="https://purl.org/dc/elements/1.1/" xmlns:cc="https://creativecommons.org/ns#" xmlns:rdf="https://www.w3.org/1999/02/22-rdf-syntax-ns#" xmlns:svg="https://www.w3.org/2000/svg" xmlns="https://www.w3.org/2000/svg" xmlns:sodipodi="https://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd" xmlns:inkscape="https://www.inkscape.org/namespaces/inkscape" version="1.1" x="0px" y="0px" viewBox="0 0 32 30" style="enable-background:new 0 0 32 32;" xml:space="preserve"><path style="" d="M 6 2 C 3.8 2 2 3.8 2 6 C 2 8.2 3.8 10 6 10 C 8.2 10 10 8.2 10 6 C 10 3.8 8.2 2 6 2 z M 6 3 C 7.7 3 9 4.3 9 6 C 9 7.7 7.7 9 6 9 C 4.3 9 3 7.7 3 6 C 3 4.3 4.3 3 6 3 z M 12.5 3 C 12.2 3 12 3.2 12 3.5 L 12 8.5 C 12 8.8 12.2 9 12.5 9 L 17.5 9 C 17.8 9 18 8.8 18 8.5 L 18 5.2011719 L 19.300781 3.9003906 C 19.500781 3.7003906 19.500781 3.3992188 19.300781 3.1992188 C 19.100781 2.9992188 18.799609 2.9992187 18.599609 3.1992188 L 18 3.7988281 L 18 3.5 C 18 3.2 17.8 3 17.5 3 L 12.5 3 z M 13 4 L 17 4 L 17 4.8007812 L 15.400391 6.4003906 L 14.300781 5.3007812 C 14.100781 5.1007812 13.799609 5.1007812 13.599609 5.3007812 C 13.399609 5.5007812 13.399609 5.8 13.599609 6 L 15 7.4003906 C 15.1 7.5003906 15.300391 7.5 15.400391 7.5 C 15.600391 7.5 15.700781 7.4003906 15.800781 7.4003906 L 17 6.2011719 L 17 8 L 13 8 L 13 4 z M 20.5 4 C 20.2 4 20 4.2 20 4.5 C 20 4.8 20.2 5 20.5 5 L 29.5 5 C 29.8 5 30 4.8 30 4.5 C 30 4.2 29.8 4 29.5 4 L 20.5 4 z M 4.8007812 4.5 A 0.5 0.5 0 0 0 4.3007812 5 A 0.5 0.5 0 0 0 4.8007812 5.5 A 0.5 0.5 0 0 0 5.3007812 5 A 0.5 0.5 0 0 0 4.8007812 4.5 z M 7.3007812 4.5 A 0.5 0.5 0 0 0 6.8007812 5 A 0.5 0.5 0 0 0 7.3007812 5.5 A 0.5 0.5 0 0 0 7.8007812 5 A 0.5 0.5 0 0 0 7.3007812 4.5 z M 20.5 6 C 20.2 6 20 6.2 20 6.5 C 20 6.8 20.2 7 20.5 7 L 26.5 7 C 26.8 7 27 6.8 27 6.5 C 27 6.2 26.8 6 26.5 6 L 20.5 6 z M 4.9492188 6.5507812 C 4.8242188 6.5507812 4.6996094 6.5992188 4.5996094 6.6992188 C 4.3996094 6.8992187 4.3996094 7.2003906 4.5996094 7.4003906 C 4.9996094 7.8003906 5.5 8 6 8 C 6.5 8 7.0003906 7.8003906 7.4003906 7.4003906 C 7.6003906 7.2003906 7.6003906 6.8992188 7.4003906 6.6992188 C 7.2003906 6.4992187 6.8992188 6.4992187 6.6992188 6.6992188 C 6.2992187 7.0992187 5.7007813 7.0992188 5.3007812 6.6992188 C 5.2007813 6.5992188 5.0742188 6.5507812 4.9492188 6.5507812 z M 6 12 C 3.8 12 2 13.8 2 16 C 2 18.2 3.8 20 6 20 C 8.2 20 10 18.2 10 16 C 10 13.8 8.2 12 6 12 z M 6 13 C 7.7 13 9 14.3 9 16 C 9 17.7 7.7 19 6 19 C 4.3 19 3 17.7 3 16 C 3 14.3 4.3 13 6 13 z M 12.5 13 C 12.2 13 12 13.2 12 13.5 L 12 18.5 C 12 18.8 12.2 19 12.5 19 L 17.5 19 C 17.8 19 18 18.8 18 18.5 L 18 13.5 C 18 13.2 17.8 13 17.5 13 L 12.5 13 z M 13 14 L 17 14 L 17 18 L 13 18 L 13 14 z M 20.5 14 C 20.2 14 20 14.2 20 14.5 C 20 14.8 20.2 15 20.5 15 L 29.5 15 C 29.8 15 30 14.8 30 14.5 C 30 14.2 29.8 14 29.5 14 L 20.5 14 z M 4.8007812 14.5 A 0.5 0.5 0 0 0 4.3007812 15 A 0.5 0.5 0 0 0 4.8007812 15.5 A 0.5 0.5 0 0 0 5.3007812 15 A 0.5 0.5 0 0 0 4.8007812 14.5 z M 7.3007812 14.5 A 0.5 0.5 0 0 0 6.8007812 15 A 0.5 0.5 0 0 0 7.3007812 15.5 A 0.5 0.5 0 0 0 7.8007812 15 A 0.5 0.5 0 0 0 7.3007812 14.5 z M 20.5 16 C 20.2 16 20 16.2 20 16.5 C 20 16.8 20.2 17 20.5 17 L 26.5 17 C 26.8 17 27 16.8 27 16.5 C 27 16.2 26.8 16 26.5 16 L 20.5 16 z M 4.9003906 16.5 C 4.6003906 16.5 4.4003906 16.7 4.4003906 17 C 4.4003906 17.3 4.6003906 17.5 4.9003906 17.5 L 7.0996094 17.5 C 7.2996094 17.5 7.5 17.3 7.5 17 C 7.5 16.7 7.3 16.5 7 16.5 L 4.9003906 16.5 z M 6 22 C 3.8 22 2 23.8 2 26 C 2 28.2 3.8 30 6 30 C 8.2 30 10 28.2 10 26 C 10 23.8 8.2 22 6 22 z M 6 23 C 7.7 23 9 24.3 9 26 C 9 27.7 7.7 29 6 29 C 4.3 29 3 27.7 3 26 C 3 24.3 4.3 23 6 23 z M 12.5 23 C 12.2 23 12 23.2 12 23.5 L 12 28.5 C 12 28.8 12.2 29 12.5 29 L 17.5 29 C 17.8 29 18 28.8 18 28.5 L 18 23.5 C 18 23.2 17.8 23 17.5 23 L 12.5 23 z M 13 24 L 17 24 L 17 28 L 13 28 L 13 24 z M 20.5 24 C 20.2 24 20 24.2 20 24.5 C 20 24.8 20.2 25 20.5 25 L 29.5 25 C 29.8 25 30 24.8 30 24.5 C 30 24.2 29.8 24 29.5 24 L 20.5 24 z M 4.8007812 24.5 A 0.5 0.5 0 0 0 4.3007812 25 A 0.5 0.5 0 0 0 4.8007812 25.5 A 0.5 0.5 0 0 0 5.3007812 25 A 0.5 0.5 0 0 0 4.8007812 24.5 z M 7.3007812 24.5 A 0.5 0.5 0 0 0 6.8007812 25 A 0.5 0.5 0 0 0 7.3007812 25.5 A 0.5 0.5 0 0 0 7.8007812 25 A 0.5 0.5 0 0 0 7.3007812 24.5 z M 20.5 26 C 20.2 26 20 26.2 20 26.5 C 20 26.8 20.2 27 20.5 27 L 26.5 27 C 26.8 27 27 26.8 27 26.5 C 27 26.2 26.8 26 26.5 26 L 20.5 26 z M 6 26.675781 C 5.475 26.675781 4.9496094 26.849219 4.5996094 27.199219 C 4.3996094 27.399219 4.3996094 27.700391 4.5996094 27.900391 C 4.7996094 28.100391 5.1007812 28.100391 5.3007812 27.900391 C 5.7007813 27.500391 6.2992187 27.500391 6.6992188 27.900391 C 6.7992187 28.000391 6.9996094 28 7.0996094 28 C 7.1996094 28 7.3003906 28.000391 7.4003906 27.900391 C 7.6003906 27.700391 7.6003906 27.399219 7.4003906 27.199219 C 7.0503906 26.849219 6.525 26.675781 6 26.675781 z " fill="#0f7e7d" stroke="none"/></svg>
            </div>
										
									</div>
      </div> --%>
      <div class="col col-md-4 mb-3"> 
        <!-- small box -->
        <div class="small-box bg-red-gradient d-flex align-items-center h-100 text-white" >
        	<h3>Overdue Articles &nbsp;:&nbsp; ${totalarticleavailablepast48.size()}
            <span class="d-block text-capitalize text-small"><a href="#" class="text-white" onclick="showAndHide('overdue1')">More info <i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
            <div class="icon ml-auto">
            	<svg version="1.1" id="Layer_2_copy_2" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
	 y="0px" viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve" class="main-icon" width="100%" height="100%" >
<g>
	<path d="M221.1,251.3V231h-37.7v-13l32-51.8H240v49.8H250V231H240v20.3H221.1z M221.1,216.1v-18.8c0-5.1,0.3-10.3,0.5-15.8h-0.4
		c-2.7,5.5-5.1,10.5-8,15.8L202,215.8l-0.1,0.3H221.1z"/>
	<path d="M272.4,207.5c-8.2-4.3-12.3-11.3-12.3-18.7c0-14.4,13-23.9,30-23.9c19.9,0,28.1,11.5,28.1,21.8c0,7.3-3.9,14.5-12.4,18.7
		v0.4c8.4,3.1,15.7,10.2,15.7,21.1c0,15.4-13,25.9-32.7,25.9c-21.6,0-31.5-12.2-31.5-23.7c0-10.2,5.9-17.3,15.2-21.3V207.5z
		 M301.2,228.4c0-7.5-5.6-11.9-13.3-14c-6.5,1.8-10.3,6.5-10.3,12.7c-0.1,6.1,4.6,11.9,12,11.9C296.5,239,301.2,234.4,301.2,228.4z
		 M278.9,188.1c0,5.8,5.1,9.4,11.9,11.5c4.6-1.3,8.6-5.5,8.6-10.7c0-5.4-3-10.6-10.3-10.6C282.3,178.3,278.9,182.9,278.9,188.1z"/>
</g>
<g>
	<g>
		<path d="M127.2,269v26.6H152V269h15v69.3h-15v-29h-24.8v29h-15V269H127.2z"/>
		<path d="M236.3,302.9c0,22.8-13.2,36.5-32.7,36.5c-19.7,0-31.4-15.5-31.4-35.4c0-20.8,12.9-36.3,32.4-36.3
			C225.1,267.8,236.3,283.7,236.3,302.9z M188.1,303.8c0,13.7,6.1,23.2,16.2,23.2c10.2,0,16-10.1,16-23.5c0-12.5-5.6-23.2-16-23.2
			C194,280.2,188.1,290.3,188.1,303.8z"/>
		<path d="M256.3,269v39.8c0,12,4.5,18.1,12.1,18.1c7.9,0,12.3-5.8,12.3-18.1V269h15v38.9c0,21.4-10.4,31.6-27.8,31.6
			c-16.8,0-26.6-9.8-26.6-31.8V269H256.3z"/>
		<path d="M303.7,269.9c4.8-0.8,12-1.4,20.1-1.4c9.9,0,16.8,1.5,21.6,5.4c4.1,3.3,6.2,8.2,6.2,14.6c0,8.7-6,14.8-11.8,17v0.3
			c4.6,2,7.2,6.5,8.9,12.8c2.1,7.9,4.1,17,5.3,19.6h-15.4c-1-2.1-2.7-7.6-4.5-16.1c-1.9-8.7-4.7-11-11-11.1h-4.5v27.2h-14.9V269.9z
			 M318.7,299.7h5.9c7.5,0,12-3.9,12-10c0-6.3-4.2-9.6-11.1-9.6c-3.7,0-5.7,0.2-6.8,0.5V299.7z"/>
		<path d="M357.9,322.2c4,2.2,10.3,4.3,16.7,4.3c6.9,0,10.6-3,10.6-7.5c0-4.3-3.2-6.8-11.2-9.7c-11.1-4.1-18.4-10.5-18.4-20.6
			c0-11.8,9.6-20.8,25.2-20.8c7.6,0,13.1,1.5,17,3.5l-3.4,12.5c-2.6-1.3-7.4-3.3-13.8-3.3c-6.5,0-9.7,3.2-9.7,6.7
			c0,4.4,3.7,6.4,12.4,9.8c11.8,4.5,17.2,10.9,17.2,20.7c0,11.6-8.5,21.5-26.8,21.5c-7.6,0-15.1-2.2-18.9-4.3L357.9,322.2z"/>
	</g>
</g>
<g transform="translate(0,-288.53332)">
	<path d="M54.6,522.3c-0.5,2.9-0.7,5.9-1.1,8.8l27.9,4.9l3-17.4l-27.9-4.9C55.9,516.6,55.2,519.4,54.6,522.3L54.6,522.3z"/>
	<path d="M61.3,620.1c1.8,5.6,3.9,11.1,6.1,16.6l26.8-9.8l-6.1-16.6L61.3,620.1z"/>
	<path d="M93.9,432.7l21.9,18.2l11.4-13.6l-21.8-18.2C101.4,423.4,97.6,428,93.9,432.7L93.9,432.7z"/>
	<path d="M118.8,709.8c4.4,4,8.9,7.8,13.6,11.4l18.3-21.9L137,687.9L118.8,709.8z"/>
	<path d="M178.4,367.9l9.7,26.6l16.6-6.1l-9.7-26.6C189.4,363.6,183.8,365.6,178.4,367.9z"/>
	<path d="M213.4,758.5c2.9,0.6,5.7,1.5,8.7,2c2.9,0.5,5.8,0.7,8.8,1.1l4.9-27.9l-17.4-3L213.4,758.5z"/>
	<path d="M310,727l9.8,26.8c5.6-1.8,11.2-3.8,16.6-6.1l-9.8-26.8L310,727z"/>
	<path d="M387.6,678l21.9,18.3c4-4.4,7.8-8.9,11.4-13.6L399,664.4L387.6,678z"/>
	<path d="M21.9,516.6c-22.6,130,64.6,253.9,194.5,276.5s253.9-64.6,276.5-194.5c2.3-11.8-15.6-14.9-17.4-3
		c-21,120.5-135.5,201.1-256,180.1S18.4,640.2,39.3,519.7c18.8-107.8,112.4-183.5,218.3-183.2l3.1-17.6
		C145.3,317.2,42.3,399.4,21.9,516.6z"/>
	<path d="M283.2,292.6l28.8,41l-41,28.8L283.2,292.6z"/>
	<path d="M487.5,545.9c-4.9,0.4-9.2-3.2-9.6-8c-0.4-4.9,3.2-9.2,8-9.6c0,0,0,0,0,0c4.9-0.4,9.2,3.2,9.6,8
		C495.9,541.2,492.4,545.5,487.5,545.9L487.5,545.9z"/>
	<path d="M476.6,486.8c-4.6,1.7-9.7-0.7-11.4-5.3c0,0,0,0,0,0c-1.7-4.6,0.7-9.7,5.3-11.4c4.6-1.7,9.7,0.7,11.4,5.3c0,0,0,0,0,0
		C483.5,480,481.2,485.1,476.6,486.8z"/>
	<path d="M450.8,432.4c-4,2.8-9.5,1.9-12.3-2.1c-2.8-4-1.9-9.5,2.1-12.3c0,0,0,0,0,0c4-2.8,9.5-1.9,12.3,2.1
		C455.7,424.1,454.8,429.6,450.8,432.4C450.8,432.4,450.8,432.4,450.8,432.4z"/>
	<path d="M411.8,386.7c-3.1,3.8-8.7,4.3-12.5,1.1c0,0,0,0,0,0c-3.8-3.1-4.3-8.7-1.1-12.5c3.1-3.8,8.7-4.3,12.5-1.1c0,0,0,0,0,0
		C414.4,377.3,414.9,382.9,411.8,386.7z"/>
	<path d="M362.3,352.5c-2.1,4.4-7.3,6.4-11.8,4.3c-4.4-2.1-6.4-7.3-4.3-11.8c0,0,0,0,0,0c2.1-4.4,7.3-6.4,11.8-4.3
		C362.4,342.8,364.3,348.1,362.3,352.5L362.3,352.5z"/>
</g>
</svg>
            </div>
        </div>
      </div>
       <div class="col col-md-4 mb-3"> 
        <!-- small box -->
        <div class="small-box bg-dark-blue-gradient d-flex align-items-center h-100 text-white" >
        	<h3>Overdue Articles&nbsp;:&nbsp; ${totalarticleavailablepastdate.size()}
            <span class="d-block text-capitalize text-small"><a href="#" class="text-white" onclick="showAndHide('overdue2')">More info <i class="fa fa-long-arrow-right"></i></a></span>
            </h3>
            <div class="icon ml-auto">
            <svg version="1.1" id="Layer_2_copy_2" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
	 y="0px" viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve" class="main-icon" width="100%" height="100%">
<g>
	<path d="M246.9,166.3v12.6l-35.1,72.5h-21.1l35.1-68.4v-0.3h-39v-16.4H246.9z"/>
	<path d="M258.7,251.3v-12l10.9-9.8c18.7-16.7,27.7-26.3,27.9-36.2c0-6.9-4.1-12.4-13.9-12.4c-7.3,0-13.7,3.7-18.2,6.9l-5.6-14.1
		c6.3-4.8,16.4-8.8,27.7-8.8c19.4,0,29.8,11.3,29.8,26.6c0,14.4-10.2,25.8-22.6,36.8l-7.8,6.5v0.3H319v16.4H258.7z"/>
</g>
<g>
	<g>
		<path d="M127.2,269v26.6H152V269h15v69.3h-15v-29h-24.8v29h-15V269H127.2z"/>
		<path d="M236.3,302.9c0,22.8-13.2,36.5-32.7,36.5c-19.7,0-31.4-15.5-31.4-35.4c0-20.8,12.9-36.3,32.4-36.3
			C225.1,267.8,236.3,283.7,236.3,302.9z M188.1,303.8c0,13.7,6.1,23.2,16.2,23.2c10.2,0,16-10.1,16-23.5c0-12.5-5.6-23.2-16-23.2
			C194,280.2,188.1,290.3,188.1,303.8z"/>
		<path d="M256.3,269v39.8c0,12,4.5,18.1,12.1,18.1c7.9,0,12.3-5.8,12.3-18.1V269h15v38.9c0,21.4-10.4,31.6-27.8,31.6
			c-16.8,0-26.6-9.8-26.6-31.8V269H256.3z"/>
		<path d="M303.7,269.9c4.8-0.8,12-1.4,20.1-1.4c9.9,0,16.8,1.5,21.6,5.4c4.1,3.3,6.2,8.2,6.2,14.6c0,8.7-6,14.8-11.8,17v0.3
			c4.6,2,7.2,6.5,8.9,12.8c2.1,7.9,4.1,17,5.3,19.6h-15.4c-1-2.1-2.7-7.6-4.5-16.1c-1.9-8.7-4.7-11-11-11.1h-4.5v27.2h-14.9V269.9z
			 M318.7,299.7h5.9c7.5,0,12-3.9,12-10c0-6.3-4.2-9.6-11.1-9.6c-3.7,0-5.7,0.2-6.8,0.5V299.7z"/>
		<path d="M357.9,322.2c4,2.2,10.3,4.3,16.7,4.3c6.9,0,10.6-3,10.6-7.5c0-4.3-3.2-6.8-11.2-9.7c-11.1-4.1-18.4-10.5-18.4-20.6
			c0-11.8,9.6-20.8,25.2-20.8c7.6,0,13.1,1.5,17,3.5l-3.4,12.5c-2.6-1.3-7.4-3.3-13.8-3.3c-6.5,0-9.7,3.2-9.7,6.7
			c0,4.4,3.7,6.4,12.4,9.8c11.8,4.5,17.2,10.9,17.2,20.7c0,11.6-8.5,21.5-26.8,21.5c-7.6,0-15.1-2.2-18.9-4.3L357.9,322.2z"/>
	</g>
</g>
<g transform="translate(0,-288.53332)">
	<path d="M220.6,747.2c2.9,0.8,5.8,1.2,8.7,1.8l7.1-27.4l-17.1-4.5l-7.1,27.4C215,745.4,217.7,746.4,220.6,747.2L220.6,747.2z"/>
	<path d="M318.6,748.6c5.8-1.3,11.4-2.9,17-4.7l-7.6-27.5l-17.1,4.7L318.6,748.6z"/>
	<path d="M134.5,700.6l20-20.3l-12.6-12.4l-20,20.2C125.9,692.4,130.1,696.6,134.5,700.6L134.5,700.6z"/>
	<path d="M412.7,698.6c4.3-4,8.5-8.2,12.5-12.6L404.8,666l-12.4,12.6L412.7,698.6z"/>
	<path d="M76.9,611.1l27.3-7.5l-4.7-17.1L72.2,594C73.5,599.8,75.1,605.5,76.9,611.1z"/>
	<path d="M469.1,608.3c0.9-2.8,1.9-5.6,2.7-8.5c0.8-2.9,1.2-5.8,1.8-8.6l-27.4-7.1l-4.5,17.1L469.1,608.3z"/>
	<path d="M445.6,509.5l27.5-7.6c-1.3-5.8-2.9-11.5-4.7-17.1l-27.5,7.6L445.6,509.5z"/>
	<path d="M403.2,428.1l20.1-20.3c-4-4.3-8.2-8.5-12.6-12.5l-20.1,20.4L403.2,428.1z"/>
	<path d="M212.3,779.3c127.7,33.2,258.3-43.4,291.6-171.1s-43.4-258.3-171.1-291.6c-11.5-3.2-16.1,14.3-4.5,17.1
		c118.4,30.8,189.3,151.6,158.4,270S335.1,793,216.7,762.1C110.8,734.6,43.1,635,52.1,529.5L34.8,525
		C23.7,639.9,97.1,749.3,212.3,779.3z"/>
	<path d="M10.5,500.4L53.7,475L79,518.2L10.5,500.4z"/>
	<path d="M279.7,317.7c0,4.9-3.9,8.9-8.8,8.9c-4.9,0-8.9-3.9-8.9-8.8c0,0,0,0,0,0c0-4.9,3.9-8.9,8.8-8.9
		C275.7,308.9,279.7,312.8,279.7,317.7L279.7,317.7z"/>
	<path d="M219.9,323.7c1.3,4.7-1.5,9.6-6.2,10.9c0,0,0,0,0,0c-4.7,1.3-9.6-1.5-10.9-6.2c-1.3-4.7,1.5-9.6,6.2-10.9c0,0,0,0,0,0
		C213.7,316.2,218.6,319,219.9,323.7z"/>
	<path d="M163.6,344.9c2.5,4.2,1.1,9.6-3.2,12.1c-4.2,2.5-9.6,1.1-12.1-3.2c0,0,0,0,0,0c-2.5-4.2-1.1-9.6,3.2-12.1
		C155.7,339.3,161.2,340.7,163.6,344.9C163.6,344.9,163.6,344.9,163.6,344.9z"/>
	<path d="M114.8,380c3.5,3.4,3.5,9,0.1,12.5c0,0,0,0,0,0c-3.4,3.5-9,3.5-12.5,0.1c-3.5-3.4-3.5-9-0.1-12.5c0,0,0,0,0,0
		C105.7,376.6,111.3,376.6,114.8,380z"/>
	<path d="M76.7,426.6c4.3,2.4,5.7,7.8,3.3,12.1c-2.4,4.3-7.8,5.7-12.1,3.3c0,0,0,0,0,0c-4.3-2.4-5.7-7.8-3.3-12.1
		C67,425.6,72.5,424.2,76.7,426.6L76.7,426.6z"/>
</g>
</svg></div>
        </div>
      </div>
      
       <!-- ./col -->
       
    </div>
    </div>
    
                    <div class="row" id="new_project">
	                <div class="col-md-12">
	                <c:if test="${taskManagementVo.size() ge 1}">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">My Task Details</span></div>
	                <div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0 filter7"
											id="articalList">
											<thead class="table-head">
												<tr>
													 <th>S.No.</th>
													
												    <th>Article ID</th>
													<th>Articles Title</th>
													 <th>Journal Name</th>
													<th>Articles DOI</th>
													<th>Delivery Date</th>
													<th>Articles Type </th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${taskManagementVo}"
													varStatus="counter">
													<tr>
														<td>${counter.count}</td>
														<td>${temp.aid}</td>
														<td>${temp.article_title}</td>
														<td>${temp.journalAbbrName}</td>
														<td>${temp.article_doi}</td>
														<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.sch_end_time}" /></td>
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
	                <c:if test="${totalarticleavailableToday.size() ge 1}">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">Today's Target (Articles)</span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0 filter7"
											id="inprocess">
											<thead class="table-head">
												<tr>
													 <th>S.No.</th>
												    <th>Article ID</th>
													<th>Articles Title</th>
													 <th>Journal Name</th>
													
													<th>Articles DOI</th>
													<th>Delivery Date</th>
													<th>Articles Type </th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${totalarticleavailableToday}"
													varStatus="counter">
													<tr>
														<td>${counter.count}</td>
														<td>${temp.articleDetail.aid}</td>
														<td>${temp.articleDetail.article_title}</td>
														<td>${temp.articleDetail.journals.journalAcronym}</td>
														<td>${temp.articleDetail.article_doi}</td>
														<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.sch_end_time}" /></td>
														<td>${temp.articleDetail.article_type_cd}</td>
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
	                <c:if test="${totalarticleavailablepast24.size() ge 1}">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">Overdue Article(24 Hours)</span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0 filter7"
											id="overdue">
											<thead class="table-head">
												<tr>
												 <th>S.No.</th>
												    <th>Article ID</th>
													<th>Articles Title</th>
													<th>Journal Name</th>
													
													<th>Articles DOI</th>
													<th>Delivery Date</th>
													<th>Articles Type </th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${totalarticleavailablepast24}"
													varStatus="counter">
													<tr>
														<td>${counter.count}</td>
														<td>${temp.articleDetail.aid}</td>
														<td>${temp.articleDetail.article_title}</td>
														<td>${temp.articleDetail.journals.journalAcronym}</td>
													
														<td>${temp.articleDetail.article_doi}</td>
														<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.sch_end_time}" /></td>
														<td>${temp.articleDetail.article_type_cd}</td>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</c:if>
							</div>
						</div>
						
						
						
						<div class="row" id="overdue_project1">
	                <div class="col-md-12">
	                <c:if test="${totalarticleavailablepast48.size() ge 1}">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">Overdue Article(48 Hours)</span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0 filter7"
											id="overdue1">
											<thead class="table-head">
												<tr>
												   <th>S.No.</th>
												    <th>Article ID</th>
													<th>Articles Title</th>
													<th>Journal Name</th>
													<th>Articles DOI</th>
													<th>Delivery Date</th>
													<th>Articles Type</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${totalarticleavailablepast48}"
													varStatus="counter">
													<tr>
														<td>${counter.count}</td>
														<td>${temp.articleDetail.aid}</td>
														<td>${temp.articleDetail.article_title}</td>
														<td>${temp.articleDetail.journals.journalAcronym}</td>
														<td>${temp.articleDetail.article_doi}</td>
														<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.sch_end_time}" /></td>
														<td>${temp.articleDetail.article_type_cd}</td>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</c:if>
							</div>
							</div>
							
					<div class="row" id="overdue_project2">
	                <div class="col-md-12">
	                <c:if test="${totalarticleavailablepastdate.size() ge 1}">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">Overdue Article(72 Hours)</span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0 filter7"
											id="overdue2">
											<thead class="table-head">
												<tr>
												   <th>S.No.</th>
												    <th>Article ID</th>
													<th>Articles Title</th>
													<th>Journal Name</th>
												
													<th>Articles DOI</th>
													<th>Delivery Date</th>
													<th>Articles Type</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${totalarticleavailablepastdate}"
													varStatus="counter">
													<tr>
														<td>${counter.count}</td>
														<td>${temp.articleDetail.aid}</td>
														<td>${temp.articleDetail.article_title}</td>
														<td>${temp.articleDetail.journals.journalAcronym}</td>
														<td>${temp.articleDetail.article_doi}</td>
														<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.sch_end_time}" /></td>
														<td>${temp.articleDetail.article_type_cd}</td>
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
	                <c:if test="${totalarticleavailablepastdate.size() ge 1}">
	                <div class="main_tittle d-flex align-items-center"><span class="mr-2">Total Overdue Articles </span></div>
						<div class="content_box">
									<div class="box-body">
										<table class="table table-striped table-bordered m-0 filter7"
											id="completeArticle">
											<thead class="table-head">
												<tr>
												    <th>S.No.</th>
												    <th>Article ID</th>
													<th>Articles Title</th>
													<th>Journal Name</th>
													<th>Articles DOI</th>
													<th>Delivery Date</th>
													<th>Articles Type </th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="temp" items="${totalarticleavailablepastdate}"
													varStatus="counter">
													<tr>
														<td>${counter.count}</td>
														<td>${temp.articleDetail.aid}</td>
														<td>${temp.articleDetail.article_title}</td>
														<td>${temp.articleDetail.journals.journalAcronym}</td>
														<td>${temp.articleDetail.article_doi}</td>
														<td><fmt:formatDate pattern="dd-MM-yyyy"
															value="${temp.sch_end_time}" /></td>
														<td>${temp.articleDetail.article_type_cd}</td>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</c:if>
							</div>
						</div>
										
						<div class="row">
							<div class="col-md-6">
							<div class="content_box p-3">
								<div id="containerthree"></div>
							</div>
							 
							</div>
							<div class="col-md-6">
								<div class="content_box p-3">
			               			<div id="container"></div>
			               		</div>
			                </div>

  
					</div>
					
					
				
				
			</div>
		</div>
		</div>
	</div>

</form>
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
		document.getElementById("overdue_project1").style.display = "none";
		document.getElementById("overdue_project2").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
		
	}
	else if(val=='overdue'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "block";
		document.getElementById("overdue_project1").style.display = "none";
		document.getElementById("overdue_project2").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
	}
	else if(val=='overdue1'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("overdue_project1").style.display = "block";
		document.getElementById("overdue_project2").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
	}

	else if(val=='overdue2'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("overdue_project1").style.display = "none";
		document.getElementById("overdue_project2").style.display = "block";
		document.getElementById("complete_project").style.display = "none";
	}
	
	else if(val=='articalList'){
		document.getElementById("new_project").style.display = "block";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("overdue_project1").style.display = "none";
		document.getElementById("overdue_project2").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
	}
	else if(val=='complete'){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("overdue_project1").style.display = "none";
		document.getElementById("overdue_project2").style.display = "none";
		document.getElementById("complete_project").style.display = "block";
	}
	else if(val==''){
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("overdue_project1").style.display = "none";
		document.getElementById("overdue_project2").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
	}
}


</script>
<script type="text/javascript">
/* $(document).ready(function() {
    $('#articalList').DataTable();
} );
$(document).ready(function() {
    $('#overdue').DataTable();
} );
$(document).ready(function() {
    $('#overdue1').DataTable();
} );
$(document).ready(function() {
    $('#overdue2').DataTable();
} );
$(document).ready(function() {
    $('#completeArticle').DataTable();
} );
$(document).ready(function() {
    $('#inprocess').DataTable();
} ); */
$(document).ready(function() {
	document.getElementById("new_project").style.display = "none";
	document.getElementById("inprocess_project").style.display = "none";
	document.getElementById("overdue_project").style.display = "none";
	document.getElementById("overdue_project1").style.display = "none";
	document.getElementById("overdue_project2").style.display = "none";
	document.getElementById("complete_project").style.display = "none";
} );
    
</script>


<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
 <script type="text/javascript">  
Highcharts.chart('container', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Day Wise Current Articles Load'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage} %'
            }
        }
    },
    series: [{
        name: 'Article',
        colorByPoint: true,
        data: [ {
            name: '24 Hour',
            y: ${totalarticleavailable24}
        }, {
            name: '48 Hour',
            y: ${totalarticleavailable48}
        }, {
            name: '72 Hour',
            y: ${totalarticleavailablepast}
        }]
    }]
});
</script>
<script type="text/javascript"> 

Highcharts.chart('containerthree', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Day Wise Current Articles Load '
    },

    xAxis: {
    	categories: [
        	<c:forEach items="${totalarticleavailableGraph}" var="entry">
            [  '${entry.date}' ],
           </c:forEach>
        ],
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Article Load'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:15px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y}</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding:.2,
            borderWidth: .1
        }
    },
    series: [{
    	 y: 4,
        name: 'Article',
        color: "#9B344C",
        data: [<c:forEach items="${totalarticleavailableGraph}" var="entry">${entry.article_count},</c:forEach> ]
    	
    }]
});

</script> 

