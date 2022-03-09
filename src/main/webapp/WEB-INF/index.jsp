<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Index<</title>
</head>
<body>
<%--<p>Hello?</p>--%>
<div>
<%--    <c:forEach var="rS" items="${requestScope}">--%>
<%--        <p>KEY: ${rS.key} ----> VALUE: ${rS.value}</p>--%>
<%--    </c:forEach>--%>
    <c:forEach var="rS" items="${requestScope}">
        <c:if test = "${rS.key == 'allEmployees'}">
            <table style="width:50%; justify-content: center; margin: auto; text-align: center; border: solid black 1px">
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Date Joined</th>
            </tr>
            <c:forEach var="employee" items="${rS.value}">
                <tr>
                    <td>${employee.getName()}</td>
                    <td>${employee.getAge()}</td>
                    <td>${employee.getDateJoined()}</td>
                </tr>
            </c:forEach>
            </table>
        </c:if>
    </c:forEach>
</div>

</body>
</html>