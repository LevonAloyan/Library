<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.Book" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Books </title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <title>Books</title>
    <%List<Book> books = (List<Book>) request.getAttribute("books"); %>
</head>
<body>
<div class="wrapper">
    <h2>All books</h2>
    <br>
    <table>
        <tr>
            <th>Book Name</th>
            <th>Author Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <% for (Book book : books) {
        %>
        <tr>
            <td><%=book.getBookName()%></td>
            <td> <%=book.getAuthorName()%></td>
            <td><a href="/editBook?bookId=<%=book.getId()%>">Edit</a></td>
            <td><a href="/deleteBook?bookId=<%=book.getId()%>">Delete</a></td>
        </tr>
        <%}%>
    </table>

    <br>
    <br>
    <br>
    <br>
    <a href="/">Login</a>

</div>
</body>
</html>
