/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.CustomerSatistic;
import static Model.DAO.DAO.openConnection;
import Model.Order;
import Model.OrderDetail;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author binh
 */
public class CustomerSatisticDAO {

    private static CustomerSatisticDAO instance;

    public CustomerSatisticDAO() {
    }

    public static CustomerSatisticDAO getInstance() {
        if (instance == null) {
            instance = new CustomerSatisticDAO();
        }
        return instance;
    }

    public ArrayList<CustomerSatistic> getListCustomerByTime(LocalDateTime from, LocalDateTime to) {
        ArrayList<CustomerSatistic> list = new ArrayList<>();
        Connection con = openConnection();
        try {
            PreparedStatement pstmt
                    = con.prepareStatement("""
                                           SELECT o.time, c.point,m.id,m.usename,m.password,m.name,m.address,m.address,
                                                    m.gender,m.phone,od.id,p.name,od.amount,p.price 
                                           FROM tblorder as o 
                                           Inner join tblclosecustomer as c  
                                                on o.time <= ? and o.time <= ? 
                                                    and tblCloseCustomerid  = c.tblmemberid  
                                           inner join tblmember as m on c.tblmemberid = m.id
                                           inner join tblorderdetail as od 
                                                on o.id = od.tblOrderid 
                                           inner join tblproduct as p on od.tblProductid = p.id ; """);

            pstmt.setTimestamp(1, Timestamp.valueOf(from));
            pstmt.setTimestamp(2, Timestamp.valueOf(to));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("found");
                CustomerSatistic cs = new CustomerSatistic(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId() == cs.getId()) {
                        System.out.println("found in Arr");
                        ArrayList<Order> o = list.get(i).getListOrder();
                        for (int j = 0; j < o.size(); j++) {// check and add orderDetail if order allredy exists
                            if (o.get(j).getId() == rs.getInt(1)) {
                                List<OrderDetail> od = o.get(j).getListOrderDetail();
                                Order x = o.get(j);
                                od.add(new OrderDetail(rs.getInt(11), new Product(rs.getString(12)), rs.getFloat(14), rs.getInt(13)));
                                x.setListOrderDetail(od);
                                o.set(j, x);
                                break;
                            }
                            if (j == o.size() - 1) {// Create new Order if order is not exitst
                                Order x = new Order(rs.getInt(1), rs.getTimestamp(2).toString());
                                List<OrderDetail> od = new ArrayList<>();
                                od.add(new OrderDetail(rs.getInt(11), new Product(rs.getString(12)), rs.getFloat(14), rs.getInt(13)));
                                x.setListOrderDetail(od);
                            }
                        }
                        break;
                    }
                    if (i == list.size() - 1) {// create new CloseCustomerSatistic
                        ArrayList<Order> lOrder = cs.getListOrder();
                        Order x = new Order(rs.getInt(1), rs.getTimestamp(2).toString());
                        List<OrderDetail> od = new ArrayList<>();
                        od.add(new OrderDetail(rs.getInt(11), new Product(rs.getString(12)), rs.getFloat(14), rs.getInt(13)));
                        x.setListOrderDetail(od);
                        lOrder.add(x);
                        cs.setListOrder(lOrder);
                        list.add(cs);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
