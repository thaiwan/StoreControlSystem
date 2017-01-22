<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
</head>
<body>

<form action="add" method="post">
    <label for="address">Введите адрес:
        <input type="text" id="address" value="${store.name}" name="name" />
    </label>  <br />
    <input type="hidden" name="id" value="${store.id}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>