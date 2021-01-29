package top.duanhaohao.domain;

public class Order {

    private int id;
    private String goods;
    private int price;
    private int num;
    private String customer;
    private String salesman;

    public Order(int id,String goods,int price,int num,String customer,String salesman){
        this.id = id;
        this.goods = goods;
        this.price = price;
        this.num = num;
        this.customer = customer;
        this.salesman = salesman;
    }
    public Order(String goods,int price,int num,String customer,String salesman){
        this.goods = goods;
        this.price = price;
        this.num = num;
        this.customer = customer;
        this.salesman = salesman;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", goods='" + goods + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", customer='" + customer + '\'' +
                ", salesman='" + salesman + '\'' +
                '}';
    }
}
