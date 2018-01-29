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
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<h1>Horizon WorkSpace Page!</h1>
<hr>
<div style="width:400px">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        </thead>

        <tbody>
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
        </tbody>

    </table>
</div>

<div>
    <form action="visitStaticPage" method="get">
        <br>
        <input type="submit" value="Visit Static Page">
    </form>
</div>

</body>

<script src="lib/jQuery/jquery-3.2.1.js"/>
<script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>
</html>
