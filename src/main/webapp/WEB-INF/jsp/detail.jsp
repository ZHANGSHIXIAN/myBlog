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
    <link href="/resources/css/blog-home.css" rel="stylesheet">

  </head>

  <body>

  <%@include file="common/nav.jsp"%>
  <%@include file="common/login.jsp"%>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">

          <!-- Title -->
          <h1 class="mt-4">${blog.title}</h1>

          <!-- Date/Time -->
          <p><fmt:formatDate value="${blog.createTime}" pattern="yyyy年MM月dd日HH:mm:ss" />
            <%--<button class="btn btn-link btn-sm" id="edit" style="display: none" onclick="editBlog()">编辑</button>--%>
            <button class="btn btn-link btn-sm" id="delete" style="display: none" onclick="deleteBlog(${blog.blogId})">删除</button>
          </p>
          <hr>

          <!-- Post Content -->
          <p class="lead">${blog.contentHtml}</p>
          <hr>

        </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

          <%@include file="common/seacher.jsp"%>

          <%--<!-- Categories Widget -->--%>
          <%--<div class="card my-4">--%>
            <%--<h5 class="card-header">Categories</h5>--%>
            <%--<div class="card-body">--%>
              <%--<div class="row">--%>
                <%--<div class="col-lg-6">--%>
                  <%--<ul class="list-unstyled mb-0">--%>
                    <%--<li>--%>
                      <%--<a href="#">Web Design</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                      <%--<a href="#">HTML</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                      <%--<a href="#">Freebies</a>--%>
                    <%--</li>--%>
                  <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="col-lg-6">--%>
                  <%--<ul class="list-unstyled mb-0">--%>
                    <%--<li>--%>
                      <%--<a href="#">JavaScript</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                      <%--<a href="#">CSS</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                      <%--<a href="#">Tutorials</a>--%>
                    <%--</li>--%>
                  <%--</ul>--%>
                <%--</div>--%>
              <%--</div>--%>
            <%--</div>--%>
          <%--</div>--%>

          <%--<!-- Side Widget -->--%>
          <%--<div class="card my-4">--%>
            <%--<h5 class="card-header">Side Widget</h5>--%>
            <%--<div class="card-body">--%>
              <%--You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!--%>
            <%--</div>--%>
          <%--</div>--%>

        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

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
          loginShow();
      })
  </script>
</html>
