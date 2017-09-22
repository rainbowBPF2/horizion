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
</head>
<body>
Welcome back! User
<%--${time}--%>
<%--<c:forEach items="${users}" var="user" >--%>
<%--ID: ${user.id} Name:${user.name} <br/>--%>
<%--</c:forEach>--%>
<form:form method="post" action="/loginHere">
    <table>
        <tr>
            <td><form:label path="name">User Name:</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password:</form:label></td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit">
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
