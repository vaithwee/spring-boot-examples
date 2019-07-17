<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2019-07-17
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(function () {
            var pojo = {
              id: null,
              date: '2017-08-08',
              doubleValue : 999999.09,
              integer: 100,
              range: 1000,
              email: 'email',
              size: 'adv1212',
              regexp : 'a,b,c,d'
            };
           $.ajax({
               url: "./validate",
               contentType: "application/json",
               method: 'post',
               data: JSON.stringify(pojo),
               success : function (data) {
                   alert(data.toLocaleString());
               }
           })
        });
    </script>
</head>
<body>

</body>
</html>
