<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/mainStyles.css">
</head>
<body>
<div class="input-field">
    <div class="label-block">Тип рекламной конструкции</div>
    <div class="info-block">
        <select name="outdoorType">
            <c:set var="type" value="${deal.ad.getField(0).split(': ')[1]}"/>
            <c:if test="${type eq 'Рекламный щит'}">
                <option selected>Рекламный щит</option>
            </c:if>
            <c:if test="${type ne 'Рекламный щит'}">
                <option>Рекламный щит</option>
            </c:if>
            <c:if test="${type eq 'Вывеска'}">
                <option selected>Вывеска</option>
            </c:if>
            <c:if test="${type ne 'Вывеска'}">
                <option>Вывеска</option>
            </c:if>
            <c:if test="${type eq 'Столб'}">
                <option selected>Столб</option>
            </c:if>
            <c:if test="${type ne 'Столб'}">
                <option>Столб</option>
            </c:if>
            <c:if test="${type eq 'Витрина'}">
                <option selected>Витрина</option>
            </c:if>
            <c:if test="${type ne 'Витрина'}">
                <option>Витрина</option>
            </c:if>
        </select>
    </div>
</div>
<div class="input-field">
    <div class="label-block">Адрес конструкции</div>
    <div class="info-block">
        <input required type="text" minlength="3" maxlength="50" name="address" value="${deal.ad.getField(1).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Подсветка?</div>
    <div class="info-block">
        <input required type="checkbox" name="backlight" value="checked" ${deal.ad.getField(2).split(": ")[1]}>
    </div>
</div>
<div class="input-field">
    <div class="label-block">Длина рекламной части</div>
    <div class="info-block">
        <input required type="text" maxlength="3" name="length" value="${deal.ad.getField(3).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Ширина рекламной части</div>
    <div class="info-block">
        <input required type="text" maxlength="3" name="width" value="${deal.ad.getField(4).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Количество оплаченых дней</div>
    <div class="info-block">
        <input required type="number" maxlength="5" name="numberOfPaidDays" value="${deal.ad.getField(5).split(": ")[1]}">
    </div>
</div>
<div class="input-field-text">
    <div class="label-block">Описание рекламы</div>
    <div class="info-block">
        <textarea minlength="20" maxlength="200" required name="adDescription">${deal.ad.getField(6).split(": ")[1]}</textarea>
    </div>
</div>
</body>
</html>
