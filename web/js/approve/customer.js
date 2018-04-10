/**
 * 查询
 */
function query() {
    $("#tips").css("display", "none");

    var card = $("#card").val();
    if(!validateCard(card)){
        $("#tips").text("您输入的卡号格式不正确");
        $("#tips").css("display", "");
        return ;
    }

    var id = $("#idCard").val();
    if(!validateIdCard(id)){
        $("#tips").text("您输入的身份证格式不正确");
        $("#tips").css("display", "");
        return ;
    }

    var channel = $("#channel").val();
    var status = $("#status").val();
    var deadline = $("#deadline").val();

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
 * 身份证格式校验
 */
function validateIdCard(idCard) {
    if(idCard.length !== 18){
        return false;
    }
    return validateNum(idCard);
}

/**
 * 纯数字校验
 */
function validateNum(str) {
    return !isNaN(str);
}