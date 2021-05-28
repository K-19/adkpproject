<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<h2>Продукт</h2>
<div class="input-field-info">
    <div class="info-left">
        <c:out value="Оформление рекламы: "/>
    </div>
    <div class="info-right">
        <c:out value="${product.adType.name.toLowerCase()}"/>
    </div>
</div>
<div class="input-field-info">
    <div class="info-left">
        <c:out value="Название товара: "/>
    </div>
    <div class="info-right">
        <c:out value="${product.name}"/>
    </div>
</div>
<div class="input-field-info">
    <div class="info-left">
        <c:out value="Описание: "/>
    </div>
    <div class="info-right">
        <c:out value="${product.description}"/>
    </div>
</div>
</body>
</html>
