<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2019-07-18
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="./page?language=zh_CN">简体中文</a>
    <a href="./page?language=en_US">美国英文</a>

<h2><spring:message code="msg" /> </h2>
<h2>Locale: ${pageContext.response.locale}</h2>
</body>
</html>
