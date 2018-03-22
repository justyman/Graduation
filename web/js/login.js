/**
 * 初始页面隐藏重置密码模块
 */
$(document).ready(function(){
   $("#resetModule").hide();
});

/**
 * 隐藏登陆模块，显示重置密码模块
 */
function reset() {
    $("#loginModule").fadeOut(500);
    $("#resetModule").fadeIn(1000);
}

/**
 * 隐藏重置密码模块，显示登陆模块
 */
function login(){
    $("#resetModule").fadeOut(500);
    $("#loginModule").fadeIn(1000);
}

/**
 * 校验登陆信息
 */
function check(){
    $("#resultMessage").css("display", "none");
    // 前端校验用户名密码
    var username = $("#username").val();
    var password = $("#password").val();
    if(username.trim() === "" || password.trim() === ""){
        $("#resultMessage").text("账号或密码不能为空").css("display", "");
        return false;
    }

    $.ajax({
        url:"/login.do",
        type:"post",
        contentType:"application/json;charset-utf-8",
        data:JSON.stringify({"username":username,"password":password}),
        success:function(data){
            if(data.result === "200"){
                return true;
            }else if(data.result === "000"){
                $("#resultMessage").text(data.message).css("display", "");
            }
            return false;
        },
        error:function(){
            $("#resultMessage").text("服务器故障").css("display", "");
        }
    });
    return false;
}