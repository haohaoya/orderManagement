<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加记录</title>
    <!--1.导入CSS的全局样式-->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!--2.jQuery导入，使用1.9以上的版本-->
    <script src="js/jquery-3.4.1.js"></script>

    <!--3.导入bootstrap的js文件-->
    <script src="js/bootstrap.min.js"></script>


</head>
<body>
<div class="container">
    <h3 style="text-align: center;">添加记录页面</h3>
    <div style="padding-left: 25%;padding-right: 25%;">
        <form action="${pageContext.request.contextPath}/AddOrderServlet" method="post" >
            <div class="form-group">
                <label for="goods">商品：</label>
                <input type="text" class="form-control" id="goods"  name="goods" placeholder="请输入商品名">
            </div>

            <div class="form-group">
                <label for="price">价格：</label>
                <input type="text" class="form-control" id="price"  name="price" placeholder="请输入价格">
            </div>

            <div class="form-group">
                <label for="num">数量：</label>
                <input type="text" class="form-control" id="num"  name="num" placeholder="请输入数量">
            </div>

            <div class="form-group">
                <label for="customer">顾客：</label>
                <input type="text" class="form-control" id="customer"  name="customer" placeholder="请输入顾客用户名">
            </div>

            <div class="form-group">
                <label for="salesman">销售员：</label>
                <input type="text" class="form-control" id="salesman"  name="salesman" placeholder="请输入销售员姓名">
            </div>

            <div class="form-group" style="text-align: center;">
                <input class="btn btn-primary" type="submit" value="添加" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" value="返回" />
            </div>
        </form>
    </div>
</div>
</body>
</html>
