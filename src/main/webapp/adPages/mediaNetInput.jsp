<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/mainStyles.css">
</head>
<body>
<div class="input-field">
    <div class="label-block">Тип рекламной части</div>
    <div class="info-block">
        <select name="mediaType">
            <c:set var="type" value="${deal.ad.getField(0).split(': ')[1]}"/>
            <c:if test="${type eq 'Баннер'}">
                <option selected>Баннер</option>
            </c:if>
            <c:if test="${type ne 'Баннер'}">
                <option>Баннер</option>
            </c:if>
            <c:if test="${type eq 'Вспылающий баннер'}">
                <option selected>Вспылающий баннер</option>
            </c:if>
            <c:if test="${type ne 'Вспылающий баннер'}">
                <option>Вспылающий баннер</option>
            </c:if>
            <c:if test="${type eq 'Текстовая'}">
                <option selected>Текстовая</option>
            </c:if>
            <c:if test="${type ne 'Текстовая'}">
                <option>Текстовая</option>
            </c:if>
        </select>
    </div>
</div>
<div class="input-field">
    <div class="label-block">Оплаченых показов</div>
    <div class="info-block">
        <input required type="number" maxlength="5" name="numberOfPaidImpressions" value="${deal.ad.getField(1).split(": ")[1]}">
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
    <div class="label-block">Формат рекламы</div>
    <div class="info-block">
        <select name="format">
            <c:set var="type" value="${deal.ad.getField(4).split(': ')[1]}"/>
            <c:if test="${type.toString() eq 'HTML5'}">
                <option selected>HTML5</option>
            </c:if>
            <c:if test="${type.toString() ne 'HTML5'}">
                <option>HTML5</option>
            </c:if>
            <c:if test="${type.toString() eq 'FLASH'}">
                <option selected>FLASH</option>
            </c:if>
            <c:if test="${type.toString() ne 'FLASH'}">
                <option>FLASH</option>
            </c:if>
            <c:if test="${type.toString() eq 'HTML5 + FLASH'}">
                <option selected>HTML5 + FLASH</option>
            </c:if>
            <c:if test="${type.toString() ne 'HTML5 + FLASH'}">
                <option>HTML5 + FLASH</option>
            </c:if>
        </select>
    </div>
</div>
<div class="input-field">
    <div class="label-block">Количество версий</div>
    <div class="info-block">
        <input required type="number" maxlength="2" name="numberOfVersions" value="${deal.ad.getField(5).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Тип интернет-рекламы</div>
    <div class="info-block">
        <select name="internetType">
            <c:set var="type" value="${deal.ad.getField(6).split(': ')[1]}"/>
            <c:if test="${type eq 'Пост'}">
                <option selected>Пост</option>
            </c:if>
            <c:if test="${type ne 'Пост'}">
                <option>Пост</option>
            </c:if>
            <c:if test="${type eq 'Продакт-плейсмент'}">
                <option selected>Продакт-плейсмент</option>
            </c:if>
            <c:if test="${type ne 'Продакт-плейсмент'}">
                <option>Продакт-плейсмент</option>
            </c:if>
            <c:if test="${type eq 'Медийная'}">
                <option selected>Медийная</option>
            </c:if>
            <c:if test="${type ne 'Медийная'}">
                <option>Медийная</option>
            </c:if>
        </select>
    </div>
</div>
<div class="input-field">
    <div class="label-block">Стоимость 1 просмотра</div>
    <div class="info-block">
        <input required type="number" maxlength="6" name="pricePerViewing" value="${deal.ad.getField(7).split(": ")[1]}">
    </div>
</div>
<div class="input-field-text">
    <div class="label-block">Описание рекламы</div>
    <div class="info-block">
        <textarea minlength="20" maxlength="200" required name="adDescription">${deal.ad.getField(8).split(": ")[1]}</textarea>
    </div>
</div>
</body>
</html>
