<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List,imp.Blog" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bloggify - Home</title>
    <style>
        /* CSS styles for layout */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        .header {
            background-color: #333;
            color: #fff;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .logo {
            display: flex;
            align-items: center;
        }
        .logo img {
            height: 40px;
            margin-right: 10px;
        }
        .tagline {
            font-size: 14px;
        }
        .user-email {
            font-size: 14px;
        }
        .content {
            display: flex;
            justify-content: space-between;
            padding: 20px;
        }
        .my-blogs {
            width: 100%;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
        }
        .create-blog-button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-bottom: 20px;
            width: 30%;
        }
        .blog-cards {
            width: 65%;
        }
        .plain-text-button {
            border: none;
            background: none;
            color: blue;
            text-decoration: underline;
            cursor: pointer;
        }
        .blog-card {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            border:2    px solid black;
            border-color: black;
            border-radius: 5px;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
        }
        .blog-title {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
        }
        .blog-category {
            background-color: #007bff;
            color: #fff;
            padding: 5px 10px;
            border-radius: 5px;
            margin-right: 10px;
            font-size: 14px;
        }
        .blog-description {
            font-size: 14px;
            margin-bottom: 10px;
        }
        .read-more {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <form method ="GET" action ="HomeServlet"><input type ="submit" value="Display all blogs"/></form>
    <div class="header">
        <div class="logo">
            <img src="logo.png" alt="Bloggify Logo">
            <h1>Bloggify</h1>
        </div>
        <div>
            <span class="tagline">Empowering Your Blogs</span>
            <span class="user-email">Welcome, <%= session.getAttribute("uname") %></span>
        </div>
    </div>
    <div class="content">
        <div class="my-blogs">
            <h2>My Blogs</h2>
            <button class="create-blog-button" onclick="window.location.href='CreateBlog.jsp'">Create New Blog</button>
            <%-- Fetch blogs data from HomeServlet --%>
            <%
                List<Blog> blogs = (List<Blog>)request.getAttribute("blogs");
                if (blogs != null && !blogs.isEmpty()) {
                    for (Blog blog : blogs) {
            %>
                        <div class="blog-card">
                            <div class="blog-title"><%= blog.getTitle() %></div>
                            <div>
                                <span class="blog-category"><%= blog.getCategory() %></span>
                                <p class="blog-description"><%= blog.getBdesc() %></p>
                                <form action="ReadMoreServlet" method="post">
        <!-- Hidden input field for bid -->
        <input type="hidden" name="bid" value="<%=blog.getBid()%>">
        
        <!-- Submit button styled as plain text and anchor -->
        <button type="submit" class="plain-text-button">Read More</button>
    </form>
                            </div>
                        </div>
            <%      
                    }
                } else {
            %>
                    <p>No blogs found.</p>
            <%
                }
            %>
        </div>
        
    </div>
    <a href="logout.jsp"><button style="width:100px;height:40px; position : relative;left:20px" class="create-blog-button">Logout</button></a>
</body>
</html>
