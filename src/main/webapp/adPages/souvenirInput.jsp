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
        <select name="souvenirType">
            <c:set var="type" value="${deal.ad.getField(0).split(': ')[1]}"/>
            <c:if test="${type eq 'Записная книжка'}">
                <option selected>Записная книжка</option>
            </c:if>
            <c:if test="${type ne 'Записная книжка'}">
                <option>Записная книжка</option>
            </c:if>
            <c:if test="${type eq 'Авторучка'}">
                <option selected>Авторучка</option>
            </c:if>
            <c:if test="${type ne 'Авторучка'}">
                <option>Авторучка</option>
            </c:if>
            <c:if test="${type eq 'Значок'}">
                <option selected>Значок</option>
            </c:if>
            <c:if test="${type ne 'Значок'}">
                <option>Значок</option>
            </c:if>
            <c:if test="${type eq 'Папка с рекламой'}">
                <option selected>Папка с рекламой</option>
            </c:if>
            <c:if test="${type ne 'Папка с рекламой'}">
                <option>Папка с рекламой</option>
            </c:if>
            <c:if test="${type eq 'Линейка'}">
                <option selected>Линейка</option>
            </c:if>
            <c:if test="${type ne 'Линейка'}">
                <option>Линейка</option>
            </c:if>
            <c:if test="${type eq 'Закладка'}">
                <option selected>Закладка</option>
            </c:if>
            <c:if test="${type ne 'Закладка'}">
                <option>Закладка</option>
            </c:if>
            <c:if test="${type eq 'Термометр'}">
                <option selected>Термометр</option>
            </c:if>
            <c:if test="${type ne 'Термометр'}">
                <option>Термометр</option>
            </c:if>
            <c:if test="${type eq 'Зажигалка'}">
                <option selected>Зажигалка</option>
            </c:if>
            <c:if test="${type ne 'Зажигалка'}">
                <option>Зажигалка</option>
            </c:if>
            <c:if test="${type eq 'Брелок'}">
                <option selected>Брелок</option>
            </c:if>
            <c:if test="${type ne 'Брелок'}">
                <option>Брелок</option>
            </c:if>
        </select>
    </div>
</div>
<div class="input-field">
    <div class="label-block">Количество</div>
    <div class="info-block">
        <input required type="number" maxlength="7" name="quantity" value="${deal.ad.getField(1).split(": ")[1]}">
    </div>
</div>
<div class="input-field-text">
    <div class="label-block">Описание рекламы</div>
    <div class="info-block">
        <textarea minlength="20" maxlength="200" required name="adDescription">${deal.ad.getField(2).split(": ")[1]}</textarea>
    </div>
</div>
</body>
</html>
