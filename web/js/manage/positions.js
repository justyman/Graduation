var username;
var name;
var phone;
var position;
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
    position = $("#position").val();
    pageSize = $("#pageSize").val();

    $.ajax({
        url:"queryStaff.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"username":username,"phone":phone,"name":name,"position":position,"pageNum":1,"pageSize":pageSize}),
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
                        addTd(trNode, list[i].status);
                        addTd(trNode, "position" + list[i].position + list[i].username);
                        addTd(trNode, "options" + list[i].username);
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
        data:JSON.stringify({"username":username,"phone":phone,"name":name,"position":position,"pageNum":lastPageNum,"pageSize":pageSize}),
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
                        addTd(trNode, list[i].status);
                        addTd(trNode, "position" + list[i].position + list[i].username);
                        addTd(trNode, "options" + list[i].username);
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
        data:JSON.stringify({"username":username,"phone":phone,"name":name,"position":position,"pageNum":nextPageNum,"pageSize":pageSize}),
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
                        addTd(trNode, list[i].status);
                        addTd(trNode, "position" + list[i].position + list[i].username);
                        addTd(trNode, "options" + list[i].username);
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
 * 修改职位为管理员
 */
function manage(username) {
    if($("#" + username).text() === "管理员"){
        $("#select" + username).text("当前职位已是管理员").css("color", "red");
        return ;
    }
    $.ajax({
        url:"changePosition.do?username=" + username + "&position=0",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data.result === "200"){
                $("#select" + username).text("修改成功").css("color", "green");
                $("#" + username).text("管理员");
            }else if(data.result === "000"){
                $("#select" + username).text("修改异常，请查看日志详细信息").css("color", "red");
            }
        }
    });
}

/**
 * 修改职位为审批人员
 */
function approve(username) {
    if($("#" + username).text() === "审批人员"){
        $("#select" + username).text("当前职位已是审批人员").css("color", "red");
        return ;
    }
    $.ajax({
        url:"changePosition.do?username=" + username + "&position=2",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data.result === "200"){
                $("#select" + username).text("修改成功").css("color", "green");
                $("#" + username).text("审批人员");
            }else if(data.result === "000"){
                $("#select" + username).text("修改异常，请查看日志详细信息").css("color", "red");
            }
        }
    });
}

/**
 * 修改职位为业务人员
 */
function business(username) {
    if($("#" + username).text() === "业务人员"){
        $("#select" + username).text("当前职位已是业务人员").css("color", "red");
        return ;
    }
    $.ajax({
        url:"changePosition.do?username=" + username + "&position=1",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data.result === "200"){
                $("#select" + username).text("修改成功").css("color", "green");
                $("#" + username).text("业务人员");
            }else if(data.result === "000"){
                $("#select" + username).text("修改异常，请查看日志详细信息").css("color", "red");
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
    if(result.length > 7 && result.substring(0,7) === "options"){
        trNode.append("<td id='select"+result.substring(7, result.length)+"'><select>" +
            "                   <option value=''>请选择</option>" +
            "                   <option onclick='approve(\""+result.substring(7, result.length)+"\")'>审批人员</option>" +
            "                   <option onclick='business(\""+result.substring(7, result.length)+"\")'>业务人员</option>" +
            "                   <option onclick='manage(\""+result.substring(7, result.length)+"\")'>管理员</option>" +
            "              </select></td>");
    }else if(result.length > 8 && result.substring(0, 8) === "position" && result.charAt(8) === "0"){
        trNode.append("<td id='"+result.substring(9, result.length)+"'>管理员</td>");
    }else if(result.length > 8 && result.substring(0, 8) === "position" && result.charAt(8) === "1"){
        trNode.append("<td id='"+result.substring(9, result.length)+"'>业务人员</td>");
    }else if(result.length > 8 && result.substring(0, 8) === "position" && result.charAt(8) === "2"){
        trNode.append("<td id='"+result.substring(9, result.length)+"'>审批人员</td>");
    }else if(result === "Y"){
        trNode.append("<td>正常</td>");
    }else if(result === "N"){
        trNode.append("<td>冻结</td>");
    }else{
        trNode.append("<td>" + result + "</td>");
    }
}