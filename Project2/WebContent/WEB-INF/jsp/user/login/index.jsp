<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
	<div class="container container-table" >
			<div class="row vertical-center-row">
				<div class="text-center col-md-4 col-md-offset-4">
					<div class="signup-form"><!--sign up form-->
						<h2><sp:message code="login"></sp:message></h2>
						<c:url var="post_url" value='/user/login/authen.html'></c:url>
						<s:form method="POST"  action="${post_url }" commandName="accounts">
							<s:hidden  path="score" />
							<s:input type="text" placeholder="Username" path="userNames" /><label style="color: red;">${error }</label>
							<label style="color: red;"><s:errors path="userNames"/></label>
							<s:input type="password" placeholder="Password" path="passwords"/>
							<label style="color: red;"><s:errors path="passwords"/></label>
							
							<button type="submit" class="btn btn-primary center-block" ><sp:message code="login"></sp:message></button>
							
						</s:form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
