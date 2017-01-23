<%--@elvariable id="store" type="entity.Store"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<ul>
    <li><a class="active" href="stores">Магазины</a></li>
    <li><a href="products">Продукты</a></li>
    <li><a href="transactions">Транзакции</a></li>
    <li style="float:right"><a href="about.jsp">About</a></li>
</ul>
<h3>Добавление | редактирование магазина</h3>
<form action="addstore" method="post">
    <label for="address">Введите адрес: <br>
        <input type="text" id="address" value="${store.address}" name="address" />
    </label>  <br/>
    <input type="hidden" name="id" value="${store.storeId}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>