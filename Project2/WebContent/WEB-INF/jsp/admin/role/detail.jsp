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
	<s:form class="jNice" method="POST" action="edit/${roleId }.html" commandName="roles">
		 <table cellpadding="0" cellspacing="0" style="page-break-inside:auto;">
			                     
		<tr style="page-break-inside:auto;">
				
				<td>Id</td>
				<td><s:input path="id"  /></td>
				
				
			</tr>
			<tr style="page-break-inside:auto;">
				
				<td>Name</td>
				<td><s:input path="name"  /></td>
				
				
			</tr>
			
			<tr valign="middle">
				<td colspan="2" style="text-align:center;" valign="middle"><input type="submit" value="Submit" style="margin: 0 auto;"/></td>
			</tr>
			
		                  
          </table>
          
	</s:form>
		
	
       
					
</form>
</body>
</html>