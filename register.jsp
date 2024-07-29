<%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="styles.css"/>
<title>Register Page</title>
</head>
<body>

<div class="header">
  <img src="./assets/images.png" alt="Bloggify Logo" class="logo">
  <h1 class="site-title">Bloggify</h1>
  <p class="tagline"> Reflect, Collect, Appreciate.</p>
</div>

<div class="register-container">
  <h2 style ="position:relative;left:110px;">Register</h2>
  <form action="RegisterServlet" method="post">
    <input type="text" name="name" placeholder="Name" required>
    <input type="email" name="email" placeholder="Email" required>
    <input type="password" name="password" placeholder="Password" minlength="8" required>
    <button type="submit">Register</button>
  </form>
  <p>Already have an account? <a href="index.jsp" class="signup-link">Login here</a></p>
</div>

</body>
</html>
