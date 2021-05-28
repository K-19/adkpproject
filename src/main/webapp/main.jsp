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
                Добро пожаловать, ${user.agentName} ${user.agentSurname}!
            </h2>

            <h3>Главная</h3>

            <div class="hello_description_text">
            <p>Данная система предназначена для удобного и эффективного ведения рекламной деятельности,
                быстрого и качественного поиска деловых партнёров.</p>
            <p>Рекламодателям: добавляйте в систему свои требующие рекламного продвижения продукты. После этого специальным поиском
                можно быстро найти подходящего рекламораспространителя и предложить ему сотрудничество.</p>
            <p>Рекламораспространителям: получив предложение о сотрудничестве, вы можете его либо принять сразу,
                либо отправить потенциальному деловому партнёру некоторые правки, изменив данные, вас не устроившие.</p>
            <p>Заключив договор у вас в любой момент будет полная информация обо всех деталях.</p>
            </div>





            <c:if test="${resultChanging ne null}">
                <div style="font-size: 18px; font-weight: bold">
                    <c:out value="${resultChanging}"/>
                </div>
            </c:if>

            <c:if test="${changePassword eq null}">
                <form method="get" action="changePassword">
                    <input type="submit" value="Сменить пароль" class="button"/>
                </form>
            </c:if>
            <c:if test="${changePassword ne null}">
                <form method="post" action="changePassword">
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
