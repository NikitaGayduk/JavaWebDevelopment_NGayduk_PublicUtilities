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
    <h1>Admin main page</h1>

    <table>
        <tr>
            <td>Surname</td>
            <td>Name</td>
            <td>Patronymic</td>
            <td>Role</td>
        </tr>
        <c:forEach items="${employeeList}" var="employee">
            <c:set var = "account" value = "${accountMap.get(employee.getAccountID())}"/>
            <tr>
                <td><c:out value="${employee.getEmployeeSurname()}" /></td>
                <td><c:out value="${employee.getEmployeeName()}" /></td>
                <td><c:out value="${employee.getEmployeePatronymic()}" /></td>
                <td><c:out value="${account.getRole()}" /></td>
                <td>
                    <form action="${urlPrefix}/publicutilities/main" method="post" name="dismissemployee">
                        <input type="hidden" name="command" value="changeemployeestate"/>
                        <input type="hidden" name="employee_state" value="FIRED"/>
                        <input type="hidden" name="employee_id" value="${employee.getId()}"/>
                        <input type="submit" value="Dismiss">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <form action="${urlPrefix}/publicutilities/main" method="post" name="getemployeeregistrationpage">
        <input type="hidden" name="command" value="getemployeeregistrationpage"/>
        <input type="submit" value="Registrate employee">
    </form>

</body>
</html>
