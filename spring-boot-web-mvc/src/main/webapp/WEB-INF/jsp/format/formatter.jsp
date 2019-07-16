<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2019-07-16
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Format</title>
</head>
<body>
    <form action="./commit" method="post">
        <table>
            <tr>
                <td>Date</td>
                <td>
                    <input type="text" name="date" value="2019-09-09" />
                </td>
            </tr>
            <tr>
                <td>Fortune</td>
                <td>
                    <input type="text" name="number" value="1,234,567.89" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="Submit" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
