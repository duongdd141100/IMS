<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UserLogin</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center" style="height: 100vh;">
    <div class="container">
        <h1 class="text-center">User Login</h1>
        <div class="col-md-6 offset-md-3">
            <p style="color: blue" class="text-center">
                <% String message = (String) request.getAttribute("message");
                if (message != null && !message.equals("")) {
                    out.print(message);
                } %>
            </p>
            <form action="User" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Email or PhoneNumber:</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <input type="hidden" name="action" value="LOGIN">
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
