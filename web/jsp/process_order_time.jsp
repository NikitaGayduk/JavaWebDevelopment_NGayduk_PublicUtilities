<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 26.05.2019
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td>Order desired time</td>
            <td>Order discription</td>
        </tr>
            <tr>
                <td><c:out value="${order.getDesiredTime().toString()}" /></td>
                <td><c:out value="${order.getOrderDiscription()}" /></td>
            </tr>
    </table>

    <form action="${urlPrefix}/publicutilities/main" method="post" name="executeorder">
        <input type="hidden" name="command" value="processordertime"/>
        <input type="hidden" name="order_id" value="${order.getId()}"/>
        <input type="hidden" name="order_state" value="WAITING_EXECUTION"/>

        Begin date:<br>
        <input type="date" name="order_works_begin_date" min="2019-05-23" max="9999-12-31"><br>

        Begin time:<br>
        <input type="time" name="order_works_begin_time"><br>

        End date:<br>
        <input type="date" name="order_works_end_date" min="${order_works_begin_date}" max="9999-12-31"><br>

        End time:<br>
        <input type="time" name="order_works_end_time" min="${order_works_begin_time}"><br>

        <input type="submit" value="Execute">
    </form>
</body>
</html>
