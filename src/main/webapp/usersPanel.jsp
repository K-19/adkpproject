<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Сделка</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
    <link rel="stylesheet" type="text/css" href="css/headerStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">
            <div>
                <ul class="hr">
                    <li>
                        <form method="post" action="usersPanel?filter=advertisers">
                            <input type="submit" value="Рекламодатели">
                        </form>
                    </li>
                    <li>
                        <form method="post" action="usersPanel?filter=distributors">
                            <input type="submit" value="Рекламораспространители">
                        </form>
                    </li>
                    <li>
                        <form method="post" action="usersPanel?filter=all">
                            <input type="submit" value="Все">
                        </form>
                    </li>
                </ul>
            </div>

            <c:if test="${filter eq 'advertisers'}">
                <c:set var="list" value="${user.getAdvertisers()}"/>
            </c:if>
            <c:if test="${filter eq 'distributors'}">
                <c:set var="list" value="${user.getDistributors()}"/>
            </c:if>
            <c:if test="${filter eq 'all'}">
                <c:set var="list" value="${user.getAllUsers()}"/>
            </c:if>
            <c:if test="${filter eq null}">
                <c:set var="list" value="${user.getAllUsers()}"/>
            </c:if>

        <c:forEach var="usser" items="${list}">
            <div class="account">
                <tr><td>
                    <div class="info-right">
                        <div class="smallHeadText">${usser.nameOrganization}</div>
                        <div style="font-size: 14px">${usser.description}</div>
                    </div>
                    <div class="info-left">
                        <form method="post" action="fullUserInfo?id=${usser.id}">
                            <input type="submit" value="Полная инормация" class="usersButton"/>
                        </form>
                        <form method="post" action="editUserPage?id=${usser.id}">
                            <input type="submit" value="Редактировать" class="usersButton"/>
                        </form>
                        <form method="post" action="deleteUser?id=${usser.id}">
                            <input type="submit" value="Удалить" class="cancelButton" style="width: 100%"/>
                        </form>
                    </div>
                </td></tr>
                <div style="width: 100%; clear: both"></div>
            </div>
        </c:forEach>
        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
