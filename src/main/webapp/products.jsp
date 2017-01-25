<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список продуктов</title>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css">
    <script src='js/tablesort.min.js'></script>
    <script src='js/tablesort.number.js'></script>
    <script src='js/tablesort.date.js'></script>
</head>
<body>
<ul>
    <li><a href="stores">Магазины</a></li>
    <li><a class="active" href="products">Продукты</a></li>
    <li><a href="transactions">Транзакции</a></li>
    <li style="float:right"><a href="about.jsp">About</a></li>
</ul>
<h3>Все продукты:</h3><a href="addproduct"><img src="icons/add.png" title="Добавить продукт"></a>
<br>
<br>
<table id="table-id">
    <thead>
        <tr>
            <th>ID</th>
            <th>Наименование</th>
            <th data-sort-method='none'>Действия</th>
        </tr>
    </thead>
    <tbody>
        <%--@elvariable id="products" type="java.util.List"--%>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.productId}</td>
                <td>${product.name}</td>
                <td><a href="addproduct?edit=${product.productId}"><img src="icons/edit.png"></a>
                    <a href="deleteproduct?id=${product.productId}"><img src="icons/delete.png"></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
    <script>
        new Tablesort(document.getElementById('table-id'));
    </script>
</body>
</html>