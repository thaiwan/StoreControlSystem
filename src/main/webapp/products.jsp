<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список продуктов</title>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<ul>
    <li><a href="stores">Магазины</a></li>
    <li><a class="active" href="products">Продукты</a></li>
    <li><a href="transactions">Транзакции</a></li>
    <li style="float:right"><a href="about.jsp">About</a></li>
</ul>
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