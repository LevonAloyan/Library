<%@ page import="com.epam.library.model.User" %>
<%@ page import="com.epam.library.model.Book" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registration or Sign Up form in HTML CSS | CodingLab </title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<div class="wrapper">
    <h2>Welcome <%=((User) session.getAttribute("user")).getName()%>
    </h2>
</div>
<h3>Your Books:</h3>
<% List<Book> books = (List<Book>) session.getAttribute("books");
    User user = ((User) session.getAttribute("user"));%>
%>
<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Author</th>
    </tr>
    </thead>
    <tbody>

    <% for (Book book : books) {
        if (book.getUserId() == user.getId())%>
    <tr>
        <td><%= book.getBookName() %>
        </td>
        <td><%= book.getAuthorName() %>
        </td>
    </tr>
    </tbody>
    <% } %>
</table>
<div class="web-field">
    <a href="/my-account">Back</a><br>
</div>
</form>
</body>
</html>
