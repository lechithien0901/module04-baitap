<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/3/2024
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="employee" action="/employee/add" method="post">
    Id:<form:input path="id" type="text"/>
    Name:<form:input path="name" type="text"/>
    ContactNumber:<form:input path="contactNumber" type="text"/>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>
