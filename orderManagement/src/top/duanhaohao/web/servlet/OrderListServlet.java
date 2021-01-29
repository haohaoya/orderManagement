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
import java.util.List;

@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用UserService完成查询
        OrderService service = new OrderServiceImpl();
        List<Order> orders = service.findAll();

        //2.将list存入request域
        request.setAttribute("orders",orders);

        //3.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
