
package CartManager;

/**
 * Cart Instance class creates an instance of a CartObject for global use
 * @author Tom Loziier
 */
public class CartInstance {
    
    // create instance
    private static CartInstance instance = new CartInstance();
    private Cart cart;

    /**
     * Private constructor controls access
     */
    private CartInstance() {
        cart = new Cart();
    }
    
    /**
     * Method gets cart object
     * @return cart object
     */
    public Cart getCart(){
        return cart;
    }
    
    /**
     * Gets instance
     * @return instance
     */
    public static CartInstance getInstance() {
        return instance;
    }
}
