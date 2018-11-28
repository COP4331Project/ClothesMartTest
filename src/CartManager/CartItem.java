/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartManager;

import InventoryManager.Product;
import java.io.Serializable;

/**
 * Class is used for storing a product and quantity of product in cartArr
 * @author Tom
 */
public class CartItem implements Serializable {
    private Product product;
    private int Quantity;

    /**
     * Create cart item
     * @param product product added to cart
     * @param Quantity quantity of product added to cart
     */
    public CartItem(Product product, int Quantity) {
        this.product = product;
        this.Quantity = Quantity;
    }

    /**
     * Get product
     * @return product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Get quantity of product
     * @return product quantity
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * Update quantity of product
     * @param Quantity new quantity
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    
}
