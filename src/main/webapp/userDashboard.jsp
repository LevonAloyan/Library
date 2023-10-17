<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.epam.library.model.User" session="true" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User dashboard</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<div class="wrapper">
    <h2>Welcome <c:out value="${user.name}"/></h2>
    <h3>Books:</h3>
    <table>
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${userAllBooks}">
            <c:if test="${book.userId == user.id}">
                <tr>
                    <td>${book.bookName}
                    </td>
                    <td>${book.authorName}
                    </td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
    <div class="web-field">
        <a href="/">Back</a><br>
    </div>
</div>
</body>
</html>