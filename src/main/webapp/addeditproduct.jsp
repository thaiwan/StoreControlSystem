<%--@elvariable id="product" type="entity.Product"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<ul>
    <li><a href="stores">Магазины</a></li>
    <li><a class="active" href="products">Продукты</a></li>
    <li><a href="transactions">Транзакции</a></li>
    <li style="float:right"><a href="about.jsp">About</a></li>
</ul>
<h3>Добавление | редактирование продукта</h3>
<form action="addproduct" method="post">
    <label for="name">Введите наименование: <br>
        <input type="text" id="name" value="${product.name}" name="name" required/>
    </label>  <br />
    <input type="hidden" name="id" value="${product.productId}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>