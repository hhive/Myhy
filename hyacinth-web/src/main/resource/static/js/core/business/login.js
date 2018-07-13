function showErrorMsg(msg) {
    console.log(msg)
}
function login(){
    var username = $("#username").val();
    var password = $("#password").val();
    if(username == null ){
        alert ("用户名不能为空");
    }
    if(password == null){
        alert("密码为空");
    }
    $.ajax({
       type : "get",
        url : "/send",
        data :{"username": username},
        dataType:"text",
        async: false,
        success : function () {
        },
        error : function () {
        }
    });
}
