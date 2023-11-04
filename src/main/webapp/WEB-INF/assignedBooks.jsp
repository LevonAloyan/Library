<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.Book" %>
<%@ page import="com.epam.library.manager.impl.UserManagerImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up form</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
<h2>All Books</h2>
<br>
<table>

<c:forEach var="book" items="${sessionScope.assignedBooks}">
    <tr>
        <td>${book.bookName}</td>
        <c:forEach var="user" items="${sessionScope.users}">
            <c:if test="${user.id == book.userId}">
                <td>${user.name}</td>
                <td>${user.lastName}</td>
            </c:if>
        </c:forEach>
        <td><a href="/unAssignBook?bookId=${book.id} %>">Unassign</a></td>
        </tr>
    </c:forEach>
    <c:if test="${not empty requestScope.unassignError}">

    <span style="color: red">${requestScope.unassignError}</span>
    </c:if>
    <c:if test="${not empty requestScope.unassignSuccess}">

    <span style="color: green">${requestScope.unassignSuccess}</span>
    </c:if>
    </table>
    <br>
    <a href="/">Login</a>
    </div>
    <%!
        private User getUserForBook(List<User> userList, Book book) {
            for (User user : userList) {
                if (user.getId() == book.getUserId()) {
                    return user;
                }
            }
            return null;
        }
    %>
    </body>
    </html>

