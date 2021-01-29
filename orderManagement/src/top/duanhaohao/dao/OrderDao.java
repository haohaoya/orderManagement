package top.duanhaohao.dao;

import top.duanhaohao.domain.Order;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的Dao
 */
public interface OrderDao {

    public List<Order> findAll();

    public void addOrder(Order order);

    void deleteOrder(int id);

    Order findOrderById(int id);

    void uqdateOrder(Order order);

    int findTotalCount(Map<String,String[]> condition);

    List<Order> findByPage(int start, int rows, Map<String,String[]> condition);
}
