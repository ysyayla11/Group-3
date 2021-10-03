<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<br>
<%-- Menu Bar --%>
<div class="topnav">
    <a class="active" href="index.jsp">Hjemme</a>
    <a href="Logg%20inn.jsp">Log inn</a>
    <a href="DinProfil.jsp">Din Profil</a>
    <a href="DineBestillinger.jsp">Dine Bestillinger</a>
    <br>
    <br>
    <br>
    <a href="Admin_userEntry.jsp">Admin</a>
    <a href="Admin_toolEntry.jsp">Verktøy</a>
    <a href="Admin_userEntry.jsp">Brukere</a>
</div>
<br/>

<form class="post">
    <%-- Enter user --%>
    <div class="container">
        <label><b>First name</b></label> <br>
        <input type="text" placeholder="Enter First name" name="User_firstName" required> <br>

        <label><b>Last name</b></label> <br>
        <input type="text" placeholder="Enter Last name" name="User_lastName" required> <br>

        <label><b>Email</b></label> <br>
        <input type="text" placeholder="Enter Email" name="User_email" required> <br>

        <label><b>Phone Number</b></label> <br>
        <input type="text" placeholder="Enter phone number" name="User_phoneNumber" required> <br>

        <label><b>Date of Birth</b></label> <br>
        <input type="text" placeholder="Enter Date of Birth" name="User_dob" required> <br>

        <label><b>Address</b></label> <br>
        <input type="text" placeholder="Enter Address" name="User_address" required> <br>

        <label><b>Is the user an admin?</b></label> <br>
        <input type="checkbox" name="User_access" required> <br>

        <label><b>Is the user qualified to operate all tools?</b></label> <br>
        <input type="checkbox" name="User_qualification" required> <br>

        <label><b>Are the user an unionworker?</b></label> <br>
        <input type="checkbox" name="User_union" required> <br>

        <label><b>Password</b></label> <br>
        <input type="password" placeholder="Enter Password" name="User_password" required> <br>

        <button type="submit">Login</button> <br>

    </div>
</form>

</body>
</html>
