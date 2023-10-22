<%@ page import="com.epam.library.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Zmix
  Date: 21.10.2023
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="wrapper">
  <h2>Welcome</h2>
    <%=((User) session.getAttribute("user")).getName()%>
</div>
</body>
</html>
