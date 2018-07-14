function showErrorMsg(msg) {
    console.log(msg)
}
function tset() {
    var username = $("#username").val();
    var password = $("#password").val();
    if(username == null ){
        alert ("用户名不能为空");
    }else if(password == null){
        alert("密码为空");
    } else {
        $.ajax({
            url:"/login",
            data:
                {name:name,password:password},
            type:"post",
            success:function(msg){
                console.log(msg);
                //100表示成功
                if (msg.code == 100) {
                    //跳到发表文章页面:因为路线二，所以把这个注释先
                    //window.location.href = "article/publish.html?";

                    //跳到显示全部文章页面
                    //window.location.href = "article/showAllArticle.html?";

                    //跳转到创建文件夹及显示全部文件夹功能页面
                    window.location.href = "index";

                    //后台获取要加一杠/showAllArticle
                    //window.location.href = "showAllArticle";
                } else {
                    $('#prompt').text(msg.map.errMsg);
                }
            },
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }

        });
    }
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

}
