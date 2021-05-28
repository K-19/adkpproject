<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/mainStyles.css">
</head>
<body>
    <div class="input-field">
        <div class="label-block">Сколько дней реклама будет в воздухе?</div>
        <div class="info-block">
            <input type="number" minlength="1" maxlength="2" required name="numberOfDays" value="${deal.ad.getField(0).split(": ")[1]}">
        </div>
    </div>
    <div class="input-field">
        <div class="label-block">Длина рекламной части</div>
        <div class="info-block">
            <input type="text"  maxlength="3" required name="length" value="${deal.ad.getField(1).split(": ")[1]}">
        </div>
    </div>
    <div class="input-field">
        <div class="label-block">Ширина рекламной части</div>
        <div class="info-block">
            <input type="text" maxlength="3" required name="width" value="${deal.ad.getField(2).split(": ")[1]}">
        </div>
    </div>
    <div class="input-field">
        <div class="label-block">Введите время запуска дирижабля</div>
        <div class="info-block">
            <input type="datetime-local" required name="startTime" value="${deal.ad.getField(3).split(": ")[1]}">
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
