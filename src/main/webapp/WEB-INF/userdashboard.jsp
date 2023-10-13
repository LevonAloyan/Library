<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registration or Sign Up form in HTML CSS | CodingLab </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel='stylesheet' type='text/css' href='css/tableStyle.css'/>
</head>
<body>
<div class="wrapper">
    <h2>Welcome</h2>
    <c:out value="${sessionScope.user.getName()}"/>

    <c:if test="${books.isEmpty()}">
        <span>Book list is empty</span>
    </c:if>
    <c:if test="${!myAssignedBooks.isEmpty() && myAssignedBooks != null}">
        <table>
            <tr>
                <th>Book Name</th>
                <th>Author Name</th>
            </tr>
            <c:forEach items="${myAssignedBooks}" var="book">
                <tr>
                    <td>${book.getBookName()}</td>
                    <td>${book.getAuthorName()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>

</body>
</html>
