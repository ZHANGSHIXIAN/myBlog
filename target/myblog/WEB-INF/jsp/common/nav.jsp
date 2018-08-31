<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <br><br>
    <div class="container">
        <a class="navbar-brand" href="#">张世贤的博客</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <button type="button" id="home" onclick="window.location.href='<%=basePath%>myblog/home'"  class="btn btn-primary btn-sm">主页</button>&nbsp;
                </li>
                <li class="nav-item">
                    <button type="button" id="write" onclick="window.location.href='<%=basePath%>myblog/write'" class="btn btn-danger btn-sm">写博客</button>&nbsp;
                </li>
                <li class="nav-item">
                    <button type="button"  id="login" class="btn btn-success btn-sm" onclick="login()">登陆</button>&nbsp;
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-info btn-sm" onclick="window.location.href='<%=basePath%>myblog/about'">关于我</button>
                </li>
            </ul>
        </div>
    </div>
</nav>


<br>
<br>
<br>
