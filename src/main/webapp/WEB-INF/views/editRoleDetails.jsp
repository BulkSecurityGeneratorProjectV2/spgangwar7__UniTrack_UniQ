
<%@ include file="/WEB-INF/includes/include.jsp"%>

<div class="wrapper">
	<div class="main_part_outer" id="content">
		<div class="d-flex flex-column w-100 h-100">
			<div class="container-fluid">
				<!--main_tittle-->
				<div class="row">
					<div class="col-md-12">
						<div class="main_tittle d-flex align-items-center">
							<span class="mr-2">Create Role</span> <span id="Date"></span>
						</div>
					</div>
				</div>
				<!--main_tittle_End-->

				<div class="row ">
					<div class="col-md-12 ">
						<div class="content_box">
							<div class="box-body">


								<form id="roles" name="roles">
									<input type="hidden" name="roleID" id="roleID"
										value="${roleList.roleID}"> <input type="hidden"
										name="createdBy" id="createdBy" value="${roleList.createdBy}">

									<div class="">

										<div class="row">

											<div class="col-md-4">
												<div class="form-group">
													<label for="currency">Role Name</label><input
														name="colour" type="color" id="myColor" value="${roleList.colour}">
													<input type="text" class="form-control" name="roleName" maxlength=25
														id="roleName" placeholder="" autocomplete="off"
														value="${roleList.roleName}">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label for="ExpertiseLevel">Status </label>

													<select id="status" name="status" class="form-control">
														<c:choose>
															<c:when test="${roleList.status eq 'Y'} ">
																<option value="Y">Active</option>
																<option value="N">InActive</option>
															</c:when>
															<c:otherwise>
																<option value="Y">Active</option>
																<option value="N">InActive</option>

															</c:otherwise>
														</c:choose>
													</select>
												</div>
											</div>
											<c:forEach items="${menuList}" var="menu" varStatus="loop">
												
												<div class="col-md-4">
													<div class="form-group">
														<label class="new-lbl" for="ExpertiseLevel">
															${menu.name}<!--  <sup class="text-red">&lowast;</sup> -->
														</label>
														<div class="accordion my_accordion" id="accordionExample"
															style="color: black;">

															<div class="card border box-shadow">

																<div class="card-header" id="headingOne"
																	data-toggle="collapse" data-target="#collapseOne"
																	aria-expanded="true">
																	<label class="form-control">Select ${menu.name}
																		Menu</label>
																</div>

																<div id="collapseOne" class=" show"
																	aria-labelledby="headingOne"
																	data-parent="#accordionExample">
																	<div class="card-body">
																		<c:forEach items="${menu.subMenuList}" var="submenu"
																			varStatus="loop">
																	
																			<c:choose>
																				<c:when test="${submenu.status eq 'Y'}">
																					<input type="checkbox" name=function
																						 value='${submenu.id}'> ${submenu.sname}<br>
																				</c:when>
																				 <c:otherwise>
																					<input type="checkbox" name=function
																						checked="checked" value='${submenu.id}'>${submenu.sname}<br>

																				</c:otherwise>
																			</c:choose>
																		</c:forEach>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</c:forEach>

											

										</div>

									</div>

								</form>
							</div>
							<div class="box-footer text-right">
								<a class="btn btn-outline-danger"
									href="${context}/roleDetails"><i class="fa fa-close"></i>
									Cancel</a> &nbsp; <a class="btn btn-danger"
									href="javascript:;"
									onclick="updateRoleDetails(${roleList.roleID})"><i
									class="fa fa-save"></i> Save</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
$('#roleName').on('input', function() {
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
</script>