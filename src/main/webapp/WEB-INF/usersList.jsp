<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> All users </title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <h2>All users</h2>
    <br>
    <p>
        <c:out value="${sessionScope.user.name}"/>
    </p>
    <table>
        <tr>
            <th>User Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.name} ${user.lastName}</td>
                <td><a href="/editUsers?userId=${user.id}">Edit</a></td>
                <td><a href="/deleteUsers?userId=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/">Login</a>
</div>

<%--Select -> list of users--%>
<%--Select ->  list of books--%>

<%--button assign--%>


</body>
</html>
