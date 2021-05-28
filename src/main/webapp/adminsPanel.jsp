<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Администраторы</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">


            <h2>Администраторы системы</h2>
                <c:forEach items="${user.getAllAdmins()}" var="admin">
                    <div>
                        <h3><c:out value="Администратор №${admin.id} ${admin.name} ${admin.surname}"/></h3>
                    </div>
                </c:forEach>

            <c:if test="${addAdmin eq null}">
                <form method="get" action="addAdmin">
                    <input type="submit" value="Добавить нового администратора" class="button"/>
                </form>
            </c:if>
            <c:if test="${addAdmin ne null}">
                <form method="post" action="addAdmin">
                    <div class="input-field">
                        <div class="label-block">Имя</div>
                        <div class="info-block">
                            <input type="text" minlength="2" maxlength="50" name="name" required>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Фамилия</div>
                        <div class="info-block">
                            <input type="text" minlength="2" maxlength="50" name="surname" required>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Логин</div>
                        <div class="info-block">
                            <input type="text" minlength="5" maxlength="30" name="login" required>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Пароль</div>
                        <div class="info-block">
                            <input type="text" minlength="5" maxlength="30" name="password" required>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Повторите пароль</div>
                        <div class="info-block">
                            <input type="text" minlength="5" maxlength="30" name="repeatPassword" required>
                        </div>
                    </div>
                    <div class="margin-bottom">
                        <input type="submit" value="Зарегистрировать администратора" class="button">
                    </div>
                </form>
            </c:if>

            <div style="margin: 10px">
            <c:if test="${error ne null}">
                <c:out value="${error}"/>
            </c:if>
            </div>

        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
