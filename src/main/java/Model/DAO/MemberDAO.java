/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import murach.helpers.DatabaseHelper;

/**
 *
 * @author binh
 */
public class MemberDAO {

    private static MemberDAO instance;

    public MemberDAO() {
    }

    public static MemberDAO getInstance() {
        if (instance == null) {
            instance = new MemberDAO();
        }
        return instance;
    }

    public Member checkLogin(String username, String password) throws Exception {
        String sql = "select id,name from tblmember"
                + " where username=? and password=?";
        try (
                Connection con = DAO.openConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    return new Member(rs.getInt(1), rs.getString(2));

                }
            }
        }
        return null;
    }
}
