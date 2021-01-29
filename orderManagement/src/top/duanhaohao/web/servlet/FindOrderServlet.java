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

@WebServlet("/FindOrderServlet")
public class FindOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        OrderService orderService = new OrderServiceImpl();
        Order order =orderService.findOrderById(Integer.parseInt(id));
        request.setAttribute("order",order);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
