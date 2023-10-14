<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 37455
  Date: 10/14/2023
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <td>${user.name}</td>
        <td>${user.lastName}</td>
        <td>${user.email}</td>

    </c:forEach>


</div>
</body>
</html>
