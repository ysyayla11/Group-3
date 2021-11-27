<%@ page import="bacit.web.bacit_web.models.HtmlModel" %><%--
  Created by IntelliJ IDEA.
  User: Aleksander Wilberg
  Date: 21-Sep-21
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%= HtmlModel.getHeader("Admin dashboard")%>
<br>
<br>
    <div class="adminButtons">
        <div>
            <a href="Admin_userEntry.jsp"><button type ="button" class="adminButtons"><img class="adminButtons" alt="addUser" src="../Images/add%20user.png"/>Legg til nye brukere</button></a>
            <a href="Admin_toolEntry.jsp"><button type ="button" class="adminButtons"><img class="adminButtons" alt="addTool" src="../Images/add%20tool.png"/>Legg til nye verktøy</button></a>
        </div>
        <br>
        <div>
            <a href="../SiteAdmin/GetAllUserServlet" methods="get"><button type ="button" class="adminButtons"><img class="adminButtons" alt="editUser" src="../Images/edit%20user.png"/>Oppdater brukere</button></a>
            <a href="../SiteAdmin/GetAllToolServlet" methods="get"><button type ="button" class="adminButtons"><img class="adminButtons" alt="editTool" src="../Images/edit%20tool.png"/>Oppdater Verktøy</button></a>
        </div>
    </div>
</div>
<button onclick="confimDeleteTool()"  name = "tool_id" value=""></button>
<br/>

<ul>

</ul>


</body>
</html>
