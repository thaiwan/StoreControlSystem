<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список продуктов</title>
</head>
<body>

<h3>Все продукты:</h3>(<a href="addproduct">добавить</a>)
<ol>
    <%--@elvariable id="products" type="java.util.List"--%>
    <c:forEach items="${products}" var="product">
        <li>
            ID: ${product.productId} | Наименование: ${product.name}
            <a href="addproduct?edit=${product.productId}">(редактировать</a> | <a href="deleteproduct?id=${product.productId}">удалить)</a>
        </li>
    </c:forEach>
</ol>

</body>
</html>