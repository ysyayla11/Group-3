<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="bacit.web.bacit_web.models.HtmlModel" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<%= HtmlModel.getHeader("Hjem")%>


<br>
<br>
<br>

<a href="GetAllToolServlet" methods="get"><img alt="editTool" src="../Images/edit%20tool.png"/>Oppdater Verktøy</a>

<a href="../SiteAdmin/Admin_dashboard.jsp">Admin</a>

<%= HtmlModel.getFooter()%>
