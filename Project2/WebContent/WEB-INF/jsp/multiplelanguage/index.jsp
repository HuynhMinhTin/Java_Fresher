<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/multiplelanguage.html?lang=en">English</a> | 
	<a href="${pageContext.request.contextPath }/multiplelanguage.html?lang=fr">France</a> | 
	<a href="${pageContext.request.contextPath }/multiplelanguage.html?lang=de">Germany</a>
	<s:message code="title"></s:message>
	<s:message code="detail"></s:message>

</body>
</html>