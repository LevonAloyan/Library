<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> All users </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel='stylesheet' type='text/css' href='css/tableStyle.css'/>

</head>
<body>
<div class="wrapper">
    <h2>All users</h2>
    <br>
    <table>
        <tr>
            <th>User Name</th>
            <th>Last Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getName()}</td>
                <td>${user.getLastName()}</td>
                <td><a href="/editUsers?userId=${user.getId()}">Edit</a>/
                    <a href="/deleteUsers?userId=${user.getId()}">Delete</a></td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <a href="/admin">Go home</a>
</div>

</body>
</html>
