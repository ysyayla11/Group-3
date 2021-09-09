<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello, World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>

    <%
        for (int i = 1; i <= 5; i++) {
            out.println("<br/> Koding er sinnsykt sykt gøy: " + i);
        }
    %>

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>