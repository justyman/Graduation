/**
 * 页面初始化加载用户信息
 */
$(document).ready(function(){
    var staffJson = "";
    var cookies = document.cookie;
    var arrCookies = cookies.split(";");
    for(var i = 0; i < arrCookies.length; i++){
        if(arrCookies[i].contains("staffJson")){
            staffJson = arrCookies[i];
        }
    }

    // 得到用户信息，并写入页面
    var staff = JSON.parse(staffJson.replace("staffJson=", ""));
    var name = staff.name;
    var phone = staff.phone;
    var position = staff.position;
    var image = staff.image;
    var status = staff.status;
    if(status === "Y"){
        $("#staffStatus").text("正常");
    }else if(status === "N"){
        $("#staffStatus").text("冻结");
    }
    if(position === 0){
        $("#staffPosition").text("管理员");
    }else if(position === 1){
        $("#staffPosition").text("审批人员");
    }else if(position === 2){
        $("#staffPosition").text("业务人员");
    }
    $("#staffName").text(name);
    $("#staffImage").src = "/images/" + image;
});