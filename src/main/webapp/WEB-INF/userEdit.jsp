<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> User Edit</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <h2>User Edit</h2>
    <form action="/editUser" method="post">
        <div class="selectedUser">
            <div class="input-box">
                <input type="hidden" name="userId" value="${user.id}">
            </div>
            <div class="input-box">
                <input name="name" type="text" value="${user.name}">
            </div>
            <div class="input-box">
                <input name="lastName" type="text" value="${user.lastName}">
            </div>
            <div class="input-box">
                <input name="email" type="text" value="${user.email}">
            </div>
            <div class="input-box">
                <input name="user_role" type="text" value="${user.userRole}">
            </div>
        </div>

        <div class="input-box button">
            <input type="Submit" value="Edit and Save">
        </div>
    </form>
</div>

</body>
</html>