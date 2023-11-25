/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author binh
 */
public class Employee extends Member {

    String role;

    public Employee() {
    }

    public Employee(String role) {
        this.role = role;
    }

    public Employee(int id, String name) {
        super(id, name);
    }

    public Employee(int id, String username, String password, String name, String address, String email, String gender, String phone) {
        super(id, username, password, name, address, email, gender, phone);
    }

    

    public String getRole() {
        return role;
    }

}
