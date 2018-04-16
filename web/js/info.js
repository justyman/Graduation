/**
 * 页面加载后访问后台取得用户信息
 */
$(document).ready(function () {
    $.ajax({
        url:"staffInfo.do",
        type:"post",
        async:false,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            if(data.result === "200"){
                var staff = JSON.parse(data.message);
                $("#staffName").text(staff.name);
                $("#staffSex").text(staff.sex);
                $("#staffBornDate").text(staff.birth);
                $("#staffUsername").text(staff.username);
                $("#staffJobDate").text(staff.entry);
                $("#staffPhone").text(staff.phone);
                $("#staffPosition").text(staff.position);
                $("#staffStatus").text(staff.status);
            }
        }
    });
});