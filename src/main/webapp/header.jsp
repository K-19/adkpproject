<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/headerStyles.css">
</head>
<body>
    <header>
        <div class="vertical">
<%--            <div id="logo">--%>
<%--                <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Tesla_Motors.svg/155px-Tesla_Motors.svg.png">--%>
<%--            </div>--%>
<%--            <ul class="hr">--%>
<%--                <li>--%>
<%--                    <form action="signUp.jsp">--%>
<%--                        <div class="shadowed">--%>
<%--                            <input type="submit" value="Регистрация" class="hButtons">--%>
<%--                        </div>--%>
<%--                    </form>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <form action="hello.jsp">--%>
<%--                        <div class="shadowed">--%>
<%--                            <input type="submit" value="Вход" class="hButtons">--%>
<%--                        </div>--%>
<%--                    </form>--%>
<%--                </li>--%>
<%--            </ul>--%>



            <ul class="hr">
                <c:if test="${user eq null}">
                    <li>
                        <form action="signUp.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Регистрация" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="hello.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Вход" class="hButtons">
                            </div>
                        </form>
                    </li>
                </c:if>
                <c:if test="${user.getClass().name eq 'by.bsuir.filinovichsa.adkpproject.users.Advertiser'}">
                    <li>
                        <form action="main.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Главная" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="myProducts.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Мои товары" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="dealToDistributors.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Работа с клиентами" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="partners.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Партнёры" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="statisticsAdvertiser.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Статистика" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="bankAccounts.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Мои банковские счета" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="support.jsp">
                            <div class="shadowed">
                                <input type="submit" value="?" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form method="post" action="exit">
                            <div class="shadowed">
                                <input type="submit" value="Выход" class="hButtons">
                            </div>
                        </form>
                    </li>
                </c:if>
                <c:if test="${user.getClass().name eq 'by.bsuir.filinovichsa.adkpproject.users.Distributor'}">
                    <li>
                        <form action="main.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Главная" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="workWithAdvertisers.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Взаимодействие с рекламодателями" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="partners.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Партнёры" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="statisticsDistributor.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Статистика" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="bankAccounts.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Мои банковские счета" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="support.jsp">
                            <div class="shadowed">
                                <input type="submit" value="?" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form method="post" action="exit">
                            <div class="shadowed">
                                <input type="submit" value="Выход" class="hButtons">
                            </div>
                        </form>
                    </li>
                </c:if>
                <c:if test="${user.getClass().name eq 'by.bsuir.filinovichsa.adkpproject.users.Admin'}">
                    <li>
                        <form action="adminMain.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Главная" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="usersPanel.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Управление пользователями" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="adminsPanel.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Администраторы" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form action="techSupport.jsp">
                            <div class="shadowed">
                                <input type="submit" value="Поддержка пользователей" class="hButtons">
                            </div>
                        </form>
                    </li>
                    <li>
                        <form method="post" action="exit">
                            <div class="shadowed">
                                <input type="submit" value="Выход" class="hButtons">
                            </div>
                        </form>
                    </li>
                </c:if>
            </ul>
        </div>
    </header>
</body>
</html>
