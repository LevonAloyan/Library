<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
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
        <% for (User user : userList) {
        %>
        <tr>
            <td><%=user.getName()%></td>
            <td><%=user.getLastName()%></td>
            <td><a href="/editUsers?userId=<%= user.getId() %>">Edit</a></td>
            <td><a href="/deleteUsers?userId=<%= user.getId() %>">Delete</a></td>
            <% } %>
        </tr>
        </tbody>
    </table>
    <br>
    <a href="/">Login</a>
</div>
</body>
</html>

