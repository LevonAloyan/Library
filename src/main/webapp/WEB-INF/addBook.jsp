<%--
  Created by IntelliJ IDEA.
  User: radik
  Date: 13.10.2023
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add book</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<div class="wrapper">
    <h2>Add book</h2>
    <form action="/book/add" method="post">
        <div class="input-box">
            <input name="book_name" type="text" placeholder="Enter book name" required>
            <input name="author_name" type="text" placeholder="Enter author name" required>
        </div>
        <button type="submit">Add</button>
    </form>
    <a href="/admin">Back</a>
</div>

</body>
</html>
