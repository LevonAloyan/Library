<%@ page import="com.epam.library.model.Book" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--

  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.10.2023
  Time: 2:49
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registration or Sign Up form in HTML CSS | CodingLab </title>
    <link rel="stylesheet" href="css/style.css">
    <title>Edit Book</title>
</head>
<body>
<c:set var="bookToEdit" value="${requestScope.bookToEdit}"/>
<div class="wrapper">
<h1>Edit Books</h1>
<br>
    <form action="/editBooks" method="post">
        <div class="input-box">
            <input name="bookName" type="text" placeholder="Enter book name" required value="${bookToEdit.bookName}">
        </div>
        <div class="input-box">
            <input name="authorName" type="text" placeholder="Enter author name" required value="${bookToEdit.authorName}">
        </div>
        <input type="hidden" name="bookId" value="${bookToEdit.id}">

        <div class="input-box button">
            <input type="Submit" value="Edit book">
        </div>
        <div class="text">
            <h3>Back to login page? <a href="/">Login now</a></h3>
        </div>
    <br>
    </form>
<p><a href="/allBooks">Back to All Books</a></p>
</div>
</body>
</html>