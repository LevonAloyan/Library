<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.epam.library.model.User" session="true" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admins dashboard</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<div class="wrapper">
    <h2> Welcome <c:out value="${user.name}" /></h2>
    <form action="/add-book" method="post">
        <c:if test="${not empty requestScope.bookAddingMsg}">
            <span style="color: green">${requestScope.bookAddingMsg}</span>
        </c:if>
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