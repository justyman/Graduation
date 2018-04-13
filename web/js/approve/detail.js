$(document).ready(function () {
    var card =  (window.location.search).replace("?card=","");
    $.ajax({
        url:"/queryDetail.do?card=" + card,
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            if(data.result === "200"){
                if (data.message === null || (data.message).length === 0) {
                    $("#tips").css("display", "").css("color", "red");
                } else {
                    var json = JSON.parse(data.message);
                    // 为字段赋值
                    $("#name").text(json.name);
                    $("#gender").text(json.gender);
                    $("#phone").text(json.phone);
                    $("#id").text(json.id);
                    $("#level").text(json.level);
                    $("#credit").text(json.credit);
                    $("#address").text(json.address);
                    $("#card").text(json.card);
                    $("#channel").text(json.channel);
                    $("#deadline").text(json.deadline);
                    $("#businessName").text(json.businessName);
                    $("#businessTime").text(json.businessTime);
                    $("#status").text(json.status);
                    $("#openDate").text(json.openDate);
                    $("#bill").text(json.bill);
                    $("#amount").text(json.amount);
                    $("#money").text(json.money);
                    $("#debt").text(json.debt);
                    $("#delay").text(json.delay);
                    $("#total").text(json.total);
                }
            }else if(data.result === "000"){
                $("#tips").text("查询失败，请联系管理员").css("display", "").css("color", "red");
            }
        },
        error:function(){
            $("#tips").text("服务器异常，请联系管理员").css("display", "").css("color", "red");
        }
    });
});