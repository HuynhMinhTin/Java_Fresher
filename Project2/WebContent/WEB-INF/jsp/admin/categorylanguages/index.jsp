<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-body">
				<table class="table table-hover table-bordered" id="sampleTable">
					<thead>
						<tr>	
							<th>Language</th>
							<th>Category</th>
							<th>Name</th>
							<th><a href="${pageContext.request.contextPath }/admin/categorylanguages/register.html" >Insert</a></th>
						</tr>
					</thead>
					<tbody>	
						<c:forEach var="cl" items="${cls}">
							<tr>
		      					<!--  <td>${category.id}</td>-->
		      					<td>${cl.languages.name}</td>
								<td>${cl.categories.name}</td>
								
								<td>${cl.name}</td>
							
								<td>
								<a  href="${pageContext.request.contextPath }/
								admin/categorylanguages/categorylanguagesdetail/languageId=${cl.languages.id}&categoryId=${cl.categories.id}.html" class="edit">detail</a> |
								<a   href="${pageContext.request.contextPath }/
								admin/categorylanguages/delete/languageId=${cl.languages.id}&categoryId=${cl.categories.id}.html" class="delete">delete</a> |
								
								<a  href="${pageContext.request.contextPath }/
								admin/categorylanguages/detail/languageId=${cl.languages.id}&categoryId=${cl.categories.id}.html" class="edit">edit</a>
								</td>	
							</tr>						
							</c:forEach> 
						
					</tbody>
				</table>
				
			</div>
		</div>
	</div>
</div>
<script
	src="${pageContext.request.contextPath }/assets/admin/js/jquery-2.1.4.min.js"></script>
<script
	src="${pageContext.request.contextPath }/assets/admin/js/essential-plugins.js"></script>
<script
	src="${pageContext.request.contextPath }/assets/admin/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath }/assets/admin/js/plugins/pace.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/admin/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/admin/js/plugins/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
	$('#sampleTable').DataTable();
</script>