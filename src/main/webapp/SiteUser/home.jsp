<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="bacit.web.bacit_web.models.HtmlModel" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%= HtmlModel.getHeader("hjemside")%>

<form action="GetAllToolServlet" method="get">Get Tools
    <button type="submit"> Hent Verktøy </button>
</form>

<a href="../SiteAdmin/Admin_dashboard.jsp">Admin</a>
<a href="../getAllToolServlet">get all tools</a>

<h2>My Phonebook</h2>







</script>



</body>
</html>
