<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@include file="common/tag.jsp" %>
<%
  String path=request.getContextPath();
  String basePath =request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/";
%>
<!DOCTYPE html>
<html lang="zh">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ZHANGSHIXIAN的博客</title>

    <link href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath%>myblog/resources/css/blog-home.css" rel="stylesheet">

  </head>

  <body>

  <%@include file="common/nav.jsp"%>
  <%@include file="common/login.jsp"%><div class="container">
    <div class="jumbotron">
      <h1>请先登录</h1>
      <p class="lead">登陆后即可使用markdown发表博客~</p>
      <p><a class="btn btn-lg btn-success" onclick="login()" role="button">登陆</a></p>
    </div>


  </div> <!-- /container -->

  <%@include file="common/foot.jsp"%>

    <!-- Bootstrap core JavaScript -->
  <script src="https://cdn.bootcss.com/jquery/3.3.0/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
  <script src="https://cdn.bootcss.com/jquery.form/4.0.0/jquery.form.min.js"></script>

  </body>
  <script type="text/javascript" src="/resources/js/blog.js"></script>
  <script>
      $(document).ready(function () {
          init();
          login();
      })
  </script>
</html>
