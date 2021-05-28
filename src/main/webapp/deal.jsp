<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Сделка</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">

            <c:set var="advertiser" value="${deal.product.owner}" scope="request"/>
            <c:import url="advertiserOut.jsp"/>

            <c:set var="distributor" value="${deal.distributor}" scope="request"/>
            <c:import url="distributorOut.jsp"/>

            <h2>Реклама</h2>
            <c:forEach var="i" begin="0" end="${deal.getAd().getCountFields() - 1}" step="1">
                <div class="input-field-info">
                    <div class="info-left">
                        ${deal.getAd().getField(i).split(": ")[0]}
                    </div>
                    <div class="info-right">
                        ${deal.getAd().getField(i).split(": ")[1]}
                    </div>
                </div>
            </c:forEach>


            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Комментарий: "/>
                </div>
                <div class="info-right">
                    <c:out value="${deal.comment}"/>
                </div>
            </div>

            <c:set var="product" value="${deal.product}" scope="request"/>
            <c:import url="productTitle.jsp"/>

            <c:if test="${deal.status.name eq 'Заключено'}">
                <c:set var="color" value="green"/>
            </c:if>
            <c:if test="${deal.status.name ne 'Заключено'}">
                <c:set var="color" value="orange"/>
            </c:if>
            <div class="input-field-info">
                <div class="info-left">
                    <c:out value="Статус: "/>
                </div>
                <div class="info-right" style="color: ${color}">
                    <c:out value="${deal.status.name}"/>
                </div>
            </div>

        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
