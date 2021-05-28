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
                    <c:out value="Количество товаров за всё время: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getProductAll()}"/>
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



            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Рекламы на дирижаблях: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getAdSizeDealsWithAdType(0)}"/>
                </div>
            </div>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Рекламы на воздушных шарах: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getAdSizeDealsWithAdType(1)}"/>
                </div>
            </div>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Рекламы в теле-радио-эфирах: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getAdSizeDealsWithAdType(2)}"/>
                </div>
            </div>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Рекламы на мероприятиях: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getAdSizeDealsWithAdType(3)}"/>
                </div>
            </div>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Рекламы на видеохостингах: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getAdSizeDealsWithAdType(4)}"/>
                </div>
            </div>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Рекламы на интернет-ресурсах: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getAdSizeDealsWithAdType(5)}"/>
                </div>
            </div>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Рекламы в печатных СМИ: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getAdSizeDealsWithAdType(6)}"/>
                </div>
            </div>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Печатной рекламы: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getAdSizeDealsWithAdType(7)}"/>
                </div>
            </div>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Рекламы на уличных коммуникациях: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getAdSizeDealsWithAdType(8)}"/>
                </div>
            </div>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Рекламы на сувенирах: "/>
                </div>
                <div class="info-right">
                    <c:out value="${user.getAdSizeDealsWithAdType(9)}"/>
                </div>
            </div>


        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
