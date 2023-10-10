<%@ page import="com.epam.library.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.library.model.Book" %>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> All users </title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");%>
<div class="wrapper">
    <h2>All books</h2>
    <br>
    <table>
        <tr>
            <th>User Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%for (Book book : books) {%>
        <tr>
            <td><%=book.getBookName()%> <%=book.getAuthorName()%></td>
            <td><a href="/editUsers?userId=<%=book.getId()%>">Edit</a></td>
            <td><a href="/deleteUsers?userId=<%=book.getId()%>">Delete</a></td>
        </tr>
        <%}%>
    </table>
    <br>
    <div class="#">
        <a href="/assign">Assign book to user</a><br>
        <a href="/unassigned">UnAssign book</a><br>
    </div>
</div>




</body>
</html>
