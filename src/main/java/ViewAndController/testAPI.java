/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewAndController;

import Model.DAO.ProductDAO;
import Model.Product;

/**
 *
 * @author binh
 */
public class testAPI {

    public static void main(String args[]) {

        Product a = new Product(1, "cafe trung nguyên2", "cafe khá ngon", 1000, Float.parseFloat("5.500"));

        System.out.println(ProductDAO.getInstance().addProduct(a));
    }
}
