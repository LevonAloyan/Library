<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Zmix
  Date: 01.11.2023
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration or Sign up form in HTML CSS | CodingLab</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%List<User> userList = (List<User>) request.getAttribute("allUsers");%>
<div class="wrapper">
    <h2>All users</h2>
    <br>
    <table>
        <tr>
            <th>User name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <% for (User user : userList) {%>
        <tr>
            <td><%=user.getName()%> <%=user.getLastName()%></td>
            <td><a href="/editUsers?userId=<%=user.getId()%>">Edit</a></td>
            <td><a href="/deleteUsers?userId=<%=user.getId()%>">Delete</a></td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
