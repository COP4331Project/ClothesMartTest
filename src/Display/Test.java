/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import InventoryManager.InitializeData;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Tom
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        InitializeData.initialize();
        JPanel panel = new JPanel();
        FrameManager.getInstance().displayLogin(LoginDisplay.getLoginPanel());
        FrameManager.getInstance().displayFrame();
    }
}
