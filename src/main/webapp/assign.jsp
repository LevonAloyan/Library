<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.epam.library.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Assign book to user</title>
        <c:set var="users" value="${sessionScope.users}"/>
        <c:set var="unassignedBooks" value="${sessionScope.unassignedBooks}"/>
        <link rel="stylesheet" href="css/style.css">
    </head>
<body>
<div class="wrapper">
    <h2>Admin</h2>
    <form action="/assign" method="post">
        <c:if test="${not empty requestScope.successAssign}">
            <span style="color: green">${requestScope.successAssign}</span>
        </c:if>
        <div class="input-box">
            <label for="selectUser"> Select User:
                <select name="selectedUser" id="selectUser">
                    <c:forEach var="user" items="${users}">
                        <option value="${user.id}"> ${user.name } ${user.lastName}</option>
                    </c:forEach>
                </select>
            </label>
        </div>

        <br>
        <div class="input-box">
            <label for="selectbook"> Select Book:
                <select name="selectedBook" id="selectbook">
                    <c:forEach var="book" items="${sessionScope.unassignedBooks}">
                        <option value="${book.id}">${book.bookName } ${book.authorName}</option>
                    </c:forEach>
                </select>
            </label>
        </div>

        <br>
        <div class="input-box button">
            <input type="submit" value="Assign">
        </div>
    </form>

    <ul>
        <li><a href="/">Back</a>
        </li>
        <li><a href="/users">Show all users</a>
        </li>
        <li><a href="/books">Show all books</a>
        </li>
    </ul>
</div>
</body>
</html>