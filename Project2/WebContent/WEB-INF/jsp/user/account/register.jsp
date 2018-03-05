<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
	<div class="container container-table" >
			<div class="row vertical-center-row">
				<div class="text-center col-md-4 col-md-offset-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
						<s:form method="POST"  action="${pageContext.request.contextPath}/user/account/insert.html" commandName="accounts">
							<s:hidden  path="score" />
							<s:input type="text" placeholder="Username" path="userNames" /><label style="color: red;">${error }</label>
							<label style="color: red;"><s:errors path="userNames"/></label>
							<s:input type="password" placeholder="Password" path="passwords"/>
							<label style="color: red;"><s:errors path="passwords"/></label>
							<input type="password" placeholder="Confirm Password" id="confirmPassword" name="confirmPassword"/>
							<label style="color: red;">${error2 }</label>
							<button type="submit" class="btn btn-primary center-block" >Sign up</button>
						</s:form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
