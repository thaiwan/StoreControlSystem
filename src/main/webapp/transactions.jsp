<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список транзакций</title>
</head>
<body>

<h3>Все магазины:</h3>(<a href="addstore">добавить</a>)
<ol>
    <%--@elvariable id="transactions" type="java.util.List"--%>
    <c:forEach items="${transactions}" var="transaction">
        <li>
            ID: ${transaction.transactionId} | Адрес: ${transaction.count}
            <a href="addtransaction?edit=${transaction.transactionId}">(редактировать</a> | <a href="deletetransaction?id=${transaction.transactionId}">удалить)</a>
        </li>
    </c:forEach>
</ol>

</body>
</html>