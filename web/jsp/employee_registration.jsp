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

<html>
<head>
    <title>Title</title>
</head>
<body>
<p1>Employee registration</p1>

<form action="${urlPrefix}/publicutilities/main" method="post" name="registration">
    <input type="hidden" name="command" value="registrateemployee"/>

    Login:<br>
    <input type="text" name="account_login"><br>

    Password:<br>
    <input type="password" name="account_password"><br>

    Surname:<br>
    <input type="text" name="employee_surname"><br>

    Name:<br>
    <input type="text" name="employee_name"><br>

    Patronymic:<br>
    <input type="text" name="employee_patronymic"><br>

    Employee state:<br>
    <select name="role_name">
        <option value="OPERATOR">Operator</option>
        <option value="WORKER">Worker</option>
    </select> <br>

    <input type="submit" value="Send">
</form>
</body>
</html>
