/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author binh
 */
public class Product {

    private int id;
    public String name;
    private String describe;
    private int amount;
    private float price;

    public Product() {
    }

    public Product(int id, String name, String describe) {
        this.id = id;
        this.name = name;
        this.describe = describe;
    }

    public Product(String name, String describe, int amount, float price) {
        this.name = name;
        this.describe = describe;
        this.amount = amount;
        this.price = price;
    }

    public Product(int id, String name, String describe, int amount, float price) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.amount = amount;
        this.price = price;
    }

    public Product(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public int getAmount() {
        return amount;
    }

}
