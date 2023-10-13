<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up form</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <h2>Sign Up</h2>
    <form action="/login" method="post">
        <c:if test="${not empty requestScope.loginError}">
            <span style="color: red"> ${requestScope.loginError}</span></c:if>
        <div class="input-box">
            <input name="email" type="text" placeholder="Enter your email" required>
        </div>
        <div class="input-box">
            <input name="password" type="password" placeholder="Create password" required>
        </div>
        <div class="input-box button">
            <input type="Submit" value="Sign Up">
        </div>
        <div class="text">
            <h3>Does not have an account? <a href="/registerPage">Register now</a></h3>
        </div>
    </form>
</div>

</body>
</html>
