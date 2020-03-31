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
    <caption><h3>Записи</h3></caption>
    <tr>
        <th>Дата</th>
        <th> Ім'я </th>
        <th></th>
    </tr>
    <c:forEach var="record" items="${records}">
        <tr>
            <td>${record.date}</td>
            <td>${record.userName}</td>
            <td><c:if test="${user.phoneNumber == record.userPhone}"><a href="/=${coach.phoneNumber}">Видалити</a></c:if></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
