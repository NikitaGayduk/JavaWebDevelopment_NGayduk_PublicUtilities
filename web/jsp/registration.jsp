<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 28.04.2019
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Registration in system</h1>

    <form action="${urlPrefix}/publicutilities" method="post" name="registration">
        <input type="hidden" name="command" value="registration"/>

        Login:<br>
        <input type="text" name="login"><br>

        Password:<br>
        <input type="password" name="password">

        Surname:<br>
        <input type="text" name="tenant_surname"><br>

        Name:<br>
        <input type="text" name="tenant_name"><br>

        Patronymic:<br>
        <input type="text" name="patronymic_name"><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
