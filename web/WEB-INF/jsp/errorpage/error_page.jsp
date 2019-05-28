<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 26.04.2019
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${from_handler}">
        <ul>
            <c:if test="${not empty statusCode}">
                <li>${statusCode}</li>
            </c:if>
            <c:if test="${not empty exceptionName}">
                <li>${exceptionName}</li>
            </c:if>
            <c:if test="${not empty message}">
                <li>${message}</li>
            </c:if>
            <c:if test="${not empty requsetUri}">
                <li> </strong>${requestUri}</li>
            </c:if>
        </ul>
    </c:when>
    <c:otherwise>
        <br><br>
        <h3>error</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
