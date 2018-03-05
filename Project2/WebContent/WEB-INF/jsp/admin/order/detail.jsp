<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="card">
              <h3 class="card-title">Register</h3>
              <div class="card-body">
                <s:form class="form-horizontal" action="edit/${orderId}.html" method="POST" commandName="orders" >
	                <div class="form-group">
							<label class="control-label col-md-3">User role</label>
							<div class="col-md-8">
								<s:select class="form-control" id="select" path="accounts.id" disabled="true">
									
									<s:options items="${account}"  itemLabel="userNames" itemValue="id" />
								</s:select>
							</div>
					</div>
                 
                  <div class="form-group">
                    <label class="control-label col-md-3">Customer Address</label>
                    <div class="col-md-8">
                      <s:input class="form-control" type="text" placeholder="Enter Customer Address" path="customerAddress"/>
                      <div class="form-group has-error" align="center">
							<s:errors class="control-label" type="text" path="customerAddress"
								for="inputError" />
						</div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="control-label col-md-3">Customer Name</label>
                    <div class="col-md-8">
                      <s:input class="form-control"  id="datepicker" type="text" placeholder="Enter Customer Name" path="customerName"/>
                        <div class="form-group has-error" align="center">
							<s:errors class="control-label" type="text" path="customerName"
								for="inputError" />
						</div>
                    </div>
                  </div>
                   <div class="form-group">
                    <label class="control-label col-md-3">Customer Phone</label>
                    <div class="col-md-8">
                      <s:input class="form-control" type="text" placeholder="Enter Customer Phone" path="customerPhone"/>
                       <div class="form-group has-error" align="center">
							<s:errors class="control-label" type="text" path="customerPhone"
								for="inputError" />
						</div>
                    </div>
                  </div>
                   <div class="form-group">
                    <label class="control-label col-md-3">Customer Email</label>
                    <div class="col-md-8" >
                      <s:input class="form-control" type="text" placeholder="Enter Customer Email" path="customerEmail" />
                      <div class="form-group has-error" align="center">
							<s:errors class="control-label" type="text" path="customerEmail"
								for="inputError" />
						</div>
                    </div>
                    
                  </div>
                    <div class="form-group">
                    <label class="control-label col-md-3">Date</label>
                    <div class="col-md-8">
                      <s:input class="form-control" type="text" placeholder="Enter Date" path="orderDate"/>
                    </div>
                   
                  </div>
                  <div class="form-group">
						<label class="control-label col-md-3">Status</label>
							<div class="col-md-8">
							<div class="radio">
                              <label>
                                <s:radiobutton id="optionsRadios1"  path="status" value="true" label="True"/>
                              </label>
                            </div>
                            <div class="radio">
                              <label>
                                <s:radiobutton id="optionsRadios1"  path="status" value="false" label="False"/>
                              </label>
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