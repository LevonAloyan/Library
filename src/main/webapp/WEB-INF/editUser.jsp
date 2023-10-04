<%@ page import="com.epam.library.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Noname
  Date: 10/3/2023
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Update user's data </title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
<div class="wrapper">
    <h2>Edit</h2>
    <form action="/user/edit" method="post">
        <div class="input-box">
            <input type="hidden" name="userId" value="<%=user.getId()%>">
            <input name="name" type="text" placeholder="Enter your name" value="<%=user.getName()%>" required>
        </div>
        <div class="input-box">
            <input name="lastName" type="text" placeholder="Enter your last name" value="<%=user.getLastName()%>"
                   required>
        </div>
        <%
            if (request.getAttribute("usernameExistsErr") != null) {
        %>
        <span style="color: red"><%=request.getAttribute("usernameExistsErr")%></span>
        <%}%>
        <%
            if (request.getAttribute("emailFormatErr") != null) {
        %>
        <span style="color: red"><%=request.getAttribute("emailFormatErr")%></span>
        <%}%>
        <div class="input-box">
            <input name="email" type="text" placeholder="Enter your email" value="<%=user.getEmail()%>" required>
        </div>
        <%
            if (request.getAttribute("passwordErrMsg") != null) {
        %>
        <span style="color: red"><%=request.getAttribute("passwordErrMsg")%></span>
        <%}%>

        <div class="input-box button">
            <input type="Submit" value="Update user's data">
        </div>
        <div class="text">
            <h3><a href="/">Login now</a></h3>
        </div>
    </form>
</div>

</body>
</html>
