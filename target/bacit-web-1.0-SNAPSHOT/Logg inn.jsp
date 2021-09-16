<%--
  Created by IntelliJ IDEA.
  User: ysyay
  Date: 13.09.2021
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log inn</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<br>
<%-- Menu Bar --%>
<div class="topnav">
    <a class="active" href="index.jsp">Hjemme</a>
    <a href="Logg%20inn.jsp">Log inn</a>
    <a href="DinProfil.jsp">Din Profil</a>
    <a href="DineBestillinger.jsp">Dine Bestillinger</a>
    <a href="https://www.amv-as.no/">Kontakt</a>

</div>
<br/>

<%-- Amv Picture --%>
<div class="imgcontainer">
    <img src="img.png" alt="Avatar" class="avatar" width="350" height="350">
</div>

<form class="post">
    <%-- Login --%>
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

    <%-- Forget password --%>
    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button> <br>
        <span class="psw">Forgot <a href="#">password?</a></span> <br>
    </div>
</form>

</body>
</html>
