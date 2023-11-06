<%-- 
    Document   : authorization
    Created on : Nov 3, 2023, 1:06:24 AM
    Author     : giang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="modal.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User dashboard</h1>
        <%User user = (User) session.getAttribute("user");
        if (user.getId()==1) {
            %>
            <div>System Setting <a href="Setting">Click here</a></div>
            <%
            }else if (user.getId()==2) {
                %>
                
                <%               
                }else if (user.getId()==3) {
                    %>
                    
                    <%
                    }else if (user.getId()==4) {
                        %>
                        
                        <%
                        }else if (user.getId()==5) {
                            %>
                            
                            <%
                            }
        %> 
    </body>
</html>
