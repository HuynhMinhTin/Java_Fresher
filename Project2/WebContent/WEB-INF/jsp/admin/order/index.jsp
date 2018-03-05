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
							<!--  <td>Id</td>-->
							<td>Customer Name</td>
							<td>Username</td>
							<td>Status</td>
							<!--  <td>Customer address</td>-->
							
							<!--  <td>Customer Phone</td>-->
							<td>Order Date</td>
							
							<td><a href="<c:url value='order/register.html'></c:url>">Insert</a></td>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="order" items="${orders }">
							<tr>
								<!--  <td>${order.id}</td>-->
								<td>${order.customerName}</td>
								<td>${order.accounts.userNames}</td> 
								<td>${order.status}</td>
								<!-- < td>${order.customerAddress}</td>-->
								
								<!--  <td>${order.customerPhone}</td>-->
								<td>${order.orderDate}</td>
								

								<td class="action">
								<a
									href="<c:url value='order/delete/${order.id}.html'></c:url>"
									class="delete">detail</a> |
								<a
									href="<c:url value='order/delete/${order.id}.html'></c:url>"
									class="delete">delete</a> |
									 <a
									href="<c:url value='order/detail/${order.id}.html'></c:url>"
									class="edit">edit</a></td>
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