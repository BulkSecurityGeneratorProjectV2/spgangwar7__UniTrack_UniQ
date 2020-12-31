<%@ include file="/WEB-INF/includes/include.jsp"%>


<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">

			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2"><spring:message code="issue.book" /> Details</span> <span id="Date">Mon
								, 26 Aug 2019</span><span class="ml-auto"><a
								href="${context}/issueMakeup"
								class="btn btn-sm btn-outline-danger"><i class="fa fa-plus"></i>
									Add New</a> </span>
						</div>

					</div>
				</div>
				<!--main_tittle-->
				<div class="row">

					<div class="col mb-3">
						<div
							class="small-box bg-dark-green-gradient d-flex align-items-center h-100">
							<h3 style="color: white;">
								All <spring:message code="issues.books" /> &nbsp;:&nbsp; <span>${issueList.size()}</span> <span
									class="d-block text-capitalize text-small"><br> <br>

									<a href="#" onclick="showAndHideIssue('articalList')"
									class="d-flex text-white moreinfoBlock">More info <i
										class="fa fa-angle-right ml-2"></i></a> </span>
							</h3>

							<div class="icon ml-auto">
								<svg class="main-icon"
									xmlns:dc="https://purl.org/dc/elements/1.1/"
									xmlns:cc="https://creativecommons.org/ns#"
									xmlns:rdf="https://www.w3.org/1999/02/22-rdf-syntax-ns#"
									xmlns:svg="https://www.w3.org/2000/svg"
									xmlns="https://www.w3.org/2000/svg"
									xmlns:sodipodi="https://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd"
									xmlns:inkscape="https://www.inkscape.org/namespaces/inkscape"
									version="1.1" x="0px" y="0px" viewBox="0 0 32 30"
									style="enable-background: new 0 0 32 32;" xml:space="preserve">
									<path style=""
										d="M 6 2 C 3.8 2 2 3.8 2 6 C 2 8.2 3.8 10 6 10 C 8.2 10 10 8.2 10 6 C 10 3.8 8.2 2 6 2 z M 6 3 C 7.7 3 9 4.3 9 6 C 9 7.7 7.7 9 6 9 C 4.3 9 3 7.7 3 6 C 3 4.3 4.3 3 6 3 z M 12.5 3 C 12.2 3 12 3.2 12 3.5 L 12 8.5 C 12 8.8 12.2 9 12.5 9 L 17.5 9 C 17.8 9 18 8.8 18 8.5 L 18 5.2011719 L 19.300781 3.9003906 C 19.500781 3.7003906 19.500781 3.3992188 19.300781 3.1992188 C 19.100781 2.9992188 18.799609 2.9992187 18.599609 3.1992188 L 18 3.7988281 L 18 3.5 C 18 3.2 17.8 3 17.5 3 L 12.5 3 z M 13 4 L 17 4 L 17 4.8007812 L 15.400391 6.4003906 L 14.300781 5.3007812 C 14.100781 5.1007812 13.799609 5.1007812 13.599609 5.3007812 C 13.399609 5.5007812 13.399609 5.8 13.599609 6 L 15 7.4003906 C 15.1 7.5003906 15.300391 7.5 15.400391 7.5 C 15.600391 7.5 15.700781 7.4003906 15.800781 7.4003906 L 17 6.2011719 L 17 8 L 13 8 L 13 4 z M 20.5 4 C 20.2 4 20 4.2 20 4.5 C 20 4.8 20.2 5 20.5 5 L 29.5 5 C 29.8 5 30 4.8 30 4.5 C 30 4.2 29.8 4 29.5 4 L 20.5 4 z M 4.8007812 4.5 A 0.5 0.5 0 0 0 4.3007812 5 A 0.5 0.5 0 0 0 4.8007812 5.5 A 0.5 0.5 0 0 0 5.3007812 5 A 0.5 0.5 0 0 0 4.8007812 4.5 z M 7.3007812 4.5 A 0.5 0.5 0 0 0 6.8007812 5 A 0.5 0.5 0 0 0 7.3007812 5.5 A 0.5 0.5 0 0 0 7.8007812 5 A 0.5 0.5 0 0 0 7.3007812 4.5 z M 20.5 6 C 20.2 6 20 6.2 20 6.5 C 20 6.8 20.2 7 20.5 7 L 26.5 7 C 26.8 7 27 6.8 27 6.5 C 27 6.2 26.8 6 26.5 6 L 20.5 6 z M 4.9492188 6.5507812 C 4.8242188 6.5507812 4.6996094 6.5992188 4.5996094 6.6992188 C 4.3996094 6.8992187 4.3996094 7.2003906 4.5996094 7.4003906 C 4.9996094 7.8003906 5.5 8 6 8 C 6.5 8 7.0003906 7.8003906 7.4003906 7.4003906 C 7.6003906 7.2003906 7.6003906 6.8992188 7.4003906 6.6992188 C 7.2003906 6.4992187 6.8992188 6.4992187 6.6992188 6.6992188 C 6.2992187 7.0992187 5.7007813 7.0992188 5.3007812 6.6992188 C 5.2007813 6.5992188 5.0742188 6.5507812 4.9492188 6.5507812 z M 6 12 C 3.8 12 2 13.8 2 16 C 2 18.2 3.8 20 6 20 C 8.2 20 10 18.2 10 16 C 10 13.8 8.2 12 6 12 z M 6 13 C 7.7 13 9 14.3 9 16 C 9 17.7 7.7 19 6 19 C 4.3 19 3 17.7 3 16 C 3 14.3 4.3 13 6 13 z M 12.5 13 C 12.2 13 12 13.2 12 13.5 L 12 18.5 C 12 18.8 12.2 19 12.5 19 L 17.5 19 C 17.8 19 18 18.8 18 18.5 L 18 13.5 C 18 13.2 17.8 13 17.5 13 L 12.5 13 z M 13 14 L 17 14 L 17 18 L 13 18 L 13 14 z M 20.5 14 C 20.2 14 20 14.2 20 14.5 C 20 14.8 20.2 15 20.5 15 L 29.5 15 C 29.8 15 30 14.8 30 14.5 C 30 14.2 29.8 14 29.5 14 L 20.5 14 z M 4.8007812 14.5 A 0.5 0.5 0 0 0 4.3007812 15 A 0.5 0.5 0 0 0 4.8007812 15.5 A 0.5 0.5 0 0 0 5.3007812 15 A 0.5 0.5 0 0 0 4.8007812 14.5 z M 7.3007812 14.5 A 0.5 0.5 0 0 0 6.8007812 15 A 0.5 0.5 0 0 0 7.3007812 15.5 A 0.5 0.5 0 0 0 7.8007812 15 A 0.5 0.5 0 0 0 7.3007812 14.5 z M 20.5 16 C 20.2 16 20 16.2 20 16.5 C 20 16.8 20.2 17 20.5 17 L 26.5 17 C 26.8 17 27 16.8 27 16.5 C 27 16.2 26.8 16 26.5 16 L 20.5 16 z M 4.9003906 16.5 C 4.6003906 16.5 4.4003906 16.7 4.4003906 17 C 4.4003906 17.3 4.6003906 17.5 4.9003906 17.5 L 7.0996094 17.5 C 7.2996094 17.5 7.5 17.3 7.5 17 C 7.5 16.7 7.3 16.5 7 16.5 L 4.9003906 16.5 z M 6 22 C 3.8 22 2 23.8 2 26 C 2 28.2 3.8 30 6 30 C 8.2 30 10 28.2 10 26 C 10 23.8 8.2 22 6 22 z M 6 23 C 7.7 23 9 24.3 9 26 C 9 27.7 7.7 29 6 29 C 4.3 29 3 27.7 3 26 C 3 24.3 4.3 23 6 23 z M 12.5 23 C 12.2 23 12 23.2 12 23.5 L 12 28.5 C 12 28.8 12.2 29 12.5 29 L 17.5 29 C 17.8 29 18 28.8 18 28.5 L 18 23.5 C 18 23.2 17.8 23 17.5 23 L 12.5 23 z M 13 24 L 17 24 L 17 28 L 13 28 L 13 24 z M 20.5 24 C 20.2 24 20 24.2 20 24.5 C 20 24.8 20.2 25 20.5 25 L 29.5 25 C 29.8 25 30 24.8 30 24.5 C 30 24.2 29.8 24 29.5 24 L 20.5 24 z M 4.8007812 24.5 A 0.5 0.5 0 0 0 4.3007812 25 A 0.5 0.5 0 0 0 4.8007812 25.5 A 0.5 0.5 0 0 0 5.3007812 25 A 0.5 0.5 0 0 0 4.8007812 24.5 z M 7.3007812 24.5 A 0.5 0.5 0 0 0 6.8007812 25 A 0.5 0.5 0 0 0 7.3007812 25.5 A 0.5 0.5 0 0 0 7.8007812 25 A 0.5 0.5 0 0 0 7.3007812 24.5 z M 20.5 26 C 20.2 26 20 26.2 20 26.5 C 20 26.8 20.2 27 20.5 27 L 26.5 27 C 26.8 27 27 26.8 27 26.5 C 27 26.2 26.8 26 26.5 26 L 20.5 26 z M 6 26.675781 C 5.475 26.675781 4.9496094 26.849219 4.5996094 27.199219 C 4.3996094 27.399219 4.3996094 27.700391 4.5996094 27.900391 C 4.7996094 28.100391 5.1007812 28.100391 5.3007812 27.900391 C 5.7007813 27.500391 6.2992187 27.500391 6.6992188 27.900391 C 6.7992187 28.000391 6.9996094 28 7.0996094 28 C 7.1996094 28 7.3003906 28.000391 7.4003906 27.900391 C 7.6003906 27.700391 7.6003906 27.399219 7.4003906 27.199219 C 7.0503906 26.849219 6.525 26.675781 6 26.675781 z "
										fill="#fff" stroke="none"></path></svg>
							</div>

						</div>

						<%-- <div class="h-100 boxContainer bg-green  border px-3 pt-4 pb-3 d-none">
							<div class="mainBox d-flex">
								<div class="boxContent">
									<h5 style="color: white;">All Issue</h5>
									<p class="numberBox">${issueList.size()}</p>
								</div>
								<div class="boxLogo ml-auto"></div>
							</div>
							<div class="boxFooter w-100">
								

							</div>
						</div> --%>

					</div>


					<div class="col mb-3">

						<div
							class="small-box bg-blue-gradient d-flex align-items-center h-100">
							<h3 style="color: white;">
								Upcoming <spring:message code="issues.books" /> &nbsp;:&nbsp; <span>${upcomingIssue.size()}</span>
								<span class="d-block text-capitalize text-small"><br>
									<br> <a href="#" onclick="showAndHideIssue('inprocess')"
									class="d-flex text-white moreinfoBlock">More info <i
										class="fa fa-angle-right ml-2"></i></a> </span>
							</h3>

							<div class="icon ml-auto">
								<svg version="1.1" id="Capa_1"
									xmlns="http://www.w3.org/2000/svg"
									xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
									viewBox="0 0 512 512" fill="#ffffff"
									style="enable-background: new 0 0 512 512;"
									xml:space="preserve">
								<g>
									<g>
										<path
										d="M400,152H256c-5.5,0-10,4.5-10,10s4.5,10,10,10h144c5.5,0,10-4.5,10-10S405.5,152,400,152z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M365,202.9c-1.9-1.9-4.4-2.9-7.1-2.9s-5.2,1.1-7.1,2.9c-1.9,1.9-2.9,4.4-2.9,7.1s1.1,5.2,2.9,7.1s4.4,2.9,7.1,2.9
											s5.2-1.1,7.1-2.9c1.9-1.9,2.9-4.4,2.9-7.1S366.9,204.8,365,202.9z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M263.1,45.9c-1.9-1.9-4.4-2.9-7.1-2.9s-5.2,1.1-7.1,2.9S246,50.4,246,53s1.1,5.2,2.9,7.1c1.9,1.9,4.4,2.9,7.1,2.9
											s5.2-1.1,7.1-2.9c1.9-1.9,2.9-4.4,2.9-7.1S264.9,47.8,263.1,45.9z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M315.9,200H256c-5.5,0-10,4.5-10,10s4.5,10,10,10h59.9c5.5,0,10-4.5,10-10S321.4,200,315.9,200z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M400,260H256c-5.5,0-10,4.5-10,10s4.5,10,10,10h144c5.5,0,10-4.5,10-10S405.5,260,400,260z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M365,310.9c-1.9-1.9-4.4-2.9-7.1-2.9s-5.2,1.1-7.1,2.9c-1.9,1.9-2.9,4.4-2.9,7.1s1.1,5.2,2.9,7.1s4.4,2.9,7.1,2.9
											s5.2-1.1,7.1-2.9c1.9-1.9,2.9-4.4,2.9-7.1S366.9,312.8,365,310.9z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M315.9,308H256c-5.5,0-10,4.5-10,10s4.5,10,10,10h59.9c5.5,0,10-4.5,10-10S321.4,308,315.9,308z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M400,368H256c-5.5,0-10,4.5-10,10s4.5,10,10,10h144c5.5,0,10-4.5,10-10S405.5,368,400,368z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M365,418.9c-1.9-1.9-4.4-2.9-7.1-2.9s-5.2,1.1-7.1,2.9c-1.9,1.9-2.9,4.4-2.9,7.1s1.1,5.2,2.9,7.1s4.4,2.9,7.1,2.9
											s5.2-1.1,7.1-2.9c1.9-1.9,2.9-4.4,2.9-7.1S366.9,420.8,365,418.9z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M315.9,416H256c-5.5,0-10,4.5-10,10s4.5,10,10,10h59.9c5.5,0,10-4.5,10-10S321.4,416,315.9,416z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M419.2,39h-76.4c-11-10.5-26-17-42.4-17h-8.8C285,8.7,271.3,0,256,0s-29,8.7-35.7,22h-8.8c-16.4,0-31.3,6.5-42.4,17H92.8
											C65.9,39,44,60.9,44,87.8v375.5c0,26.9,21.9,48.8,48.8,48.8h326.5c26.9,0,48.8-21.9,48.8-48.8V87.8C468,60.9,446.1,39,419.2,39z
											 M211.5,42h15.6c4.5,0,8.4-3,9.6-7.3C239.1,26,247,20,256,20c9,0,16.9,6,19.3,14.7c1.2,4.3,5.1,7.3,9.6,7.3h15.6
											c21.7,0,39.6,16.8,41.4,38H170.1C171.9,58.8,189.8,42,211.5,42z M448,463.2c0,15.9-12.9,28.8-28.8,28.8H92.8
											C76.9,492,64,479.1,64,463.2V87.8C64,71.9,76.9,59,92.8,59h62.3c-3.3,7.5-5.1,15.8-5.1,24.5V90c0,5.5,4.5,10,10,10h192
											c5.5,0,10-4.5,10-10v-6.5c0-8.7-1.8-17-5.1-24.5h62.4c15.9,0,28.8,12.9,28.8,28.8V463.2z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M168,368h-48c-5.5,0-10,4.5-10,10v48c0,5.5,4.5,10,10,10h48c5.5,0,10-4.5,10-10v-48C178,372.5,173.5,368,168,368z
											 M158,416h-28v-28h28V416z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M168,260h-48c-5.5,0-10,4.5-10,10v48c0,5.5,4.5,10,10,10h48c5.5,0,10-4.5,10-10v-48C178,264.5,173.5,260,168,260z
											 M158,308h-28v-28h28V308z" />
									</g>
								</g>
								<g>
									<g>
										<path
										d="M168,152h-48c-5.5,0-10,4.5-10,10v48c0,5.5,4.5,10,10,10h48c5.5,0,10-4.5,10-10v-48C178,156.5,173.5,152,168,152z
											 M158,200h-28v-28h28V200z" />
									</g>
								</g>
								</svg>

							</div>

						</div>


						<%-- <div class="h-100 boxContainer bg-d-blue  border px-3 pt-4 pb-3">
							<div class="mainBox d-flex">
								<div class="boxContent">
									<h5 style="color: white;">Upcoming Issues</h5>
									<p class="numberBox">${upcomingIssue.size()}</p>
								</div>
								<div class="boxLogo ml-auto"></div>
							</div>
							<div class="boxFooter w-100">
								<a href="#" onclick="showAndHideIssue('inprocess')"
									class="d-flex text-white moreinfoBlock">More info <i
									class="fa fa-angle-right ml-auto"></i></a>
							</div>
						</div> --%>

					</div>


					<div class="col mb-3">
						<div
							class="small-box bg-orange-gradient d-flex align-items-center h-100">
							<h3 style="color: white;">
								 Running/Draft <spring:message code="issues.books" /> &nbsp;:&nbsp; <span>${runingIssue.size()}</span>
								<span class="d-block text-capitalize text-small"><br>
									<br> <a href="#" onclick="showAndHideIssue('overdue')"
									class="d-flex text-white moreinfoBlock">More info <i
										class="fa fa-angle-right ml-2"></i></a> </span>
							</h3>

							<div class="icon ml-auto">
								<img src="resources/images/failed_tasks_icon.png"
									class="img-fluid">
							</div>

						</div>

						<div
							class="h-100 boxContainer bg-red border px-3 pt-4 pb-3 d-none">
							<div class="mainBox d-flex">
								<div class="boxContent">
									<h5 style="color: white;"> Running/Draft <spring:message code="issues.books" /></h5>
									<p class="numberBox">${runingIssue.size()}</p>
								</div>
								<div class="boxLogo ml-auto">
									<img src="resources/images/failed_tasks_icon.png"
										class="img-fluid">
								</div>
							</div>
							<div class="boxFooter w-100">
								<a href="#" onclick="showAndHideIssue('overdue')"
									class="d-flex text-white moreinfoBlock">More info <i
									class="fa fa-angle-right ml-auto"></i></a>
							</div>
						</div>

					</div>
					
							<div class="col mb-3">
												<!-- small box -->
												<div
													class="small-box bg-green-gradient d-flex align-items-center h-100">
													<h3 style="color: white;">
														Delivered <spring:message code="issues.books" /> &nbsp;:&nbsp; ${completeDetail.size()} <span
															class="d-block text-capitalize text-small"><br>
															<br> <a style="color: white;" href="#"
															onclick="showAndHideIssue('complete')">More info <i
																class="fa fa-long-arrow-right"></i></a></span>
													</h3>

													<div class="icon ml-auto">

														<svg class="main-icon"
															xmlns:dc="https://purl.org/dc/elements/1.1/"
															xmlns:cc="https://creativecommons.org/ns#"
															xmlns:rdf="https://www.w3.org/1999/02/22-rdf-syntax-ns#"
															xmlns:svg="https://www.w3.org/2000/svg"
															xmlns="https://www.w3.org/2000/svg"
															xmlns:sodipodi="https://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd"
															xmlns:inkscape="https://www.inkscape.org/namespaces/inkscape"
															version="1.1" x="0px" y="0px" viewBox="0 0 32 30"
															style="enable-background: new 0 0 32 32;"
															xml:space="preserve">
															<path style=""
																d="M 6 2 C 3.8 2 2 3.8 2 6 C 2 8.2 3.8 10 6 10 C 8.2 10 10 8.2 10 6 C 10 3.8 8.2 2 6 2 z M 6 3 C 7.7 3 9 4.3 9 6 C 9 7.7 7.7 9 6 9 C 4.3 9 3 7.7 3 6 C 3 4.3 4.3 3 6 3 z M 12.5 3 C 12.2 3 12 3.2 12 3.5 L 12 8.5 C 12 8.8 12.2 9 12.5 9 L 17.5 9 C 17.8 9 18 8.8 18 8.5 L 18 5.2011719 L 19.300781 3.9003906 C 19.500781 3.7003906 19.500781 3.3992188 19.300781 3.1992188 C 19.100781 2.9992188 18.799609 2.9992187 18.599609 3.1992188 L 18 3.7988281 L 18 3.5 C 18 3.2 17.8 3 17.5 3 L 12.5 3 z M 13 4 L 17 4 L 17 4.8007812 L 15.400391 6.4003906 L 14.300781 5.3007812 C 14.100781 5.1007812 13.799609 5.1007812 13.599609 5.3007812 C 13.399609 5.5007812 13.399609 5.8 13.599609 6 L 15 7.4003906 C 15.1 7.5003906 15.300391 7.5 15.400391 7.5 C 15.600391 7.5 15.700781 7.4003906 15.800781 7.4003906 L 17 6.2011719 L 17 8 L 13 8 L 13 4 z M 20.5 4 C 20.2 4 20 4.2 20 4.5 C 20 4.8 20.2 5 20.5 5 L 29.5 5 C 29.8 5 30 4.8 30 4.5 C 30 4.2 29.8 4 29.5 4 L 20.5 4 z M 4.8007812 4.5 A 0.5 0.5 0 0 0 4.3007812 5 A 0.5 0.5 0 0 0 4.8007812 5.5 A 0.5 0.5 0 0 0 5.3007812 5 A 0.5 0.5 0 0 0 4.8007812 4.5 z M 7.3007812 4.5 A 0.5 0.5 0 0 0 6.8007812 5 A 0.5 0.5 0 0 0 7.3007812 5.5 A 0.5 0.5 0 0 0 7.8007812 5 A 0.5 0.5 0 0 0 7.3007812 4.5 z M 20.5 6 C 20.2 6 20 6.2 20 6.5 C 20 6.8 20.2 7 20.5 7 L 26.5 7 C 26.8 7 27 6.8 27 6.5 C 27 6.2 26.8 6 26.5 6 L 20.5 6 z M 4.9492188 6.5507812 C 4.8242188 6.5507812 4.6996094 6.5992188 4.5996094 6.6992188 C 4.3996094 6.8992187 4.3996094 7.2003906 4.5996094 7.4003906 C 4.9996094 7.8003906 5.5 8 6 8 C 6.5 8 7.0003906 7.8003906 7.4003906 7.4003906 C 7.6003906 7.2003906 7.6003906 6.8992188 7.4003906 6.6992188 C 7.2003906 6.4992187 6.8992188 6.4992187 6.6992188 6.6992188 C 6.2992187 7.0992187 5.7007813 7.0992188 5.3007812 6.6992188 C 5.2007813 6.5992188 5.0742188 6.5507812 4.9492188 6.5507812 z M 6 12 C 3.8 12 2 13.8 2 16 C 2 18.2 3.8 20 6 20 C 8.2 20 10 18.2 10 16 C 10 13.8 8.2 12 6 12 z M 6 13 C 7.7 13 9 14.3 9 16 C 9 17.7 7.7 19 6 19 C 4.3 19 3 17.7 3 16 C 3 14.3 4.3 13 6 13 z M 12.5 13 C 12.2 13 12 13.2 12 13.5 L 12 18.5 C 12 18.8 12.2 19 12.5 19 L 17.5 19 C 17.8 19 18 18.8 18 18.5 L 18 13.5 C 18 13.2 17.8 13 17.5 13 L 12.5 13 z M 13 14 L 17 14 L 17 18 L 13 18 L 13 14 z M 20.5 14 C 20.2 14 20 14.2 20 14.5 C 20 14.8 20.2 15 20.5 15 L 29.5 15 C 29.8 15 30 14.8 30 14.5 C 30 14.2 29.8 14 29.5 14 L 20.5 14 z M 4.8007812 14.5 A 0.5 0.5 0 0 0 4.3007812 15 A 0.5 0.5 0 0 0 4.8007812 15.5 A 0.5 0.5 0 0 0 5.3007812 15 A 0.5 0.5 0 0 0 4.8007812 14.5 z M 7.3007812 14.5 A 0.5 0.5 0 0 0 6.8007812 15 A 0.5 0.5 0 0 0 7.3007812 15.5 A 0.5 0.5 0 0 0 7.8007812 15 A 0.5 0.5 0 0 0 7.3007812 14.5 z M 20.5 16 C 20.2 16 20 16.2 20 16.5 C 20 16.8 20.2 17 20.5 17 L 26.5 17 C 26.8 17 27 16.8 27 16.5 C 27 16.2 26.8 16 26.5 16 L 20.5 16 z M 4.9003906 16.5 C 4.6003906 16.5 4.4003906 16.7 4.4003906 17 C 4.4003906 17.3 4.6003906 17.5 4.9003906 17.5 L 7.0996094 17.5 C 7.2996094 17.5 7.5 17.3 7.5 17 C 7.5 16.7 7.3 16.5 7 16.5 L 4.9003906 16.5 z M 6 22 C 3.8 22 2 23.8 2 26 C 2 28.2 3.8 30 6 30 C 8.2 30 10 28.2 10 26 C 10 23.8 8.2 22 6 22 z M 6 23 C 7.7 23 9 24.3 9 26 C 9 27.7 7.7 29 6 29 C 4.3 29 3 27.7 3 26 C 3 24.3 4.3 23 6 23 z M 12.5 23 C 12.2 23 12 23.2 12 23.5 L 12 28.5 C 12 28.8 12.2 29 12.5 29 L 17.5 29 C 17.8 29 18 28.8 18 28.5 L 18 23.5 C 18 23.2 17.8 23 17.5 23 L 12.5 23 z M 13 24 L 17 24 L 17 28 L 13 28 L 13 24 z M 20.5 24 C 20.2 24 20 24.2 20 24.5 C 20 24.8 20.2 25 20.5 25 L 29.5 25 C 29.8 25 30 24.8 30 24.5 C 30 24.2 29.8 24 29.5 24 L 20.5 24 z M 4.8007812 24.5 A 0.5 0.5 0 0 0 4.3007812 25 A 0.5 0.5 0 0 0 4.8007812 25.5 A 0.5 0.5 0 0 0 5.3007812 25 A 0.5 0.5 0 0 0 4.8007812 24.5 z M 7.3007812 24.5 A 0.5 0.5 0 0 0 6.8007812 25 A 0.5 0.5 0 0 0 7.3007812 25.5 A 0.5 0.5 0 0 0 7.8007812 25 A 0.5 0.5 0 0 0 7.3007812 24.5 z M 20.5 26 C 20.2 26 20 26.2 20 26.5 C 20 26.8 20.2 27 20.5 27 L 26.5 27 C 26.8 27 27 26.8 27 26.5 C 27 26.2 26.8 26 26.5 26 L 20.5 26 z M 6 26.675781 C 5.475 26.675781 4.9496094 26.849219 4.5996094 27.199219 C 4.3996094 27.399219 4.3996094 27.700391 4.5996094 27.900391 C 4.7996094 28.100391 5.1007812 28.100391 5.3007812 27.900391 C 5.7007813 27.500391 6.2992187 27.500391 6.6992188 27.900391 C 6.7992187 28.000391 6.9996094 28 7.0996094 28 C 7.1996094 28 7.3003906 28.000391 7.4003906 27.900391 C 7.6003906 27.700391 7.6003906 27.399219 7.4003906 27.199219 C 7.0503906 26.849219 6.525 26.675781 6 26.675781 z "
																fill="#fff" stroke="none" /></svg>
													</div>

												</div>
											</div>
				</div>

				<form name="issue" id="issue">
					<div class="row" id="new_project">
						<div class="col-md-12">
							<div class="row">
								<div class="col-md-12">
									<div class="main_tittle d-flex align-items-center">
										<span class="mr-2">All <spring:message code="issue.book" /> Details</span>
									</div>

								</div>
							</div>
							<input type="hidden" name=issue_id id="issue_id">
							<input type="hidden" name=issueId id="issueId"><!-- for edit issue-->
														<div class="content_box">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0"
										id="isueTable" class="issueclass">
										<thead class="table-head">
											<tr>
												<th>S.No</th>
												<th><spring:message code="issue.book" /> Title</th>
												<th data-orderable="false"><spring:message code="book.journal" /> Name</th>
												<!-- 												<th>Publisher Name</th> -->
												<th><spring:message code="book.journal" /> <spring:message code="issue.book" /> Number</th>
												<th><spring:message code="book.journal" /> Volume Number</th>
												<th><spring:message code="issue.book" /> Volume Year</th>
												<!-- 												<th>Issue Annual Budget</th> -->
												<th><spring:message code="issue.book" /> Create Date</th>
												<!-- <th>Show Article</th> -->
											</tr>
										</thead>
										<tbody>
											<c:forEach var="temp" items="${issueList}"
												varStatus="counter">
												<tr>
													<td>${counter.count}</td>
													<td>${temp.issue_title}</td>
													<td>${temp.journals.journalName}</td>
													<%-- 													<td>${temp.publisher.publisherName}</td> --%>
													<td>${temp.last_issue_number}</td>
													<td>${temp.last_volume_number}</td>
													<td>${temp.volume_year}</td>
													<%-- 													<td>${temp.annual_article_budget}</td> --%>
													<td><fmt:formatDate value="${temp.create_date}"
															pattern="yyyy-MM-dd" /></td>
													<%-- <td
														onclick="IssueArticleDetails(${temp.issue_id},${temp.journals.journalId})"><button
															class="btn btn-outline-success btn-sm" type="button">Details</button></td> --%>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>



					<div class="row" id="inprocess_project">
						<div class="col-md-12">

							<div class="row">
								<div class="col-md-12">
									<div class="main_tittle d-flex align-items-center">
										<span class="mr-2"> Upcoming <spring:message code="issue.book" /> Details</span>
									</div>

								</div>
							</div>


							<div class="content_box">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0"
										id="isuePlaneTable" class="issueclass">
										<thead class="table-head">
											<tr>
												<th>S.No</th>
												<th><spring:message code="issue.book" /> Title</th>
												<th data-orderable="false"><spring:message code="book.journal" /> Name</th>
												<!-- 												<th>Publisher Name</th> -->
												<th><spring:message code="book.journal" /> <spring:message code="issue.book" /> Number</th>
												<th><spring:message code="book.journal" /> Volume Number</th>
												<th><spring:message code="issue.book" /> Volume Year</th>
												<!-- 												<th>Issue Annual Budget</th> -->
												<th><spring:message code="issue.book" /> Create Date</th>
												 <th>Action</th> 
											</tr>
										</thead>
										<tbody>
											<c:forEach var="temp" items="${upcomingIssue}"
												varStatus="counter">
												<tr>
													<td>${counter.count}</td>
													<td>${temp.issue_title}</td>
													<td>${temp.journals.journalName}</td>
													<%-- 													<td>${temp.publisher.publisherName}</td> --%>
													<td>${temp.last_issue_number}</td>
													<td>${temp.last_volume_number}</td>
													<td>${temp.volume_year}</td>
													<%-- 													<td>${temp.annual_article_budget}</td> --%>
													<td><fmt:formatDate value="${temp.create_date}"
															pattern="yyyy-MM-dd" /></td>
													 <th onclick="searchdata(${temp.issue_id});"><button
															class="btn btn-outline-success btn-sm" type="button">Create Issue</button></th>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>




					<div class="row" id="overdue_project">
						<div class="col-md-12">
							<div class="row">
								<div class="col-md-12">
									<div class="main_tittle d-flex align-items-center">
										<span class="mr-2"> Running/Draft <spring:message code="issue.book" /> Details</span>
									</div>

								</div>
							</div>


							<div class="content_box">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0"
										id="inprocess" class="issueclass">
										<thead class="table-head">
											<tr>
												<th>S.No</th>
												<th><spring:message code="issue.book" /> Title</th>
												<th data-orderable="false"><spring:message code="book.journal" /> Name</th>
												<!-- 												<th>Publisher Name</th> -->
												<th><spring:message code="book.journal" /> <spring:message code="issue.book" /> Number</th>
												<th><spring:message code="book.journal" /> Volume Number</th>
												<th><spring:message code="issue.book" /> Volume Year</th>
												<!-- <spring:message code="issue.book" />											<th>Issue Annual Budget</th> -->
												<th><spring:message code="issue.book" /> Create Date</th>
												<th>History / Run Scheduler</th>
												<th><spring:message code="issue.book" /> Layout</th>
												<th>Edit <spring:message code="issue.book" /></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="temp" items="${runingIssue}"
												varStatus="counter">
												<tr>
													<td>${counter.count}</td>
													<td>${temp.issue_title}</td>
													<td>${temp.journals.journalName}</td>
													<%-- 													<td>${temp.publisher.publisherName}</td> --%>
													<td>${temp.last_issue_number}</td>
													<td>${temp.last_volume_number}</td>
													<td>${temp.volume_year}</td>
													<%-- 													<td>${temp.annual_article_budget}</td> --%>
													<td><fmt:formatDate value="${temp.create_date}"
															pattern="yyyy-MM-dd" /></td>
													<td><c:if test="${temp.isScheduled eq 'Y'}">
															<a href="#"
																onclick="IssueSheduleDetails(${temp.issue_id})"
																class="btn btn-outline-success btn-sm" type="button">Details</a>
														</c:if> <c:if test="${temp.isScheduled eq 'N'}">
															<a href="#" onclick="issuesheduler(${temp.issue_id})"
																data-placement="top" title="Run Schedule"> <i
																class="fa fa-play" aria-hidden="true"
																style="font-size: 24px; color: green"></i></a>
														</c:if></td>
													<td><a href="#"
														onclick="downloadExcel(${temp.issue_id})"
														data-placement="top" title="Download  Excel"> <i
															class="fa fa-file-excel-o" aria-hidden="true"
															style="font-size: 24px; color: red"></i></a> &nbsp;&nbsp;
														&nbsp;<a href="#"
														onclick="IssueArticleDetails(${temp.issue_id},${temp.journals.journalId})"
														data-placement="top" title="View Article Info"> <i
															class="fa fa-eye edit-icon"
															style="font-size: 24px; color:"></i></a></td>
													<td onclick="editeIssueMakeUpLIst(${temp.issue_id});">

														<a href="#" class="btn btn-outline-success btn-sm"
														type="button">Edit <spring:message code="issue.book" /></a>
													</td>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>



					<div class="row" id="complete_project">
						<div class="col-md-12">
							<div class="row">
								<div class="col-md-12">
									<div class="main_tittle d-flex align-items-center">
										<span class="mr-2"> Delivered <spring:message code="issue.book" /> Details</span>
									</div>

								</div>
							</div>


							<div class="content_box">
								<div class="box-body">
									<table class="table table-striped table-bordered m-0"
										id="Delivered" class="issueclass">
										<thead class="table-head">
											<tr>
												<th>S.No</th>
												<th><spring:message code="issue.book" /> Title</th>
												<th data-orderable="false"><spring:message code="book.journal" /> Name</th>
												<!-- 												<th>Publisher Name</th> -->
												<th><spring:message code="book.journal" /> <spring:message code="issue.book" /> Number</th>
												<th><spring:message code="book.journal" /> Volume Number</th>
												<th><spring:message code="issue.book" /> Volume Year</th>
												<!-- 												<th>Issue Annual Budget</th> -->
												<th><spring:message code="issue.book" /> Create Date</th>
												<th>History</th>
												<th><spring:message code="issue.book" /> Layout</th>
											<!-- 	<th>Edit Issue</th> -->
											</tr>
										</thead>
										<tbody>
											<c:forEach var="temp" items="${completeDetail}"
												varStatus="counter">
												<tr>
													<td>${counter.count}</td>
													<td>${temp.issueDetail.issue_title}</td>
													<td>${temp.issueDetail.journals.journalName}</td>
													<%-- 													<td>${temp.publisher.publisherName}</td> --%>
													<td>${temp.issueDetail.last_issue_number}</td>
													<td>${temp.issueDetail.last_volume_number}</td>
													<td>${temp.issueDetail.volume_year}</td>
													<%-- 													<td>${temp.annual_article_budget}</td> --%>
													<td><fmt:formatDate value="${temp.issueDetail.create_date}"
															pattern="yyyy-MM-dd" /></td>
													<td onclick="IssueSheduleDetails(${temp.issueDetail.issue_id})"><button
															class="btn btn-outline-success btn-sm" type="button">Details</button></td>
													<td >
													<a href="#" onclick="downloadExcel(${temp.issueDetail.issue_id})"
																data-placement="top" title="Download  Excel"> <i
																class="fa fa-file-excel-o" aria-hidden="true" style="font-size:24px;color:red"></i></a>
															&nbsp;&nbsp;
															&nbsp;<a href="#" onclick="IssueArticleDetails(${temp.issueDetail.issue_id},${temp.issueDetail.journals.journalId})"
																data-placement="top" title="View Article Info"> <i
																class="fa fa-eye edit-icon" style="font-size:24px;color:"></i></a>
															</td>
													<%-- <td onclick="editeIssueMakeUpLIst(${temp.issueDetail.issue_id});">

														<a href="#" class="btn btn-outline-success btn-sm"
															type="button">Edit Issue</a>
													</td> --%>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>


					<div id="">
						<table class="table table-striped table-bordered m-0 "
							id="example"></table>
					</div>
				
					<div id="issueTable">
						<div class="col-md-12">
									<div class="main_tittle d-flex align-items-center">
										<span class="mr-2"><spring:message code="issue.book" /> Details</span>
									</div>
								</div>
						<div class="content_box">
							<div class="box-body">
								<table class="table table-striped table-bordered m-0 "
									id="showData">
									<thead class="table-head">
										<tr>
											<th>S.No</th>
											<th><spring:message code="chapter.article" /> Id</th>
											<th>Workflow</th>
											<th><spring:message code="chapter.article" /> Title</th>
											<th>Page</th>
											<th>From</th>
											<th>To</th>
											<th><spring:message code="book.journal" /></th>
											<th>Sequence Number</th>
											<th><spring:message code="chapter.article" /> DOI</th>
										</tr>
									</thead>
									<tbody id=appData></tbody>
								</table>
							</div>
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>

