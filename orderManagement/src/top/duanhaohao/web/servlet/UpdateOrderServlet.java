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

@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Order order = new Order(Integer.parseInt(request.getParameter("id")),request.getParameter("goods"),
                Integer.parseInt(request.getParameter("price")), Integer.parseInt(request.getParameter("num")),
                request.getParameter("customer"),request.getParameter("salesman"));
        OrderService orderService = new OrderServiceImpl();
        orderService.uqdateOrder(order);
        response.sendRedirect(request.getContextPath()+"/FindOrderByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
