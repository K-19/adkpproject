<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Дистрибьютор</h2>
    <div class="input-field-info">
        <div class="info-left">
            <c:out value="Название организации: "/>
        </div>
        <div class="info-right">
            <c:out value="${distributor.nameOrganization}"/>
        </div>
    </div>
    <div class="input-field-info">
        <div class="info-left">
            <c:out value="Тип субъекта: "/>
        </div>
        <div class="info-right">
            <c:out value="${distributor.type.name}"/>
        </div>
    </div>
    <div class="input-field-info">
        <div class="info-left">
            <c:out value="Тип дистрибьютора: "/>
        </div>
        <div class="info-right">
            <c:out value="${distributor.distributorType.name}"/>
        </div>
    </div>
    <div class="input-field-info">
        <div class="info-left">
            <c:out value="Адрес организации: "/>
        </div>
        <div class="info-right">
            <c:out value="${distributor.address}"/>
        </div>
    </div>

    <div class="input-field-info">
        <div class="info-left">
            <c:out value="Счета организации: "/>
        </div>
        <div class="info-right">
            <c:forEach items="${distributor.bankAccounts}" var="bankAccount">
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
            <c:out value="${distributor.description}"/>
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
            <c:out value="${distributor.agentSurname}"/>
        </div>
    </div>
    <div class="input-field-info">
        <div class="info-left">
            <c:out value="Имя: "/>
        </div>
        <div class="info-right">
            <c:out value="${distributor.agentName}"/>
        </div>
    </div>
    <div class="input-field-info">
        <div class="info-left">
            <c:out value="Телефон: "/>
        </div>
        <div class="info-right">
            <c:out value="${distributor.agentPhone}"/>
        </div>
    </div>
</body>
</html>
