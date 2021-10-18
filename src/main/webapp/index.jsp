<%@ page import="bacit.web.bacit_web.models.HtmlModel" %><%--
  Created by IntelliJ IDEA.
  User: ysyay
  Date: 13.09.2021
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>logg inn</title>
    <meta charset="UTF-8">

</head>
<body>

<img src="Images/img.png" alt="Avatar" class="avatar">


<form class="post">

    <div class="container">
        <label><b>Username</b></label> <br>
        <input type="text" placeholder="Enter Username" name="uname" required> <br>

        <label><b>Password</b></label> <br>
        <input type="password" placeholder="Enter Password" name="psw" required> <br>

        <button type="submit">Login</button> <br>

        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label> <br>
    </div>
    <a href="SiteUser/home.jsp">gå til tools</a>


    <div class="container" style="background-color:#f1f1f1">

        <span  class="psw"> Forgot <a href="#">password?</a></span> <br>
    </div>
</form>

</body>
</html>

