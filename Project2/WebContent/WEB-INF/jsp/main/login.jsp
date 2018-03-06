<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page session="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/assets/admin/css/main.css">
    <title>Vali Admin</title>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries-->
    <!--if lt IE 9
    script(src='https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js')
    script(src='https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js')
    -->
  </head>
  <body>
   <div class="login-box">
   ${msg }
        <form class="login-form" action="<c:url value='/j_spring_security_check'/> " method="POST">
          <h3 class="login-head"><i class="fa fa-lg fa-fw fa-user"></i>SIGN IN</h3>
          <div class="form-group">
            <label class="control-label">USERNAME</label>
            <input class="form-control" type="text" placeholder="Username" autofocus name="username">
          </div>
          <div class="form-group">
            <label class="control-label">PASSWORD</label>
            <input class="form-control" type="password" placeholder="Password" name="password">
          </div>
          <!--  <div class="form-group">
            <div class="utility">
              <div class="animated-checkbox">
                <label class="semibold-text">
                  <input type="checkbox"><span class="label-text">Stay Signed in</span>
                </label>
              </div>
              <p class="semibold-text mb-0"><a id="toFlip" href="#">Forgot Password ?</a></p>
            </div>
          </div>-->
          <div class="form-group btn-container">
            <button class="btn btn-primary btn-block">SIGN IN <i class="fa fa-sign-in fa-lg"></i></button>
            <input  class="btn btn-primary btn-block" type="submit" value="login">
          </div>
        </form>
        <form class="forget-form" action="index.html">
          <h3 class="login-head"><i class="fa fa-lg fa-fw fa-lock"></i>Forgot Password ?</h3>
          <div class="form-group">
            <label class="control-label">EMAIL</label>
            <input class="form-control" type="text" placeholder="Email">
          </div>
          <div class="form-group btn-container">
            <button class="btn btn-primary btn-block">RESET <i class="fa fa-unlock fa-lg"></i></button>
          </div>
          <div class="form-group mt-20">
            <p class="semibold-text mb-0"><a id="noFlip" href="#"><i class="fa fa-angle-left fa-fw"></i> Back to Login</a></p>
          </div>
        </form>
      </div>
  </body>
  <script src="${pageContext.request.contextPath }/assets/admin/js/jquery-2.1.4.min.js"></script>
  <script src="${pageContext.request.contextPath }/assets/admin/js/essential-plugins.js"></script>
  <script src="${pageContext.request.contextPath }/assets/admin/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath }/assets/admin/js/plugins/pace.min.js"></script>
  <script src="${pageContext.request.contextPath }/assets/admin/js/main.js"></script>
</html>