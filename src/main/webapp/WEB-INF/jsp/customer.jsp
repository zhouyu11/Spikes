<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="utf-8" %>
<html>
<head>customer</head>
<body>
    <h1>customer list</h1>

    <table>
        <tr>
            <td>name</td>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>

</html>