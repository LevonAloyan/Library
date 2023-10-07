<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.Book" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registration or Sign Up form in HTML CSS | CodingLab </title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    List<Book> assignedBookList = (List<Book>) session.getAttribute("assignedBooks");

%>
<div class="wrapper">
    <h2>All assigned books</h2>

    <div class="input-box">

        <% for (Book assaignedBook : assignedBookList) {
        %>
        <option name="selectedBook" id="selectbook"
                value="<%=assaignedBook.getId()%>"><%=assaignedBook.getBookName()%> <%=assaignedBook.getAuthorName()%>
                <a href="/unassignBook?bookId=<%=assaignedBook.getId()%>">Unassign</a>

        </option>

        <%}%>
    </div>

    <br>
    <br>
    <br>
    <br>
    <a href="/">Login</a>

</div>


</body>
</html>