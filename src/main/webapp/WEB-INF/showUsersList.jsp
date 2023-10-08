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
    <%List<User> users = (List<User>) request.getAttribute("users"); %>
</head>
<body>
<div class="wrapper">
    <h2>All users</h2>
    <div class="input-box">
        <% for (User user : users) {
        %>
        <option value="<%=user.getId()%>"><%=user.getName()%> <%=user.getLastName()%>
            <a href="/editUser?userId=<%=user.getId()%>">Edit</a>
            <a href="/deleteUser?userId=<%=user.getId()%>">Delete</a>
        </option>
        <%}%>
    </div>

    <br>
    <br>
    <br>
    <br>
    <a href="/">Login</a>

</div>
</body>
</html>
