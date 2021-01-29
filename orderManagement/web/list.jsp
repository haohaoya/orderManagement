<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>账单管理系统</title>
    <!--1.导入CSS的全局样式-->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!--2.jQuery导入，使用1.9以上的版本-->
    <script src="js/jquery-3.4.1.js"></script>

    <!--3.导入bootstrap的js文件-->
    <script src="js/bootstrap.min.js"></script>

    <link href="css/list.css" rel="stylesheet">

    <script>
        function deleteSure(id) {
            if(confirm("您确定要删除吗？")){
                location.href="${pageContext.request.contextPath}/DeleteOrderServlet?id="+id;
            }
        }

        window.onload = function () {
            document.getElementById("deleteSelected").onclick = function () {
                if(confirm("您确定要删除选中条目吗？")){
                    var cbs = document.getElementsByName("orderid");
                    for(var i = 0; i < cbs.length; i++){
                        if(cbs[i].checked){
                            document.getElementById("form").submit();
                            break;
                        }
                    }

                }
            }

            document.getElementById("first").onclick = function () {
                var cbs = document.getElementsByName("orderid");
                for(var i = 0; i < cbs.length; i++){
                    cbs[i].checked = this.checked;
                }
            }
        }


    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center;">账单信息列表</h3>

    <div style="float: left;">
        <form class="form-inline" action="${pageContext.request.contextPath}/FindOrderByPageServlet" method="post">
            <div class="form-group">
                <label for="goods">商品</label>
                <input type="text" value="${condition.goods[0]}" class="form-control" name="goods" id="goods">
            </div>
            <div class="form-group">
                <label for="customer">顾客</label>
                <input type="text" value="${condition.customer[0]}" class="form-control" name="customer" id="customer">
            </div>
            <div class="form-group">
                <label for="salesman">销售员</label>
                <input type="text" value="${condition.salesman[0]}" class="form-control" name="salesman" id="salesman">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="add.jsp">添加记录</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="deleteSelected">删除选中</a>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/DeleteSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="first"></th>
                <th>编号</th>
                <th>商品</th>
                <th>价格</th>
                <th>数量</th>
                <th>顾客</th>
                <th>销售员</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${pageBean.list}" var="order" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="orderid" value="${order.id}"></td>
                    <td>${s.count}</td>
                    <td>${order.goods}</td>
                    <td>${order.price}</td>
                    <td>${order.num}</td>
                    <td>${order.customer}</td>
                    <td>${order.salesman}</td>
                    <td>
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/FindOrderServlet?id=${order.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteSure(${order.id});">删除</a>
                    </td>
                </tr>
            </c:forEach>


        </table>

    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pageBean.currentPage == 1}">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                </c:if>

                <c:if test="${pageBean.currentPage != 1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/FindOrderByPageServlet?currentPage=${pageBean.currentPage - 1}&rows=6&goods=${condition.goods[0]}&customer=${condition.customer[0]}&salesman=${condition.salesman[0]}" aria-label="Previous">
                </c:if>

                    <span aria-hidden="true">&laquo</span>
                    </a>
                </li>

                <c:forEach begin="1" end="${pageBean.totalPage}" var="i" >
                    <c:if test="${pageBean.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/FindOrderByPageServlet?currentPage=${i}&rows=6&goods=${condition.goods[0]}&customer=${condition.customer[0]}&salesman=${condition.salesman[0]}">${i}</a> </li>
                    </c:if>

                    <c:if test="${pageBean.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/FindOrderByPageServlet?currentPage=${i}&rows=6&goods=${condition.goods[0]}&customer=${condition.customer[0]}&salesman=${condition.salesman[0]}">${i}</a> </li>
                    </c:if>

                </c:forEach>


                <c:if test="${pageBean.currentPage == pageBean.totalPage}">
                    <li class="disabled">
                        <a href="#" aria-label="Next">
                </c:if>

                <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/FindOrderByPageServlet?currentPage=${pageBean.currentPage + 1}&rows=6&goods=${condition.goods[0]}&customer=${condition.customer[0]}&salesman=${condition.salesman[0]}" aria-label="Next">
                </c:if>

                        <span aria-hidden="true">&raquo</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${pageBean.totalCount}条记录，共${pageBean.totalPage}页
                </span>

            </ul>
        </nav>
    </div>
</div>

</body>
</html>
