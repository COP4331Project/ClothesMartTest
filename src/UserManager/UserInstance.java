/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManager;

/**
 *
 * @author Tom
 */
public class UserInstance {
    private User customer;
    private static UserInstance instance = new UserInstance();
    
    
    public void setCustomer(User c) {
        this.customer = c;
    }
    
    public User getCustomer(){
        return customer;
    }
    
    public static UserInstance getInstance() {
        return instance;
    }
}
