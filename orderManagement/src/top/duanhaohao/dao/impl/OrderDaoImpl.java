package top.duanhaohao.dao.impl;

import top.duanhaohao.dao.OrderDao;
import top.duanhaohao.domain.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {
	private String url="jdbc:mysql://localhost:3306/ordermanagement?serverTimezone=Asia/Shanghai";
	private String user="root";
	private String pwd="123456";
    @Override
    public List<Order> findAll() {
        //使用JDBC操作数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Order> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            ps = conn.prepareStatement("select * from orders");
            rs = ps.executeQuery();

            while(rs.next()){
                list.add(new Order(rs.getInt(1),rs.getString(2), rs.getInt(3),
                        rs.getInt(4),rs.getString(5),rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void addOrder(Order order) {
        //使用JDBC操作数据库
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            ps = conn.prepareStatement("insert into orders values(null,?,?,?,?,?)");

            ps.setString(1,order.getGoods());
            ps.setInt(2,order.getPrice());
            ps.setInt(3,order.getNum());
            ps.setString(4,order.getCustomer());
            ps.setString(5,order.getSalesman());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteOrder(int id) {

        //使用JDBC操作数据库
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            ps = conn.prepareStatement("delete from orders where id = ?");

            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Order findOrderById(int id) {

        //使用JDBC操作数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Order order = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            ps = conn.prepareStatement("select * from orders where id = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            rs.next();
            order = new Order(rs.getInt(1),rs.getString(2), rs.getInt(3),
                        rs.getInt(4),rs.getString(5),rs.getString(6));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return order;
    }

    @Override
    public void uqdateOrder(Order order) {
        //使用JDBC操作数据库
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            ps = conn.prepareStatement("update orders set goods = ?,price = ?,num = ?,customer = ?,salesman = ? where id = ?");
            ps.setString(1,order.getGoods());
            ps.setInt(2,order.getPrice());
            ps.setInt(3,order.getNum());
            ps.setString(4,order.getCustomer());
            ps.setString(5,order.getSalesman());
            ps.setInt(6,order.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int findTotalCount(Map<String,String[]> condition) {
        //使用JDBC操作数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Integer totalCount = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            StringBuilder stringBuilder = new StringBuilder("select count(*) from orders where 1 = 1 ");
            List<String> params = new ArrayList<>();
            Set<String> keySet = condition.keySet();
            for(String key : keySet){

                if("currentPage".equals(key) || "rows".equals(key)){
                    continue;
                }

                //获取value
                String value = condition.get(key)[0];
                if(value != null && !"".equals(value)){
                    //有值
                    stringBuilder.append(" and "+key+" like ? ");
                    params.add("%"+value+"%");
                }
            }

            ps = conn.prepareStatement(stringBuilder.toString());

            for(int i = 1; i<=params.size(); i++){
                ps.setString(i,params.get(i-1));
            }

            resultSet = ps.executeQuery();
            resultSet.next();
            totalCount = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return totalCount;
    }

    @Override
    public List<Order> findByPage(int start, int rows, Map<String,String[]> condition) {
        //使用JDBC操作数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<Order> orders = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);

            StringBuilder stringBuilder = new StringBuilder("select * from orders where 1 = 1 ");
            List<Object> params = new ArrayList<>();
            Set<String> keySet = condition.keySet();
            for(String key : keySet){

                if("currentPage".equals(key) || "rows".equals(key)){
                    continue;
                }

                //获取value
                String value = condition.get(key)[0];
                if(value != null && !"".equals(value)){
                    //有值
                    stringBuilder.append(" and "+key+" like ? ");
                    params.add("%"+value+"%");
                }
            }
            stringBuilder.append(" limit ?,?");
            params.add(start);
            params.add(rows);
            ps = conn.prepareStatement(stringBuilder.toString());
            for(int i = 1; i<=params.size(); i++){
                ps.setObject(i,params.get(i-1));
            }
            System.out.println(ps);
            resultSet = ps.executeQuery();
            while(resultSet.next()){
                orders.add(new Order(resultSet.getInt(1),resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }
}
