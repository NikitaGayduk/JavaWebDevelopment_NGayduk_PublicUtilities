<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 09.05.2019
  Time: 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Worker main page</h1>

    <form action="${urlPrefix}/publicutilities/main" method="get" name="logout">
        <input type="hidden" name="command" value="logout"/>
        <input type="submit" value="Выход">
    </form>
</body>
</html>