$(window).on("load", function () {
	$("#issueTable").hide();
});

$(document).ready(function() {
    $('#Delivered').DataTable();
} );
// $(document).ready(function() {
//     $('#isuePlaneTable').DataTable();
// } );
// $(document).ready(function() {
//     $('#inprocess').DataTable();
// } );
/* $(document).ready(function() {
    $('#showData').DataTable();
} ); */
$(document).ready(function() {
	document.getElementById("new_project").style.display = "block";
	document.getElementById("inprocess_project").style.display = "none";
	document.getElementById("overdue_project").style.display = "none";
	document.getElementById("complete_project").style.display = "none";
} );

	function IssueArticleDetails(issueID,journalId) {
			var mappingJSON = {};
			mappingJSON["issueId"] = issueID;
			mappingJSON["jId"] = journalId;
			var mappingInfo = JSON.stringify(mappingJSON);
			$('#appData').empty();
			$.ajax({
				url : '${context}/getIssueArticleList',
				type : "POST",
				data : mappingInfo,
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				cache : false,
				success : function(result) {
					$("#issueTable").show();
					var issueSeq = result.payload;
					if(issueSeq==null){
						alert("No data Found");
					}else{
					issueSeq.forEach(function(x, index) {
					
						var str = '<tr><td>'+ ++index +'</td>'+
						'<td>'+ x.coverArticleId+'</td>'
						+'<td>'+ x.workflows.name+'</td>'+
						'<td>'+ x.articletitle+'</td>'+
						'<td>'+ x.pages+'</td>'+
						'<td>'+ x.page_from+'</td>'+
						'<td>'+ x.to_page+'</td>'+
						'<td>'+ x.journals.journalName+'</td>'+
						'<td>'+ x.sequenceNo+'</td>'+
						'<td>'+ x.articleDoi+'</td>'+
						'</tr>';
						$('#appData').append(str);
						
					});
					$('#showData').DataTable();}
				},
				error : function(e) {
					console.log(e.message);
				}
			});
	}
	</script>
