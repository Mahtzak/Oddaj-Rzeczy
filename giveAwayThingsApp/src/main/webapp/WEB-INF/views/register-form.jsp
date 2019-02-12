<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 12.02.2019
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form:form modelAttribute="user" method="post">
            Nazwa użytkownika:<form:input path="username"/><form:errors path="username"/><br>
            Email:<form:input path="email"/><form:errors path="email"/><br>
            Hasło:<form:password path="password"/><form:errors path="password"/><br>
            Powtórz hasło:<form:password path="confirmedPassword"/><form:errors path="confirmedPassword"/><br>
            <input type="submit" value="Wyślij"/>
            <input type="reset" value="Reset"/>
        </form:form>
    </div>
</body>
</html>
