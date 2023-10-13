<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up form</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    List<User> userList = (List<User>) session.getAttribute("users");
%>
<div class="wrapper">
    <h2>All Users</h2>
    <br>
    <table>
        <tbody>
        <c:forEach var="user" items="${sessionScope.users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td><a href="/editUsers?userId=${user.id}">Edit</a></td>
            <td><a href="/deleteUsers?userId=${user.id}">Delete</a></td>
            </c:forEach>
        </tr>
        </tbody>
    </table>
    <br>
    <a href="/">Login</a>
</div>
</body>
</html>

