<%@ page import="bacit.web.bacit_web.models.HtmlModel" %>
<%@ page import="java.nio.file.attribute.UserPrincipal" %>
<%--
  Created by IntelliJ IDEA.
  User: ysyay
  Date: 13.09.2021
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%=HtmlModel.getHeader("profileSite")%>

<%
   java.security.Principal principal = request.getUserPrincipal();
   String name = principal.getName();
   String role = principal.toString();
%>

<%= name%>
<%= role%>


<%=HtmlModel.getFooter()%>



