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
							<th>Id</th>
							<th>Subject	</th>
							<th>Message</th>
							<th>Name
							</th>
							<th>Contact Number</th>
							<th>Received Date</th>
							<th><a href="<c:url value='account/register.html'></c:url>">Insert</a></th>

						</tr>
					</thead>
					<tbody>	
						<c:forEach var="fb" items="${feedbacks }">
							<tr>
			      				<td>${fb.id}</td>
								<td>${fb.message}</td>
								<td>${fb.subject}</td>
								<td>${fb.name}</td>
								<td>${fb.contactNumber}</td>
								<td>${fb.receivedDate}</td>
								<td class="action"><a
									href="${pageContext.request.contextPath }/admin/feedback/delete/${fb.id}.html"
									class="delete">delete</a> 
					
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