


//改变博客列表的页数
function changeCurrentPage(currentPage){
    $("#currentPage").val(currentPage);
    $("#homeForm").submit();
}
//模糊查询的按钮事件
function go() {
    $("#like").val($("#goText").val());
    $("#homeForm").submit();
}
//删除博客按钮事件
function deleteBlog(id) {
    var r=confirm("确认删除吗？");
    if (r==true)
    {
        $.ajax({
            url:"/myblog/delete?id="+id,
            type: "post",
            success: function (data) {
                if (data['code']==200) {
                    alert("删除成功");
                    window.location.href = "/myblog/home";
                }else {
                    alert(data['msg']);
                }
            },

            error: function (data) {
                alert(data['msg']);
            }
        })
    }
}





//判断是否登录
var username;
var currentPage;
//页面加载时就判断是否登录
function init() {
    username = $.cookie('username');
    if (username!=null){
        //已登录就改变登录按钮的文本
        $("#login").text("登出");
    }else {
        $("#login").text("登陆");
    }
    currentPage=$("#currentPage").val();

}

//详情页展示编辑和删除按钮的初始化
function loginShow() {

    if (username!=null){
        var edit=$("#edit");
        edit.show();
        var del=$("#delete");
        del.show();
    }else {
        $("#edit").hide();
        $("#delete").hide();
    }

}







//登录按钮事件
function login() {
    if (username!=null){
        //清除cookie 退出登陆
        $.cookie("username","", {expires: -1,path:'/'}); // 删除 cookie
        window.location.reload();
    }else {
        dologin();
    }

}


//登录操作
function dologin() {
    var login = $('#myModal');
    //显示弹出层
    login.modal({
        show:true,
        // backdrop:'static',//禁止位置关闭
        // keyboard:false //关闭键盘事件
    });
    $('#submitMessage').hide();
    $("#loginBtn").click(function () {
        var name = $("#input_username").val();
        var password = $("#input_password").val();
        if (name  == "" || password ==""){
            $('#submitMessage').hide().html('<label class="label label-danger">帐号或密码不能为空！</label>').show(300);
        }else {
            $("#name").val(name);
            $("#password").val(password);
            $("#formLogin").ajaxSubmit({
                success : function(result) {
                    if (result['code']==0){
                        $.cookie('username',name,{
                            expires:7,
                            path:'/'});
                        //刷新页面
                        window.location.reload();
                    } else {
                        $('#submitMessage').hide().html('<label class="label label-danger">帐号或密码错误！</label>').show(300);
                    }

                }

            })
        }
});

}