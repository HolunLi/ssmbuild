<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" type="text/css" href="static/css/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="static/css/index.css"/>
    <script src="static/js/jquery-3.6.0.js" ></script>

    <script type="text/javascript">
        function fun() {
            $.post(
                "${pageContext.request.contextPath}/loginCheck",
                
                {
                    name:$("#user").val(),
                    pwd:$("#password").val()
                },

                function (data) {
                    if (data === "true")
                        document.getElementById("loginForm").submit();
                    else
                    {
                        $("#display").css("color", "red");
                        $("#display").html("账号或密码错误!");
                    }
                }
            )
        }
    </script>

</head>
<body>
    <div id="login-box">
        <h1>Login</h1>
        <form id="loginForm" action="${pageContext.request.contextPath}/toLoginPage" method="post" >
            <div class="input-box">
                <i class="iconfont">&#xe609;</i>

                <input type="text" id="user" name="username" placeholder="UserName" required />
            </div>
            <div class="input-box">
                <i class="iconfont">&#xe605;</i>
                <input type="password" id="password" placeholder="UserPassword" required />
            </div>
        </form>
        <button onclick="fun()" >Sign in</button><br><br>
        <span id="display"></span>
    </div>
</body>
</html>
