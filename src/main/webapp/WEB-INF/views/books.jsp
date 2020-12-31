<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 
 

	<div class="container-fluid">

		<div class="accordion my_accordion" id="accordionExample">
			<form:form method="POST" action="/createbook"
				modelAttribute="books"  style="
    padding-top: 101px;">
				<div class="card">

					<div class="card-header" id="headingOne" data-toggle="collapse"
								data-target="#collapseOne" aria-expanded="true">
					    <span class="fos">Create Book</span>
						 
						
					</div>

					<div id="collapseOne" class="collapse show"
						aria-labelledby="headingOne" data-parent="#accordionExample">
						<div class="card-body">
							<div class="row">
								<!-- <div  class="col-md-6"> -->
								<div class="form-group col-md-4">
									<label>Book Acronym: </label>
									<input type="text"
										name="journalAcronym" class="form-control"
										placeholder="book Acronym">
								</div>

								<div class="form-group col-md-4">
									 <label> Partner name: </label>  <input type="text" name="partnername"
										class="form-control" placeholder="Partner name">
								</div>

								<div class="form-group col-md-4">
									<label>Book Title: </label>  <input type="text" name="journalTitle"
										class="form-control" placeholder="book Title">
								</div>

								<div class="form-group col-md-4">
									 <label> Partner Contact
											: </label>
								  <input type="text"
										name="partnerContact" class="form-control"
										placeholder="Partner Contact">
								</div>

								<div class="form-group col-md-4">
									<label> Short Title : </label>  <input type="text" name="shortTitle"
										class="form-control" placeholder="Short Title">
								</div>

								<div class="form-group col-md-4">
									 <label> INGESTION
											Method:</label>
									 <input type="text"
										name="INGESTIONMethod" class="form-control"
										placeholder="Ingestion Method">
								</div>

								<div class="form-group col-md-4">
									 <label> OA Status: </label>
									  <input type="text"
										name="oAStatus" class="form-control" placeholder="OA Status">
								</div>

								<div class="form-group col-md-4">
									 <label> House Style: </label>   <input type="text" name="houseStyle"
										class="form-control" placeholder="House Style">
								</div>

								<div class="form-group col-md-4">
									 <label> Online ISSN:</label>   <input type="text" name="onlineIssn"
										class="form-control" placeholder="Online ISSN">
								</div>

								<div class="form-group col-md-4">
									 <label> Page Layout: </label>  <input type="text" name="pageLayout"
										class="form-control" placeholder="Page Layout">
								</div>

								<div class="form-group col-md-4">
									<label> Print ISSB: </label>  <input type="text" name="printIssn"
										class="form-control" placeholder="Print ISSN">
								</div>

								<div class="form-group col-md-4">
									 <label>Publication Type:
									</label>
									  <input type="text"
										name="publicationType" class="form-control"
										placeholder="Publication Type">
								</div>

								<div class="form-group col-md-4">
									 <label> ISSB to Use for
											DOI: </label>
								  <input type="text"
										name="issnDoi" class="form-control"
										placeholder="ISSB to Use for DOI">
								</div>

								<div class="form-group col-md-4">
									 <label> Sequential issue
											numbering?: </label>
									  <input type="text"
										name="sequentialIssue" class="form-control"
										placeholder="Sequential issue numbering?">
								</div>
								<div class="form-group col-md-4">
									 <label> Book Comments
											: </label>
									   <input type="text"
										name="journalComments" class="form-control"
										placeholder="book Comments">
								</div>
								<div class="form-group col-md-4">
									<label> DOI Prefix : </label>   <input type="text" name="doiPrefix"
										class="form-control" placeholder="DOI Prefix">
								</div>

								<div class="form-group col-md-4">
									<label> CODEN: </label>   <input type="text" name="coden"
										class="form-control" placeholder="CODEN">
								</div>

								<div class="form-group col-md-4">
									<label> DOI Creation Rule
											:</label>   <input type="text"
										name="creationRule" class="form-control"
										placeholder="Doi Creation Rule">
								</div>

								<!-- </div> -->

								<!-- <div  class="col-md-6"> -->

								<div class="form-group col-md-4">
									 <label>Chapter Id
											Created By Application*: </label>  <input
										type="text" name="articleID" class="form-control"
										placeholder="Chapter Id Created By Application">
								</div>



							</div>

							<button type="submit" class="btn btn-danger ">Submit</button>

						</div>
						
					</div>


				</div>
			</form:form>

			<%-- <div>
				<form:form method="POST" action="/createjournal"
					modelAttribute="journal">
					<div class="card">
						<div class="card-header" id="headingTwo" data-toggle="collapse" data-target="#collapseTwo"
									aria-expanded="false">
						    <span class="fos">Production Workflow Info</span>
							 
						</div>
						<div id="collapseTwo" class="collapse"
							aria-labelledby="headingTwo" data-parent="#accordionExample">
							<div class="card-body">
								<div class="row">
								<div class="form-group col-md-4">
									<label>Book Workflow:
									</label> <input type="text"
										name="articleWorkflow" class="form-control"
										placeholder="Article Workflow">
								</div>

								<div class="form-group col-md-4">
									 <label> Direct
											Proofing(Default): </label>  <input
										type="text" name="directProofing" class="form-control"
										placeholder="Partner name">
								</div>

								<div class="form-group col-md-4">
									<label>Issue Workflow: </label>  <input type="text"
										name="issueWorkflow" class="form-control"
										placeholder="Journal Title">
								</div>

								<div class="form-group col-md-4">
									 <label> Pre-Proofread
											Check : </label>
									  <input type="text"
										name="preProofreadCheck" class="form-control"
										placeholder="Partner Contact">
								</div>

								<div class="form-group col-md-4">
									<label> Forthcoming
											Articles(Default): </label> <input
										type="text" name="forthcomingArticles" class="form-control"
										placeholder="Short Title">
								</div>

								<div class="form-group col-md-4">
									 <label> Language Editing
											(Default):</label>
									  <input type="text"
										name="languageEditing" class="form-control"
										placeholder="Language Editing">
								</div>

								<div class="form-group col-md-4">
									 <label>Accepted
											Manuscript(Default): </label>
									   <input type="text"
										name="acceptedManuscript" class="form-control"
										placeholder="OA Accepted Manuscript">
								</div>

								<div class="form-group col-md-4">
									 <label>
											Proofreading(Default): </label>  <input
										type="text" name="proofreading" class="form-control"
										placeholder="Proofreading">
								</div>

								<div class="form-group col-md-4">
									 <label>
											Auto-Assess(Defult):</label>  <input
										type="text" name="autoAssess" class="form-control"
										placeholder="Auto-Assess">
								</div>

								<div class="form-group col-md-4">
									 <label>Show DigiEdit
											Link(PE/FL): </label>  <input
										type="text" name="showDigiEditLink" class="form-control"
										placeholder="Show DigiEdit Link">
								</div>

								<div class="form-group col-md-4">
									<label> Author Proofing:
									</label> </span> <input type="text"
										name="authorProofing" class="form-control" placeholder="PDF/HTML">
								</div>
							</div>
						</div>
					</div>

				</form:form>

			</div> --%>
			<%-- <div>
				<form:form method="POST" action="/createjournal"
					modelAttribute="journal">
					<div class="card">
						<div class="card-header" id="headingFour" data-toggle="collapse" data-target="#collapseFour"
									aria-expanded="false">
						    <span class="fos">People Information</span>
							 
						</div>
						<div id="collapseFour" class="collapse"
							aria-labelledby="headingFour" data-parent="#accordionExample">
							<div class="card-body">
								<div class="row">


									<div class="form-group col-md-4">
										 <label>Assign PE ?: </label>
										  <input type="text"
											name="assign" class="form-control" placeholder="Assign">
									</div>

									<div class="form-group col-md-4">
										 <label>Pre-Press
												Supplier:</label>
									  <input type="text"
											name="prePress" class="form-control"
											placeholder="Pre-Press Supplier Name">
									</div>

									<div class="form-group col-md-4">
										 <label> Production
												Editor: </label>
										   <input type="text"
											name="editorName" class="form-control"
											placeholder="Production Editor Name">
									</div>
									<div class="form-group col-md-4">
										 <label>XML Notificaion
												To supplier: </label>
										   <input type="text"
											name="xmlNotificatio" class="form-control" placeholder="YES/No">
									</div>

									<div class="form-group col-md-4">
										<label> Journal Team
												Signature: </label>  <input
											type="text" name="signature" class="form-control"
											placeholder="Signature">
									</div>

									<div class="form-group col-md-4">
										<label> Supplier
												Contact: </label>  <input type="text"
											name="supplierContact" class="form-control"
											placeholder="Name of Supplier">
									</div>

									<div class="form-group col-md-4">
										<label> Journal E-Mail:</label>
									 <input type="text" name="eMail"
											class="form-control" placeholder="E-Mail">
									</div>
									</div>
								</div>
							</div>
						</div>
						</form:form>
					</div> --%>
				
			<%-- </div>
			<div>
				<form:form method="POST" action="/createjournal"
					modelAttribute="journal">
					<div class="card">
						<div class="card-header" id="headingThree" data-toggle="collapse" data-target="#collapseThree"
									aria-expanded="false">
						    <span class="fos">Chapter Information</span>
							 
						</div>
						<div id="collapseThree" class="collapse"
							aria-labelledby="headingThree" data-parent="#accordionExample">
							<div class="card-body">
								<div class="row">

									<div class="form-group col-md-4">
										 <label>Regular Chapter
												: </label>  <input type="text"
											name="regularArticle" class="form-control"
											placeholder="regularBook">
									</div>

									<div class="form-group col-md-4">
										 <label>Special Chapter
												: </label>  <input type="text"
											name="specialArticle" class="form-control"
											placeholder="Special Chapter">
									</div>

									<div class="form-group col-md-4">
										 <label>Short Fast
												Article : </label>  <input type="text"
											name="ShortFastArticle" class="form-control"
											placeholder="shortFastArticle">
									</div>

									<div class="form-group col-md-4">
										 <label>Review Chapter :
										</label>  <input type="text"
											name="reviewFastArticle" class="form-control"
											placeholder="ReviewFastArticle">
									</div>

									<div class="form-group col-md-4">
										 <label>Other : </label>   <input type="text" name="other"
											class="form-control" placeholder="Other">
									</div>

									<div class="form-group col-md-4">
										 <label>Corrections : </label>   <input type="text"
											name="corrections" class="form-control" placeholder="Other">
									</div>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div> --%>
		</div>
	</div>

 