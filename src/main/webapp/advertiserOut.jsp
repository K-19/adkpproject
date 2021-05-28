<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Рекламодатель</h2>
<div class="input-field-info">
    <div class="info-left">
        <c:out value="Название организации: "/>
    </div>
    <div class="info-right">
        <c:out value="${advertiser.nameOrganization}"/>
    </div>
</div>
<div class="input-field-info">
    <div class="info-left">
        <c:out value="Тип субъекта: "/>
    </div>
    <div class="info-right">
        <c:out value="${advertiser.type.name}"/>
    </div>
</div>
<div class="input-field-info">
    <div class="info-left">
        <c:out value="Адрес организации: "/>
    </div>
    <div class="info-right">
        <c:out value="${advertiser.address}"/>
    </div>
</div>

<div class="input-field-info">
    <div class="info-left">
        <c:out value="Счета организации: "/>
    </div>
    <div class="info-right">
        <c:forEach items="${advertiser.bankAccounts}" var="bankAccount">
            <div>
                <c:out value="${bankAccount.getFullInformation()}"/>
            </div>
        </c:forEach>
    </div>
</div>

<div class="input-field-info">
    <div class="info-left">
        <c:out value="Описание: "/>
    </div>
    <div class="info-right">
        <c:out value="${advertiser.description}"/>
    </div>
</div>
<div class="input-field-info">
    <div class="info-left" style="font-weight: bold">
        <c:out value="Представитель: "/>
    </div>
</div>
<div class="input-field-info">
    <div class="info-left">
        <c:out value="Фамилия: "/>
    </div>
    <div class="info-right">
        <c:out value="${advertiser.agentSurname}"/>
    </div>
</div>
<div class="input-field-info">
    <div class="info-left">
        <c:out value="Имя: "/>
    </div>
    <div class="info-right">
        <c:out value="${advertiser.agentName}"/>
    </div>
</div>
<div class="input-field-info">
    <div class="info-left">
        <c:out value="Телефон: "/>
    </div>
    <div class="info-right">
        <c:out value="${advertiser.agentPhone}"/>
    </div>
</div>
</body>
</html>
