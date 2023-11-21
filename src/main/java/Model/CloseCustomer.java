/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author binh
 */
public class CloseCustomer extends Member {

    int point;

    public CloseCustomer(int point, int id, String username, String password, String name, String address, String email, String gender, String phone) {
        super(id, username, password, name, address, email, gender, phone);
        this.point = point;
    }

    public CloseCustomer() {
    }

    public CloseCustomer(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

}
