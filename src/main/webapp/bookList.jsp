<%@ page import="com.epam.library.model.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Zmix
  Date: 03.11.2023
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration or Sign up form in HTML CSS | CodingLab</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
 <%List<Book> allBooks=(List<Book>)request.getAttribute("allBooks"); %>
 <div class="wrapper">
     <h2>All users</h2>
     <br>
     <table>
         <tr>
             <th>Book name</th>
             <th>Edit</th>
             <th>Delete</th>
         </tr>
         <% for (Book book : allBooks) {%>
         <tr>
             <td><%=book.getBookName()%> <%=book.getAuthorName()%></td>
             <td><a href="/editBooks?bookId=<%=book.getId()%>"> Edit</a></td>
             <td><a href="/deleteBooks?bookId=<%=book.getId()%>"> Delete</a></td>
         </tr>
         <%}%>
     </table>
 </div>
</body>
</html>
