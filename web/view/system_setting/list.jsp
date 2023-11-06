<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modal.Setting" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SettingList</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Setting List</h1>
        <p style="color: blue" class="text-center"> 
            <% String message = (String) request.getAttribute("message");
            if (message != null && !message.equals("")) {
                out.print(message);
            } %>
        </p> 
        <table class="table table-bordered text-center">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Display Order</th>
                    <th>Status</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Setting> settings = (List<Setting>) request.getAttribute("settings");
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
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
