<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="modal.Setting" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SettingDetail</title>
</head>
<body>
    <h1>Setting Detail</h1>
    <form action="Setting" method="post">
        <% Setting setting = (Setting) request.getAttribute("setting"); %>
        <input type="hidden" name="id" value="<%= setting.getSetting_id() %>">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= setting.getSetting_name() %>"><br><br>

        <label for="type">Type:</label>
        <select name="type">
            <option value="Role" <%= setting.getSetting_type().equals("role") ? "selected" : "" %>>Role</option>
            <option value="Semester" <%= setting.getSetting_type().equals("semester") ? "selected" : "" %>>Semester</option>
        </select><br><br>

        <label for="displayOrder">Display Order:</label>
        <input type="text" id="display_order" name="display_order" value="<%= setting.getDisplay_order() %>"><br><br>

        <label for="status">Status:</label>
        <select name="status">
            <option value="Active" <%= setting.getStatus().equals("active") ? "selected" : "" %>>Active</option>
            <option value="Inactive" <%= setting.getStatus().equals("inactive") ? "selected" : "" %>>Inactive</option>
        </select><br><br>

        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="<%= setting.getDescription() %>"><br><br>

        <button type="submit" name="action" value="UPDATE">Update</button>
        <button type="submit" name="action" value="ADDNEW">Add New</button>
    </form>
</body>
</html>
