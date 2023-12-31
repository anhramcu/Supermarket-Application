/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.helpers;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class DataValidator {

    public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage) {
        if (field.getText().equals("")) {
            if (field.getText().equals("")) {
                sb.append(errorMessage).append("\n");
                field.setBackground(Color.red);
                field.requestFocus();
            }
        } else {
            field.setBackground(Color.white);
        }
    }

    public static void validateEmpty(JPasswordField field, StringBuilder sb, String errorMessage) {
        String pass = new String(field.getPassword());
        if (pass.equals("")) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        } else {
            field.setBackground(Color.white);
        }
    }
}
