<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registration or Sign Up form in HTML CSS | CodingLab </title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    List<User> userList = (List<User>) session.getAttribute("users");

%>
<div class="wrapper">
    <h2>All users</h2>
        <div class="input-box">

            <% for (User user : userList) {
            %>
            <option value="<%=user.getId()%>"><%=user.getName()%> <%=user.getLastName()%>
                <button class="edit-button">Edit</button>
                <button class="delete-button">Delete</button>
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
