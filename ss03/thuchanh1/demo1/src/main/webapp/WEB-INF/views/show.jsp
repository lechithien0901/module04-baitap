<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/3/2024
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${message}</h1>
<fieldset>
    <legend>Information</legend>
    <table>
        <tr>
            <td>${id}</td>
            <td>${name}</td>
            <td>${contactNumber}</td>
        </tr>
    </table>
</fieldset>

</body>
</html>
