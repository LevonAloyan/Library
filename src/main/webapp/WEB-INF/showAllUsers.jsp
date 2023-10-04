<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Noname
  Date: 10/2/2023
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%List<User> users = (List<User>) request.getAttribute("users"); %>
    <link rel="stylesheet" href="css/style.css">
    <h3>Users:</h3>
</head>
<body>
<div class="wrapper">
    <%--    <form action="/view-all-users" method="post">--%>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <% for (User user : users) { %>
        <tr>
            <td><%= user.getName() %>
            </td>
            <td><%= user.getLastName() %>
            </td>
            <td><%= user.getEmail() %>
                <a href="/user/edit?userId=<%=user.getId()%>">Edit</a> | <a href="/user/remove?userId=<%=user.getId()%>">Delete</a>
            </td>
        </tr>
        <% } %>
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

