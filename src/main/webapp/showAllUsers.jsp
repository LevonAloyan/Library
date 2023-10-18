<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <form action="/users" method="post" class="tree-table-view">
    <h3>Users:</h3>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        </thead>
        <br>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.name}
                </td>
                <td>${user.lastName}
                </td>
                <td>${user.email}
                </td>
                <td>
                    <a href="/user/edit?userId=${user.id}">Edit</a> |
                    <a href="/user/remove?userId=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="web-field">
        <a href="/my-account">Back</a><br>
        <a href="/assign">Assign book to user</a><br>
    </div>
    </form>
</div>
</body>
</html>