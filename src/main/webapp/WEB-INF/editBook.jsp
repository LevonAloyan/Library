<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Edit User </title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <h2>Edit Book</h2>
    <br>
    <form action="/editBook" method="post">
        <input name="book_id" type="hidden" value="${bookToEdit.getId()}"/>
        <div class="input-box">
            <input name="book_name" type="text" placeholder="Enter book name" required
                   value="${bookToEdit.getBookName()}">
        </div>
        <div class="input-box">
            <input name="author_name" type="text" placeholder="Enter author name" required
                   value="${bookToEdit.getAuthorName()}">
        </div>

        <div class="input-box button">
            <input type="Submit" value="Edit book">
        </div>
        <div class="text">
            <h3>Back to login page? <a href="/books">Back to books list</a></h3>
        </div>
    </form>
    <br>
    <a href="/books">Back</a>
</div>

</body>
</html>
