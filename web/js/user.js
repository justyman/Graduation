/**
 * 页面初始化加载用户信息
 */
$(document).ready(function(){
    // 初始化frame
    var ifm= document.getElementById("mainFrame");
    ifm.height=$(document).height();

    var staffJson = "";
    var cookies = document.cookie;
    var arrCookies = cookies.split(";");
    for(var i = 0; i < arrCookies.length; i++){
        if(arrCookies[i].indexOf("staffJson") !== -1){
            staffJson = arrCookies[i];
        }
    }

    // 得到用户信息，并写入页面
    var staff = JSON.parse(staffJson.replace("staffJson=", ""));
    var name = staff.name;
    var position = staff.position;
    var image = staff.image;
    var status = staff.status;
    $("#staffStatus").text(status);
    $("#staffPosition").text(position);
    $("#staffName").text(name);
    $("#staffImage").attr("src", "./images/" + image);

    // 设置初始化主页面信息
    var url = location.href.replace("user", "info");
    $("#mainFrame").attr("src", url);
});

/**
 * 跳转至个人信息页面
 */
function info() {
    var url = location.href.replace("user", "info");
    $("#mainFrame").attr("src", url);
}

/**
 * 跳转至业务查询页面
 */
function businessQuery() {
    var url = location.href.replace("user", "businessQuery");
    $("#mainFrame").attr("src", url);
}

/**
 * 跳转至审批查询页面
 */
function approveQuery() {
    var url = location.href.replace("user", "approveQuery");
    $("#mainFrame").attr("src", url);
}