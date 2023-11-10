/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
// connect to database
public class DAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/"
            + "supermarket_db";
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "";

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = getConnection(DB_URL, USER_NAME, PASSWORD);
            return con;
        } catch (ClassNotFoundException | SQLException er) {
            er.printStackTrace();
        }
        return null;
    }
//          Class.forName("com.microsoft.sqlserver.jdbc.")
}
