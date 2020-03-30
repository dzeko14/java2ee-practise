<%--
  Created by IntelliJ IDEA.
  User: dzeko14
  Date: 28.03.20
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<c:if test="${regError}">
    <h3><span style="color:red"> Не вдалося зареєструвати користувача, спробуйте ще раз</span></h3>
</c:if>
<form action="registration" method="POST">
    Номер телефону: <input type="text" name="phone"/><br/>
    Ім'я: <input type="text" name="name"/><br/>
    Пароль: <input type="password" name="password">
    <input type="submit" value="Зареєструватися">
</form>
</body>
</html>
