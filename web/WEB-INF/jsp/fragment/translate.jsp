<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 19.05.2019
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="L10n" />

<html lang="${language}">
<head>
    <title>Title</title>
</head>
<body>
<div style="float: right; padding: 10px;">

    <form action="${urlPrefix}/publicutilities/main" method="post">
        <input type="hidden" name="command" value="changeLocale"/>
        <input name="command" value="changeLocale" type="hidden">
        <input name="language" value="ru" type="hidden">
        <input type="submit" class="AccountButton" value="RU"/>
    </form>

    <form action="${urlPrefix}/publicutilities/main" method="post">
        <input name="command" value="changeLocale" type="hidden">
        <input name="language" value="en" type="hidden">
        <input type="submit" class="AccountButton" value="EN"/>
    </form>

</div>

</body>
</html>
