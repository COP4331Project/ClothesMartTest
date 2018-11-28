/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Tom
 */
public class DisplayHelper {
    
    public static JLabel getLabel(String name, int fontSize){
        JLabel label = new JLabel(name);
        label.setFont(new Font(Font.DIALOG, Font.PLAIN, fontSize));
        return label;
    }
    
    public static JLabel getBoldLabel(String name, int fontSize){
        JLabel label = new JLabel(name);
        label.setFont(new Font(Font.DIALOG, Font.BOLD, fontSize));
        return label;
    }
    
    public static JButton getButton(String label){
        JButton button = new JButton(label);
        button.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        return button;
    }
    
}
