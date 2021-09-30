<%--
  Created by IntelliJ IDEA.
  User: jense
  Date: 30.09.2021
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rediger brukerinformasjon</title>
<link href="styles.css" rel="stylesheet" type="text/css">

</head>
<body>


<div class="topnav">
    <a class="active" href="index.jsp">Hjemme</a>
    <a href="Logg%20inn.jsp">Log inn</a>
    <a href="DinProfil.jsp">Din Profil</a>
    <a href="DineBestillinger.jsp">Dine Bestillinger</a>
</div>

<form action="EditUserInfoServlet" method="get">
    <label> Fullt navn </label>
    <input type="text" name = "fullName">

    <br>
    <label> E-mail </label>
    <input type="text" name = "email">

    <br>
    <label> Telefonnummer </label>
    <input type="text" name = "phoneNumber">

    <br>
    <label> Addresse </label>
    <input type="text" name = "address">

    <br>
    <Label> Tilgang </Label>
    <input type="text" name = "access">

    <br>
    <label> Fagforening </label>
    <input type="radio" id="buttonYes" name="union" value="true">
    <label for="buttonYes">Ja</label>
    <input type="radio" id="buttonNo" name="union" value="false">
    <label for="buttonNo">Nei</label>

    <br>
    <label> Gjeld </label>
    <input type="text" name = "debt">

    <br>
    <label> Passord </label>
    <input type="text" name = "password">

    <br>
    <button type="submit"> Endre </button>


</form>

</body>
</html>
