<%@ page import="bacit.web.bacit_web.models.HtmlModel" %><%--
  Created by IntelliJ IDEA.
  User: ysyay
  Date: 13.09.2021
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%= HtmlModel.getHeader("dine bestillinger")%>

    <label>Tool id</label>
    <input type="text" name="Tool_id">
    <label>Varen Levert</label>
    <label>Ja</label>
    <input type="radio" name="Tool_delivered" value="true">
    <label>Nei</label>
    <input type="radio" name="Tool_delivered" value="false">

    <input type="submit" value="Lever Varen">

<%= HtmlModel.getFooter()%>
