<%--
  Created by IntelliJ IDEA.
  User: pengfei
  Date: 2017/9/24
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Account</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<div>
    <div class="panel panel-primary" style="height: 100%;margin-bottom: 0px">
        <div class="panel-heading">
            <h3 class="panel-title" style="margin:auto">Welcome back, user! </h3>
        </div>
        <div class="panel-body" style="width:40%; margin: auto;margin-top:30px">
            <form class="bs-example bs-example-form" role="form" method="post" action="/account/save"
                  enctype="multipart/form-data">

                <div class="input-group">
                    <span class="input-group-addon">名称</span>
                    <input type="text" class="form-control" placeholder="Your name" name="name">
                </div>
                <br>
                <div class="input-group">
                    <span class="input-group-addon">密码</span>
                    <input type="password" class="form-control" placeholder="Your password" name="password">
                </div>
                <br>
                <div class="input-group">
                    <span class="input-group-addon">邮件</span>
                    <input type="text" class="form-control" placeholder="Your email" name="email">
                </div>
                <br>

                <div class="input-group">
                    <span class="input-group-addon">头像</span>
                    <input type="file" class="form-control" placeholder="Your photo" name="image">
                </div>

                <br>
                <div class="input-group">
                    <span class="input-group-addon">保存</span>
                    <input type="submit" class="form-control" value="Save">
                </div>
                <br>

            </form>
        </div>
    </div>

</div>

</body>
</html>
