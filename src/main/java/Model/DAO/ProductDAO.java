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
public class ProductDAO extends DAO {

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

    public boolean addProduct(Product p) {
        Connection con = DAO.openConnection();
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(
                    "INSERT INTO tblproduct(`name`, `describe`, `amount`, `price`) "
                    + "VALUES (?,?,?,?)");
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getDescribe());
            pstmt.setInt(3, p.getAmount());
            pstmt.setFloat(4, p.getPrice());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean editProduct(Product p) {
        Connection con = openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("update tblproduct set name=?, describe = ?,amount = ?,price=?, where id = ?");
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getDescribe());
            pstmt.setInt(3, p.getAmount());
            pstmt.setFloat(4, p.getPrice());
            int i = pstmt.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }

    public boolean deleteProductById(Product p) {
        Connection con = DAO.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("Delete from tblProduct where id= ? ");
            pstmt.setInt(1, p.getId());
            int i = pstmt.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Product> GetListProduct() {
        List<Product> list = new ArrayList<>();
        Connection con = openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tblproduct ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5));
                list.add(p);
//                Drinks drinks = new Drinks(rs.getInt(1),rs.getString(2), rs.getInt(3));
//                list.add(drinks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Product> GetListProductByName(Product a) {
        List<Product> list = new ArrayList<>();
        Connection con = openConnection();

        System.out.println("search product by name :" + a.getName());
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tblproduct where name like ?");
            pstmt.setString(1, "%" + a.getName() + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
