<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<form id="homeForm" action="<%=basePath%>myblog/home" method="get">
    <input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}">
    <input type="hidden" name="like" id="like" value="${like}">
</form>

<!-- Search Widget -->
<div class="card my-4">
    <h5 class="card-header">查询</h5>
    <div class="card-body">
        <div class="input-group">
            <input type="text" class="form-control" id="goText" placeholder="Search for...">
            <span class="input-group-btn">
                  <button class="btn btn-primary" type="button" id="goBtn" onclick="go()">Go!</button>
                </span>
        </div>
    </div>
</div>