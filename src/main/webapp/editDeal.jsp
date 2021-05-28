<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Сделка №${deal.id}</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">

            <c:if test="${deal.status.name eq 'Ожидается ответ дистрибьютора'}">
                <c:set var="index" value="0" scope="request"/>
                <c:set var="advertiser" value="${deal.product.owner}" scope="request"/>
                <c:import url="advertiserOut.jsp"/>
            </c:if>
            <c:if test="${deal.status.name eq 'Ожидается ответ адвертайзера'}">
                <c:set var="index" value="1" scope="request"/>
                <c:set var="distributor" value="${deal.distributor}" scope="request"/>
                <c:import url="distributorOut.jsp"/>
            </c:if>


            <c:set var="product" value="${deal.product}" scope="request"/>
            <c:import url="productTitle.jsp"/>

            <form method="post" action="confirmDeal?edit=true&index=${index}">

            <!-- Форма для рекламы на ДИРИЖАБЛЕ -->
                <c:if test="${deal.product.adType.name eq 'На дирижабле'}">
                    <c:import url="adPages/airshipInput.jsp"/>
                </c:if>
                <c:if test="${deal.product.adType.name eq 'На воздушном шаре'}">
                    <c:import url="adPages/balloonInput.jsp"/>
                </c:if>
                <c:if test="${deal.product.adType.name eq 'В теле-радио эфире'}">
                    <c:import url="adPages/broadcastingInput.jsp"/>
                </c:if>
                <c:if test="${deal.product.adType.name eq 'На мероприятии'}">
                    <c:import url="adPages/eventInput.jsp"/>
                </c:if>
                <c:if test="${deal.product.adType.name eq 'На видеохостинге'}">
                    <c:import url="adPages/internetInput.jsp"/>
                </c:if>
                <c:if test="${deal.product.adType.name eq 'На интернет-ресурсе'}">
                    <c:import url="adPages/mediaNetInput.jsp"/>
                </c:if>
                <c:if test="${deal.product.adType.name eq 'В печатных СМИ'}">
                    <c:import url="adPages/mediaPrintInput.jsp"/>
                </c:if>
                <c:if test="${deal.product.adType.name eq 'Печатная'}">
                    <c:import url="adPages/otherPrintInput.jsp"/>
                </c:if>
                <c:if test="${deal.product.adType.name eq 'На уличных коммуникациях'}">
                    <c:import url="adPages/outdoorInput.jsp"/>
                </c:if>
                <c:if test="${deal.product.adType.name eq 'На сувенирах'}">
                    <c:import url="adPages/souvenirInput.jsp"/>
                </c:if>
<%--                //TODO:--%>

                <div class="input-field-text">
                    <div class="label-block">Комментарий</div>
                    <div class="info-block">
                        <textarea minlength="10" maxlength="200" name="comment" required>${deal.comment}</textarea>
                    </div>
                </div>
                <div class="margin-bottom">
                    <input type="submit" value="Отправить правки" class="button">
                </div>
            </form>

            <c:if test="${deal.status.name eq 'Ожидается ответ дистрибьютора'}">
                <form method="post" action="confirmDeal?index=${index}">
                    <div class="margin-bottom">
                        <input type="submit" value="Подтвердить предложение" class="button">
                    </div>
                </form>
            </c:if>
            <form method="post" action="cancelDeal?iddeal=${deal.id}&owner=${index}">
                <div class="margin-bottom">
                    <input type="submit" value="Отклонить" class="button">
                </div>
            </form>

        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
