<%@ page import="bacit.web.bacit_web.models.HtmlModel" %><%--
  Created by IntelliJ IDEA.
  User: Kristian
  Date: 04.10.2021
  Time: 18:43
  To change this template use File | Settings | File Templates. yolorvhebrv
--%>

<!DOCTYPE html>
<%=HtmlModel.getHeader("Booking")%>

<h1> Booking Registration Page</h1>
<form action="BookingServlet" method="post">

    <label>Tool id</label>
    <input type="text" name="Tool_id">

    <label>User id</label>
    <input type="text" name="User_id">

    <label>Booking start</label>
    <input type="date" name="Booking_dateStart">

    <label>Booking end</label>
    <input type="date" name="Booking_dateEnd">

    <label>Booking paid</label>
    <label>Ja</label>
    <input type="radio" name="Booking_paid" value="true">
    <label>Nei</label>
    <input type="radio" name="Booking_paid" value="false">


    <input type="submit" value="register">
</form>
</body>
</html>