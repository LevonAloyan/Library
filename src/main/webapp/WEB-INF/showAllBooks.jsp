<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 37455
  Date: 10/14/2023
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View all books</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<form action="/books" method="post">
    <h3>Books</h3>
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.bookName}</td>
                <td>${book.authorName}</td>
            </tr>

        </c:forEach>
    </table>
</form>
</body>
</html>
