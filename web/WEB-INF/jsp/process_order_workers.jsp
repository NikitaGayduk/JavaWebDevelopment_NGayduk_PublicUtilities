<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 27.05.2019
  Time: 1:06
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

<d1><fmt:message key="order.team_consist"/></d1>

<table>
    <tr>
        <td><fmt:message key="table.surname"/></td>
        <td><fmt:message key="table.name"/></td>
        <td><fmt:message key="table.patronymic"/></td>
    </tr>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td><c:out value="${employee.getEmployeeSurname()}"/></td>
            <td><c:out value="${employee.getEmployeeName()}"/></td>
            <td><c:out value="${employee.getEmployeePatronymic()}"/></td>
        </tr>
    </c:forEach>
</table>

<d1><fmt:message key="order.available_workers"/></d1>
<table>
    <tr>
        <td><fmt:message key="table.surname"/></td>
        <td><fmt:message key="table.name"/></td>
        <td><fmt:message key="table.patronymic"/></td>
    </tr>
    <c:forEach items="${freeEmployeeList}" var="employee">
        <tr>
            <td><c:out value="${employee.getEmployeeSurname()}"/></td>
            <td><c:out value="${employee.getEmployeeName()}"/></td>
            <td><c:out value="${employee.getEmployeePatronymic()}"/></td>
            <td>
                <form action="${urlPrefix}/publicutilities/main" method="post" name="setorderworker">
                    <input type="hidden" name="command" value="setorderworker"/>
                    <input type="hidden" name="employee_id" value="${employee.getId()}"/>
                    <input type="hidden" name="order_id" value="${order.getId()}"/>

                    <input type="submit" value="<fmt:message key="button.add"/>">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="${urlPrefix}/publicutilities/main" method="post" name="getoperatormainpage">
    <input type="hidden" name="command" value="getoperatormainpage"/>

    <input type="submit" value="<fmt:message key="button.go_main"/>">
</form>
</body>
</html>
