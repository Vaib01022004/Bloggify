<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="imp.Blog"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Read More</title>
</head>
<body>
    <h1>Blog Details</h1>
    
    <% 
        // Retrieve the blog attribute from the request
        Object blogObj = request.getAttribute("blog");
        
        // Check if the blog object is not null and is an instance of Blog
        if (blogObj != null && blogObj instanceof Blog) {
            // Typecast the object to Blog
            Blog blog = (Blog) blogObj;
    %>
            <div>
                <h2><%= blog.getTitle() %></h2>
                <p><strong>Category:</strong> <%= blog.getCategory() %></p>
                <p><strong>Description:</strong> <%= blog.getBdesc() %></p>
                <p><strong>Body:</strong> <%= blog.getBody() %></p>
            </div>
    <% 
        } else {
            // Handle case where blog object is null or not an instance of Blog
            out.println("Blog not found");
        }
    %>
    
    <!-- Back button to navigate back to home.jsp -->
    <button onclick="goBack()">Back</button>

    <!-- JavaScript function to go back to the previous page -->
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
