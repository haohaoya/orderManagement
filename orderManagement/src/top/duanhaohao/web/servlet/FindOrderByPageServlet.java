package top.duanhaohao.web.servlet;

import top.duanhaohao.domain.Order;
import top.duanhaohao.domain.PageBean;
import top.duanhaohao.service.OrderService;
import top.duanhaohao.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/FindOrderByPageServlet")
public class FindOrderByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数
        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "6";
        }

        Map<String, String[]> condition = request.getParameterMap();

        OrderService orderService = new OrderServiceImpl();
        PageBean<Order> pageBean = orderService.findOrderByPage(Integer.parseInt(currentPage),Integer.parseInt(rows),condition);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
