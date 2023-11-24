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
public class CloseCustomer extends Member {

    int point;
    private ArrayList<Order> listOrder;
    public CloseCustomer(int point, int id, String username, String password, String name, String address, String email, String gender, String phone) {
        super(id, username, password, name, address, email, gender, phone);
        this.point = point;
    }

    public CloseCustomer(int point, ArrayList<Order> listOrder) {
        this.point = point;
        this.listOrder = listOrder;
    }

    public CloseCustomer() {
    }

    public CloseCustomer(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setListOrder(ArrayList<Order> listOrder) {
        this.listOrder = listOrder;
    }
    
}
