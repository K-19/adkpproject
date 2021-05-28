<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация сделки</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">

            <c:import url="distributorOut.jsp"/>

            <c:import url="productTitle.jsp"/>

            <form method="post" action="sendDealToDist">

            <!-- Форма для рекламы на ДИРИЖАБЛЕ -->
                <c:if test="${product.adType.name eq 'На дирижабле'}">
                    <c:import url="adPages/airshipInput.jsp"/>
                </c:if>
                <c:if test="${product.adType.name eq 'На воздушном шаре'}">
                    <c:import url="adPages/balloonInput.jsp"/>
                </c:if>
                <c:if test="${product.adType.name eq 'В теле-радио эфире'}">
                    <c:import url="adPages/broadcastingInput.jsp"/>
                </c:if>
                <c:if test="${product.adType.name eq 'На мероприятии'}">
                    <c:import url="adPages/eventInput.jsp"/>
                </c:if>
                <c:if test="${product.adType.name eq 'На видеохостинге'}">
                    <c:import url="adPages/internetInput.jsp"/>
                </c:if>
                <c:if test="${product.adType.name eq 'На интернет-ресурсе'}">
                    <c:import url="adPages/mediaNetInput.jsp"/>
                </c:if>
                <c:if test="${product.adType.name eq 'В печатных СМИ'}">
                    <c:import url="adPages/mediaPrintInput.jsp"/>
                </c:if>
                <c:if test="${product.adType.name eq 'Печатная'}">
                    <c:import url="adPages/otherPrintInput.jsp"/>
                </c:if>
                <c:if test="${product.adType.name eq 'На уличных коммуникациях'}">
                    <c:import url="adPages/outdoorInput.jsp"/>
                </c:if>
                <c:if test="${product.adType.name eq 'На сувенирах'}">
                    <c:import url="adPages/souvenirInput.jsp"/>
                </c:if>
                    <div class="input-field-text">
                        <div class="label-block">Комментарий</div>
                        <div class="info-block">
                            <textarea minlength="20" maxlength="200" name="comment" required>${deal.comment}</textarea>
                        </div>
                    </div>
                    <input type="submit" value="Оформить рекламу" class="smallButton">
                </form>
            <form method="get" action="sendDealToDist">
                <input type="submit" value="Отменить" class="button">
            </form>



        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
