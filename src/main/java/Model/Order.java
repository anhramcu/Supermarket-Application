/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author binh
 */
public class Order {

    private int id;
    private String time;
    private Casher casher;
    private CloseCustomer customer;
    private List<OrderDetail> listOrderDetail;

    public Order() {
        customer = new CloseCustomer();
        casher = new Casher();
    }

    public Order(Casher casher, CloseCustomer customer) {
        this.casher = casher;
        this.customer = customer;
    }

    public Order(int id, String time) {
        this.id = id;
        this.time = time;
    }

    public Order(int id, String time, Casher casher, CloseCustomer customer, List<OrderDetail> listOrderDetail) {
        this.id = id;
        this.time = time;
        this.casher = casher;
        this.customer = customer;
        this.listOrderDetail = listOrderDetail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCasher(Casher casher) {
        this.casher = casher;
    }

    public void setCustomer(CloseCustomer customer) {
        this.customer = customer;
    }

    public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }

    public int getId() {
        return id;
    }
    public float getTotal(){
        float sum = 0;
        for(OrderDetail i : listOrderDetail)
            sum+=i.getAmount()*i.getPrice();
        return sum;
    }
    public String getTime() {
        return time;
    }

    public Casher getCasher() {
        return casher;
    }

    public CloseCustomer getCustomer() {
        return customer;
    }

    public List<OrderDetail> getListOrderDetail() {
        return listOrderDetail;
    }

}
