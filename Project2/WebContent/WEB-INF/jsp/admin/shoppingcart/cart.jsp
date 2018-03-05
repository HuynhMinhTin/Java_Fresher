<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>  
<div class="title">
	<span class="title_icon"><img src="${pageContext.request.contextPath }/assets/user/images/bullet1.gif" alt=""
		title=""></span>Special gifts
</div>
<table>
	
		<tr>
			<th>Option</th>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
			
		</tr>
		<c:forEach var="it" items="${sessionScoped.cart }">
		<tr>
			<td align="center">Delete</td>
			<td>${it.product.id }</td>
			<td>${it.product.name }</td>
			<td>${it.product.price}</td>
			<td>${it.product.quantity}</td>
			<td>${it.product.price * it.product.quantity }</td>
		</tr>
		
	</c:forEach>
</table>


<div class="pagination">
	<span class="disabled">&lt;&lt;</span><span class="current">1</span><a
		href="#?page=2">2</a><a href="#?page=3">3</a>...<a href="#?page=199">10</a><a
		href="#?page=200">11</a><a href="#?page=2">&gt;&gt;</a>
</div>


<div class="clear"></div>