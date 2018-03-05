<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>  
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table border="1">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
		<th>Buy</th>
	</tr>
	<c:forEach var="p" items="${listProducts }">
		<tr>
			<td>${p.id }</td>
			<td>${p.name }</td>
			<td>
			<c:set var="price" value="${p.price}" /> 
					<fmt:setLocale
						value="en_US" /> 
					<fmt:formatNumber value="${price}"
						type="currency" />
			</td>
			<td align="center"><a href="${pageContext.request.contextPath}/user/shoppingcart/ordernow/${p.id}.html">Ordern Now</a></td>
			
		</tr>
		
	</c:forEach>
</table>

<div class="clear"></div>