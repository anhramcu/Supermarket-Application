/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author binh
 */
public class CustomerSatistic extends CloseCustomer {

    private float total;
    private ArrayList<Order> listOrder = new ArrayList<>();

    public CustomerSatistic(float total, ArrayList<Order> listOrder) {
        this.total = total;
        this.listOrder = listOrder;
    }

    public CustomerSatistic() {
    }

    public CustomerSatistic(int point, int id, String username, String password, String name, String address, String email, String gender, String phone) {
        super(point, id, username, password, name, address, email, gender, phone);
    }

    public float getTotal() {
        for (Order i : listOrder) {
            total += i.getTotal();
        }
        return total;
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public int getPoint() {
        return point;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setListOrder(ArrayList<Order> listOrder) {
        this.listOrder = listOrder;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
