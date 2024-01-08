<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/4/2024
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        .select1 {
            width: 300px;
            margin-left: 100px;
        }

        .select2 {
            margin-left: 10px;


        }

        .spanfix {
            margin-left: 100px;
        }

        .form-group {
            display: block;
            margin-bottom: 10px;
        }

        .select3 {
            margin-left: 100px;
        }
        .select4{
            margin-left: 100px;

        }
        .select5{
            height: 80px;
            width: 300px;
        }
    </style>
</head>
<body>
<h1>Setting</h1>

<form:form method="post" action="/all/add" modelAttribute="email">
    <div class="form-group"><form:label path="languages">Languages:</form:label>
        <form:select class="select1" path="languages" multiple="${false}">
            <form:options items="${languagesList}"/>
        </form:select></div>
    <div class="form-group"><form:label path="pageSize">Page Size:</form:label>
        <span class="spanfix">Show</span>
        <form:select path="pageSize" class="select2" multiple="${false}">
            <form:options items="${pageSize}"/>
        </form:select>
        <span> emails per page</span>
    </div>
    <div class="form-group">
        <form:label path="Spam">Spams filter:</form:label>
        <span class="select3"> <form:checkbox path="spam" value="Enable spams filter"/> Enable spams filter
        </span>

    </div>
    <div class="form-group">
        <form:label path="Signature">Signature</form:label>
        <span class="select4"><form:input class="select5" path="Signature" />
        </span>
    </div>
    <div class="form-group">
        <form:button>Submit</form:button>
    </div>


</form:form>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</html>
