<%-- 
    Document   : systemsettinglist
    Created on : Nov 3, 2023, 1:06:01 AM
    Author     : giang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modal.Setting" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SettingList</title>
    </head>
    <body>
        <h1>Setting List</h1>   
        <p style="color: blue"> 
            <%String message = (String) request.getAttribute("message");
             if (message != null && !message.equals("")) {
                out.print(message);
            }%>
        </p> 
        <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
        </tr>
        <% 
            List<Setting> settings = (List<Setting>)  request.getAttribute("settings");
            for (Setting setting : settings) {
        %>
        <tr onclick="window.location.href='Setting?view=DETAIL&&id=<%= setting.getSetting_id() %>'">
            <td><%= setting.getSetting_id() %></td>
            <td><%= setting.getSetting_name() %></td>
            <td><%= setting.getSetting_type() %></td>
            <td><%= setting.getDisplay_order() %></td>
            <td><%= setting.getStatus() %></td>
            <td><%= setting.getDescription() %></td>
        </tr>
        <% } %>
    </table>
    </body>
</html>


