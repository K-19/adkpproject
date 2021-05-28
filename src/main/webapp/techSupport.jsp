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


            <c:if test="${user.getAllMessages().size() eq 0}">
                <h3>Список вопросов пуст</h3>
            </c:if>
            <c:if test="${user.getAllMessages().size() ne 0}">
                <c:forEach items="${user.getAllMessages()}" var="message">
                    <div class="account">
                        <tr><td>

                            <div class="smallHeadText">Вопрос от ${message.user.nameOrganization}</div>
                            <div>${message.text}</div>
                            <c:if test="${message.answer eq null}">
                            <form method="post" action="answerTheQuestion?id=${message.id}">
                                <div style="margin-bottom: 20px; height: 100px">
                                    <textarea minlength="20" maxlength="200" name="textAnswer" required style="font-size: 16px; resize: none; width: 80%; height: 100%"></textarea>
                                </div>
                                <div>
                                    <input type="submit" value="Отправить ответ" class="button"/>
                                </div>
                            </form>
                            </c:if>
                            <c:if test="${message.answer ne null}">
                                <div class="smallHeadText">Ответ от администратора ${user.name} ${user.surname}</div>
                                <div>${message.answer}</div>
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
