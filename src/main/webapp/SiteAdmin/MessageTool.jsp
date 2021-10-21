<%--
  Created by IntelliJ IDEA.
  User: Aleksander Wilberg
  Date: 25-Sep-21
  Time: 01:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Message for tool</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>



<center>
    <h3><%=request.getAttribute("MessageTool")%></h3>
</center>
<br>
<center>
    <div class="topnav">
        <a href="../SiteUser/home.jsp">Hjem</a>
        <a href="Admin_toolEntry.jsp">Legg til et nytt verktøy</a>
    </div>
</center>
</body>
</html>