<%--
  Created by IntelliJ IDEA.
  User: pengfei
  Date: 2017/9/22
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Horizon WorkSpace Page</title>
</head>
<body>
<h1>Horizon WorkSpace Page!</h1>
<hr>

<table>
    <tr>
        <td>ID:</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${password}</td>
    </tr>
    <tr>
        <td><input type="date"></td>
    </tr>
</table>

<div>
    <form action="visitStaticPage" method="get">
        <br>
        <input type="submit" value="Visit Static Page">
    </form>
</div>

</body>
</html>
