<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="${pageContext.request.contextPath }/assets/user/images/${product1.products.images}" alt="" />
								<h3>ZOOM</h3>
							</div>
							<div id="similar-product" class="carousel slide" data-ride="carousel">
								
								  <!-- Wrapper for slides -->
								    <div class="carousel-inner">
										<div class="item active">
										  <a href=""><img src="${pageContext.request.contextPath }/assets/user/images/product-details/similar1.jpg" alt=""></a>
										  <a href=""><img src="${pageContext.request.contextPath }/assets/user/images/product-details/similar2.jpg" alt=""></a>
										  <a href=""><img src="${pageContext.request.contextPath }/assets/user/images/product-details/similar3.jpg" alt=""></a>
										</div>
										<div class="item">
										  <a href=""><img src="${pageContext.request.contextPath }/assets/user/images/product-details/similar1.jpg" alt=""></a>
										  <a href=""><img src="${pageContext.request.contextPath }/assets/user/images/product-details/similar2.jpg" alt=""></a>
										  <a href=""><img src="${pageContext.request.contextPath }/assets/user/images/product-details/similar3.jpg" alt=""></a>
										</div>
										<div class="item">
										  <a href=""><img src="${pageContext.request.contextPath }/assets/user/images/product-details/similar1.jpg" alt=""></a>
										  <a href=""><img src="${pageContext.request.contextPath }/assets/user/images/product-details/similar2.jpg" alt=""></a>
										  <a href=""><img src="${pageContext.request.contextPath }/assets/user/images/product-details/similar3.jpg" alt=""></a>
										</div>
										
									</div>

								  <!-- Controls -->
								  <a class="left item-control" href="#similar-product" data-slide="prev">
									<i class="fa fa-angle-left"></i>
								  </a>
								  <a class="right item-control" href="#similar-product" data-slide="next">
									<i class="fa fa-angle-right"></i>
								  </a>
							</div>

						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<img src="${pageContext.request.contextPath }/assets/user/images/product-details/new.jpg" class="newarrival" alt="" />
								<h2>${product1.name}</h2>
								<p>Web ID: 1089772</p>
								<img src="${pageContext.request.contextPath }/assets/user/images/product-details/rating.png" alt="" />
								<span>
									<span>
										<c:set var="price" value="${product1.products.price}" /> 
										<fmt:setLocale value="en_US" /> <fmt:formatNumber value="${price}" type="currency" />
									</span>
									<label>Quantity:</label>
									<input type="text" value="3" />
									<button type="button" class="btn btn-fefault cart">
										<i class="fa fa-shopping-cart"></i>
										<a href="${pageContext.request.contextPath}/user/shoppingcart/ordernow/${product1.products.id}.html"><s:message code="addtocart"></s:message></a>
										
									</button>
								</span>
								<p><b>Availability:</b> In Stock</p>
								<p><b>Condition:</b> New</p>
								<p><b>Brand:</b> E-SHOPPER</p>
								<a href=""><img src="${pageContext.request.contextPath }/assets/user/images/product-details/share.png" class="share img-responsive"  alt="" /></a>
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->