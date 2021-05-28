<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/mainStyles.css">
</head>
<body>
<div class="input-field">
    <div class="label-block">Тип вещания</div>
    <div class="info-block">
        <select name="broadcastType">
            <c:set var="type" value="${deal.ad.getField(0).split(': ')[1]}"/>
            <c:if test="${type eq 'Телевидение'}">
                <option selected>Телевидение</option>
            </c:if>
            <c:if test="${type ne 'Телевидение'}">
                <option>Телевидение</option>
            </c:if>
            <c:if test="${type eq 'Радио'}">
                <option selected>Радио</option>
            </c:if>
            <c:if test="${type ne 'Радио'}">
                <option>Радио</option>
            </c:if>
        </select>
    </div>
</div>
<div class="input-field">
    <div class="label-block">Стоимость 1 секунды эфира</div>
    <div class="info-block">
        <input type="number" maxlength="4" required name="durationInSec" value="${deal.ad.getField(1).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Оплаченых показов</div>
    <div class="info-block">
        <input type="number" maxlength="5" required name="numberOfPaidImpressions" value="${deal.ad.getField(2).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Частота показов в день</div>
    <div class="info-block">
        <input type="number" maxlength="4" required name="frequency" value="${deal.ad.getField(3).split(": ")[1]}">
    </div>
</div>
<div class="input-field-text">
    <div class="label-block">Описание рекламы</div>
    <div class="info-block">
        <textarea minlength="20" maxlength="200" required name="adDescription">${deal.ad.getField(4).split(": ")[1]}</textarea>
    </div>
</div>
</body>
</html>
