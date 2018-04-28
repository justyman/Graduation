var card = "";
var id = "";
var name = "";
var pageSize;
var pages;

$(document).ready(function () {
    pageSize = 10;
    $.ajax({
        url:"queryCustomer.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"card":card,"id":id,"name":name,"pageNum":1,"pageSize":pageSize}),
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
                        addTd(trNode, list[i].name);
                        addTd(trNode, list[i].sex);
                        addTd(trNode, list[i].phone);
                        addTd(trNode, list[i].id);
                        addTd(trNode, list[i].level);
                        addTd(trNode, list[i].credit);
                        addTd(trNode, "credit" + list[i].id);
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
});

/**
 * 查询
 */
function query() {
    $("#tips").css("display", "none");
    $("#pages").css("display", "none");
    $("#queryTable").css("display", "none");
    $("#queryResult").empty();

    card = $("#card").val();
    if(card !== "" && !validateCard(card)){
        $("#tips").text("您输入的卡号格式不正确");
        $("#tips").css("display", "");
        return ;
    }

    id = $("#idCard").val();
    channel = $("#channel").val();
    deadline = $("#deadline").val();
    pageSize = $("#pageSize").val();

    $.ajax({
        url:"queryCustomer.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"card":card,"id":id,"name":name,"pageNum":1,"pageSize":pageSize}),
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
                        addTd(trNode, list[i].name);
                        addTd(trNode, list[i].sex);
                        addTd(trNode, list[i].phone);
                        addTd(trNode, list[i].id);
                        addTd(trNode, list[i].level);
                        addTd(trNode, list[i].credit);
                        addTd(trNode, "credit" + list[i].id);
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
        url:"queryCustomer.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"card":card,"id":id,"name":name,"pageNum":lastPageNum,"pageSize":pageSize}),
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
                        addTd(trNode, list[i].name);
                        addTd(trNode, list[i].sex);
                        addTd(trNode, list[i].phone);
                        addTd(trNode, list[i].id);
                        addTd(trNode, list[i].level);
                        addTd(trNode, list[i].credit);
                        addTd(trNode, "credit" + list[i].id);
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
        url:"queryCustomer.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"card":card,"id":id,"name":name,"pageNum":nextPageNum,"pageSize":pageSize}),
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
                        addTd(trNode, list[i].name);
                        addTd(trNode, list[i].sex);
                        addTd(trNode, list[i].phone);
                        addTd(trNode, list[i].id);
                        addTd(trNode, list[i].level);
                        addTd(trNode, list[i].credit);
                        addTd(trNode, "credit" + list[i].id);
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
 * 得到当前页码
 */
function getPageNum() {
    return $("#pageNum").text().replace(/[^0-9]/ig,"");
}

/**
 * 生成td
 */
function addTd(trNode, result) {
    if(result === undefined){
        result = "";
    }
    if(result.length === 16 && result.substring(0,4) === "6258"){
        trNode.append("<td><a href='approveQueryDetail.do?card=" + result + "' target='_blank'>" + result + "</a></td>");
    }else if(result.length > 6 && result.substring(0,6) === "credit"){
        var content = "<td id='select\"+result.substring(6, result.length)+\"'><select><option value=''>请选择</option>";
        for(var i = 1; i < 101; i++){
            content = content + "<option onclick='approve(\""+result.substring(6, result.length)+"-"+i+"\")'>i</option>";
        }
            "                   <option onclick='approve(\""+result.substring(6, result.length)+"\")'>审批人员</option>" +
            "                   <option onclick='business(\""+result.substring(6, result.length)+"\")'>业务人员</option>" +
            "                   <option onclick='manage(\""+result.substring(6, result.length)+"\")'>管理员</option>" +
            "              </select></td>");
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