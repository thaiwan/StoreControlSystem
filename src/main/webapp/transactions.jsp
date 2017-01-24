<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список транзакций</title>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css">

</head>
<body>
<ul>
    <li><a href="stores">Магазины</a></li>
    <li><a href="products">Продукты</a></li>
    <li><a class="active" href="transactions">Транзакции</a></li>
    <li style="float:right"><a href="about.jsp">About</a></li>
</ul>
<h3>Все транзакции:</h3>(<a href="addtransaction">добавить</a>)
<ol>
            <%--@elvariable id="transactions" type="java.util.List"--%>
            <%--@elvariable id="transaction" type="entity.Transaction"--%>
            <c:forEach items="${transactions}" var="transaction">
                <li>
                    ID: ${transaction.transactionId} | Магазин: ${transaction.store.address} | Продукт: ${transaction.product.name} |
                    Дата: ${transaction.transactionDate} | Количество: ${transaction.count} | Стоимость: ${transaction.cost}
                    <a href="addtransaction?edit=${transaction.transactionId}">(редактировать</a> | <a href="deletetransaction?id=${transaction.transactionId}">удалить)</a>
                </li>
    </c:forEach>
</ol>

</body>
</html>