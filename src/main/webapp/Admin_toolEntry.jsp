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
    <title>ToolEntry</title>
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

<form method="post" action="uploadServlet" enctype="multipart/form-data">
    <%-- Enter user --%>
    <div class="container">
        <label><b>Tool name</b></label> <br>
        <input type="text" placeholder="Enter Tool Name" name="Tool_name" required> <br>

        <label><b>Tool type</b></label> <br>
        <input type="text" placeholder="Enter Tool Type" name="Tool_type" required> <br>

        <label><b>Tool condition</b></label> <br>
        <input type="text" placeholder="Enter tool condition" name="Tool_condition" required> <br>

        <label><b>Price</b></label> <br>
        <input type="text" placeholder="Enter rental price" name="Tool_price" required> <br>

        <label><b>Is the tool free the first day?</b></label><input type="checkbox" name="Tool_freeFirstDay" >
        <br>
        <br>
        <label><b>Important information about the tool</b></label> <br>
        <input type="text" placeholder="Enter Important Information" name="Tool_importantInformation" required> <br>

        <label><b>Picture of the tool (JPG/PNG only)</b></label> <br>
        <input type="file" name="Tool_image" required> <br>

        <label><b>What is the maximum amount of days this tool can be rented?</b></label> <br>
        <input type="text" placeholder="Enter maximum rental days" name="Tool_maxDays" > <br>

        <button type="submit">Lagre verktøy</button> <br>

    </div>
</form>

</body>
</html>

<web-app>
    <context-param>

    </context-param>
</web-app>