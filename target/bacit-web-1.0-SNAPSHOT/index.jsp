<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>JSP</title>
    <link href="styles.css" rel="stylesheet" type="text/css">

</head>

<body>
<br>




<div class="topnav">
    <a id="hjemme" href="index.jsp">Hjemme</a>
    <a id="Log" href="Logg inn.jsp">Log inn</a>
    <a id="Profil" href="DinProfil.jsp">Din Profil</a>
    <a id="Bestilling" href="DineBestillinger.jsp">Dine Bestillinger</a>
</div>


    <!--<table border="2">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Condition</td>
            <td>Price</td>
            <td>Free first day</td>
            <td>importantInformation</td>
            <td>image</td>
        </tr>-->
            <%--
    <%
                try
                {
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3308/MyTestDB";
                String username="root";
                String password="12345";
                String query="select * from tools";
                Connection conn=DriverManager.getConnection(url,username,password);
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(query);
                while(rs.next())
                {
            %>
        <tr>
            <td><%=rs.getInt("Tool_name") %></td>
            <td><%=rs.getString("Tool_type") %></td>
            <td><%=rs.getString("Tool_condition") %></td>
            <td><%=rs.getString("Tool_price") %></td>
            <td><%=rs.getString("Tool_freeFirstDay") %></td>
            <td><%=rs.getString("Tool_importantInformation") %></td>
            <td><%=rs.getString("Tool_image") %></td>
        </tr>
        <%
        }
                %>
    </table>
        <%
            rs.close();
            stmt.close();
            conn.close();
            }
        catch(Exception e)
        {
            e.printStackTrace();
            }
        %>
</form>
--%>

<a href="AdministerToolServlet">Verktøy</a>


<ul class="tool">
    <li>
        <img src="Images/img_2.png" alt="icon"  >
        <h3> Verktøy Sett </h3>
        <p> Pris første dag: Gratis</p>
        <p>Dagspris p&aring;f&oslash;lgende dag(er): 20kr</p>
        <p> Status: Ledig</p>
        <button type ="button" class="availability"> Sjekk ledige tider </button>
    </li>


    <li> <img src="Images/img_3.png" alt="icon" >
        <h3> Skrujern </h3>
        <p> Pris første dag: Gratis</p>
        <p>Dagspris p&aring;f&oslash;lgende dag(er): 20 kr</p>
        <p> Status: Opptatt, Første ledig fra: 28.09.2021</p>
        <button type ="button" class="availability"> Sjekk ledige tider </button>
    </li>


    <li> <img src="Images/img_4.png" alt="icon"  >
        <h3> Tannbørste </h3>
        <p> Pris første dag: Gratis</p>
        <p>Dagspris p&aring;f&oslash;lgende dag(er): 20kr</p>
        <p> Status: Ledig</p>
        <button type ="button" class="availability"> Sjekk ledige tider </button>
    </li>

</ul>

<form action="/GetToolServlet" method="get">Get Tools</form>

<a href="Admin_dashboard.jsp">Admin</a>

</body>
</html>
