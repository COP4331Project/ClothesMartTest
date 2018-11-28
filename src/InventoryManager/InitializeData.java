/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryManager;

import CartManager.*;
import UserManager.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Tom
 */
public class InitializeData {
    public static void initialize() throws IOException, ClassNotFoundException {
        Product p1 = new Product(1001, "Red Shirt", 12.99, 5.15, 
                "images/redShirt.jpg", "Shirts", 10, "Description Goes Here");
        Product p2 = new Product(1002, "Blue Shirt", 12.94, 5.15, 
                "images/blueShirt.jpg", "Shirts", 10, "Description Goes Here");
        Product p3 = new Product(1003, "Grey Shirt", 12.95, 5.15, 
                "images/greyShirt.jpg", "Shirts", 10, "Description Goes Here");
        Product p4 = new Product(1004, "White Shirt", 12.97, 5.15, 
                "images/whiteShirt.jpg", "Shirts", 10, "Description Goes Here");
        Product p5 = new Product(1005, "Blue Jeans", 12.98, 5.15, 
                "images/jeans.jpg", "Pants", 10, "Description Goes Here");
        Product p6 = new Product(1006, "Grey Pants", 12.93, 5.15, 
                "images/greyPants.jpg", "Pants", 10, "Description Goes Here");
        Product p7 = new Product(1007, "Pajama Pants", 12.99, 5.15, 
                "images/pajamaPants.jpg", "Pants", 10, "Description Goes Here");
        Product p8 = new Product(1008, "Black Shirt", 12.99, 5.15, 
                "images/blackShirt.jpg", "Shirts", 10, "Description Goes Here");
        Product p9 = new Product(1009, "Green Shirt", 12.99, 5.15, 
                "images/greenShirt.jpg", "Shirts", 10, "Description Goes Here");
        Product p10 = new Product(1010, "Green Shirt", 12.99, 5.15, 
                "images/greenShirt.jpg", "Shirts", 10, "Description Goes Here");
        Product p11 = new Product(1011, "Green Shirt", 12.99, 5.15, 
                "images/greenShirt.jpg", "Shirts", 10, "Description Goes Here");
        
        // write object to file
        
        if (!(new File("CartStore.dat").isFile())){
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("inventory.dat"));
            out.writeObject(p1);
            out.writeObject(p2);
            out.writeObject(p3);
            out.writeObject(p4);
            out.writeObject(p5);
            out.writeObject(p6);
            out.writeObject(p7);
            out.writeObject(p8);
            out.writeObject(p9);
            out.writeObject(p10);
            out.writeObject(p11);
            out.close();
        }
        
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Users.dat"));
        
        User admin = new User("tom", "tom123", "Tom", "Lozier", true);
        User customer = new User(1002, "joe", "joe123", "Joe", "Smith", 
                "123 Main St", "Delray Beach", "Florida", "33426", 1001, false);
        
        out.writeObject(admin);
        out.writeObject(customer);
        out.close();
        
        
        //UserInstance.getInstance().setCustomer(user);
    }
        
}
