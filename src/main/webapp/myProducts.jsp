<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Мои товары</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">


            <c:if test="${user.products.size() eq 0}">
                <h3>Ваш список продуктов пуст</h3>
            </c:if>
            <c:if test="${user.products.size() ne 0}">
                <c:forEach items="${user.products}" var="product">
                    <div class="account">
                        <tr><td>
                            <div><h2>${product.name}</h2></div>
                            <div><c:out value="Продукт №${product.id}"/></div>
                            <div><c:out value="${product.description}"/></div>
                            <div class="typeAd"><c:out value="Тип желаемой рекламы: ${product.adType.name}"/></div>
                            <c:if test="${product.deal ne null}">
                                <c:if test="${product.deal.status.name eq 'Заключено'}">
                                    <div style="color: green"><c:out value="Реклама запущена"/></div>
                                </c:if>
                                <c:if test="${product.deal.status.name ne 'Заключено'}">
                                    <div style="color: orange"><c:out value="В процессе"/></div>
                                    <div><form method="post" action="deleteProduct?dealId=${product.id}">
                                        <input type="submit" value="Удалить продукт" class="cancelButton">
                                    </form></div>
                                </c:if>
                                <div><form method="post" action="viewDeal?dealId=${product.deal.id}">
                                    <input type="submit" value="Подробная информация" class="smallButton">
                                </form></div>
                            </c:if>
                            <c:if test="${product.deal eq null}">
                            <div><form method="post" action="chooseDistributor?product=${product.id}">
                                <input type="submit" value="Найти дистрибьютора" class="smallButton">
                            </form></div>
                                <div><form method="post" action="deleteProduct?dealId=${product.id}">
                                    <input type="submit" value="Удалить продукт" class="cancelButton">
                                </form></div>
                            </c:if>
                        </td></tr>
                    </div>
                </c:forEach>
            </c:if>

            <c:if test="${addProduct eq null}">
                <form method="get" action="addProduct">
                    <input type="submit" value="Добавить новый товар" class="button"/>
                </form>
            </c:if>
            <c:if test="${addProduct ne null}">
                <form method="post" action="addProduct">
                    <div class="input-field">
                        <div class="label-block">Название продукта</div>
                        <div class="info-block">
                            <input minlength="2" maxlength="50" type="text" name="nameProduct" required>
                        </div>
                    </div>
                    <div class="input-field-text">
                        <div class="label-block">Описание продукта</div>
                        <div class="info-block">
                            <textarea minlength="20" maxlength="200" name="descriptionProduct" required></textarea>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Тип рекламы</div>
                        <div class="info-block">
                            <select name="adCode" class="inputForm">
                                <option>На дирижабле</option>
                                <option>На воздушном шаре</option>
                                <option>В теле-радио эфире</option>
                                <option>На мероприятии</option>
                                <option>На видеохостинге</option>
                                <option>На интернет-ресурсе</option>
                                <option>В печатных СМИ</option>
                                <option>Печатная</option>
                                <option>На уличных коммуникациях</option>
                                <option>На сувенирах</option>
                            </select>
                        </div>
                    </div>
                    <div class="margin-bottom">
                        <input type="submit" value="Добавить продукт" class="button">
                    </div>
                </form>
            </c:if>

        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
