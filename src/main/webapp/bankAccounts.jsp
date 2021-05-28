<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Мои банковские счета</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyles.css">
</head>
<body>
<div class="scrolling">
    <div class="main">
        <c:import url="header.jsp"/>
        <div class="content">


            <c:if test="${user.bankAccounts.size() eq 0}">
                <h3>Ваш список банковских счетов пуст</h3>
            </c:if>
            <c:if test="${user.bankAccounts.size() ne 0}">
                <c:forEach items="${user.bankAccounts}" var="bankAccount">
                    <div class="account">
                        <tr><td>
                            <div>
                                <c:out value="Счёт №${bankAccount.id}"/>
                            </div>
                            <div>
                                <c:out value="${bankAccount.getFullInformation()}"/>
                            </div>
                            <div><form method="post" action="deleteBankAcc?accid=${bankAccount.id}">
                                <input type="submit" value="Удалить счет" class="cancelButton">
                            </form></div>
                        </td></tr>
                    </div>
                </c:forEach>
            </c:if>

            <div>
                <c:if test="${error ne null}">
                    <c:out value="${error}"/>
                </c:if>
            </div>


            <c:if test="${addAccount eq null}">
                <form method="get" action="addBankAccount">
                    <input type="submit" value="Добавить новый банковский счёт" class="button"/>
                </form>
            </c:if>
            <c:if test="${addAccount ne null}">
                <form method="post" action="addBankAccount">
                    <div class="input-field">
                        <div class="label-block">Код страны</div>
                        <div class="info-block">
                            <select name="countryCode" class="inputForm">
                                <c:forEach items="${user.getAllCountriesCode()}" var="code">
                                    <option>${code}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Контрольное число</div>
                        <div class="info-block">
                            <input type="text" minlength="2" maxlength="2" name="checkNumber" required>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Код банка BIC</div>
                        <div class="info-block">
                            <input type="text" minlength="4" maxlength="4" name="bankBICCode" required>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Балансовый счет</div>
                        <div class="info-block">
                            <input type="text" minlength="4" maxlength="4" name="balanceAccount" required>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Индивидуальный счет</div>
                        <div class="info-block">
                            <input type="text" minlength="16" maxlength="16" name="individualAccount" required>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Название отделения банка</div>
                        <div class="info-block">
                            <input type="text" minlength="10" maxlength="200" name="bankBranchName" required>
                        </div>
                    </div>
                    <div class="input-field">
                        <div class="label-block">Адрес банка</div>
                        <div class="info-block">
                            <input type="text" minlength="5" maxlength="50" name="bankBranchAddress" required>
                        </div>
                    </div>
                    <div class="margin-bottom">
                        <input type="submit" value="Добавить счёт" class="button">
                    </div>
                </form>
            </c:if>


        </div>
        <c:import url="footer.jsp"/>
    </div>
</div>
</body>
</html>
