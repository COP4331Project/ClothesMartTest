/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.io.IOException;
import javax.swing.JLabel;

/**
 *
 * @author Tom
 */
public class NavigationManager {
    public static void category(String label) throws IOException, ClassNotFoundException{
       
        FrameManager.getInstance().clearFrame();
        FrameManager.getInstance().addScrollPanel(PanelCreator.getCategoryPanel(label));
        FrameManager.getInstance().displayFrame();
    }
    
    public static void navBar(String label) {
        FrameManager.getInstance().clearFrame();
        if (label.equals("Home")){
            FrameManager.getInstance().addPanel(PanelCreator.getCategoriesPanel());
        }
        else if (label.equals("Cart")) {
            FrameManager.getInstance().addScrollPanel(PanelCreator.getCartPanel());
        }
        FrameManager.getInstance().displayFrame();
    }
    
    public static void product(String label, int productID) throws IOException, ClassNotFoundException{
       
        FrameManager.getInstance().clearFrame();
        if (label.equals("view")){
            FrameManager.getInstance().addPanel(PanelCreator.getProductPanel(productID));
        } else if (label.equals("add")){
            FrameManager.getInstance().addPanel(PanelCreator.getAddCartPanel(productID));
        }
        FrameManager.getInstance().displayFrame();
    }
    
    public static void navCart(String label) throws IOException, ClassNotFoundException{
       
        FrameManager.getInstance().clearFrame();
        if (label.equals("shop")){
            FrameManager.getInstance().addPanel(PanelCreator.getCategoriesPanel());
        }
        else if (label.equals("cart")){
            FrameManager.getInstance().addScrollPanel(PanelCreator.getCartPanel());
        }
        else if (label.equals("checkout")){
            FrameManager.getInstance().addPanel(PanelCreator.getCheckOutPanel());
        }
        FrameManager.getInstance().displayFrame();
    }
    
    public static void navLogin(String label){
        
        FrameManager.getInstance().clearFrame();
        if (label.equals("none")){
            FrameManager.getInstance().displayLogin(LoginDisplay.getLoginPanel());
        } else if (label.equals("customer")){
            FrameManager.getInstance().addPanel(PanelCreator.getCategoriesPanel());
        } else if (label.equals("admin")){
            
        }
        
        FrameManager.getInstance().displayFrame();
    }
}
