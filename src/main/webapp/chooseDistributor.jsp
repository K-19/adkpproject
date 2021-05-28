<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Выбор клиента</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">


        <h1>Подходящие партнёры</h1>
        <c:forEach items="${distributors}" var="distributor">
            <div class="account">
                <tr><td>
                    <div><c:out value="${distributor.getNameOrganization()}"/></div>
                    <div><c:out value="${distributor.getDescription()}"/></div>
                    <div><c:out value="${distributor.getType().getName()}"/></div>
                    <div><c:out value="${distributor.getDistributorType().getName()}"/></div>
                        <div><form method="post" action="signUpDeal?dist=${distributor.getId()}">
                            <input type="submit" value="Посмотреть полную информацию" class="smallButton">
                        </form></div>
                </td></tr>
            </div>
        </c:forEach>



        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
