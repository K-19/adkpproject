<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">


        <c:if test="${user.getAvailableDeals().size() eq 0}">
            <h3>Активных сделок на данный момент нет</h3>
        </c:if>
        <c:if test="${user.getAvailableDeals().size() ne 0}">
            <c:forEach items="${user.getAvailableDeals()}" var="deal">
                <div class="account">
                    <tr><td>
                        <div><c:out value="Сделка №${deal.getId()}"/></div>
                        <div><c:out value="Рекламодатель: ${deal.getProduct().getOwner().getNameOrganization()}"/></div>
                        <div><c:out value="Продукт: ${deal.getProduct().getName()}"/></div>
                        <div><c:out value="Тип желаемой рекламы: ${deal.getProduct().getAdType().getName()}"/></div>
                        <c:if test="${deal.getStatus().getName() eq 'Ожидается ответ дистрибьютора'}">
                            <div style="color: green"><c:out value="Активное предложение"/></div>
                            <div><form method="post" action="editDeal?dealId=${deal.getId()}">
                                <input type="submit" value="Просмотреть">
                            </form></div>
                        </c:if>
                        <c:if test="${deal.getStatus().getName() eq 'Ожидается ответ адвертайзера'}">
                            <div><c:out value="Ожидается ответ рекламодателя"/></div>
                            <div><form method="post" action="viewDeal?dealId=${deal.getId()}">
                                <input type="submit" value="Подробная информация">
                            </form></div>
                        </c:if>
                        <c:if test="${deal.getStatus().getName() eq 'Удалено рекламодателем'}">
                            <div style="color: red"><c:out value="Удалено рекламодателем"/></div>
                            <div><form method="post" action="deleteDeal?dealid=${deal.getId()}&to=distributor">
                                <input type="submit" value="Удалить сделку">
                            </form></div>
                        </c:if>

                    </td></tr>
                </div>
            </c:forEach>
        </c:if>



        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
