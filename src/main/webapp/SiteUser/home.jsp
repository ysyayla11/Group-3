<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="bacit.web.bacit_web.models.HtmlModel" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%= HtmlModel.getHeader("hjemside")%>

<ul class="tool">
    <li>
        <img src="../Images/img_2.png" alt="icon"  >
        <h3> Verktøy Sett </h3>
        <p> Pris første dag: Gratis</p>
        <p>Dagspris p&aring;f&oslash;lgende dag(er): 20kr</p>
        <p> Status: Ledig</p>
       <a href="Booking.jsp"> <button type ="button" class="availability"> Sjekk ledige tider </button></a>
    </li>

    <li> <img src="../Images/img_3.png" alt="icon" >
        <h3> Skrujern </h3>
        <p> Pris første dag: Gratis</p>
        <p>Dagspris p&aring;f&oslash;lgende dag(er): 20 kr</p>
        <p> Status: Opptatt, Første ledig fra: 28.09.2021</p>
        <a href="Booking.jsp"> <button type ="button" class="availability"> Sjekk ledige tider </button></a>
    </li>

    <li> <img src="../Images/img_4.png" alt="icon"  >
        <h3> Tannbørste </h3>
        <p> Pris første dag: Gratis</p>
        <p>Dagspris p&aring;f&oslash;lgende dag(er): 20kr</p>
        <p> Status: Ledig</p>
        <a href="Booking.jsp"> <button type ="button" class="availability"> Sjekk ledige tider </button> </a>
    </li>

</ul>

<form action="GetAllToolServlet" method="get">Get Tools
    <button type="submit"> Hent Verktøy </button>
</form>

<a href="../SiteAdmin/Admin_dashboard.jsp">Admin</a>

<form action="eksempelServlet" method="get">
    <button type="submit">Gå til eksempelServlet</button>
</form>

</body>
</html>
