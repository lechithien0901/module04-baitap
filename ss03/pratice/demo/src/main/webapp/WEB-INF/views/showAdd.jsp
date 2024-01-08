<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/3/2024
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="student" action="/student/add">
    ID:
    <form:input type="number" path="id"/>
    Name:
    <form:input type="text" path="name"/>
    Gender:
    <form:radiobutton path="gender" value="0"/>Nữ
    <form:radiobutton path="gender" value="1"/>Nam
    Langueges:
    <form:select path="languages" multiple="${false}">
        <form:options items="${listLangues}"/>
    </form:select>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>
