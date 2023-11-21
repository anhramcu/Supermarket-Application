/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.CloseCustomer;
import static Model.DAO.DAO.openConnection;
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
public class CloseCustomerDAO extends DAO {

    private static CloseCustomerDAO instance;

    public CloseCustomerDAO() {
    }

    public static CloseCustomerDAO getInstance() {
        if (instance == null) {
            instance = new CloseCustomerDAO();
        }
        return instance;
    }

    public CloseCustomer getCloseCustomerById(CloseCustomer c) {
        Connection con = openConnection();
        CloseCustomer cus = new CloseCustomer();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT a.tblmemberid , b.name "
                    + " FROM tblclosecustomer as a "
                    + "INNER JOIN tblMember as b ON a.tblmemberid = ? and a.tblmemberid = b.id;");
            pstmt.setInt(1, c.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cus.setId(rs.getInt(1));
                cus.setName(rs.getString(2));
                return cus;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
