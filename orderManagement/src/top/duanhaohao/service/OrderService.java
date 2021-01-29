package top.duanhaohao.service;

import top.duanhaohao.domain.Order;
import top.duanhaohao.domain.PageBean;

import java.util.List;
import java.util.Map;

/**
 * 订单管理的业务接口
 */
public interface OrderService {

    /**
     * 查询所有订单信息
     * @return
     */
    public List<Order> findAll();

    /**
     * 保存Order
     * @param order
     */
    public void addOrder(Order order);

    /**
     * 根据id删除Order
     * @param id
     */
    void deleteOrder(int id);

    /**
     * 根据id查找Order
     * @param parseInt
     * @return
     */
    Order findOrderById(int parseInt);

    /**
     * 修改Order信息
     * @param order
     */
    void uqdateOrder(Order order);

    void deleteSelectedUser(String[] ids);

    PageBean<Order> findOrderByPage(int currentPage, int rows, Map<String, String[]> condition);
}
