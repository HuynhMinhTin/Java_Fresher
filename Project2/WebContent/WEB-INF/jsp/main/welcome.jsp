<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${pageContext.request.userPrincipal.name!=null }">
		<h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
		<a href="${pageContext.request.contextPath}/main/superadmin.html">Super Admin</a>
		<br>
		<a href="${pageContext.request.contextPath}/admin.html">Admin</a>
		<br>
		<a href="${pageContext.request.contextPath}/employee.html">User</a>
		<br>
		<br>
		
		<a href="<c:url value='/j_spring_security_logout'/>">Logout</a>
	</c:if >
</body>
</html>