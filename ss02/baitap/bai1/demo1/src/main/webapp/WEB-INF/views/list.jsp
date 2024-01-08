<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/2/2024
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <c:forEach var="s" items="strings">
<tr>${s}</tr>
</c:forEach>
</table>

<form action="/all/listAll" method="get">
    <label><input type="checkbox" name="spice" value="mayo"> Mayo</label>
    <label><input type="checkbox" name="spice" value="mustard"> Mustard</label>
    <label><input type="checkbox" name="spice" value="ketchup"> Ketchup</label>
    <label><input type="checkbox" name="spice" value="lettuce"> Lettuce</label>
    <label><input type="checkbox" name="spice" value="tomato"> Tomato</label>
    <input type="submit" value="send">
</form>
<table>

</table>

</body>
</html>
