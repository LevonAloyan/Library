<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Books </title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <title>Books</title>
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

        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.bookName}</td>
                <td>${book.authorName}</td>
                <td><a href="/editBook?bookId=${book.id}">Edit</a></td>
                <td><a href="/deleteBook?bookId=${book.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <br>
    <br>
    <br>
    <a href="/">Login</a>

</div>
</body>
</html>
