<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 20.05.2019
  Time: 19:32
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
</head>
<body>
    <h1><fmt:message key="page.create_order"/></h1>

    <form action="${urlPrefix}/publicutilities/main" method="post" name="createorder">
        <input type="hidden" name="command" value="createorder"/>

        <fmt:message key="order.desired_date"/>:<br>
        <input type="date" name="order_desired_date" min="2019-05-23" max="9999-12-31"><br>

        <fmt:message key="order.desired_time"/>:<br>
        <input type="time" name="order_desired_time"><br>

        <fmt:message key="table.order_description"/>:<br>
        <input type="text" name="order_description"><br>

        <input type="submit" value="<fmt:message key="button.create_order"/>">
    </form>

</body>
</html>
