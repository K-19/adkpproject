<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Статистика</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Дата регистрации: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getRegisterDate()}"/>
                </div>
            </div>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Дней в системе: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.howManyDaysSinceRegistration()}"/>
                </div>
            </div>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Количество партнёров: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getConfirmAdDeals().size()}"/>
                </div>
            </div>


        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
