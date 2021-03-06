<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-body">
				<table class="table table-hover table-bordered" id="sampleTable">
					<thead>
						<tr>
							<td>Id</td>
                			<td>name</td>
                			<td><a href="<c:url value='role/register.html'></c:url>" >Insert</a></td>

						</tr>
					</thead>
					<tbody>	
						<c:forEach var="role" items="${roles }">
						<tr style="page-break-inside:auto;">
				
							<td>${role.id}</td>
				
							<td>${role.name}</td>
							<td class="action">
							<a href="<c:url value='role/delete/${role.id}.html'></c:url>" class="delete">delete</a>
							<a href="<c:url value='role/detail/${role.id}.html'></c:url>" class="edit">edit</a>
							</td>
						</tr>
			
					</c:forEach> 
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
 <script src="${pageContext.request.contextPath }/assets/admin/js/jquery-2.1.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/admin/js/essential-plugins.js"></script>
    <script src="${pageContext.request.contextPath }/assets/admin/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/admin/js/plugins/pace.min.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/admin/js/plugins/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/admin/js/plugins/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript">$('#sampleTable').DataTable();</script>