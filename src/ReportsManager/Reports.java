/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportsManager;

import CartManager.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Reports {
    
    public static void storeTransaction() throws IOException, ClassNotFoundException{
        Cart cart = CartInstance.getInstance().getCart();
        ArrayList<Cart> cartList;
        
        if (new File("CartStore.dat").isFile()){
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("TransactionStore.dat"));
            cartList = (ArrayList<Cart>) in.readObject();
            in.close();
        } else {
            cartList = new ArrayList<Cart>();
        }
        
        cartList.add(cart);
        
        
        for (int i = 0; i < cartList.size(); i++){
            ArrayList<CartItem> itemList = cartList.get(i).getCartArr();
            for (int j=0; j < itemList.size(); j++){
                System.out.println(itemList.get(j).getProduct().getName());
            }
        }
        
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("TransactionStore.dat"));
        out.writeObject(cartList);
    }
    
    public static void updateDataStore() throws IOException, ClassNotFoundException{
        Cart cart = CartInstance.getInstance().getCart();
        DataStore data;
        
        if (new File("DataStore.dat").isFile()) {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("DataStore.dat"));
            data = (DataStore) in.readObject();
            in.close();
        } else {
            data = new DataStore();
        }
        
        double costTotal = cart.getCostsTotal();
        double saleTotal = cart.getSalesTotal();
        
        data.updateData(saleTotal, costTotal);
        
        System.out.println(data.getTotalCosts());
        System.out.println(data.getTotalSales());
        System.out.println(data.getTotalRevenue());
        
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("DataStore.dat"));
        out.writeObject(data);
    }
    
    
    
}
