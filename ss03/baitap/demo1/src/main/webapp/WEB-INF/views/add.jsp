<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/4/2024
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/all/show">Back to the menu</a>
<fieldset>
    <legend>Box Email</legend>
    <table>
        <tr>
            <td>Languages:</td>
           <c:forEach var="s" items="${email.languages}">
               <td>${s}</td>
           </c:forEach>

        </tr>
        <tr>
            <td>Page Size:</td>

            <c:forEach var="c" items="${email.pageSize}">
                <td>${c}</td>
            </c:forEach>

        </tr>
        <tr>
            <td>Spams filter:</td>
            <td>this is ${email.spam}</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>${email.signature}</td>
        </tr>
    </table>
</fieldset>

</body>
</html>
