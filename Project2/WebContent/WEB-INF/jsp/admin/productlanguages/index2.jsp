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
							<th>Language</th>
							<th>Product</th>
							<th>Name</th>
							<th><a href="${pageContext.request.contextPath }/admin/productlanguages/register.html" >Insert</a></th>
						</tr>
					</thead>
					<tbody>	
						<c:forEach var="pl" items="${pls}">
							<tr>
		      					<!--  <td>${product.id}</td>-->
		      					<td>${pl.languages.name}</td>
								<td>${pl.products.name}</td>
								
								<td>${pl.name}</td>
							
								<td>
								
							
								
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
    <script src="${pageContext.request.contextPath }/assets/admin/js/main.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/admin/js/plugins/bootstrap-notify.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/admin/js/plugins/sweetalert.min.js"></script>
     <script type="text/javascript">
      $('#demoNotify').click(function(){
      	$.notify({
      		title: "Update Complete : ",
      		message: "Something cool is just updated!",
      		icon: 'fa fa-check' 
      	},{
      		type: "info"
      	});
      });
      $('#demoSwal').click(function(){
      	swal({
      		title: "Are you sure?",
      		text: "You will not be able to recover this imaginary file!",
      		type: "warning",
      		showCancelButton: true,
      		confirmButtonText: "Yes, delete it!",
      		cancelButtonText: "No, cancel plx!",
      		closeOnConfirm: false,
      		closeOnCancel: false
      	}, function(isConfirm) {
      		if (isConfirm) {
      			swal("Deleted!", "Your imaginary file has been deleted.", "success");
      		} else {
      			swal("Cancelled", "Your imaginary file is safe :)", "error");
      		}
      	});
      });
    </script>