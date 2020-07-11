function checkNullRegister() {
    var userId = document.getElementById("registUserId").value;
    var username = document.getElementById("registUserName").value;
    var password = document.getElementById("registPassword").value;
    var password2 = document.getElementById("registPassword2").value;
    if (userId == null || userId == '') {
        alert("新注册的id不能为空！");
        return false;
    } else if (username == null || username == '') {
        alert("新注册的用户名不能为空！");
        return false;
    }
    else if (password == null || password == '') {
        alert("新注册的密码不能为空！");
        return false;
    } else if (password != password2) {
        alert("两次密码不一致");
        return false;
    } else {
        return true;
    }
}

function checkNullLog() {
    var userId = document.getElementById("logUserId").value;
    var password = document.getElementById("logUserPassword").value;
    if (userId == null || userId == '') {
        alert("用户id不能为空！");
        return false;
    } else if (password == null || password == '') {
        alert("密码不能为空！");
        return false;
    } else {
        return true;
    }
}