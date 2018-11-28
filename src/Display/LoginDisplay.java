/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tom
 */
public class LoginDisplay {
    
    public static JPanel getLoginPanel(){
        
        JPanel mainPanel = new JPanel();
        BorderLayout layout = new BorderLayout();
        layout.setVgap(60);
        mainPanel.setLayout(layout);
        
        JPanel titlePanel = new JPanel();
        titlePanel.add(DisplayHelper.getBoldLabel("Welcome to Clothes Mart", 40));
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        
        JPanel userPanel = new JPanel();
        userPanel.setPreferredSize(new Dimension(800, 60));
        userPanel.setMaximumSize(userPanel.getPreferredSize());
        userPanel.add(DisplayHelper.getBoldLabel("UserName", 20));
        JTextField userName = new JTextField(10);
        userName.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        userPanel.add(userName);
        loginPanel.add(userPanel);
        
        JPanel passwordPanel = new JPanel();
        passwordPanel.setPreferredSize(new Dimension(800, 60));
        passwordPanel.setMaximumSize(passwordPanel.getPreferredSize());
        passwordPanel.add(DisplayHelper.getBoldLabel("Password", 20));
        JTextField password = new JTextField(10);
        password.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        passwordPanel.add(password);
        loginPanel.add(passwordPanel);
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(800, 60));
        buttonPanel.setMaximumSize(buttonPanel.getPreferredSize());
        JButton loginButton = DisplayHelper.getButton("Login");
        loginButton.addActionListener(Action.loginListener(userName, password));
        buttonPanel.add(loginButton);
        loginPanel.add(buttonPanel);
        
        mainPanel.add(loginPanel, BorderLayout.CENTER);
        
        return mainPanel;
        
    }
}
