<%--
  Created by IntelliJ IDEA.
  User: Aleksander Wilberg
  Date: 21-Sep-21
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="ISO-8859-1" %>
<%@page import="java.sql.*, java.util.*"%>
<%@ page import="static jdk.vm.ci.hotspot.HotSpotCallingConventionType.VALUES" %>

<%
    String User_firstName=request.getParameter("User_firstName");
    String User_lastName=request.getParameter("User_lastName");
    String User_email=request.getParameter("User_email");
    String User_phoneNumber=request.getParameter("User_phoneNumber");
    String User_address=request.getParameter("User_address");
    String User_access=request.getParameter("User_access");
    String User_qualification=request.getParameter("User_qualification");
    String User_union=request.getParameter("User_union");
    String User_password=request.getParameter("User_password");

    String connectionURL = "jdbc:mariadb://localhost:3308";
    Connection conn = null;
    PreparedStatement preparedStatement = null;





%>


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
    <a href="https://www.amv-as.no/">Kontakt</a>
    <a href="Admin_userEntry.jsp">Admin</a>

</div>
<br/>

<form class="post">
    <%-- Enter user --%>
    <div class="container">
        <label><b>First name</b></label> <br>
        <input type="text" placeholder="Enter First name" name="User_firstName" required> <br>

        <label><b>Last name</b></label> <br>
        <input type="text" placeholder="Enter Last name" name="User_lastName" required> <br>

        <label><b>Email</b></label> <br>
        <input type="text" placeholder="Enter Email" name="User_email" required> <br>

        <label><b>Phone Number</b></label> <br>
        <input type="text" placeholder="Enter phone number" name="User_phoneNumber" required> <br>

        <label><b>Date of Birth</b></label> <br>
        <input type="text" placeholder="Enter Date of Birth" name="User_dob" required> <br>

        <label><b>Address</b></label> <br>
        <input type="text" placeholder="Enter Address" name="User_address" required> <br>

        <label><b>Is the user an admin?</b></label> <br>
        <input type="checkbox" name="User_access" required> <br>

        <label><b>Is the user qualified to operate all tools?</b></label> <br>
        <input type="checkbox" name="User_qualification" required> <br>

        <label><b>Are the user an unionworker?</b></label> <br>
        <input type="checkbox" name="User_union" required> <br>

        <label><b>Password</b></label> <br>
        <input type="password" placeholder="Enter Password" name="User_password" required> <br>

        <button type="submit">Login</button> <br>

    </div>
</form>

</body>
</html>
