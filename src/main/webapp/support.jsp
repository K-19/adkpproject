<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Техподдержка</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">
            <h3>Сообщение для администрации</h3>
            <form method="post" action="sendTechMessage">
                <div style="margin-bottom: 20px; height: 100px">
                    <textarea minlength="20" maxlength="200" name="textMessage" required style="font-size: 16px; resize: none; width: 80%; height: 100%"></textarea>
                </div>
                <div>
                    <c:if test="${error ne null}">
                        <c:out value="${error}"/>
                    </c:if>
                </div>
                <div>
                    <input type="submit" value="Отправить сообщение" class="button"/>
                </div>
            </form>
            <c:forEach var="message" items="${user.getMessages()}">
            <div class="account">
                <tr><td>
                    <div style="font-size: 18px"><c:out value="Вопрос: "/></div>
                    <div><c:out value="${message.getText()}"/></div>
                    <c:if test="${message.hasAnswer() eq true}">
                        <div style="font-size: 18px"><c:out value="Ответ администратора: "/></div>
                        <div style="color: green"><c:out value="${message.getAnswer()}"/></div>
                    </c:if>
                    <c:if test="${message.hasAnswer() eq false}">
                        <div style="color: orange"><c:out value="Ожидам ответ администратора"/></div>
                    </c:if>
                </td></tr>
            </div>
            </c:forEach>
        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
