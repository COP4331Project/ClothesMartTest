/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManager;

import java.io.Serializable;

/**
 *
 * @author Tom
 */
public class User implements Serializable{
    private int custID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private int cartID;
    private boolean admin;

    public User(int custID, String username, String password, 
            String firstName, String lastName, String address, String city, 
            String state, String zip, int cartID, boolean admin) {
        this.custID = custID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.cartID = cartID;
        this.admin = admin;
    }

    public User(String username, String password, String firstName, String lastName, boolean admin) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
    }

    
    

    public int getCustID() {
        return custID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public int getCartID() {
        return cartID;
    }

    public boolean isAdmin() {
        return admin;
    }
    
    
    
}
