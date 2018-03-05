<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page import="org.springframework.context.i18n.LocaleContextHolder"%>
 


 <div class="features_items" id="itemContainer">

	<h2 class="title text-center"><s:message code="FI"></s:message></h2>
	<%String langCode = LocaleContextHolder.getLocale().getLanguage();
	%>
	
	
	

	<c:forEach var="product1" items="${products }">
	
	<div class="col-sm-4" >
		<div class="product-image-wrapper">
			<div class="single-products">
				<div class="productinfo text-center">
					  <img src="${pageContext.request.contextPath }/assets/user/images/${product1.products.images}" alt="" style="height: 200px;width: 200px" />
					<h2>
						<c:set var="price" value="${product1.products.price}" />
						 <% if( langCode=="en"){%>
	
	
						<fmt:setLocale value="en_US" /> <fmt:formatNumber value="${price}" type="currency" currencySymbol="$" pattern="¤ #,##0.00"/>	
						<%} else{ %>		
						<fmt:setLocale value="vi_VN" /> <fmt:formatNumber value="${price*23000}" type="currency" currencySymbol="VNĐ" pattern=" #,##0.00 ¤"/>	
						<%} %>		
					</h2>
					<p>${product1.name }</p>
					 <a href="${pageContext.request.contextPath }/user/product/detail/${product1.products.id }.html" class="btn btn-default add-to-cart"><i
						class="fa fa-shopping-cart"></i><s:message code="detail"></s:message></a>
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
	 <table>
      <tr>
        <th>Year</th>
        <th>IE</th>
        <th>FF</th>
        <th>Chrome</th>
        <th>Safari</th>
        <th>Opera</th>
      </tr>
      <tr class="paginate">
        <td>2013</td>
        <td>10.5%</td>
        <td>26.8%</td>
        <td>54.8%</td>
        <td>4.0%</td>
        <td>1.8%</td>
      </tr>
      <tr class="paginate">
        <td>2012</td>
        <td>14.7%</td>
        <td>31.1%</td>
        <td>46.9%</td>
        <td>4.2%</td>
        <td>2.1%</td>
      </tr>
      <tr class="paginate">
        <td>2011</td>
        <td>20.2%</td>
        <td>37.7%</td>
        <td>34.6%</td>
        <td>4.2%</td>
        <td>2.5%</td>
      </tr>
      <tr class="paginate">
        <td>2010</td>
        <td>27.5%</td>
        <td>43.5%</td>
        <td>22.4%</td>
        <td>3.8%</td>
        <td>2.2%</td>
      </tr>
      <tr class="paginate">
        <td>2009</td>
        <td>37.2%</td>
        <td>46.4%</td>
        <td>9.8%</td>
        <td>3.6%</td>
        <td>2.3%</td>
      </tr>
      <tr class="paginate">
        <td>2008</td>
        <td>46.0%</td>
        <td>44.4%</td>
        <td>3.6%</td>
        <td>2.7%</td>
        <td>2.4%</td>
      </tr>
    </table>
    <div id="page-nav"></div>


 <script type="text/javascript">
 jQuery(function($) {
	    // Grab whatever we need to paginate
	    var pageParts = $(".paginate");

	    // How many parts do we have?
	    var numPages = pageParts.length;
	    // How many parts do we want per page?
	    var perPage = 2;

	    // When the document loads we're on page 1
	    // So to start with... hide everything else
	    pageParts.slice(perPage).hide();
	    // Apply simplePagination to our placeholder
	    $("#page-nav").pagination({
	        items: numPages,
	        itemsOnPage: perPage,
	        cssStyle: "light-theme",
	        // We implement the actual pagination
	        //   in this next function. It runs on
	        //   the event that a user changes page
	        onPageClick: function(pageNum) {
	            // Which page parts do we show?
	            var start = perPage * (pageNum - 1);
	            var end = start + perPage;

	            // First hide all page parts
	            // Then show those just for our page
	            pageParts.hide()
	                     .slice(start, end).show();
	        }
	    });
	});
</script>
 
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/user/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/user/js/jquery.simplePagination.js"></script>
	
