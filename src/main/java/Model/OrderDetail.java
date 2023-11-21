/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author binh
 */
public class OrderDetail {
    private int id;
    private Product p;
    private float price;
    private int amount;
    private Order order;

    public OrderDetail() {
    }

    public OrderDetail(Product p, int amount) {
        this.p = p;
        this.amount = amount;
        price = p.getPrice();
        
    }

    
    public OrderDetail(int id, Product p, float price, int amount, Order order) {
        this.id = id;
        this.p = p;
        this.price = price;
        this.amount = amount;
        this.order = order;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public Product getP() {
        return p;
    }

    public float getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public Order getOrder() {
        return order;
    }
    
}
