<%--@elvariable id="transaction" type="entity.Transaction"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <label for="address">Выберите магазин: <br>
        <input type="text" id="address" value="${transaction.storeId}" name="storeId" />
    </label>  <br />
    <label for="address">Выберите дату: <br>
        <input type="text" id="transactionDate" value="${transaction.transactionDate}" name="transactionDate" />
    </label>  <br />
    <label for="address">Выберите количество продукта: <br>
        <input type="text" id="count" value="${transaction.count}" name="count" />
    </label>  <br />
    <label for="address">Выберите стоимость: <br>
        <input type="text" id="cost" value="${transaction.cost}" name="cost" />
    </label>  <br />
    <label for="address">Выберите тип продукта: <br>
        <input type="text" id="productId" value="${transaction.productId}" name="productId" />
    </label>  <br />
    <input type="hidden" name="id" value="${transaction.transactionId}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>