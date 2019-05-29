<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 27.04.2019
  Time: 1:31
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

    <h1><fmt:message key="page.login_in_system"/></h1>

    <form action="${urlPrefix}/publicutilities/main" method="post" name="login">
        <input type="hidden" name="command" value="login"/>
        <fmt:message key="authorization.login"/>:<br>
        <input type="text" name="account_login"><br>
        <fmt:message key="authorization.password"/><br>
        <input type="password" name="account_password"> <br>
        <input type="submit" value="<fmt:message key="authorization.signin"/>">
    </form>

    <form action="${urlPrefix}/publicutilities/main" method="get" name="getregistrationpage">
        <input type="hidden" name="command" value="getregistrationpage"/>
        <input type="submit" value="<fmt:message key="authorization.signup"/>">
    </form>

</body>
</html>
