<%--
  Created by IntelliJ IDEA.
  User: Aleksander Wilberg
  Date: 21-Sep-21
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="ISO-8859-1" %>
<%@page import="java.sql.*, java.util.*"%>
<%@ page import="static jdk.vm.ci.hotspot.HotSpotCallingConventionType.VALUES" %> --%>




<html>
<head>
    <title>Admin</title>
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

    <br>
    <br>
    <br>
</div>
    <div class="adminButtons">
        <a href="Admin_userEntry.jsp"><img alt="addUser" src="Images/add%20user.png" />Legg til nye brukere</a>
        <a href="Admin_toolEntry.jsp"><img alt="addTool" src="Images/add%20tool.png" >Legg til nye verktøy</a>
        <br>
        <br>
        <br>
        <a href="GetAllUserServlet" methods="get"><img alt="editUser" src="Images/edit%20user.png"/>Oppdater brukere</a>
        <a href="Admin_toolUpdate.jsp"><img alt="editTool" src="Images/edit%20tool.png"/>Oppdater Verktøy</a>
    </div>
</div>
<br/>


</body>
</html>
