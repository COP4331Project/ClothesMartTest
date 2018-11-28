/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginManager;

import CartManager.Cart;
import CartManager.CartInstance;
import InventoryManager.Product;
import UserManager.User;
import UserManager.UserInstance;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Login {
    
    public static String checkLogin(String username, String password) throws IOException, ClassNotFoundException{
        
        
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Users.dat"));
        
        User user;
        String acctType = "none";
        boolean eof = false;
        while (!eof) {
            try {
                user = (User) in.readObject();
                if (username.equals(user.getUsername())){
                    if (password.equals(user.getPassword())){
                        if (user.isAdmin()){
                            acctType = "admin";
                        } else {
                            acctType = "customer";
                        }
                        UserInstance.getInstance().setCustomer(user);
                    }
                }
            }
            catch(EOFException e) {
                eof = true;
            }
        }
        in.close();
        
        return acctType;
    }
}
