<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Отправленные заявки</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">


            <c:if test="${user.getWaitingDistributorsProducts().size() eq 0}">
                <h3>Список ожидающих ответа дистрибьютора продуктов пуст</h3>
            </c:if>
            <c:if test="${user.getWaitingDistributorsProducts().size() ne 0}">
                <c:forEach items="${user.getWaitingDistributorsProducts()}" var="product">
                    <div class="account">
                        <tr><td>
                            <div><h2>${product.name}</h2></div>
                            <div><c:out value="Товар №${product.id}"/></div>
                            <div><c:out value="${product.description}"/></div>
                            <div class="typeAd"><c:out value="Тип желаемой рекламы: ${product.adType.name}"/></div>
                            <c:if test="${product.deal.status.name eq 'Ожидается ответ адвертайзера'}">
                                <div style="color: yellowgreen"><c:out value="Пришли правки от дистрибьютора!"/></div>
                                <div><form method="post" action="editDeal?dealId=${product.deal.id}">
                                    <input type="submit" value="Подробная информация" class="smallButton">
                                </form></div>
                            </c:if>
                            <c:if test="${product.deal.status.name eq 'Ожидается ответ дистрибьютора'}">
                                <div style="color: orange"><c:out value="Ждём ответ клиента"/></div>
                                <div><form method="post" action="viewDeal?dealId=${product.deal.id}">
                                    <input type="submit" value="Подробная информация" class="smallButton">
                                </form></div>
                            </c:if>
                            <c:if test="${product.deal.status.name eq 'Отклонено дистрибьютором'}">
                                <div style="color: red"><c:out value="Отклонено дистрибьютором"/></div>
                                <div><form method="post" action="deleteDeal?dealid=${product.deal.id}&to=advertiser">
                                    <input type="submit" value="Удалить сделку" class="smallButton">
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
