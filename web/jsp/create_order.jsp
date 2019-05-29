<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 20.05.2019
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Create order</h1>

    <form action="${urlPrefix}/publicutilities/main" method="post" name="createorder">
        <input type="hidden" name="command" value="createorder"/>

        Desired date:<br>
        <input type="date" name="order_desired_date" min="2019-05-23" max="9999-12-31"><br>

        Desired time:<br>
        <input type="time" name="order_desired_time"><br>

        Order discription:<br>
        <input type="text" name="order_description"><br>

        <input type="submit" value="Create">
    </form>

</body>
</html>
