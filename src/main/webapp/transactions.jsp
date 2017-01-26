<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Список транзакций</title>
        <link href="css/mystyle.css" rel="stylesheet" type="text/css">
        <script src='js/tablesort.min.js'></script>
        <script src='js/tablesort.number.js'></script>
        <script src='js/tablesort.date.js'></script>
        <script src='js/filtering.js'></script>
    </head>
    <body onload="sortAndSum()">
        <ul>
            <li><a href="stores">Магазины</a></li>
            <li><a href="products">Продукты</a></li>
            <li><a class="active" href="transactions">Транзакции</a></li>
            <li style="float:right"><a href="about.jsp">About</a></li>
        </ul>
        <h3>Все транзакции:</h3><a href="addtransaction"><img src="icons/add.png" title="Добавить транзакцию"></a>
        <br>
        <br>
        <%--@elvariable id="transactions" type="java.util.List"--%>
        <%--@elvariable id="transaction" type="entity.Transaction"--%>
        <input type="text" id="productFilter" onkeyup="filterProcessingFunction()" placeholder="Фильтровать по продуктам...">
        <br>
        C:
        <br>
        <input title="С" type="date" id="fromDateFilter" onchange="filterProcessingFunction()">
        <br>
        По:
        <br>
        <input title="По" type="date" id="toDateFilter" onchange="filterProcessingFunction()">
        <table id="table-id">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Магазин</th>
                    <th>Продукт</th>
                    <th>Дата</th>
                    <th>Количество</th>
                    <th>Стоимость</th>
                    <th data-sort-method='none'>Действия</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${transactions}" var="transaction">
                    <tr>
                        <td>${transaction.transactionId}</td>
                        <td>${transaction.store.address}</td>
                        <td>${transaction.product.name}</td>
                        <td>${transaction.transactionDate}</td>
                        <td>${transaction.count}</td>
                        <td class="countable">${transaction.cost}</td>
                        <td><a href="addtransaction?edit=${transaction.transactionId}"><img src="icons/edit.png"></a>
                            <a href="deletetransaction?id=${transaction.transactionId}"><img src="icons/delete.png"></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <div class="totalcostcontainer"><b>Общая стоимость: </b><span id="totalcost"></span></div>
    </body>
</html>