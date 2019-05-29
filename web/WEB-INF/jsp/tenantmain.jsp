<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 08.05.2019
  Time: 15:23
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
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

    <h1><fmt:message key="page.tenant_main_page"/></h1>

    <table>
        <tr>
            <td><fmt:message key="table.order_desired_time"/></td>
            <td><fmt:message key="table.works_begin"/></td>
            <td><fmt:message key="table.order_description"/></td>
        </tr>
        <c:forEach items="${orderList}" var="order">
            <tr>
                <td><c:out value="${order.getDesiredTime().toString()}" /></td>
                <td><c:out value="${order.getWorksBegin().toString()}" /></td>
                <td><c:out value="${order.getOrderDiscription()}" /></td>
                <td>
                    <form action="${urlPrefix}/publicutilities/main" method="post" name="cancelorder">
                        <input type="hidden" name="command" value="changeorderstate"/>
                        <input type="hidden" name="order_state" value="CANCELED"/>
                        <input type="hidden" name="order_id" value="${order.getId()}"/>
                        <input type="submit" value="<fmt:message key="button.cancel_order"/>">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <form action="${urlPrefix}/publicutilities/main" method="post" name="getordercreatepage">
        <input type="hidden" name="command" value="getordercreatepage"/>
        <input type="submit" value="<fmt:message key="button.create_order"/>">
    </form>

</body>
</html>
