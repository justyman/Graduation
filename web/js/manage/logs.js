var username;
var time;
var pageSize;
var pages;

/**
 * 查询系统用户信息
 */
function query() {
    $("#tips").css("display", "none");
    $("#pages").css("display", "none");
    $("#queryTable").css("display", "none");
    $("#queryResult").empty();

    username = $("#username").val();
    time = $("#time").val() === "" ? "2018-01-01" : $("#time").val();
    pageSize = $("#pageSize").val();

    if(time.length !== 10 || time.charAt(4) !== "-" || time.charAt(7) !== "-" ||
        isNaN(time.substring(0,4)) || isNaN(time.substring(5,7)) || isNaN(time.substring(8,10))){
        $("#tips").text("日期输入格式不正确").css("display", "");
        return ;
    }

    $.ajax({
        url:"queryLog.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"username":username,"time":time,"pageNum":1,"pageSize":pageSize}),
        success:function (data) {
            if(data.result === "200"){
                var json = JSON.parse(data.message);
                if(json === null || json.length === 0){
                    $("#tips").text("查无结果").css("display", "");
                    return ;
                }
                var list = eval(json.list);
                if (list === null || list.length === 0) {
                    $("#tips").text("查无结果").css("display", "");
                } else {
                    // 查询结果
                    for (var i = 0; i < list.length; i++) {
                        var trNode = $("<tr/>");
                        addTd(trNode, list[i].username);
                        addTd(trNode, fmtDate(list[i].time));
                        addTd(trNode, list[i].message);
                        $("#queryResult").append(trNode);
                    }
                    $("#queryTable").css("display", "");
                    // 分页结果
                    $("#total").text("一共" + json.total + "条记录");
                    $("#pageNum").text("第" + json.pageNum + "页");
                    $("#pages").css("display", "");
                    pages = json.pages;
                    $("#lastPage").addClass("disabled");
                    $("#nextPage").removeClass("disabled");
                    if(json.total <= pageSize){
                        $("#nextPage").addClass("disabled");
                    }
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
 * 上一页
 */
function lastPage() {
    if((parseInt(getPageNum()) - 1) < 1){
        return ;
    }
    var lastPageNum = parseInt(getPageNum()) - 1;
    $("#nextPage").removeClass("disabled");
    if(lastPageNum === 1){
        $("#lastPage").addClass("disabled");
    }
    $("#queryResult").empty();
    $.ajax({
        url:"queryLog.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"username":username,"time":time,"pageNum":lastPageNum,"pageSize":pageSize}),
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
                        addTd(trNode, list[i].username);
                        addTd(trNode, fmtDate(list[i].time));
                        addTd(trNode, list[i].message);
                        $("#queryResult").append(trNode);
                    }
                    // 分页结果
                    $("#pageNum").text("第" + json.pageNum + "页");
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
 * 下一页
 */
function nextPage() {
    if((parseInt(getPageNum()) + 1) > pages){
        return ;
    }
    var nextPageNum = parseInt(getPageNum()) + 1;
    $("#lastPage").removeClass("disabled");
    if(nextPageNum === pages){
        $("#nextPage").addClass("disabled");
    }
    $("#queryResult").empty();
    $.ajax({
        url:"queryLog.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"username":username,"time":time,"pageNum":nextPageNum,"pageSize":pageSize}),
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
                        addTd(trNode, list[i].username);
                        addTd(trNode, fmtDate(list[i].time));
                        addTd(trNode, list[i].message);
                        $("#queryResult").append(trNode);
                    }
                    // 分页结果
                    $("#pageNum").text("第" + json.pageNum + "页");
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
    var h = date.getHours();
    var min = date.getMinutes();
    var s = date.getSeconds();
    return y+"-"+m+"-"+d+" "+addZero(h)+":"+addZero(min)+":"+addZero(s);
}

/**
 * 得到当前页码
 */
function getPageNum() {
    return $("#pageNum").text().replace(/[^0-9]/ig,"");
}

/**
 * 自动补零至两位数
 */
function addZero(num) {
    if(num.toString().length === 1){
        return "0"+num.toString();
    }
    return num.toString();
}

/**
 * 生成td
 */
function addTd(trNode, result) {
    trNode.append("<td>" + result + "</td>");
}