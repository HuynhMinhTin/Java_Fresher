<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
	Account
<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-body">
				<table class="table table-hover table-bordered" id="sampleTable">
					<thead>
						<tr>
							<!--<th>Id</th>-->
							<th>user_names</th>
							<th>status</th>
							<th>passwords
							</th>
							<th>Role</th>
							<th>score</th>
							<th><a href="<c:url value='account/register.html'></c:url>">Insert</a></th>

						</tr>
					</thead>
					<tbody>	
						<c:forEach var="account" items="${accounts }">
							<tr>
		      				<!--  	<td>${account.id}</td>-->
							<td>${account.userNames}</td>
							<td>${account.status}</td>
							<td>${account.passwords}</td>
							<td>${account.roles.name}</td>
							<td>${account.score}</td>
							<td class="action">
								<a
								href="${pageContext.request.contextPath }/admin/account/delete/${account.id}.html"
								class="delete">detail</a> |
								<a
								href="${pageContext.request.contextPath }/admin/account/delete/${account.id}.html"
								class="delete">delete</a> |
								<a
								href="${pageContext.request.contextPath }/admin/account/detail/${account.id}.html"
								class="edit">edit</a></td>	
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