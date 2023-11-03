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
    <title>Edit user</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%User user=(User)request.getAttribute("userToEdit"); %>
<div class="wrapper">
    <h2>Edit user</h2>
    <form action="/editUsers?userId=<%=user.getId()%>" method="post">
        <div class="input-box">
            <input name="name" type="text" placeholder="Enter user name" required value="<%=user.getName()%>">
        </div>
        <div class="input-box">
            <input name="lastName" type="text" placeholder="Enter user last name" required value="<%=user.getLastName()%>">
        </div>
        <div class="input-box">
            <input name="email" type="text" placeholder="Enter user  email" required value="<%=user.getEmail()%>">
        </div>
        <div class="input-box button">
            <input type="Submit" value="Edit user">
        </div>
        <div class="text">
            <h3>Back to login page <a href="/">Login now</a></h3>
        </div>
    </form>
</div>
</body>
</html>
