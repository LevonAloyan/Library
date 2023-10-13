<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> All books </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel='stylesheet' type='text/css' href='css/tableStyle.css'/>
</head>
<body>
<div class="wrapper">
    <h2>All assign books</h2>
    <br>
    <c:choose>
        <c:when test="${!assignBooks.isEmpty()}">
            <table>
                <tr>
                    <th>Book Name</th>
                    <th>Author Name</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${assignBooks}" var="book">
                    <tr>
                        <td>${book.getBookName()}</td>
                        <td>${book.getAuthorName()}</td>
                        <td>
                            <form method="post" action="/assign_books" style="display: flex; margin-top: 0px">
                                <div>
                                    <input type="hidden" name="book_id" value="${book.getId()}" />
                                </div>
                                <div>
                                    <input type="submit" value="Unassign Books"/>
                                </div>
                            </form>

                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <c:otherwise>
            <span>No assigned books</span>
        </c:otherwise>
    </c:choose>

    <br>
    <a href="/admin">Back</a>
</div>

</body>
</html>
