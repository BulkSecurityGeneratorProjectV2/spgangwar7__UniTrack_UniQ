<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-6">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Cron Jobs</span> <span id="Date"></span>
						</div>
					</div>
					<div class="col-md-6">
						<label class="mandatoryMsg"> </label>
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
				<table class="table table-striped table-bordered m-0">
					<thead class="table-head">
						<tr>
							<th>S.no</th>
							<th>Process Name</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cronlist}" var="entry" varStatus="counter">
							<tr>
								<td>${counter.count}</td>
								<td>${entry.value}</td>
								<td><a href="${entry.key}">Start</a></td>

							</tr>

						</c:forEach>
					</tbody>
				</table>


			</div>
		</div>
	</div>
</div>