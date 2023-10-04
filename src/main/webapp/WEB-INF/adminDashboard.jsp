<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: Noname
  Date: 10/1/2023
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admins dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <h2>Welcome <%=((User) session.getAttribute("user")).getName()%></h2>
    <form action="/add-book" method="post">
        <div class="input-box">
            <input name="bookName" type="text" placeholder="Enter book's name" required>
        </div>
        <div class="input-box">
            <input name="authorName" type="text" placeholder="Enter book's author name" required>
        </div>
        <br>
        <div class="input-box button">
            <input type="submit" value="Add">
        </div>
    </form>
    <div class="webcolor-field">
        <p><a href="/users">Show all users</a></p>
        <p><a href="/books">Show all books</a></p>
        <p><a href="/assign">Assign book to user</a></p>
        <p><a href="/">Back</a></p><br>
    </div>
</div>
</body>
</html>
