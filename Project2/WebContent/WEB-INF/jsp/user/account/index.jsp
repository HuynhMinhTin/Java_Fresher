<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<s:form class="jNice" method="POST" action="${pageContext.request.contextPath}/user/account/welcome.html"
	commandName="accounts">
	<table cellpadding="1" cellspacing="1" style="page-break-inside: auto;" border="1">
		<tr style="page-break-inside: auto;">
			<td>User Name</td>
			<td><s:input path="userNames" /></td>
		</tr>

		<tr style="page-break-inside: auto;">
			<td>Password</td>
			<td><s:password path="passwords" /></td>
		</tr>
		<tr style="page-break-inside: auto;">
			<td>Remember me</td>
			<td><input type="checkbox" name="remember" value="1"></td>
		</tr>
		<tr valign="middle">
			<td colspan="2" style="text-align: center;" valign="middle"><input
				type="submit" value="Submit" style="margin: 0 auto;" /></td>
		</tr>
	</table>
</s:form>


