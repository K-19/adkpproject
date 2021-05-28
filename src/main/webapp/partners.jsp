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

            <c:if test="${user.getConfirmAdDeals().size() eq 0}">
                <h3>Ваш список партнёров пуст</h3>
            </c:if>
            <c:if test="${user.getConfirmAdDeals().size() ne 0}">
                <c:if test="${user.getClass().name eq 'by.bsuir.filinovichsa.adkpproject.users.Advertiser'}">
                    <c:forEach items="${user.getConfirmAdDeals()}" var="deal">
                        <div class="account">
                            <tr><td>
                                <div><h2>${deal.distributor.nameOrganization}</h2></div>
                                <div><c:out value="${deal.distributor.getFullAgentName()}"/></div>
                                <div><c:out value="Продукт: ${deal.product.name}"/></div>
                                <div class="typeAd"><c:out value="Тип : ${deal.product.adType.name}"/></div>
                                <div><form method="post" action="viewDeal?dealId=${deal.id}">
                                    <input type="submit" value="Подробная информация" class="smallButton">
                                </form></div>
                            </td></tr>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${user.getClass().name eq 'by.bsuir.filinovichsa.adkpproject.users.Distributor'}">
                    <c:forEach items="${user.getConfirmAdDeals()}" var="deal">
                        <div class="account">
                            <tr><td>
                                <div><h2>${deal.product.owner.nameOrganization}</h2></div>
                                <div><c:out value="${deal.product.owner.getFullAgentName()}"/></div>
                                <div><c:out value="Продукт: ${deal.product.name}"/></div>
                                <div class="typeAd"><c:out value="Тип : ${deal.product.adType.name}"/></div>
                                <div><form method="post" action="viewDeal?dealId=${deal.id}">
                                    <input type="submit" value="Подробная информация" class="smallButton">
                                </form></div>
                            </td></tr>
                        </div>
                    </c:forEach>
                </c:if>
            </c:if>

        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
