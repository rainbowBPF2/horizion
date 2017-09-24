<%--
  Created by IntelliJ IDEA.
  User: pengfei
  Date: 2017/9/22
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Login Page</title>

    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">

</head>
<body>
<%--${time}--%>
<%--<c:forEach items="${users}" var="user" >--%>
<%--ID: ${user.id} Name:${user.name} <br/>--%>
<%--</c:forEach>--%>
<div style="padding: 30px 50px 10px;">
    <h2>Welcome back! User</h2>

    <form:form method="post" action="/loginHere" class="bs-example bs-example-form" role="form">

        <div class="input-group">
            <form:label path="name" >User Name:</form:label>
            <form:input path="name" class="form-control"/>
        </div>
        <div class="input-group">
            <form:label path="password">Password:</form:label>
            <form:password path="password" class="form-control"/>
        </div>
        <div class="input-group">
            <br>
            <input type="submit" value="Submit" class="btn btn-primary">
        </div>

    </form:form>
</div>

</body>

<script src="lib/jQuery/jquery-3.2.1.js"/>
<script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>
</html>
