<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13.10.2023
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.epam.library.model.User" %>
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
    <h2>Welcome</h2>
    <%=((User)session.getAttribute("user")).getName()%>
</div>

</body>
</html>