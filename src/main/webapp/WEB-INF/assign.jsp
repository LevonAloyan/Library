<%@ page import="com.epam.library.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Noname
  Date: 10/2/2023
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assign book to user</title>
    <%
        List<User> users = (List<User>) session.getAttribute("users");
        List<Book> unassignedBooks = (List<Book>) session.getAttribute("unassignedBooks");
    %>
        <link rel="stylesheet" href="css/style.css">
    <h2>Admin</h2>
</head>
<body>
<div class="wrapper">
    <form action="/assign" method="post">
        <%
            if (request.getAttribute("successAssign") != null) {
        %>
        <span style="color: green"><%=request.getAttribute("successAssign")%></span>
        <%}%>
        <div class="input-box">
            <label for="selectuser"> Select User:
                <select name="selectedUser" id="selectuser">
                    <% for (User user : users) {
                    %>
                    <option value="<%=user.getId()%>"><%=user.getName()%> <%=user.getLastName()%>
                    </option>
                    <%}%>
                </select>
            </label>
        </div>

        <br>
        <div class="input-box">
            <label for="selectbook"> Select Book:
                <select name="selectedBook" id="selectbook">
                    <% for (Book book : unassignedBooks) {
                    %>
                    <option value="<%=book.getId()%>"><%=book.getBookName()%>/<%=book.getAuthorName()%>
                    </option>
                    <%}%>
                </select>
            </label>
        </div>

        <br>
        <div class="input-box button">
            <input type="submit" value="Assign">
        </div>
    </form>

    <ul>
        <li><a href="/">Back</a>
        </li>
        <li><a href="/users">Show all users</a>
        </li>
        <li><a href="/books">Show all books</a>
        </li>
    </ul>
</div>
</body>
</html>
