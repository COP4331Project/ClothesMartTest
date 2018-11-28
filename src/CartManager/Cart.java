package CartManager;

import java.util.ArrayList;
import InventoryManager.Product;
import java.io.Serializable;

/**
 * Class cart stores products selected by user for purchase.
 * @author Tom Lozier
 */
public class Cart implements Serializable {
    
    // ArrayList of CartItems used to store products and their quantities
    private ArrayList<CartItem> cartArr = new ArrayList<CartItem>();
    
    /**
     * Gets cartArr
     * @return ArrayList of CartITems
     */
    public ArrayList getCartArr(){
        return cartArr;
    }
    
    /**
     * Adds a product to cart
     * @param p product to be added
     * @param quantity quantity of product to be added
     */
    public void addToCart(Product p, int quantity){
        if (productExists(p.getProductID())){
            int index = getProductIndex(p.getProductID());
            int currentQuantity = cartArr.get(index).getQuantity();
            cartArr.get(index).setQuantity(currentQuantity + quantity);
        }
        else {
            CartItem c = new CartItem(p, quantity);
            cartArr.add(c);
        }
    }
    
    /**
     * Removes a product from the cart
     * @param i index of product in cartArr
     */
    public void removeFromCart(int i){
        cartArr.remove(i);
    }
    
    /**
     * Updates quantity of a product thats in the cart
     * @param i index of product in cartArr
     * @param quantity updated quantity of product
     */
    public void updateQuantity(int i, int quantity){
        cartArr.get(i).setQuantity(quantity);
    }
    
    /**
     * Checks if product exists already in cart
     * @param productID productID of product
     * @return returns true if product exists
     */
    public boolean productExists(int productID){
        boolean exists = false;
        for (int i = 0; i < cartArr.size(); i++){
            if (productID == cartArr.get(i).getProduct().getProductID()){
                exists = true;
            }
        }
        return exists;
    }
    
    /**
     * Gets the index of product in cartArr
     * @param productID productID of product
     * @return index of product in cartArr
     */
    public int getProductIndex(int productID){
        int index = 0;
        for (int i = 0; i < cartArr.size(); i++){
            if (productID == cartArr.get(i).getProduct().getProductID()){
                index = i;
            }
        }
        return index;
    }
    
    /**
     * Gets total sales amount of all products in cart
     * @return total sales
     */
    public double getSalesTotal(){
        double total = 0;
        int quantity;
        double price;
        double totalPrice;
        for (int i = 0; i < cartArr.size(); i++){
            quantity = cartArr.get(i).getQuantity();
            price = cartArr.get(i).getProduct().getPrice();
            totalPrice = price * quantity;
            total = total + totalPrice;
        }
        return total;
    }
    
    /**
     * Gets total sales amount of all products in cart
     * @return total costs
     */
    public double getCostsTotal(){
        double total = 0;
        int quantity;
        double cost;
        double totalCosts;
        for (int i = 0; i < cartArr.size(); i++){
            quantity = cartArr.get(i).getQuantity();
            cost = cartArr.get(i).getProduct().getCost();
            totalCosts = cost * quantity;
            total = total + totalCosts;
        }
        return total;
    }
    
}
