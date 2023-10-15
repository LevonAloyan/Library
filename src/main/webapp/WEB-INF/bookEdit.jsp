<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Book Edit </title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="wrapper">
    <h2>Book Edit</h2>
    <form action="/editBook" method="post">
        <div class="selectedBookr">
            <div class="input-box">
                <input type="hidden" name="bookId" value="${book.id}">
            </div>
            <div class="input-box">
                <input name="name" type="text" value="${book.bookName}">
            </div>
            <div class="input-box">
                <input name="authorName" type="text" value="${book.authorName}">
            </div>
            <div class="input-box">
                <input name="userId" type="text" value="${book.userId}">
            </div>

        </div>

        <div class="input-box button">
            <input type="Submit" value="Edit and Save">
        </div>
    </form>
</div>

</body>
</html>