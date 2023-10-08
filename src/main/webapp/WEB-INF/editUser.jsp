<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.10.2023
  Time: 2:49
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registration or Sign Up form in HTML CSS | CodingLab </title>
    <link rel="stylesheet" href="css/style.css">
</head>
<head>
    <title>Edit User</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("userToEdit");
%>
<h1>Edit User</h1>

<form method="post" action="editUser">
    <input type="hidden" name="id" value="<%= user.getId() %>">

    <label for="newName">New Name:</label>
    <input type="text" id="newName" name="newName" value="<%= user.getName() %>">
    <br>

    <label for="newLastName">New Last Name:</label>
    <input type="text" id="newLastName" name="newLastName" value="<%= user.getLastName() %>">

    <br>

    <input type="submit" value="Save Changes">
</form>

<p><a href="/allUsers">Back to All Users</a></p>

</body>
</html>
