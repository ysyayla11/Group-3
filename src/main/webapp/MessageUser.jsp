<%--
  Created by IntelliJ IDEA.
  User: Aleksander Wilberg
  Date: 27-Sep-21
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Message for User</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>



<center>
  <h3><%=request.getAttribute("MessageUser")%></h3>
</center>
<br>
<center>
  <div class="topnav">
    <a href="index.jsp">Hjem</a>
    <a href="Admin_userEntry.jsp">Legg til en ny bruker</a>
  </div>
</center>
</body>
</html>