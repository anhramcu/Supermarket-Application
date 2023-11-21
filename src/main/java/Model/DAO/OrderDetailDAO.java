/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Order;
import Model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author binh
 */
public class OrderDetailDAO extends DAO {

    private static OrderDetailDAO instance;

    public OrderDetailDAO() {
    }

    public static OrderDetailDAO getInstance() {
        if (instance == null) {
            instance = new OrderDetailDAO();
        }
        return instance;
    }

    public boolean saveListOrderDetail(Order o) {
        try {
            PreparedStatement pstmt;
            PreparedStatement pstmt2;
            Connection con = DAO.openConnection();

            pstmt = con.prepareStatement("INSERT INTO tblOrderDetail (price,amount,tblProductid,tblOrderid) "
                    + "VALUES (?,?,?,?);");
            pstmt2 = con.prepareStatement("Update tblProduct set amount = ? where id = ? ;");
            for (OrderDetail i : o.getListOrderDetail()) {
                pstmt.setFloat(1, i.getPrice());
                pstmt.setInt(2, i.getAmount());
                pstmt.setInt(3, i.getP().getId());
                pstmt.setInt(4, o.getId());
                pstmt2.setInt(1, i.getP().getAmount() - i.getAmount());
                pstmt2.setInt(2, i.getP().getId());

                pstmt.addBatch();
                pstmt2.addBatch();
            }
            pstmt.executeBatch();
            pstmt2.executeBatch();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
