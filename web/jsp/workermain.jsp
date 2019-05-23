<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 09.05.2019
  Time: 1:30
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
    <h1>Worker main page</h1>

    <table>
        <tr>
            <td>Works Begin</td>
            <td>Order discription</td>
            <td>Tenant surname</td>
            <td>Tenant name</td>
            <td>Tenant patronymic</td>
            <td>Tenant street</td>
            <td>Tenant house number</td>
            <td>Tenant apartments number</td>
        </tr>
        <c:forEach items="${orderList}" var="order">
            <c:set var = "tenant" value = "${tenantMap.get(order.getTenantID())}"/>
            <c:set var = "address" value = "${addressMap.get(tenant.getAddressID())}"/>
            <tr>
                <td><c:out value="${order.getWorksBegin().toString()}" /></td>
                <td><c:out value="${order.getOrderDiscription()}" /></td>
                <td><c:out value="${tenant.getSurname()}" /></td>
                <td><c:out value="${tenant.getName()}" /></td>
                <td><c:out value="${tenant.getPatronymic()}" /></td>
                <td><c:out value="${address.getStreet()}" /></td>
                <td><c:out value="${address.getHouse()}" /></td>
                <td><c:out value="${address.getApartments()}" /></td>
                <td>
                    <form action="${urlPrefix}/publicutilities/main" method="post" name="executeorder">
                        <input type="hidden" name="command" value="changeorderstate"/>
                        <input type="hidden" name="order_state" value="EXECUTED"/>
                        <input type="hidden" name="order_id" value="${order.getId()}"/>
                        <input type="submit" value="Executed">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
