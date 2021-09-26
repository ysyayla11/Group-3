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



<a href="Admin_dashboard.jsp">Admin</a>

</body>
</html>