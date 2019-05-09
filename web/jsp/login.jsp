<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 27.04.2019
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Logging to system</h1>

    <form action="${urlPrefix}/publicutilities/main" method="post" name="login">
        <input type="hidden" name="command" value="login"/>
        Login:<br>
        <input type="text" name="login"><br>
        Password:<br>
        <input type="password" name="password"> <br>
        <input type="submit" value="Вход">
    </form>

    <form action="${urlPrefix}/publicutilities/main" method="get" name="goregistration">
        <input type="hidden" name="command" value="getregistrationpage"/>
        <input type="submit" value="Регистрация">
    </form>

</body>
</html>
