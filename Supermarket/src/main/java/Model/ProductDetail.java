/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author binh
 */
public class ProductDetail {
    private int id;
    private float price;
    private String date;
    private int amount;

    public ProductDetail() {
    }

    
    public ProductDetail(int id, float price, String date, int amount) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
    

   
    
}
