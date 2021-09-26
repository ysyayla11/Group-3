<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP</title>
    <link ${pageContext.request.contextPath} href="styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<br>
<%-- Menu Bar --%>
<div class="topnav">
    <ul>
   <li><a class="active" href="index.jsp">Hjemme</a></li>
        <li> <a href="Logg%20inn.jsp">Log inn</a></li>
        <li> <a href="DinProfil.jsp">Din Profil</a></li>
        <li><a href="DineBestillinger.jsp">Dine Bestillinger</a></li>
        </ul>
</div>
<br/>

<%-- Tool list --%>

    <ul class="tool">
            <li>
        <img src="Images/img_2.png" alt="icon" width="200" height="200" >
            <h3> Verktøy Sett </h3>
            <p> Pris første dag: Gratis</p>
            <p>Dagspris p&aring;f&oslash;lgende dag(er): 20kr</p>
            <p> Status: Ledig</p>
        <button type ="button" class="availability"> Sjekk ledige tider </button>
        </li>

        <li> <img src="Images/img_3.png" alt="icon" width="200" height="200" >
            <h3> Skrujern </h3>
            <p> Pris første dag: Gratis</p>
            <p>Dagspris p&aring;f&oslash;lgende dag(er): 20 kr</p>
            <p> Status: Opptatt, Første ledig fra: 28.09.2021</p>
        <button type ="button" class="availability"> Sjekk ledige tider </button>
        </li>

        <li> <img src="Images/img_4.png" alt="icon" width="200" height="200" >
            <h3> Tannbørste </h3>
            <p> Pris første dag: Gratis</p>
            <p>Dagspris p&aring;f&oslash;lgende dag(er): 20kr</p>
            <p> Status: Ledig</p>
        <button type ="button" class="availability"> Sjekk ledige tider </button>
        </li>
    </ul>


</body>
</html>