<%--
  Created by IntelliJ IDEA.
  User: Kristian
  Date: 04.10.2021
  Time: 18:43
  To change this template use File | Settings | File Templates. yolorvhebrv
--%>
<%@ page import="bacit.web.bacit_web.models.HtmlModel" %>

<%= HtmlModel.getHeader("Booking")%>

<script type="text/javascript">
    function showMessage() {
        alert("Your booking was succesful");
    }
</script>

<h1> Booking Registration Page</h1>
<form action="BookingServlet" method="post">

    <label>Tool id</label>
    <input type="text" name="Tool_id"> <br/>

    <label>User id</label>
    <input type="text" name="User_id"> <br/>

    <label>Booking start</label>
    <input type="date" name="Booking_dateStart"> <br/> <br/>

    <label>Booking end</label>
    <input type="date" name="Booking_dateEnd"> <br/> <br/>

    <label>Booking paid:</label> <br/>
    <label>Ja</label>
    <input type="radio" name="Booking_paid" value="true"> <br/>
    <label>Nei</label>
    <input type="radio" name="Booking_paid" value="false"> <br/>


    <a href="home.jsp"><button type="submit" value="Register" onclick="showMessage()">Registrer</button> <br/></a>
</form>
</body>
</html>