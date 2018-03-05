<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--  <ul>
	  <li><a href="${pageContext.request.contextPath }/upload/simpleupload.html">Upload File</a></li>
	</ul>
	-->
	<s:form method="POST" commandName="photo" action="simpleupload.html" enctype="multipart/form-data">
	
		<s:errors path="file"/>
		<br>
		Photo<input type="file" name="file">
		
		<br>
		<input type="submit" value="Upload">
	</s:form>
</body>
</html>