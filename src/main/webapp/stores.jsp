<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список магазинов</title>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css">
    <script src='js/tablesort.min.js'></script>
    <script src='js/tablesort.number.js'></script>
    <script src='js/tablesort.date.js'></script>
</head>
<body>
<ul>
    <li><a class="active" href="stores">Магазины</a></li>
    <li><a href="products">Продукты</a></li>
    <li><a href="transactions">Транзакции</a></li>
    <li style="float:right"><a href="about.jsp">About</a></li>
</ul>
<h3>Все магазины:</h3><a href="addstore"><img src="icons/add.png" title="Добавить магазин"></a>
<br>
<br>
<table id="table-id">
    <thead>
        <tr>
            <th>ID</th>
            <th>Адрес</th>
            <th data-sort-method='none'>Действия</th>
        </tr>
    </thead>
    <tbody>
        <%--@elvariable id="stores" type="java.util.List"--%>
        <c:forEach items="${stores}" var="store">
            <tr>
                <td>${store.storeId}</td>
                <td>${store.address}</td>
                <td><a href="addstore?edit=${store.storeId}"><img src="icons/edit.png"></a>
                    <a href="deletestore?id=${store.storeId}"><img src="icons/delete.png"></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
    <script>
        new Tablesort(document.getElementById('table-id'));
    </script>
</body>
</html>