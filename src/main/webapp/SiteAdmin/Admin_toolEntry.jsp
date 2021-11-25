<%@ page import="bacit.web.bacit_web.models.HtmlModel" %><%--
  Created by IntelliJ IDEA.
  User: Aleksander Wilberg
  Date: 21-Sep-21
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%= HtmlModel.getHeader("tool Entry")%>
<br>

<h1>Legg til nytt verktøy</h1>



<form method="post" action="../SiteAdmin/toolUploadServlet" id="toolForm">
    <%-- Enter user --%>
    <%-- Endring --%>
    <div class="container">
        <label><b>Navn på verktøy</b></label> <br>
        <input type="text" placeholder="Skriv her..." name="Tool_name" required> <br>

        <select name="Tool_type">
            <option disabled selected>Velg Type</option>
            <option value="1">Diverse småutstyr</option>
            <option value="2">Spikerpistoler o.l.</option>
            <option value="3">Utstyr for vedhogst</option>
            <option value="4">Tilhengere</option>
            <option value="5">Større Utstyr</option>
        </select> <br>

        <label><b>Tilstand</b></label> <br>
        <input type="text" placeholder="Skriv her..." name="Tool_condition" required> <br>

        <label><b>Pris per dag</b></label> <br>
        <input type="number" placeholder="Skriv her..." name="Tool_price" required> <br><br>

        <label><b>Kryss av om verktøyet er gratis første dag</b></label>
        <input type="checkbox" value="on" name="Tool_freeFirstDay">
        <input type="hidden" value="off" name="Tool_freeFirstDay">
        <br>
        <br>
        <label><b>Viktig informasjon om verktøyet</b></label> <br>
        <input type="text" placeholder="Skriv her..." name="Tool_importantInformation" required> <br>
        </div>
        <button type="submit">lagre nytt verktøy</button>
</form>


<%=HtmlModel.getFooter()%>
