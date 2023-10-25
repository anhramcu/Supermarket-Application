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
public class Product {
    private int id;
    public String name;
    private String describe;
    public ArrayList<ProductDetail> listProduct;
    public Product() {
        listProduct = new ArrayList<>();
    }
    public Product(int id, String name, String describe, ArrayList<ProductDetail> listProduct) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.listProduct = listProduct;
    }

    public Product(int id, String name, String describe) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        listProduct = new ArrayList<>();
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

    public ArrayList<ProductDetail> getListProduct() {
        return listProduct;
    }
    
    public int getAmount(){
        int amount = 0;
        for(ProductDetail i : listProduct){
            amount+= i.getAmount();
        }
        return amount;
    }
    
    
    
}
