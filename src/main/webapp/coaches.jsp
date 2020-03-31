<%--
  Created by IntelliJ IDEA.
  User: dzeko14
  Date: 31.03.20
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Coaches</title>
</head>
<body>
<table border="1">
    <caption><h3>Список вендорів</h3></caption>
    <tr>
        <th>Телефон</th>
        <th> Ім'я </th>
        <th> Адреса залу</th>
    </tr>
    <c:forEach var="coach" items="${coaches}">
        <tr>
            <td>${coach.phoneNumber}</td>
            <td>${coach.name}</td>
            <td>${coach.gymAddress}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
