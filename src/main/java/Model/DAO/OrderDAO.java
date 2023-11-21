/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author binh
 */
public class OrderDAO {

    private static OrderDAO instance;

    public OrderDAO() {
    }

    public static OrderDAO getInstance() {
        if (instance == null) {
            instance = new OrderDAO();
        }
        return instance;
    }

    public int addOrder(Order a) {

        try {
            PreparedStatement pstmt = null;
            Connection con = DAO.openConnection();

            pstmt = con.prepareStatement("INSERT INTO tblOrder (time,tblCloseCustomerid,tblCasherid) "
                    + " VALUES (current_timestamp,?,?);");
            if (a.getCustomer() == null) {
                pstmt.setNull(1, Types.INTEGER);
            } else {
                pstmt.setInt(1, a.getCustomer().getId());
            }
            pstmt.setInt(2, a.getCasher().getId());

            pstmt.execute();
            pstmt = con.prepareStatement("SELECT LAST_INSERT_ID() from tblOrder");
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
