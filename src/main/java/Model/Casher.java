/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author binh
 */
public class Casher extends Employee {

    public Casher() {
    }

    public Casher(Member mem) {
        super(mem.getId(), mem.getName());
        this.role = "casher";
    }

    public Casher(String role) {
        super(role);
    }

    public Casher(int id, String username, String password, String name, String address, String email, String gender, String phone) {
        super(id, username, password, name, address, email, gender, phone);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
