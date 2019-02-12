<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 12.02.2019
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona główna</title>
</head>
<body>
    <sec:authorize access="isAuthenticated()">
        Zalogowano
    </sec:authorize>
    <div>
        <a href="/login">Zaloguj się</a>
        <a href="/register">Załóż konto</a>
    </div>
    <h1>Hello World</h1>
</body>
</html>
