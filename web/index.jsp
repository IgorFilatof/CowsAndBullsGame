<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Game CowsAndBulls</title>


</head>
<body>
<h1>Введите имя</h1>
<form action="./Servlet" method="get">
    <tr>
        <td><input type="text" name="user" size="40"/> </td>
    </tr>
    <br />
    <h1>Введите число</h1>
    <tr>
        <td><input type="text" name="userNumber" size="40"/> </td>
    </tr>

    <tr>
        <td >
            <input type="submit"  value="Ввод" />
        </td>

</form>

<c:forEach var="num" items="${topUser}">
    <p>${num}</p>
</c:forEach>
</body>

</html>