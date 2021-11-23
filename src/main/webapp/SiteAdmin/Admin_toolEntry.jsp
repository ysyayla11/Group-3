<%@ page import="bacit.web.bacit_web.models.HtmlModel" %><%--
  Created by IntelliJ IDEA.
  User: Aleksander Wilberg
  Date: 21-Sep-21
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%= HtmlModel.getHeader("tool Entry")%>
<br/>

<form method="post" action="uploadServlet" enctype="multipart/form-data">
    <%-- Enter user --%>
    <%-- Endring --%>
    <div class="container">
        <label><b>Navn på verktøy</b></label> <br>
        <input type="text" placeholder="Enter Tool Name" name="Tool_name" required> <br>

        <label><b>Type</b></label> <br>
        <input type="text" placeholder="Enter Tool Type" name="Tool_type" required> <br>

        <label><b>Tilstand</b></label> <br>
        <input type="text" placeholder="Enter tool condition" name="Tool_condition" required> <br>

        <label><b>Pris per dag</b></label> <br>
        <input type="text" placeholder="Enter rental price" name="Tool_price" required> <br>

        <label><b>er verktøyet gratis første dag?</b></label><input type="checkbox" name="Tool_freeFirstDay" >
        <br>
        <br>
        <label><b>Viktig informasjon om verktøyet</b></label> <br>
        <input type="text" placeholder="Enter Important Information" name="Tool_importantInformation" required> <br>

        <label><b>Last opp bilde (JPG/PNG only)</b></label> <br>
        <input type="file" name="Tool_image" required> <br>

        <button type="submit">Lagre verktøy</button> <br>

    </div>
</form>



</body>
</html>
