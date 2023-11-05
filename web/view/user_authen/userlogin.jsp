<%-- 
    Document   : userlogin
    Created on : Nov 3, 2023, 1:05:05 AM
    Author     : giang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UserLogin</title>
    </head>
    <body>
        <h1>User Login</h1>
        <p style="color: blue"> 
            <%String message = (String) request.getAttribute("message");
             if (message != null && !message.equals("")) {
                out.print(message);
            }%>
        </p> 
        <form action="User" method="post">
            Username: <input type="text" name="username" required><br>
            Password: <input type="password" name="password" required><br>
            <input type="hidden" name="action" value="LOGIN" required>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
