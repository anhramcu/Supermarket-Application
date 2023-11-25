/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.helpers;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class MessageDialogHelper {

    public static void showMessageDialog(Component Parent, String content, String title) {
        JOptionPane.showMessageDialog(Parent, content, title, JOptionPane.INFORMATION_MESSAGE);

    }

    public static void showErrorDialog(Component Parent, String content, String title) {
        JOptionPane.showMessageDialog(Parent, content, title, JOptionPane.ERROR_MESSAGE);
    }

    public static int showConfirmDialog(Component Parent, String content, String title) {
        int choose = JOptionPane.showConfirmDialog(Parent,content, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose;
    }
}
