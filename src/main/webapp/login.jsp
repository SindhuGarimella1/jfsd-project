<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: url('https://cdn.pixabay.com/photo/2020/02/28/16/18/board-4887880_960_720.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
        }

        .form-container {
            width: 400px;
            padding: 20px;
            margin: 50px auto;
            background: rgba(255, 255, 255, 0.8);
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .form-container h2 {
            text-align: center;
        }

        .form-field {
            margin-bottom: 15px;
        }

        .form-field input {
            width: 95%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .submit-button {
            width: 90%;
            padding: 10px;
            background: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            align-items: center;
        }

        .submit-button:hover {
            background: #45a049;
        }
        
        .notification {
            visibility: hidden;
            min-width: 250px;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            border-radius: 4px;
            padding: 16px;
            position: fixed;
            top: 80px;
            right: 20px;
            z-index: 1;
            transition: visibility 0.5s, opacity 0.5s ease-in-out;
            opacity: 0;
        }
        .notification.show {
            visibility: visible;
            opacity: 1;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Login</h2>
        <form action="/login" method="post">
            <div class="form-field">
                <input type="text" name="username" placeholder="Username" required />
            </div>
            <div class="form-field">
                <input type="password" name="password" placeholder="Password" required />
            </div>
            <input type="submit" value="Login" class="submit-button" />
        </form>
    </div>

  <div id="successNotification" class="notification"></div>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        const message = "<%= session.getAttribute("message") != null ? session.getAttribute("message") : "" %>";
        if (message) {
            const notification = document.getElementById("successNotification");
            notification.textContent = message;
            notification.classList.add("show");

            setTimeout(() => {
                notification.classList.remove("show");
            }, 3000);

            // Remove message from session after displaying
            <% session.removeAttribute("message"); %>
        }
    });
</script>
  
</body>
</html>