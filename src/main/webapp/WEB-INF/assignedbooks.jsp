<%@ page import="com.epam.library.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> All books </title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <h2>All books</h2>
    <br>
    <table>
        <c:forEach var="book" items="${sessionScope.assignedbooks}">
            <tr>
                <td>${book.bookName}</td>
                <c:forEach var="user" items="${sessionScope.users}">
                    <c:if test="${usr.id==book.userId}">
                        <td>${user.name}</td>
                        <td>${user.lastName}</td>
                    </c:if>
                </c:forEach>
                <a href="/unAssignBook?bookId=${book.id}">Unassign</a>
            </tr>
        </c:forEach>
        <c:if test="${not empty requestScope.unassignError}">

            <span style="color: red">${requestScope.unassignError}</span>
        </c:if>
        <c:if test="${not empty requestScope.unassignSuccess}">

            <span style="color: blueviolet">${requestScope.unassignSuccess}</span>
        </c:if>


    </table>
    <a href="/">Login</a>
</div>

</body>
</html>
