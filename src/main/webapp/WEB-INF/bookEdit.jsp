<%@ page import="com.epam.library.model.Book" %>
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
<%
    Book book = (Book) request.getAttribute("book");
%>
<div class="wrapper">
    <h2>Book Edit</h2>
    <form action="/editBook" method="post">
        <div class="selectedBookr">
            <div class="input-box">
                <input type="hidden" name="bookId" value="<%=book.getId()%>">
            </div>
            <div class="input-box">
            <input name="name" type="text" value="<%=book.getBookName()%>">
            </div>
            <div class="input-box">
                <input name="authorName" type="text" value="<%=book.getAuthorName()%>">
            </div>
            <div class="input-box">
                <input name="userId" type="text" value="<%=book.getUserId()%>">
            </div>

        </div>

        <div class="input-box button">
            <input type="Submit" value="Edit and Save">
        </div>
    </form>
</div>

</body>
</html>