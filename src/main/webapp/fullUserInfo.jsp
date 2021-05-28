<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Пользователь ${usser.nameOrganization}</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">

            <c:if test="${usser.getClass().name eq 'by.bsuir.filinovichsa.adkpproject.users.Advertiser'}">
                <c:set var="advertiser" value="${usser}" scope="request"/>
                <c:import url="advertiserOut.jsp"/>
                <div class="input-field-info">
                    <div class="info-left" style="font-weight: bold">
                        <c:out value="Статистика: "/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Дней в системе: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.howManyDaysSinceRegistration()}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Количество товаров за всё время: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getProductAll()}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Количество партнёров: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getConfirmAdDeals().size()}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Рекламы на дирижаблях: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getAdSizeDealsWithAdType(0)}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Рекламы на воздушных шарах: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getAdSizeDealsWithAdType(1)}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Рекламы в теле-радио-эфирах: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getAdSizeDealsWithAdType(2)}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Рекламы на мероприятиях: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getAdSizeDealsWithAdType(3)}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Рекламы на видеохостингах: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getAdSizeDealsWithAdType(4)}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Рекламы на интернет-ресурсах: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getAdSizeDealsWithAdType(5)}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Рекламы в печатных СМИ: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getAdSizeDealsWithAdType(6)}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Печатной рекламы: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getAdSizeDealsWithAdType(7)}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Рекламы на уличных коммуникациях: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getAdSizeDealsWithAdType(8)}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Рекламы на сувенирах: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getAdSizeDealsWithAdType(9)}"/>
                    </div>
                </div>
            </c:if>

            <c:if test="${usser.getClass().name eq 'by.bsuir.filinovichsa.adkpproject.users.Distributor'}">
                <c:set var="distributor" value="${usser}" scope="request"/>
                <c:import url="distributorOut.jsp"/>
                <div class="input-field-info">
                    <div class="info-left" style="font-weight: bold">
                        <c:out value="Статистика: "/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Дней в системе: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.howManyDaysSinceRegistration()}"/>
                    </div>
                </div>
                <div class="input-field-info">
                    <div class="info-left">
                        <c:out value="Количество партнёров: "/>
                    </div>
                    <div class="info-right">
                        <c:out value="${usser.getConfirmAdDeals().size()}"/>
                    </div>
                </div>
            </c:if>

        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
