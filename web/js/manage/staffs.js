var username;
var name;
var phone;
var status;
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
    name = $("#name").val();
    phone = $("#phone").val();
    status = $("#status").val();
    pageSize = $("#pageSize").val();

    $.ajax({
        url:"queryStaff.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"username":username,"phone":phone,"name":name,"status":status,"pageNum":1,"pageSize":pageSize}),
        success:function (data) {
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
                        addTd(trNode, list[i].password);
                        addTd(trNode, list[i].name);
                        addTd(trNode, list[i].sex);
                        addTd(trNode, list[i].phone);
                        addTd(trNode, fmtDate(list[i].entry));
                        addTd(trNode, list[i].position);
                        addTd(trNode, list[i].status + list[i].username);
                        addTd(trNode, "option" + list[i].status + list[i].username);
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
        url:"queryStaff.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"username":username,"phone":phone,"name":name,"status":status,"pageNum":lastPageNum,"pageSize":pageSize}),
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
                        addTd(trNode, list[i].password);
                        addTd(trNode, list[i].name);
                        addTd(trNode, list[i].sex);
                        addTd(trNode, list[i].phone);
                        addTd(trNode, fmtDate(list[i].entry));
                        addTd(trNode, list[i].position);
                        addTd(trNode, list[i].status + list[i].username);
                        addTd(trNode, "option" + list[i].status + list[i].username);
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
        url:"queryStaff.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"username":username,"phone":phone,"name":name,"status":status,"pageNum":nextPageNum,"pageSize":pageSize}),
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
                        addTd(trNode, list[i].password);
                        addTd(trNode, list[i].name);
                        addTd(trNode, list[i].sex);
                        addTd(trNode, list[i].phone);
                        addTd(trNode, fmtDate(list[i].entry));
                        addTd(trNode, list[i].position);
                        addTd(trNode, list[i].status + list[i].username);
                        addTd(trNode, "option" + list[i].status + list[i].username);
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
 * 冻结用户
 */
function freeze(username) {
    $.ajax({
        url:"freezeStaff.do?username=" + username,
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data.result === "200"){
                $("#btn" + username).text("冻结成功").css("color", "green");
                $("#" + username).text("冻结");
            }else if(data.result === "000"){
                $("#btn" + username).text("冻结异常，请查看日志详细信息").css("color", "red");
            }
        }
    });
}

/**
 * 解冻用户
 */
function normal(username) {
    $.ajax({
        url:"normalStaff.do?username=" + username,
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data.result === "200"){
                $("#btn" + username).text("解冻成功").css("color", "green");
                $("#" + username).text("正常");
            }else if(data.result === "000"){
                $("#btn" + username).text("解冻异常，请查看日志详细信息").css("color", "red");
            }
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
    if(result.length >= 7 && result.substring(0, 6) === "option"){
        if(result.charAt(6) === "Y"){
            trNode.append("<td id='btn"+result.substring(7, result.length)+"'><button type='button' class='btn btn-primary' style='padding-top: 0' onclick='freeze(\""+result.substring(7, result.length)+"\")'>冻结</button></td>");
        }else{
            trNode.append("<td id='btn"+result.substring(7, result.length)+"'><button type='button' class='btn btn-primary' style='padding-top: 0' onclick='normal(\""+result.substring(7, result.length)+"\")'>解冻</button></td>");
        }
    }else if(result === 0){
        trNode.append("<td>管理员</td>");
    }else if(result === 1){
        trNode.append("<td>业务人员</td>");
    }else if(result === 2){
        trNode.append("<td>审批人员</td>");
    }else if(result.charAt(0) === "Y"){
        trNode.append("<td id='"+result.substring(1, result.length)+"'>正常</td>");
    }else if(result.charAt(0) === "N"){
        trNode.append("<td id='"+result.substring(1, result.length)+"'>冻结</td>");
    }else{
        trNode.append("<td>" + result + "</td>");
    }
}
