<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registration or Sign Up form in HTML CSS | CodingLab </title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <h2>Admin</h2>

    <form action="/assign" method="post">
        <c:if test="${requestScope.successAssign != null}">
            <span style="color: green"><c:out value="${requestScope.successAssign}"/></span>

        </c:if>
        <div class="input-box">
            <label for="selectuser"> Select User:
                <select name="selectedUser" id="selectuser">
                    <c:forEach var="user" items="${users}">
                        <option value="${user.id}"> ${user.name} ${user.lastName}
                        </option>
                    </c:forEach>
                </select>
            </label>
        </div>

        <br>
        <div class="input-box">
            <label for="selectbook"> Select Book:
                <select name="selectedBook" id="selectbook">
                    <c:forEach var="book" items="${unassignedBooks}">
                        <option value="${book.id}">${book.bookName}/${book.authorName}
                        </option>
                    </c:forEach>
                </select>
            </label>
        </div>

        <br>
        <div class="input-box button">
            <input type="submit" value="Assign">
        </div>
    </form>

    <ul>
        <li><a href="/">Login Page</a>
        </li>
        <li><a href="/users">Show all users</a>
        </li>
        <li><a href="/books">Show all books</a>
        </li>
        <li><a href="/assignedBooks">Show assigned books</a>
        </li>
    </ul>
</div>
</body>
</html>
