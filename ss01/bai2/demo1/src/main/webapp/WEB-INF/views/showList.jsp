<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/30/2023
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dictionary Search</h2>
<fieldset>
    <form action="/dictionary/searchList" method="get">
    <legend>Enter the Search</legend>
    <table>
        <tr>
            <td>Search</td>
            <td><input type="text" name="key"></td>
        </tr>
        <tr>
            <td><input type="submit" name="Search"></td>
        </tr>
    </table>
    </form>
</fieldset>

</body>
</html>
