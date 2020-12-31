
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<script src="https://code.highcharts.com/highcharts.js"></script>
				<script src="https://code.highcharts.com/modules/data.js"></script>
				<script src="https://code.highcharts.com/modules/drilldown.js"></script>
				<script src="https://code.highcharts.com/modules/exporting.js"></script>
					<script src="https://code.highcharts.com/modules/export-data.js"></script>


				<div class="row">
					<div class="col-md-12">
						<div id="container" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
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
				</div>
			</div>
		</div>
	</div>
</div>

<script src="resources/js/drildownmis.js"></script>
<script src="resources/js/drildownmis2.js"></script>
<script src="resources/js/drildownmis3.js"></script>
