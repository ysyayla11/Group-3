<%@ page import="bacit.web.bacit_web.models.HtmlModel" %><%--
  Created by IntelliJ IDEA.
  User: Aleksander Wilberg
  Date: 27-Sep-21
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%=HtmlModel.getHeader("Message user")%>

  <h3><%=request.getAttribute("MessageUser")%></h3>

<br>

  <div class="topnav">
    <a href="../SiteUser/home.jsp">Hjem</a>
    <a href="Admin_userEntry.jsp">Legg til en ny bruker</a>
  </div>

<%=HtmlModel.getFooter()%>