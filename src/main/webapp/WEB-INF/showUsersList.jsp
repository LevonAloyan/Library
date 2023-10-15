<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Users </title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <title>Users</title>
</head>
<body>
<div class="wrapper">
    <h2>All users</h2>
    <br>
    <table>
        <tr>
            <th>User Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.name} ${user.lastName}</td>
                <td><a href="/editUser?userId=${user.id}">Edit</a></td>
                <td><a href="/deleteUser?userId=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <br>
    <br>
    <br>
    <a href="/">Login</a>

</div>
</body>
</html>
