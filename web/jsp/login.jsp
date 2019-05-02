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

    <form action="${urlPrefix}/publicutilities" method="post" name="login">
        Login:<br>
        <input type="text" name="login" value="Login"><br>
        Password:<br>
        <input type="password" name="password">
        <input type="submit" value="Submit">
    </form>

</body>
</html>
