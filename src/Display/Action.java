/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import CartManager.*;
import InventoryManager.Product;
import LoginManager.Login;
import ReportsManager.Reports;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Tom
 */
public class Action {
    
    public static ActionListener addListener(String type, String label){
        return new
            ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    if (type.equals("navBar")){
                        NavigationManager.navBar(label);
                    }
                    else if (type.equals("category")){
                        NavigationManager.category(label);
                    }
                    else if (type.equals("cart")){
                        NavigationManager.navCart(label);
                    }
                    else if (type.equals("update")){
                        NavigationManager.navCart(label);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }
    
    public static ActionListener addProductListener(int productID){
        return new
            ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    NavigationManager.product("view", productID);
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }
    
    public static ActionListener addToCartListener(Product p, int quantity){
        return new
            ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Cart cart = CartInstance.getInstance().getCart();
                cart.addToCart(p, quantity);
                try {
                    NavigationManager.product("add", p.getProductID());
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }
    
    public static ActionListener addQuantityListener(JComboBox c, int i){
        return new
            ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Cart cart = CartInstance.getInstance().getCart();
                ArrayList<CartItem> cartArr = cart.getCartArr();
                CartItem item = cartArr.get(i);
                cartArr.get(i).setQuantity(c.getSelectedIndex() + 1);
                try {
                    NavigationManager.navCart("cart");
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }
    
    public static ActionListener deleteItemListener(int index){
        return new
            ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Cart cart = CartInstance.getInstance().getCart();
                cart.removeFromCart(index);
                try {
                    NavigationManager.navCart("cart");
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }
    
    
    public static ActionListener completePurchaseListener(){
        return new
            ActionListener() {
            public void actionPerformed(ActionEvent event) {
                
                try {
                    Reports.storeTransaction();
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                
                try {
                    Reports.updateDataStore();
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                
            }
        };
    }
    
    public static ActionListener loginListener(JTextField userField, JTextField passField){
        return new
            ActionListener() {
            public void actionPerformed(ActionEvent event) {
                
                String acctType = "none";
                String userName = userField.getText();
                String password = passField.getText();
                
                try {
                    acctType = Login.checkLogin(userName, password);
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                
                if (acctType.equals("none")){
                    JOptionPane.showMessageDialog(
                            FrameManager.getInstance().getFrame(), 
                            "Invalid Login");
                    NavigationManager.navLogin("none");
                } else if (acctType.equals("admin")){
                    NavigationManager.navLogin("admin");
                } else if (acctType.equals("customer")){
                    NavigationManager.navLogin("customer");
                }
                
                
            }
        };
    }
    
}
