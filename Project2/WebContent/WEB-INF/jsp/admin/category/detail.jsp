<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
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
                <s:form class="form-horizontal" method="POST" action="edit/${categoryId }.html" commandName="categories" >
                  <div class="form-group">
                    <label class="control-label col-md-3">Name</label>
                    <div class="col-md-8">
                      <s:input class="form-control" type="text" placeholder="Enter Fullname" path="name"/>
                       <div class="form-group has-error"><s:errors class="control-label" type="text" path="name" for="inputError"/></div>
                    </div>
                  </div>
                  <!--  
                  <div class="form-group">
                    <label class="control-label col-md-3">Email</label>
                    <div class="col-md-8">
                      <input class="form-control col-md-8" type="email" placeholder="Enter email address">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="control-label col-md-3">Address</label>
                    <div class="col-md-8">
                      <textarea class="form-control" rows="4" placeholder="Enter your address"></textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="control-label col-md-3">Gender</label>
                    <div class="col-md-9">
                      <div class="radio-inline">
                        <label>
                          <input type="radio" name="gender">Male
                        </label>
                      </div>
                      <div class="radio-inline">
                        <label>
                          <input type="radio" name="gender">Female
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="control-label col-md-3">Identity Proof</label>
                    <div class="col-md-8">
                      <input class="form-control" type="file">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-md-8 col-md-offset-3">
                      <div class="checkbox">
                        <label>
                          <input type="checkbox">I accept the terms and conditions
                        </label>
                      </div>
                    </div>
                  </div>
                -->
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
</body>
</html>