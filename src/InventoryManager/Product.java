/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryManager;

import java.io.Serializable;

/**
 *
 * @author Tom
 */
public class Product implements Serializable{
    private int productID;
    private String name;
    private double price;
    private double cost;
    private String imgLocation;
    private String category;
    private int quantity;
    private String info;

    public Product(int productID, String name, double price, double cost, 
            String imgLocation, String category, int quantity, String info) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.imgLocation = imgLocation;
        this.category = category;
        this.quantity = quantity;
        this.info = info;
    }
    
    

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getImgLocation() {
        return imgLocation;
    }

    public void setImgLocation(String imgLocation) {
        this.imgLocation = imgLocation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
    
    
}
