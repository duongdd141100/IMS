<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UserRegister</title>
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
        <h1 class="text-center">Register</h1>
        <div class="col-md-6 offset-md-3">
            <p style="color: blue" class="text-center">
                <% String message = (String) request.getAttribute("message");
                if (message != null && !message.equals("")) {
                    out.print(message);
                } %>
            </p>
            <form action="User" method="post">
                <div class="mb-3">
                    <label for="fullname" class="form-label">Fullname:</label>
                    <input type="text" class="form-control" id="fullname" name="fullname" required>
                </div>
                <div class="mb-3">
                    <label for="birthday" class="form-label">Date of Birth:</label>
                    <input type="date" class="form-control" id="birthday" name="birthday" required>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Address:</label>
                    <input type="text" class="form-control" id="address" name="address" required>
                </div>
                <div class="mb-3">
                    <label for="emailOrMobile" class="form-label">Email or Mobile:</label>
                    <input type="text" class="form-control" id="emailOrMobile" name="emailOrMobile" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <div class="mb-3">
                    <label for="repassword" class="form-label">Re-enter Password:</label>
                    <input type="password" class="form-control" id="repassword" name="repassword" required>
                </div>
                <input type="hidden" name="action" value="REGISTER">
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </form>
            <div class="text-center mt-3">Already have an account? <a href="User?action=LOGIN">Login</a></div>
        </div>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
