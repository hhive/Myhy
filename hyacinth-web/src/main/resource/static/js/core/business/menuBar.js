/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

var menuBar = function () {
    var links = {
        // '#indexManagementMenu': '/index',
        // '#advertisementManagementMenu': '/views/profit/profitShow',
        '#staffManagementMenu': '/staff/list ',
        '#changePasswordMenu': '/views/changePassword'
    };
    return {
        init: function (parentId, id) {
            $(".collapse").collapse();
            for (var key in links) {
                $(key).on('click', function (key) {
                    window.location.href = links["#" + key.currentTarget.id]
                });
                $(key + " a").attr('href', links[key]);
            }
            $(parentId + " a").css('font-weight', 'bold');
            $(parentId + " a").css('color', '#222222');
            $(parentId).css('background-color', '#ffc814');
            if (id) {
                $(id + " a").css('font-weight', 'bold');
                $(id + " a").css('color', '#222222');
            }

            //var username = "<%=Session("username").ToString()%>";
        }
    }
};
function importCsv(){
    var formData = new FormData();
    var name = $("#upfile").val();
    formData.append("file",$("#upfile")[0].files[0]);
    formData.append("name",name);
    $.ajax({
        url :"/index",
        type : 'GET',
        async : false ,
        data : "json",
        processData : false,
        beforeSend:function () {
            console.log("正在进行，亲稍等");
        }

    });
}
function Search(){
    var imformation = $("#message").val();
    window.location.href="/staff/search1?message="+imformation;
}
function changeEmail(){
    var doc = document;
    var Back = doc.getElementById('black'),
        DialogBox = doc.getElementById('dialogBox'),
        DialogClose = DialogBox.getElementsByClassName('dialog_close')[0];
    //显示遮罩层
    Back.style.display = 'block';
    //显示弹出窗口
    DialogBox.style.display = 'block';
    DialogClose.onclick = function () {
        //隐藏遮罩层
        Back.style.display = 'none';
        //显示弹出窗口
        DialogBox.style.display = 'none';
    }
    Back.onclick = function () {
        //隐藏遮罩层
        Back.style.display = 'none';
        //显示弹出窗口
        DialogBox.style.display = 'none';
    }
}
function changeEmail(){
    var doc = document;
    var Back = doc.getElementById('black'),
        DialogBox = doc.getElementById('dialogBox'),
        DialogClose = DialogBox.getElementsByClassName('dialog_close')[0];
    //显示遮罩层
    Back.style.display = 'block';
    //显示弹出窗口
    DialogBox.style.display = 'block';
    DialogClose.onclick = function () {
        //隐藏遮罩层
        Back.style.display = 'none';
        //显示弹出窗口
        DialogBox.style.display = 'none';
    }
    Back.onclick = function () {
        //隐藏遮罩层
        Back.style.display = 'none';
        //显示弹出窗口
        DialogBox.style.display = 'none';
    }
}


