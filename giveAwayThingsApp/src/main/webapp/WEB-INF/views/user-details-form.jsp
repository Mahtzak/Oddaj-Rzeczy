<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 20.02.2019
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zmiana danych użytkownika</title>

</head>
<body>
    <div>
        <form:form modelAttribute="userDetails">
            Imię:<form:input path="firstName"/><form:errors path="firstName"/><br>
            Nazwisko:<form:input path="lastName"/><form:errors path="lastName"/><br>
            Adres:<form:input path="address"/><form:errors path="address"/><br>
            Telefon kontaktowy:<form:input path="phoneNumber"/><form:errors path="phoneNumber"/><br>
            <input type="submit" value="Zapisz"/>
            <input type="reset" value="Cofnij zmiany"/>
        </form:form>
    </div>
</body>
</html>
