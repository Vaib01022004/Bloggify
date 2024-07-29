<%@page language="java" import ="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "stylesheet" type = "text/css" href="styles.css"/>
<title>Login Page</title>

</head>
<body>

<div class="header">
  <img src="./assets/images.png" alt="Bloggify Logo" class="logo">
  <h1 class="site-title">Bloggify</h1>
  <p class = "tagline"> Reflect, Collect, Appreciate.</p>
</div>

<div class="login-container">
  <% Object logoutMsgObj = request.getAttribute("logout");
     String logoutmsg = null;
     if(logoutMsgObj!=null){
        logoutmsg = logoutMsgObj.toString();
      }if(logoutmsg!=null){
       %><p style="color:red;position:relative;"><%=logoutmsg%></p><%
      }%>

  <% Object rerrorMsgObj = request.getAttribute("rerror");
     String rerrormsg = null;
     if(rerrorMsgObj!=null){
        rerrormsg = rerrorMsgObj.toString();
      }if(rerrormsg!=null){
       %><p style="color:red;position:relative;"><%=rerrormsg%></p><%
      }%>
      <% Object rsuccessMsgObj = request.getAttribute("rsuccess");
     String rsuccessmsg = null;
     if(rsuccessMsgObj!=null){
        rsuccessmsg = rsuccessMsgObj.toString();
      }if(rsuccessmsg!=null){
       %><p style="color:red;position:relative;"><%=rsuccessmsg%></p><%
      }%>
  <h2>Login</h2>
  <form action="LoginServlet" method="post">
    <input type="email" name="email" placeholder="Email" required>
    <input type="password" name="password" placeholder="Password" minlength="8" required>
    <button type="submit">Sign In</button>
  </form>
  <p>Don't have an account? <a href="register.jsp" class="signup-link">Sign up to Bloggify</a></p>
  <%
            Object errorMessageObj = request.getAttribute("error");
            String errormsg = null;
            if(errorMessageObj!=null){
            errormsg = errorMessageObj.toString();}
            if(errormsg!=null && !errormsg.isEmpty()){
            %><p style="color:red;position:relative;"><%=errormsg%></p>
        <%  }
        %>
</div>

    <div class="loginerror">
    </div>
</body>
</html>
