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
</head>
<body>
<%
    List<User> users = (List<User>) request.getAttribute("users");%>
<div class="wrapper">
    <h2>All users</h2>
    <br>
    <table>
        <tr>
            <th>User Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%for (User user : users) {%>
        <tr>
            <td><%=user.getName()%> <%=user.getLastName()%></td>
            <td><a href="/editUsers?userId=<%=user.getId()%>">Edit</a></td>
            <td><a href="/deleteUsers?userId=<%=user.getId()%>">Delete</a></td>
        </tr>
        <%}%>
    </table>
    <br>
    <a href="/">Login</a>
</div>

<%--Select -> list of users--%>
<%--Select ->  list of books--%>

<%--button assign--%>


</body>
</html>
