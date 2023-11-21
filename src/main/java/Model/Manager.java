/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author binh
 */
public class Manager extends Employee {

    public Manager() {
    }

    public String getRole() {
        return role;
    }

    public Manager(String role) {
        super(role);
    }

    public Manager(int id, String username, String password, String name, String address, String email, String gender, String phone) {
        super(id, username, password, name, address, email, gender, phone);
    }

    public void setRole(String role) {
        this.role = role;
    }
    

}
