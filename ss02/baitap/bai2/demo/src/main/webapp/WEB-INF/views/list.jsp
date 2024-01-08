<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/2/2024
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/all/math" method="get">
    <h1>Calculator</h1>
    <table>
        <tr>
            <td><input type="text" name="value1"></td>
            <td><input type="text" name="value2"></td>
        </tr>
        <tr>
            <td><input type="submit" name="operation" value="Addition(+)"></td>
            <td><input type="submit" name="operation" value="Subtraction(-)"></td>
            <td><input type="submit" name="operation" value="Multiplication(X)"></td>
            <td><input type="submit" name="operation" value="Division(/)"></td>
        </tr>
        <h1>ResultDevision:${result}</h1>
    </table>
</form>

</body>
</html>
