<%@ page import="com.epam.library.model.User" %>
<%@ page import="com.epam.library.model.Book" %>
<%@ page import="com.epam.library.manager.impl.BookManagerImpl" %>
<%@ page import="com.epam.library.manager.BookManager" %>
<%@ page import="java.util.List" %>
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

<%--List of all your book--%>
<div class="book-list">
    <h3>Your Books</h3>
    <ul>
        <%
            BookManager<Integer, Book> bookManager = new BookManagerImpl();
            User user = (User) session.getAttribute("user");
            List<Book> userBooks = (List<Book>) bookManager.getById(user.getId());

            for (Book book : userBooks) {
                if (book.getUserId() == user.getId())
        %>
        <li><%= book.getBookName() %> by <%= book.getAuthorName() %></li>
        <%
            }
        %>
    </ul>

</div>
</body>
</html>
