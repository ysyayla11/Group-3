<%@ page import="bacit.web.bacit_web.models.HtmlModel" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%= HtmlModel.getHeader("user entry")%>
<br/>

<h1>Legg til ny bruker</h1>

<form method="post" action="../SiteAdmin/UserUploadDBServlet">
    <%-- Enter user --%>
    <div class="container">

        <input type="text" name="User_fullName" placeholder="Skriv navnet her" required><br>

        <input type="text" name="User_email" placeholder="Skriv email her" required><br>

        <input type="number" name="User_phoneNumber" placeholder="Skriv telefonnummer her" required><br>

        <input type="text" name="User_address" placeholder="Skriv addresse her" required><br>

        <label>Er brukeren admin?</label>
        <input type="checkbox" name="User_access" value="true"><br>
        <input type="hidden" name="User_access" value="false">

        <label>Er brukeren med i fagforeningen</label>
        <input type="checkbox" name="User_union" value="true"><br>
        <input type="hidden" name="User_union" value="false">

        <input type="number" name="User_debt" placeholder="Har brukeren tidligere gjeld?" value="0"><br>

        <input type="password" name="User_password" placeholder="skriv inn brukerens passord" required>

        <button type="submit">Legg til bruker</button>

    </div>
</form>

</body>
</html>
