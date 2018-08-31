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
    <title>写博客</title>
    <link rel="stylesheet" href="/resources/css/style.css" />
    <link rel="stylesheet" href="/resources/css/editormd.css" />
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon" />
    <link href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<%@include file="common/nav.jsp"%>
<%@include file="common/login.jsp"%>


<form id="formBlog" action="<%=basePath%>myblog/submit" method="post">
    <input id="blog_title" name="title" value="" style="display: none;"></input>
    <textarea id="blog_md" name="contentMd" value="" style="display: none;"></textarea>
    <textarea id="blog_html" name="contentHtml" value="" style="display: none;"></textarea>
</form>




<div id="layout">
    <header>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-8 column">
                    <input type="text" class="form-control" id="art-head" name="art-head" placeholder="标题">
                </div>
                <div class="col-md-4 column">
                    <button class="btn btn-success btn-blog-save">发布内容</button>
                </div>
            </div>
        </div>
    </header>
    <div id="blog_mdedit">
                <textarea style="display:none;"></textarea>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.3.0/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery.form/4.0.0/jquery.form.min.js"></script>
<script src="/resources/js/editormd.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
    var md_edit;
    $(function() {
        md_edit = editormd("blog_mdedit", { //注意1：这里的就是上面的DIV的id属性值
            placeholder : '  欢迎使用'+'${title}' +" 博客",
            width : "90%",
            height : 700,
            syncScrolling : "single",
            emoji : true,
            path : "/resources/lib/", //注意2：你的路径
            saveHTMLToTextarea : true,
            tocm : true, // Using [TOCM]
            tex : true, // 开启科学公式TeX语言支持，默认关闭
            flowChart : true, // 开启流程图支持，默认关闭
            /* 上传图片配置 */
            imageUpload : true,
            imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
            imageUploadURL : "${proPath }/base/blog/upFile", //注意你后端的上传图片服务地址
        });
    });

    $('.btn-blog-save').click(function() {
        $("#formBlog")[0].reset();//清空表单数据，避免上次数据干扰
        $("#blog_title").val($("#art-head").val());
        $("#blog_md").val(md_edit.getMarkdown());//md格式内容，使用md的js获取
        $("#blog_html").val(md_edit.getHTML());
        $("#formBlog").ajaxSubmit({
            success : function(data) {
                if (data['code']=200){
                    alert(data['msg']);
                    window.location.href = "/myblog/home";
                }else {
                    alert(data['msg']);
                }


            }
        });
    });
</script>
</body>
<script type="text/javascript" src="/resources/js/blog.js"></script>
<script>
    $(document).ready(function () {
        init();
    })
</script>
</html>