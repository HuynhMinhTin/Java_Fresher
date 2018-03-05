<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$('#datepicker').datepicker({
			dateFormat : 'dd/mm/yy'
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="card">
		<h3 class="card-title">Register</h3>
		<div class="card-body">
			<s:form class="form-horizontal" action="${pageContext.request.contextPath}/admin/account/insert.html" method="POST"
				commandName="accounts">
				<div class="form-group">
					<label class="control-label col-md-3">Name</label>
					<div class="col-md-8">
						<s:input class="form-control" type="text"
							placeholder="Enter full name" path="userNames" />
						<div class="form-group has-error">
							<s:errors class="control-label" type="text" path="userNames"
								for="inputError" />
						</div>

					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Password</label>
					<div class="col-md-8">
						<s:input class="form-control" type="text"
							placeholder="Enter Password" path="passwords" />
						<div class="form-group has-error">
							<s:errors class="control-label" type="text" path="passwords"
								for="inputError" />
						</div>
				</div>
				<div class="form-group">
						<label class="control-label col-md-3">User role</label>
						<div class="col-md-8">
							<s:select class="form-control" id="select" path="roles.id">
								
								<s:options items="${role1}"  itemLabel="name" itemValue="id" />
							</s:select>
						</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Score</label>
					<div class="col-md-8">
						<s:input class="form-control" type="text"
							placeholder="Enter Score" path="score" />
						<div class="form-group has-error">
							<s:errors class="control-label" type="text" path="score"
								for="inputError" />
						</div>
				</div>
				<div class="form-group">
						<label class="control-label col-md-3">Status</label>
							<div class="col-md-8">
							<div class="radio">
                              <label>
                                <s:radiobutton id="optionsRadios1"  path="status" value="true" label="True"/>
                              </label>
                            </div>
                            <div class="radio">
                              <label>
                                <s:radiobutton id="optionsRadios1"  path="status" value="false" label="False"/>
                              </label>
                            </div>
							</div>
						
				</div>
					<div class="card-footer">
						<div class="row">
							<div class="col-md-8 col-md-offset-3">

								<input type="submit" value='Submit'
									class="btn btn-primary icon-btn"> &nbsp;&nbsp;&nbsp; <a
									class="btn btn-default icon-btn" href="#"><i
									class="fa fa-fw fa-lg fa-times-circle"></i>Cancel</a>
							</div>
						</div>
					</div>
				</div>
		</div>
		</s:form>
		<script type="text/javascript">
			$('#sl').click(function() {
				$('#tl').loadingBtn();
				$('#tb').loadingBtn({
					text : "Signing In"
				});
			});

			$('#el').click(function() {
				$('#tl').loadingBtnComplete();
				$('#tb').loadingBtnComplete({
					html : "Sign In"
				});
			});

			$('#demoDate').datepicker({

			});

			$('#demoSelect').select2();
		</script>
</body>
</html>