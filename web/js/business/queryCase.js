/**
 * 查询
 */
function query() {
    $("#tips").css("display", "none");
    $("#pages").css("display", "none");
    $("#queryTable").css("display", "none");
    $("#queryResult").empty();

    var card = $("#card").val();
    if(card !== "" && !validateCard(card)){
        $("#tips").text("您输入的卡号格式不正确");
        $("#tips").css("display", "");
        return ;
    }

    var id = $("#idCard").val();
    var channel = $("#channel").val();
    var status = $("#status").val();
    var deadline = $("#deadline").val();
    var pageSize = $("#pageSize").val();

    $.ajax({
        url:"queryCase.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"card":card,"id":id,"channel":channel,"status":status,"deadline":deadline,"pageNum":1,"pageSize":pageSize}),
        success:function(data){
            if(data.result === "200"){
                var json = JSON.parse(data.message);
                var list = eval(json.list);
                if (list === null || list.length === 0) {
                    $("#tips").text("查无结果").css("display", "");
                } else {
                    // 查询结果
                    for (var i = 0; i < list.length; i++) {
                        var trNode = $("<tr/>");
                        addTd(trNode, list[i].card);
                        addTd(trNode, list[i].cusName);
                        addTd(trNode, list[i].channelName);
                        addTd(trNode, list[i].businessName);
                        addTd(trNode, list[i].status);
                        addTd(trNode, list[i].approveName);
                        addTd(trNode, fmtDate(list[i].businessTime));
                        addTd(trNode, list[i].deadline);
                        $("#queryResult").append(trNode);
                    }
                    $("#queryTable").css("display", "");
                    // 分页结果
                    $("#total").text("一共" + json.total + "条记录");
                    $("#pageNum").text("第" + json.pageNum + "页");
                    $("#pages").css("display", "");
                }
            }else if(data.result === "000"){
                $("#tips").text("查询失败").css("display", "");
            }
        },
        error:function(){
            $("#tips").text("数据库异常，请联系管理员").css("display", "");
        }
    });
}

/**
 * 时间戳->yyyy-MM-dd
 */
function fmtDate(timeStamp){
    var date = new Date();
    date.setTime(timeStamp);
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    return y+"-"+m+"-"+d;
}

/**
 * 生成td
 */
function addTd(trNode, result) {
    if(result.length === 16 && result.substring(0,4) === "6258"){
        trNode.append("<td><a href='/businessQueryDetail.do?card=" + result + "' target='_blank'>" + result + "</a></td>");
    }else{
        trNode.append("<td>" + result + "</td>");
    }
}

/**
 * 卡号格式校验
 */
function validateCard(card) {
    if(card.length !== 16){
        return false;
    }
    return validateNum(card);
}

/**
 * 纯数字校验
 */
function validateNum(str) {
    return !isNaN(str);
}