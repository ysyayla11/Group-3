<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="bacit.web.bacit_web.models.HtmlModel" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%= HtmlModel.getHeader("Hjemmeside")%>


<form method="get" action="DisplayToolsServlet">
    <button type="submit">Check all tools</button>
</form>


<a href="../SiteAdmin/Admin_dashboard.jsp">Admin</a>
<a href="../getAllToolServlet">get all tools</a>








</script>



</body>
</html>
