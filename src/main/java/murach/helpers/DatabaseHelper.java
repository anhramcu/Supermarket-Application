/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.helpers;

import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
// connect to database
public class DatabaseHelper {

    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=RecoDB;";
    private static String USER_NAME = "admin";
    private static String PASSWORD = "admin";

    public static Connection openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = getConnection(DB_URL, USER_NAME, PASSWORD);
            return con;
        } catch (Exception er) {
            er.printStackTrace();
        }
        return null;
    }
//          Class.forName("com.microsoft.sqlserver.jdbc.")
}
