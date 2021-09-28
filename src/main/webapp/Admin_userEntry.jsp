<%--
  Created by IntelliJ IDEA.
  User: Aleksander Wilberg
  Date: 21-Sep-21
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<html>
<head>
    <title>UserEntry</title>
    <link rel="stylesheet" href="styles.css">
    <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<br>
<%-- Menu Bar --%>
<div class="topnav">
    <a href="Admin_dashboard.jsp">Admin</a>
</div>
<br/>

<form method="post" action="uploadServletUser" enctype="multipart/form-data">
    <%-- Enter user --%>
    <div class="container">
        <label><b>Full name</b></label> <br>
        <input type="text" placeholder="Enter Full Name" name="User_fullName" required> <br>

        <label><b>Phone Number</b></label> <br>
        <input type="text" placeholder="Enter phone number" name="User_phoneNumber" required> <br>

        <label><b>Email</b></label> <br>
        <input type="text" placeholder="Enter Email" name="User_email" required> <br>

        <label><b>Address</b></label> <br>
        <input type="text" placeholder="Enter Address" name="User_address" required> <br>

        <label><b>Is the user an admin?</b></label> <br>
        <input type="checkbox" name="User_access" > <br>

        <label><b>Is the user qualified to operate all tools?</b></label> <br>
        <input type="checkbox" name="User_qualification" > <br>

        <label><b>Are the user an unionworker?</b></label> <br>
        <input type="checkbox" name="User_union" > <br>

        <label><b>Do the user have any outstanding/old debt?</b></label> <br>
        <input type="text" placeholder="Enter Debt" name="User_debt" > <br>

        <label><b>Password</b></label> <br>
        <input type="text" placeholder="Enter Password" name="User_password" required> <br>

        <button type="submit">Lagre bruker</button> <br>

    </div>
</form>

</body>
</html>

<web-app>
    <context-param>

    </context-param>
</web-app>
