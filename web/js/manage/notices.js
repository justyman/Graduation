/**
 * 页面初始加载表格
 */
$(document).ready(function () {
    $.ajax({
        url:"queryNotice.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data.result === "200"){
                if(data.message === "null"){
                    var trNode = $("<tr/>");
                    addTd(trNode, "");
                    addTd(trNode, "<button type='button' class='btn btn-success' style='padding-top: 0' data-toggle='modal' data-target='#myModal'>添加</button>");
                    $("#queryResult").append(trNode);
                }else {
                    var list = eval(data.message);
                    // 查询结果
                    for (var i = 0; i < list.length + 1; i++) {
                        var trNode1 = $("<tr/>");
                        if(i === list.length){
                            addTd(trNode1, "");
                            addTd(trNode1, "<button type='button' class='btn btn-success' style='padding-top: 0' data-toggle='modal' data-target='#myModal'>添加</button>");
                            addTd(trNode1, "");
                            $("#queryResult").append(trNode1);
                        }else{
                            addTd(trNode1, list[i].type);
                            addTd(trNode1, list[i].content);
                            addTd(trNode1, "<button type='button' class='btn btn-danger' style='padding-top: 0' onclick='delNotice(\""+list[i].id+"\")'>删除</button>");
                            $("#queryResult").append(trNode1);
                        }
                    }
                }
                $("#queryTable").css("display", "");
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
 * 增加公告信息
 */
function addNotice() {
    var type = $("#type").val();
    var content = $("#content").val();
    $.ajax({
        url:"addNotice.do",
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"type":type,"content":content}),
        success:function (data) {
            if(data.result === "200"){
                document.location.reload();
            }else {
                alert("数据库异常，请查看详细日志信息");
            }
        }
    });
}

/**
 * 删除公告信息
 */
function delNotice(id) {
    $.ajax({
        url:"delNotice.do?id=" + id,
        type:"post",
        async:true,
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data.result === "200"){
                document.location.reload();
            }else {
                alert("数据库异常，请查看详细日志信息");
            }
        }
    });
}

/**
 * 生成td
 */
function addTd(trNode, result) {
    trNode.append("<td>" + result + "</td>");
}