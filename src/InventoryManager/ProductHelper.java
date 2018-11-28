/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryManager;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class ProductHelper {
    public static ArrayList getProducts(String category) throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("inventory.dat"));
        
        ArrayList<Product> products = new ArrayList<Product>();
        Product product;
        boolean eof = false;
        while (!eof) {
            try {
                product = (Product) in.readObject();
                if (product.getCategory().equals(category)){
                    products.add(product);
                }
            }
            catch(EOFException e) {
                eof = true;
            }
        }
        in.close();
        
        return products;
    }
    
    public static Product getProduct(int productID) throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("inventory.dat"));
        
        ArrayList<Product> products = new ArrayList<Product>();
        Product product;
        Product item = null;
        boolean eof = false;
        while (!eof) {
            try {
                product = (Product) in.readObject();
                if (product.getProductID() == productID){
                    item = product;
                }
            }
            catch(EOFException e) {
                eof = true;
            }
        }
        in.close();
        
        return item;
    }
}
