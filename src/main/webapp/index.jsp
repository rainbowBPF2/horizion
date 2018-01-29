<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">World Horizon</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="hotel/home">酒店</a></li>
                <li><a href="guestHouse/home/2">客栈公寓</a></li>
                <li><a href="domesticTicket/home?userID=3&userName=jack">国内机票</a></li>
                <li><a href="abroadTicket/home">国际机票</a></li>
                <li><a href="vacation/home">旅游度假</a></li>
                <li><a href="scenery/home">景点门票</a></li>
                <li><a href="trainTicket/home">火车票</a></li>
                <li class="dropdown">
                    <a href="flyPig/home" class="dropdown-toggle" data-toggle="dropdown">
                        飞猪国际<b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="northAmerica/home">北美站</a></li>
                        <li><a href="westEuro/home">西欧站</a></li>
                        <li><a href="asiaPacific/home">亚太站</a></li>
                        <li><a href="eastAlabo/home">中东站</a></li>
                    </ul>
                </li>
                <li><a href="#">我的旅行</a></li>
            </ul>


            <p class="navbar-text navbar-right" style="margin-right: 10px">
                <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal">登录</button>
            </p>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/account/edit">我的账户</a></li>
            </ul>


        </div>
    </div>
</nav>

<div class="container">
    <div class="jumbotron">
        <h1>Horizon Index Page</h1>
        <p>Horizon index page, welcome back, user!</p>
    </div>
    <div class="row">
        <div class="col-sm-4">
            <h3>第一列</h3>
            <p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
        </div>
        <div class="col-sm-4">
            <h3>第二列</h3>
            <p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
        </div>
        <div class="col-sm-4">
            <h3>第三列</h3>
            <p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
        </div>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <form class="bs-example bs-example-form" role="form" action="/loginHere" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        登录页面
                    </h4>
                </div>
                <div class="modal-body">
                    <div style="padding: 0px 10px 10px;">
                        <h2>Welcome back! User</h2>
                    </div>
                    <div style="padding: 10px 10px 10px;">
                        <div class="input-group">
                            <span class="input-group-addon">名称</span>
                            <input type="text" id="name" name="name" class="form-control" placeholder="Your user name">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">密码</span>
                            <input type="password" id="password" name="password" class="form-control"
                                   placeholder="Your password">
                        </div>
                        <br>
                    </div>
                </div>

                <div class="modal-footer">
                    <input type="submit" value="登录" class="btn btn-primary" style="margin-right: 10px"/>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </form>
</div>


</body>
<%--<script src="/lib/jQuery/jquery-3.2.1.min.js"/>--%>
<%--<script src="/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>--%>


</html>
