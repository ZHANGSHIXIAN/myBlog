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
      <h2>关于我</h2>
      <p class="lead">姓名:张世贤</p>
      <p class="lead">年龄:23</p>
      <p class="lead">所在城市:深圳</p>
      <p class="lead">联系邮箱:623678979@qq.com</p>
      <p class="lead">本站所用技术:Spring+SpringMvc+Mybatis+mysql+bootstrap+ajax+editormd(markdown编辑器)</p>
      <p>github地址:<a href="https://github.com/ZHANGSHIXIAN/myBlog">https://github.com/ZHANGSHIXIAN/myBlog</a></p>
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

</html>
