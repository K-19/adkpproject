<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добро пожаловать</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
    <div class="scrolling">
        <div class="main">
            <c:import url="header.jsp"/>

            <div class="content">
                <h1>Добро пожаловать!</h1>

                <form method="post" action="login">

                    <div class="input-field">
                        <div class="label-block">Логин</div>
                        <div class="info-block">
                            <input minlength="5" maxlength="30" type="text" name="login" required>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Пароль</div>
                        <div class="info-block">
                            <input minlength="5" maxlength="30" type="password" name="password" required>
                        </div>
                    </div>

                    <div>
                        <c:if test="${error ne null}">
                            <c:out value="${error}"/>
                        </c:if>
                    </div>

                    <div class="margin-bottom">
                        <input type="submit" value="Войти" class="button">
                    </div>
                </form>
                <div class="input-field">
                    <div class="left-child">Еще нет аккаунта?</div>
                    <div class="right-child">
                        <form action="signUp.jsp">
                            <div><input type="submit" value="Зарегистрироваться" class="button"></div>
                        </form>
                    </div>
                </div>
            </div>

            <c:import url="footer.jsp"/>
        </div>
    </div>
</body>
</html>
