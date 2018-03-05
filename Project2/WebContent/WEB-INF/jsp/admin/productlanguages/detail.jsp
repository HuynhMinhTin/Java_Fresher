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
                <s:form class="form-horizontal" action="${pageContext.request.contextPath }/admin/productlanguages/detail/edit/languageId=${pls.languages.id}&productId=${pls.products.id}.html" commandName="pls" >
                   <div class="form-group">
						<label class="control-label col-md-3">Languages</label>
						<div class="col-md-8">
							<s:select class="form-control" id="select" path="languages.id">			
								<s:options items="${language}"  itemLabel="name" itemValue="id" />
							</s:select>
								<label style="color: red;"><c:out value="${error}" /> </label>									
						</div>
						
					</div>
				
                  
                  <div class="form-group">
						<label class="control-label col-md-3">Product</label>
						<div class="col-md-8">
							<s:select class="form-control" id="select" path="products.id">
								
								<s:options items="${product}"  itemLabel="name" itemValue="id" />
							</s:select>
						</div>
				 </div>
                  <div class="form-group">
                    <label class="control-label col-md-3">Name</label>
                    <div class="col-md-8">
                      <s:input class="form-control" type="text" placeholder="Enter Fullname" path="name"/>
                      <div class="form-group has-error">
							<s:errors class="control-label" type="text" path="name"
								for="inputError" />
						</div>
                    </div>                
                  </div>      
                   <div class="form-group">
                    <label class="control-label col-md-3">Descriptions</label>
                    <div class="col-md-8">
                      <s:input class="form-control" type="text" placeholder="Enter Descriptions" path="descriptions"/>
                       <div class="form-group has-error">
							<s:errors class="control-label" type="text" path="descriptions"
								for="inputError" />
						</div>
                    </div>
                  </div>
                  
              </div>
              <div class="card-footer">
                <div class="row">
                  <div class="col-md-8 col-md-offset-3">
                  
                  <input type="submit" value='Submit' class="btn btn-primary icon-btn">
                    &nbsp;&nbsp;&nbsp;
                    <a class="btn btn-default icon-btn" href="#"><i class="fa fa-fw fa-lg fa-times-circle"></i>Cancel</a>
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