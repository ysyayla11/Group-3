<%@ page import="bacit.web.bacit_web.models.HtmlModel" %><%--
  Created by IntelliJ IDEA.
  User: Aleksander Wilberg
  Date: 21-Sep-21
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%= HtmlModel.getHeader("Admin dashboard")%>
    <div class="adminButtons">
        <div>
            <a href="Admin_userEntry.jsp"><button type ="button" class="adminButtons"><img class="adminButtons" alt="addUser" src="../Images/add%20user.png" style="height: 50px; width: auto; align-content: center;"/>Legg til nye brukere</button></a>
            <a href="Admin_toolEntry.jsp"><button type ="button" class="adminButtons"><img class="adminButtons" alt="addTool" src="../Images/add%20tool.png" style="height: 50px; width: auto; align-content: center;"/>Legg til nye verktøy</button></a>
        </div>
        <br>
        <br>
        <br>
        <div>
            <a href="../SiteAdmin/GetAllUserServlet" methods="get"><button type ="button" class="adminButtons"><img class="adminButtons" alt="editUser" src="../Images/edit%20user.png" style="height: 50px; width: auto; align-content: center;"/>Oppdater brukere</button></a>
            <a href="../SiteAdmin/GetAllToolServlet" methods="get"><button type ="button" class="adminButtons"><img class="adminButtons"alt="editTool" src="../Images/edit%20tool.png" style="height: 50px; width: auto; align-content: center;"/>Oppdater Verktøy</button></a>
        </div>
    </div>
</div>
<br/>

<ul>

</ul>


</body>
</html>
