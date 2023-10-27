/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

/**
 *
 * @author Administrator
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRI
 */
public class ProductDAO {

    private static ProductDAO instance;

    public ProductDAO() {
    }

    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }
//
//    public boolean insertNewProduct(Product p) {
//        Connection con = DAO.openConnection();
//        PreparedStatement pstmt;
//        try {
//            pstmt = con.prepareStatement(
//                    "INSERT INTO drinks(name , price) "
//                    + "VALUES ( ? , ? );");
//            pstmt.setString(1, name);
//            pstmt.setString(2, price);
//            if (pstmt.executeUpdate() > 0) {
//                return true;
//            }
//            return false;
//        } catch (SQLException e) {
//            System.out.println(e);
//            return false;
//        }
//    }
//
//    public boolean editProduct(Product p1, Product p2) {
//        Connection con = DAO.openConnection();
////        try {
////            PreparedStatement pstmt = con.prepareStatement("update drinks set name=?, price=? where name = ?");
////            pstmt.setString(1, newName);
////            pstmt.setString(2, newPrice);
////            pstmt.setString(3, name);
////            int i = pstmt.executeUpdate();
////            if (i > 0) {
////                return true;
////            } else {
////                return false;
////            }
////        } catch (SQLException e) {
////            System.out.print(e.getMessage());
////            return false;
////        }
//    }

    public boolean deleteProductById(String name) {
        Connection con = DAO.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("Delete from drinks where id= ? ");
            pstmt.setString(1, name);
            int i = pstmt.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Product> GetListProduct() {
        List<Product> list = new ArrayList<>();
        Connection con = DAO.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tblProduct ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
//                Drinks drinks = new Drinks(rs.getInt(1),rs.getString(2), rs.getInt(3));
//                list.add(drinks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<Product> GetListProductByName() {
        List<Product> list = new ArrayList<>();
        Connection con = DAO.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tblProduct ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
//                Drinks drinks = new Drinks(rs.getInt(1),rs.getString(2), rs.getInt(3));
//                list.add(drinks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
