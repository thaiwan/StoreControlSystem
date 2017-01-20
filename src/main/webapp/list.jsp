<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>

<h3>Все пользователи:</h3>(<a href="add">добавить</a>)
<ol>
    <c:forEach items="${stores}" var="store">
        <li>
                ${store.storeId}
            <a href="add?edit=${store.storeId}">редактировать</a> | <a href="delete?id=${store.storeId}">удалить</a>
        </li>
    </c:forEach>
</ol>

</body>
</html>