<script>

function showAndHideIssue(val){
	//alert(val)
	if(val=='inprocess'){
		$("#issueTable").hide();
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "block";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
		
	}
	else if(val=='overdue'){
		$("#issueTable").hide();
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "block";
		document.getElementById("complete_project").style.display = "none";
	}
	
	else if(val=='articalList'){
		$("#issueTable").hide();
		document.getElementById("new_project").style.display = "block";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
	} 
	else if(val=='complete'){
		$("#issueTable").hide();
		document.getElementById("new_project").style.display = "none";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "block";
	}
	else if(val==''){
		$("#issueTable").hide();
		document.getElementById("new_project").style.display = "block";
		document.getElementById("inprocess_project").style.display = "none";
		document.getElementById("overdue_project").style.display = "none";
		document.getElementById("complete_project").style.display = "none";
	}
}


</script>
<script>
function IssueSheduleDetails(issueId){
		document.getElementById("issue_id").value =issueId;
	//	document.getElementById("flag").value = 1;
		document.getElementById("issue").action="${context}/issueShecdulerDetails";
		document.getElementById("issue").method="POST";
		document.getElementById("issue").submit();
	}

</script>


<script>
function editeIssueMakeUpLIst(issueID){
	document.getElementById("issueId").value= issueID;
	document.getElementById("issue").action="editGetIssueData";
    document.getElementById("issue").method="POST";
	document.getElementById("issue").submit();
}
</script>

		<script>
	
	$(document).ready(function() {
	    $('#inprocess').DataTable( {
	        initComplete: function () {
	            this.api().columns(2).every( function () {
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
	        }
	    } );
	} );
	</script>
		<script>
	
	$(document).ready(function() {
	    $('#isueTable').DataTable( {
	        initComplete: function () {
	            this.api().columns(2).every( function () {
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
	        }
	    } );
	} );
	</script>
		<script>
	
	$(document).ready(function() {
	    $('#isuePlaneTable').DataTable( {
	        initComplete: function () {
	            this.api().columns(2).every( function () {
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
	        }
	    } );
	} );
	</script>
	<script>
function downloadExcel(issueId) {
	debugger;
  //  alert("File will  download until the  issue will save ");
  		document.getElementById("issue_id").value =issueId;
	document.getElementById("issue").action = "issueCreateExcel";
	document.getElementById("issue").method = "POST";
	document.getElementById("issue").submit();	
}

function searchdata(issueId) {
		document.getElementById("issueId").value =issueId;
		document.getElementById("issue").action = "getIssueData";
		document.getElementById("issue").method = "POST";
		document.getElementById("issue").submit();
}

function issuesheduler(issueId) {
	document.getElementById("issue_id").value =issueId;
	document.getElementById("issue").action = "issuesheduler";
	document.getElementById("issue").method = "POST";
	document.getElementById("issue").submit();
}
</script>

