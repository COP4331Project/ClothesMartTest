/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Tom
 */
public class FrameManager {
    
    private JFrame frame;
    private static FrameManager instance = new FrameManager();
    
    private FrameManager() {
        frame = new JFrame();
    }
    
    public void addPanel(JPanel panel) {
        JPanel navPanel = PanelCreator.getNavBar();
        frame.add(navPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
    }
    
    public void displayLogin(JPanel panel){
        frame.add(panel, BorderLayout.CENTER);
    }
    
    public void displayFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,800);
        frame.setVisible(true);
    }
    
    public void clearFrame() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }
    
    public JFrame getFrame(){
        return frame;
    }
    
    public void addScrollPanel(JPanel panel){
        JPanel navPanel = PanelCreator.getNavBar();
        frame.add(navPanel, BorderLayout.NORTH);
        
        JScrollPane scrollPanel = new JScrollPane(panel);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPanel, BorderLayout.CENTER);
    }
    
    public static FrameManager getInstance() {
        return instance;
    }
    
}
