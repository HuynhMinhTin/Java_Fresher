<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${ initParam['postturl']}">
	
		<input type="hidden" name="upload" value="">
		<input type="hidden" name="return" value="${initParam['postturl']}">
		<input type="hidden" name="cmd" value="_cart">
		<input type="hidden" name="bussiness" value="${initParam['postturl']}">
		
		<!--Product 1-->
		<input type="hidden" name="item_name_1" value="Product1 ">
		<input type="hidden" name="item_number_1" value="p1">
		<input type="hidden" name="amount_1" value="2">
		<input type="hidden" name="quantity_1" value="3">
		
		<!--Product 2-->
		<input type="hidden" name="item_name_2" value="Product2 ">
		<input type="hidden" name="item_number_2" value="p2">
		<input type="hidden" name="amount_2" value="3">
		<input type="hidden" name="quantity_2" value="4">
		
		<!--Product 2-->
		<input type="hidden" name="item_name_3" value="Product3 ">
		<input type="hidden" name="item_number_3" value="p3">
		<input type="hidden" name="amount_3" value="3">
		<input type="hidden" name="quantity_3" value="2">
		
		<input type="image" scr="http://www.paypal.com/en_US/i/btn/btn_xpressCheckout.gif">
	</form>
</body>
</html>