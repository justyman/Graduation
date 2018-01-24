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
    $("#loginModule").hide(500);
    $("#resetModule").show(1000);
}

/**
 * 隐藏重置密码模块，显示登陆模块
 */
function login(){
    $("#resetModule").hide(500);
    $("#loginModule").show(1000);
}

/**
 * 登陆验证
 */
function submit(){
    $("#loginForm").submit();
}