<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.Book" %>
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
<%
    List<Book> assignedBookList = (List<Book>) request.getAttribute("assignedBooks");


%>
<div class="wrapper">
    <h2>All assigned books</h2>
    <br>
    <table>
        <tr>
            <th>Book name</th>
            <th>Author name</th>
            <th>Unassign</th>
        </tr>
        <% for (Book assaignedBook : assignedBookList) {
        %>
        <tr>
            <td><%=assaignedBook.getBookName()%></td>
            <td><%=assaignedBook.getAuthorName()%></td>
            <td><a href="/unassignBook?bookId=<%=assaignedBook.getId()%>">Unassign</a></td>
        <tr/>
        <%}%>
    </table>

    <br>
    <br>
    <br>
    <br>
    <a href="/">Login</a>

</div>


</body>
</html>