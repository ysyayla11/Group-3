<%@ page import="bacit.web.bacit_web.models.HtmlModel" %><%--
  Created by IntelliJ IDEA.
  User: ysyay
  Date: 13.09.2021
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%=HtmlModel.getHeader("Din profil")%>
<br>



<div class="topnav">
    <a id="hjemme" href="home.jsp">Hjemme</a>
    <a id="Log" href="../index.jsp">Log inn</a>
    <a id="Profil" href="DinProfil.jsp">Din Profil</a>
    <a id="Bestilling" href="DineBestillinger.jsp">Dine Bestillinger</a>
</div>

<img src="../Images/img_5.png" alt="icon">

<ul class="ProfilID">
    <li> Navn: Anna Olsen  </li>
    <li> Rolle: Ansatt</li>
    <li> Mobilnummer: 96754322</li>
    <li> Address: Vestrestrandgate 42, 4612 Kristiansanf</li>
    <li> Mail: anne@mail.no</li>

</ul>

<button class="ProfilID"> Redifer Profil </button>

<%=HtmlModel.getFooter()%>

