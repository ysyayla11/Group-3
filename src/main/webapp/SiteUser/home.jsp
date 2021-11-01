<%@ page import="bacit.web.bacit_web.models.HtmlModel" %>
<%@ page import="bacit.web.bacit_web.servlets.tools.GetAllToolServlet" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%= HtmlModel.getHeader("Hjemmeside")%>



        <form action="GetAllToolServlet" method="get" enctype="multipart/form-data">Get Tools</form>
            <div class="container" id="verktøy_hjem"></div>

            <a href="../SiteAdmin/Admin_dashboard.jsp">Admin</a>


<form><%=request.getAttribute("ToolsHome")%></form>

    </body>
</html>
