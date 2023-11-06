<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="modal.Setting" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SettingDetail</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .form-container {
            max-width: 400px;
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1 class="text-center">Setting Detail</h1>
        <form action="Setting" method="post">
            <% Setting setting = (Setting) request.getAttribute("setting"); %>
            <input type="hidden" name="id" value="<%= setting.getSetting_id() %>">
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="<%= setting.getSetting_name() %>">
            </div>

            <div class="mb-3">
                <label for="type" class="form-label">Type:</label>
                <select class="form-select" id="type" name="type">
                    <option value="Role" <%= setting.getSetting_type().equals("role") ? "selected" : "" %>>Role</option>
                    <option value="Semester" <%= setting.getSetting_type().equals("semester") ? "selected" : "" %>>Semester</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="displayOrder" class="form-label">Display Order:</label>
                <input type="text" class="form-control" id="display_order" name="display_order" value="<%= setting.getDisplay_order() %>">
            </div>

            <div class="mb-3">
                <label for="status" class="form-label">Status:</label>
                <select class="form-select" id="status" name="status">
                    <option value="Active" <%= setting.getStatus().equals("active") ? "selected" : "" %>>Active</option>
                    <option value="Inactive" <%= setting.getStatus().equals("inactive") ? "selected" : "" %>>Inactive</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description:</label>
                <input type="text" class="form-control" id="description" name="description" value="<%= setting.getDescription() %>">
            </div>

            <div class="mb-3 text-center">
                <button type="submit" class="btn btn-primary" name="action" value="UPDATE">Update</button>
                <button type="submit" class="btn btn-secondary" name="action" value="ADDNEW">Add New</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
