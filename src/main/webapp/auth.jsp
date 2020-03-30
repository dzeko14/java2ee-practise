<%--
  Created by IntelliJ IDEA.
  User: dzeko14
  Date: 28.03.20
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gym</title>
</head>
<body>
<h1>Створити запис про вендора</h1>

<c:if test="${authError}">
    <h3><span style="color:red"> Не правильний номер телефона або парль</span></h3>
</c:if>

<form action="auth" method="POST">
    Номер телефону: <input type="text" name="phone"/><br/>
    Пароль: <input type="password" name="password">
    <input type="submit" value="Увійти">
</form>
<a href="registraion.jsp">Зареєструватися</a>
</body>
</html>
