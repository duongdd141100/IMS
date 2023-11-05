<%-- 
    Document   : userregister
    Created on : Nov 3, 2023, 1:05:15 AM
    Author     : giang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UserRegister</title>
    </head>
    <body>
        <h1>Register </h1>
        <p style="color: blue"> 
            <%String message = (String) request.getAttribute("message");
             if (message != null && !message.equals("")) {
                out.print(message);
            }%>
        </p>    
        <form action="User" method="post">
            Fullname: <input type="text" name="fullname" required><br>
            Date of Birth: <input type="date" name="birthday" required><br>
            Address: <input type="text" name="address" required><br>
            Email or Mobile: <input type="text" name="emailOrMobile" required><br>
            Password: <input type="password" name="password" required><br>
            Re-enter Password: <input type="password" name="repassword" required><br>
            <input type="hidden" name="action" value="REGISTER" required>
            <input type="submit" value="Register">
        </form>
        <div>Already have an account? <a href="User?action=LOGIN">Login</a></div>
    </body>
</html>
