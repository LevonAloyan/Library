<%--
  Created by IntelliJ IDEA.
  User: Noname
  Date: 9/23/2023
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
    <h1>Error</h1>
</head>
<body>
<% String msg = (String) request.getAttribute("msg");
%>
<% if (msg != null) { %>
<p style="color: red"><%=msg%>
</p>
<% } %>

<% String msgForPassword = (String) request.getAttribute("msgForPassword");
%>
<% if (msgForPassword != null) { %>
<p style="color: red"><%=msgForPassword%>
</p>
<% } %>

<% String msgForAge = (String) request.getAttribute("msgForAge");
%>
<% if (msgForAge != null) { %>
<p style="color: red"><%=msgForAge%>
</p>
<% } %>

<p><a href="/">Back to Registration</a></p>
</body>
</html>
