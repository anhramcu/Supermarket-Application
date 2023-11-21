/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewAndController;

import Model.Casher;
import Model.DAO.OrderDAO;
import Model.DAO.ProductDAO;
import Model.Order;

/**
 *
 * @author binh
 */
public class testAPI {
    
    public static void main(String args[]) {
        
        Casher c = new Casher();
        Order o = new Order(c, null);
        
        c.setId(2);
        o.setId(OrderDAO.getInstance().addOrder(o));
        System.out.println(o.getId());
    }
}
