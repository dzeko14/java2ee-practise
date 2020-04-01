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
    <h3>Деталі про замовлене тренування</h3>
    <br />
    Тренер: ${training.coach.name}
    <br />
    Кількість тренувань:  ${training.amount}
    <br />
</body>
</html>
