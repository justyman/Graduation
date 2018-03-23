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

    var status = false;
    $.ajax({
        url:"/login.do",
        type:"post",
        async:false,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"username":username,"password":password}),
        success:function(data){
            if(data.result === "200"){
                $("#resultMessage").text("正在登陆...请稍后...").css("display", "").css("color", "green");
                status = true;
            }else if(data.result === "000"){
                $("#resultMessage").text(data.message).css("display", "");
            }
        },
        error:function(){
            $("#resultMessage").text("服务器故障，请联系管理员").css("display", "");
        }
    });
    return status;
}

/**
 * 校验修改密码信息
 */
function checkReset(){
    $("#resultMessageReset").css("display", "none");
    // 前端校验字段
    var username = $("#login").val();
    var resetPassword = $("#resetPassword").val();
    var confirmPassword = $("#confirmPassword").val();
    var reason = $("#reason").val();
    if(!checkValue(username) || !checkValue(resetPassword)){
        $("#resultMessageReset").text("账号或密码存在不合法字符").css("display", "");
        return false;
    }
    if(username.trim() === "" || resetPassword.trim() === ""){
        $("#resultMessageReset").text("账号或密码不能为空").css("display", "");
        return false;
    }else if(resetPassword === confirmPassword){
        $("#resultMessageReset").text("两次密码不匹配").css("display", "");
        return false;
    }else if(reason.trim() === ""){
        $("#resultMessageReset").text("申请理由不能为空").css("display", "");
        return false;
    }

    $.ajax({
        url:"/reset.do",
        type:"post",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"username":username,"resetword":resetPassword,"reason":reason}),
        success:function(data){
            if(data.result === "200"){
                alert("申请更换密码成功");
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

/**
 * 利用正则表达式进行值校验
 */
function checkValue(value){
    var regex = /^[0-9a-zA-Z]*$/g;
    return regex.test(value);
}