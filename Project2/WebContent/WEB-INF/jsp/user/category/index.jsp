<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="features_items">
	<!--features_items-->
	<h2 class="title text-center">Features Items</h2>
	<c:forEach var="product" items="${products }">
	<div class="col-sm-4">
		<div class="product-image-wrapper">
			<div class="single-products">
				<div class="productinfo text-center">
					<img src="${pageContext.request.contextPath }/assets/user/images/home/product1.jpg" alt="" />
					<h2>
						<c:set var="price" value="${product.price}" /> 
						<fmt:setLocale value="en_US" /> <fmt:formatNumber value="${price}" type="currency" />					
					</h2>
					<p>${product.name }</p>
					<a href="${pageContext.request.contextPath }/user/product/detail/${product.id }.html" class="btn btn-default add-to-cart"><i
						class="fa fa-shopping-cart"></i>Detail</a>
				</div>
				
			</div>
			<div class="choose">
				<ul class="nav nav-pills nav-justified">
					<li><a href="#"><i class="fa fa-plus-square"></i>Add to
							wishlist</a></li>
					<li><a href="#"><i class="fa fa-plus-square"></i>Add to
							compare</a></li>
				</ul>
			</div>
		</div>
	</div>
	</c:forEach>