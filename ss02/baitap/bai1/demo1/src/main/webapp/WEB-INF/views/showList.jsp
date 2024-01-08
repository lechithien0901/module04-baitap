<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/2/2024
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span>
    <span>Đây là những gia vị bạn chọn dành cho bữa ăn SanchWich : </span>
    <c:forEach var="s" items="${list}">
        <c:out value="${s}"/>
    </c:forEach>
</span>


</body>
</html>
