<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2019-07-15
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>
<center>
    <table border="1">
        <tr>
            <td>标签</td>
            <td>值</td>
        </tr>
        <tr>
            <td>Id</td>
            <td><c:out value="${user.id}"></c:out> </td>
        </tr>
        <tr>
            <td>Username</td>
            <td><c:out value="${user.username}"></c:out> </td>
        </tr>
        <tr>
            <td>note</td>
            <td><c:out value="${user.note}"></c:out> </td>
        </tr>

    </table>
</center>
</body>
</html>
