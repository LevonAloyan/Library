<%@ page import="com.epam.library.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: Zmix
  Date: 03.11.2023
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit book</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit user</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%Book book=(Book) request.getAttribute("bookToEdit"); %>
<div class="wrapper">
    <h2>Edit book</h2>
    <form action="/editBooks?bookId=<%=book.getId()%>" method="post">
        <div class="input-box">
            <input name="bookName" type="text" placeholder="Enter book name" required value="<%=book.getBookName()%>">
        </div>
        <div class="input-box">
            <input name="authorName" type="text" placeholder="Enter author name" required value="<%=book.getAuthorName()%>">
        </div>
        <div class="input-box button">
            <input type="Submit" value="Edit book">
        </div>
        <div class="text">
            <h3>Back to login page <a href="/">Login now</a></h3>
        </div>
    </form>
</div>
</body>
</html>
