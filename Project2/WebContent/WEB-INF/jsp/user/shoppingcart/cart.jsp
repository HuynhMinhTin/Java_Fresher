
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>  
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<form method="post" action="${pageContext.request.contextPath}/user/shoppingcart/update.html" id="myform">
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image"><sp:message code="item"></sp:message></td>
							<td class="description"></td>
							<td class="price"><sp:message code="price"></sp:message></td>
							<td class="quantity"><sp:message code="quantity"></sp:message></td>
							<td class="total"><sp:message code="total"></sp:message></td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="it" items="${sessionScope.cart }">
					<c:set var="s" value="${s+ it.productLanguages.products.price * it.quantity }" />
						<tr>
							<td class="cart_product">
								<a href=""><img src="${pageContext.request.contextPath }/assets/user/images/${it.productLanguages.products.images}" alt="" style="height: 150px;width: 150px"></a>
							</td>
							<td class="cart_description">
								<h4><a href="">${it.productLanguages.name }</a></h4>
								<p>Web ID: 1089772</p>
							</td>
							<td class="cart_price">
								<p>.
									<c:set var="price" value="${it.productLanguages.products.price}" /> 
									<fmt:setLocale value="en_US" /> <fmt:formatNumber value="${price}" type="currency" currencySymbol="$"/>
								</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
								<!-- <input class="cart_quantity_up" type="submit" value="+"> -->
									 <a class="cart_quantity_up" href="#" > + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="${it.quantity}" autocomplete="off" size="2">
									<a class="cart_quantity_down" href="#" > - </a>
									
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">
								<c:set var="subtotal" value="${it.productLanguages.products.price * it.quantity }" /> 
								<fmt:setLocale value="en_US" /> <fmt:formatNumber value="${subtotal}" type="currency" currencySymbol="$" />
						</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="${pageContext.request.contextPath}/user/shoppingcart/delete/${it.productLanguages.products.id }.html"><i class="fa fa-times"></i></a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->
	
	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3><sp:message code="donext"></sp:message></h3>
				
			</div>
			
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li><sp:message code="CartSubTotal"></sp:message>
								<span>
									<c:set var="sum" value="${s}" /> 
									<fmt:setLocale value="en_US" /> <fmt:formatNumber value="${sum}" type="currency" currencySymbol="$"/>
								</span>
							</li>
							<li><sp:message code="EcoTax"></sp:message> <span>$0</span></li>
							<li><sp:message code="ShippingCost"></sp:message> <span>Free</span></li>
							<li><sp:message code="total"></sp:message>
								<span>
									<c:set var="sum" value="${s}" /> 
									<fmt:setLocale value="en_US" /> <fmt:formatNumber value="${sum}" type="currency" currencySymbol="$"/>
								</span>
								</li>
						</ul>
							<a class="btn btn-default update" href="${pageContext.request.contextPath}/user/product.html">Continue Shopping</a>
							<a class="btn btn-default update" href="#" onclick="document.getElementById('myform').submit()">Update</a>
							<a class="btn btn-default check_out" href="${pageContext.request.contextPath}/user/shoppingcart/checkout.html">Check Out</a>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->
</form>





<div class="clear"></div>