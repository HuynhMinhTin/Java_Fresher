<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>   
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Transdmin Light</title>

<!-- CSS -->
<link href="${pageContext.request.contextPath }/assets/admin/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath }/assets/admin/css/ie6.css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath }/assets/admin/css/ie7.css" /><![endif]-->

<!-- JavaScripts-->
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/admin/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/admin/js/jNice.js"></script>
</head>

<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>Transdmin Light</span></a></h1>
        
        <!-- You can name the links with lowercase, they will be transformed to uppercase by CSS, we prefered to name them with uppercase to have the same effect with disabled stylesheet -->
        <ul id="mainNav">
        	<li><a href="#" class="active">DASHBOARD</a></li> <!-- Use the "active" class for the active menu item  -->
        	<li><a href="#">ADMINISTRATION</a></li>
        	<li><a href="#">DESIGN</a></li>
        	<li><a href="#">OPTION</a></li>
        	<li class="logout"><a href="#">LOGOUT</a></li>
        </ul>
        <!-- // #end mainNav -->
        
        <div id="containerHolder">
			<div id="container">
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="${pageContext.request.contextPath }/admin/product.html">Product</a></li>
                    	<li><a href="${pageContext.request.contextPath }/admin/account.html" class="active">Account</a></li>
                    	<li><a href="${pageContext.request.contextPath }/admin/category.html">Category</a></li>
                    	<li><a href="${pageContext.request.contextPath }/admin/role.html">Role</a></li>
                    	<li><a href="${pageContext.request.contextPath }/admin/order.html">Order</a></li>
                    	<li><a href="${pageContext.request.contextPath }/admin/orderdetail.html">Order Detail</a></li>
                    </ul>
                    <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2><a href="#">Dashboard</a> &raquo; <a href="#" class="active">Print resources</a></h2>
                
                <div id="main">
                	<tiles:insertAttribute name="content"></tiles:insertAttribute>
                </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
        <p id="footer">Feel free to use and customize it. <a href="http://www.perspectived.com">Credit is appreciated.</a></p>
    </div>
    <!-- // #wrapper -->
</body>
</html>
