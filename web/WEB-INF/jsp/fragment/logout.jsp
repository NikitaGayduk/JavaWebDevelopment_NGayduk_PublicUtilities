<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 29.05.2019
  Time: 10:18
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
<div style="float: right; padding: 10px;">
<form action="${urlPrefix}/publicutilities/main" method="get" name="logout">
    <input type="hidden" name="command" value="logout"/>

    <input type="submit" value="Выход">



</form>
</div>
</body>
</html>
