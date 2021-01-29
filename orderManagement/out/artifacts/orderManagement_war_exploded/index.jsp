<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
      <title>首页</title>

      <!--1.导入CSS的全局样式-->
      <link href="css/bootstrap.min.css" rel="stylesheet">

      <!--2.jQuery导入，使用1.9以上的版本-->
      <script src="js/jquery-3.4.1.js"></script>

      <!--3.导入bootstrap的js文件-->
      <script src="js/bootstrap.min.js"></script>

      <link href="css/index.css" rel="stylesheet">
  </head>
  <body>
    <div align="center">
        <a
            href="${pageContext.request.contextPath}/FindOrderByPageServlet" style="...">查询所有订单
        </a>
    </div>

  </body>
</html>
