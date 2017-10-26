<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Game CowsAndBulls</title>


</head>
<body>
<h1>Введите числа</h1>
<form action="./Servlet" method="get">
    <tr>
        <td><input type="text" name="userNumber" size="40"/> </td>
    </tr>

    <tr>
        <td colspan="2">
            <input type="submit"  value="Add" />
        </td>

</form>>

<h3>Число: ${number}</h3>
<h3>Быки и Коровы: ${string}</h3>
<h3> ${win}</h3>
<c:forEach var="num" items="${listCowsAndBulls}">
    <tr>
        <td>${num}</td>
        <br/>
    </tr>
</c:forEach>
<br/>

<c:forEach var="num" items="${listNumber}">
    <tr>
        <td >${num}</td>
        <br/>
    </tr>
</c:forEach>

</body>

</html>
