<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/mainStyles.css">
</head>
<body>
<div class="input-field">
    <div class="label-block">Тип печатного издания</div>
    <div class="info-block">
        <select name="mediaPrintType">
            <c:set var="type" value="${deal.ad.getField(0).split(': ')[1]}"/>
            <c:if test="${type eq 'Газета'}">
                <option selected>Газета</option>
            </c:if>
            <c:if test="${type ne 'Газета'}">
                <option>Газета</option>
            </c:if>
            <c:if test="${type eq 'Журнал'}">
                <option selected>Журнал</option>
            </c:if>
            <c:if test="${type ne 'Журнал'}">
                <option>Журнал</option>
            </c:if>
            <c:if test="${type eq 'Каталог'}">
                <option selected>Каталог</option>
            </c:if>
            <c:if test="${type ne 'Каталог'}">
                <option>Каталог</option>
            </c:if>
        </select>
    </div>
</div>
<div class="input-field">
    <div class="label-block">Страница</div>
    <div class="info-block">
        <input required type="number" maxlength="3" name="pageNumber" value="${deal.ad.getField(1).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Длина рекламной части</div>
    <div class="info-block">
        <input required type="number" maxlength="3" name="length" value="${deal.ad.getField(2).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Ширина рекламной части</div>
    <div class="info-block">
        <input required type="number" maxlength="3" name="width" value="${deal.ad.getField(3).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Количество</div>
    <div class="info-block">
        <input required type="number" maxlength="7" name="quantity" value="${deal.ad.getField(4).split(": ")[1]}">
    </div>
</div>
<div class="input-field-text">
    <div class="label-block">Описание рекламы</div>
    <div class="info-block">
        <textarea minlength="20" maxlength="200" required name="adDescription">${deal.ad.getField(5).split(": ")[1]}</textarea>
    </div>
</div>
</body>
</html>
