<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/mainStyles.css">
</head>
<body>
<div class="input-field">
    <div class="label-block">Тип интернет-рекламы</div>
    <div class="info-block">
        <select name="internetType">
            <c:set var="type" value="${deal.ad.getField(0).split(': ')[1]}"/>
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
        <input type="number" maxlength="6" required name="pricePerViewing" value="${deal.ad.getField(1).split(": ")[1]}">
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
