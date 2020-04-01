<%--
  Created by IntelliJ IDEA.
  User: dzeko14
  Date: 01.04.20
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Оновити тренування</h3>
<form action="updateTraining" method="POST">
    <input type="hidden" name="id" value="${training.id}"/><br/>
    <label for="quantity">Кількість (від 1 до 10):</label>
    <input type="number" id="quantity" name="quantity" value="${training.amount}" min="1" max="10">
    <input type="submit" value="Оновити">
</form>
</body>
</html>
