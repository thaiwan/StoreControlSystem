<%--@elvariable id="store" type="entity.Store"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
</head>
<body>

<form action="addstore" method="post">
    <label for="address">Введите адрес:
        <input type="text" id="address" value="${store.address}" name="address" />
    </label>  <br />
    <input type="hidden" name="id" value="${store.storeId}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>