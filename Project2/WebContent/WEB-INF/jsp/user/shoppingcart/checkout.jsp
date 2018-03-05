<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>  
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
	<section id="cart_items">
		<div class="container">
			
			<div class="review-payment">
				<h2>Review & Payment</h2>
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
									<fmt:setLocale value="en_US" /> <fmt:formatNumber value="${price}" type="currency" />
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
								<fmt:setLocale value="en_US" /> <fmt:formatNumber value="${subtotal}" type="currency" />
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
			<div class="shopper-informations">
				<div class="row">
					<div class="col-md-4 .col-md-4-offset-5  clearfix" style="margin: auto;float: none;">
						<div class="shopper-info">
							<p>Shopper Information</p>
							
							<s:form method="post" action="${pageContext.request.contextPath}/
									user/shoppingcart/saveOrder.html" id="myform" commandName="order">
								<s:hidden path="orderDate"/>	<s:hidden path="status"/><s:hidden path="id"/>
								<s:input type="text" placeholder="Please insert UserName" path="accounts.userNames"></s:input>
								<div class="form-group has-error">
									<s:errors class="control-label" type="text" path="accounts.userNames"
										for="inputError" />
									
								</div>
								<s:input type="text" placeholder="Please Insert Password" path="accounts.passwords"></s:input>
								<div class="form-group has-error">
									<s:errors class="control-label" type="text" path="accounts.passwords"
										for="inputError" />
									<label style="color: red;">${error1 }</label>
								</div>
								<s:input type="text" placeholder="Please Insert Customer Address" path="customerAddress"></s:input>
								<div class="form-group has-error">
									<s:errors class="control-label" type="text" path="customerAddress"
										for="inputError" />
									
								</div>
								<s:input type="text" placeholder="Please Insert Customer Name" path="customerName"></s:input>
								<div class="form-group has-error">
									<s:errors class="control-label" type="text" path="customerName"
										for="inputError" />
									
								</div>
								<s:input type="text" placeholder="Please Insert Customer Email" path="customerEmail"></s:input>
								<div class="form-group has-error">
									<s:errors class="control-label" type="text" path="customerEmail"
										for="inputError" />
									
								</div>
								<s:input type="text" placeholder="Please Insert Customer Phone" path="customerPhone"></s:input>
								<div class="form-group has-error">
									<s:errors class="control-label" type="text" path="customerPhone"
										for="inputError" />
									
								</div>
							
							<a class="btn btn-primary" id="singlebutton" href="#" onclick="document.getElementById('myform').submit()">Continue</a>
							</s:form>
						</div>
					</div>
					
								
				</div>
			</div>
			
	</section> <!--/#cart_items-->

