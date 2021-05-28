<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Главная</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">

            <h2>
                Добро пожаловать, администратор ${user.name} ${user.surname}!
            </h2>
            <div class="hello_description_text">
                <p>Данная система предназначена для удобного и эффективного ведения рекламной деятельности,
                    быстрого и качественного поиска деловых партнёров.</p>
                <p>Вы - администратор. Ваша задача - поддерживать работоспособность приложения своевременно реагировать на сообщения от пользователей.
                </p>
            </div>



            <c:if test="${resultChanging ne null}">
                <div style="font-size: 18px; font-weight: bold">
                    <c:out value="${resultChanging}"/>
                </div>
            </c:if>

            <c:if test="${changeAdminPassword eq null}">
                <form method="get" action="changeAdminPassword">
                    <input type="submit" value="Сменить пароль" class="button"/>
                </form>
            </c:if>
            <c:if test="${changeAdminPassword ne null}">
                <form method="post" action="changeAdminPassword">
                    <div class="input-field">
                        <div class="label-block">Старый пароль</div>
                        <div class="info-block">
                            <input type="text" minlength="5" maxlength="30" name="oldPass" required>
                        </div>
                    </div>
                    <div class="input-field-text">
                        <div class="label-block">Новый пароль</div>
                        <div class="info-block">
                            <input type="text" minlength="5" maxlength="30" name="newPass" required>
                        </div>
                    </div>
                    <div class="input-field-text">
                        <div class="label-block">Повторите новый пароль</div>
                        <div class="info-block">
                            <input type="text" minlength="5" maxlength="30" name="repeatNewPass" required>
                        </div>
                    </div>
                    <div class="margin-bottom">
                        <input type="submit" value="Сменить пароль" class="button">
                    </div>
                </form>
            </c:if>


        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
