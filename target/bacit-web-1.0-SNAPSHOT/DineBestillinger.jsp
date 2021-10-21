<%--
  Created by IntelliJ IDEA.
  User: ysyay
  Date: 13.09.2021
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>JSP</title>
    <link href="styles.css" rel="stylesheet" type="text/css">
</head>

<body>
<form action="DeliverServlet" method="post">
    <br>


    <div class="topnav">
        <a id="hjemme" href="index.jsp">Hjemme</a>
        <a id="Log" href="Logg inn.jsp">Log inn</a>
        <a id="Profil" href="DinProfil.jsp">Din Profil</a>
        <a id="Bestilling" href="DineBestillinger.jsp">Dine Bestillinger</a>
    </div>

    <ul>
        <li>
            <img src="Images/img_2.png" alt="icon"  >
            <h3> Verktøy Sett </h3>
            <p>Leiedato: 22.09.2021</p>
            <p>Leveringsdato: 25.09.2021</p>
            <p> Kostnad: 40 kr</p>
        </li>
    </ul>

    <label>Tool id</label>
    <input type="text" name="Tool_id">
    <label>Varen Levert</label>
    <label>Ja</label>
    <input type="radio" name="Tool_delivered" value="true">
    <label>Nei</label>
    <input type="radio" name="Tool_delivered" value="false">

    <input type="submit" value="Lever Varen">
</form>

</body>

</html>
