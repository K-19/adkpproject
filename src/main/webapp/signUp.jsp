<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
    <div class="scrolling">
        <div class="main">
            <c:import url="header.jsp"/>
            <div class="content">

                <h1>Регистрация
                    <c:if test="${role eq 'advertiser'}">
                        <c:out value=" рекламодателя"/>
                    </c:if>
                    <c:if test="${role eq 'distributor'}">
                        <c:out value=" рекламораспространителя"/>
                    </c:if>
                </h1>
                <div>
                    <c:if test="${error ne null}">
                        <c:out value="${error}"/>
                    </c:if>
                </div>
                <c:if test="${chooseRole eq null}">
                    <h1>Кто вы?</h1>
                    <form method="post" action="signUp?role=advertiser">
                        <input type="submit" value="Рекламодатель" class="button">
                    </form>
                    <form method="post" action="signUp?role=distributor">
                        <input type="submit" value="Распространитель" class="button">
                    </form>
                </c:if>
                <c:if test="${chooseRole ne null}">
                    <c:if test="${role eq 'advertiser'}">
                        <form method="post" action="signUpAdvertiser">
                            <div class="input-field">
                                <div class="label-block">Тип субьекта</div>
                                <div class="info-block">
                                    <select name="userAdvertiserType" class="inputForm">
                                        <option>Юридическое лицо</option>
                                        <option>Индивидуальный предприниматель</option>
                                    </select>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Название организации</div>
                                <div class="info-block">
                                    <input type="text" minlength="3" maxlength="50" name="advertiserOrgName" required>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Адрес организации</div>
                                <div class="info-block">
                                    <input type="text" minlength="5" maxlength="50" name="advertiserOrgAddress" required>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Имя представителя</div>
                                <div class="info-block">
                                    <input type="text" minlength="2" maxlength="50" name="advertiserAgentName" required>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Фамилия представителя</div>
                                <div class="info-block">
                                    <input type="text" minlength="2" maxlength="50" name="advertiserAgentSurname" required>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Телефон представителя</div>
                                <div class="info-block">
                                    <input type="text" minlength="11" maxlength="15" name="advertiserAgentPhone" required>
                                </div>
                            </div>
                            <div class="input-field-text">
                                <div class="label-block">Описание</div>
                                <div class="info-block">
                                    <textarea minlength="20" maxlength="200" name="advertiserDescription" required></textarea>
                                </div>
                            </div>
                            <h4>Введите данные для входа в аккаунт:</h4>
                            <div class="input-field">
                                <div class="label-block">Логин</div>
                                <div class="info-block">
                                    <input minlength="5" maxlength="30" type="text" name="advertiserLogin" required>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Пароль</div>
                                <div class="info-block">
                                    <input minlength="5" maxlength="30" type="text" name="advertiserPassword" required>
                                </div>
                            </div>
                            <div class="margin-bottom">
                                <input type="submit" value="Зарегистрироваться" class="button">
                            </div>
                        </form>
                        <form action="signUp.jsp">
                            <input type="submit" value="Отмена" class="button">
                        </form>
                    </c:if>
                    <c:if test="${role eq 'distributor'}">
                        <form method="post" action="signUpDistributor">
                            <div class="input-field">
                                <div class="label-block">Тип субьекта</div>
                                <div class="info-block">
                                    <select name="userDistributorType" class="inputForm">
                                        <option>Юридическое лицо</option>
                                        <option>Индивидуальный предприниматель</option>
                                    </select>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Тип дистрибьютора</div>
                                <div class="info-block">
                                    <select name="distributorType" class="inputForm">
                                        <option>Газета</option>
                                        <option>Журнал</option>
                                        <option>Интернет-портал</option>
                                        <option>Радиостанция</option>
                                        <option>ТВ-канал</option>
                                        <option>Другое</option>
                                    </select>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Название организации</div>
                                <div class="info-block">
                                    <input type="text" minlength="3" maxlength="50" name="distributorOrgName" required>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Адрес организации</div>
                                <div class="info-block">
                                    <input type="text" minlength="3" maxlength="50" name="distributorOrgAddress" required>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Имя представителя</div>
                                <div class="info-block">
                                    <input type="text" minlength="2" maxlength="50" name="distributorAgentName" required>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Фамилия представителя</div>
                                <div class="info-block">
                                    <input type="text" minlength="2" maxlength="50" name="distributorAgentSurname" required>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Телефон представителя</div>
                                <div class="info-block">
                                    <input type="text" minlength="1" maxlength="15" name="distributorAgentPhone" required>
                                </div>
                            </div>
                            <div class="input-field-text">
                                <div class="label-block">Описание</div>
                                <div class="info-block">
                                    <textarea minlength="20" maxlength="200" name="distributorDescription" required></textarea>
                                </div>
                            </div>
                            <h4>Введите данные для входа в аккаунт:</h4>
                            <div class="input-field">
                                <div class="label-block">Логин</div>
                                <div class="info-block">
                                    <input type="text" minlength="5" maxlength="30" name="distributorLogin" required>
                                </div>
                            </div>
                            <div class="input-field">
                                <div class="label-block">Пароль</div>
                                <div class="info-block">
                                    <input type="text" minlength="5" maxlength="30" name="distributorPassword" required>
                                </div>
                            </div>

                            <div class="margin-bottom">
                                <input type="submit" value="Зарегистрироваться" class="button">
                            </div>
                        </form>
                        <form action="signUp.jsp">
                            <input type="submit" value="Отмена" class="button">
                        </form>
                    </c:if>
                </c:if>
            </div>
            <c:import url="footer.jsp"/>
        </div>
    </div>

</body>
</html>
