<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 09.05.2019
  Time: 1:29
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
    <h1>Operator main page</h1>
    <table>
        <tr>
            <td>Desired time</td>
            <td>Order discription</td>
        </tr>
        <c:forEach items="${orderList}" var="order">
            <tr>
                <td><c:out value="${order.getDesiredTime()}" /></td>
                <td><c:out value="${order.getOrderDiscription()}" /></td>

                <td>
                    <form action="${urlPrefix}/publicutilities/main" method="post" name="processorder">
                        <input type="hidden" name="command" value="processorder"/>
                        <input type="hidden" name="order_id" value="${order.getId()}"/>
                        <input type="submit" value="Process">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
