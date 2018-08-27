<!-- 模态框（Modal） -->
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <form id="formLogin" action="<%=basePath%>myblog/doLogin" method="post">
        <input id="name" name="name" value="" style="display: none;"/>
        <input id="password" name="password" value="" style="display: none;"/>
    </form>


    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h4 class="modal-title" id="myModalLabel">
                    登录
                </h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="input_username" class="form-control" placeholder="username" required autofocus>
                <input type="password" id="input_password" class="form-control" placeholder="Password" required>

            <div class="checkbox">
                <%--<label>--%>
                    <%--<input type="checkbox" value="remember-me" id="rm" >记住我--%>
                <%--</label>--%>
            </div>
            </div>
            <div class="modal-footer">
                <span id="submitMessage" class="glyphicon"></span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" id="loginBtn" class="btn btn-primary">
                    登录
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div>
</div>