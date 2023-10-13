<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.Book" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="wrapper">
    <h2>All Books</h2>
    <br>
    <table>
        <tbody>
        <c:forEach var="book" items="${sessionScope.books}">

        <tr>
            <td>${book.bookName}</td>
            <td><a href="/editBooks?bookId=${book.id}">Edit</a></td>
            <td><a href="/deleteBooks?bookId=${book.id}">Delete</a></td>

            </c:forEach>
        </tr>
        </tbody>
    </table>
    <br>
    <a href="/">Login</a>
</div>
</body>
</html>





