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
<d1>Team consist</d1>
<table>
    <tr>
        <td>Surname</td>
        <td>Name</td>
        <td>Patronymic</td>
    </tr>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td><c:out value="${employee.getEmployeeSurname()}"/></td>
            <td><c:out value="${employee.getEmployeeName()}"/></td>
            <td><c:out value="${employee.getEmployeePatronymic()}"/></td>
        </tr>
    </c:forEach>
</table>

<d1>Available workers</d1>
<table>
    <tr>
        <td>Surname</td>
        <td>Name</td>
        <td>Patronymic</td>
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

                    <input type="submit" value="Add">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="${urlPrefix}/publicutilities/main" method="post" name="getoperatormainpage">
    <input type="hidden" name="command" value="getoperatormainpage"/>

    <input type="submit" value="На главную">
</form>
</body>
</html>
