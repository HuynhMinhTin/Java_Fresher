<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Price</th>	
		<th>Description</th>
	</tr>
	<c:forEach var="p" items="${listProducts }">
		<tr>
			<td>${p.id }</td>
			<td>${p.name }</td>
			<td>${p.price }</td>
			<td>${p.descriptions }</td>
		</tr>	
	</c:forEach>
	</table>
</body>
</html>