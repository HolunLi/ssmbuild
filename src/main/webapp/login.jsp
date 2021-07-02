<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" type="text/css" href="static/css/index.css" >
    <link rel="stylesheet" type="text/css" href="static/css/iconfont.css" >
    <script src="static/js/jquery-3.6.0.js" ></script>

    <script type="text/javascript">
        function fun() {
            $.post(
                "${pageContext.request.contextPath}/user/loginCheck",
                
                {
                    name:$("#user").val(),
                    pwd:$("#password").val()
                },

                function (data) {
                    if (data === "A") {
                        $("#display").css("color", "red");
                        $("#display").html("请输入用户名和密码!");
                        return;
                    }
                    else if (data === "B")
                    {
                        $("#display").css("color", "red");
                        $("#display").html("用户名为空!");
                        return;
                    }
                    else if (data === "C")
                    {
                        $("#display").css("color", "red");
                        $("#display").html("密码为空!");
                        return;
                    }

                    if (data === "a")
                        window.location.href = "${pageContext.request.contextPath}/book/allBooks";
                    else if (data === "b") {
                        $("#display").css("color", "red");
                        $("#display").html("用户名或密码错误!");
                    }
                    else if (data === "c") {
                        $("#display").css("color", "red");
                        $("#display").html("用户名有误!");
                    }
                    else {
                        $("#display").css("color", "red");
                        $("#display").html("密码有误!");
                    }

                }
            )
        }
    </script>

</head>
<body>
    <div id="login-box">
        <h1>Login</h1>
            <div class="input-box">
                <i class="iconfont">&#xe609;</i>

                <input type="text" id="user" name="username" placeholder="UserName"  />
            </div>
            <div class="input-box">
                <i class="iconfont">&#xe605;</i>
                <input type="password" id="password" placeholder="UserPassword"  />
            </div>
            <button onclick="fun()" >Sign in</button><br><br>
            <span id="display"></span>
    </div>
</body>
</html>
