<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>

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
    <%List<User> userList = (List<User>) request.getAttribute("users"); %>
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
        <% for (User user : userList) {
        %>
        <tr>
            <td><%=user.getName()%> <%=user.getLastName()%></td>
            <td><a href="/editUser?userId=<%=user.getId()%>">Edit</a></td>
            <td><a href="/deleteUser?userId=<%=user.getId()%>">Delete</a></td>
        </tr>
        <%}%>
    </table>

    <br>
    <br>
    <br>
    <br>
    <a href="/">Login</a>

</div>
</body>
</html>
