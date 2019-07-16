<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2019-07-16
  Time: 09:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(function () {
           $("#submit").click(function () {
               var username = $("#username").val();
               var note = $("#note").val();
               if ($.trim(username) == '') {
                   alert("username is null");
                   return;
               }
               var params = {
                   username : username,
                   note: note
               };
               console.log(params);
               $.ajax({
                   url: "./insert",
                   contentType: "application/json;charset=UTF-8",
                   dataType: "json",
                   data: JSON.stringify(params),
                   type: "post",
                   success: function (data) {
                       console.log(data);
                   }
               });
           });
        });
    </script>

</head>
<body>
    <div style="margin: 20px 0;"></div>
    <form id="insertForm">
        <table>
            <tr>
                <td>username</td>
                <td><input id="username" name="username" /></td>
            </tr>
            <tr>
                <td>note</td>
                <td><input id="note" name="note" /></td>
            </tr>
            <tr>
                <td></td>
                <td align="right">
                    <input type="button" value="Submit" id="submit" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
