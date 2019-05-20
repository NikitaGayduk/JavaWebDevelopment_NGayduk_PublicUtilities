<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 08.05.2019
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="fragment/header.jsp" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Tenant main page</h1>

    <form action="${urlPrefix}/publicutilities/main" method="post" name="getordercreatepage">
        <input type="hidden" name="command" value="getordercreatepage"/>
        <input type="submit" value="Create order">
    </form>

</body>
</html>
