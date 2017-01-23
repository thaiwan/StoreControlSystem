<%--@elvariable id="transaction" type="entity.Transaction"--%>
<%--@elvariable id="stores" type="java.util.List"--%>
<%--@elvariable id="products" type="java.util.List"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<ul>
    <li><a href="stores">Магазины</a></li>
    <li><a href="products">Продукты</a></li>
    <li><a class="active" href="transactions">Транзакции</a></li>
    <li style="float:right"><a href="about.jsp">About</a></li>
</ul>
<h3>Добавление | редактирование транзакции</h3>
<form action="addtransaction" method="post">
    <label for="storedropdown">Выберите магазин: <br>
        <select id="storedropdown" name="storeId">
            <c:forEach items="${stores}" var="store">
                <option name="storeId" id="storeId" value="${store.storeId}">${store.address}</option>
            </c:forEach>
        </select>
    </label><br>
    <label for="productdropdown">Выберите тип продукта: <br>
        <select id="productdropdown" name="productId">
            <c:forEach items="${products}" var="product">
                <option name="productId" id="productId" value="${product.productId}">${product.name}</option>
            </c:forEach>
        </select>
    </label><br>
    <label for="transactionDate">Выберите дату: <br>
        <%--<input type="text" id="transactionDate" value="${transaction.transactionDate}" name="transactionDate" />--%>
        <input type="date" name="transactionDate" id="transactionDate" value="${transaction.transactionDate}">
    </label>  <br />
    <label for="count">Выберите количество продукта: <br>
        <input type="number" id="count" value="${transaction.count}" name="count" />
    </label>  <br />
    <label for="cost">Выберите стоимость: <br>
        <input type="number" id="cost" value="${transaction.cost}" name="cost" />
    </label>  <br />
    <input type="hidden" name="id" value="${transaction.transactionId}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>