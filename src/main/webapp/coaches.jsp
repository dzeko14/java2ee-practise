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
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        body {
            font-family: "Poppins", sans-serif;
            height: 100vh;
            background-color: #4285bc;
        }
        .wrapper {
            display: flex;
            align-items: center;
            flex-direction: column;
            justify-content: center;
            width: 100%;
            padding: 20px;
            min-height: 100%;
        }
        #formContent {
            -webkit-border-radius: 10px 10px 10px 10px;
            border-radius: 10px 10px 10px 10px;
            background: #fff;
            position: relative;
            -webkit-box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
            box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
            text-align: center;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <div id="formContent">
            <table class="table table-bordered table-hover">
                <caption><h3>Список тренерів</h3></caption>
                <thead>
                <tr>
                    <th>Телефон тренера</th>
                    <th>Ім'я тренера</th>
                    <th>Адреса залу</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="coach" items="${coaches}">
                    <tr>
                        <td>${coach.phoneNumber}</td>
                        <td>${coach.name}</td>
                        <td>${coach.gymAddress}</td>
                        <td class="text-center"><a class='btn btn-info' href="training?coachPhone=${coach.phoneNumber}"><span class="glyphicon glyphicon-shopping-cart"></span>Замовити тренування</a></td>
                    </tr>
                </c:forEach>
            </table>
    </div>
</div>
</body>
</html>
