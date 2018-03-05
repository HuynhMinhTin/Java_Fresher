<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  
  $(function() {
      $('#datepicker').datepicker({dateFormat: 'dd/mm/yy'});
});
  </script>
<title>Insert title here</title>
</head>
<body>
	<div class="card">
              <h3 class="card-title">Register</h3>
              <div class="card-body">
                <s:form class="form-horizontal" action="${pageContext.request.contextPath }/admin/product/detail/edit/${productId }.html" commandName="products" enctype="multipart/form-data">
                  <div class="form-group">
                    <label class="control-label col-md-3">Name</label>
                    <div class="col-md-8">
                      <s:hidden  path="name" />
                      <span class="control-label col-md-3" style="font-weight:normal;text-align:left ">${products.name }</span>  
                    </div>
                    
                  </div>
                  <div class="form-group">
						<label class="control-label col-md-3">Category</label>
						<div class="col-md-8">
						<s:hidden  path="categories" />
						<label class="control-label col-md-3" style="font-weight:normal;text-align:left ;">${products.categories.name }</label>  	
						 </div>
				</div>
                  <div class="form-group">
                    <label class="control-label col-md-3">Image</label>
                    <div class="col-md-8">
                      <s:hidden  path="images" />
                      <img alt="" src="${pageContext.request.contextPath }/assets/user/images/${products.images}" style="height: 100px;width: 100px">
                   
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="control-label col-md-3">Creation Date</label>
                    <div class="col-md-8">
                       <s:hidden  path="createDate" />
                      <span class="control-label col-md-3" style="font-weight:normal;text-align:left">${products.createDate}</span>  
                       
                    </div>
                  </div>
                   <div class="form-group">
                    <label class="control-label col-md-3">Price</label>
                    <div class="col-md-8">
                      <s:hidden  path="price" />
                      <span class="control-label col-md-3" style="font-weight:normal;text-align:left">${products.price }</span>  
               
                    </div>
                  </div>
                   <div class="form-group">
                    <label class="control-label col-md-3">Descriptions</label>
                    <div class="col-md-8">
                      <s:hidden  path="descriptions" />
                      <span class="control-label col-md-3" style="font-weight:normal;text-align:left">${products.descriptions}</span>  
                       
                    </div>
                  </div>
                  
              </div>
              <div class="card-footer">
                <div class="row">
                  <div class="col-md-8 col-md-offset-3">
                  
                  <input type="submit" value='Edit' class="btn btn-primary icon-btn">
                    &nbsp;&nbsp;&nbsp;
                    <a class="btn btn-default icon-btn" href="${pageContext.request.contextPath }/admin/product.html"><i class="fa fa-fw fa-lg fa-times-circle"></i>Go Back</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          </s:form>
            <script type="text/javascript">
      $('#sl').click(function(){
      	$('#tl').loadingBtn();
      	$('#tb').loadingBtn({ text : "Signing In"});
      });
      
      $('#el').click(function(){
      	$('#tl').loadingBtnComplete();
      	$('#tb').loadingBtnComplete({ html : "Sign In"});
      });
      
      $('#demoDate').datepicker({
      	
      });
      
      $('#demoSelect').select2();
    </script>
</body>
</html>