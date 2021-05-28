<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/mainStyles.css">
</head>
<body>
<div class="input-field">
    <div class="label-block">Тип события</div>
    <div class="info-block">
        <select name="eventType">
            <c:set var="type" value="${deal.ad.getField(0).split(': ')[1]}"/>
            <c:if test="${type eq 'Выставка'}">
                <option selected>Выставка</option>
            </c:if>
            <c:if test="${type ne 'Выставка'}">
                <option>Выставка</option>
            </c:if>
            <c:if test="${type eq 'Конференция'}">
                <option selected>Конференция</option>
            </c:if>
            <c:if test="${type ne 'Конференция'}">
                <option>Конференция</option>
            </c:if>
            <c:if test="${type eq 'Фестиваль'}">
                <option selected>Фестиваль</option>
            </c:if>
            <c:if test="${type ne 'Фестиваль'}">
                <option>Фестиваль</option>
            </c:if>
            <c:if test="${type eq 'Презентация'}">
                <option selected>Презентация</option>
            </c:if>
            <c:if test="${type ne 'Презентация'}">
                <option>Презентация</option>
            </c:if>
            <c:if test="${type eq 'Шоу'}">
                <option selected>Шоу</option>
            </c:if>
            <c:if test="${type ne 'Шоу'}">
                <option>Шоу</option>
            </c:if>
            <c:if test="${type eq 'Интерактив'}">
                <option selected>Интерактив</option>
            </c:if>
            <c:if test="${type ne 'Интерактив'}">
                <option>Интерактив</option>
            </c:if>
            <c:if test="${type eq 'Концерт'}">
                <option selected>Концерт</option>
            </c:if>
            <c:if test="${type ne 'Концерт'}">
                <option>Концерт</option>
            </c:if>
            <c:if test="${type eq 'Другое'}">
                <option selected>Другое</option>
            </c:if>
            <c:if test="${type ne 'Другое'}">
                <option>Другое</option>
            </c:if>
        </select>
    </div>
</div>
<div class="input-field">
    <div class="label-block">Дата и время начала</div>
    <div class="info-block">
        <input type="datetime-local" required name="startTime" value="${deal.ad.getField(1).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Стоимость за 1 посетителя</div>
    <div class="info-block">
        <input type="number" maxlength="4" required name="pricePerVisitor" value="${deal.ad.getField(2).split(": ")[1]}">
    </div>
</div>
<div class="input-field-text">
    <div class="label-block">Описание рекламы</div>
    <div class="info-block">
        <textarea minlength="20" maxlength="200" required name="adDescription">${deal.ad.getField(3).split(": ")[1]}</textarea>
    </div>
</div>
</body>
</html>
