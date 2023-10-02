<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.Book" %>
<%@ page import="com.epam.library.model.User" %>

<!DOCTYPE html>
<html>
<head>

</head>
<body>
    <h1>Admin Panel</h1>
    <h2>Books</h2>
    <table>
        <td>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
            </tr>
        </td>
        <tbody>
            <% List<Book> books = (List<Book>) request.getAttribute("books"); %>
            <% for (Book book : books) { %>
                <tr>
                    <td><%= book.getId() %></td>
                    <td><%= book.getBookName() %></td>
                    <td><%= book.getAuthorName() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <h2>Users</h2>
    <table>
        <td>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Last Name</th>
            </tr>
        </td>
        <tbody>
            <% List<User> users = (List<User>) request.getAttribute("users"); %>
            <% for (User user : users) { %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getName() %></td>
                    <td><%= user.getLastName() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>