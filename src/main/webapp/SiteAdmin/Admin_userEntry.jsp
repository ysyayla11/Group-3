<%@ page import="bacit.web.bacit_web.models.HtmlModel" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%= HtmlModel.getHeader("user entry")%>
<br/>

<form method="post" action="uploadServletUser" enctype="multipart/form-data">
    <%-- Enter user --%>
    <div class="container">
        <label><b>Full name</b></label> <br>
        <input type="text" placeholder="Enter Full name" name="User_fullName" required> <br>

        <label><b>Email</b></label> <br>
        <input type="text" placeholder="Enter Email" name="User_email" required> <br>

        <label><b>Phone Number</b></label> <br>
        <input type="text" placeholder="Enter phone number" name="User_phoneNumber" required> <br>

        <label><b>Date of Birth</b></label> <br>
        <input type="text" placeholder="Enter Date of Birth" name="User_dob" required> <br>

        <label><b>Address</b></label> <br>
        <input type="text" placeholder="Enter Address" name="User_address" required> <br>

        <label><b>Is the user an admin?</b></label> <br>
        <input type="checkbox" name="User_access"> <br>

        <label><b>Is the user qualified to operate all tools?</b></label> <br>
        <input type="checkbox" name="User_qualification"> <br>

        <label><b>Are the user an unionworker?</b></label> <br>
        <input type="checkbox" name="User_union"> <br>

        <label><b>Do thee user have any previous debt?</b></label> <br>
        <input type="text" placeholder="Enter debt" name="User_debt"> <br>

        <label><b>Password</b></label> <br>
        <input type="password" placeholder="Enter Password" name="User_password" required> <br>

        <button type="submit">Login</button> <br>


    </div>
</form>

</body>
</html>
