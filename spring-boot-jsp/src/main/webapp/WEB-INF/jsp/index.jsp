<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2019-07-24
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Welcome <span style="color: red;">${requestScope.username}</span></h2>
<table>
    <thead>
        <tr>
            <th>id</th>
            <th>image</th>
            <th>title</th>
            <th>author</th>
            <th>price</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${requestScope.books}" var="book">
            <tr>
                <th>${book.id}</th>
                <th>${book.image}</th>
                <th>${book.title}</th>
                <th>${book.author}</th>
                <th>${book.price}</th>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
