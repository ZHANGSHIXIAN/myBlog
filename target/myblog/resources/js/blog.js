



function changeCurrentPage(currentPage){
    $("#currentPage").val(currentPage);
    $("#homeForm").submit();
}
function go() {
    $("#like").val($("#goText").val());
    $("#homeForm").submit();
}
function deleteBlog(id) {
    var r=confirm("确认删除吗？");
    if (r==true)
    {
        $.ajax({
            url:"/myblog/delete?id="+id,
            type: "post",
            success: function (data) {
                if (data.status=="success") {
                    alert("删除成功");
                    window.location.href = "/myblog/home";
                }
            },

            error: function (data) {
                alert("data"+data.status);
            }
        })
    }
}





//判断是否登录
var username;
var currentPage;
function init() {
    username = $.cookie('username');
    if (username!=null){
        $("#login").text("登出");
    }else {
        $("#login").text("登陆");
    }
    currentPage=$("#currentPage").val();

}


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








function login() {
    if (username!=null){
        //清除cookie 退出登陆
        $.cookie("username","", {expires: -1,path:'/'}); // 删除 cookie
        window.location.reload();
    }else {
        dologin();
    }

}



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
                success : function(data) {
                    if (data.status=="success"){
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