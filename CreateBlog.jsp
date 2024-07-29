<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Blog</title>
    <style>
        /* Styling for the page */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        header img {
            height: 40px;
            margin-right: 20px;
        }
        header h1 {
            font-size: 24px;
            margin: 0;
        }
        .input-field {
            margin-bottom: 20px;
        }
        .input-field label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .input-field input[type="text"],
        .input-field textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .input-field input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .input-field input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Header with logo and user email -->
        <header>
            <div>
                <img src="path/to/bloggify_logo.png" alt="Bloggify Logo">
                <h1>Create Blog</h1>
            </div>
            <p>User Email: <%= session.getAttribute("uname") %></p>
        </header>
        
        <!-- Blog creation form -->
        <form action="CreateBlogServlet" method="post">
            <div class="input-field">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div class="input-field">
                <label for="category">Category:</label>
                <input type="text" id="category" name="category" required>
            </div>
            <div class="input-field">
                <label for="description">Description:</label>
                <input type="text" id="description" name="description" required>
            </div>
            <div class="input-field">
                <label for="body">Body:</label>
                <textarea id="body" name="body" rows="6" required></textarea>
            </div>
            <div class="input-field">
                <input type="submit" value="Create Blog">
            </div>
        </form>
    </div>
</body>
</html>
