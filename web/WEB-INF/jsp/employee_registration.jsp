<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 25.05.2019
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="fragment/translate.jsp" %>
<%@ include file="fragment/logout.jsp" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p1><fmt:message key="page.employee_registration"/></p1>

<form action="${urlPrefix}/publicutilities/main" method="post" name="registration">
    <input type="hidden" name="command" value="registrateemployee"/>

    <fmt:message key="authorization.login"/>:<br>
    <input type="text" name="account_login"><br>

    <fmt:message key="authorization.password"/>:<br>
    <input type="password" name="account_password"><br>

    <fmt:message key="table.surname"/>:<br>
    <input type="text" name="surname"><br>

    <fmt:message key="table.name"/>:<br>
    <input type="text" name="name"><br>

    <fmt:message key="table.patronymic"/>:<br>
    <input type="text" name="patronymic"><br>

    <fmt:message key="table.role"/>:<br>
    <select name="role_name">
        <option value="OPERATOR">Operator</option>
        <option value="WORKER">Worker</option>
    </select> <br>

    <input type="submit" value="<fmt:message key="button.registrate"/>">
</form>
</body>
</html>
