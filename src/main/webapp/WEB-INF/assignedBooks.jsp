<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registration or Sign Up form in HTML CSS | CodingLab </title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <h2>All assigned books</h2>
    <br>
    <table>
        <tr>
            <th>Book name</th>
            <th>Author name</th>
            <th>Unassign</th>
        </tr>
        <c:forEach var="assaignedBook" items="${sessionScope.assignedBooks}">
            <tr>
                <td>${assaignedBook.bookName}</td>
                <td>${assaignedBook.authorName}</td>
                <td><a href="/unassignBook?bookId=${assaignedBook.id}">Unassign</a></td>
            <tr/>
        </c:forEach>
    </table>
    <br>
    <br>
    <br>
    <br>
    <a href="/">Login</a>

</div>
</body>
</html>