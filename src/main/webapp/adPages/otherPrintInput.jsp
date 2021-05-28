<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/mainStyles.css">
</head>
<body>
<div class="input-field">
    <div class="label-block">Тип рекламного изделия</div>
    <div class="info-block">
        <select name="othPrintType">
            <c:set var="type" value="${deal.ad.getField(0).split(': ')[1]}"/>
            <c:if test="${type eq 'Плакат'}">
                <option selected>Плакат</option>
            </c:if>
            <c:if test="${type ne 'Плакат'}">
                <option>Плакат</option>
            </c:if>
            <c:if test="${type eq 'Листовка'}">
                <option selected>Листовка</option>
            </c:if>
            <c:if test="${type ne 'Листовка'}">
                <option>Листовка</option>
            </c:if>
            <c:if test="${type eq 'Брошюра'}">
                <option selected>Брошюра</option>
            </c:if>
            <c:if test="${type ne 'Брошюра'}">
                <option>Брошюра</option>
            </c:if>
            <c:if test="${type eq 'Открытка'}">
                <option selected>Открытка</option>
            </c:if>
            <c:if test="${type ne 'Открытка'}">
                <option>Открытка</option>
            </c:if>
            <c:if test="${type eq 'Календарь'}">
                <option selected>Календарь</option>
            </c:if>
            <c:if test="${type ne 'Календарь'}">
                <option>Календарь</option>
            </c:if>
            <c:if test="${type eq 'Визитка'}">
                <option selected>Визитка</option>
            </c:if>
            <c:if test="${type ne 'Визитка'}">
                <option>Визитка</option>
            </c:if>
        </select>
    </div>
</div>
<div class="input-field">
    <div class="label-block">Размер бумажного листа</div>
    <div class="info-block">
        <select name="paperSize">
            <c:set var="type" value="${deal.ad.getField(1).split(': ')[1]}"/>
            <c:if test="${type eq 'A0'}">
                <option selected>A0</option>
            </c:if>
            <c:if test="${type ne 'A0'}">
                <option>A0</option>
            </c:if>
            <c:if test="${type eq 'A1'}">
                <option selected>A1</option>
            </c:if>
            <c:if test="${type ne 'A1'}">
                <option>A1</option>
            </c:if>
            <c:if test="${type eq 'A2'}">
                <option selected>A2</option>
            </c:if>
            <c:if test="${type ne 'A2'}">
                <option>A2</option>
            </c:if>
            <c:if test="${type eq 'A3'}">
                <option selected>A3</option>
            </c:if>
            <c:if test="${type ne 'A3'}">
                <option>A3</option>
            </c:if>
            <c:if test="${type eq 'A4'}">
                <option selected>A4</option>
            </c:if>
            <c:if test="${type ne 'A4'}">
                <option>A4</option>
            </c:if>
        </select>
    </div>
</div>
<div class="input-field">
    <div class="label-block">Плотность бумаги</div>
    <div class="info-block">
        <input required type="text" maxlength="4" name="paperDensity" value="${deal.ad.getField(2).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Материал бумаги</div>
    <div class="info-block">
        <input required type="text" minlength="2" maxlength="15" name="material" value="${deal.ad.getField(3).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Длина рекламной части</div>
    <div class="info-block">
        <input required maxlength="3" type="text" name="length" value="${deal.ad.getField(4).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Ширина рекламной части</div>
    <div class="info-block">
        <input required type="text" maxlength="3" name="width" value="${deal.ad.getField(5).split(": ")[1]}">
    </div>
</div>
<div class="input-field">
    <div class="label-block">Количество</div>
    <div class="info-block">
        <input required type="number" maxlength="7" name="quantity" value="${deal.ad.getField(6).split(": ")[1]}">
    </div>
</div>
<div class="input-field-text">
    <div class="label-block">Описание рекламы</div>
    <div class="info-block">
        <textarea minlength="20" maxlength="200" required name="adDescription">${deal.ad.getField(7).split(": ")[1]}</textarea>
    </div>
</div>
</body>
</html>
