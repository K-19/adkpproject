<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Продукт</h2>
    <div><c:out value="${product.name}"/></div>
    <div><c:out value="${product.description}"/></div>
    <div><c:out value="Тип необходимой рекламы: ${product.adType.name}"/></div>
</body>
</html>
