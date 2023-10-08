<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.Book" %>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All books</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    List<Book> bookList = (List<Book>) session.getAttribute("books");
%>
<div class="wrapper">
    <h2>All Books</h2>
    <br>
    <table>
        <tbody>
        <% for (Book book : bookList) {
        %>
        <tr>
            <td><%=book.getBookName()%>
            </td>
            <td><a href="/editBook?id=<%= book.getBookName() %>">Edit</a></td>
            <td><a href="/deleteBook?id=<%= book.getBookName() %>">Delete</a></td>


            <% } %>
        </tr>
        </tbody>
    </table>
    <br>
    <a href="/">Login</a>
</div>
</body>
</html>





