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
						
							<!--  <th>Id</th>-->
							<th>Name</th>
							<th>Category</th>
							<th>create_Date</th>
							<th>image</th>
							<!--  <th>Description</th>-->
							<th>Price</th>
							<th>Active</th>
							<th><a href="${pageContext.request.contextPath }/admin/product/register.html" >Insert</a></th>

						</tr>
					</thead>
					<tbody>	
						<c:forEach var="product" items="${products }">
							<tr>
		      					<!--  <td>${product.id}</td>-->
		      					<td>${product.name}</td>
								<td>${product.categories.name}</td>
								
								<td>${product.createDate}</td>
								<td>${product.images}</td>
								
								<!--<td>${product.descriptions}</td>-->
								<td>${product.price}</td>
								<td>${product.created}</td>
								<td>
								<a href="${pageContext.request.contextPath }/admin/product/productdetail/${product.id}.html" class="delete">detail</a> |
								<a href="${pageContext.request.contextPath }/admin/product/delete/${product.id}.html" class="delete">delete</a> |
								<a href="${pageContext.request.contextPath }/admin/product/detail/${product.id}.html" class="edit">edit</a>
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