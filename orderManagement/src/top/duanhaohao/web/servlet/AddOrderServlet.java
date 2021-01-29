package top.duanhaohao.web.servlet;

import top.duanhaohao.domain.Order;
import top.duanhaohao.service.OrderService;
import top.duanhaohao.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        Order order = new Order(map.get("goods")[0],Integer.parseInt(map.get("price")[0]),
                Integer.parseInt(map.get("num")[0]), map.get("customer")[0],map.get("salesman")[0]);
        //4.调用service保存
        OrderService service = new OrderServiceImpl();
        service.addOrder(order);

        response.sendRedirect(request.getContextPath()+"/FindOrderByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
