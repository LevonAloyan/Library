<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.Book" %>
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
    List<Book> unassignedBooks = (List<Book>) session.getAttribute("unassignedBooks");

%>
<div class="wrapper">
    <h2>Admin</h2>

    <form action="/assign" method="post">
        <%
            if (request.getAttribute("successAssign") != null) {
        %>
        <span style="color: green"><%=request.getAttribute("successAssign")%></span>
        <%}%>
        <div class="input-box">
            <label for="selectuser"> Select User:
                <select name="selectedUser" id="selectuser">
                    <% for (User user : userList) {
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
        <li><a href="/">Login Page</a>
        </li>
        <li><a href="/allUsers">Show all users</a>
        </li>
        <li><a href="/allBooks">Show all books</a>
        </li>
        <li><a href="/assignedBooks">Show assigned books</a>
        </li>
    </ul>
</div>


<%--Select -> list of users--%>
<%--Select ->  list of books--%>

<%--button assign--%>


</body>
</html>
