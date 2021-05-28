<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Редактирование пользователя</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
            <div class="content">
                <h2>Редактирование пользователя</h2>
                <form method="post" action="editUser?id=${object.id}">
                    <div class="input-field">
                        <div class="label-block">Тип субьекта</div>
                        <div class="info-block">
                            <select name="userType" class="inputForm">
                                <c:set var="type" value="${object.type.name}"/>
                                <c:if test="${type eq 'Юридическое лицо'}">
                                    <option selected>Юридическое лицо</option>
                                </c:if>
                                <c:if test="${type ne 'Юридическое лицо'}">
                                    <option>Юридическое лицо</option>
                                </c:if>
                                <c:if test="${type eq 'Индивидуальный предприниматель'}">
                                    <option selected>Индивидуальный предприниматель</option>
                                </c:if>
                                <c:if test="${type ne 'Индивидуальный предприниматель'}">
                                    <option>Индивидуальный предприниматель</option>
                                </c:if>
                            </select>
                        </div>
                    </div>
                <c:if test="${object.getClass().name eq 'by.bsuir.filinovichsa.adkpproject.users.Distributor'}">
                    <div class="input-field">
                        <div class="label-block">Тип дистрибьютора</div>
                        <div class="info-block">
                            <select name="distributorType" class="inputForm">
                                <c:set var="type" value="${object.type.name}"/>
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
                                <c:if test="${type eq 'Интернет-портал'}">
                                    <option selected>Интернет-портал</option>
                                </c:if>
                                <c:if test="${type ne 'Интернет-портал'}">
                                    <option>Интернет-портал</option>
                                </c:if>
                                <c:if test="${type eq 'Радиостанция'}">
                                    <option selected>Радиостанция</option>
                                </c:if>
                                <c:if test="${type ne 'Радиостанция'}">
                                    <option>Радиостанция</option>
                                </c:if>
                                <c:if test="${type eq 'ТВ-канал'}">
                                    <option selected>ТВ-канал</option>
                                </c:if>
                                <c:if test="${type ne 'ТВ-канал'}">
                                    <option>ТВ-канал</option>
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
                    </c:if>

                        <div class="input-field">
                            <div class="label-block">Название организации</div>
                            <div class="info-block">
                                <input minlength="3" maxlength="50" type="text" name="orgName" required value="${object.nameOrganization}">
                            </div>
                        </div>
                        <div class="input-field">
                            <div class="label-block">Адрес организации</div>
                            <div class="info-block">
                                <input minlength="3" maxlength="50" type="text" name="orgAddress" required value="${object.address}">
                            </div>
                        </div>
                        <div class="input-field">
                            <div class="label-block">Имя представителя</div>
                            <div class="info-block">
                                <input minlength="2" maxlength="50" type="text" name="agentName" required value="${object.agentName}">
                            </div>
                        </div>
                        <div class="input-field">
                            <div class="label-block">Фамилия представителя</div>
                            <div class="info-block">
                                <input minlength="2" maxlength="50" type="text" name="agentSurname" required value="${object.agentSurname}">
                            </div>
                        </div>
                        <div class="input-field">
                            <div class="label-block">Телефон представителя</div>
                            <div class="info-block">
                                <input minlength="11" maxlength="15" type="text" name="agentPhone" required value="${object.agentPhone}">
                            </div>
                        </div>
                        <div class="input-field-text">
                            <div class="label-block">Описание</div>
                            <div class="info-block">
                                <textarea minlength="20" maxlength="200" name="description" required>${object.description}</textarea>
                            </div>
                        </div>
                        <div class="input-field">
                            <div class="label-block">Логин</div>
                            <div class="info-block">
                                <input minlength="5" maxlength="30" type="text" name="login" required value="${object.login}">
                            </div>
                        </div>
                        <div class="margin-bottom">
                            <input type="submit" value="Подтвердить изменения" class="button">
                        </div>
                    </form>
                    <form method="post", action="adminChangePassword?id=${object.id}">
                        <h4>Сменить пароль</h4>
                        <div class="input-field">
                            <div class="label-block">Новый пароль</div>
                            <div class="info-block">
                                <input minlength="5" maxlength="30" type="text" name="newPassword" required>
                            </div>
                        </div>
                        <div class="input-field">
                            <div class="label-block">Повторите пароль</div>
                            <div class="info-block">
                                <input minlength="5" maxlength="30" type="text" name="repeatNewPassword" required>
                            </div>
                        </div>
                        <div class="margin-bottom">
                            <input type="submit" value="Сменить пароль" class="button"/>
                        </div>
                    </form>
                    <form action="usersPanel.jsp">
                        <input type="submit" value="Отмена" class="button">
                    </form>
                </div>
            <c:import url="footer.jsp"/>
        </div>
    </div>
    </body>
</html>
