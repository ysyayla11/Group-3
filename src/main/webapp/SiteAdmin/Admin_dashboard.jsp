<%@ page import="bacit.web.bacit_web.models.HtmlModel" %><%--
  Created by IntelliJ IDEA.
  User: Aleksander Wilberg
  Date: 21-Sep-21
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="ISO-8859-1" %>
<%@page import="java.sql.*, java.util.*"%>
<%@ page import="static jdk.vm.ci.hotspot.HotSpotCallingConventionType.VALUES" %> --%>




<%=HtmlModel.getHeader("Dashboard")%>

<br>
<%-- Menu Bar --%>

    <div class="adminButtons">
        <div>
            <a href="Admin_userEntry.jsp"><img alt="addUser" src="../Images/add%20user.png" />Legg til nye brukere</a>
            <a href="Admin_toolEntry.jsp"><img alt="addTool" src="../Images/add%20tool.png" >Legg til nye verktøy</a>
        </div>
        <br>
        <br>
        <br>
        <div>
            <a href="GetAllUserServlet" methods="get"><img alt="editUser" src="../Images/edit%20user.png"/>Oppdater brukere</a>
            <a href="GetAllToolServlet" methods="get"><img alt="editTool" src="../Images/edit%20tool.png"/>Oppdater Verktøy</a>
        </div>
    </div>
</div>
<br/>

<%=HtmlModel.getFooter()%>
