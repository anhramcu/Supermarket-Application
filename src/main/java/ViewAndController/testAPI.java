/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewAndController;

import Model.CustomerSatistic;
import Model.DAO.CustomerSatisticDAO;
import Model.Order;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author binh
 */
public class testAPI {

    public static void main(String args[]) {
        List<CustomerSatistic> c = CustomerSatisticDAO.getInstance().getListCustomerByTime(LocalDateTime.now(), LocalDateTime.now());
        for(Order i : c.get(0).getListOrder()){
            System.out.println(i.getListOrderDetail().size());
        }
    }
}
