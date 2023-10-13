<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> All books </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel='stylesheet' type='text/css' href='css/tableStyle.css'/>

</head>
<body>
<div class="wrapper">
    <h2>All books</h2>
    <c:if test="${books.isEmpty()}">
        <span>Book list is empty</span>
    </c:if>
    <c:if test="${!books.isEmpty() && books != null}">
        <table>
            <tr>
                <th>Book Name</th>
                <th>Author Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.getBookName()}</td>
                    <td>${book.getAuthorName()}</td>
                    <td><a href="/editBook?bookId=${book.getId()}">Edit</a>/
                        <a href="/deleteBook?bookId=${book.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:choose>
        <c:when test="${user.getUserRole().name().equals('ADMIN')}">
            <a href="/admin">Back</a>
        </c:when>

        <c:otherwise>
            <br>
            <h4>Data base is empty</h4>
            <a href="/"> Home</a>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
