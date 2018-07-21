function showErrorMsg(msg) {
    console.log(msg)
}
function login(){
    var username = $("#username").val();
    var password = $("#password").val();

    $.ajax({
       type : "POST",
        url : "/login",
        data :{"Username": username,"Password": password},
        async: false,
        success : function (data) {
    if(data.loginName != null)
            window.location.href="http://localhost:8888/success";
    else  alert("用户名或密码错误");

        },
        error : function () {
            alert("用户名或密码错误");
        }
    });
}
