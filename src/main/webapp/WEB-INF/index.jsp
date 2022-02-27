<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Index<</title>
</head>
<body>

<div>
    <c:forEach var="employee" items="all-employees">
        <table style="width:50%; justify-content: center; margin: auto">
        <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Date Joined</th>
        </tr>
        <tr>
        <td>${employee.name}</td>
        <td>${employee.age}</td>
        <td>${employee.dateJoined}</td>
        </tr>
        </table>
    </c:forEach>
</div>

</body>
</html>