<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.Book" %>
<%@ page import="com.epam.library.manager.impl.UserManagerImpl" %>
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
<div class="wrapper">
    <h2>All Books</h2>
    <br>
    <table> <%
        List<User> userList = (List<User>) session.getAttribute("users");
        List<Book> assignedBooks = (List<Book>) session.getAttribute("assignedBooks");

        for (Book book : assignedBooks) {
            User user = getUserForBook(userList, book);
    %>
        <tr>
            <td><%= book.getBookName() %></td>
            <td><%= user.getName() %></td>
            <td><%= user.getLastName() %></td>
            <td><a href="/unAssignBook?bookId=<%= book.getId() %>">Unassign</a></td>
        </tr>

        <%}%>
        <% if (request.getAttribute("unassignError") != null) { %>
        <span style="color: red"><%= request.getAttribute("unassignError") %></span>

        <% } else if (request.getAttribute("unassignSuccess") != null) { %>
        <span style="color: green"><%= request.getAttribute("unassignSuccess") %></span>
        <% } %>
    </table>
    <br>
    <a href="/">Login</a>
</div>
<%!
    private User getUserForBook(List<User> userList, Book book) {
        for (User user : userList) {
            if (user.getId() == book.getUserId()) {
                return user;
            }
        }
        return null;
    }
%>
</body>
</html>

