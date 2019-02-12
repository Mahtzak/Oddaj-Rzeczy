<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 12.02.2019
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>
<div>
    <c:if test="${param['error'] != null}">
        <span>Błędne dane logowania</span>
        <c:if test="${message != null}">
            <span>${message}</span>
        </c:if>
    </c:if>
    <form:form modelAttribute="user" method="post">
        Email:<form:input path="email"/><form:errors path="email"/><br>
        Hasło:<form:password path="password"/><form:errors path="password"/><br>
        <input type="submit" value="Zaloguj się"/>
    </form:form>
</div>
</body>
</html>
