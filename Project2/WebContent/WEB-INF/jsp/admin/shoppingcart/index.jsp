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
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
		<th>Buy</th>
	</tr>
	<c:forEach var="p" items="${listProducts }">
		<tr>
			<td>${p.id }</td>
			<td>${p.name }</td>
			<td>${p.price}</td>
			<td align="center"><a href="${pageContext.request.contextPath} admin/shoppingcart/ordernow/${p.id}">Ordern Now</a></td>
			
		</tr>
		
	</c:forEach>
</table>


<div class="pagination">
	<span class="disabled">&lt;&lt;</span><span class="current">1</span><a
		href="#?page=2">2</a><a href="#?page=3">3</a>...<a href="#?page=199">10</a><a
		href="#?page=200">11</a><a href="#?page=2">&gt;&gt;</a>
</div>


<div class="clear"></div>