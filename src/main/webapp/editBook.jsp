<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admins dashboard</title>
  <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<div class="wrapper">
  <form action="/book/edit" method="post">
    <c:set var="book" value="${book}"/>
    <div class="input-box">
      <input name="bookId" type="hidden" value="${book.id}" required>
    </div>
    <div class="input-box">
      <input name="bookName" type="text" placeholder="Enter book's name" value="${book.bookName}" required>
    </div>
    <div class="input-box">
      <input name="authorName" type="text" placeholder="Enter book's author name" value="${book.authorName}" required>
    </div>
    <br>
    <div class="input-box button">
      <input type="submit" value="Edit">
    </div>
  </form>
  <div class="webcolor-field">
    <p><a href="/assign">Assign book to user</a></p>
    <p><a href="/add-book">Assign book to user</a></p>
    <p><a href="/">Back</a></p><br>
  </div>
</div>
</body>
</html>