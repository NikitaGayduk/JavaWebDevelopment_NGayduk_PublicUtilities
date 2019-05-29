<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 28.04.2019
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="fragment/translate.jsp" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><fmt:message key="page.tenant_registration"/></h1>

    <form action="${urlPrefix}/publicutilities/main" method="post" name="registration">
        <input type="hidden" name="command" value="registration"/>

        <fmt:message key="authorization.login"/>:<br>
        <input type="text" name="account_login"><br>

        <fmt:message key="authorization.password"/>:<br>
        <input type="password" name="account_password"><br>

        <fmt:message key="table.surname"/>:<br>
        <input type="text" name="surname"><br>

        <fmt:message key="table.name"/>:<br>
        <input type="text" name="name"><br>

        <fmt:message key="table.patronymic"/>:<br>
        <input type="text" name="patronymic"><br>

        <fmt:message key="table.address"/>:<br>
        <select name="address_id">

            <c:forEach items="${addressList}" var="address">
                <option value="${address.getId()}">
                    <fmt:message key="table.street"/>
                    <c:out value="| ${address.getStreet()} |" />
                    <fmt:message key="table.house_number"/>
                    <c:out value="| ${address.getHouse()} |" />
                    <fmt:message key="table.apartments_number"/>
                    <c:out value="| ${address.getApartments()}" />
                </option>
            </c:forEach>
        </select> <br>

        <input type="submit" value="<fmt:message key="button.registrate"/>">
    </form>
</body>
</html>
