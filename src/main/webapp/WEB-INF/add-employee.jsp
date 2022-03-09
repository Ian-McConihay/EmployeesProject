<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ianmcconihay
  Date: 2/26/22
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<div>
<form action="add-employee" method="post">
    <input type="text" name="name"> Enter Name
    <input type="text" name="age"> Enter Age
    <input type="submit" >
</form>
</div>
</body>
</html>
