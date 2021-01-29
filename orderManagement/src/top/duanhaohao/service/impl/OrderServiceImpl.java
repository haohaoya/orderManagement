package top.duanhaohao.service.impl;

import top.duanhaohao.dao.OrderDao;
import top.duanhaohao.dao.impl.OrderDaoImpl;
import top.duanhaohao.domain.Order;
import top.duanhaohao.domain.PageBean;
import top.duanhaohao.service.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao dao = new OrderDaoImpl();

    @Override
    public List<Order> findAll() {
        //调用Dao完成查询

        return dao.findAll();

    }

    @Override
    public void addOrder(Order order){
        dao.addOrder(order);
    }

    @Override
    public void deleteOrder(int id) {
        dao.deleteOrder(id);
    }

    @Override
    public Order findOrderById(int id) {
        return dao.findOrderById(id);
    }

    @Override
    public void uqdateOrder(Order order) {
        dao.uqdateOrder(order);
    }

    @Override
    public void deleteSelectedUser(String[] ids) {
        for(String id : ids){
            dao.deleteOrder(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<Order> findOrderByPage(int currentPage, int rows, Map<String,String[]> condition) {
        PageBean<Order> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        int totalCount = dao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        int start = (currentPage - 1) * rows;
        List<Order> list = dao.findByPage(start,rows,condition);
        pageBean.setList(list);

        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
