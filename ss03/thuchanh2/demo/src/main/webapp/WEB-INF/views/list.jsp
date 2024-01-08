<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/3/2024
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>Information</legend>
    <table>
        <tr>
            <td>account:</td>
            <td>${user.account}</td>
        </tr>
        <tr>
            <td>password:</td>
            <td>${user.password}</td>
        </tr>
        <tr>
            <td>name:</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>email:</td>
            <td>${user.email}</td>
        </tr><tr>
        <td>age:</td>
        <td>${user.age}</td>
    </tr>
    </table>
</fieldset>

</body>
</html>
