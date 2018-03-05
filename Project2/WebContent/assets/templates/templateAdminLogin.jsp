<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>  
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
    <section class="material-half-bg">
      <div class="cover"></div>
    </section>
    <section class="login-content">
      <div class="logo">
        <h1>Vali</h1>
      </div>
      <tiles:insertAttribute name="content"></tiles:insertAttribute>
       
       
    </section>
     
  </body>
  <script src="${pageContext.request.contextPath }/assets/admin/js/jquery-2.1.4.min.js"></script>
  <script src="${pageContext.request.contextPath }/assets/admin/js/essential-plugins.js"></script>
  <script src="${pageContext.request.contextPath }/assets/admin/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath }/assets/admin/js/plugins/pace.min.js"></script>
  <script src="${pageContext.request.contextPath }/assets/admin/js/main.js"></script>
</html>